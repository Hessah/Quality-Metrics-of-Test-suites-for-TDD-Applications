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

import java.io.IOException;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class DisableDebuggingCommand extends Command {

	@Override
	public String execute() throws Exception {
		try {
			Server server = ServerFactory.createServer(PortaMon.getServerProps());
			server.getLifecycleManager().setAuthenticationCallback(PortaMon.getLifecycleManagerAuthenticationCallback());
			
			String key = readDebugKey();
			
			server.getLifecycleManager().disableDebugging(key);
			return "Debugging disabled successfully. ";
		} catch (NotAuthorizedException e) {
			return "Authorization failed: " + e.getMessage();
		} catch (CoreException e) {
			return "Disable debugging failed: " + e.getMessage();
		} 
	}

	private String readDebugKey() throws IOException {
		PortaMon.getOut().print("Debug Key: ");
		return PortaMon.getIn().readLine().trim();
	}

}
