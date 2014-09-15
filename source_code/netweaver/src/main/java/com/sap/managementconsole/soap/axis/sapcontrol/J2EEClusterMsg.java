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
 * J2EEClusterMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EEClusterMsg  implements java.io.Serializable {
    private java.lang.String service;
    private java.lang.String id;
    private long count;
    private long length;
    private long avgLength;
    private long maxLength;
    private long countP2PMsg;
    private long countP2PRequest;
    private long countP2PReply;
    private long countBroadcastMsg;
    private long countBroadcastRequest;

    public J2EEClusterMsg() {
    }

    public J2EEClusterMsg(
           java.lang.String service,
           java.lang.String id,
           long count,
           long length,
           long avgLength,
           long maxLength,
           long countP2PMsg,
           long countP2PRequest,
           long countP2PReply,
           long countBroadcastMsg,
           long countBroadcastRequest) {
           this.service = service;
           this.id = id;
           this.count = count;
           this.length = length;
           this.avgLength = avgLength;
           this.maxLength = maxLength;
           this.countP2PMsg = countP2PMsg;
           this.countP2PRequest = countP2PRequest;
           this.countP2PReply = countP2PReply;
           this.countBroadcastMsg = countBroadcastMsg;
           this.countBroadcastRequest = countBroadcastRequest;
    }


    /**
     * Gets the service value for this J2EEClusterMsg.
     * 
     * @return service
     */
    public java.lang.String getService() {
        return service;
    }


    /**
     * Sets the service value for this J2EEClusterMsg.
     * 
     * @param service
     */
    public void setService(java.lang.String service) {
        this.service = service;
    }


    /**
     * Gets the id value for this J2EEClusterMsg.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this J2EEClusterMsg.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the count value for this J2EEClusterMsg.
     * 
     * @return count
     */
    public long getCount() {
        return count;
    }


    /**
     * Sets the count value for this J2EEClusterMsg.
     * 
     * @param count
     */
    public void setCount(long count) {
        this.count = count;
    }


    /**
     * Gets the length value for this J2EEClusterMsg.
     * 
     * @return length
     */
    public long getLength() {
        return length;
    }


    /**
     * Sets the length value for this J2EEClusterMsg.
     * 
     * @param length
     */
    public void setLength(long length) {
        this.length = length;
    }


    /**
     * Gets the avgLength value for this J2EEClusterMsg.
     * 
     * @return avgLength
     */
    public long getAvgLength() {
        return avgLength;
    }


    /**
     * Sets the avgLength value for this J2EEClusterMsg.
     * 
     * @param avgLength
     */
    public void setAvgLength(long avgLength) {
        this.avgLength = avgLength;
    }


    /**
     * Gets the maxLength value for this J2EEClusterMsg.
     * 
     * @return maxLength
     */
    public long getMaxLength() {
        return maxLength;
    }


    /**
     * Sets the maxLength value for this J2EEClusterMsg.
     * 
     * @param maxLength
     */
    public void setMaxLength(long maxLength) {
        this.maxLength = maxLength;
    }


    /**
     * Gets the countP2PMsg value for this J2EEClusterMsg.
     * 
     * @return countP2PMsg
     */
    public long getCountP2PMsg() {
        return countP2PMsg;
    }


    /**
     * Sets the countP2PMsg value for this J2EEClusterMsg.
     * 
     * @param countP2PMsg
     */
    public void setCountP2PMsg(long countP2PMsg) {
        this.countP2PMsg = countP2PMsg;
    }


    /**
     * Gets the countP2PRequest value for this J2EEClusterMsg.
     * 
     * @return countP2PRequest
     */
    public long getCountP2PRequest() {
        return countP2PRequest;
    }


    /**
     * Sets the countP2PRequest value for this J2EEClusterMsg.
     * 
     * @param countP2PRequest
     */
    public void setCountP2PRequest(long countP2PRequest) {
        this.countP2PRequest = countP2PRequest;
    }


    /**
     * Gets the countP2PReply value for this J2EEClusterMsg.
     * 
     * @return countP2PReply
     */
    public long getCountP2PReply() {
        return countP2PReply;
    }


    /**
     * Sets the countP2PReply value for this J2EEClusterMsg.
     * 
     * @param countP2PReply
     */
    public void setCountP2PReply(long countP2PReply) {
        this.countP2PReply = countP2PReply;
    }


    /**
     * Gets the countBroadcastMsg value for this J2EEClusterMsg.
     * 
     * @return countBroadcastMsg
     */
    public long getCountBroadcastMsg() {
        return countBroadcastMsg;
    }


    /**
     * Sets the countBroadcastMsg value for this J2EEClusterMsg.
     * 
     * @param countBroadcastMsg
     */
    public void setCountBroadcastMsg(long countBroadcastMsg) {
        this.countBroadcastMsg = countBroadcastMsg;
    }


    /**
     * Gets the countBroadcastRequest value for this J2EEClusterMsg.
     * 
     * @return countBroadcastRequest
     */
    public long getCountBroadcastRequest() {
        return countBroadcastRequest;
    }


    /**
     * Sets the countBroadcastRequest value for this J2EEClusterMsg.
     * 
     * @param countBroadcastRequest
     */
    public void setCountBroadcastRequest(long countBroadcastRequest) {
        this.countBroadcastRequest = countBroadcastRequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EEClusterMsg)) return false;
        J2EEClusterMsg other = (J2EEClusterMsg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.count == other.getCount() &&
            this.length == other.getLength() &&
            this.avgLength == other.getAvgLength() &&
            this.maxLength == other.getMaxLength() &&
            this.countP2PMsg == other.getCountP2PMsg() &&
            this.countP2PRequest == other.getCountP2PRequest() &&
            this.countP2PReply == other.getCountP2PReply() &&
            this.countBroadcastMsg == other.getCountBroadcastMsg() &&
            this.countBroadcastRequest == other.getCountBroadcastRequest();
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
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += new Long(getCount()).hashCode();
        _hashCode += new Long(getLength()).hashCode();
        _hashCode += new Long(getAvgLength()).hashCode();
        _hashCode += new Long(getMaxLength()).hashCode();
        _hashCode += new Long(getCountP2PMsg()).hashCode();
        _hashCode += new Long(getCountP2PRequest()).hashCode();
        _hashCode += new Long(getCountP2PReply()).hashCode();
        _hashCode += new Long(getCountBroadcastMsg()).hashCode();
        _hashCode += new Long(getCountBroadcastRequest()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EEClusterMsg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EEClusterMsg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("", "service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avgLength");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avg-length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxLength");
        elemField.setXmlName(new javax.xml.namespace.QName("", "max-length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countP2PMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count-p2p-msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countP2PRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count-p2p-request"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countP2PReply");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count-p2p-reply"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countBroadcastMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count-broadcast-msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countBroadcastRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count-broadcast-request"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
