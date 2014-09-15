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
package com.sap.netweaver.porta.ide.eclipse.axis.proxy;

import org.apache.axis.AxisProperties;
import org.apache.axis.components.net.DefaultHTTPTransportClientProperties;

public class AxisTransportClientProperties extends DefaultHTTPTransportClientProperties 
 {

	@Override
	public String getNonProxyHosts() {
		String value = AxisProperties.getProperty("http.nonProxyHosts");
		return (value == null) ? "" : value;
	}

	@Override
	public String getProxyHost() {
		String value = AxisProperties.getProperty("http.proxyHost");
		return (value == null) ? "" : value;
	}

	@Override
	public String getProxyPassword() {
		String value = AxisProperties.getProperty("http.proxyPassword");
		return (value == null) ? "" : value;
	}

	@Override
	public String getProxyPort() {
		String value = AxisProperties.getProperty("http.proxyPort");
		return (value == null) ? "" : value;
	}

	@Override
	public String getProxyUser() {
		String value = AxisProperties.getProperty("http.proxyUser");
		return (value == null) ? "" : value;
	}

}
