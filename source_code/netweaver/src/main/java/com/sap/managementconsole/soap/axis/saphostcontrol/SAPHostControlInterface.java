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
 * SAPHostControlInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public interface SAPHostControlInterface extends java.rmi.Remote {

    /**
     * Return the list of all installed SAP Instances Installed /
     * Running (see InstanceStatus) on the current host. If an hostname is
     * defined in InstanceSelector, only the instances using this host as
     * SAPLOCALHOST are considered.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance[] listInstances(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceSelector aSelector) throws java.rmi.RemoteException;

    /**
     * // Start the instance specified by aInstance. If a timeout
     * (see OperationOptions) is defined the operation will wait until this
     * expired, and return the operationID. The result of this operation
     * could be retrived using GetOperationResults. If timeout is 0 the operation
     * will be executed asynchronously.If the timeout is -1 the operation
     * will be executed synchronously.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult startInstance(com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance aInstance, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * // Stop the instance specified by aInstance. If a timeout (see
     * OperationOptions) is defined the operation will wait until this expired,
     * and return the operationID. The result of this operation could be
     * retrived using GetOperationResults. If timeout is 0 the operation
     * will be executed asynchronously.If the timeout is -1 the operation
     * will be executed synchronously.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult stopInstance(com.sap.managementconsole.soap.axis.saphostcontrol.SAPInstance aInstance, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Call the specified operation. Supported operations are START,
     * STOP, RESTART (see InstanceServiceOperation). Supported target for
     * the operation are DB[Database], DB_SERVICE [Database Service or Listner],
     * Instance Service [sapstartsrv].If a timeout (see OperationOptions)
     * is defined the operation will wait until this expired, and return
     * the operationID. The result of this operation could be retrived using
     * GetOperationResults. If timeout is 0 the operation will be executed
     * asynchronously. If the timeout is -1 the operation will be executed
     * synchronously.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult callServiceOperation(com.sap.managementconsole.soap.axis.saphostcontrol.InstanceServiceOperation aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult ACOSPrepare(com.sap.managementconsole.soap.axis.saphostcontrol.ACOperation[] aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Return the results of the operation identified by aOperationID.
     * If a timeout is specified (see aOption) the method will wait until
     * the timout expired and returns the currently results, withouth cancelling
     * the operation. If timeout is 0 the method will return immediately.If
     * the timeout is -1 the operation will be executed synchronously.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult getOperationResults(java.lang.String aOperationID, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Cancel a previously started operation. The operation is identified
     * by the aOperationID, and could be canceled using the aType O_SOFT
     * (continue if timeout expired) or O_HARD (kill if timeout expired).
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult cancelOperation(java.lang.String aOperationID, com.sap.managementconsole.soap.axis.saphostcontrol.CancelOperationType aType, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Returns true if the operation is finished. The operation
     * is identified by aOperationID.
     */
    public boolean isOperationFinished(java.lang.String aOperationID) throws java.rmi.RemoteException;

    /**
     * //Execute a predefined SAPHostControl operation.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult executeOperation(java.lang.String aOperation, com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * .
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject[] getCIMObject(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException;

    /**
     * .
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.CIMObject getComputerSystem(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPHostControl__ListDatabases
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.Database[] listDatabases(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException;

    /**
     * //Get the status of the database specified in aArguments. The
     * database must be specified by the following properties: "Database/Name"
     * [mandatory], "Database/Type" (ada|sap|db6|mss|ora...), "Database/InstanceName",
     * "Database/Host", "Database/Username" (DB administration user), "Database/Password".
     * On success status contains the overall status of the database. result
     * contains the components of the database and their status. A database
     * component is described by the properties "Database/ComponentName"
     * and "Database/ComponentDescription" which are filled into the properties
     * array mProperties of the database component. A textual description
     * of the component status, "Database/ComponentStatusDescription", will
     * also be filled into the poperties array.
     */
    public void getDatabaseStatus(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.holders.ArrayOfDatabaseComponentHolder result, com.sap.managementconsole.soap.axis.saphostcontrol.holders.DatabaseStatusHolder status) throws java.rmi.RemoteException;

    /**
     * //Start the database specified in aArguments. The database
     * must be specified as described in SAPHostControl__GetDatabaseStatus.
     * If the network service (e.g. the xserver process in case of MaxDB)
     * should also be started add the O_SERVICE flag to aOptions.mOptions.
     * In case a pre-operation and/or post-operation hook command is to be
     * executed add the flag(s) O_PREHOOK and O_POSTHOOK respectively to
     * aOptions.mOptions. To specify an operation timeout set aOption.mTimeout.
     * The operation will wait until the specified value is expired, and
     * return the operationID. The result of this operation could be retrived
     * using GetOperationResults. If the timeout value is "0" the operation
     * will be executed asynchronously. If the timeout value is "-1" the
     * operation will be executed synchronously.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult startDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Stop the database specified in aArguments. The database must
     * be specified as described in SAPHostControl__GetDatabaseStatus. Add
     * the flag O_SERVICE to aOptions.mOptions if the network service (e.g.
     * the xserver process in case of MaxDB) should also be stopped. To perform
     * a database shutdown even if users are still logged on, add the O_FORCE
     * flag to aOptions.mOptions. For timeout and pre/post hook handling
     * refer to SAPHostControl__StartDatabase.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult stopDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Attach the database specified in aArguments. The database
     * must be specified as described in SAPHostControl__GetDatabaseStatus.
     * For timeout and pre/post hook handling refer to SAPHostControl__StartDatabase.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult attachDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Detach the database specified in aArguments. The database
     * must be specified as described in SAPHostControl__GetDatabaseStatus.
     * For timeout and pre/post hook handling refer to SAPHostControl__StartDatabase.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult detachDatabase(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;

    /**
     * //Get properties of the database specified in aArguments. The
     * database must be specified as described in SAPHostControl__GetDatabaseStatus.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.Property[] getDatabaseProperties(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException;

    /**
     * //Set a database property. The database must be specified as
     * described in SAPHostControl__GetDatabaseStatus. The property to be
     * set must be specified by the arguments "Database/PropertyName" and
     * "Database/PropertyValue".
     */
    public void setDatabaseProperty(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments) throws java.rmi.RemoteException;

    /**
     * //Update the database specified in aArguments. The database
     * must be specified as described in SAPHostControl__GetDatabaseStatus.
     * Add the argument "LiveUpdate/MethodName" to specify the update step
     * [mandatory]. Valid values are: "Extract", "Check", "Prepare", "Undo",
     * "Execute", "Cleanup". The extract step expects the following further
     * arguments: "LiveUpdate/SourcePath" [mandatory] (source path of the
     * .SAR archive), "LiveUpdate/TargetPath" (destination path to extract
     * the archive). On success result.mOperationResults contains "LiveUpdate/TargetPath"
     * which points to the actual path where the archive was extracted to.
     * The other steps expect the "LiveUpdate/SourcePath" [mandatory] argument
     * (which is the destination path of the extract step). For timeout handling
     * refer to SAPHostControl__StartDatabase.
     */
    public com.sap.managementconsole.soap.axis.saphostcontrol.OperationResult liveDatabaseUpdate(com.sap.managementconsole.soap.axis.saphostcontrol.Property[] aArguments, com.sap.managementconsole.soap.axis.saphostcontrol.OperationOptions aOptions) throws java.rmi.RemoteException, com.sap.managementconsole.soap.axis.saphostcontrol.OperationException;
}
