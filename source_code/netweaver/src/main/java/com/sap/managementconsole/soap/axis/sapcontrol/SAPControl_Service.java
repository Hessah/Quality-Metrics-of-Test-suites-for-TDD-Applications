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
package com.sap.managementconsole.soap.axis.sapcontrol;

/**
 * SAPControl_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public interface SAPControl_Service extends javax.xml.rpc.Service {

/**
 * The SAPControl webservice can be used to control and monitor a
 * single SAP instance. Some methods may fail with http error 401 without
 * user authentication. Use http basic authentication (UTF8 encoded)
 * to provide OS user credentials. By default the service uses port 5$(SAPSYSTEM)13
 * for http and 5$(SAPSYSTEM)14 for https (if SSL is configured for the
 * instance), this might be overriden in etc/service by specifying sapctrl$(SAPSYSTEM)
 * and sapctrls$(SAPSYSTEM).
 */
    public java.lang.String getSAPControlAddress();

    public com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType getSAPControl() throws javax.xml.rpc.ServiceException;

    public com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType getSAPControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
