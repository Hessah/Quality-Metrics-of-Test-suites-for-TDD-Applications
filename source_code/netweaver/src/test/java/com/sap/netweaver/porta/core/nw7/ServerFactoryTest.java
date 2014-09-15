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
		Properties p1 = new Properties();
		p1.setProperty(SERVER_TYPE, "NW7");
		Server s1 = ServerFactory.createServer(p1);
		assertNotNull(s1);
		assertTrue(s1 instanceof ServerImpl);
		
		Properties p2 = new Properties();
		p2.setProperty(SERVER_TYPE, "NW7");
		p2.setProperty("host", "localhost");
		Server s2 = ServerFactory.createServer(p2);
		assertEquals(s1, s2);
		
		Properties p3 = new Properties();
		p3.setProperty(SERVER_TYPE, "NW7");
		p3.setProperty("host", "localhost");
		p3.setProperty("instance.number", "0");
		Server s3 = ServerFactory.createServer(p3);
		assertEquals(s1, s3);
		
		Properties p4 = new Properties();
		p4.setProperty(SERVER_TYPE, "NW7");
		p4.setProperty("host", "my-host");
		p4.setProperty("instance.number", "0");
		Server s4 = ServerFactory.createServer(p4);
		assertNotSame(s1, s4);
		assertNotNull(s4);
		assertTrue(s4 instanceof ServerImpl);
		
		Properties p5 = new Properties();
		p5.setProperty(SERVER_TYPE, "NW7");
		p5.setProperty("host", "my-host");
		p5.setProperty("instance.number", "12");
		Server s5 = ServerFactory.createServer(p5);
		assertNotSame(s4, s5);
		assertNotNull(s5);
		assertTrue(s5 instanceof ServerImpl);
		
		Properties p6 = new Properties();
		p6.setProperty(SERVER_TYPE, "NW7");
		p6.setProperty("host", "my-host");
		p6.setProperty("instance.number", "12");
		Server s6 = ServerFactory.createServer(p6);
		assertEquals(s5, s6);
	}

}
