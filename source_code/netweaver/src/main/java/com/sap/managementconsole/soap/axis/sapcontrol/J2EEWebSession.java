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
 * J2EEWebSession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEWebSession  implements java.io.Serializable {
    private java.lang.String processname;
    private int idHash;
    private int size;
    private int timeout;
    private int activeRequests;
    private java.lang.String startTime;
    private java.lang.String updateTime;
    private java.lang.String state;
    private java.lang.String backingStore;
    private java.lang.String user;

    public J2EEWebSession() {
    }

    public J2EEWebSession(
           java.lang.String processname,
           int idHash,
           int size,
           int timeout,
           int activeRequests,
           java.lang.String startTime,
           java.lang.String updateTime,
           java.lang.String state,
           java.lang.String backingStore,
           java.lang.String user) {
           this.processname = processname;
           this.idHash = idHash;
           this.size = size;
           this.timeout = timeout;
           this.activeRequests = activeRequests;
           this.startTime = startTime;
           this.updateTime = updateTime;
           this.state = state;
           this.backingStore = backingStore;
           this.user = user;
    }


    /**
     * Gets the processname value for this J2EEWebSession.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EEWebSession.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the idHash value for this J2EEWebSession.
     * 
     * @return idHash
     */
    public int getIdHash() {
        return idHash;
    }


    /**
     * Sets the idHash value for this J2EEWebSession.
     * 
     * @param idHash
     */
    public void setIdHash(int idHash) {
        this.idHash = idHash;
    }


    /**
     * Gets the size value for this J2EEWebSession.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this J2EEWebSession.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Gets the timeout value for this J2EEWebSession.
     * 
     * @return timeout
     */
    public int getTimeout() {
        return timeout;
    }


    /**
     * Sets the timeout value for this J2EEWebSession.
     * 
     * @param timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }


    /**
     * Gets the activeRequests value for this J2EEWebSession.
     * 
     * @return activeRequests
     */
    public int getActiveRequests() {
        return activeRequests;
    }


    /**
     * Sets the activeRequests value for this J2EEWebSession.
     * 
     * @param activeRequests
     */
    public void setActiveRequests(int activeRequests) {
        this.activeRequests = activeRequests;
    }


    /**
     * Gets the startTime value for this J2EEWebSession.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this J2EEWebSession.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the updateTime value for this J2EEWebSession.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EEWebSession.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the state value for this J2EEWebSession.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this J2EEWebSession.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the backingStore value for this J2EEWebSession.
     * 
     * @return backingStore
     */
    public java.lang.String getBackingStore() {
        return backingStore;
    }


    /**
     * Sets the backingStore value for this J2EEWebSession.
     * 
     * @param backingStore
     */
    public void setBackingStore(java.lang.String backingStore) {
        this.backingStore = backingStore;
    }


    /**
     * Gets the user value for this J2EEWebSession.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this J2EEWebSession.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEWebSession)) return false;
        J2EEWebSession other = (J2EEWebSession) obj;
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
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.backingStore==null && other.getBackingStore()==null) || 
             (this.backingStore!=null &&
              this.backingStore.equals(other.getBackingStore()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser())));
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
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getBackingStore() != null) {
            _hashCode += getBackingStore().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEWebSession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEWebSession"));
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
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
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
