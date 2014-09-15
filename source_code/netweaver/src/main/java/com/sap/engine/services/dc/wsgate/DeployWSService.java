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
package com.sap.engine.services.dc.wsgate;

/**
 * DeployWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
public interface DeployWSService extends javax.xml.rpc.Service {
    public java.lang.String getDeployWSPortAddress();

    public com.sap.engine.services.dc.wsgate.DeployWSPortType getDeployWSPort() throws javax.xml.rpc.ServiceException;

    public com.sap.engine.services.dc.wsgate.DeployWSPortType getDeployWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
