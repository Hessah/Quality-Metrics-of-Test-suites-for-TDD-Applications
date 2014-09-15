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
 * OSProcess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class OSProcess  implements java.io.Serializable {
    private java.lang.String name;
    private java.lang.String description;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;
    private java.lang.String textstatus;
    private java.lang.String starttime;
    private java.lang.String elapsedtime;
    private int pid;

    public OSProcess() {
    }

    public OSProcess(
           java.lang.String name,
           java.lang.String description,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus,
           java.lang.String textstatus,
           java.lang.String starttime,
           java.lang.String elapsedtime,
           int pid) {
           this.name = name;
           this.description = description;
           this.dispstatus = dispstatus;
           this.textstatus = textstatus;
           this.starttime = starttime;
           this.elapsedtime = elapsedtime;
           this.pid = pid;
    }


    /**
     * Gets the name value for this OSProcess.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this OSProcess.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this OSProcess.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this OSProcess.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the dispstatus value for this OSProcess.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this OSProcess.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }


    /**
     * Gets the textstatus value for this OSProcess.
     * 
     * @return textstatus
     */
    public java.lang.String getTextstatus() {
        return textstatus;
    }


    /**
     * Sets the textstatus value for this OSProcess.
     * 
     * @param textstatus
     */
    public void setTextstatus(java.lang.String textstatus) {
        this.textstatus = textstatus;
    }


    /**
     * Gets the starttime value for this OSProcess.
     * 
     * @return starttime
     */
    public java.lang.String getStarttime() {
        return starttime;
    }


    /**
     * Sets the starttime value for this OSProcess.
     * 
     * @param starttime
     */
    public void setStarttime(java.lang.String starttime) {
        this.starttime = starttime;
    }


    /**
     * Gets the elapsedtime value for this OSProcess.
     * 
     * @return elapsedtime
     */
    public java.lang.String getElapsedtime() {
        return elapsedtime;
    }


    /**
     * Sets the elapsedtime value for this OSProcess.
     * 
     * @param elapsedtime
     */
    public void setElapsedtime(java.lang.String elapsedtime) {
        this.elapsedtime = elapsedtime;
    }


    /**
     * Gets the pid value for this OSProcess.
     * 
     * @return pid
     */
    public int getPid() {
        return pid;
    }


    /**
     * Sets the pid value for this OSProcess.
     * 
     * @param pid
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OSProcess)) return false;
        OSProcess other = (OSProcess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.dispstatus==null && other.getDispstatus()==null) || 
             (this.dispstatus!=null &&
              this.dispstatus.equals(other.getDispstatus()))) &&
            ((this.textstatus==null && other.getTextstatus()==null) || 
             (this.textstatus!=null &&
              this.textstatus.equals(other.getTextstatus()))) &&
            ((this.starttime==null && other.getStarttime()==null) || 
             (this.starttime!=null &&
              this.starttime.equals(other.getStarttime()))) &&
            ((this.elapsedtime==null && other.getElapsedtime()==null) || 
             (this.elapsedtime!=null &&
              this.elapsedtime.equals(other.getElapsedtime()))) &&
            this.pid == other.getPid();
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        if (getTextstatus() != null) {
            _hashCode += getTextstatus().hashCode();
        }
        if (getStarttime() != null) {
            _hashCode += getStarttime().hashCode();
        }
        if (getElapsedtime() != null) {
            _hashCode += getElapsedtime().hashCode();
        }
        _hashCode += getPid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OSProcess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "OSProcess"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "textstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("starttime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "starttime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elapsedtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elapsedtime"));
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
