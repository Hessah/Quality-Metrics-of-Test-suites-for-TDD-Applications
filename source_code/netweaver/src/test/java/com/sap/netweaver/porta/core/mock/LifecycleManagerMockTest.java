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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.ServerState;

public class LifecycleManagerMockTest {
	
	private LifecycleManagerMock lm;
	
	@Before
	public void createDeployManager() {
		lm = new LifecycleManagerMock();
		lm.setAuthenticationCallback(new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				return new Credentials(CoreModuleMock.USER, CoreModuleMock.PASS);
			}
		});
	}
	
	@Test
	public void testGetState() throws Exception {
		assertEquals(ServerState.STOPPED, lm.getState());
	}
	
	@Test
	public void testStopWithoutStart() throws Exception {
		assertEquals(ServerState.STOPPED, lm.getState());
		lm.stop();
		assertEquals(ServerState.STOPPED, lm.getState());
	}

}
