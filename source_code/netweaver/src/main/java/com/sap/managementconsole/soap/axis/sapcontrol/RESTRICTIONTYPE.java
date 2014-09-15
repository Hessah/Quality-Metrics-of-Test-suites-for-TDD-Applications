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
 * RESTRICTIONTYPE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class RESTRICTIONTYPE implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected RESTRICTIONTYPE(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "SAPControl-RESTRICT-NONE";
    public static final java.lang.String _value2 = "SAPControl-RESTRICT-INT";
    public static final java.lang.String _value3 = "SAPControl-RESTRICT-FLOAT";
    public static final java.lang.String _value4 = "SAPControl-RESTRICT-INTRANGE";
    public static final java.lang.String _value5 = "SAPControl-RESTRICT-FLOATRANGE";
    public static final java.lang.String _value6 = "SAPControl-RESTRICT-ENUM";
    public static final java.lang.String _value7 = "SAPControl-RESTRICT-BOOL";
    public static final RESTRICTIONTYPE value1 = new RESTRICTIONTYPE(_value1);
    public static final RESTRICTIONTYPE value2 = new RESTRICTIONTYPE(_value2);
    public static final RESTRICTIONTYPE value3 = new RESTRICTIONTYPE(_value3);
    public static final RESTRICTIONTYPE value4 = new RESTRICTIONTYPE(_value4);
    public static final RESTRICTIONTYPE value5 = new RESTRICTIONTYPE(_value5);
    public static final RESTRICTIONTYPE value6 = new RESTRICTIONTYPE(_value6);
    public static final RESTRICTIONTYPE value7 = new RESTRICTIONTYPE(_value7);
    public java.lang.String getValue() { return _value_;}
    public static RESTRICTIONTYPE fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        RESTRICTIONTYPE enumeration = (RESTRICTIONTYPE)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static RESTRICTIONTYPE fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RESTRICTIONTYPE.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "RESTRICTION-TYPE"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
