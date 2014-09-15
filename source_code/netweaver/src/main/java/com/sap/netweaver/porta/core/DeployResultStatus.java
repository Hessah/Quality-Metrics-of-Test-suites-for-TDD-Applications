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
 * Represents the overall result status of a deploy/undeploy operation.
 * 
 * @see DeployResult
 * @see DeployManager#deploy(java.io.File[])
 */
public enum DeployResultStatus {

	/**
	 * This never should happen, but it was added in order to keep consistency 
	 * with result status, returned from deploy service
	 */

	UNKNOWN("Unknown"),
	/**
	 * If there is at least one archive which has not been deployed or
	 * undeployed successfully.
	 */
	ERROR("Error"),

	/**
	 * If there are no archives with status ERROR or WARNING and there is at
	 * least one archive which have been successfully deployed or undeployed.
	 */
	SUCCESS("Success"),

	/**
	 * If there are no archives with status ERROR and all of them have been
	 * deployed or undeployed successfully, but there are warnings where user
	 * attention is needed.
	 */
	WARNING("Warning");
	
	private final String name;
	
	DeployResultStatus(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static DeployResultStatus getByName(String name) {
		for (DeployResultStatus value : values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		throw new IllegalArgumentException(name);
	}

}
