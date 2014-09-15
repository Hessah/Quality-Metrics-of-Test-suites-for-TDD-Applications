/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev (SAP AG) - initial API and implementation
 *******************************************************************************/
package com.sap.netweaver.porta.ide.eclipse.server.control;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDisconnect;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.Server;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.DebugSessionInfo;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.DeployResultStatus;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.ProxyException;
import com.sap.netweaver.porta.core.ServerState;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;
import com.sap.netweaver.porta.ide.eclipse.util.ProxyUtilCaller;

public class SapNWServerBehavior extends ServerBehaviourDelegate {
	
	private DebugSessionInfo debugSessionInfo;
	private IDisconnect debugLaunch;

	@Override
	protected void initialize(IProgressMonitor monitor) {
		super.initialize(monitor);
		
		// force refresh of the server state
		try {
			refreshServerState();
		} catch (Exception e) {
			SapNWPlugin.logError("Error on refreshing server state", e); 
		}
	}

	@Override
	public void stop(boolean force) {
		try {
			disconnectDebugSession();
			getLM().stop();
			setServerState(IServer.STATE_STOPPING);
		} catch (NotAuthorizedException e) {
			SapNWPlugin.errorDialog("Not authorized", "You do not have sufficient rights to manage server's lifecycle. ");
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.logError("Stop operation for SAP server failed.", e);
		}
	}

	@Override
	public void restart(String launchMode) throws CoreException {
		try {
			if (getServer().getMode().equals(launchMode)) {
				// regular restart is triggered
				restartServer(launchMode);
			} else if (ILaunchManager.DEBUG_MODE.equals(launchMode)) {
				// switch debug mode on
				enableDebugging();
			} else if (ILaunchManager.RUN_MODE.equals(launchMode)) {
				// switch debug mode off
				disableDebugging();
			}
		} catch (NotAuthorizedException e) {
			SapNWPlugin.errorDialog("Not authorized", "You do not have sufficient rights to manage server's lifecycle. ");
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.logError("Server lifecycle operation for the SAP NetWeaver server failed.", e);
		}

	}

//	@Override - not available in Europa
	public IStatus canStart(String launchMode) {
		if (getServer().getServerState() == IServer.STATE_UNKNOWN) {
			return new Status(Status.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Server is in unknown state. Lifecycle actions are not available. ", null);
		}
		
		return Status.OK_STATUS;
	}

//	@Override - not available in Europa
	public IStatus canStop() {
		if (getServer().getServerState() == IServer.STATE_UNKNOWN) {
			return new Status(Status.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Server is in unknown state. Lifecycle actions are not available. ", null);
		}
		
		if (getServer().getServerState() == IServer.STATE_STARTING) {
			return new Status(Status.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Cannot stop the starting server. Wait the start to complete first. ", null);
		}
		
		return Status.OK_STATUS;
	}

//	@Override - not available in Europa
	public IStatus canRestart(String mode) {
		if (getServer().getServerState() == IServer.STATE_UNKNOWN) {
			return new Status(Status.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Server is in unknown state. Lifecycle actions are not available. ", null);
		}
		
		return Status.OK_STATUS;
	}

//	@Override - not available in Europa
	public IStatus canPublish() {
		if (getServer().getServerState() == IServer.STATE_UNKNOWN) {
			return new Status(Status.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Server is in unknown state. Publish actions are not available. ", null);
		}
		
		return Status.OK_STATUS;
	}

	private int getServerState() {
		try {
			ServerState state = getLM().getState();
			if (state == ServerState.RUNNING){
				return IServer.STATE_STARTED; 
			} else if(state == ServerState.STARTING){
				return IServer.STATE_STARTING;
			} else if(state == ServerState.STOPPING ){
				return IServer.STATE_STOPPING;
			} else if(state == ServerState.STOPPED ){
				return IServer.STATE_STOPPED;
			}
		} catch (NotAuthorizedException e) {
			// should not be possible to happen
		} catch (ProxyException e) {
			ProxyUtilCaller.handleProxyException(e);
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.logError("Cannot get server state. ", e);
		}
		return IServer.STATE_UNKNOWN;
	}


	private LifecycleManager getLM() throws com.sap.netweaver.porta.core.CoreException {
		return ((SapNWServer)getServer().loadAdapter(SapNWServer.class, null)).getServerCore().getLifecycleManager();
	}
	
	private DeployManager getDM() throws com.sap.netweaver.porta.core.CoreException {
		return ((SapNWServer)getServer().loadAdapter(SapNWServer.class, null)).getServerCore().getDeployManager();
	}
	
	public void refreshServerState() throws NotAuthorizedException, CoreException, com.sap.netweaver.porta.core.CoreException {
		int currentState = getServerState();
		int latestState = getServer().getServerState();
		
		if (latestState == IServer.STATE_STARTING && 
				currentState == IServer.STATE_STOPPED) {
			// the server has not changed to starting state yet
			// don't change the state - remain in starting
			return;
		}
		
		if (latestState == IServer.STATE_STOPPING && 
				currentState == IServer.STATE_STARTED) {
			// the server has not changed to stopping state yet
			// don't change the state - remain in stopping
			return;
		}
		
		if (latestState == IServer.STATE_STARTING && 
				currentState == IServer.STATE_STARTED && 
				ILaunchManager.DEBUG_MODE.equals(getServer().getMode()) && 
				debugSessionInfo == null) {
			// the server has been started in debug mode and it has just finished starting
			// switch the debug mode on
			enableDebugging();
		}
		
		setServerState(currentState);
	}

	protected void setupLaunch(ILaunch launch, String launchMode, IProgressMonitor monitor) throws CoreException {
		try {
			// check if the server is already started
			if (getServerState() == IServer.STATE_UNKNOWN || getServerState() == IServer.STATE_STOPPED) {
				// trigger start
				getLM().start();
				setServerState(IServer.STATE_STARTING);
				setMode(launchMode);
			}
		} catch (NotAuthorizedException e) {
			throw new CoreException(
					new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "You do not have sufficient rights to manage server's lifecycle.", e));
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.errorDialog("Starting server failed", "Cannot start the server. ", e);
		}
	}

	public void publish(File archiveFile) throws com.sap.netweaver.porta.core.CoreException {
		DeployResult result = getDM().deploy(new File[] { archiveFile });
		if (result.getStatus() != DeployResultStatus.SUCCESS){
			throw new PublishException(result);
		}
	}
	
	public void unpublish(String appName) throws com.sap.netweaver.porta.core.CoreException {
		Application[] apps = getDM().getApplications();
		for (Application app : apps) {
			if (app.getName().equals(appName)) {
				// TODO process deploy result
				getDM().undeploy(new Application[] { app });
				break;
			}
		}
	}
	
	public Application[] getPublishedApplications() throws com.sap.netweaver.porta.core.CoreException {
		return getDM().getApplications();
	}

	@Override
	protected void publishServer(int kind, IProgressMonitor monitor)
			throws CoreException {
		setServerPublishState(IServer.PUBLISH_STATE_NONE);
	}
	
	private void enableDebugging() throws CoreException, com.sap.netweaver.porta.core.CoreException {
		debugSessionInfo = getLM().enableDebugging();
		if (debugSessionInfo.getPort() == 0) {
			// there is a problem switching to debug mode without restarting
			SapNWPlugin.logWarning("Cannot not switch server " + getServer().getName() + " to debug mode without restarting. Restarting the server. ", null);
			// restart the server
			restartServer(ILaunchManager.DEBUG_MODE);
		} else {
			setMode(ILaunchManager.DEBUG_MODE);
			launchRemoteDebugging();
		}
	}
	
	private void disableDebugging() throws com.sap.netweaver.porta.core.CoreException, DebugException {
		disconnectDebugSession();
		if (debugSessionInfo != null) {
			String key = debugSessionInfo.getKey();
			getLM().disableDebugging(key);
		}
	}
	
	private void disconnectDebugSession() {
		try {
			if (debugLaunch != null) {
				debugLaunch.disconnect();
			}
		} catch (DebugException e) {
			SapNWPlugin.logError("Error on disconnecting debug session", e);
		} finally {
			debugSessionInfo = null;
			debugLaunch = null;
			setMode(ILaunchManager.RUN_MODE);
		}
	}

	void launchRemoteDebugging() throws CoreException {
		if (debugLaunch != null && !debugLaunch.isDisconnected())
			return;
		
		ILaunchConfiguration launchConfiguration = getExistingRemoteConfiguration();
		if (launchConfiguration == null) {
			launchConfiguration = createNewRemoteConfiguration();
		}
		debugLaunch = (IDisconnect) launchConfiguration.launch(ILaunchManager.DEBUG_MODE, null);
	}

	private ILaunchConfiguration getExistingRemoteConfiguration() throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType("com.sap.netweaver.server.remote.debugging.launchConfigurationType");
		ILaunchConfiguration[] launchConfigurations = launchManager.getLaunchConfigurations(launchConfigurationType);
		for (ILaunchConfiguration lc : launchConfigurations) {
			Map<String, String> connectMap = lc.getAttribute(IJavaLaunchConfigurationConstants.ATTR_CONNECT_MAP, Collections.EMPTY_MAP);
			String serverId = lc.getAttribute(Server.ATTR_SERVER_ID, "");
			if (getServer().getId().equals(serverId) && 
					getServer().getHost().equals(connectMap.get("hostname")) && 
					Integer.toString(debugSessionInfo.getPort()).equals(connectMap.get("port"))) {
				return lc;
			}
		}
		return null;
	}

	private ILaunchConfiguration createNewRemoteConfiguration() throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType("com.sap.netweaver.server.remote.debugging.launchConfigurationType");
		String launchName = getServer().getName() + " Debug";
		launchName = launchManager.generateUniqueLaunchConfigurationNameFrom(launchName);
		ILaunchConfigurationWorkingCopy wc = launchConfigurationType.newInstance(null, launchName);
		Map<String, String> connectMap = new HashMap<String, String>();
		connectMap.put("hostname", getServer().getHost());
		connectMap.put("port", Integer.toString(debugSessionInfo.getPort()));
		wc.setAttribute(Server.ATTR_SERVER_ID, getServer().getId());
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_CONNECT_MAP, connectMap);
		return wc.doSave();
	}

	private void restartServer(String launchMode) throws com.sap.netweaver.porta.core.CoreException {
		disconnectDebugSession();
		getLM().restart();
		setServerState(IServer.STATE_STOPPING);
		setMode(launchMode);
	}
}
