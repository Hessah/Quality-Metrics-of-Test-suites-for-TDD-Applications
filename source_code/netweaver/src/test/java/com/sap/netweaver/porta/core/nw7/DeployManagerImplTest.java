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

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.engine.services.dc.wsgate.Option;
import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.DeployResultStatus;

public class DeployManagerImplTest {
	
	private static final String HOST = "localhost";
	private static final int INST_NR = 73;
	private static final int PORT = 57300;
	
	private final LMUtils lmUtils = new LMUtilsImpl();
	private final DMUtils dmUtils = new DMUtilsImpl();
	
	@Test
	public void testInitialize() throws Exception {
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(createStrictMock(FileUploader.class));
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		dm.initialize();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testInitialize_IllegalStateException() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		URL wsUrl = lmUtils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		
		LMUtils mockLMUtils = createStrictMock(LMUtils.class);
		expect(mockLMUtils.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mockLMUtils.getSAPControlWSProxy(wsUrl)).andReturn(mock);
		expect(mockLMUtils.getSAPControlWSProxyToFirstJ2EEInstance(mock)).andReturn(null);
		
		replay(mock, mockLMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, dmUtils);
		dm.initialize();
	}
	
	@Test
	public void testDeploy() throws Exception {
		String[] paths = new String[] { "/tmp/file.txt" };
		File[] files = new File[] { new File(paths[0]) };
		com.sap.engine.services.dc.wsgate.DeployResult deployWSResult = 
			new com.sap.engine.services.dc.wsgate.DeployResult();
		com.sap.netweaver.porta.core.nw7.DeployResultImpl deployResult = 
			new com.sap.netweaver.porta.core.nw7.DeployResultImpl(DeployResultStatus.SUCCESS, "");
		
		FileUploader mockUploader = createStrictMock(FileUploader.class);
		expect(mockUploader.upload(files)).andReturn(paths);
		
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(mockUploader);
		expect(mock.deployLocal((String[]) anyObject(), (Option[]) anyObject())).andReturn(deployWSResult);
		expect(mockDMUtils.convertDeployResult(deployWSResult)).andReturn(deployResult);
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		DeployResult result = dm.deploy(files);
		assertEquals(deployResult, result);
	}
	
	@Test
	public void testUndeploy() throws Exception {
		com.sap.engine.services.dc.wsgate.Application app = 
			new com.sap.engine.services.dc.wsgate.Application("id", "location", "name", "status", "vendor", "version");
		com.sap.engine.services.dc.wsgate.Application[] apps = 
			new com.sap.engine.services.dc.wsgate.Application[] { app };
		com.sap.netweaver.porta.core.Application application = 
			new com.sap.netweaver.porta.core.nw7.ApplicationImpl(app);
		com.sap.netweaver.porta.core.Application[] applications = 
			new com.sap.netweaver.porta.core.Application[] { application };
		com.sap.engine.services.dc.wsgate.DeployResult undeployWSResult = 
			new com.sap.engine.services.dc.wsgate.DeployResult();
		com.sap.netweaver.porta.core.nw7.DeployResultImpl undeployResult = 
			new com.sap.netweaver.porta.core.nw7.DeployResultImpl(DeployResultStatus.SUCCESS, "");
		
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(createStrictMock(FileUploader.class));
		expect(mockDMUtils.convertApplication(application)).andReturn(app);
		expect(mock.undeploy(aryEq(apps), (Option[]) anyObject())).andReturn(undeployWSResult);
		expect(mockDMUtils.convertDeployResult(undeployWSResult)).andReturn(undeployResult);
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		DeployResult result = dm.undeploy(applications);
		assertEquals(undeployResult, result);
	}
	
	@Test
	public void testGetApplications() throws Exception {
		com.sap.engine.services.dc.wsgate.Application app = 
			new com.sap.engine.services.dc.wsgate.Application("id", "location", "name", "status", "vendor", "version");
		com.sap.engine.services.dc.wsgate.Application[] apps = 
			new com.sap.engine.services.dc.wsgate.Application[] { app };
		com.sap.netweaver.porta.core.Application application = 
			new com.sap.netweaver.porta.core.nw7.ApplicationImpl(app);
		com.sap.netweaver.porta.core.Application[] applications = 
			new com.sap.netweaver.porta.core.Application[] { application };
		
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(createStrictMock(FileUploader.class));
		expect(mock.getApplications((Option[]) anyObject())).andReturn(apps);
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		com.sap.netweaver.porta.core.Application[] result = dm.getApplications();
		assertArrayEquals(applications, result);
	}
	
	@Test
	public void testStartApplication() throws Exception {
		com.sap.engine.services.dc.wsgate.Application[] apps = new  com.sap.engine.services.dc.wsgate.Application[] {
				new com.sap.engine.services.dc.wsgate.Application("id", "location", "name", "status", "vendor", "version")
		};
		com.sap.netweaver.porta.core.Application[] applications = new com.sap.netweaver.porta.core.Application[] {
				new com.sap.netweaver.porta.core.nw7.ApplicationImpl(apps[0])
		};
		
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(createStrictMock(FileUploader.class));
		expect(mockDMUtils.convertApplications(applications)).andReturn(apps);
		expect(mockDMUtils.convertApplications(apps)).andReturn(applications);
		expect(mock.start(apps, null)).andReturn(apps);
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		com.sap.netweaver.porta.core.Application[] result = dm.start(applications);
		assertArrayEquals(applications, result);
	}
	
	@Test
	public void testStopApplication() throws Exception {
		com.sap.engine.services.dc.wsgate.Application[] apps = new  com.sap.engine.services.dc.wsgate.Application[] {
				new com.sap.engine.services.dc.wsgate.Application("id", "location", "name", "status", "vendor", "version")
		};
		com.sap.netweaver.porta.core.Application[] applications = new com.sap.netweaver.porta.core.Application[] {
				new com.sap.netweaver.porta.core.nw7.ApplicationImpl(apps[0])
		};
		
		DeployWSPortType mock = createStrictMock(DeployWSPortType.class);
		LMUtils mockLMUtils = createLMUtilsMock();
		DMUtils mockDMUtils = createDMUtilsMock(mock);
		expect(mockDMUtils.getFileUploader(HOST, PORT)).andReturn(createStrictMock(FileUploader.class));
		expect(mockDMUtils.convertApplications(applications)).andReturn(apps);
		expect(mockDMUtils.convertApplications(apps)).andReturn(applications);
		expect(mock.stop(apps, null)).andReturn(apps);
		
		replay(mock, mockLMUtils, mockDMUtils);
		
		DeployManagerImpl dm = new DeployManagerImpl(HOST, INST_NR, mockLMUtils, mockDMUtils);
		com.sap.netweaver.porta.core.Application[] result = dm.stop(applications);
		assertArrayEquals(applications, result);
	}
	
	private LMUtils createLMUtilsMock() throws Exception {
		SAPControlPortType control = createStrictMock(SAPControlPortType.class);
		URL wsUrl = lmUtils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		AccessPoint accessPoint = new AccessPoint();
		accessPoint.setAddress(HOST);
		accessPoint.setPort(PORT);
		
		LMUtils mock = createStrictMock(LMUtils.class);
		expect(mock.getSAPControlWSUrlByInstance(HOST, INST_NR)).andReturn(wsUrl);
		expect(mock.getSAPControlWSProxy(wsUrl)).andReturn(control);
		expect(mock.getSAPControlWSProxyToFirstJ2EEInstance(control)).andReturn(control);
		expect(mock.findIcmHttpAccessPoint(control)).andReturn(accessPoint);
		
		return mock;
	}
	
	private DMUtils createDMUtilsMock(DeployWSPortType deploy) throws Exception {
		URL wsUrl = dmUtils.getDeployWSUrl(HOST, PORT);
		DMUtils mock = createStrictMock(DMUtils.class);
		expect(mock.getDeployWSUrl(HOST, PORT)).andReturn(wsUrl);
		expect(mock.getDeployWSProxy(wsUrl)).andReturn(deploy);
		return mock;
	}

}
