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
package com.sap.netweaver.porta.core.snippets;

import java.io.File;
import java.util.Properties;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class SnippetUseDeployManager implements AuthenticationCallback {
	
	private static final Credentials staticCredentials = new Credentials("<user>", "<pass>");
	private static final File[] staticFiles = new File[] {new File("D:\\firstcup.ear")};
	
	public Credentials getCredentials(AuthenticationReason reason)
			throws CoreException, AuthenticationRefusedException {
		Credentials result = null;
		if (reason.equals(AuthenticationReason.AUTHORIZATION_REQUIRED)) {
			System.out.println("Credentials passed.");
			result = staticCredentials;
		} else if (reason.equals(AuthenticationReason.INVALID_CREDENTIALS)) {
			// something wrong
			System.out.println("Invalid credentials, but credentials never passed!");
			result = staticCredentials;
		}
		return result;
	}

	private void useDeployManager() {
		try {
			Properties props = new Properties();
			props.setProperty(ServerFactory.SERVER_TYPE, "NW7");
			props.setProperty("host", "localhost");
			props.setProperty("instance.number", "0");
			Server server = ServerFactory.createServer(props);
			// get deploy manager and try to deploy
			DeployManager deployManager = server.getDeployManager();
			deployManager.setAuthenticationCallback(this);
			DeployResult deployResult = deployManager.deploy(staticFiles);
			System.out.println(deployResult.getStatusDetails());
		} catch (CoreException e) {
			System.out.println("Core exception!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SnippetUseDeployManager snippet = new SnippetUseDeployManager();
		snippet.useDeployManager();
	}

}
