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

import java.net.InetSocketAddress;
import java.util.Properties;

public class TestServerFactory {

	private static Server server;
	
	public static Server createServer(Properties props) {
		if (server == null) {
			server = new TestServer();
		}
		return server;
	}
	
	static class TestServer implements Server {

		public DeployManager getDeployManager() throws CoreException {
			// TODO Auto-generated method stub
			return null;
		}

		public InetSocketAddress getHttpAccessPoint() throws CoreException {
			// TODO Auto-generated method stub
			return null;
		}

		public LifecycleManager getLifecycleManager() throws CoreException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getSystemName() throws CoreException {
			// TODO Auto-generated method stub
			return null;
		}

		public void ping() throws CoreException {
			// TODO Auto-generated method stub
		}

	}

}
