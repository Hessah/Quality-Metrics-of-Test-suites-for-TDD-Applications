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

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;

public class LifecycleManagerAuthenticationCallback implements
		AuthenticationCallback {

	public Credentials getCredentials(AuthenticationReason reason)
			throws CoreException, AuthenticationRefusedException {
		switch (reason) {
			case AUTHORIZATION_REQUIRED:
				System.out.println("User and password for the system are required.");
				break;
	
			case INVALID_CREDENTIALS:
				System.out.println("Invalid user and password. Try again.");
				break;
		}
		
		try {
			PortaMon.getOut().print("User: ");
			String user = PortaMon.getIn().readLine().trim();
			PortaMon.getOut().print("Pass: ");
			String pass = PortaMon.getIn().readLine();
			return new Credentials(user, pass);
		} catch (IOException e) {
			throw new CoreException(e);
		}
	}

}
