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

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class UndeployCommand extends AppCommand {

	@Override
	public String execute() throws Exception {
		try {
			Server server = ServerFactory.createServer(PortaMon.getServerProps());
			server.getDeployManager().setAuthenticationCallback(PortaMon.getDeployManagerAuthenticationCallback());
			
			String vendor = readAppVendor();
			String name = readAppName();
			Application app = findApp(server, vendor, name);
			
			if (app == null) {
				return "No such application. ";
			} else {
				DeployResult result = server.getDeployManager().undeploy(new Application[] { app });
				switch (result.getStatus()) {
					case SUCCESS:
						return "Undeploy finished successfully: " + result.getStatusDetails();
						
					case ERROR:
						return "Undeploy finished with errors: " + result.getStatusDetails();
						
					case WARNING: 
						return "Undeploy finished with warnings: " + result.getStatusDetails();
						
					default: 
						throw new IllegalStateException();
				}
			}
		} catch (NotAuthorizedException e) {
			return "Authorization failed: " + e.getMessage();
		} catch (CoreException e) {
			return "Undeploy failed: " + e.getMessage();
		} 
	}

}
