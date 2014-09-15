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
 * An abstract interface for all modules in the Core library.
 * 
 * <p>
 * This interface contains the common characteristics that has to be implemented
 * by all core modules.
 * </p>
 */
public interface CoreModule {

	/**
	 * Registers an implementation of the <code>AuthenticationCallback</code>
	 * interface to the core module.
	 * 
	 * <p>
	 * The module uses the callback interface to retrieve the authentication
	 * credentials. The credentials are used in server operation (like start or
	 * stop) that require user authentication.
	 * </p>
	 * 
	 * <p>
	 * The core module first tries to call the server operation without
	 * specifying authentication credentials. If the operation fails because of
	 * wrong authorization, then the core module asks the callback interface for
	 * the correct credentials. If the callback inteface fails to provide valid
	 * credentials the corresponding method may throw
	 * <code>NotAuthorizedException</code>. Once the callback interface
	 * provides valid crendentials, these credentials are then used until they
	 * are not valid for a certain operation. If this happens, the core module
	 * asks again the callback interface for new credentials.
	 * </p>
	 * 
	 * <p>
	 * If there is no instance of the callback interface registered, then this
	 * certainly means that almost all methods of the core module will throws
	 * <code>NotAuthorizedException</code>.
	 * </p>
	 * 
	 * <p>
	 * The core module can have only one instance of the callback interface
	 * registered. If this method is called second time, then the new instance
	 * overwrites the previous one.
	 * </p>
	 * 
	 * @param callback -
	 *            an implementation of <code>AuthenticationCallback</code>.
	 * 
	 * @see AuthenticationCallback
	 * @see NotAuthorizedException
	 */
	public void setAuthenticationCallback(AuthenticationCallback callback);

}
