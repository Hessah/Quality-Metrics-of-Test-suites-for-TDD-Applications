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
 * Represents the result of a deploy/undeploy operation.
 * 
 * @see DeployManager#deploy(java.io.File[])
 */
public interface DeployResult {

	/**
	 * Returns the overall result of the deploy/undeploy operation.
	 * 
	 * @return an enumeration value representing the status.
	 */
	public DeployResultStatus getStatus();

	/**
	 * Returns a descriptive explanation of the result of the deploy/undeploy
	 * operation.
	 * 
	 * @return a detailed status
	 */
	public String getStatusDetails();

}
