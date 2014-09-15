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

import java.net.InetSocketAddress;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.Server;

public class ServerMock implements Server {
	
	private LifecycleManager lm;
	private DeployManager dm;

	public LifecycleManager getLifecycleManager() throws CoreException {
		if (lm == null) {
			lm = new LifecycleManagerMock();
		}
		return lm;
	}

	public DeployManager getDeployManager() throws CoreException {
		if (dm == null) {
			dm = new DeployManagerMock();
		}
		return dm;
	}
	
	public void ping() throws CoreException {
		// do nothing - ping successful
	}
	
	public String getSystemName() throws CoreException {
		return "MCK";
	}

	public InetSocketAddress getHttpAccessPoint() throws CoreException {
		return new InetSocketAddress("localhost", 50000);
	}

}
