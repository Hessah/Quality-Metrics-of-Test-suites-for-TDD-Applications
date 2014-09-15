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
 * J2EESharedTableInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EESharedTableInfo  implements java.io.Serializable {
    private java.lang.String table;
    private int used;
    private int peak;
    private int limit;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public J2EESharedTableInfo() {
    }

    public J2EESharedTableInfo(
           java.lang.String table,
           int used,
           int peak,
           int limit,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.table = table;
           this.used = used;
           this.peak = peak;
           this.limit = limit;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the table value for this J2EESharedTableInfo.
     * 
     * @return table
     */
    public java.lang.String getTable() {
        return table;
    }


    /**
     * Sets the table value for this J2EESharedTableInfo.
     * 
     * @param table
     */
    public void setTable(java.lang.String table) {
        this.table = table;
    }


    /**
     * Gets the used value for this J2EESharedTableInfo.
     * 
     * @return used
     */
    public int getUsed() {
        return used;
    }


    /**
     * Sets the used value for this J2EESharedTableInfo.
     * 
     * @param used
     */
    public void setUsed(int used) {
        this.used = used;
    }


    /**
     * Gets the peak value for this J2EESharedTableInfo.
     * 
     * @return peak
     */
    public int getPeak() {
        return peak;
    }


    /**
     * Sets the peak value for this J2EESharedTableInfo.
     * 
     * @param peak
     */
    public void setPeak(int peak) {
        this.peak = peak;
    }


    /**
     * Gets the limit value for this J2EESharedTableInfo.
     * 
     * @return limit
     */
    public int getLimit() {
        return limit;
    }


    /**
     * Sets the limit value for this J2EESharedTableInfo.
     * 
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }


    /**
     * Gets the dispstatus value for this J2EESharedTableInfo.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this J2EESharedTableInfo.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EESharedTableInfo)) return false;
        J2EESharedTableInfo other = (J2EESharedTableInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.table==null && other.getTable()==null) || 
             (this.table!=null &&
              this.table.equals(other.getTable()))) &&
            this.used == other.getUsed() &&
            this.peak == other.getPeak() &&
            this.limit == other.getLimit() &&
            ((this.dispstatus==null && other.getDispstatus()==null) || 
             (this.dispstatus!=null &&
              this.dispstatus.equals(other.getDispstatus())));
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
        if (getTable() != null) {
            _hashCode += getTable().hashCode();
        }
        _hashCode += getUsed();
        _hashCode += getPeak();
        _hashCode += getLimit();
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EESharedTableInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EESharedTableInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table");
        elemField.setXmlName(new javax.xml.namespace.QName("", "table"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("used");
        elemField.setXmlName(new javax.xml.namespace.QName("", "used"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peak");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peak"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
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
