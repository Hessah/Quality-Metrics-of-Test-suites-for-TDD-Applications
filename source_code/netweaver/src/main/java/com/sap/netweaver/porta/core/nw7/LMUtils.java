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

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.netweaver.porta.core.ServerState;

public interface LMUtils {
	
	public URL getSAPControlWSUrlByPort(String host, int port) throws MalformedURLException;

	public URL getSAPControlWSUrlByInstance(String host, int instNr) throws MalformedURLException;

	public SAPControlPortType getSAPControlWSProxy(URL wsUrl) throws ServiceException;

	public SAPControlPortType getSAPControlWSProxyToFirstJ2EEInstance(SAPControlPortType control) throws ServiceException, RemoteException, MalformedURLException;

	public AccessPoint findIcmHttpAccessPoint(SAPControlPortType control) throws RemoteException;
	
	public ServerState determineServerState(J2EEProcess[] processes);

}
