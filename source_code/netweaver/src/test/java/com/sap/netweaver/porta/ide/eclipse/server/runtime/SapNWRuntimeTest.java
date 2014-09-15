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
package com.sap.netweaver.porta.ide.eclipse.server.runtime;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.junit.Test;

public class SapNWRuntimeTest {
	
	@Test
	public void testValidateClasspath_710() throws Exception {
		SapNWRuntime sapRuntime = new SapNW710Runtime();
		IStatus status = sapRuntime.validateClasspath(new File("resource/J710"));
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testValidateClasspath_711() throws Exception {
		SapNWRuntime sapRuntime = new SapNW711Runtime();
		IStatus status = sapRuntime.validateClasspath(new File("resource/J711"));
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testValidateClasspath_720() throws Exception {
		SapNWRuntime sapRuntime = new SapNW720Runtime();
		IStatus status = sapRuntime.validateClasspath(new File("resource/J720"));
		assertTrue(status.getMessage(), status.isOK());
	}
	
	@Test
	public void testValidateClasspath_Error() throws Exception {
		SapNWRuntime sapRuntime = new SapNW710Runtime();
		IStatus status = sapRuntime.validateClasspath(new File("resource"));
		assertEquals(IStatus.ERROR, status.getSeverity());
	}

}
