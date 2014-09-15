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
 * SAPHostControl_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPHostControl_BindingStub extends org.apache.axis.client.Stub implements com.sap.managementconsole.soap.axis.saphostcontrol.SAPHostControlInterface {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[20];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListInstances");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aSelector"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceSelector"), com.sap.managementconsole.soap.axis.saphostcontrol.InstanceSelector.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfSAPInstance"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "aInstances"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StartInstance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aInstance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "SAPInstance"), com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "response"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StopInstance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aInstance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "SAPInstance"), com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "response"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CallServiceOperation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceServiceOperation"), com.sap.managementconsole.soap.axis.saphostcontrol.InstanceServiceOperation.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "response"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ACOSPrepare");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfACOperation"), com.sap.managementconsole.soap.axis.saphostcontrol.ACOperation[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOperationResults");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperationID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelOperation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperationID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "CancelOperationType"), com.sap.managementconsole.soap.axis.saphostcontrol.CancelOperationType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsOperationFinished");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperationID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "IsFinished"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExecuteOperation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOperation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCIMObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfCIMObject"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetComputerSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "CIMObject"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListDatabases");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfDatabase"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.Database[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDatabaseStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "result"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfDatabaseComponent"), com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseStatus"), com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StartDatabase");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StopDatabase");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AttachDatabase");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DetachDatabase");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDatabaseProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetDatabaseProperty");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LiveDatabaseUpdate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aArguments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty"), com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions"), com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:SAPHostControl", "OperationException"),
                      "com.sap.managementconsole.soap.axis.saphostcontrol.OperationException",
                      new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    public SAPHostControl_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SAPHostControl_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SAPHostControl_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", ">OperationException");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.OperationException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperation");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ACOperation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationArguments");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationCode");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfACOperation");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ACOperation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperation");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfACOperationArguments");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ACOperationArguments[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ACOperationArguments");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfCIMAttribute");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.CIMAttribute[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "CIMAttribute");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfCIMObject");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "CIMObject");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfDatabase");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.Database[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "Database");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfDatabaseComponent");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseComponent");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfInstanceOptionsFlags");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceOptionsFlags");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfProperty");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "Property");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfResponseMessages");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ResponseMessage");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ArrayOfSAPInstance");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "SAPInstance");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "CancelOperationType");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.CancelOperationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "CIMAttribute");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.CIMAttribute.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "CIMObject");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "Database");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.Database.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseComponent");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "DatabaseStatus");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceOptionsFlags");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.InstanceOptionsFlags.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceSelector");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.InstanceSelector.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceServiceOperation");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.InstanceServiceOperation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceStatus");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.InstanceStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "OperationCode");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.OperationCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "OperationOptions");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "OperationResult");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "Property");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ResponseMessage");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "SAPInstance");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ServiceIdentifier");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "ServiceType");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPHostControl", "TargetService");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.saphostcontrol.TargetService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[] listInstances(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceSelector aSelector) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "ListInstances"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aSelector});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult startInstance(com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance aInstance, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "StartInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aInstance, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult stopInstance(com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance aInstance, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "StopInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aInstance, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult callServiceOperation(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceServiceOperation aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "CallServiceOperation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperation, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult ACOSPrepare(com.sap.managementconsole.soap.axis.saphostcontrol.ACOperation[] aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "ACOSPrepare"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperation, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult getOperationResults(java.lang.String aOperationID, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "GetOperationResults"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperationID, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult cancelOperation(java.lang.String aOperationID, com.sap.managementconsole.soap.axis.saphostcontrol.CancelOperationType aType, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "CancelOperation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperationID, aType, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean isOperationFinished(java.lang.String aOperationID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "IsOperationFinished"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperationID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult executeOperation(java.lang.String aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "ExecuteOperation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aOperation, aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[] getCIMObject(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "GetCIMObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject getComputerSystem(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "GetComputerSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.Database[] listDatabases(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "ListDatabases"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.Database[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.Database[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.Database[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getDatabaseStatus(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.holders.ArrayOfDatabaseComponentHolder result, com.sap.managementconsole.soap.axis.saphostcontrol.holders.DatabaseStatusHolder status) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "GetDatabaseStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                result.value = (com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[]) _output.get(new javax.xml.namespace.QName("", "result"));
            } catch (java.lang.Exception _exception) {
                result.value = (com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "result")), com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseComponent[].class);
            }
            try {
                status.value = (com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus) _output.get(new javax.xml.namespace.QName("", "status"));
            } catch (java.lang.Exception _exception) {
                status.value = (com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), com.sap.managementconsole.soap.axis.saphostcontrol.DatabaseStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult startDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "StartDatabase"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult stopDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "StopDatabase"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult attachDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "AttachDatabase"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult detachDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "DetachDatabase"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.Property[] getDatabaseProperties(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "GetDatabaseProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.Property[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.Property[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.Property[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setDatabaseProperty(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "SetDatabaseProperty"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult liveDatabaseUpdate(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPHostControl", "LiveDatabaseUpdate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aArguments, aOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) {
              throw (com.sap.managementconsole.soap.axis.saphostcontrol.OperationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
