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

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.sap.netweaver.porta.core.ApplicationStatus;

public class ApplicationMockTest {

	private static final String NAME = "test";
	private static final String FILE_PATH = "/tmp/" + NAME + ".jar";
	private static final String VENDOR = "sap.com";
	private static final String ID = "name: '" + NAME + "', vendor: '" + VENDOR + "'";
	private static final String LOCATION = "SAP AG";
	private static final ApplicationStatus STATUS = ApplicationStatus.STARTED;
	
	private static final String NEW_ID = "new-id";
	private static final String NEW_NAME = "new-name";
	private static final String NEW_VENDOR = "new-vendor";
	private static final String NEW_VERSION = "new-version";
	private static final String NEW_LOCATION = "new-location";
	private static final ApplicationStatus NEW_STATUS = ApplicationStatus.STOPPED;
	
	
	private ApplicationMock application;
	
	@Before
	public void createApplication() {
		File file = new File(FILE_PATH);
		application = new ApplicationMock(file);
	}
	
	@Test
	public void testId() throws Exception {
		assertEquals(ID, application.getId());
		
		application.setId(NEW_ID);
		assertEquals(NEW_ID, application.getId());
	}
	
	@Test
	public void testName() throws Exception {
		assertEquals("test", application.getName());
		
		application.setName(NEW_NAME);
		assertEquals(NEW_NAME, application.getName());
	}
	
	@Test
	public void testVendor() throws Exception {
		assertEquals(VENDOR, application.getVendor());
		
		application.setVendor(NEW_VENDOR);
		assertEquals(NEW_VENDOR, application.getVendor());
	}
	
	@Test
	public void testVersion() throws Exception {
		assertTrue(application.getVersion().startsWith("7.10"));
		
		application.setVersion(NEW_VERSION);
		assertEquals(NEW_VERSION, application.getVersion());
	}
	
	@Test
	public void testLocation() throws Exception {
		assertEquals(LOCATION, application.getLocation());
		
		application.setLocation(NEW_LOCATION);
		assertEquals(NEW_LOCATION, application.getLocation());
	}
	
	@Test
	public void testStatus() throws Exception {
		assertEquals(STATUS, application.getStatus());
		
		application.setStatus(NEW_STATUS);
		assertEquals(NEW_STATUS, application.getStatus());
	}
	
	@Test
	public void testEquals() throws Exception {
		ApplicationMock app2 = new ApplicationMock(new File(FILE_PATH));
		assertEquals(app2, application);
		
		app2.setName(NEW_NAME);
		assertEquals(app2, application);
		
		app2.setId(NEW_ID);
		assertNotSame(app2, application);
	}
	
	@Test
	public void testHashcode() throws Exception {
		assertEquals(ID.hashCode(), application.hashCode());
	}
	
	@Test
	public void testToString() throws Exception {
		application.setVersion(NEW_VERSION);
		assertEquals(String.format("%s|%s|%s|%s|%s|%s", ID, NAME, VENDOR, NEW_VERSION, LOCATION, STATUS), application.toString());
	}

}
