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

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.LifecycleManager;

public class ServerImplTest {
	
	private static final String HOST = "localhost";
	private static final int INST_NR = 73;
	
	private final LMUtils utils = new LMUtilsImpl();
	
	@Test
	public void testGetLifecycleManager() throws Exception {
		ServerImpl server = new ServerImpl(HOST, INST_NR);
		LifecycleManager lm1 = server.getLifecycleManager();
		assertNotNull(lm1);
		LifecycleManager lm2 = server.getLifecycleManager();
		assertEquals(lm2, lm1);
	}
	
	@Test
	public void testGetDeployManager() throws Exception {
		ServerImpl server = new ServerImpl(HOST, INST_NR);
		DeployManager dm1 = server.getDeployManager();
		assertNotNull(dm1);
		DeployManager dm2 = server.getDeployManager();
		assertEquals(dm2, dm1);
	}
	
	@Test
	public void testGetSystemName() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		expect(mock.parameterValue("SAPSYSTEMNAME")).andReturn("SID");
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		assertEquals("SID", server.getSystemName());
	}
	
	@Test(expected = CoreException.class)
	public void testGetSystemName_MalformedURLException() throws Exception {
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andThrow(new MalformedURLException());
		
		replay(mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getSystemName();
	}
	
	@Test(expected = CoreException.class)
	public void testGetSystemName_ServiceException() throws Exception {
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andThrow(new ServiceException());
		
		replay(mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getSystemName();
	}
	
	@Test(expected = CoreException.class)
	public void testGetSystemName_RemoteException() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		expect(mock.parameterValue("SAPSYSTEMNAME")).andThrow(new RemoteException());
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getSystemName();
	}
	
	@Test
	public void testPing() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		expect(mock.parameterValue("SAPSYSTEMNAME")).andReturn("SID");
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.ping();
	}
	
	@Test
	public void testGetHttpAccessPoint() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		AccessPoint accessPoint = new AccessPoint();
		accessPoint.setAddress(HOST);
		accessPoint.setPort(57300);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		expect(mockUtils.getSAPControlWSProxyToFirstJ2EEInstance(mock)).andReturn(mock);
		expect(mockUtils.findIcmHttpAccessPoint(mock)).andReturn(accessPoint);
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		InetSocketAddress socketAddress = server.getHttpAccessPoint();
		assertEquals(HOST, socketAddress.getHostName());
		assertEquals(57300, socketAddress.getPort());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetHttpAccessPoint_IllegalStateException() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		expect(mockUtils.getSAPControlWSProxyToFirstJ2EEInstance(mock)).andReturn(null);
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getHttpAccessPoint();
	}
	
	@Test(expected = CoreException.class)
	public void testGetHttpAccessPoint_MalformedURLException() throws Exception {
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andThrow(new MalformedURLException());
		
		replay(mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getHttpAccessPoint();
	}
	
	@Test(expected = CoreException.class)
	public void testGetHttpAccessPoint_ServiceException() throws Exception {
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andThrow(new ServiceException());
		
		replay(mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getHttpAccessPoint();
	}
	
	@Test(expected = CoreException.class)
	public void testGetHttpAccessPoint_RemoteException() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		URL wsUrl = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockUtils = createStrictMock(LMUtils.class);
		expect(mockUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		expect(mockUtils.getSAPControlWSProxyToFirstJ2EEInstance(mock)).andReturn(mock);
		expect(mockUtils.findIcmHttpAccessPoint(mock)).andThrow(new RemoteException());
		
		replay(mock, mockUtils);
		
		ServerImpl server = new ServerImpl(HOST, INST_NR, mockUtils);
		server.getHttpAccessPoint();
	}

}
