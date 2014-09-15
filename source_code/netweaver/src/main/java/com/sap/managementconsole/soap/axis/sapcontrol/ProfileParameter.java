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
 * ProfileParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ProfileParameter  implements java.io.Serializable {
    private java.lang.String name;
    private java.lang.String group;
    private java.lang.String description;
    private java.lang.String unit;
    private com.sap.managementconsole.soap.axis.sapcontrol.ParameterRestriction restriction;
    private com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter[] subPara;
    private java.lang.String value;
    private java.lang.String dynamicValue;
    private java.lang.String[] values;
    private java.lang.String[] dynamicValues;

    public ProfileParameter() {
    }

    public ProfileParameter(
           java.lang.String name,
           java.lang.String group,
           java.lang.String description,
           java.lang.String unit,
           com.sap.managementconsole.soap.axis.sapcontrol.ParameterRestriction restriction,
           com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter[] subPara,
           java.lang.String value,
           java.lang.String dynamicValue,
           java.lang.String[] values,
           java.lang.String[] dynamicValues) {
           this.name = name;
           this.group = group;
           this.description = description;
           this.unit = unit;
           this.restriction = restriction;
           this.subPara = subPara;
           this.value = value;
           this.dynamicValue = dynamicValue;
           this.values = values;
           this.dynamicValues = dynamicValues;
    }


    /**
     * Gets the name value for this ProfileParameter.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ProfileParameter.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the group value for this ProfileParameter.
     * 
     * @return group
     */
    public java.lang.String getGroup() {
        return group;
    }


    /**
     * Sets the group value for this ProfileParameter.
     * 
     * @param group
     */
    public void setGroup(java.lang.String group) {
        this.group = group;
    }


    /**
     * Gets the description value for this ProfileParameter.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ProfileParameter.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the unit value for this ProfileParameter.
     * 
     * @return unit
     */
    public java.lang.String getUnit() {
        return unit;
    }


    /**
     * Sets the unit value for this ProfileParameter.
     * 
     * @param unit
     */
    public void setUnit(java.lang.String unit) {
        this.unit = unit;
    }


    /**
     * Gets the restriction value for this ProfileParameter.
     * 
     * @return restriction
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ParameterRestriction getRestriction() {
        return restriction;
    }


    /**
     * Sets the restriction value for this ProfileParameter.
     * 
     * @param restriction
     */
    public void setRestriction(com.sap.managementconsole.soap.axis.sapcontrol.ParameterRestriction restriction) {
        this.restriction = restriction;
    }


    /**
     * Gets the subPara value for this ProfileParameter.
     * 
     * @return subPara
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter[] getSubPara() {
        return subPara;
    }


    /**
     * Sets the subPara value for this ProfileParameter.
     * 
     * @param subPara
     */
    public void setSubPara(com.sap.managementconsole.soap.axis.sapcontrol.SubProfileParameter[] subPara) {
        this.subPara = subPara;
    }


    /**
     * Gets the value value for this ProfileParameter.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this ProfileParameter.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the dynamicValue value for this ProfileParameter.
     * 
     * @return dynamicValue
     */
    public java.lang.String getDynamicValue() {
        return dynamicValue;
    }


    /**
     * Sets the dynamicValue value for this ProfileParameter.
     * 
     * @param dynamicValue
     */
    public void setDynamicValue(java.lang.String dynamicValue) {
        this.dynamicValue = dynamicValue;
    }


    /**
     * Gets the values value for this ProfileParameter.
     * 
     * @return values
     */
    public java.lang.String[] getValues() {
        return values;
    }


    /**
     * Sets the values value for this ProfileParameter.
     * 
     * @param values
     */
    public void setValues(java.lang.String[] values) {
        this.values = values;
    }


    /**
     * Gets the dynamicValues value for this ProfileParameter.
     * 
     * @return dynamicValues
     */
    public java.lang.String[] getDynamicValues() {
        return dynamicValues;
    }


    /**
     * Sets the dynamicValues value for this ProfileParameter.
     * 
     * @param dynamicValues
     */
    public void setDynamicValues(java.lang.String[] dynamicValues) {
        this.dynamicValues = dynamicValues;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProfileParameter)) return false;
        ProfileParameter other = (ProfileParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.group==null && other.getGroup()==null) || 
             (this.group!=null &&
              this.group.equals(other.getGroup()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.unit==null && other.getUnit()==null) || 
             (this.unit!=null &&
              this.unit.equals(other.getUnit()))) &&
            ((this.restriction==null && other.getRestriction()==null) || 
             (this.restriction!=null &&
              this.restriction.equals(other.getRestriction()))) &&
            ((this.subPara==null && other.getSubPara()==null) || 
             (this.subPara!=null &&
              java.util.Arrays.equals(this.subPara, other.getSubPara()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.dynamicValue==null && other.getDynamicValue()==null) || 
             (this.dynamicValue!=null &&
              this.dynamicValue.equals(other.getDynamicValue()))) &&
            ((this.values==null && other.getValues()==null) || 
             (this.values!=null &&
              java.util.Arrays.equals(this.values, other.getValues()))) &&
            ((this.dynamicValues==null && other.getDynamicValues()==null) || 
             (this.dynamicValues!=null &&
              java.util.Arrays.equals(this.dynamicValues, other.getDynamicValues())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getGroup() != null) {
            _hashCode += getGroup().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getUnit() != null) {
            _hashCode += getUnit().hashCode();
        }
        if (getRestriction() != null) {
            _hashCode += getRestriction().hashCode();
        }
        if (getSubPara() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubPara());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubPara(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getDynamicValue() != null) {
            _hashCode += getDynamicValue().hashCode();
        }
        if (getValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDynamicValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDynamicValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDynamicValues(), i);
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
        new org.apache.axis.description.TypeDesc(ProfileParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ProfileParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group");
        elemField.setXmlName(new javax.xml.namespace.QName("", "group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restriction");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restriction"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ParameterRestriction"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subPara");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sub-para"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "SubProfileParameter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamicValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dynamic-value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("values");
        elemField.setXmlName(new javax.xml.namespace.QName("", "values"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamicValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dynamic-values"));
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
