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

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.ApplicationStatus;

public class ApplicationImpl implements Application {
	
	private com.sap.engine.services.dc.wsgate.Application proxy;
	
	public ApplicationImpl(com.sap.engine.services.dc.wsgate.Application proxy) {
		this.proxy = proxy;
	}

	public String getId() {
		return proxy.getId();
	}

	public String getLocation() {
		return proxy.getLocation();
	}

	public String getName() {
		return proxy.getName();
	}

	public ApplicationStatus getStatus() {
		return ApplicationStatus.getByName(proxy.getStatus());
	}

	public String getVendor() {
		return proxy.getVendor();
	}

	public String getVersion() {
		return proxy.getVersion();
	}
	
	com.sap.engine.services.dc.wsgate.Application getProxy() {
		return proxy;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ApplicationImpl) {
			return proxy.getId().equals(((ApplicationImpl) obj).proxy.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return proxy.getId().hashCode();
	}
	
}
