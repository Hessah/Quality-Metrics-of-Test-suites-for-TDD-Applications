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

import java.util.Properties;

import com.sap.netweaver.porta.core.Server;

public class ServerFactory {
	
	private static Server mock;
	
	public static Server createServer(Properties props) {
		if (mock == null) {
			mock = new ServerMock();
		}
		return mock;
	}

}
