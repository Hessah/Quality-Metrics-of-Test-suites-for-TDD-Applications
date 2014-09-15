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

public class ProxyExceptionTest {
	
	@Test
	public void testConstructor3() throws Exception {
		String host = "my-host";
		ProxyException e = new ProxyException("my-host");
		assertNotNull(e.getMessage());
		assertNull(e.getCause());
		assertEquals(host, e.getHost());
	}

}
