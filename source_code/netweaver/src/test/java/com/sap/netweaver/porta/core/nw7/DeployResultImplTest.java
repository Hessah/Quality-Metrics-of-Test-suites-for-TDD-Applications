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

import com.sap.netweaver.porta.core.DeployResultStatus;

public class DeployResultImplTest {
	
	private static final String DETAILS = "deploy result detials";
	
	@Test
	public void testGetters() throws Exception {
		DeployResultImpl deployResult = new DeployResultImpl(DeployResultStatus.UNKNOWN, DETAILS);
		assertEquals(DeployResultStatus.UNKNOWN, deployResult.getStatus());
		assertEquals(DETAILS, deployResult.getStatusDetails());
	}
	
}
