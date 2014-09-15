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
 * ICMConnection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ICMConnection  implements java.io.Serializable {
    private java.lang.String conid;
    private java.lang.String protocol;
    private java.lang.String role;
    private java.lang.String requesttype;
    private java.lang.String peerAddress;
    private int peerPort;
    private java.lang.String localAddress;
    private int localPort;
    private int procTimeout;
    private int keepaliveTimeout;
    private java.lang.String connectionTime;
    private int nihdl;

    public ICMConnection() {
    }

    public ICMConnection(
           java.lang.String conid,
           java.lang.String protocol,
           java.lang.String role,
           java.lang.String requesttype,
           java.lang.String peerAddress,
           int peerPort,
           java.lang.String localAddress,
           int localPort,
           int procTimeout,
           int keepaliveTimeout,
           java.lang.String connectionTime,
           int nihdl) {
           this.conid = conid;
           this.protocol = protocol;
           this.role = role;
           this.requesttype = requesttype;
           this.peerAddress = peerAddress;
           this.peerPort = peerPort;
           this.localAddress = localAddress;
           this.localPort = localPort;
           this.procTimeout = procTimeout;
           this.keepaliveTimeout = keepaliveTimeout;
           this.connectionTime = connectionTime;
           this.nihdl = nihdl;
    }


    /**
     * Gets the conid value for this ICMConnection.
     * 
     * @return conid
     */
    public java.lang.String getConid() {
        return conid;
    }


    /**
     * Sets the conid value for this ICMConnection.
     * 
     * @param conid
     */
    public void setConid(java.lang.String conid) {
        this.conid = conid;
    }


    /**
     * Gets the protocol value for this ICMConnection.
     * 
     * @return protocol
     */
    public java.lang.String getProtocol() {
        return protocol;
    }


    /**
     * Sets the protocol value for this ICMConnection.
     * 
     * @param protocol
     */
    public void setProtocol(java.lang.String protocol) {
        this.protocol = protocol;
    }


    /**
     * Gets the role value for this ICMConnection.
     * 
     * @return role
     */
    public java.lang.String getRole() {
        return role;
    }


    /**
     * Sets the role value for this ICMConnection.
     * 
     * @param role
     */
    public void setRole(java.lang.String role) {
        this.role = role;
    }


    /**
     * Gets the requesttype value for this ICMConnection.
     * 
     * @return requesttype
     */
    public java.lang.String getRequesttype() {
        return requesttype;
    }


    /**
     * Sets the requesttype value for this ICMConnection.
     * 
     * @param requesttype
     */
    public void setRequesttype(java.lang.String requesttype) {
        this.requesttype = requesttype;
    }


    /**
     * Gets the peerAddress value for this ICMConnection.
     * 
     * @return peerAddress
     */
    public java.lang.String getPeerAddress() {
        return peerAddress;
    }


    /**
     * Sets the peerAddress value for this ICMConnection.
     * 
     * @param peerAddress
     */
    public void setPeerAddress(java.lang.String peerAddress) {
        this.peerAddress = peerAddress;
    }


    /**
     * Gets the peerPort value for this ICMConnection.
     * 
     * @return peerPort
     */
    public int getPeerPort() {
        return peerPort;
    }


    /**
     * Sets the peerPort value for this ICMConnection.
     * 
     * @param peerPort
     */
    public void setPeerPort(int peerPort) {
        this.peerPort = peerPort;
    }


    /**
     * Gets the localAddress value for this ICMConnection.
     * 
     * @return localAddress
     */
    public java.lang.String getLocalAddress() {
        return localAddress;
    }


    /**
     * Sets the localAddress value for this ICMConnection.
     * 
     * @param localAddress
     */
    public void setLocalAddress(java.lang.String localAddress) {
        this.localAddress = localAddress;
    }


    /**
     * Gets the localPort value for this ICMConnection.
     * 
     * @return localPort
     */
    public int getLocalPort() {
        return localPort;
    }


    /**
     * Sets the localPort value for this ICMConnection.
     * 
     * @param localPort
     */
    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }


    /**
     * Gets the procTimeout value for this ICMConnection.
     * 
     * @return procTimeout
     */
    public int getProcTimeout() {
        return procTimeout;
    }


    /**
     * Sets the procTimeout value for this ICMConnection.
     * 
     * @param procTimeout
     */
    public void setProcTimeout(int procTimeout) {
        this.procTimeout = procTimeout;
    }


    /**
     * Gets the keepaliveTimeout value for this ICMConnection.
     * 
     * @return keepaliveTimeout
     */
    public int getKeepaliveTimeout() {
        return keepaliveTimeout;
    }


    /**
     * Sets the keepaliveTimeout value for this ICMConnection.
     * 
     * @param keepaliveTimeout
     */
    public void setKeepaliveTimeout(int keepaliveTimeout) {
        this.keepaliveTimeout = keepaliveTimeout;
    }


    /**
     * Gets the connectionTime value for this ICMConnection.
     * 
     * @return connectionTime
     */
    public java.lang.String getConnectionTime() {
        return connectionTime;
    }


    /**
     * Sets the connectionTime value for this ICMConnection.
     * 
     * @param connectionTime
     */
    public void setConnectionTime(java.lang.String connectionTime) {
        this.connectionTime = connectionTime;
    }


    /**
     * Gets the nihdl value for this ICMConnection.
     * 
     * @return nihdl
     */
    public int getNihdl() {
        return nihdl;
    }


    /**
     * Sets the nihdl value for this ICMConnection.
     * 
     * @param nihdl
     */
    public void setNihdl(int nihdl) {
        this.nihdl = nihdl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ICMConnection)) return false;
        ICMConnection other = (ICMConnection) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conid==null && other.getConid()==null) || 
             (this.conid!=null &&
              this.conid.equals(other.getConid()))) &&
            ((this.protocol==null && other.getProtocol()==null) || 
             (this.protocol!=null &&
              this.protocol.equals(other.getProtocol()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.requesttype==null && other.getRequesttype()==null) || 
             (this.requesttype!=null &&
              this.requesttype.equals(other.getRequesttype()))) &&
            ((this.peerAddress==null && other.getPeerAddress()==null) || 
             (this.peerAddress!=null &&
              this.peerAddress.equals(other.getPeerAddress()))) &&
            this.peerPort == other.getPeerPort() &&
            ((this.localAddress==null && other.getLocalAddress()==null) || 
             (this.localAddress!=null &&
              this.localAddress.equals(other.getLocalAddress()))) &&
            this.localPort == other.getLocalPort() &&
            this.procTimeout == other.getProcTimeout() &&
            this.keepaliveTimeout == other.getKeepaliveTimeout() &&
            ((this.connectionTime==null && other.getConnectionTime()==null) || 
             (this.connectionTime!=null &&
              this.connectionTime.equals(other.getConnectionTime()))) &&
            this.nihdl == other.getNihdl();
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
        if (getConid() != null) {
            _hashCode += getConid().hashCode();
        }
        if (getProtocol() != null) {
            _hashCode += getProtocol().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getRequesttype() != null) {
            _hashCode += getRequesttype().hashCode();
        }
        if (getPeerAddress() != null) {
            _hashCode += getPeerAddress().hashCode();
        }
        _hashCode += getPeerPort();
        if (getLocalAddress() != null) {
            _hashCode += getLocalAddress().hashCode();
        }
        _hashCode += getLocalPort();
        _hashCode += getProcTimeout();
        _hashCode += getKeepaliveTimeout();
        if (getConnectionTime() != null) {
            _hashCode += getConnectionTime().hashCode();
        }
        _hashCode += getNihdl();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ICMConnection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ICMConnection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "protocol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesttype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requesttype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peerAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer-address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peerPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer-port"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "local-address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "local-port"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proc-timeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keepaliveTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "keepalive-timeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connectionTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "connection-time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nihdl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nihdl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
