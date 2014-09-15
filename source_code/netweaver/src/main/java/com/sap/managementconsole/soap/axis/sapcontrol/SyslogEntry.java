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
 * SyslogEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class SyslogEntry  implements java.io.Serializable {
    private java.lang.String time;
    private java.lang.String typ;
    private java.lang.String client;
    private java.lang.String user;
    private java.lang.String tcode;
    private java.lang.String MNo;
    private java.lang.String text;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR severity;

    public SyslogEntry() {
    }

    public SyslogEntry(
           java.lang.String time,
           java.lang.String typ,
           java.lang.String client,
           java.lang.String user,
           java.lang.String tcode,
           java.lang.String MNo,
           java.lang.String text,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR severity) {
           this.time = time;
           this.typ = typ;
           this.client = client;
           this.user = user;
           this.tcode = tcode;
           this.MNo = MNo;
           this.text = text;
           this.severity = severity;
    }


    /**
     * Gets the time value for this SyslogEntry.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this SyslogEntry.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the typ value for this SyslogEntry.
     * 
     * @return typ
     */
    public java.lang.String getTyp() {
        return typ;
    }


    /**
     * Sets the typ value for this SyslogEntry.
     * 
     * @param typ
     */
    public void setTyp(java.lang.String typ) {
        this.typ = typ;
    }


    /**
     * Gets the client value for this SyslogEntry.
     * 
     * @return client
     */
    public java.lang.String getClient() {
        return client;
    }


    /**
     * Sets the client value for this SyslogEntry.
     * 
     * @param client
     */
    public void setClient(java.lang.String client) {
        this.client = client;
    }


    /**
     * Gets the user value for this SyslogEntry.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this SyslogEntry.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the tcode value for this SyslogEntry.
     * 
     * @return tcode
     */
    public java.lang.String getTcode() {
        return tcode;
    }


    /**
     * Sets the tcode value for this SyslogEntry.
     * 
     * @param tcode
     */
    public void setTcode(java.lang.String tcode) {
        this.tcode = tcode;
    }


    /**
     * Gets the MNo value for this SyslogEntry.
     * 
     * @return MNo
     */
    public java.lang.String getMNo() {
        return MNo;
    }


    /**
     * Sets the MNo value for this SyslogEntry.
     * 
     * @param MNo
     */
    public void setMNo(java.lang.String MNo) {
        this.MNo = MNo;
    }


    /**
     * Gets the text value for this SyslogEntry.
     * 
     * @return text
     */
    public java.lang.String getText() {
        return text;
    }


    /**
     * Sets the text value for this SyslogEntry.
     * 
     * @param text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }


    /**
     * Gets the severity value for this SyslogEntry.
     * 
     * @return severity
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getSeverity() {
        return severity;
    }


    /**
     * Sets the severity value for this SyslogEntry.
     * 
     * @param severity
     */
    public void setSeverity(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR severity) {
        this.severity = severity;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SyslogEntry)) return false;
        SyslogEntry other = (SyslogEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.typ==null && other.getTyp()==null) || 
             (this.typ!=null &&
              this.typ.equals(other.getTyp()))) &&
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.tcode==null && other.getTcode()==null) || 
             (this.tcode!=null &&
              this.tcode.equals(other.getTcode()))) &&
            ((this.MNo==null && other.getMNo()==null) || 
             (this.MNo!=null &&
              this.MNo.equals(other.getMNo()))) &&
            ((this.text==null && other.getText()==null) || 
             (this.text!=null &&
              this.text.equals(other.getText()))) &&
            ((this.severity==null && other.getSeverity()==null) || 
             (this.severity!=null &&
              this.severity.equals(other.getSeverity())));
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
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getTyp() != null) {
            _hashCode += getTyp().hashCode();
        }
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getTcode() != null) {
            _hashCode += getTcode().hashCode();
        }
        if (getMNo() != null) {
            _hashCode += getMNo().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        if (getSeverity() != null) {
            _hashCode += getSeverity().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SyslogEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "SyslogEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Typ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Severity"));
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
