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
package com.sap.netweaver.porta.ide.eclipse.server.control;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.DeployResultStatus;

public class PublishException extends CoreException {
	
	private static final long serialVersionUID = -698578474515838790L;
	
	private DeployResult deployResult;
	
	public PublishException(DeployResult deployResult) {
		super(getMessage(deployResult.getStatus()));
		this.deployResult = deployResult;
	}

	private static String getMessage(DeployResultStatus status) {
		switch (status) {
			case ERROR: return "The publish operation finished with error. ";
			case WARNING: return "The publish operation finished with warning. ";
			default: return "";
		}
	}
	
	public DeployResult getDeployResult() {
		return deployResult;
	}

}
