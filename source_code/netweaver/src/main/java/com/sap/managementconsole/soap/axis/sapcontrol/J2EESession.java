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
 * J2EESession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EESession  implements java.io.Serializable {
    private java.lang.String processname;
    private int idHash;
    private int size;
    private int timeout;
    private int activeRequests;
    private java.lang.String startTime;
    private java.lang.String updateTime;
    private java.lang.String sticky;
    private java.lang.String corrupt;
    private java.lang.String backingStore;

    public J2EESession() {
    }

    public J2EESession(
           java.lang.String processname,
           int idHash,
           int size,
           int timeout,
           int activeRequests,
           java.lang.String startTime,
           java.lang.String updateTime,
           java.lang.String sticky,
           java.lang.String corrupt,
           java.lang.String backingStore) {
           this.processname = processname;
           this.idHash = idHash;
           this.size = size;
           this.timeout = timeout;
           this.activeRequests = activeRequests;
           this.startTime = startTime;
           this.updateTime = updateTime;
           this.sticky = sticky;
           this.corrupt = corrupt;
           this.backingStore = backingStore;
    }


    /**
     * Gets the processname value for this J2EESession.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EESession.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the idHash value for this J2EESession.
     * 
     * @return idHash
     */
    public int getIdHash() {
        return idHash;
    }


    /**
     * Sets the idHash value for this J2EESession.
     * 
     * @param idHash
     */
    public void setIdHash(int idHash) {
        this.idHash = idHash;
    }


    /**
     * Gets the size value for this J2EESession.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this J2EESession.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Gets the timeout value for this J2EESession.
     * 
     * @return timeout
     */
    public int getTimeout() {
        return timeout;
    }


    /**
     * Sets the timeout value for this J2EESession.
     * 
     * @param timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }


    /**
     * Gets the activeRequests value for this J2EESession.
     * 
     * @return activeRequests
     */
    public int getActiveRequests() {
        return activeRequests;
    }


    /**
     * Sets the activeRequests value for this J2EESession.
     * 
     * @param activeRequests
     */
    public void setActiveRequests(int activeRequests) {
        this.activeRequests = activeRequests;
    }


    /**
     * Gets the startTime value for this J2EESession.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this J2EESession.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the updateTime value for this J2EESession.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EESession.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the sticky value for this J2EESession.
     * 
     * @return sticky
     */
    public java.lang.String getSticky() {
        return sticky;
    }


    /**
     * Sets the sticky value for this J2EESession.
     * 
     * @param sticky
     */
    public void setSticky(java.lang.String sticky) {
        this.sticky = sticky;
    }


    /**
     * Gets the corrupt value for this J2EESession.
     * 
     * @return corrupt
     */
    public java.lang.String getCorrupt() {
        return corrupt;
    }


    /**
     * Sets the corrupt value for this J2EESession.
     * 
     * @param corrupt
     */
    public void setCorrupt(java.lang.String corrupt) {
        this.corrupt = corrupt;
    }


    /**
     * Gets the backingStore value for this J2EESession.
     * 
     * @return backingStore
     */
    public java.lang.String getBackingStore() {
        return backingStore;
    }


    /**
     * Sets the backingStore value for this J2EESession.
     * 
     * @param backingStore
     */
    public void setBackingStore(java.lang.String backingStore) {
        this.backingStore = backingStore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EESession)) return false;
        J2EESession other = (J2EESession) obj;
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
            this.idHash == other.getIdHash() &&
            this.size == other.getSize() &&
            this.timeout == other.getTimeout() &&
            this.activeRequests == other.getActiveRequests() &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            ((this.updateTime==null && other.getUpdateTime()==null) || 
             (this.updateTime!=null &&
              this.updateTime.equals(other.getUpdateTime()))) &&
            ((this.sticky==null && other.getSticky()==null) || 
             (this.sticky!=null &&
              this.sticky.equals(other.getSticky()))) &&
            ((this.corrupt==null && other.getCorrupt()==null) || 
             (this.corrupt!=null &&
              this.corrupt.equals(other.getCorrupt()))) &&
            ((this.backingStore==null && other.getBackingStore()==null) || 
             (this.backingStore!=null &&
              this.backingStore.equals(other.getBackingStore())));
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
        _hashCode += getIdHash();
        _hashCode += getSize();
        _hashCode += getTimeout();
        _hashCode += getActiveRequests();
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        if (getUpdateTime() != null) {
            _hashCode += getUpdateTime().hashCode();
        }
        if (getSticky() != null) {
            _hashCode += getSticky().hashCode();
        }
        if (getCorrupt() != null) {
            _hashCode += getCorrupt().hashCode();
        }
        if (getBackingStore() != null) {
            _hashCode += getBackingStore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EESession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EESession"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idHash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IdHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeRequests");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeRequests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sticky");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sticky"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corrupt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corrupt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backingStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "backingStore"));
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
