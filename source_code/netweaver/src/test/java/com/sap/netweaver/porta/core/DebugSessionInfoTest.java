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

public class DebugSessionInfoTest {
	
	private static final String KEY = "key";
	private static final int PORT = 1234;
	
	@Test
	public void testGetters() throws Exception {
		DebugSessionInfo info = new DebugSessionInfo(KEY, PORT);
		assertEquals(KEY, info.getKey());
		assertEquals(PORT, info.getPort());
	}

}
