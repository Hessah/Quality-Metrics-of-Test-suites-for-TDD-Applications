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
 * Controls the lifecycle state of the SAP NetWeaver Application Server.
 * 
 * <p>
 * This interface provides a set of methods to:
 * <ul>
 * <li>start and stop the server;
 * <li>switch on and off the debugging mode of the server;
 * <li>retrieve the current running state of the server.
 * </ul>
 * </p>
 */
public interface LifecycleManager extends CoreModule {

	/**
	 * Requests the server to start.
	 * 
	 * <p>
	 * Requesting this method takes effect only if the server is in <i>stopped</i>
	 * or <i>stopping</i> state. In all other cases this operation is ignored.
	 * </p>
	 * 
	 * <p>
	 * This method is non-blocking. This means that the method only triggers a
	 * start request to the server, but does not wait for the operation to
	 * complete. The user should call the <code>getState()</code> to check the
	 * current running state of the server.
	 * </p>
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the server to start.
	 * 
	 * @see #getState()
	 * @see #setAuthenticationCallback(AuthenticationCallback)
	 */
	public void start() throws NotAuthorizedException, CoreException;

	/**
	 * Request the server to restart. 
	 * 
	 * <p>
	 * Requesting this method does not take effect if the server is in in
	 * <i>stopped</i> or <i>stopping</i> state. In such case this operation is
	 * just ignored.
	 * </p>
	 * 
	 * <p>
	 * This method is non-blocking. This means that the method only triggers a
	 * restart request to the server, but does not wait for the operation to
	 * complete. The user should call the <code>getState()</code> to check the
	 * current running state of the server.
	 * </p>
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the server to stop.
	 * 
	 * @see #getState()
	 * @see #setAuthenticationCallback(AuthenticationCallback)
	 */
	public void restart() throws NotAuthorizedException, CoreException;

	/**
	 * Requests the server to stop.
	 * 
	 * <p>
	 * Requesting this method does not take effect if the server is in in
	 * <i>stopped</i> or <i>stopping</i> state. In such case this operation is
	 * just ignored.
	 * </p>
	 * 
	 * <p>
	 * This method is non-blocking. This means that the method only triggers a
	 * stop request to the server, but does not wait for the operation to
	 * complete. The user should call the <code>getState()</code> to check the
	 * current running state of the server.
	 * </p>
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the server to stop.
	 * 
	 * @see #getState()
	 * @see #setAuthenticationCallback(AuthenticationCallback)
	 */
	public void stop() throws NotAuthorizedException, CoreException;

	/**
	 * Enables the debugging mode of the server.
	 * 
	 * <p>
	 * If the debugging is enabled successfully, the method returns a
	 * <code>DebugSessionInfo</code> pair that gives the debug session key and
	 * the debug port needed by the client to perform the debug session.
	 * </p>
	 * 
	 * @return a pair with debug session key and debug port.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while enabling the debugging.
	 */
	public DebugSessionInfo enableDebugging() throws NotAuthorizedException,
			CoreException;

	/**
	 * Disables the debugging mode of the server.
	 * 
	 * @param key -
	 *            the <i>debug session key</i> of the debug session to disable.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while enabling the debugging.
	 */
	public void disableDebugging(String key) throws NotAuthorizedException,
			CoreException;

	/**
	 * Retrieves the current running state of the server.
	 * 
	 * @return a <code>ServerState</code> enumeration value that represents
	 *         the current running state of the server.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the lifecycle manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs when retrieving the data from the server.
	 * 
	 * @see ServerState
	 */
	public ServerState getState() throws NotAuthorizedException, CoreException;

}
