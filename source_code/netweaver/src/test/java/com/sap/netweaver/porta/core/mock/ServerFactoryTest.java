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

import static com.sap.netweaver.porta.core.ServerFactory.*;
import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

import com.sap.netweaver.porta.core.Server;

public class ServerFactoryTest {
	
	@Test
	public void testConstructor() throws Exception {
		new ServerFactory();
	}
	
	@Test
	public void testCreateServer() throws Exception {
		Properties p = new Properties();
		p.setProperty(SERVER_TYPE, "MOCK");
		Server s = ServerFactory.createServer(p);
		assertNotNull(s);
		assertTrue(s instanceof ServerMock);
	}

}
