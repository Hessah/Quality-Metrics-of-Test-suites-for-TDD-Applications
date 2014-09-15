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
 * SAPControlPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */
public interface SAPControlPortType extends java.rmi.Remote {

    /**
     * Triggers an instance start and returns immediately.
     */
    public void start() throws java.rmi.RemoteException;

    /**
     * Triggers an instance stop and returns immediately.
     */
    public void stop(int softtimeout, int isSystemStop) throws java.rmi.RemoteException;

    /**
     * Triggers a graceful instance stop and returns immediately.
     */
    public void shutdown(int isSystemStop) throws java.rmi.RemoteException;

    /**
     * Returns a SAP profile parameter value for a given profile parameter.
     * If the given profile parameter is empty it returns a string with all
     * known parameter value pairs seperated by newline.
     */
    public java.lang.String parameterValue(java.lang.String parameter) throws java.rmi.RemoteException;

    /**
     * Returns a list of all processes directly started by the Webservice
     * according to the SAP start profile.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.OSProcess[] getProcessList() throws java.rmi.RemoteException;

    /**
     * Returns start profile name and content as array of lines.
     */
    public void getStartProfile(javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Returns Webservice tracefile name and content as array of lines.
     */
    public void getTraceFile(javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Returns CCMS Alert tree as an array, parent-child node relationship
     * is encoded via the parent index of each node (similar to rz20 transaction).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.AlertNode[] getAlertTree() throws java.rmi.RemoteException;

    /**
     * Returns a list of all CCMS alerts for a given node and it's
     * child nodes.
     */
    public void getAlerts(java.lang.String rootTid, javax.xml.rpc.holders.StringHolder rootTidName, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfAlertHolder alert) throws java.rmi.RemoteException;

    /**
     * Triggers webservice restart without any effects on the eventually
     * running instance and returns immediately.
     */
    public void restartService() throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__StopService
     */
    public void stopService() throws java.rmi.RemoteException;

    /**
     * Returns the process environment as an array of strings.
     */
    public java.lang.String[] getEnvironment() throws java.rmi.RemoteException;

    /**
     * Returns a list of all instance tracefiles (superceded by ListLogFiles).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.DirEntry[] listDeveloperTraces() throws java.rmi.RemoteException;

    /**
     * Returns the content of a given tracefile. Use size=0 to read
     * the entire file, size bigger 0 to read the first size bytes, size
     * smaller 0 to read the last size bytes (superceded by ReadLogFile).
     */
    public void readDeveloperTrace(java.lang.String filename, int size, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Triggers an instance restart and returns immediately.
     */
    public void restartInstance(int softtimeout) throws java.rmi.RemoteException;

    /**
     * Sends a given OS signal to a given process. The signal can
     * be given by name or number.
     */
    public void sendSignal(int pid, java.lang.String signal) throws java.rmi.RemoteException;

    /**
     * Returns a list version information for the most important files
     * of the instance
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.InstanceVersionInfo[] getVersionInfo() throws java.rmi.RemoteException;

    /**
     * Returns a list of queue information of work processes and icm
     * (similar to dpmon).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.TaskHandlerQueue[] getQueueStatistic() throws java.rmi.RemoteException;

    /**
     * Returns a list of available instance features and information
     * how to get it.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty[] getInstanceProperties() throws java.rmi.RemoteException;

    /**
     * Executes an external OS command.
     */
    public void OSExecute(java.lang.String command, int async, int timeout, java.lang.String protocolfile, javax.xml.rpc.holders.IntHolder exitcode, javax.xml.rpc.holders.IntHolder pid, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Returns the content of a given log file. Use statecookie to
     * specify starting position (""=beginning), use maxentries to specify
     * upper limit of returned entries (0=all) and reading direction (positive:
     * forward, negative: backward).
     */
    public void readLogFile(java.lang.String filename, java.lang.String filter, java.lang.String language, int maxentries, java.lang.String statecookie, javax.xml.rpc.holders.StringHolder format, javax.xml.rpc.holders.StringHolder startcookie, javax.xml.rpc.holders.StringHolder endcookie, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder fields) throws java.rmi.RemoteException;

    /**
     * Returns a list of all instance log files.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.LogFile[] listLogFiles() throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__AnalyseLogFiles
     */
    public void analyseLogFiles(java.lang.String starttime, java.lang.String endtime, int severityLevel, int maxentries, javax.xml.rpc.holders.StringHolder format, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder fields) throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__GetAccessPointList
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint[] getAccessPointList() throws java.rmi.RemoteException;

    /**
     * Returns a list of SAP instances of the SAP system.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance[] getSystemInstanceList() throws java.rmi.RemoteException;

    /**
     * Triggers start of entire system or parts of it.
     */
    public void startSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int waittimeout) throws java.rmi.RemoteException;

    /**
     * Triggers stop or soft shutdown of entire system or parts of
     * it.
     */
    public void stopSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int softtimeout, int waittimeout) throws java.rmi.RemoteException;

    /**
     * Triggers restart of entire system or parts of it.
     */
    public void restartSystem(com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption options, java.lang.String prioritylevel, int softtimeout, int waittimeout) throws java.rmi.RemoteException;

    /**
     * Checks execute permission of webservice function.
     */
    public void accessCheck(java.lang.String function) throws java.rmi.RemoteException;

    /**
     * Returns actual Profile Parameters for a given process.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ProfileParameter[] getProcessParameter(java.lang.String processtype, int pid) throws java.rmi.RemoteException;

    /**
     * Sets dynamic Profile Parameters for a given process.
     */
    public void setProcessParameter(java.lang.String processtype, int pid, com.sap.managementconsole.soap.axis.sapcontrol.SetProfileParameter[] parameter) throws java.rmi.RemoteException;

    /**
     * Triggers sapstarstrv to detach from shared memory (for internal
     * usage only).
     */
    public void shmDetach() throws java.rmi.RemoteException;

    /**
     * Reads the SAP ABAP Syslog and returns it as an array of entries
     * (similar to sm21 transaction).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.SyslogEntry[] ABAPReadSyslog() throws java.rmi.RemoteException;

    /**
     * Reads the SAP ABAP Syslog and returns it as an array of raw
     * entries (similar to sm21 transaction).
     */
    public java.lang.String[] ABAPReadRawSyslog() throws java.rmi.RemoteException;

    /**
     * Returns a list of the ABAP workprocesses (similar to sm50 transaction).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.WorkProcess[] ABAPGetWPTable() throws java.rmi.RemoteException;

    /**
     * Achnowledge CCMS Alerts in the SAP ABAP system. Requires SAP
     * user credentials and a list of alert ids to acknowledge. Returns a
     * list of success code for each alerts (1=success, 0=failure).
     */
    public int[] ABAPAcknowledgeAlerts(java.lang.String r3Client, java.lang.String r3User, java.lang.String r3Password, java.lang.String[] aid) throws java.rmi.RemoteException;

    /**
     * Returns a list of j2ee processes controled by jcontrol (superceded
     * by J2EEGetProcessList2).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess[] j2EEGetProcessList() throws java.rmi.RemoteException;

    /**
     * Returns a list of j2ee processes controled by jcontrol (supercedes
     * J2EEGetProcessList).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess2[] j2EEGetProcessList2() throws java.rmi.RemoteException;

    /**
     * Performs a given function (EnableProcess, DisableProcess, RestartProcess,
     * DumpStackTrace, EnableDebugging, DisableDebugging, IncrementTrace,
     * DecrementTrace) on a given j2ee process.
     */
    public void j2EEControlProcess(java.lang.String processname, java.lang.String function) throws java.rmi.RemoteException;

    /**
     * Returns a list of threads in the j2ee instance (superceded
     * by J2EEGetThreadList2).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread[] j2EEGetThreadList() throws java.rmi.RemoteException;

    /**
     * Returns a list of threads in the j2ee instance (supercedes
     * J2EEGetThreadList).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEThread2[] j2EEGetThreadList2() throws java.rmi.RemoteException;

    /**
     * Returns a list of (Http) sessions in the j2ee instance (superceded
     * by J2EEGetWebSessionList).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EESession[] j2EEGetSessionList() throws java.rmi.RemoteException;

    /**
     * Returns a list of (Http) sessions in the j2ee instance (supercedes
     * J2EEGetSessionList).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEWebSession[] j2EEGetWebSessionList() throws java.rmi.RemoteException;

    /**
     * Returns a list of caches in the j2ee instance (superceded by
     * J2EEGetCacheStatistic2).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EECache[] j2EEGetCacheStatistic() throws java.rmi.RemoteException;

    /**
     * Returns a list of caches in the j2ee instance (supercedes J2EEGetCacheStatistic).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EECache2[] j2EEGetCacheStatistic2() throws java.rmi.RemoteException;

    /**
     * Returns a list of application aliases in the j2ee instance.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEApplicationAlias[] j2EEGetApplicationAliasList() throws java.rmi.RemoteException;

    /**
     * Returns a list of JAVA VM garbage collections in the j2ee instance
     * (superceded by J2EEGetVMGCHistory2).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.GCInfo[] j2EEGetVMGCHistory() throws java.rmi.RemoteException;

    /**
     * Returns a list of JAVA VM garbage collections in the j2ee instance
     * (supercedes J2EEGetVMGCHistory).
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.GCInfo2[] j2EEGetVMGCHistory2() throws java.rmi.RemoteException;

    /**
     * Returns a list of JAVA VM heap information.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.HeapInfo[] j2EEGetVMHeapInfo() throws java.rmi.RemoteException;

    /**
     * Returns a list of EJB sessions in the j2ee instance.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEEJBSession[] j2EEGetEJBSessionList() throws java.rmi.RemoteException;

    /**
     * Returns a list of remote object connections in the j2ee instance.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EERemoteObject[] j2EEGetRemoteObjectList() throws java.rmi.RemoteException;

    /**
     * Returns a list of J2EE cluster communication statistic from
     * the message server.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EEClusterMsg[] j2EEGetClusterMsgList() throws java.rmi.RemoteException;

    /**
     * Returns a list of SAP startup framework shared memory table
     * information.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.J2EESharedTableInfo[] j2EEGetSharedTableInfo() throws java.rmi.RemoteException;

    /**
     * Creates a J2EE debug session on  given node or automatically
     * selected node (processname = "") with the given debug flags (blank
     * seperated keywords "SuspendAll", "CodeIsolate", "LoadIsolate", "MigrateSessions")
     * for the gievn client name. Returns debug key an network port.
     */
    public void j2EEEnableDbgSession(java.lang.String processname, java.lang.String flags, java.lang.String client, javax.xml.rpc.holders.StringHolder key, javax.xml.rpc.holders.IntHolder port) throws java.rmi.RemoteException;

    /**
     * Removes a J2EE debug session created by J2EEEnableDbgSession.
     */
    public void j2EEDisableDbgSession(java.lang.String key) throws java.rmi.RemoteException;

    /**
     * Returns java callstack of specified J2EE thread or all J2EE
     * threads (index = -1).
     */
    public void j2EEGetThreadCallStack(int index, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Returns java taskstack of specified J2EE thread or all J2EE
     * threads (index = -1).
     */
    public void j2EEGetThreadTaskStack(int index, javax.xml.rpc.holders.StringHolder name, com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder lines) throws java.rmi.RemoteException;

    /**
     * Returns a list of threads used by ICM.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ICMThread[] ICMGetThreadList() throws java.rmi.RemoteException;

    /**
     * Returns a list of incomming network connections handled by
     * ICM.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ICMConnection[] ICMGetConnectionList() throws java.rmi.RemoteException;

    /**
     * Returns a list of objects cached by ICM.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ICMCacheEntry[] ICMGetCacheEntries() throws java.rmi.RemoteException;

    /**
     * Returns a list of outgoing network proxy connections handled
     * by ICM.
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection[] ICMGetProxyConnectionList() throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__EnqGetLockTable
     */
    public com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[] enqGetLockTable() throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__EnqRemoveLocks
     */
    public void enqRemoveLocks(com.sap.managementconsole.soap.axis.sapcontrol.EnqLock[] lock) throws java.rmi.RemoteException;

    /**
     * Service definition of function SAPControl__EnqGetStatistic
     */
    public void enqGetStatistic(javax.xml.rpc.holders.IntHolder ownerNow, javax.xml.rpc.holders.IntHolder ownerHigh, javax.xml.rpc.holders.IntHolder ownerMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder ownerState, javax.xml.rpc.holders.IntHolder argumentsNow, javax.xml.rpc.holders.IntHolder argumentsHigh, javax.xml.rpc.holders.IntHolder argumentsMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder argumentsState, javax.xml.rpc.holders.IntHolder locksNow, javax.xml.rpc.holders.IntHolder locksHigh, javax.xml.rpc.holders.IntHolder locksMax, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder locksState, javax.xml.rpc.holders.LongHolder enqueueRequests, javax.xml.rpc.holders.LongHolder enqueueRejects, javax.xml.rpc.holders.LongHolder enqueueErrors, javax.xml.rpc.holders.LongHolder dequeueRequests, javax.xml.rpc.holders.LongHolder dequeueErrors, javax.xml.rpc.holders.LongHolder dequeueAllRequests, javax.xml.rpc.holders.LongHolder cleanupRequests, javax.xml.rpc.holders.LongHolder backupRequests, javax.xml.rpc.holders.LongHolder reportingRequests, javax.xml.rpc.holders.LongHolder compressRequests, javax.xml.rpc.holders.LongHolder verifyRequests, javax.xml.rpc.holders.DoubleHolder lockTime, javax.xml.rpc.holders.DoubleHolder lockWaitTime, javax.xml.rpc.holders.DoubleHolder serverTime, com.sap.managementconsole.soap.axis.sapcontrol.holders.STATECOLORHolder replicationState) throws java.rmi.RemoteException;
}
