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
package com.sap.netweaver.porta.core.mock;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.CoreModule;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class CoreModuleMock implements CoreModule {
	
	protected static final String USER = "Administrator";
	protected static final String PASS = "abcd1234";
	
	private AuthenticationCallback callback;
	private Credentials credentials;

	public void setAuthenticationCallback(AuthenticationCallback callback) {
		this.callback = callback;
	}
	
	protected void checkCredentials() throws NotAuthorizedException, CoreException {
		if (credentials == null) {
			getCredentials(AuthenticationReason.AUTHORIZATION_REQUIRED);
		}
		
		int repeats = 3;
		do {
			repeats--;
			if (!verifyCredentials()) {
				if (repeats == 0) {
					throw new NotAuthorizedException();
				} else {
					getCredentials(AuthenticationReason.INVALID_CREDENTIALS);
				}
			}
		} while (repeats > 0);
	}
	
	protected void getCredentials(AuthenticationReason reason) throws NotAuthorizedException, CoreException {
		if (callback == null) {
			throw new NotAuthorizedException();
		}
		try {
			credentials = callback.getCredentials(reason);
		} catch (AuthenticationRefusedException e) {
			throw new NotAuthorizedException(e);
		}
	}
	
	protected boolean verifyCredentials() {
		return USER.equals(credentials.getUser()) && PASS.equals(credentials.getPassword());
	}

}
