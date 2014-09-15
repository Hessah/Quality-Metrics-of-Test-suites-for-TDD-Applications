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
 * ICMCacheEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class ICMCacheEntry  implements java.io.Serializable {
    private java.lang.String name;
    private int version;
    private long size;
    private boolean valid;
    private java.lang.String cache;
    private java.lang.String creationTime;
    private java.lang.String lastAccessTime;
    private java.lang.String expirationTime;
    private java.lang.String cacheurl;

    public ICMCacheEntry() {
    }

    public ICMCacheEntry(
           java.lang.String name,
           int version,
           long size,
           boolean valid,
           java.lang.String cache,
           java.lang.String creationTime,
           java.lang.String lastAccessTime,
           java.lang.String expirationTime,
           java.lang.String cacheurl) {
           this.name = name;
           this.version = version;
           this.size = size;
           this.valid = valid;
           this.cache = cache;
           this.creationTime = creationTime;
           this.lastAccessTime = lastAccessTime;
           this.expirationTime = expirationTime;
           this.cacheurl = cacheurl;
    }


    /**
     * Gets the name value for this ICMCacheEntry.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ICMCacheEntry.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the version value for this ICMCacheEntry.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this ICMCacheEntry.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the size value for this ICMCacheEntry.
     * 
     * @return size
     */
    public long getSize() {
        return size;
    }


    /**
     * Sets the size value for this ICMCacheEntry.
     * 
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }


    /**
     * Gets the valid value for this ICMCacheEntry.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this ICMCacheEntry.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the cache value for this ICMCacheEntry.
     * 
     * @return cache
     */
    public java.lang.String getCache() {
        return cache;
    }


    /**
     * Sets the cache value for this ICMCacheEntry.
     * 
     * @param cache
     */
    public void setCache(java.lang.String cache) {
        this.cache = cache;
    }


    /**
     * Gets the creationTime value for this ICMCacheEntry.
     * 
     * @return creationTime
     */
    public java.lang.String getCreationTime() {
        return creationTime;
    }


    /**
     * Sets the creationTime value for this ICMCacheEntry.
     * 
     * @param creationTime
     */
    public void setCreationTime(java.lang.String creationTime) {
        this.creationTime = creationTime;
    }


    /**
     * Gets the lastAccessTime value for this ICMCacheEntry.
     * 
     * @return lastAccessTime
     */
    public java.lang.String getLastAccessTime() {
        return lastAccessTime;
    }


    /**
     * Sets the lastAccessTime value for this ICMCacheEntry.
     * 
     * @param lastAccessTime
     */
    public void setLastAccessTime(java.lang.String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    /**
     * Gets the expirationTime value for this ICMCacheEntry.
     * 
     * @return expirationTime
     */
    public java.lang.String getExpirationTime() {
        return expirationTime;
    }


    /**
     * Sets the expirationTime value for this ICMCacheEntry.
     * 
     * @param expirationTime
     */
    public void setExpirationTime(java.lang.String expirationTime) {
        this.expirationTime = expirationTime;
    }


    /**
     * Gets the cacheurl value for this ICMCacheEntry.
     * 
     * @return cacheurl
     */
    public java.lang.String getCacheurl() {
        return cacheurl;
    }


    /**
     * Sets the cacheurl value for this ICMCacheEntry.
     * 
     * @param cacheurl
     */
    public void setCacheurl(java.lang.String cacheurl) {
        this.cacheurl = cacheurl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ICMCacheEntry)) return false;
        ICMCacheEntry other = (ICMCacheEntry) obj;
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
            this.version == other.getVersion() &&
            this.size == other.getSize() &&
            this.valid == other.isValid() &&
            ((this.cache==null && other.getCache()==null) || 
             (this.cache!=null &&
              this.cache.equals(other.getCache()))) &&
            ((this.creationTime==null && other.getCreationTime()==null) || 
             (this.creationTime!=null &&
              this.creationTime.equals(other.getCreationTime()))) &&
            ((this.lastAccessTime==null && other.getLastAccessTime()==null) || 
             (this.lastAccessTime!=null &&
              this.lastAccessTime.equals(other.getLastAccessTime()))) &&
            ((this.expirationTime==null && other.getExpirationTime()==null) || 
             (this.expirationTime!=null &&
              this.expirationTime.equals(other.getExpirationTime()))) &&
            ((this.cacheurl==null && other.getCacheurl()==null) || 
             (this.cacheurl!=null &&
              this.cacheurl.equals(other.getCacheurl())));
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
        _hashCode += getVersion();
        _hashCode += new Long(getSize()).hashCode();
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCache() != null) {
            _hashCode += getCache().hashCode();
        }
        if (getCreationTime() != null) {
            _hashCode += getCreationTime().hashCode();
        }
        if (getLastAccessTime() != null) {
            _hashCode += getLastAccessTime().hashCode();
        }
        if (getExpirationTime() != null) {
            _hashCode += getExpirationTime().hashCode();
        }
        if (getCacheurl() != null) {
            _hashCode += getCacheurl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ICMCacheEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "ICMCacheEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cache");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cache"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creation-time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastAccessTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "last-access-time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expiration-time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cacheurl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cacheurl"));
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
