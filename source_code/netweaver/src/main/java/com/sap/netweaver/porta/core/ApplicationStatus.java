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
 * Enumerates the status of applications deployed on the server.
 */
public enum ApplicationStatus {

	/**
	 * The application is currently started and working.
	 */
	STARTED("started"),

	/**
	 * The application is currently stopped and not accessible.
	 * 
	 * <p>
	 * The reason for this state could be that:
	 * <ul>
	 * <li>the application is requested to stop;
	 * <li>the application failed to started because of an error.
	 * </ul>
	 * </p>
	 */
	STOPPED("stopped"),

	/**
	 * 
	 */
	NOT_SUPPORTED("not supported"),

	/**
	 * The application is in unknown status.
	 */
	UNKNOWN("unknown"),

	/**
	 * The application is currently starting.
	 * 
	 * <p>
	 * If the starting process completes successfully the application status
	 * will change to "started" and the application will be accessible.
	 * </p>
	 */
	STARTING("starting"),

	/**
	 * The application is currently stopping.
	 * 
	 * <p>
	 * The application is no more accessible. After the stopping process
	 * completes the application status will be become "stopped".
	 * </p>
	 */
	STOPPING("stopping"),

	/**
	 * 
	 */
	UPGRADING("upgrading"),

	/**
	 * 
	 */
	IMPLICIT_STOPPED("implicit stopped"), 
	
	/**
	 * 
	 */
	MARKED_FOR_REMOVAL("marked for removal");

	private final String name;

	ApplicationStatus(String name) {
		this.name = name;
	}

	/**
	 * Returns the string representations of the status.
	 * 
	 * @return a string representation of the status.
	 */
	public String toString() {
		return name;
	}
	
	public static ApplicationStatus getByName(String name) {
		for (ApplicationStatus value : values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
