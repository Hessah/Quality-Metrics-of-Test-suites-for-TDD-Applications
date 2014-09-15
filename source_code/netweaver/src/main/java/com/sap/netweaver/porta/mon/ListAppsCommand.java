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
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class ListAppsCommand extends Command {
	
	@Override
	public String execute() throws Exception {
		try {
			Server server = ServerFactory.createServer(PortaMon.getServerProps());
			server.getDeployManager().setAuthenticationCallback(PortaMon.getDeployManagerAuthenticationCallback());
			Application[] apps = server.getDeployManager().getApplications();
			
			StringBuilder result = new StringBuilder();
			result.append("List of deployed applications (");
			result.append(apps.length);
			result.append("): ");
			result.append(LN);
			result.append(LN);
			result.append("ID | NAME | VENDOR | VERSION | LOCATION | STATUS");
			result.append(LN);
			
			for (Application a : apps) {
				result.append(a.getId());
				result.append(" | ");
				result.append(a.getName());
				result.append(" | "); 
				result.append(a.getVendor());
				result.append(" | ");
				result.append(a.getVersion());
				result.append(" | "); 
				result.append(a.getLocation());
				result.append(" | "); 
				result.append(a.getStatus());
				result.append(LN);
			}
			
			return result.toString();
		} catch (NotAuthorizedException e) {
			return "Authorization failed: " + e.getMessage();
		} catch (CoreException e) {
			return "Cannot get deployed applications: " + e.getMessage();
		} 
	}

}
