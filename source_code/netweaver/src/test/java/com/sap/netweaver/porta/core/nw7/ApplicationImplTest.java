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

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.engine.services.dc.wsgate.Application;
import com.sap.netweaver.porta.core.ApplicationStatus;

public class ApplicationImplTest {
	
	private static final String ID = "app_id";
	private static final String LOCATION = "app_location";
	private static final String NAME = "app_name";
	private static final String STATUS = "unknown";
	private static final String VENDOR = "app_vendor";
	private static final String VERSION = "app_version";
	
	@Test
	public void testGetters() throws Exception {
		Application proxy = new Application(ID, LOCATION, NAME, STATUS, VENDOR, VERSION);
		ApplicationImpl app = new ApplicationImpl(proxy);
		
		assertEquals(ID, app.getId());
		assertEquals(LOCATION, app.getLocation());
		assertEquals(NAME, app.getName());
		assertEquals(ApplicationStatus.UNKNOWN, app.getStatus());
		assertEquals(VENDOR, app.getVendor());
		assertEquals(VERSION, app.getVersion());
		assertEquals(proxy, app.getProxy());
	}
	
}
