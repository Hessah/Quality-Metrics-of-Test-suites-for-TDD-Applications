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

import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jst.server.core.IWebModule;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.Server;
import org.eclipse.wst.server.core.model.IURLProvider;
import org.eclipse.wst.server.core.model.LaunchableAdapterDelegate;
import org.eclipse.wst.server.core.util.HttpLaunchable;
import org.eclipse.wst.server.core.util.WebResource;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;

public class SapNWLaunchableAdapterDelegate extends LaunchableAdapterDelegate {

	@Override
	public Object getLaunchable(IServer server, IModuleArtifact moduleArtifact)
			throws CoreException {
		if (server.getAdapter(SapNWServer.class) == null)
			return null;
		if (!(moduleArtifact instanceof WebResource))
			return null;
		if (moduleArtifact.getModule().loadAdapter(IWebModule.class, null) == null)
			return null;
		
		HttpLaunchable launchable = null;
		try {
			URL url = ((IURLProvider) server.loadAdapter(IURLProvider.class, null)).getModuleRootURL(moduleArtifact.getModule());
			
			if (moduleArtifact instanceof WebResource) {
				WebResource resource = (WebResource) moduleArtifact;
				String path = resource.getPath().toString();
				// append path to the root url
				url = new URL(url.getProtocol(), url.getHost(), url.getPort(), url.getFile() + path);
			}
			launchable = new HttpLaunchable(url);
		} catch (Exception e) {
			SapNWPlugin.logError("Error getting URL for " + moduleArtifact, e);
		}
		
		// ensure that the debug launch configuration is connected when Debug on Server is called
		if (launchable != null && 
				server.getServerState() == IServer.STATE_STARTED &&
				server.getMode() == ILaunchManager.DEBUG_MODE &&
				!((Server) server).shouldPublish()) {
			SapNWServerBehavior serverControl = (SapNWServerBehavior) server.loadAdapter(SapNWServerBehavior.class, null);
			serverControl.launchRemoteDebugging();
		}
		
		return launchable;
	}

}
