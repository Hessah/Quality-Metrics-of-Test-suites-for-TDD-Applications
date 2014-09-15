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
 * An interface used by the <code>Server</code>'s managers to retrieve
 * authentication information needed for operations that are executed on the
 * server.
 * 
 * <p>
 * The interface has to be implemented by the user of the corresponding
 * <code>Server</code>'s managers and then registered using the
 * <code>setAuthenticationCallback(AuthenticationCallback)</code> method.
 * </p>
 */
public interface AuthenticationCallback {

	/**
	 * Retrieves the authentication credentials.
	 * 
	 * <p>
	 * The implementation of this method should typically prompt the end user to
	 * provide authentication credentials. This could be done using a text
	 * prompt, a dialog box, etc.
	 * </p>
	 * 
	 * @param reason -
	 *            specifies the reason for requesting the credentials. 
	 * 
	 * @return a pair object with the user name and password. 
	 * 
	 * @throws CoreException -
	 *             if a problem happens during retrieving the credentials.
	 * @throws AuthenticationRefusedException - 
	 *             if the end user refuses to authenticate (e.g. clicks the
	 *             Cancel button of the dialog box).
	 * 
	 * @see AuthenticationReason
	 */
	public Credentials getCredentials(AuthenticationReason reason)
			throws CoreException, AuthenticationRefusedException;

}
