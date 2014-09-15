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
 * <code>NoWSGateException</code> is thrown when deploy operation is executed,
 * but the WS Gate application is not deployed on the target server. The WS Gate
 * application provides the Web Service with the deploy operations.
 */
public class NoWSGateException extends CoreException {
	
	private static final long serialVersionUID = -3375606069287273785L;
	
	private String endpoint;

	public NoWSGateException(Throwable cause, String endpoint) {
		super("Deploy Web Service application not available. This application installs the Web Service that enables the publish operations. You need to install it on the target server in order to execute any publish operations. ", cause);
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return endpoint;
	}

}
