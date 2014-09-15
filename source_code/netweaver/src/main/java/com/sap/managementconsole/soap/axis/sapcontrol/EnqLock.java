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
 * EnqLock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public class EnqLock  implements java.io.Serializable {
    private java.lang.String lockName;
    private java.lang.String lockArg;
    private java.lang.String lockMode;
    private java.lang.String owner;
    private java.lang.String ownerVb;
    private int useCountOwner;
    private int useCountOwnerVb;
    private java.lang.String client;
    private java.lang.String user;
    private java.lang.String transaction;
    private java.lang.String object;
    private boolean backup;

    public EnqLock() {
    }

    public EnqLock(
           java.lang.String lockName,
           java.lang.String lockArg,
           java.lang.String lockMode,
           java.lang.String owner,
           java.lang.String ownerVb,
           int useCountOwner,
           int useCountOwnerVb,
           java.lang.String client,
           java.lang.String user,
           java.lang.String transaction,
           java.lang.String object,
           boolean backup) {
           this.lockName = lockName;
           this.lockArg = lockArg;
           this.lockMode = lockMode;
           this.owner = owner;
           this.ownerVb = ownerVb;
           this.useCountOwner = useCountOwner;
           this.useCountOwnerVb = useCountOwnerVb;
           this.client = client;
           this.user = user;
           this.transaction = transaction;
           this.object = object;
           this.backup = backup;
    }


    /**
     * Gets the lockName value for this EnqLock.
     * 
     * @return lockName
     */
    public java.lang.String getLockName() {
        return lockName;
    }


    /**
     * Sets the lockName value for this EnqLock.
     * 
     * @param lockName
     */
    public void setLockName(java.lang.String lockName) {
        this.lockName = lockName;
    }


    /**
     * Gets the lockArg value for this EnqLock.
     * 
     * @return lockArg
     */
    public java.lang.String getLockArg() {
        return lockArg;
    }


    /**
     * Sets the lockArg value for this EnqLock.
     * 
     * @param lockArg
     */
    public void setLockArg(java.lang.String lockArg) {
        this.lockArg = lockArg;
    }


    /**
     * Gets the lockMode value for this EnqLock.
     * 
     * @return lockMode
     */
    public java.lang.String getLockMode() {
        return lockMode;
    }


    /**
     * Sets the lockMode value for this EnqLock.
     * 
     * @param lockMode
     */
    public void setLockMode(java.lang.String lockMode) {
        this.lockMode = lockMode;
    }


    /**
     * Gets the owner value for this EnqLock.
     * 
     * @return owner
     */
    public java.lang.String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this EnqLock.
     * 
     * @param owner
     */
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }


    /**
     * Gets the ownerVb value for this EnqLock.
     * 
     * @return ownerVb
     */
    public java.lang.String getOwnerVb() {
        return ownerVb;
    }


    /**
     * Sets the ownerVb value for this EnqLock.
     * 
     * @param ownerVb
     */
    public void setOwnerVb(java.lang.String ownerVb) {
        this.ownerVb = ownerVb;
    }


    /**
     * Gets the useCountOwner value for this EnqLock.
     * 
     * @return useCountOwner
     */
    public int getUseCountOwner() {
        return useCountOwner;
    }


    /**
     * Sets the useCountOwner value for this EnqLock.
     * 
     * @param useCountOwner
     */
    public void setUseCountOwner(int useCountOwner) {
        this.useCountOwner = useCountOwner;
    }


    /**
     * Gets the useCountOwnerVb value for this EnqLock.
     * 
     * @return useCountOwnerVb
     */
    public int getUseCountOwnerVb() {
        return useCountOwnerVb;
    }


    /**
     * Sets the useCountOwnerVb value for this EnqLock.
     * 
     * @param useCountOwnerVb
     */
    public void setUseCountOwnerVb(int useCountOwnerVb) {
        this.useCountOwnerVb = useCountOwnerVb;
    }


    /**
     * Gets the client value for this EnqLock.
     * 
     * @return client
     */
    public java.lang.String getClient() {
        return client;
    }


    /**
     * Sets the client value for this EnqLock.
     * 
     * @param client
     */
    public void setClient(java.lang.String client) {
        this.client = client;
    }


    /**
     * Gets the user value for this EnqLock.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this EnqLock.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the transaction value for this EnqLock.
     * 
     * @return transaction
     */
    public java.lang.String getTransaction() {
        return transaction;
    }


    /**
     * Sets the transaction value for this EnqLock.
     * 
     * @param transaction
     */
    public void setTransaction(java.lang.String transaction) {
        this.transaction = transaction;
    }


    /**
     * Gets the object value for this EnqLock.
     * 
     * @return object
     */
    public java.lang.String getObject() {
        return object;
    }


    /**
     * Sets the object value for this EnqLock.
     * 
     * @param object
     */
    public void setObject(java.lang.String object) {
        this.object = object;
    }


    /**
     * Gets the backup value for this EnqLock.
     * 
     * @return backup
     */
    public boolean isBackup() {
        return backup;
    }


    /**
     * Sets the backup value for this EnqLock.
     * 
     * @param backup
     */
    public void setBackup(boolean backup) {
        this.backup = backup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnqLock)) return false;
        EnqLock other = (EnqLock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lockName==null && other.getLockName()==null) || 
             (this.lockName!=null &&
              this.lockName.equals(other.getLockName()))) &&
            ((this.lockArg==null && other.getLockArg()==null) || 
             (this.lockArg!=null &&
              this.lockArg.equals(other.getLockArg()))) &&
            ((this.lockMode==null && other.getLockMode()==null) || 
             (this.lockMode!=null &&
              this.lockMode.equals(other.getLockMode()))) &&
            ((this.owner==null && other.getOwner()==null) || 
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.ownerVb==null && other.getOwnerVb()==null) || 
             (this.ownerVb!=null &&
              this.ownerVb.equals(other.getOwnerVb()))) &&
            this.useCountOwner == other.getUseCountOwner() &&
            this.useCountOwnerVb == other.getUseCountOwnerVb() &&
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.transaction==null && other.getTransaction()==null) || 
             (this.transaction!=null &&
              this.transaction.equals(other.getTransaction()))) &&
            ((this.object==null && other.getObject()==null) || 
             (this.object!=null &&
              this.object.equals(other.getObject()))) &&
            this.backup == other.isBackup();
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
        if (getLockName() != null) {
            _hashCode += getLockName().hashCode();
        }
        if (getLockArg() != null) {
            _hashCode += getLockArg().hashCode();
        }
        if (getLockMode() != null) {
            _hashCode += getLockMode().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getOwnerVb() != null) {
            _hashCode += getOwnerVb().hashCode();
        }
        _hashCode += getUseCountOwner();
        _hashCode += getUseCountOwnerVb();
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getTransaction() != null) {
            _hashCode += getTransaction().hashCode();
        }
        if (getObject() != null) {
            _hashCode += getObject().hashCode();
        }
        _hashCode += (isBackup() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnqLock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:SAPControl", "EnqLock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lockName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lock-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lockArg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lock-arg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lockMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lock-mode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerVb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner-vb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useCountOwner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "use-count-owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useCountOwnerVb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "use-count-owner-vb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaction");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transaction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("object");
        elemField.setXmlName(new javax.xml.namespace.QName("", "object"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "backup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
