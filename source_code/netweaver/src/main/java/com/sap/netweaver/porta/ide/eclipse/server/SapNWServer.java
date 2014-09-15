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
package com.sap.netweaver.porta.ide.eclipse.server;

import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jst.server.core.IEnterpriseApplication;
import org.eclipse.jst.server.core.IWebModule;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleType;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.ServerUtil;
import org.eclipse.wst.server.core.model.IURLProvider;
import org.eclipse.wst.server.core.model.ServerDelegate;
import org.eclipse.wst.server.core.util.IStaticWeb;

import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.control.AuthCallback;
import com.sap.netweaver.porta.ide.eclipse.util.FacetUtil;
import com.sap.netweaver.porta.ide.eclipse.util.SapNWServerUtil;

public class SapNWServer extends ServerDelegate implements IURLProvider {

	public static final String PROPERTY_INSTANCE_NUMBER = "instance_nr";
	
	public static final boolean MOCK = false;
	
	private final boolean mock;
	
	public SapNWServer() {
		this(MOCK);
	}
	
	public SapNWServer(boolean mock) {
		this.mock = mock;
	}
	
	@Override
	protected void initialize() {
		// schedule the refresh state job to ensure that the refresh mechanism is activated
		SapNWPlugin.refreshStateJob.schedule();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void setDefaults(IProgressMonitor monitor) {
		super.setDefaults(monitor);
		// disable auto-publishing
		setAttribute("auto-publish-setting", 1);
	}

	public URL getModuleRootURL(IModule module) {
		return getModuleRootURL(module, getServer().getHost(), getPort());
	}
	
	URL getModuleRootURL(IModule module, String host, int port) {
		try {
			String contextRoot = "";
			if (module != null) {
				// retrieve the context root
				contextRoot = "/";
				String type = module.getModuleType().getId();
				if (FacetUtil.STATIC_WEB.equals(type)) {
					IStaticWeb staticWeb = (IStaticWeb) module.loadAdapter(IStaticWeb.class, null);
					contextRoot += staticWeb.getContextRoot();
				} else if (FacetUtil.DYNAMIC_WEB.equals(type)) {
					IWebModule webModule = (IWebModule) module.loadAdapter(IWebModule.class, null);
					contextRoot += webModule.getContextRoot();
				}
			}
			
			if (port == 80) {
				return new URL("http", host, contextRoot);
			} else {
				return new URL("http", host, port, contextRoot);
			}
		} catch (Exception e) {
			SapNWPlugin.logError("Could not get root URL", e);
			return null;
		}
	}
	
	public IModule[] getChildModules(IModule[] module) {
		if (module[0] != null && module.length == 1) {
			IModuleType moduleType = module[0].getModuleType();
			if (moduleType != null 
					&& FacetUtil.ENTERPRISE_APPLICATION.equals(moduleType.getId())) {
				IEnterpriseApplication enterpriseApplication = (IEnterpriseApplication) module[0]
						.loadAdapter(IEnterpriseApplication.class, null);
				if (enterpriseApplication != null) {
					IModule[] earModules = enterpriseApplication.getModules();
					if (earModules != null) {
						return earModules;
					}
				}
			} else if (moduleType != null
					&& FacetUtil.DYNAMIC_WEB.equals(moduleType.getId())) {
				IWebModule webModule = (IWebModule) module[0].loadAdapter(IWebModule.class, null);
				if (webModule != null) {
					return webModule.getModules();
				}
			}
		}
		return new IModule[0];
	}

	@Override
	public IModule[] getRootModules(IModule module) throws CoreException {
		IModule[] ears = ServerUtil.getModules(FacetUtil.ENTERPRISE_APPLICATION);
		return getRootModules(module, ears);
	}

	IModule[] getRootModules(IModule module, IModule[] ears) {
		ArrayList<IModule> list = new ArrayList<IModule>();
		
		// add if module is EAR
		if (SapNWServerUtil.isEAR(module)) {
			list.add(module);
		}
		
		// add the EARs that contained the module
		for (IModule ear : ears) {
			IEnterpriseApplication earApp = (IEnterpriseApplication) ear.loadAdapter(IEnterpriseApplication.class, null);
			IModule[] children = earApp.getModules();
			for (IModule child : children) {
				if (child.equals(module))
					list.add(ear);
			}
		}
		
		// add if module is WAR - standalone WARs are supported 
		if (SapNWServerUtil.isWAR(module)) {
			list.add(module);
		}
		
		return list.toArray(new IModule[list.size()]);
	}

	public IStatus canModifyModules(IModule[] add, IModule[] remove) {
		boolean invalidModule = false;
		
		if (add != null) {
			invalidModule = !SapNWServerUtil.areAllDeployableModules(add);
		}
		
		if (!invalidModule && remove != null) {
			invalidModule = !SapNWServerUtil.areAllDeployableModules(remove);
		}

		if (invalidModule) {
			return new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, 0, "Only EARs and standalone WARs can be added/removed", null);
		}
		
		return Status.OK_STATUS;
	}

	public ServerPort[] getServerPorts() {
		int port = getPort();
		ServerPort[] ports = { new ServerPort("http", "HTTP Port", port, "http") };
		return ports;
	}

  	public Server getServerCore() throws com.sap.netweaver.porta.core.CoreException {
		return getServerCore(getServer().getHost(), getInstanceNumber());
  	}
  	
  	Server getServerCore(String host, int instance) throws com.sap.netweaver.porta.core.CoreException {
		Properties p = new Properties();
		if (mock) {
			p.setProperty(ServerFactory.SERVER_TYPE, "MOCK");
		} else {
			p.setProperty(ServerFactory.SERVER_TYPE, "NW7");
		}
		p.setProperty("host", host);
		p.setProperty("instance.number", Integer.toString(instance));

		Server serverCore = ServerFactory.createServer(p);
		// TODO avoid the creation of new AuthCallback every time
		serverCore.getLifecycleManager().setAuthenticationCallback(new AuthCallback(true, getLMDefaultUser(serverCore)));
		serverCore.getDeployManager().setAuthenticationCallback(new AuthCallback(false, getDMDefaultUser(serverCore)));
		return serverCore;
	}
  	
  	public int getInstanceNumber() {
  		return getAttribute(PROPERTY_INSTANCE_NUMBER, 0);
  	}
  	
  	public void setInstanceNumber(int instNr) {
  		setAttribute(PROPERTY_INSTANCE_NUMBER, instNr);
  	}

	public void modifyModules(IModule[] add, IModule[] remove, IProgressMonitor monitor) throws CoreException {
		// TODO
		// do nothing
	}

	private int getPort() {
		try {
			return getServerCore().getHttpAccessPoint().getPort();
		} catch (Exception e) {
			SapNWPlugin.logWarning(String.format("Could not get http port for server [%s:%d]. ", getServer().getHost(), getInstanceNumber()), e);
		}
		try {
			return 50000 + getInstanceNumber() * 100;
		} catch (NumberFormatException e) {
			return 50000;
		}
	}
	
	private String getLMDefaultUser(Server serverCore) {
		try {
			return serverCore.getSystemName().toLowerCase() + "adm";
		} catch (com.sap.netweaver.porta.core.CoreException e) {
			SapNWPlugin.logWarning(String.format("Cannot retrieve system name for server [%s:%d]. Will not suggest default user name. ", getServer().getHost(), getInstanceNumber()), e);
			return "";
		}
	}
	
	private String getDMDefaultUser(Server serverCore) {
		return "Administrator";
	}
	
}
