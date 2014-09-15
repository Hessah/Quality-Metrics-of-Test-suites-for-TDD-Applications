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
package com.sap.netweaver.porta.core.nw7;

import static com.sap.netweaver.porta.core.nw7.FaultReasons.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.AxisFault;
import org.junit.Test;

import com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DebugSessionInfo;
import com.sap.netweaver.porta.core.ServerState;

public class LifecycleManagerImplTest {
	
	private static final String HOST = "localhost";
	private static final int INST_NR = 73;
	
	private final LMUtils utils = new LMUtilsImpl();
	
	@Test
	public void testInitialize() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.initialize();
	}
	
	@Test(expected = CoreException.class)
	public void testInitialize_CoreException() throws Exception {
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andThrow(new MalformedURLException());
		
		replay(mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.initialize();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testInitialize_IllegalStateException() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		expect(mockUtils.getSAPControlWSProxyToFirstJ2EEInstance(mock)).andReturn(null);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.initialize();
	}
	
	@Test
	public void testStart() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.startSystem(StartStopOption.value1, "1", 30*60);
		expectLastCall();
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.start();
	}
	
	@Test
	public void testStart_InstanceAlreadyStarted() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.startSystem(StartStopOption.value1, "1", 30*60);
		expectLastCall().andThrow(new AxisFault(FAULT_INSTANCE_ALREADY_STARTED.getFaultReason()));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.start();
	}
	
	@Test(expected = CoreException.class)
	public void testStart_OtherFault() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.startSystem(StartStopOption.value1, "1", 30*60);
		expectLastCall().andThrow(new AxisFault("Other Fault"));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.start();
	}
	
	@Test
	public void testStop() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.stopSystem(StartStopOption.value1, "1", 0, 30*60);
		expectLastCall();
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.stop();
	}
	
	@Test
	public void testRestart() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.restartSystem(StartStopOption.value5, "1", 30*60, 0);
		expectLastCall();
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.restart();
	}
	
	@Test
	public void testRestart_InstanceAlreadyStarted() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.restartSystem(StartStopOption.value5, "1", 30*60, 0);
		expectLastCall().andThrow(new AxisFault(FAULT_INSTANCE_ALREADY_STARTED.getFaultReason()));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.restart();
	}
	
	@Test(expected = CoreException.class)
	public void testRestart_OtherFault() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.restartSystem(StartStopOption.value5, "1", 30*60, 0);
		expectLastCall().andThrow(new AxisFault("Other Fault"));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.restart();
	}
	
	@Test
	public void testEnableDebugging() throws Exception {
		SAPControlPortType mock = createMock(SAPControlPortType.class);
		mock.j2EEEnableDbgSession((String) anyObject(), (String) anyObject(), (String) anyObject(), (StringHolder) anyObject(), (IntHolder) anyObject());
		expectLastCall();
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		DebugSessionInfo info = lm.enableDebugging();
		assertNotNull(info);
	}
	
	@Test
	public void testDisableDebugging() throws Exception {
		String key = "debug-key";
		
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.j2EEDisableDbgSession(key);
		expectLastCall();
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.disableDebugging(key);
	}
	
	@Test
	public void testDisableDebugging_DebugSessionWrongState() throws Exception {
		String key = "debug-key";
		
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.j2EEDisableDbgSession(key);
		expectLastCall().andThrow(new AxisFault(FAULT_END_DEBUG_SESSION_WRONG_STATE.getFaultReason()));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.disableDebugging(key);
	}
	
	@Test(expected = CoreException.class)
	public void testDisableDebugging_OtherFault() throws Exception {
		String key = "debug-key";
		
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		mock.j2EEDisableDbgSession(key);
		expectLastCall().andThrow(new AxisFault("Other Fault"));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		lm.disableDebugging(key);
	}
	
	@Test
	public void testGetState() throws Exception {
		J2EEProcess p = new J2EEProcess();
		p.setName("server0");
		p.setType("J2EE Server");
		p.setState(J2EEPSTATE.value4); // running
		
		J2EEProcess[] processes = new J2EEProcess[] { p };
		
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		expect(mock.j2EEGetProcessList()).andReturn(processes);
		
		LMUtils mockUtils = createUtilsMock(mock);
		expect(mockUtils.determineServerState(processes)).andReturn(ServerState.RUNNING);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		assertEquals(ServerState.RUNNING, lm.getState());
	}
	
	@Test
	public void testGetState_ShmNotFound() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		expect(mock.j2EEGetProcessList()).andThrow(new AxisFault(FAULT_SHM_NOT_FOUND.getFaultReason()));
		
		LMUtils mockUtils = createUtilsMock(mock);
		
		replay(mock, mockUtils);
		
		LifecycleManagerImpl lm = new LifecycleManagerImpl(HOST, INST_NR, mockUtils);
		assertEquals(ServerState.STOPPED, lm.getState());
	}
	
	private LMUtils createUtilsMock(SAPControlPortType control) throws Exception {
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(control);
		expect(mockUtils.getSAPControlWSProxyToFirstJ2EEInstance(control)).andReturn(control);
		return mockUtils;
	}
	
}
