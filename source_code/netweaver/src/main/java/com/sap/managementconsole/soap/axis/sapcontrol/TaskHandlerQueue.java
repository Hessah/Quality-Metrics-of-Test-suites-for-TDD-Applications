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
 * TaskHandlerQueue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class TaskHandlerQueue  implements java.io.Serializable {
    private java.lang.String typ;
    private int now;
    private int high;
    private int max;
    private int writes;
    private int reads;

    public TaskHandlerQueue() {
    }

    public TaskHandlerQueue(
           java.lang.String typ,
           int now,
           int high,
           int max,
           int writes,
           int reads) {
           this.typ = typ;
           this.now = now;
           this.high = high;
           this.max = max;
           this.writes = writes;
           this.reads = reads;
    }


    /**
     * Gets the typ value for this TaskHandlerQueue.
     * 
     * @return typ
     */
    public java.lang.String getTyp() {
        return typ;
    }


    /**
     * Sets the typ value for this TaskHandlerQueue.
     * 
     * @param typ
     */
    public void setTyp(java.lang.String typ) {
        this.typ = typ;
    }


    /**
     * Gets the now value for this TaskHandlerQueue.
     * 
     * @return now
     */
    public int getNow() {
        return now;
    }


    /**
     * Sets the now value for this TaskHandlerQueue.
     * 
     * @param now
     */
    public void setNow(int now) {
        this.now = now;
    }


    /**
     * Gets the high value for this TaskHandlerQueue.
     * 
     * @return high
     */
    public int getHigh() {
        return high;
    }


    /**
     * Sets the high value for this TaskHandlerQueue.
     * 
     * @param high
     */
    public void setHigh(int high) {
        this.high = high;
    }


    /**
     * Gets the max value for this TaskHandlerQueue.
     * 
     * @return max
     */
    public int getMax() {
        return max;
    }


    /**
     * Sets the max value for this TaskHandlerQueue.
     * 
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }


    /**
     * Gets the writes value for this TaskHandlerQueue.
     * 
     * @return writes
     */
    public int getWrites() {
        return writes;
    }


    /**
     * Sets the writes value for this TaskHandlerQueue.
     * 
     * @param writes
     */
    public void setWrites(int writes) {
        this.writes = writes;
    }


    /**
     * Gets the reads value for this TaskHandlerQueue.
     * 
     * @return reads
     */
    public int getReads() {
        return reads;
    }


    /**
     * Sets the reads value for this TaskHandlerQueue.
     * 
     * @param reads
     */
    public void setReads(int reads) {
        this.reads = reads;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaskHandlerQueue)) return false;
        TaskHandlerQueue other = (TaskHandlerQueue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.typ==null && other.getTyp()==null) || 
             (this.typ!=null &&
              this.typ.equals(other.getTyp()))) &&
            this.now == other.getNow() &&
            this.high == other.getHigh() &&
            this.max == other.getMax() &&
            this.writes == other.getWrites() &&
            this.reads == other.getReads();
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
        if (getTyp() != null) {
            _hashCode += getTyp().hashCode();
        }
        _hashCode += getNow();
        _hashCode += getHigh();
        _hashCode += getMax();
        _hashCode += getWrites();
        _hashCode += getReads();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TaskHandlerQueue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "TaskHandlerQueue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Typ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("now");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Now"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("high");
        elemField.setXmlName(new javax.xml.namespace.QName("", "High"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("max");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Max"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("writes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Writes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reads");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Reads"));
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
