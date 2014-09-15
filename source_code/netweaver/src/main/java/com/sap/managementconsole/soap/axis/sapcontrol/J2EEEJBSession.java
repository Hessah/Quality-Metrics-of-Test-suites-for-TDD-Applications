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
 * J2EEEJBSession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEEJBSession  implements java.io.Serializable {
    private int idHash;
    private java.lang.String state;
    private int size;
    private int activeRequests;
    private int totalRequests;
    private java.lang.String backingStore;
    private java.lang.String processname;
    private java.lang.String startTime;
    private java.lang.String updateTime;
    private int responseTime;
    private java.lang.String user;
    private java.lang.String transaction;
    private java.lang.String ejb;
    private java.lang.String application;
    private java.lang.String reference;

    public J2EEEJBSession() {
    }

    public J2EEEJBSession(
           int idHash,
           java.lang.String state,
           int size,
           int activeRequests,
           int totalRequests,
           java.lang.String backingStore,
           java.lang.String processname,
           java.lang.String startTime,
           java.lang.String updateTime,
           int responseTime,
           java.lang.String user,
           java.lang.String transaction,
           java.lang.String ejb,
           java.lang.String application,
           java.lang.String reference) {
           this.idHash = idHash;
           this.state = state;
           this.size = size;
           this.activeRequests = activeRequests;
           this.totalRequests = totalRequests;
           this.backingStore = backingStore;
           this.processname = processname;
           this.startTime = startTime;
           this.updateTime = updateTime;
           this.responseTime = responseTime;
           this.user = user;
           this.transaction = transaction;
           this.ejb = ejb;
           this.application = application;
           this.reference = reference;
    }


    /**
     * Gets the idHash value for this J2EEEJBSession.
     * 
     * @return idHash
     */
    public int getIdHash() {
        return idHash;
    }


    /**
     * Sets the idHash value for this J2EEEJBSession.
     * 
     * @param idHash
     */
    public void setIdHash(int idHash) {
        this.idHash = idHash;
    }


    /**
     * Gets the state value for this J2EEEJBSession.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this J2EEEJBSession.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the size value for this J2EEEJBSession.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this J2EEEJBSession.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Gets the activeRequests value for this J2EEEJBSession.
     * 
     * @return activeRequests
     */
    public int getActiveRequests() {
        return activeRequests;
    }


    /**
     * Sets the activeRequests value for this J2EEEJBSession.
     * 
     * @param activeRequests
     */
    public void setActiveRequests(int activeRequests) {
        this.activeRequests = activeRequests;
    }


    /**
     * Gets the totalRequests value for this J2EEEJBSession.
     * 
     * @return totalRequests
     */
    public int getTotalRequests() {
        return totalRequests;
    }


    /**
     * Sets the totalRequests value for this J2EEEJBSession.
     * 
     * @param totalRequests
     */
    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }


    /**
     * Gets the backingStore value for this J2EEEJBSession.
     * 
     * @return backingStore
     */
    public java.lang.String getBackingStore() {
        return backingStore;
    }


    /**
     * Sets the backingStore value for this J2EEEJBSession.
     * 
     * @param backingStore
     */
    public void setBackingStore(java.lang.String backingStore) {
        this.backingStore = backingStore;
    }


    /**
     * Gets the processname value for this J2EEEJBSession.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EEEJBSession.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }


    /**
     * Gets the startTime value for this J2EEEJBSession.
     * 
     * @return startTime
     */
    public java.lang.String getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this J2EEEJBSession.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the updateTime value for this J2EEEJBSession.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EEEJBSession.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the responseTime value for this J2EEEJBSession.
     * 
     * @return responseTime
     */
    public int getResponseTime() {
        return responseTime;
    }


    /**
     * Sets the responseTime value for this J2EEEJBSession.
     * 
     * @param responseTime
     */
    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }


    /**
     * Gets the user value for this J2EEEJBSession.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this J2EEEJBSession.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the transaction value for this J2EEEJBSession.
     * 
     * @return transaction
     */
    public java.lang.String getTransaction() {
        return transaction;
    }


    /**
     * Sets the transaction value for this J2EEEJBSession.
     * 
     * @param transaction
     */
    public void setTransaction(java.lang.String transaction) {
        this.transaction = transaction;
    }


    /**
     * Gets the ejb value for this J2EEEJBSession.
     * 
     * @return ejb
     */
    public java.lang.String getEjb() {
        return ejb;
    }


    /**
     * Sets the ejb value for this J2EEEJBSession.
     * 
     * @param ejb
     */
    public void setEjb(java.lang.String ejb) {
        this.ejb = ejb;
    }


    /**
     * Gets the application value for this J2EEEJBSession.
     * 
     * @return application
     */
    public java.lang.String getApplication() {
        return application;
    }


    /**
     * Sets the application value for this J2EEEJBSession.
     * 
     * @param application
     */
    public void setApplication(java.lang.String application) {
        this.application = application;
    }


    /**
     * Gets the reference value for this J2EEEJBSession.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this J2EEEJBSession.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEEJBSession)) return false;
        J2EEEJBSession other = (J2EEEJBSession) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idHash == other.getIdHash() &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            this.size == other.getSize() &&
            this.activeRequests == other.getActiveRequests() &&
            this.totalRequests == other.getTotalRequests() &&
            ((this.backingStore==null && other.getBackingStore()==null) || 
             (this.backingStore!=null &&
              this.backingStore.equals(other.getBackingStore()))) &&
            ((this.processname==null && other.getProcessname()==null) || 
             (this.processname!=null &&
              this.processname.equals(other.getProcessname()))) &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            ((this.updateTime==null && other.getUpdateTime()==null) || 
             (this.updateTime!=null &&
              this.updateTime.equals(other.getUpdateTime()))) &&
            this.responseTime == other.getResponseTime() &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.transaction==null && other.getTransaction()==null) || 
             (this.transaction!=null &&
              this.transaction.equals(other.getTransaction()))) &&
            ((this.ejb==null && other.getEjb()==null) || 
             (this.ejb!=null &&
              this.ejb.equals(other.getEjb()))) &&
            ((this.application==null && other.getApplication()==null) || 
             (this.application!=null &&
              this.application.equals(other.getApplication()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference())));
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
        _hashCode += getIdHash();
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        _hashCode += getSize();
        _hashCode += getActiveRequests();
        _hashCode += getTotalRequests();
        if (getBackingStore() != null) {
            _hashCode += getBackingStore().hashCode();
        }
        if (getProcessname() != null) {
            _hashCode += getProcessname().hashCode();
        }
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        if (getUpdateTime() != null) {
            _hashCode += getUpdateTime().hashCode();
        }
        _hashCode += getResponseTime();
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getTransaction() != null) {
            _hashCode += getTransaction().hashCode();
        }
        if (getEjb() != null) {
            _hashCode += getEjb().hashCode();
        }
        if (getApplication() != null) {
            _hashCode += getApplication().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEEJBSession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEEJBSession"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idHash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IdHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("", "size"));
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
        elemField.setFieldName("totalRequests");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalRequests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backingStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "backingStore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
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
        elemField.setFieldName("updateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaction");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transaction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ejb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ejb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("application");
        elemField.setXmlName(new javax.xml.namespace.QName("", "application"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
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
