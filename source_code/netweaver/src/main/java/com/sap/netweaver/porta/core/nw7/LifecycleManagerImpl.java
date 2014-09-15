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
package com.sap.netweaver.porta.core.nw7;

import static com.sap.netweaver.porta.core.nw7.FaultReasons.*;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import javax.xml.rpc.Stub;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.AxisFault;

import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption;
import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DebugSessionInfo;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.ProxyException;
import com.sap.netweaver.porta.core.ServerState;

public class LifecycleManagerImpl extends CoreModuleImpl implements LifecycleManager {
	
	private abstract class LifecycleOperationContext implements OperationContext {

		public AuthenticationCallback getAuthenticationCallback() {
			return callback;
		}

		public void setCredentials(String user, String password) {
			Stub stub = (Stub) control;
			stub._setProperty(Stub.USERNAME_PROPERTY, user);
			stub._setProperty(Stub.PASSWORD_PROPERTY, password);
		}

		public Object getResult() {
			return null;
		}

		public boolean handleFault(AxisFault fault) throws CoreException {
			throw new CoreException(fault);
		}
		
	}

	private final LMUtils utils;
	private SAPControlPortType control;
	
	public LifecycleManagerImpl(String host, int instNr) {
		this(host, instNr, new LMUtilsImpl());
	}
	
	LifecycleManagerImpl(String host, int instNr, LMUtils utils) {
		super(host, instNr);
		this.utils = utils;
		// to be initialized on first usage
		this.control = null;
	}
	
	protected void initialize() throws CoreException {
		try {
			// establish ws proxy to the SAPControl of the first J2EE instance
			URL url = utils.getSAPControlWSUrlByInstance(host, instNr);
			SAPControlPortType initial = utils.getSAPControlWSProxy(url);
			try {
				control = utils.getSAPControlWSProxyToFirstJ2EEInstance(initial);
			} catch (AxisFault fault) {
				// check for problems with the proxy settings
				String host = url.getHost();
				try {
					// check if the host can be resolved
					InetAddress.getByName(host);
					// the host can be resolved. 
					// there is a problem with the proxy settings - the host should be added to the nonProxyHosts list
					throw new ProxyException(host);
				} catch (UnknownHostException e) {
					// the host cannot be resolved - there is no problem with proxy settings
					throw new CoreException("There is a network problem in server's landscape. Java instance was found on host " + e.getMessage() + ", but it cannot be resolved. Try configuring the server direcly to the Java instance. ", e);
				}
			}
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(e);
		}
		
		if (control == null)
			throw new IllegalStateException("cannot determine the J2EE instance");
	}
	
	protected boolean initialized() {
		return control != null; 
	}
	
	public void disableDebugging(final String key) throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		new Operation(new LifecycleOperationContext() {
			public void executeOperation() throws RemoteException {
				control.j2EEDisableDbgSession(key);
			}
			
			public boolean handleFault(AxisFault fault) throws CoreException {
				if (FAULT_END_DEBUG_SESSION_WRONG_STATE.getFaultReason().equals(fault.getFaultReason())) {
					// this is should happen because of invalid or outdated key
					return false;
				} 
				return super.handleFault(fault);
			}
		}).execute();
	}

	public DebugSessionInfo enableDebugging() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		final StringHolder keyHolder = new StringHolder();
		final IntHolder portHolder = new IntHolder();
		
		new Operation(new LifecycleOperationContext() {
			public void executeOperation() throws RemoteException {
				control.j2EEEnableDbgSession("", "", "Eclipse", keyHolder, portHolder);
			}
		}).execute();
		
		return new DebugSessionInfo(keyHolder.value, portHolder.value);
	}
	
	public ServerState getState() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		Object result = new Operation(new LifecycleOperationContext() {
			
			private ServerState result;

			public void executeOperation() throws RemoteException {
				J2EEProcess[] processes = control.j2EEGetProcessList();
				result = utils.determineServerState(processes);
			}

			public Object getResult() {
				return result;
			}

			public boolean handleFault(AxisFault fault) throws CoreException {
				if (FAULT_SHM_NOT_FOUND.getFaultReason().equals(fault.getFaultReason())) {
					// this happens when the instance is stopped - the
					// shared memory cannot be found to report any processes.
					result = ServerState.STOPPED;
					return false;
				} 
				return super.handleFault(fault);
			}

		}).execute();
		
		return (ServerState) result;
	}

	public void start() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		new Operation(new LifecycleOperationContext() {

			public void executeOperation() throws RemoteException {
				// TODO make timeout configurable
				control.startSystem(StartStopOption.value1, "1", 30*60);
			}

			public boolean handleFault(AxisFault fault) throws CoreException {
				if (FAULT_INSTANCE_ALREADY_STARTED.getFaultReason().equals(fault.getFaultReason())) {
					return false;
				} 
				return super.handleFault(fault);
			}

		}).execute();
	}

	public void stop() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		new Operation(new LifecycleOperationContext() {
			public void executeOperation() throws RemoteException {
				//TODO all instances or only j2ee ones
				//TODO clarify what prioritylevel param is
				//TODO make timeout configurable
				control.stopSystem(StartStopOption.value1, "1", 0, 30*60);
			}
		}).execute();
	}

	public void restart() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		new Operation(new LifecycleOperationContext() {

			public void executeOperation() throws RemoteException {
				control.restartSystem(StartStopOption.value5, "1", 30*60, 0);
			}

			public boolean handleFault(AxisFault fault) throws CoreException {
				if (FAULT_INSTANCE_ALREADY_STARTED.getFaultReason().equals(fault.getFaultReason())) {
					return false;
				} 
				return super.handleFault(fault);
			}

		}).execute();
	}
	
}
