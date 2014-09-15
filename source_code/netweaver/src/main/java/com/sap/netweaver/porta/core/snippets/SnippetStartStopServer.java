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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;
import com.sap.netweaver.porta.core.ServerState;

public class SnippetStartStopServer {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty(ServerFactory.SERVER_TYPE, "NW7");
		props.setProperty("host", "localhost");
		props.setProperty("instance.number", "0");

		Server server = ServerFactory.createServer(props);
		LifecycleManager lm = server.getLifecycleManager();
		lm.setAuthenticationCallback(new AuthCallback());

		System.out.println("Starting the server...");
		lm.start();

		ServerState state = ServerState.UNKNOWN;
		while (state != ServerState.RUNNING) {
			state = lm.getState();
			System.out.println(state);
			Thread.sleep(5000);
		}

		System.out.println("Server started. ");
		System.out.println();
		System.out.println("Stopping the server...");

		lm.stop();

		while (state != ServerState.STOPPED) {
			state = lm.getState();
			System.out.println(state);
			Thread.sleep(5000);
		}

		System.out.println("Server stopped.");
	}

	private static class AuthCallback implements AuthenticationCallback {

		public Credentials getCredentials(AuthenticationReason reason) throws CoreException {
			switch (reason) {
				case AUTHORIZATION_REQUIRED:
					System.out.println("User and password have not been given yet. Please, give user and password.");
					break;

				case INVALID_CREDENTIALS:
					System.out.println("Invalid user and password. Try again.");
					break;
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				System.out.print("User: ");
				String user = in.readLine();
				System.out.print("Pass: ");
				String pass = in.readLine();
				return new Credentials(user, pass);
			} catch (IOException e) {
				throw new CoreException(e);
			}
		}
		
	}

}
