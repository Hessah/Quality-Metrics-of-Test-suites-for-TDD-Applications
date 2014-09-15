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

import java.io.File;

/**
 * Manages the deployment of Java EE applications on the server.
 * 
 * <p>
 * This interface provides a set of methods to:
 * <ul>
 * <li>deploy and undeploy Java EE applications on the server;
 * <li>retrieve a list of all Java EE applications currently deployed on the
 * server;
 * <li>start and stop a particular Java EE application that is already deployed
 * on the server.
 * </ul>
 * </p>
 */
public interface DeployManager extends CoreModule {

	/**
	 * Deploys one or more Java EE applications to the server.
	 * 
	 * <p>
	 * The Java EE applications are given to the method as an array of
	 * <code>File</code> references to the Java EE modules to be deployed.
	 * </p>
	 * 
	 * <p>
	 * This method returns a <code>DeployResult</code> object. It represents
	 * the overall status of the deploy operation along with a detailed
	 * explanation message.
	 * </p>
	 * 
	 * @param archives -
	 *            the list of Java EE modules to be deployed.
	 * 
	 * @return the result of the deploy operation.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the deploy manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the deploy operation.
	 * 
	 * @see DeployResult
	 */
	public DeployResult deploy(File[] archives) throws NotAuthorizedException,
			CoreException;

	/**
	 * Undeploys one or more Java EE applications from the server.
	 * 
	 * <p>
	 * This method returns an <code>DeployResult</code> object. It represents
	 * the overall status of the undeploy operation along with a detailed
	 * explanation message.
	 * </p>
	 * 
	 * @param apps -
	 *            the list of the applications to be undeployed.
	 * 
	 * @return the result of the undeploy operation.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the deploy manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the deploy operation.
	 * 
	 * @see DeployResult
	 */
	public DeployResult undeploy(Application[] apps)
			throws NotAuthorizedException, CoreException;

	/**
	 * Returns a list of all Java EE applications deployed on the server.
	 * 
	 * @return a list of <code>Application</code> objects.
	 * 
	 * @throws NotAuthorizedException -
	 *             if the deploy manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException -
	 *             if a problem occurs while requesting the deploy operation.
	 */
	public Application[] getApplications() throws NotAuthorizedException,
			CoreException;

	/**
	 * Starts one or more Java EE applications that is already deployed on the
	 * server.
	 * 
	 * @param apps
	 *            - the applications to start.
	 * 
	 * @return a list of <code>Application</code> objects that are updated with
	 *         the new status of the application.
	 * 
	 * @throws NotAuthorizedException
	 *             - if the deploy manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException
	 *             - if a problem occurs while requesting the deploy operation.
	 */
	public Application[] start(Application[] apps)
			throws NotAuthorizedException, CoreException;

	/**
	 * Stops one or more Java EE applications that is already deployed on the
	 * server.
	 * 
	 * @param apps
	 *            - the applications to stop.
	 * 
	 * @return a list of <code>Application</code> objects that are updated with
	 *         the new status of the application.
	 * 
	 * @throws NotAuthorizedException
	 *             - if the deploy manager with the help of the registered
	 *             <code>AuthenticationCallback</code> interface fails to
	 *             provide valid authentication credentials.
	 * @throws CoreException
	 *             - if a problem occurs while requesting the deploy operation.
	 */
	public Application[] stop(Application[] apps)
			throws NotAuthorizedException, CoreException;

}
