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
 * J2EEProcess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEProcess  implements java.io.Serializable {
    private int telnetPort;
    private java.lang.String name;
    private int pid;
    private java.lang.String type;
    private java.lang.String restart;
    private java.lang.String exitCode;
    private com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE state;
    private java.lang.String statetext;
    private java.lang.String startTime;
    private java.lang.String elapsedTime;
    private int restartCount;
    private int errorCount;
    private java.lang.String cpu;
    private java.lang.String debug;

    public J2EEProcess() {
    }

    public J2EEProcess(
           int telnetPort,
           java.lang.String name,
           int pid,
           java.lang.String type,
           java.lang.String restart,
           java.lang.String exitCode,
           com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE state,
           java.lang.String statetext,
           java.lang.String startTime,
           java.lang.String elapsedTime,
           int restartCount,
           int errorCount,
           java.lang.String cpu,
           java.lang.String debug) {
           this.telnetPort = telnetPort;
           this.name = name;
           this.pid = pid;
           this.type = type;
           this.restart = restart;
           this.exitCode = exitCode;
           this.state = state;
           this.statetext = statetext;
           this.startTime = startTime;
           this.elapsedTime = elapsedTime;
           this.restartCount = restartCount;
           this.errorCount = errorCount;
           this.cpu = cpu;
           this.debug = debug;
    }


    /**
     * Gets the telnetPort value for this J2EEProcess.
     * 
     * @return telnetPort
     */
    public int getTelnetPort() {
        return telnetPort;
    }


    /**
     * Sets the telnetPort value for this J2EEProcess.
     * 
     * @param telnetPort
     */
    public void setTelnetPort(int telnetPort) {
        this.telnetPort = telnetPort;
    }


    /**
     * Gets the name value for this J2EEProcess.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this J2EEProcess.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the pid value for this J2EEProcess.
     * 
     * @return pid
     */
    public int getPid() {
        return pid;
    }


    /**
     * Sets the pid value for this J2EEProcess.
     * 
     * @param pid
     */
    public void setPid(int pid) {
        this.pid = pid;
    }


    /**
     * Gets the type value for this J2EEProcess.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this J2EEProcess.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the restart value for this J2EEProcess.
     * 
     * @return restart
     */
    public java.lang.String getRestart() {
        return restart;
    }


    /**
     * Sets the restart value for this J2EEProcess.
     * 
     * @param restart
     */
    public void setRestart(java.lang.String restart) {
        this.restart = restart;
    }


    /**
     * Gets the exitCode value for this J2EEProcess.
     * 
     * @return exitCode
     */
    public java.lang.String getExitCode() {
        return exitCode;
    }


    /**
     * Sets the exitCode value for this J2EEProcess.
     * 
     * @param exitCode
     */
    public void setExitCode(java.lang.String exitCode) {
        this.exitCode = exitCode;
    }


    /**
     * Gets the state value for this J2EEProcess.
     * 
     * @return state
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE getState() {
        return state;
    }


    /**
     * Sets the state value for this J2EEProcess.
     * 
     * @param state
     */
    public void setState(com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE state) {
        this.state = state;
    }


    /**
     * Gets the statetext value for this J2EEProcess.
     * 
     * @return statetext
     */
    public java.lang.String getStatetext() {
        return statetext;
    }


    /**
     * Sets the statetext value for this J2EEProcess.
     * 
     * @param statetext
     */
    public void setStatetext(java.lang.String statetext) {
        this.statetext = statetext;
    }


    /**
     * Gets the startTime value for this J2EEProcess.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this J2EEProcess.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the elapsedTime value for this J2EEProcess.
     * 
     * @return elapsedTime
     */
    public java.lang.String getElapsedTime() {
        return elapsedTime;
    }


    /**
     * Sets the elapsedTime value for this J2EEProcess.
     * 
     * @param elapsedTime
     */
    public void setElapsedTime(java.lang.String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }


    /**
     * Gets the restartCount value for this J2EEProcess.
     * 
     * @return restartCount
     */
    public int getRestartCount() {
        return restartCount;
    }


    /**
     * Sets the restartCount value for this J2EEProcess.
     * 
     * @param restartCount
     */
    public void setRestartCount(int restartCount) {
        this.restartCount = restartCount;
    }


    /**
     * Gets the errorCount value for this J2EEProcess.
     * 
     * @return errorCount
     */
    public int getErrorCount() {
        return errorCount;
    }


    /**
     * Sets the errorCount value for this J2EEProcess.
     * 
     * @param errorCount
     */
    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }


    /**
     * Gets the cpu value for this J2EEProcess.
     * 
     * @return cpu
     */
    public java.lang.String getCpu() {
        return cpu;
    }


    /**
     * Sets the cpu value for this J2EEProcess.
     * 
     * @param cpu
     */
    public void setCpu(java.lang.String cpu) {
        this.cpu = cpu;
    }


    /**
     * Gets the debug value for this J2EEProcess.
     * 
     * @return debug
     */
    public java.lang.String getDebug() {
        return debug;
    }


    /**
     * Sets the debug value for this J2EEProcess.
     * 
     * @param debug
     */
    public void setDebug(java.lang.String debug) {
        this.debug = debug;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEProcess)) return false;
        J2EEProcess other = (J2EEProcess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.telnetPort == other.getTelnetPort() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.pid == other.getPid() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.restart==null && other.getRestart()==null) || 
             (this.restart!=null &&
              this.restart.equals(other.getRestart()))) &&
            ((this.exitCode==null && other.getExitCode()==null) || 
             (this.exitCode!=null &&
              this.exitCode.equals(other.getExitCode()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.statetext==null && other.getStatetext()==null) || 
             (this.statetext!=null &&
              this.statetext.equals(other.getStatetext()))) &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            ((this.elapsedTime==null && other.getElapsedTime()==null) || 
             (this.elapsedTime!=null &&
              this.elapsedTime.equals(other.getElapsedTime()))) &&
            this.restartCount == other.getRestartCount() &&
            this.errorCount == other.getErrorCount() &&
            ((this.cpu==null && other.getCpu()==null) || 
             (this.cpu!=null &&
              this.cpu.equals(other.getCpu()))) &&
            ((this.debug==null && other.getDebug()==null) || 
             (this.debug!=null &&
              this.debug.equals(other.getDebug())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getTelnetPort();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getPid();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getRestart() != null) {
            _hashCode += getRestart().hashCode();
        }
        if (getExitCode() != null) {
            _hashCode += getExitCode().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getStatetext() != null) {
            _hashCode += getStatetext().hashCode();
        }
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        if (getElapsedTime() != null) {
            _hashCode += getElapsedTime().hashCode();
        }
        _hashCode += getRestartCount();
        _hashCode += getErrorCount();
        if (getCpu() != null) {
            _hashCode += getCpu().hashCode();
        }
        if (getDebug() != null) {
            _hashCode += getDebug().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEProcess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEProcess"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telnetPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telnetPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EE-PSTATE"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statetext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statetext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elapsedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elapsedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restartCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restartCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cpu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debug");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debug"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
