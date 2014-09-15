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

public class AuthenticationRefusedExceptionTest {
	
	@Test
	public void testConstructor() throws Exception {
		AuthenticationRefusedException e = new AuthenticationRefusedException();
		assertNull(e.getMessage());
		assertNull(e.getCause());
	}
	
	@Test
	public void testConstructor2() throws Exception {
		String msg = "message";
		AuthenticationRefusedException e = new AuthenticationRefusedException(msg);
		assertEquals(msg, e.getMessage());
		assertNull(e.getCause());
	}
	
	@Test
	public void testConstructor3() throws Exception {
		Throwable t = new Throwable();
		AuthenticationRefusedException e = new AuthenticationRefusedException(t);
		assertEquals("java.lang.Throwable", e.getMessage());
		assertEquals(t, e.getCause());
	}
	
	@Test
	public void testConstructor4() throws Exception {
		String msg = "message";
		Throwable t = new Throwable();
		AuthenticationRefusedException e = new AuthenticationRefusedException(msg, t);
		assertEquals(msg, e.getMessage());
		assertEquals(t, e.getCause());
	}

}
