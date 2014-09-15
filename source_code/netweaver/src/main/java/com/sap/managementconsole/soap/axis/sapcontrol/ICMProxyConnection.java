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
 * ICMProxyConnection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ICMProxyConnection  implements java.io.Serializable {
    private java.lang.String conid;
    private java.lang.String role;
    private java.lang.String peerAddress;
    private int peerPort;
    private java.lang.String localAddress;
    private int localPort;
    private java.lang.String status;
    private int nihdl;
    private int socket;
    private java.lang.String partner;
    private java.lang.String internalConvid;
    private java.lang.String externalConvid;
    private java.lang.Integer sncContextLength;
    private java.lang.String failoverStatus;
    private java.lang.String disconnectTime;
    private java.lang.String objectid;
    private java.lang.String tidUidMode;

    public ICMProxyConnection() {
    }

    public ICMProxyConnection(
           java.lang.String conid,
           java.lang.String role,
           java.lang.String peerAddress,
           int peerPort,
           java.lang.String localAddress,
           int localPort,
           java.lang.String status,
           int nihdl,
           int socket,
           java.lang.String partner,
           java.lang.String internalConvid,
           java.lang.String externalConvid,
           java.lang.Integer sncContextLength,
           java.lang.String failoverStatus,
           java.lang.String disconnectTime,
           java.lang.String objectid,
           java.lang.String tidUidMode) {
           this.conid = conid;
           this.role = role;
           this.peerAddress = peerAddress;
           this.peerPort = peerPort;
           this.localAddress = localAddress;
           this.localPort = localPort;
           this.status = status;
           this.nihdl = nihdl;
           this.socket = socket;
           this.partner = partner;
           this.internalConvid = internalConvid;
           this.externalConvid = externalConvid;
           this.sncContextLength = sncContextLength;
           this.failoverStatus = failoverStatus;
           this.disconnectTime = disconnectTime;
           this.objectid = objectid;
           this.tidUidMode = tidUidMode;
    }


    /**
     * Gets the conid value for this ICMProxyConnection.
     * 
     * @return conid
     */
    public java.lang.String getConid() {
        return conid;
    }


    /**
     * Sets the conid value for this ICMProxyConnection.
     * 
     * @param conid
     */
    public void setConid(java.lang.String conid) {
        this.conid = conid;
    }


    /**
     * Gets the role value for this ICMProxyConnection.
     * 
     * @return role
     */
    public java.lang.String getRole() {
        return role;
    }


    /**
     * Sets the role value for this ICMProxyConnection.
     * 
     * @param role
     */
    public void setRole(java.lang.String role) {
        this.role = role;
    }


    /**
     * Gets the peerAddress value for this ICMProxyConnection.
     * 
     * @return peerAddress
     */
    public java.lang.String getPeerAddress() {
        return peerAddress;
    }


    /**
     * Sets the peerAddress value for this ICMProxyConnection.
     * 
     * @param peerAddress
     */
    public void setPeerAddress(java.lang.String peerAddress) {
        this.peerAddress = peerAddress;
    }


    /**
     * Gets the peerPort value for this ICMProxyConnection.
     * 
     * @return peerPort
     */
    public int getPeerPort() {
        return peerPort;
    }


    /**
     * Sets the peerPort value for this ICMProxyConnection.
     * 
     * @param peerPort
     */
    public void setPeerPort(int peerPort) {
        this.peerPort = peerPort;
    }


    /**
     * Gets the localAddress value for this ICMProxyConnection.
     * 
     * @return localAddress
     */
    public java.lang.String getLocalAddress() {
        return localAddress;
    }


    /**
     * Sets the localAddress value for this ICMProxyConnection.
     * 
     * @param localAddress
     */
    public void setLocalAddress(java.lang.String localAddress) {
        this.localAddress = localAddress;
    }


    /**
     * Gets the localPort value for this ICMProxyConnection.
     * 
     * @return localPort
     */
    public int getLocalPort() {
        return localPort;
    }


    /**
     * Sets the localPort value for this ICMProxyConnection.
     * 
     * @param localPort
     */
    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }


    /**
     * Gets the status value for this ICMProxyConnection.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ICMProxyConnection.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the nihdl value for this ICMProxyConnection.
     * 
     * @return nihdl
     */
    public int getNihdl() {
        return nihdl;
    }


    /**
     * Sets the nihdl value for this ICMProxyConnection.
     * 
     * @param nihdl
     */
    public void setNihdl(int nihdl) {
        this.nihdl = nihdl;
    }


    /**
     * Gets the socket value for this ICMProxyConnection.
     * 
     * @return socket
     */
    public int getSocket() {
        return socket;
    }


    /**
     * Sets the socket value for this ICMProxyConnection.
     * 
     * @param socket
     */
    public void setSocket(int socket) {
        this.socket = socket;
    }


    /**
     * Gets the partner value for this ICMProxyConnection.
     * 
     * @return partner
     */
    public java.lang.String getPartner() {
        return partner;
    }


    /**
     * Sets the partner value for this ICMProxyConnection.
     * 
     * @param partner
     */
    public void setPartner(java.lang.String partner) {
        this.partner = partner;
    }


    /**
     * Gets the internalConvid value for this ICMProxyConnection.
     * 
     * @return internalConvid
     */
    public java.lang.String getInternalConvid() {
        return internalConvid;
    }


    /**
     * Sets the internalConvid value for this ICMProxyConnection.
     * 
     * @param internalConvid
     */
    public void setInternalConvid(java.lang.String internalConvid) {
        this.internalConvid = internalConvid;
    }


    /**
     * Gets the externalConvid value for this ICMProxyConnection.
     * 
     * @return externalConvid
     */
    public java.lang.String getExternalConvid() {
        return externalConvid;
    }


    /**
     * Sets the externalConvid value for this ICMProxyConnection.
     * 
     * @param externalConvid
     */
    public void setExternalConvid(java.lang.String externalConvid) {
        this.externalConvid = externalConvid;
    }


    /**
     * Gets the sncContextLength value for this ICMProxyConnection.
     * 
     * @return sncContextLength
     */
    public java.lang.Integer getSncContextLength() {
        return sncContextLength;
    }


    /**
     * Sets the sncContextLength value for this ICMProxyConnection.
     * 
     * @param sncContextLength
     */
    public void setSncContextLength(java.lang.Integer sncContextLength) {
        this.sncContextLength = sncContextLength;
    }


    /**
     * Gets the failoverStatus value for this ICMProxyConnection.
     * 
     * @return failoverStatus
     */
    public java.lang.String getFailoverStatus() {
        return failoverStatus;
    }


    /**
     * Sets the failoverStatus value for this ICMProxyConnection.
     * 
     * @param failoverStatus
     */
    public void setFailoverStatus(java.lang.String failoverStatus) {
        this.failoverStatus = failoverStatus;
    }


    /**
     * Gets the disconnectTime value for this ICMProxyConnection.
     * 
     * @return disconnectTime
     */
    public java.lang.String getDisconnectTime() {
        return disconnectTime;
    }


    /**
     * Sets the disconnectTime value for this ICMProxyConnection.
     * 
     * @param disconnectTime
     */
    public void setDisconnectTime(java.lang.String disconnectTime) {
        this.disconnectTime = disconnectTime;
    }


    /**
     * Gets the objectid value for this ICMProxyConnection.
     * 
     * @return objectid
     */
    public java.lang.String getObjectid() {
        return objectid;
    }


    /**
     * Sets the objectid value for this ICMProxyConnection.
     * 
     * @param objectid
     */
    public void setObjectid(java.lang.String objectid) {
        this.objectid = objectid;
    }


    /**
     * Gets the tidUidMode value for this ICMProxyConnection.
     * 
     * @return tidUidMode
     */
    public java.lang.String getTidUidMode() {
        return tidUidMode;
    }


    /**
     * Sets the tidUidMode value for this ICMProxyConnection.
     * 
     * @param tidUidMode
     */
    public void setTidUidMode(java.lang.String tidUidMode) {
        this.tidUidMode = tidUidMode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ICMProxyConnection)) return false;
        ICMProxyConnection other = (ICMProxyConnection) obj;
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
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.peerAddress==null && other.getPeerAddress()==null) || 
             (this.peerAddress!=null &&
              this.peerAddress.equals(other.getPeerAddress()))) &&
            this.peerPort == other.getPeerPort() &&
            ((this.localAddress==null && other.getLocalAddress()==null) || 
             (this.localAddress!=null &&
              this.localAddress.equals(other.getLocalAddress()))) &&
            this.localPort == other.getLocalPort() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            this.nihdl == other.getNihdl() &&
            this.socket == other.getSocket() &&
            ((this.partner==null && other.getPartner()==null) || 
             (this.partner!=null &&
              this.partner.equals(other.getPartner()))) &&
            ((this.internalConvid==null && other.getInternalConvid()==null) || 
             (this.internalConvid!=null &&
              this.internalConvid.equals(other.getInternalConvid()))) &&
            ((this.externalConvid==null && other.getExternalConvid()==null) || 
             (this.externalConvid!=null &&
              this.externalConvid.equals(other.getExternalConvid()))) &&
            ((this.sncContextLength==null && other.getSncContextLength()==null) || 
             (this.sncContextLength!=null &&
              this.sncContextLength.equals(other.getSncContextLength()))) &&
            ((this.failoverStatus==null && other.getFailoverStatus()==null) || 
             (this.failoverStatus!=null &&
              this.failoverStatus.equals(other.getFailoverStatus()))) &&
            ((this.disconnectTime==null && other.getDisconnectTime()==null) || 
             (this.disconnectTime!=null &&
              this.disconnectTime.equals(other.getDisconnectTime()))) &&
            ((this.objectid==null && other.getObjectid()==null) || 
             (this.objectid!=null &&
              this.objectid.equals(other.getObjectid()))) &&
            ((this.tidUidMode==null && other.getTidUidMode()==null) || 
             (this.tidUidMode!=null &&
              this.tidUidMode.equals(other.getTidUidMode())));
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
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getPeerAddress() != null) {
            _hashCode += getPeerAddress().hashCode();
        }
        _hashCode += getPeerPort();
        if (getLocalAddress() != null) {
            _hashCode += getLocalAddress().hashCode();
        }
        _hashCode += getLocalPort();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        _hashCode += getNihdl();
        _hashCode += getSocket();
        if (getPartner() != null) {
            _hashCode += getPartner().hashCode();
        }
        if (getInternalConvid() != null) {
            _hashCode += getInternalConvid().hashCode();
        }
        if (getExternalConvid() != null) {
            _hashCode += getExternalConvid().hashCode();
        }
        if (getSncContextLength() != null) {
            _hashCode += getSncContextLength().hashCode();
        }
        if (getFailoverStatus() != null) {
            _hashCode += getFailoverStatus().hashCode();
        }
        if (getDisconnectTime() != null) {
            _hashCode += getDisconnectTime().hashCode();
        }
        if (getObjectid() != null) {
            _hashCode += getObjectid().hashCode();
        }
        if (getTidUidMode() != null) {
            _hashCode += getTidUidMode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ICMProxyConnection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ICMProxyConnection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conid"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socket");
        elemField.setXmlName(new javax.xml.namespace.QName("", "socket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internalConvid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "internal-convid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalConvid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "external-convid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sncContextLength");
        elemField.setXmlName(new javax.xml.namespace.QName("", "snc-context-length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failoverStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "failover-status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disconnectTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disconnect-time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objectid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tidUidMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tid-uid-mode"));
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
