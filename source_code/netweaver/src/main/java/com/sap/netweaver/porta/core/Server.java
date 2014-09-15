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

import java.net.InetSocketAddress;

/**
 * Represents a physical SAP NetWeaver Application Server system. This interface
 * provides a set of methods to control various aspects of the server.
 * 
 * <p>
 * An instance of the <code>Server</code> interface can be created using the
 * <code>ServerFactory</code>.
 * </p>
 * 
 * @see ServerFactory
 */
public interface Server {

	/**
	 * Returns an instance of the <code>LifecycleManager</code> interface.
	 * 
	 * <p>
	 * The lifecycle manager is responsible of controlling the lifecycle state
	 * of the SAP NetWeaver Application Server like starting, stopping,
	 * debugging, etc.
	 * </p>
	 * 
	 * @return an instance of <code>LifecycleManager</code>.
	 * 
	 * @throws CoreException -
	 *             if a problem occurs during initializing the Lifecycle
	 *             Manager.
	 */
	public LifecycleManager getLifecycleManager() throws CoreException;

	/**
	 * Returns an instance of the <code>DeployManager</code> interface.
	 * 
	 * <p>
	 * The deploy manager is used to deploy Java EE applications to the SAP
	 * NetWeaver Application Server and to watch their status.
	 * </p>
	 * 
	 * @return an instance of <code>DeployManager</code>.
	 * 
	 * @throws CoreException -
	 *             if a problem occurs during initializing the Deploy Manager.
	 */
	public DeployManager getDeployManager() throws CoreException;

	/**
	 * Checks if this <code>Server</code> instance is alive.
	 * 
	 * <p>
	 * The <code>Server</code> instance is considered alive if a simple call
	 * to the SAPControl service can be processed. Failed ping means that either
	 * the SAPControl service is stopped, or the <code>Server</code> instance
	 * is not configured properly (e.g. wrong host or instance number).
	 * </p>
	 * 
	 * <p>
	 * The method silently returns if the ping is successful. Otherwise, it
	 * throws a <code>CoreException</code>. The exception contains the
	 * details for the failed ping.
	 * </p>
	 * 
	 * @throws CoreException -
	 *             if the ping fails.
	 */
	public void ping() throws CoreException;

	/**
	 * Returns the name of the system.
	 * 
	 * <p>
	 * The system name is also known as SID and is a three-letter alphanumeric.
	 * It can look like CE1, LKG, N50, etc.
	 * </p>
	 * 
	 * @return the system name.
	 * 
	 * @throws CoreException -
	 *             if a problem occurs during retrieving the system name.
	 */
	public String getSystemName() throws CoreException;

	/**
	 * Returns the HTTP service access point of the server.
	 * 
	 * <p>
	 * The access point info can be used to make HTTP requests to the server.
	 * </p>
	 * 
	 * @return a socket address to the HTTP service access point that contains
	 *         the host and port to access it.
	 * 
	 * @throws CoreException -
	 *             if a problem occurs during retrieving the HTTP service access
	 *             point.
	 */
	public InetSocketAddress getHttpAccessPoint() throws CoreException;

}
