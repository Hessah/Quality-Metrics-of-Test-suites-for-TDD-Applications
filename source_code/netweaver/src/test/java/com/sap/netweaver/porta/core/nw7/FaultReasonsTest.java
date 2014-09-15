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
package com.sap.netweaver.porta.core.nw7;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultReasonsTest {
	
	@Test
	public void testUnauthorized() throws Exception {
		String msg = "(401)Unauthorized";
		assertEquals(msg, FaultReasons.FAULT_UNAUTHORIZED.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_UNAUTHORIZED.toString());
	}
	
	@Test
	public void testNotFound() throws Exception {
		String msg = "(404)Not Found";
		assertEquals(msg, FaultReasons.FAULT_NOT_FOUND.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_NOT_FOUND.toString());
	}
	
	@Test
	public void testInvalidCredentials() throws Exception {
		String msg = "Invalid Credentials";
		assertEquals(msg, FaultReasons.FAULT_INVALID_CREDENTIALS.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_INVALID_CREDENTIALS.toString());
	}
	
	@Test
	public void testPermissionsDenied() throws Exception {
		String msg = "Permission denied";
		assertEquals(msg, FaultReasons.FAULT_PERMISSION_DENIED.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_PERMISSION_DENIED.toString());
	}
	
	@Test
	public void testInstanceAlreadyStarted() throws Exception {
		String msg = "Instance already started";
		assertEquals(msg, FaultReasons.FAULT_INSTANCE_ALREADY_STARTED.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_INSTANCE_ALREADY_STARTED.toString());
	}
	
	@Test
	public void testShmNotFound() throws Exception {
		String msg = "JsfOpenShm failed: object not found";
		assertEquals(msg, FaultReasons.FAULT_SHM_NOT_FOUND.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_SHM_NOT_FOUND.toString());
	}
	
	@Test
	public void testEndDebugSessionWrongState() throws Exception {
		String msg = "JsfEndDebugSession failed: wrong state for operation";
		assertEquals(msg, FaultReasons.FAULT_END_DEBUG_SESSION_WRONG_STATE.getFaultReason());
		assertEquals(msg, FaultReasons.FAULT_END_DEBUG_SESSION_WRONG_STATE.toString());
	}

}
