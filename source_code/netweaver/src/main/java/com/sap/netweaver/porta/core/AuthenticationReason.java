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
 * Enumerates the reasons to ask the end user for authentication credentials.
 */
public enum AuthenticationReason {

	/**
	 * The server requires authentication credentials for the operation to
	 * perform. The operation cannot be performed with the default (Guest)
	 * credentials.
	 */
	AUTHORIZATION_REQUIRED,

	/**
	 * The end user has given invalid authentication credentials. The end user
	 * has to try to provide valid credentials once again.
	 */
	INVALID_CREDENTIALS,

	/**
	 * The end user has given valid authentication credentials, but they are not
	 * granted with the needed permission. The end user has to try to provide
	 * valid credentials with sufficient permission once again.
	 */
	PERMISSION_DENIED

}
