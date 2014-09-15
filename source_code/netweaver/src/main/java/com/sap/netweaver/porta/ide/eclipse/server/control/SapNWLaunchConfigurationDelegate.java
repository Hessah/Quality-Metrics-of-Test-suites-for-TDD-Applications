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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerUtil;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;

public class SapNWLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	/**
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(ILaunchConfiguration,
	 *      String, ILaunch, IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		IServer server = ServerUtil.getServer(configuration);
		if (server == null) {
			// TODO better logging
			SapNWPlugin.logError("Server does not exist", null);
		}

		SapNWServerBehavior serverControl = (SapNWServerBehavior) server.loadAdapter(
				ServerBehaviourDelegate.class, monitor);
		
		serverControl.setupLaunch(launch, mode, monitor);
	}

}
