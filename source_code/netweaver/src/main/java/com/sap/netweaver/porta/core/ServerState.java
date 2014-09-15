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
 * Enumerates the running states of the server.
 */
public enum ServerState {

	/**
	 * The server is currently stopped.
	 */
	STOPPED("Stopped"),

	/**
	 * The server is currently starting.
	 */
	STARTING("Starting"),

	/**
	 * The server has started successfully and is currently in operating state.
	 */
	RUNNING("Running"), 
	
	/**
	 * The server is currently stopping. 
	 */
	STOPPING("Stopping"), 
	
	/**
	 * The server state cannot be determined. 
	 */
	UNKNOWN("Unknown");
	
	private final String name;
	
	ServerState(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

}
