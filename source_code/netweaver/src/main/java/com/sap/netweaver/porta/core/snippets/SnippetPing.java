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
package com.sap.netweaver.porta.core.snippets;

import java.util.Properties;

import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class SnippetPing {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 0; // SCS instance
	
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty(ServerFactory.SERVER_TYPE, "NW7");
		props.setProperty("host", HOST);
		props.setProperty("instance.number", Integer.toString(INST_NR));

		Server server = ServerFactory.createServer(props);
		server.ping();
		System.out.println("Ping is successful.");
	}

}
