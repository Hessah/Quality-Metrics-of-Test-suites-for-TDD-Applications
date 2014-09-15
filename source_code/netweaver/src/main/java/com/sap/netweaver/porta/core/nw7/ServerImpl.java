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

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.LifecycleManager;
import com.sap.netweaver.porta.core.Server;

public class ServerImpl implements Server {
	
	private String host;
	private int instNr;
	
	private final LMUtils utils;
	
	private LifecycleManager lm;
	private DeployManager dm;

	public ServerImpl(String host, int instNr) {
		this(host, instNr, new LMUtilsImpl());
	}

	ServerImpl(String host, int instNr, LMUtils utils) {
		this.host = host;
		this.instNr = instNr;
		this.utils = utils;
	}

	public DeployManager getDeployManager() throws CoreException {
		if (dm == null) {
			dm = new DeployManagerImpl(host, instNr);
		}
		return dm;
	}

	public LifecycleManager getLifecycleManager() {
		if (lm == null) {
			lm = new LifecycleManagerImpl(host, instNr);
		}
		return lm;
	}
	
	public void ping() throws CoreException {
		getSystemName();
	}
	
	public String getSystemName() throws CoreException {
		try {
			URL url = utils.getSAPControlWSUrlByInstance(host, instNr);
			SAPControlPortType control = utils.getSAPControlWSProxy(url);
			return control.parameterValue("SAPSYSTEMNAME");
		} catch (MalformedURLException e) {
			throw new CoreException(e);
		} catch (ServiceException e) {
			throw new CoreException(e);
		} catch (RemoteException e) {
			throw new CoreException(e);
		}
	}
	
	public InetSocketAddress getHttpAccessPoint() throws CoreException {
		try {
			// establish ws proxy to the SAPControl of the first J2EE instance
			URL url = utils.getSAPControlWSUrlByInstance(host, instNr);
			SAPControlPortType control = utils.getSAPControlWSProxy(url);
			SAPControlPortType j2ee = utils.getSAPControlWSProxyToFirstJ2EEInstance(control);
			if (j2ee == null)
				throw new IllegalStateException("cannot determine the J2EE instance");
			
			// determine the HTTP access point
			AccessPoint icmHttp = utils.findIcmHttpAccessPoint(j2ee);
			return new InetSocketAddress(icmHttp.getAddress(), icmHttp.getPort());
		} catch (MalformedURLException e) {
			throw new CoreException(e);
		} catch (ServiceException e) {
			throw new CoreException(e);
		} catch (RemoteException e) {
			throw new CoreException(e);
		}
	}

}
