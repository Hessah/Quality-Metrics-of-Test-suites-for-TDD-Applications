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
 * A pair object that holds the user name and password of the authentication
 * credentials.
 */
public class Credentials {

	private String user;
	private String password;

	/**
	 * Constructs a <code>Credentials</code> object from the given user name
	 * and password.
	 * 
	 * @param user -
	 *            the user name to include in the credentials. 
	 * @param password -
	 *            the password to include in the credentials. 
	 */
	public Credentials(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/**
	 * Returns the user name from the credentials.
	 * 
	 * @return the user name. 
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Returns the password from the credentials.
	 * 
	 * @return the password. 
	 */
	public String getPassword() {
		return password;
	}

}
