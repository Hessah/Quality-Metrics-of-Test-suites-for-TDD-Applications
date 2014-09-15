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
 * SAPControl_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPControl_ServiceLocator extends org.apache.axis.client.Service implements com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_Service {

/**
 * The SAPControl webservice can be used to control and monitor a
 * single SAP instance. Some methods may fail with http error 401 without
 * user authentication. Use http basic authentication (UTF8 encoded)
 * to provide OS user credentials. By default the service uses port 5$(SAPSYSTEM)13
 * for http and 5$(SAPSYSTEM)14 for https (if SSL is configured for the
 * instance), this might be overriden in etc/service by specifying sapctrl$(SAPSYSTEM)
 * and sapctrls$(SAPSYSTEM).
 */

    public SAPControl_ServiceLocator() {
    }


    public SAPControl_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SAPControl_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SAPControl
    private java.lang.String SAPControl_address = "http://localhost:50013/SAPControl.cgi";

    public java.lang.String getSAPControlAddress() {
        return SAPControl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SAPControlWSDDServiceName = "SAPControl";

    public java.lang.String getSAPControlWSDDServiceName() {
        return SAPControlWSDDServiceName;
    }

    public void setSAPControlWSDDServiceName(java.lang.String name) {
        SAPControlWSDDServiceName = name;
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType getSAPControl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SAPControl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSAPControl(endpoint);
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType getSAPControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_BindingStub _stub = new com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_BindingStub(portAddress, this);
            _stub.setPortName(getSAPControlWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSAPControlEndpointAddress(java.lang.String address) {
        SAPControl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_BindingStub _stub = new com.sap.managementconsole.soap.axis.sapcontrol.SAPControl_BindingStub(new java.net.URL(SAPControl_address), this);
                _stub.setPortName(getSAPControlWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SAPControl".equals(inputPortName)) {
            return getSAPControl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:SAPControl", "SAPControl");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:SAPControl", "SAPControl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SAPControl".equals(portName)) {
            setSAPControlEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
