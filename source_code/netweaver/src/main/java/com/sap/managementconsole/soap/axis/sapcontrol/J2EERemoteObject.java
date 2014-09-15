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
 * J2EERemoteObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class J2EERemoteObject  implements java.io.Serializable {
    private int idHash;
    private java.lang.String address;
    private int port;
    private java.lang.String protocol;
    private java.lang.String direction;
    private int stubs;
    private int implementations;
    private java.lang.String creationTime;
    private java.lang.String updateTime;
    private java.lang.String processname;

    public J2EERemoteObject() {
    }

    public J2EERemoteObject(
           int idHash,
           java.lang.String address,
           int port,
           java.lang.String protocol,
           java.lang.String direction,
           int stubs,
           int implementations,
           java.lang.String creationTime,
           java.lang.String updateTime,
           java.lang.String processname) {
           this.idHash = idHash;
           this.address = address;
           this.port = port;
           this.protocol = protocol;
           this.direction = direction;
           this.stubs = stubs;
           this.implementations = implementations;
           this.creationTime = creationTime;
           this.updateTime = updateTime;
           this.processname = processname;
    }


    /**
     * Gets the idHash value for this J2EERemoteObject.
     * 
     * @return idHash
     */
    public int getIdHash() {
        return idHash;
    }


    /**
     * Sets the idHash value for this J2EERemoteObject.
     * 
     * @param idHash
     */
    public void setIdHash(int idHash) {
        this.idHash = idHash;
    }


    /**
     * Gets the address value for this J2EERemoteObject.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this J2EERemoteObject.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the port value for this J2EERemoteObject.
     * 
     * @return port
     */
    public int getPort() {
        return port;
    }


    /**
     * Sets the port value for this J2EERemoteObject.
     * 
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }


    /**
     * Gets the protocol value for this J2EERemoteObject.
     * 
     * @return protocol
     */
    public java.lang.String getProtocol() {
        return protocol;
    }


    /**
     * Sets the protocol value for this J2EERemoteObject.
     * 
     * @param protocol
     */
    public void setProtocol(java.lang.String protocol) {
        this.protocol = protocol;
    }


    /**
     * Gets the direction value for this J2EERemoteObject.
     * 
     * @return direction
     */
    public java.lang.String getDirection() {
        return direction;
    }


    /**
     * Sets the direction value for this J2EERemoteObject.
     * 
     * @param direction
     */
    public void setDirection(java.lang.String direction) {
        this.direction = direction;
    }


    /**
     * Gets the stubs value for this J2EERemoteObject.
     * 
     * @return stubs
     */
    public int getStubs() {
        return stubs;
    }


    /**
     * Sets the stubs value for this J2EERemoteObject.
     * 
     * @param stubs
     */
    public void setStubs(int stubs) {
        this.stubs = stubs;
    }


    /**
     * Gets the implementations value for this J2EERemoteObject.
     * 
     * @return implementations
     */
    public int getImplementations() {
        return implementations;
    }


    /**
     * Sets the implementations value for this J2EERemoteObject.
     * 
     * @param implementations
     */
    public void setImplementations(int implementations) {
        this.implementations = implementations;
    }


    /**
     * Gets the creationTime value for this J2EERemoteObject.
     * 
     * @return creationTime
     */
    public java.lang.String getCreationTime() {
        return creationTime;
    }


    /**
     * Sets the creationTime value for this J2EERemoteObject.
     * 
     * @param creationTime
     */
    public void setCreationTime(java.lang.String creationTime) {
        this.creationTime = creationTime;
    }


    /**
     * Gets the updateTime value for this J2EERemoteObject.
     * 
     * @return updateTime
     */
    public java.lang.String getUpdateTime() {
        return updateTime;
    }


    /**
     * Sets the updateTime value for this J2EERemoteObject.
     * 
     * @param updateTime
     */
    public void setUpdateTime(java.lang.String updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Gets the processname value for this J2EERemoteObject.
     * 
     * @return processname
     */
    public java.lang.String getProcessname() {
        return processname;
    }


    /**
     * Sets the processname value for this J2EERemoteObject.
     * 
     * @param processname
     */
    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof J2EERemoteObject)) return false;
        J2EERemoteObject other = (J2EERemoteObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idHash == other.getIdHash() &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            this.port == other.getPort() &&
            ((this.protocol==null && other.getProtocol()==null) || 
             (this.protocol!=null &&
              this.protocol.equals(other.getProtocol()))) &&
            ((this.direction==null && other.getDirection()==null) || 
             (this.direction!=null &&
              this.direction.equals(other.getDirection()))) &&
            this.stubs == other.getStubs() &&
            this.implementations == other.getImplementations() &&
            ((this.creationTime==null && other.getCreationTime()==null) || 
             (this.creationTime!=null &&
              this.creationTime.equals(other.getCreationTime()))) &&
            ((this.updateTime==null && other.getUpdateTime()==null) || 
             (this.updateTime!=null &&
              this.updateTime.equals(other.getUpdateTime()))) &&
            ((this.processname==null && other.getProcessname()==null) || 
             (this.processname!=null &&
              this.processname.equals(other.getProcessname())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        _hashCode += getPort();
        if (getProtocol() != null) {
            _hashCode += getProtocol().hashCode();
        }
        if (getDirection() != null) {
            _hashCode += getDirection().hashCode();
        }
        _hashCode += getStubs();
        _hashCode += getImplementations();
        if (getCreationTime() != null) {
            _hashCode += getCreationTime().hashCode();
        }
        if (getUpdateTime() != null) {
            _hashCode += getUpdateTime().hashCode();
        }
        if (getProcessname() != null) {
            _hashCode += getProcessname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(J2EERemoteObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "J2EERemoteObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idHash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IdHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("port");
        elemField.setXmlName(new javax.xml.namespace.QName("", "port"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "protocol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direction");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stubs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stubs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("implementations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "implementations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creationTime"));
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
        elemField.setFieldName("processname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processname"));
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
