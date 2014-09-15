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
package com.sap.managementconsole.soap.axis.saphostcontrol;

/**
 * SAPHostControl_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public interface SAPHostControl_Service extends javax.xml.rpc.Service {

/**
 * The SAPHostControl support a group of Host specific operations
 * like : Start / Stop an SAP System; Start/Stop a Database; Mount /
 * Unmount of filesystems; Activate/Deactivate ip addresses.
 */
    public java.lang.String getSAPHostControlAddress();

    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface getSAPHostControl() throws javax.xml.rpc.ServiceException;

    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface getSAPHostControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
