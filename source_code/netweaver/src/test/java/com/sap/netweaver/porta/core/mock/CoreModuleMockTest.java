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

import org.junit.Before;
import org.junit.Test;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class CoreModuleMockTest {
	
	private CoreModuleMock cm;
	
	@Before
	public void createDeployManager() {
		cm = new CoreModuleMock();
	}
	
	@Test
	public void testCheckCredentials() throws Exception {
		cm.setAuthenticationCallback(new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				return new Credentials(CoreModuleMock.USER, CoreModuleMock.PASS);
			}
		});
		cm.checkCredentials();
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void testNoCallback() throws Exception {
		cm.checkCredentials();
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void testInvalidCredentials() throws Exception {
		cm.setAuthenticationCallback(new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				return new Credentials("invalid-user", "invalid-password");
			}
		});
		cm.checkCredentials();
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void testAuthenticationRefused() throws Exception {
		cm.setAuthenticationCallback(new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				throw new AuthenticationRefusedException();
			}
		});
		cm.checkCredentials();
	}

}
