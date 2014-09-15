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
package com.sap.netweaver.porta.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationReasonTest {
	
	@Test
	public void testAuthorizationRequired() throws Exception {
		assertEquals("AUTHORIZATION_REQUIRED", AuthenticationReason.AUTHORIZATION_REQUIRED.name());
	}
	
	@Test
	public void testInvalidCredentials() throws Exception {
		assertEquals("INVALID_CREDENTIALS", AuthenticationReason.INVALID_CREDENTIALS.name());
	}
	
	@Test
	public void testPermissionDenied() throws Exception {
		assertEquals("PERMISSION_DENIED", AuthenticationReason.PERMISSION_DENIED.name());
	}

}
