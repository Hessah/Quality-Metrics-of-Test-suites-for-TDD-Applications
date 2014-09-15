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
 * HeapInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class HeapInfo  implements java.io.Serializable {
    private java.lang.String processname;
    private java.lang.String type;
    private long size;
    private long commitSize;
    private long maxUsedSize;
    private long initialSize;
    private long maxSize;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus;

    public HeapInfo() {
    }

    public HeapInfo(
           java.lang.String processname,
           java.lang.String type,
           long size,
           long commitSize,
           long maxUsedSize,
           long initialSize,
           long maxSize,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
           this.processname = processname;
           this.type = type;
           this.size = size;
           this.commitSize = commitSize;
           this.maxUsedSize = maxUsedSize;
           this.initialSize = initialSize;
           this.maxSize = maxSize;
           this.dispstatus = dispstatus;
    }


    /**
     * Gets the processname value for this HeapInfo.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this HeapInfo.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the type value for this HeapInfo.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this HeapInfo.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the size value for this HeapInfo.
     * 
     * @return size
     */
    public long getSize() {
        return size;
    }


    /**
     * Sets the size value for this HeapInfo.
     * 
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }


    /**
     * Gets the commitSize value for this HeapInfo.
     * 
     * @return commitSize
     */
    public long getCommitSize() {
        return commitSize;
    }


    /**
     * Sets the commitSize value for this HeapInfo.
     * 
     * @param commitSize
     */
    public void setCommitSize(long commitSize) {
        this.commitSize = commitSize;
    }


    /**
     * Gets the maxUsedSize value for this HeapInfo.
     * 
     * @return maxUsedSize
     */
    public long getMaxUsedSize() {
        return maxUsedSize;
    }


    /**
     * Sets the maxUsedSize value for this HeapInfo.
     * 
     * @param maxUsedSize
     */
    public void setMaxUsedSize(long maxUsedSize) {
        this.maxUsedSize = maxUsedSize;
    }


    /**
     * Gets the initialSize value for this HeapInfo.
     * 
     * @return initialSize
     */
    public long getInitialSize() {
        return initialSize;
    }


    /**
     * Sets the initialSize value for this HeapInfo.
     * 
     * @param initialSize
     */
    public void setInitialSize(long initialSize) {
        this.initialSize = initialSize;
    }


    /**
     * Gets the maxSize value for this HeapInfo.
     * 
     * @return maxSize
     */
    public long getMaxSize() {
        return maxSize;
    }


    /**
     * Sets the maxSize value for this HeapInfo.
     * 
     * @param maxSize
     */
    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }


    /**
     * Gets the dispstatus value for this HeapInfo.
     * 
     * @return dispstatus
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getDispstatus() {
        return dispstatus;
    }


    /**
     * Sets the dispstatus value for this HeapInfo.
     * 
     * @param dispstatus
     */
    public void setDispstatus(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR dispstatus) {
        this.dispstatus = dispstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HeapInfo)) return false;
        HeapInfo other = (HeapInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.processname==null && other.getProcessname()==null) || 
             (this.processname!=null &&
              this.processname.equals(other.getProcessname()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.size == other.getSize() &&
            this.commitSize == other.getCommitSize() &&
            this.maxUsedSize == other.getMaxUsedSize() &&
            this.initialSize == other.getInitialSize() &&
            this.maxSize == other.getMaxSize() &&
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
        if (getProcessname() != null) {
            _hashCode += getProcessname().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += new Long(getSize()).hashCode();
        _hashCode += new Long(getCommitSize()).hashCode();
        _hashCode += new Long(getMaxUsedSize()).hashCode();
        _hashCode += new Long(getInitialSize()).hashCode();
        _hashCode += new Long(getMaxSize()).hashCode();
        if (getDispstatus() != null) {
            _hashCode += getDispstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HeapInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "HeapInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commitSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commitSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxUsedSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxUsedSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initialSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "initialSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
