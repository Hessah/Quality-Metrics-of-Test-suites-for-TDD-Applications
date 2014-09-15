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

public class ApplicationStatusTest {
	
	@Test
	public void testStarted() throws Exception {
		assertEquals(ApplicationStatus.STARTED, ApplicationStatus.getByName("started"));
		assertEquals("started", ApplicationStatus.STARTED.toString());
	}
	
	@Test
	public void testStopped() throws Exception {
		assertEquals(ApplicationStatus.STOPPED, ApplicationStatus.getByName("stopped"));
		assertEquals("stopped", ApplicationStatus.STOPPED.toString());
	}
	
	@Test
	public void testNotSupported() throws Exception {
		assertEquals(ApplicationStatus.NOT_SUPPORTED, ApplicationStatus.getByName("not supported"));
		assertEquals("not supported", ApplicationStatus.NOT_SUPPORTED.toString());
	}
	
	@Test
	public void testUnknown() throws Exception {
		assertEquals(ApplicationStatus.UNKNOWN, ApplicationStatus.getByName("unknown"));
		assertEquals("unknown", ApplicationStatus.UNKNOWN.toString());
	}
	
	@Test
	public void testStarting() throws Exception {
		assertEquals(ApplicationStatus.STARTING, ApplicationStatus.getByName("starting"));
		assertEquals("starting", ApplicationStatus.STARTING.toString());
	}
	
	@Test
	public void testStopping() throws Exception {
		assertEquals(ApplicationStatus.STOPPING, ApplicationStatus.getByName("stopping"));
		assertEquals("stopping", ApplicationStatus.STOPPING.toString());
	}
	
	@Test
	public void testUpgrading() throws Exception {
		assertEquals(ApplicationStatus.UPGRADING, ApplicationStatus.getByName("upgrading"));
		assertEquals("upgrading", ApplicationStatus.UPGRADING.toString());
	}
	
	@Test
	public void testImplicitStopped() throws Exception {
		assertEquals(ApplicationStatus.IMPLICIT_STOPPED, ApplicationStatus.getByName("implicit stopped"));
		assertEquals("implicit stopped", ApplicationStatus.IMPLICIT_STOPPED.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getByName_Invalid() throws Exception {
		ApplicationStatus.getByName("invalid");
	}
	
}
