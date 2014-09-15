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

/**
 * A pair object that holds the key and port of the debug session.
 * 
 * <p>
 * This information is needed for the client to execute a debug session to the
 * server.
 * </p>
 */
public class DebugSessionInfo {

	private String key;
	private int port;

	/**
	 * Constructs a <code>DebugSessionInfo</code> from the given key and port.
	 * 
	 * @param key -
	 *            the debug session key to include in the info object. 
	 * @param port -
	 *            the debug port to include in the info object. 
	 */
	public DebugSessionInfo(String key, int port) {
		this.key = key;
		this.port = port;
	}

	/**
	 * Returns the debug session key.
	 * 
	 * @return a <code>String</code> representation of the debug session key. 
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Returns the debug port.
	 * 
	 * @return the port number. 
	 */
	public int getPort() {
		return port;
	}

}
