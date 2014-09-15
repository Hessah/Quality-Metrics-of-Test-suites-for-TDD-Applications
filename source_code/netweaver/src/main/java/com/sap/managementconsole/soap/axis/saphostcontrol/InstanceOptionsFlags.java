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
 * InstanceOptionsFlags.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class InstanceOptionsFlags implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected InstanceOptionsFlags(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "O-INSTANCE";
    public static final java.lang.String _value2 = "O-SERVICE";
    public static final java.lang.String _value3 = "O-PREHOOK";
    public static final java.lang.String _value4 = "O-POSTHOOK";
    public static final java.lang.String _value5 = "O-CLEANUP";
    public static final java.lang.String _value6 = "O-FORCE";
    public static final java.lang.String _value7 = "O-LASTOPTION";
    public static final InstanceOptionsFlags value1 = new InstanceOptionsFlags(_value1);
    public static final InstanceOptionsFlags value2 = new InstanceOptionsFlags(_value2);
    public static final InstanceOptionsFlags value3 = new InstanceOptionsFlags(_value3);
    public static final InstanceOptionsFlags value4 = new InstanceOptionsFlags(_value4);
    public static final InstanceOptionsFlags value5 = new InstanceOptionsFlags(_value5);
    public static final InstanceOptionsFlags value6 = new InstanceOptionsFlags(_value6);
    public static final InstanceOptionsFlags value7 = new InstanceOptionsFlags(_value7);
    public java.lang.String getValue() { return _value_;}
    public static InstanceOptionsFlags fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        InstanceOptionsFlags enumeration = (InstanceOptionsFlags)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static InstanceOptionsFlags fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(InstanceOptionsFlags.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPHostControl", "InstanceOptionsFlags"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
