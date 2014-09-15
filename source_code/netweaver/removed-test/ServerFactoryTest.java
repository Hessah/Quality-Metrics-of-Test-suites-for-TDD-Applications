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

import java.util.Properties;

import org.junit.Test;

import com.sap.netweaver.porta.core.TestServerFactory.TestServer;

public class ServerFactoryTest {
	
	@Test
	public void testConstructor() throws Exception {
		new ServerFactory();
	}

	@Test
	public void testCreateServer() throws Exception {		
		Properties p = new Properties();
		p.setProperty(ServerFactory.SERVER_TYPE, "TEST");
		Server s = ServerFactory.createServer(p);
		assertNotNull(s);
		assertTrue(s instanceof TestServer);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateServer_NullProperties() throws Exception {
		ServerFactory.createServer(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateServer_NoType() throws Exception {
		ServerFactory.createServer(new Properties());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateServer_InvalidType() throws Exception {
		Properties p = new Properties();
		p.setProperty(ServerFactory.SERVER_TYPE, "invalid");
		ServerFactory.createServer(p);
	}
	
}
