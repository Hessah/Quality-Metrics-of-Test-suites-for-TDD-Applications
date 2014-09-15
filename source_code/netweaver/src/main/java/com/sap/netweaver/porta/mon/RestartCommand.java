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
package com.sap.netweaver.porta.mon;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class RestartCommand extends Command {

	@Override
	public String execute() {
		try {
			Server server = ServerFactory.createServer(PortaMon.getServerProps());
			server.getLifecycleManager().setAuthenticationCallback(PortaMon.getLifecycleManagerAuthenticationCallback());
			server.getLifecycleManager().restart();
			return "Server restart triggered successfully. ";
		} catch (NotAuthorizedException e) {
			return "Authorization failed: " + e.getMessage();
		} catch (CoreException e) {
			return "Server restart trigger failed: " + e.getMessage();
		} 
	}

}
