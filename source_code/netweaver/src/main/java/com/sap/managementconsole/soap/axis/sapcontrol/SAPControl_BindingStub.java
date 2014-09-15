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
 * SAPControl_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPControl_BindingStub extends org.apache.axis.client.Stub implements com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[64];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Start");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Stop");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "softtimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "IsSystemStop"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Shutdown");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "IsSystemStop"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ParameterValue");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "value"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProcessList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfOSProcess"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "process"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStartProfile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTraceFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAlertTree");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAlertNode"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "tree"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAlerts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RootTid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RootTidName"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "alert"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAlert"), com.sap.managementconsole.soap.axis.sapcontrol.Alert[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RestartService");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StopService");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEnvironment");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "env"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListDeveloperTraces");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfDirEntry"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "file"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ReadDeveloperTrace");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filename"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "size"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RestartInstance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "softtimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendSignal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "signal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetVersionInfo");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInstanceVersionInfo"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "version"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetQueueStatistic");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfTaskHandlerQueue"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queue"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInstanceProperties");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInstanceProperties"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "properties"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OSExecute");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "command"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "async"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "timeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "protocolfile"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "exitcode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pid"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ReadLogFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filename"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "language"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxentries"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "statecookie"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "format"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startcookie"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endcookie"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fields"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListLogFiles");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfLogFile"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.LogFile[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "file"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AnalyseLogFiles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "starttime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endtime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "severity-level"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxentries"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "format"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fields"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccessPointList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAccessPoint"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "accesspoint"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSystemInstanceList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSAPInstance"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "instance"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StartSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "StartStopOption"), com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "prioritylevel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "waittimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StopSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "StartStopOption"), com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "prioritylevel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "softtimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "waittimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RestartSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "options"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "StartStopOption"), com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "prioritylevel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "softtimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "waittimeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AccessCheck");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "function"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProcessParameter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "processtype"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfProfileParameter"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameter"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetProcessParameter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "processtype"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSetProfileParameter"), com.sap.managementconsole.soap.axis.sapcontrol.SetProfileParameter[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ShmDetach");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ABAPReadSyslog");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSyslogEntry"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "log"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ABAPReadRawSyslog");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfRawSyslogEntry"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "log"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ABAPGetWPTable");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfWorkProcess"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "workprocess"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ABAPAcknowledgeAlerts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "R3Client"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "R3User"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "R3Password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Aid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInt"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "alert"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetProcessList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEProcess"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "process"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetProcessList2");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEProcess2"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "process"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEControlProcess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "processname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "function"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetThreadList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEThread"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "thread"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetThreadList2");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEThread2"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "thread"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetSessionList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EESession"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "session"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetWebSessionList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEWebSession"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "session"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetCacheStatistic");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EECache"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cache"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetCacheStatistic2");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EECache2"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cache"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetApplicationAliasList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEApplicationAlias"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "alias"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetVMGCHistory");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfGCInfo"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "gc"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetVMGCHistory2");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfGCInfo2"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "gc"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetVMHeapInfo");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfHeapInfo"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "heap"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetEJBSessionList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEEJBSession"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ejbsession"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetRemoteObjectList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EERemoteObject"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "remoteobject"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetClusterMsgList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEClusterMsg"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "msg"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetSharedTableInfo");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EESharedTableInfo"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "jsf"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEEnableDbgSession");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "processname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "flags"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "client"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "key"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "port"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEDisableDbgSession");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetThreadCallStack");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "index"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("J2EEGetThreadTaskStack");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "index"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lines"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ICMGetThreadList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMThread"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "thread"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ICMGetConnectionList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMConnection"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "connection"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ICMGetCacheEntries");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMCacheEntry"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "entry"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ICMGetProxyConnectionList");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMProxyConnection"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "connection"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnqGetLockTable");
        oper.setReturnType(new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfEnqLock"));
        oper.setReturnClass(com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "lock"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnqRemoveLocks");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lock"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfEnqLock"), com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnqGetStatistic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "owner-now"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "owner-high"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "owner-max"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "owner-state"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arguments-now"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arguments-high"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arguments-max"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arguments-state"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locks-now"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locks-high"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locks-max"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locks-state"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "enqueue-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "enqueue-rejects"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "enqueue-errors"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dequeue-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dequeue-errors"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dequeue-all-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cleanup-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "backup-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "reporting-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "compress-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "verify-requests"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lock-time"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lock-wait-time"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "server-time"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "replication-state"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[63] = oper;

    }

    public SAPControl_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SAPControl_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SAPControl_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("urn:SAPControl", "AccessPoint");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "Alert");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.Alert.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "AlertNode");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.AlertNode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAccessPoint");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "AccessPoint");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAlert");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.Alert[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "Alert");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfAlertNode");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "AlertNode");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfDirEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "DirEntry");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfEnqLock");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "EnqLock");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfGCInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "GCInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfGCInfo2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "GCInfo2");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfHeapInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "HeapInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMCacheEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMCacheEntry");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMConnection");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMConnection");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMProxyConnection");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMProxyConnection");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfICMThread");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMThread");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInstanceProperties");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "InstanceProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInstanceVersionInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "InstanceVersionInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfInt");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEApplicationAlias");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEApplicationAlias");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EECache");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EECache");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EECache2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EECache2");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEClusterMsg");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEClusterMsg");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEEJBSession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEEJBSession");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEProcess");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEProcess2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEProcess2");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EERemoteObject");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EERemoteObject");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EESession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EESession");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EESharedTableInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EESharedTableInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEThread");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEThread");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEThread2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEThread2");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfJ2EEWebSession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEWebSession");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfLogFile");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.LogFile[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "LogFile");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfOSProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "OSProcess");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "ProfileParameter");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfRawSyslogEntry");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSAPInstance");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "SAPInstance");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSetProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SetProfileParameter[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "SetProfileParameter");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSubProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "SubProfileParameter");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfSyslogEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "SyslogEntry");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfTaskHandlerQueue");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "TaskHandlerQueue");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ArrayOfWorkProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:SAPControl", "WorkProcess");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:SAPControl", "DirEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.DirEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "EnqLock");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.EnqLock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "GCInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.GCInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "GCInfo2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "HeapInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMCacheEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMConnection");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMProxyConnection");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ICMThread");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ICMThread.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "InstanceProperty");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "InstanceVersionInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EE-PSTATE");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEApplicationAlias");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EECache");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EECache.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EECache2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEClusterMsg");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEEJBSession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEProcess2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EERemoteObject");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EESession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EESession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EESharedTableInfo");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEThread");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEThread2");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "J2EEWebSession");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "LogFile");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.LogFile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "OSProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.OSProcess.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ParameterRestriction");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ParameterRestriction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "ProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "RESTRICTION-TYPE");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.RESTRICTIONTYPE.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "SAPInstance");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "SetProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SetProfileParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "StartStopOption");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "SubProfileParameter");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "SyslogEntry");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "TaskHandlerQueue");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "VISIBLE-LEVEL");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.VISIBLELEVEL.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:SAPControl", "WorkProcess");
            cachedSerQNames.add(qName);
            cls = com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess.class;
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

    public void start() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "Start"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void stop(int softtimeout, int isSystemStop) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "Stop"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(softtimeout), new java.lang.Integer(isSystemStop)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void shutdown(int isSystemStop) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "Shutdown"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(isSystemStop)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String parameterValue(java.lang.String parameter) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ParameterValue"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[] getProcessList() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetProcessList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getStartProfile(javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetStartProfile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                name.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "name"));
            } catch (java.lang.Exception _exception) {
                name.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "name")), java.lang.String.class);
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getTraceFile(javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetTraceFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                name.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "name"));
            } catch (java.lang.Exception _exception) {
                name.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "name")), java.lang.String.class);
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[] getAlertTree() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetAlertTree"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getAlerts(java.lang.String rootTid, javax.xml.rpc.holders.StringHolder rootTidName, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfAlertHolder alert) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetAlerts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {rootTid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                rootTidName.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "RootTidName"));
            } catch (java.lang.Exception _exception) {
                rootTidName.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "RootTidName")), java.lang.String.class);
            }
            try {
                alert.value = (com.sap.managementconsole.soap.axis.sapcontrol.Alert[]) _output.get(new javax.xml.namespace.QName("", "alert"));
            } catch (java.lang.Exception _exception) {
                alert.value = (com.sap.managementconsole.soap.axis.sapcontrol.Alert[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "alert")), com.sap.managementconsole.soap.axis.sapcontrol.Alert[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void restartService() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "RestartService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void stopService() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "StopService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getEnvironment() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetEnvironment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[] listDeveloperTraces() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ListDeveloperTraces"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void readDeveloperTrace(java.lang.String filename, int size, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ReadDeveloperTrace"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {filename, new java.lang.Integer(size)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                name.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "name"));
            } catch (java.lang.Exception _exception) {
                name.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "name")), java.lang.String.class);
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void restartInstance(int softtimeout) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "RestartInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(softtimeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void sendSignal(int pid, java.lang.String signal) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "SendSignal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(pid), signal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[] getVersionInfo() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetVersionInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[] getQueueStatistic() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetQueueStatistic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[] getInstanceProperties() throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetInstanceProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void OSExecute(java.lang.String command, int async, int timeout, java.lang.String protocolfile, javax.xml.rpc.holders.IntHolder exitcode, javax.xml.rpc.holders.IntHolder pid, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "OSExecute"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {command, new java.lang.Integer(async), new java.lang.Integer(timeout), protocolfile});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                exitcode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "exitcode"))).intValue();
            } catch (java.lang.Exception _exception) {
                exitcode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "exitcode")), int.class)).intValue();
            }
            try {
                pid.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "pid"))).intValue();
            } catch (java.lang.Exception _exception) {
                pid.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "pid")), int.class)).intValue();
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void readLogFile(java.lang.String filename, java.lang.String filter, java.lang.String language, int maxentries, java.lang.String statecookie, javax.xml.rpc.holders.StringHolder format, javax.xml.rpc.holders.StringHolder startcookie, javax.xml.rpc.holders.StringHolder endcookie, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder fields) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ReadLogFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {filename, filter, language, new java.lang.Integer(maxentries), statecookie});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                format.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "format"));
            } catch (java.lang.Exception _exception) {
                format.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "format")), java.lang.String.class);
            }
            try {
                startcookie.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "startcookie"));
            } catch (java.lang.Exception _exception) {
                startcookie.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "startcookie")), java.lang.String.class);
            }
            try {
                endcookie.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "endcookie"));
            } catch (java.lang.Exception _exception) {
                endcookie.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "endcookie")), java.lang.String.class);
            }
            try {
                fields.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "fields"));
            } catch (java.lang.Exception _exception) {
                fields.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "fields")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.LogFile[] listLogFiles() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ListLogFiles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.LogFile[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.LogFile[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.LogFile[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void analyseLogFiles(java.lang.String starttime, java.lang.String endtime, int severityLevel, int maxentries, javax.xml.rpc.holders.StringHolder format, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder fields) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "AnalyseLogFiles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {starttime, endtime, new java.lang.Integer(severityLevel), new java.lang.Integer(maxentries)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                format.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "format"));
            } catch (java.lang.Exception _exception) {
                format.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "format")), java.lang.String.class);
            }
            try {
                fields.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "fields"));
            } catch (java.lang.Exception _exception) {
                fields.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "fields")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[] getAccessPointList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetAccessPointList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[] getSystemInstanceList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetSystemInstanceList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void startSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int waittimeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "StartSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {options, prioritylevel, new java.lang.Integer(waittimeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void stopSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int softtimeout, int waittimeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "StopSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {options, prioritylevel, new java.lang.Integer(softtimeout), new java.lang.Integer(waittimeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void restartSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int softtimeout, int waittimeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "RestartSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {options, prioritylevel, new java.lang.Integer(softtimeout), new java.lang.Integer(waittimeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void accessCheck(java.lang.String function) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "AccessCheck"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {function});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[] getProcessParameter(java.lang.String processtype, int pid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "GetProcessParameter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {processtype, new java.lang.Integer(pid)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setProcessParameter(java.lang.String processtype, int pid, com.sap.managementconsole.soap.axis.sapcontrol.SetProfileParameter[] parameter) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "SetProcessParameter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {processtype, new java.lang.Integer(pid), parameter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void shmDetach() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ShmDetach"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[] ABAPReadSyslog() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ABAPReadSyslog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] ABAPReadRawSyslog() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ABAPReadRawSyslog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[] ABAPGetWPTable() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ABAPGetWPTable"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] ABAPAcknowledgeAlerts(java.lang.String r3Client, java.lang.String r3User, java.lang.String r3Password, java.lang.String[] aid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ABAPAcknowledgeAlerts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {r3Client, r3User, r3Password, aid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[] j2EEGetProcessList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetProcessList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[] j2EEGetProcessList2() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetProcessList2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void j2EEControlProcess(java.lang.String processname, java.lang.String function) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEControlProcess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {processname, function});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[] j2EEGetThreadList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetThreadList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[] j2EEGetThreadList2() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetThreadList2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[] j2EEGetSessionList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetSessionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[] j2EEGetWebSessionList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetWebSessionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[] j2EEGetCacheStatistic() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetCacheStatistic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[] j2EEGetCacheStatistic2() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetCacheStatistic2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[] j2EEGetApplicationAliasList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetApplicationAliasList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[] j2EEGetVMGCHistory() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetVMGCHistory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[] j2EEGetVMGCHistory2() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetVMGCHistory2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[] j2EEGetVMHeapInfo() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetVMHeapInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[] j2EEGetEJBSessionList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetEJBSessionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[] j2EEGetRemoteObjectList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetRemoteObjectList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[] j2EEGetClusterMsgList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetClusterMsgList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[] j2EEGetSharedTableInfo() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetSharedTableInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void j2EEEnableDbgSession(java.lang.String processname, java.lang.String flags, java.lang.String client, javax.xml.rpc.holders.StringHolder key, javax.xml.rpc.holders.IntHolder port) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEEnableDbgSession"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {processname, flags, client});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                key.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "key"));
            } catch (java.lang.Exception _exception) {
                key.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "key")), java.lang.String.class);
            }
            try {
                port.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "port"))).intValue();
            } catch (java.lang.Exception _exception) {
                port.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "port")), int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void j2EEDisableDbgSession(java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEDisableDbgSession"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void j2EEGetThreadCallStack(int index, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetThreadCallStack"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(index)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                name.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "name"));
            } catch (java.lang.Exception _exception) {
                name.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "name")), java.lang.String.class);
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void j2EEGetThreadTaskStack(int index, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "J2EEGetThreadTaskStack"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(index)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                name.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "name"));
            } catch (java.lang.Exception _exception) {
                name.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "name")), java.lang.String.class);
            }
            try {
                lines.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("", "lines"));
            } catch (java.lang.Exception _exception) {
                lines.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lines")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[] ICMGetThreadList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ICMGetThreadList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[] ICMGetConnectionList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ICMGetConnectionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[] ICMGetCacheEntries() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ICMGetCacheEntries"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[] ICMGetProxyConnectionList() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "ICMGetProxyConnectionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[] enqGetLockTable() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "EnqGetLockTable"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void enqRemoveLocks(com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[] lock) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "EnqRemoveLocks"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {lock});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void enqGetStatistic(javax.xml.rpc.holders.IntHolder ownerNow, javax.xml.rpc.holders.IntHolder ownerHigh, javax.xml.rpc.holders.IntHolder ownerMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder ownerState, javax.xml.rpc.holders.IntHolder argumentsNow, javax.xml.rpc.holders.IntHolder argumentsHigh, javax.xml.rpc.holders.IntHolder argumentsMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder argumentsState, javax.xml.rpc.holders.IntHolder locksNow, javax.xml.rpc.holders.IntHolder locksHigh, javax.xml.rpc.holders.IntHolder locksMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder locksState, javax.xml.rpc.holders.LongHolder enqueueRequests, javax.xml.rpc.holders.LongHolder enqueueRejects, javax.xml.rpc.holders.LongHolder enqueueErrors, javax.xml.rpc.holders.LongHolder dequeueRequests, javax.xml.rpc.holders.LongHolder dequeueErrors, javax.xml.rpc.holders.LongHolder dequeueAllRequests, javax.xml.rpc.holders.LongHolder cleanupRequests, javax.xml.rpc.holders.LongHolder backupRequests, javax.xml.rpc.holders.LongHolder reportingRequests, javax.xml.rpc.holders.LongHolder compressRequests, javax.xml.rpc.holders.LongHolder verifyRequests, javax.xml.rpc.holders.DoubleHolder lockTime, javax.xml.rpc.holders.DoubleHolder lockWaitTime, javax.xml.rpc.holders.DoubleHolder serverTime, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder replicationState) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:SAPControl", "EnqGetStatistic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                ownerNow.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "owner-now"))).intValue();
            } catch (java.lang.Exception _exception) {
                ownerNow.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "owner-now")), int.class)).intValue();
            }
            try {
                ownerHigh.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "owner-high"))).intValue();
            } catch (java.lang.Exception _exception) {
                ownerHigh.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "owner-high")), int.class)).intValue();
            }
            try {
                ownerMax.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "owner-max"))).intValue();
            } catch (java.lang.Exception _exception) {
                ownerMax.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "owner-max")), int.class)).intValue();
            }
            try {
                ownerState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) _output.get(new javax.xml.namespace.QName("", "owner-state"));
            } catch (java.lang.Exception _exception) {
                ownerState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "owner-state")), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class);
            }
            try {
                argumentsNow.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "arguments-now"))).intValue();
            } catch (java.lang.Exception _exception) {
                argumentsNow.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "arguments-now")), int.class)).intValue();
            }
            try {
                argumentsHigh.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "arguments-high"))).intValue();
            } catch (java.lang.Exception _exception) {
                argumentsHigh.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "arguments-high")), int.class)).intValue();
            }
            try {
                argumentsMax.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "arguments-max"))).intValue();
            } catch (java.lang.Exception _exception) {
                argumentsMax.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "arguments-max")), int.class)).intValue();
            }
            try {
                argumentsState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) _output.get(new javax.xml.namespace.QName("", "arguments-state"));
            } catch (java.lang.Exception _exception) {
                argumentsState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "arguments-state")), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class);
            }
            try {
                locksNow.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "locks-now"))).intValue();
            } catch (java.lang.Exception _exception) {
                locksNow.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "locks-now")), int.class)).intValue();
            }
            try {
                locksHigh.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "locks-high"))).intValue();
            } catch (java.lang.Exception _exception) {
                locksHigh.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "locks-high")), int.class)).intValue();
            }
            try {
                locksMax.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "locks-max"))).intValue();
            } catch (java.lang.Exception _exception) {
                locksMax.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "locks-max")), int.class)).intValue();
            }
            try {
                locksState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) _output.get(new javax.xml.namespace.QName("", "locks-state"));
            } catch (java.lang.Exception _exception) {
                locksState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "locks-state")), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class);
            }
            try {
                enqueueRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "enqueue-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                enqueueRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "enqueue-requests")), long.class)).longValue();
            }
            try {
                enqueueRejects.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "enqueue-rejects"))).longValue();
            } catch (java.lang.Exception _exception) {
                enqueueRejects.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "enqueue-rejects")), long.class)).longValue();
            }
            try {
                enqueueErrors.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "enqueue-errors"))).longValue();
            } catch (java.lang.Exception _exception) {
                enqueueErrors.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "enqueue-errors")), long.class)).longValue();
            }
            try {
                dequeueRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "dequeue-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                dequeueRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "dequeue-requests")), long.class)).longValue();
            }
            try {
                dequeueErrors.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "dequeue-errors"))).longValue();
            } catch (java.lang.Exception _exception) {
                dequeueErrors.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "dequeue-errors")), long.class)).longValue();
            }
            try {
                dequeueAllRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "dequeue-all-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                dequeueAllRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "dequeue-all-requests")), long.class)).longValue();
            }
            try {
                cleanupRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "cleanup-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                cleanupRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "cleanup-requests")), long.class)).longValue();
            }
            try {
                backupRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "backup-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                backupRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "backup-requests")), long.class)).longValue();
            }
            try {
                reportingRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "reporting-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                reportingRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "reporting-requests")), long.class)).longValue();
            }
            try {
                compressRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "compress-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                compressRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "compress-requests")), long.class)).longValue();
            }
            try {
                verifyRequests.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "verify-requests"))).longValue();
            } catch (java.lang.Exception _exception) {
                verifyRequests.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "verify-requests")), long.class)).longValue();
            }
            try {
                lockTime.value = ((java.lang.Double) _output.get(new javax.xml.namespace.QName("", "lock-time"))).doubleValue();
            } catch (java.lang.Exception _exception) {
                lockTime.value = ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lock-time")), double.class)).doubleValue();
            }
            try {
                lockWaitTime.value = ((java.lang.Double) _output.get(new javax.xml.namespace.QName("", "lock-wait-time"))).doubleValue();
            } catch (java.lang.Exception _exception) {
                lockWaitTime.value = ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "lock-wait-time")), double.class)).doubleValue();
            }
            try {
                serverTime.value = ((java.lang.Double) _output.get(new javax.xml.namespace.QName("", "server-time"))).doubleValue();
            } catch (java.lang.Exception _exception) {
                serverTime.value = ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "server-time")), double.class)).doubleValue();
            }
            try {
                replicationState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) _output.get(new javax.xml.namespace.QName("", "replication-state"));
            } catch (java.lang.Exception _exception) {
                replicationState.value = (com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "replication-state")), com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
