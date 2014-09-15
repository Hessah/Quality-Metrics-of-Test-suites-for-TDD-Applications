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

import java.io.File;
import java.io.IOException;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class DeployCommand extends Command {

	@Override
	public String execute() throws Exception {
		try {
			Server server = ServerFactory.createServer(PortaMon.getServerProps());
			server.getDeployManager().setAuthenticationCallback(PortaMon.getDeployManagerAuthenticationCallback());
			
			File file = readFile();
			
			DeployResult result = server.getDeployManager().deploy(new File[] { file });
			switch (result.getStatus()) {
				case SUCCESS:
					return "Deploy finished successfully: " + result.getStatusDetails();
					
				case ERROR:
					return "Deploy finished with errors: " + result.getStatusDetails();
					
				case WARNING: 
					return "Deploy finished with warnings: " + result.getStatusDetails();
					
				default: 
					throw new IllegalStateException();
			}
		} catch (NotAuthorizedException e) {
			return "Authorization failed: " + e.getMessage();
		} catch (CoreException e) {
			return "Deploy failed: " + e.getMessage();
		} 
	}

	private File readFile() throws IOException {
		PortaMon.getOut().print("File Path: ");
		return new File(PortaMon.getIn().readLine().trim());
	}

}
