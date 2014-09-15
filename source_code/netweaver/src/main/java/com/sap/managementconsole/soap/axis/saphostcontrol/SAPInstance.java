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
package com.sap.managementconsole.soap.axis.saphostcontrol;

/**
 * SAPInstance.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SAPInstance  implements java.io.Serializable {
    private java.lang.String mSid;
    private java.lang.String mHostname;
    private java.lang.String mSystemNumber;
    private java.lang.String mSapVersionInfo;

    public SAPInstance() {
    }

    public SAPInstance(
           java.lang.String mSid,
           java.lang.String mHostname,
           java.lang.String mSystemNumber,
           java.lang.String mSapVersionInfo) {
           this.mSid = mSid;
           this.mHostname = mHostname;
           this.mSystemNumber = mSystemNumber;
           this.mSapVersionInfo = mSapVersionInfo;
    }


    /**
     * Gets the mSid value for this SAPInstance.
     * 
     * @return mSid
     */
    public java.lang.String getMSid() {
        return mSid;
    }


    /**
     * Sets the mSid value for this SAPInstance.
     * 
     * @param mSid
     */
    public void setMSid(java.lang.String mSid) {
        this.mSid = mSid;
    }


    /**
     * Gets the mHostname value for this SAPInstance.
     * 
     * @return mHostname
     */
    public java.lang.String getMHostname() {
        return mHostname;
    }


    /**
     * Sets the mHostname value for this SAPInstance.
     * 
     * @param mHostname
     */
    public void setMHostname(java.lang.String mHostname) {
        this.mHostname = mHostname;
    }


    /**
     * Gets the mSystemNumber value for this SAPInstance.
     * 
     * @return mSystemNumber
     */
    public java.lang.String getMSystemNumber() {
        return mSystemNumber;
    }


    /**
     * Sets the mSystemNumber value for this SAPInstance.
     * 
     * @param mSystemNumber
     */
    public void setMSystemNumber(java.lang.String mSystemNumber) {
        this.mSystemNumber = mSystemNumber;
    }


    /**
     * Gets the mSapVersionInfo value for this SAPInstance.
     * 
     * @return mSapVersionInfo
     */
    public java.lang.String getMSapVersionInfo() {
        return mSapVersionInfo;
    }


    /**
     * Sets the mSapVersionInfo value for this SAPInstance.
     * 
     * @param mSapVersionInfo
     */
    public void setMSapVersionInfo(java.lang.String mSapVersionInfo) {
        this.mSapVersionInfo = mSapVersionInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SAPInstance)) return false;
        SAPInstance other = (SAPInstance) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mSid==null && other.getMSid()==null) || 
             (this.mSid!=null &&
              this.mSid.equals(other.getMSid()))) &&
            ((this.mHostname==null && other.getMHostname()==null) || 
             (this.mHostname!=null &&
              this.mHostname.equals(other.getMHostname()))) &&
            ((this.mSystemNumber==null && other.getMSystemNumber()==null) || 
             (this.mSystemNumber!=null &&
              this.mSystemNumber.equals(other.getMSystemNumber()))) &&
            ((this.mSapVersionInfo==null && other.getMSapVersionInfo()==null) || 
             (this.mSapVersionInfo!=null &&
              this.mSapVersionInfo.equals(other.getMSapVersionInfo())));
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
        if (getMSid() != null) {
            _hashCode += getMSid().hashCode();
        }
        if (getMHostname() != null) {
            _hashCode += getMHostname().hashCode();
        }
        if (getMSystemNumber() != null) {
            _hashCode += getMSystemNumber().hashCode();
        }
        if (getMSapVersionInfo() != null) {
            _hashCode += getMSapVersionInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SAPInstance.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "SAPInstance"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MSid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mSid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MHostname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mHostname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MSystemNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mSystemNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MSapVersionInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mSapVersionInfo"));
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
