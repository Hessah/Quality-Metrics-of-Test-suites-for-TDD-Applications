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
 * Alert.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class Alert  implements java.io.Serializable {
    private java.lang.String object;
    private java.lang.String attribute;
    private com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR value;
    private java.lang.String description;
    private java.lang.String time;
    private java.lang.String tid;
    private java.lang.String aid;

    public Alert() {
    }

    public Alert(
           java.lang.String object,
           java.lang.String attribute,
           com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR value,
           java.lang.String description,
           java.lang.String time,
           java.lang.String tid,
           java.lang.String aid) {
           this.object = object;
           this.attribute = attribute;
           this.value = value;
           this.description = description;
           this.time = time;
           this.tid = tid;
           this.aid = aid;
    }


    /**
     * Gets the object value for this Alert.
     * 
     * @return object
     */
    public java.lang.String getObject() {
        return object;
    }


    /**
     * Sets the object value for this Alert.
     * 
     * @param object
     */
    public void setObject(java.lang.String object) {
        this.object = object;
    }


    /**
     * Gets the attribute value for this Alert.
     * 
     * @return attribute
     */
    public java.lang.String getAttribute() {
        return attribute;
    }


    /**
     * Sets the attribute value for this Alert.
     * 
     * @param attribute
     */
    public void setAttribute(java.lang.String attribute) {
        this.attribute = attribute;
    }


    /**
     * Gets the value value for this Alert.
     * 
     * @return value
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR getValue() {
        return value;
    }


    /**
     * Sets the value value for this Alert.
     * 
     * @param value
     */
    public void setValue(com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR value) {
        this.value = value;
    }


    /**
     * Gets the description value for this Alert.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Alert.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the time value for this Alert.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this Alert.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the tid value for this Alert.
     * 
     * @return tid
     */
    public java.lang.String getTid() {
        return tid;
    }


    /**
     * Sets the tid value for this Alert.
     * 
     * @param tid
     */
    public void setTid(java.lang.String tid) {
        this.tid = tid;
    }


    /**
     * Gets the aid value for this Alert.
     * 
     * @return aid
     */
    public java.lang.String getAid() {
        return aid;
    }


    /**
     * Sets the aid value for this Alert.
     * 
     * @param aid
     */
    public void setAid(java.lang.String aid) {
        this.aid = aid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Alert)) return false;
        Alert other = (Alert) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.object==null && other.getObject()==null) || 
             (this.object!=null &&
              this.object.equals(other.getObject()))) &&
            ((this.attribute==null && other.getAttribute()==null) || 
             (this.attribute!=null &&
              this.attribute.equals(other.getAttribute()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.tid==null && other.getTid()==null) || 
             (this.tid!=null &&
              this.tid.equals(other.getTid()))) &&
            ((this.aid==null && other.getAid()==null) || 
             (this.aid!=null &&
              this.aid.equals(other.getAid())));
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
        if (getObject() != null) {
            _hashCode += getObject().hashCode();
        }
        if (getAttribute() != null) {
            _hashCode += getAttribute().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getTid() != null) {
            _hashCode += getTid().hashCode();
        }
        if (getAid() != null) {
            _hashCode += getAid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Alert.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "Alert"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("object");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Object"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attribute");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Attribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Value"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "STATE-COLOR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Aid"));
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
