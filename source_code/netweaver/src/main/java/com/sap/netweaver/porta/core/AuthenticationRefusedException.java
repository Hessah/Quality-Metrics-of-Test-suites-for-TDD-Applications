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
 * <code>AuthenticationRefusedException</code> is thrown when the end user
 * refuses to authenticate himself when requested.
 * 
 * <p>
 * For example, this can be the case when the end user hits the Cancel button on
 * the dialog box requesting for user name and password.
 * </p>
 */
public class AuthenticationRefusedException extends Exception {

	private static final long serialVersionUID = 4110648425630842061L;

	/**
	 * Constructs a new exception with no specified detail message.
	 */
	public AuthenticationRefusedException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message -
	 *            the detail message.
	 */
	public AuthenticationRefusedException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause -
	 *            the cause.
	 */
	public AuthenticationRefusedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message -
	 *            the detail message.
	 * @param cause -
	 *            the cause.
	 */
	public AuthenticationRefusedException(String message, Throwable cause) {
		super(message, cause);
	}

}
