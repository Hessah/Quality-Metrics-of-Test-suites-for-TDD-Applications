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

public class NoWSGateExceptionTest {
	
	@Test
	public void testGetEdnpoint() throws Exception {
		Throwable t = new Throwable();
		NoWSGateException e = new NoWSGateException(t, "endpoint");
		assertNotNull(e.getMessage());
		assertEquals(t, e.getCause());
		assertEquals("endpoint", e.getEndpoint());
	}

}
