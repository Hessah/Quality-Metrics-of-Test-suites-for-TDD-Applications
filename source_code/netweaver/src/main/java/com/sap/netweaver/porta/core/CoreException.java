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
 * <code>CoreException</code> is thrown when a generic error happens in the
 * Core library classes.
 */
public class CoreException extends Exception {

	private static final long serialVersionUID = -6586245321483169010L;

	/**
	 * Constructs a new exception with no specified detail message.
	 */
	public CoreException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message -
	 *            the detail message.
	 */
	public CoreException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause -
	 *            the cause.
	 */
	public CoreException(Throwable cause) {
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
	public CoreException(String message, Throwable cause) {
		super(message, cause);
	}

}
