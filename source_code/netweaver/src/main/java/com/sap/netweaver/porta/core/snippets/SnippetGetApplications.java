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
package com.sap.netweaver.porta.core.snippets;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.Stub;

import com.sap.engine.services.dc.wsgate.Application;
import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.engine.services.dc.wsgate.DeployWSServiceLocator;

public class SnippetGetApplications {
	
	public static final String HOST = "localhost";
	public static final int INST_NR = 0; // J2EE instance
	
	public static final String USER = "<user>";
	public static final String PASS = "<password>";

	public static void main(String[] args) throws Exception {
		DeployWSPortType deployWS = new DeployWSServiceLocator().getDeployWSPort(getWsUrl());
		addAuthentication(deployWS, USER, PASS);
		Application[] apps = deployWS.getApplications(null);
		if (apps == null) 
			apps = new Application[0];
		
		System.out.println("Number of applications: " + apps.length);
		System.out.println();
		System.out.println("ID | NAME | VENDOR | VERSION | LOCATION | STATUS");
		
		for (Application app : apps) {
			System.out.println(
					app.getId() + " | " + 
					app.getName() + " | " + 
					app.getVendor() + " | " +
					app.getVersion() + " | " + 
					app.getLocation() + " | " + 
					app.getStatus()
			);
		}
	}
	
	private static URL getWsUrl() throws MalformedURLException {
		int port = 50000 + INST_NR * 100;
		return new URL("http", HOST, port, "/DeployWSService/DeployWS");
	}
	
	private static void addAuthentication(DeployWSPortType deployWS, String user, String pass) {
		Stub stub = (Stub) deployWS;
		stub._setProperty(Stub.USERNAME_PROPERTY, user);
		stub._setProperty(Stub.PASSWORD_PROPERTY, pass);
	}

}
