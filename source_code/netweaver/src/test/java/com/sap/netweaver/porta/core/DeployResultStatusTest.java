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

public class DeployResultStatusTest {
	
	@Test
	public void testUnknown() throws Exception {
		assertEquals(DeployResultStatus.UNKNOWN, DeployResultStatus.getByName("Unknown"));
		assertEquals("Unknown", DeployResultStatus.UNKNOWN.toString());
	}
	
	@Test
	public void testError() throws Exception {
		assertEquals(DeployResultStatus.ERROR, DeployResultStatus.getByName("Error"));
		assertEquals("Error", DeployResultStatus.ERROR.toString());
	}
	
	@Test
	public void testSuccess() throws Exception {
		assertEquals(DeployResultStatus.SUCCESS, DeployResultStatus.getByName("Success"));
		assertEquals("Success", DeployResultStatus.SUCCESS.toString());
	}
	
	@Test
	public void testWarning() throws Exception {
		assertEquals(DeployResultStatus.WARNING, DeployResultStatus.getByName("Warning"));
		assertEquals("Warning", DeployResultStatus.WARNING.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalid() throws Exception {
		DeployResultStatus.getByName("invalid");
	}

}
