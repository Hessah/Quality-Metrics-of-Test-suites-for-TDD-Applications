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
 * ParameterRestriction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ParameterRestriction  implements java.io.Serializable {
    private com.sap.managementconsole.soap.axis.sapcontrol.RESTRICTIONTYPE type;
    private java.lang.Long intMin;
    private java.lang.Long intMax;
    private java.lang.Double floatMin;
    private java.lang.Double floatMax;
    private java.lang.String[] valuemap;

    public ParameterRestriction() {
    }

    public ParameterRestriction(
           com.sap.managementconsole.soap.axis.sapcontrol.RESTRICTIONTYPE type,
           java.lang.Long intMin,
           java.lang.Long intMax,
           java.lang.Double floatMin,
           java.lang.Double floatMax,
           java.lang.String[] valuemap) {
           this.type = type;
           this.intMin = intMin;
           this.intMax = intMax;
           this.floatMin = floatMin;
           this.floatMax = floatMax;
           this.valuemap = valuemap;
    }


    /**
     * Gets the type value for this ParameterRestriction.
     * 
     * @return type
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.RESTRICTIONTYPE getType() {
        return type;
    }


    /**
     * Sets the type value for this ParameterRestriction.
     * 
     * @param type
     */
    public void setType(com.sap.managementconsole.soap.axis.sapcontrol.RESTRICTIONTYPE type) {
        this.type = type;
    }


    /**
     * Gets the intMin value for this ParameterRestriction.
     * 
     * @return intMin
     */
    public java.lang.Long getIntMin() {
        return intMin;
    }


    /**
     * Sets the intMin value for this ParameterRestriction.
     * 
     * @param intMin
     */
    public void setIntMin(java.lang.Long intMin) {
        this.intMin = intMin;
    }


    /**
     * Gets the intMax value for this ParameterRestriction.
     * 
     * @return intMax
     */
    public java.lang.Long getIntMax() {
        return intMax;
    }


    /**
     * Sets the intMax value for this ParameterRestriction.
     * 
     * @param intMax
     */
    public void setIntMax(java.lang.Long intMax) {
        this.intMax = intMax;
    }


    /**
     * Gets the floatMin value for this ParameterRestriction.
     * 
     * @return floatMin
     */
    public java.lang.Double getFloatMin() {
        return floatMin;
    }


    /**
     * Sets the floatMin value for this ParameterRestriction.
     * 
     * @param floatMin
     */
    public void setFloatMin(java.lang.Double floatMin) {
        this.floatMin = floatMin;
    }


    /**
     * Gets the floatMax value for this ParameterRestriction.
     * 
     * @return floatMax
     */
    public java.lang.Double getFloatMax() {
        return floatMax;
    }


    /**
     * Sets the floatMax value for this ParameterRestriction.
     * 
     * @param floatMax
     */
    public void setFloatMax(java.lang.Double floatMax) {
        this.floatMax = floatMax;
    }


    /**
     * Gets the valuemap value for this ParameterRestriction.
     * 
     * @return valuemap
     */
    public java.lang.String[] getValuemap() {
        return valuemap;
    }


    /**
     * Sets the valuemap value for this ParameterRestriction.
     * 
     * @param valuemap
     */
    public void setValuemap(java.lang.String[] valuemap) {
        this.valuemap = valuemap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParameterRestriction)) return false;
        ParameterRestriction other = (ParameterRestriction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.intMin==null && other.getIntMin()==null) || 
             (this.intMin!=null &&
              this.intMin.equals(other.getIntMin()))) &&
            ((this.intMax==null && other.getIntMax()==null) || 
             (this.intMax!=null &&
              this.intMax.equals(other.getIntMax()))) &&
            ((this.floatMin==null && other.getFloatMin()==null) || 
             (this.floatMin!=null &&
              this.floatMin.equals(other.getFloatMin()))) &&
            ((this.floatMax==null && other.getFloatMax()==null) || 
             (this.floatMax!=null &&
              this.floatMax.equals(other.getFloatMax()))) &&
            ((this.valuemap==null && other.getValuemap()==null) || 
             (this.valuemap!=null &&
              java.util.Arrays.equals(this.valuemap, other.getValuemap())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getIntMin() != null) {
            _hashCode += getIntMin().hashCode();
        }
        if (getIntMax() != null) {
            _hashCode += getIntMax().hashCode();
        }
        if (getFloatMin() != null) {
            _hashCode += getFloatMin().hashCode();
        }
        if (getFloatMax() != null) {
            _hashCode += getFloatMax().hashCode();
        }
        if (getValuemap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValuemap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValuemap(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParameterRestriction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ParameterRestriction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "RESTRICTION-TYPE"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intMin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "int-min"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intMax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "int-max"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("floatMin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "float-min"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("floatMax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "float-max"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valuemap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valuemap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
