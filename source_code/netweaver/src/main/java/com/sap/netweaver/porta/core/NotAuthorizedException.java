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
 * <code>NotAuthorizedException</code> is thrown when the client is not
 * authorized to access the service or operation.
 */
public class NotAuthorizedException extends CoreException {

	private static final long serialVersionUID = 3405986653773688958L;

	/**
	 * Constructs a new exception with no specified detail message.
	 */
	public NotAuthorizedException() {
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message -
	 *            the detail message.
	 */
	public NotAuthorizedException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause -
	 *            the cause.
	 */
	public NotAuthorizedException(Throwable cause) {
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
	public NotAuthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

}
