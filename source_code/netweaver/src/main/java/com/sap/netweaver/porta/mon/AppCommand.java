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
package com.sap.netweaver.porta.mon;

import java.io.IOException;

import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.Server;

public abstract class AppCommand extends Command {

	protected String readAppVendor() throws IOException {
		PortaMon.getOut().print("Application Vendor: ");
		return PortaMon.getIn().readLine().trim();
	}

	protected String readAppName() throws IOException {
		PortaMon.getOut().print("Application Name: ");
		return PortaMon.getIn().readLine().trim();
	}

	protected Application findApp(Server server, String vendor, String name) throws NotAuthorizedException, CoreException {
		Application[] apps = server.getDeployManager().getApplications();
		for (Application a : apps) {
			if (a.getVendor().equals(vendor) && a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}

}
