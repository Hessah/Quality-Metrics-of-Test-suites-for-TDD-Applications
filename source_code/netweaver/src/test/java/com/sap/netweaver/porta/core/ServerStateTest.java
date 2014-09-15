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

public class ServerStateTest {
	
	@Test
	public void testStopped() throws Exception {
		assertEquals("Stopped", ServerState.STOPPED.toString());
	}
	
	@Test
	public void testStarting() throws Exception {
		assertEquals("Starting", ServerState.STARTING.toString());
	}
	
	@Test
	public void testRunning() throws Exception {
		assertEquals("Running", ServerState.RUNNING.toString());
	}
	
	@Test
	public void testStopping() throws Exception {
		assertEquals("Stopping", ServerState.STOPPING.toString());
	}
	
	@Test
	public void testUnknown() throws Exception {
		assertEquals("Unknown", ServerState.UNKNOWN.toString());
	}
	
}
