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

public enum FaultReasons {
	
	FAULT_UNAUTHORIZED("(401)Unauthorized"), 
	FAULT_NOT_FOUND("(404)Not Found"),
	FAULT_INVALID_CREDENTIALS("Invalid Credentials"),
	FAULT_PERMISSION_DENIED("Permission denied"),
	FAULT_INSTANCE_ALREADY_STARTED("Instance already started"), 
	FAULT_SHM_NOT_FOUND("JsfOpenShm failed: object not found"), 
	FAULT_END_DEBUG_SESSION_WRONG_STATE("JsfEndDebugSession failed: wrong state for operation");
	
	private String faultReason;
	
	FaultReasons(String faultReason) {
		this.faultReason = faultReason;
	}
	
	public String getFaultReason() {
		return faultReason;
	}
	
	public String toString() {
		return faultReason;
	}

}
