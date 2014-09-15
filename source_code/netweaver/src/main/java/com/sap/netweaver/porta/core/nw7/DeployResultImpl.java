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
package com.sap.netweaver.porta.core.nw7;

import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.DeployResultStatus;

public class DeployResultImpl implements DeployResult {

	private DeployResultStatus status;
	private String details;
	
	public DeployResultImpl(DeployResultStatus status, String details) {
		super();
		this.status = status;
		this.details = details;
	}

	public DeployResultStatus getStatus() {
		return status;
	}

	public String getStatusDetails() {
		return details;
	}

}
