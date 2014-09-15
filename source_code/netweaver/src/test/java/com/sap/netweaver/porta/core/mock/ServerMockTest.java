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

import static org.junit.Assert.*;

import java.net.InetSocketAddress;

import org.junit.Before;
import org.junit.Test;

import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.LifecycleManager;

public class ServerMockTest {
	
	private ServerMock server;
	
	@Before
	public void createServer() {
		server = new ServerMock();
	}
	
	@Test
	public void testGetLifecycleManager() throws Exception {
		LifecycleManager lm1 = server.getLifecycleManager();
		assertNotNull(lm1);
		LifecycleManager lm2 = server.getLifecycleManager();
		assertEquals(lm2, lm1);
	}
	
	@Test
	public void testGetDeployManager() throws Exception {
		DeployManager dm1 = server.getDeployManager();
		assertNotNull(dm1);
		DeployManager dm2 = server.getDeployManager();
		assertEquals(dm2, dm1);
	}
	
	@Test
	public void testPing() throws Exception {
		server.ping();
	}
	
	@Test
	public void testGetSystemName() throws Exception {
		assertEquals("MCK", server.getSystemName());
	}
	
	@Test
	public void testGetHttpAccessPoint() throws Exception {
		InetSocketAddress isa = server.getHttpAccessPoint();
		assertEquals("localhost", isa.getHostName());
		assertEquals(50000, isa.getPort());
	}

}
