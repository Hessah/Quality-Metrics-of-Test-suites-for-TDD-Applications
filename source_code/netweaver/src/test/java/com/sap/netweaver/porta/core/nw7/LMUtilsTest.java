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

import java.net.URL;

import org.junit.Test;

import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEPSTATE;
import com.sap.managementconsole.soap.axis.sapcontrol.J2EEProcess;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPInstance;
import com.sap.managementconsole.soap.axis.sapcontrol.STATECOLOR;
import com.sap.netweaver.porta.core.ServerState;

public class LMUtilsTest {
	
	private static final String HOST = "my-host";
	private static final int PORT = 57313;
	private static final int INST_NR = 73;
	
	private final LMUtils utils = new LMUtilsImpl();
	
	@Test
	public void testConstructor() throws Exception {
		new LMUtilsImpl();
	}
	
	@Test
	public void testGetSAPControlWSUrlByPort() throws Exception {
		URL url = utils.getSAPControlWSUrlByPort(HOST, PORT);
		String urlStr = String.format("http://%s:%d/SAPControl.cgi", HOST, PORT);
		assertEquals(urlStr, url.toString());
	}
	
	@Test
	public void testGetSAPControlWSUrlByInstance() throws Exception {
		URL url = utils.getSAPControlWSUrlByInstance(HOST, INST_NR);
		String urlStr = String.format("http://%s:%d/SAPControl.cgi", HOST, PORT);
		assertEquals(urlStr, url.toString());
	}
	
	@Test
	public void testGetSAPControlWSProxy() throws Exception {
		URL wsUrl = utils.getSAPControlWSUrlByPort(HOST, PORT);
		SAPControlPortType portType = utils.getSAPControlWSProxy(wsUrl);
		assertNotNull(portType);
	}
	
	@Test
	public void testGetSAPControlWSProxyToFirstJ2EEInstance() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		InstanceProperty[] props = new InstanceProperty[] {
				new InstanceProperty("some property", "", ""), 
				new InstanceProperty("J2EE Process Table", "", "")
		};
		
		expect(mock.getInstanceProperties()).andReturn(props);
		
		replay(mock);
		SAPControlPortType j2ee = utils.getSAPControlWSProxyToFirstJ2EEInstance(mock);
		assertEquals(mock, j2ee);
	}
	
	@Test
	public void testGetSAPControlWSProxyToFirstJ2EEInstance2() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		InstanceProperty[] props = new InstanceProperty[] {
				new InstanceProperty("some property", "", ""), 
				new InstanceProperty("another property", "", "")
		};
		
		SAPInstance[] instances = new SAPInstance[] {
				new SAPInstance("", 0, 0, 0, "", "", STATECOLOR.value1), 
				new SAPInstance(HOST, INST_NR, PORT, 1234, "", "ICM|J2EE|OTHER", STATECOLOR.value2)
		};
		
		expect(mock.getInstanceProperties()).andReturn(props);
		expect(mock.getSystemInstanceList()).andReturn(instances);
		
		replay(mock);
		SAPControlPortType j2ee = utils.getSAPControlWSProxyToFirstJ2EEInstance(mock);
		assertNotNull(j2ee);
		assertNotSame(mock, j2ee);
	}
	
	@Test
	public void testGetSAPControlWSProxyToFirstJ2EEInstance3() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		InstanceProperty[] props = new InstanceProperty[] {
				new InstanceProperty("some property", "", ""), 
				new InstanceProperty("another property", "", "")
		};
		
		SAPInstance[] instances = new SAPInstance[] {
				new SAPInstance("", 0, 0, 0, "", "", STATECOLOR.value1), 
				new SAPInstance(HOST, INST_NR, PORT, 1234, "", "ICM|OTHER", STATECOLOR.value2)
		};
		
		expect(mock.getInstanceProperties()).andReturn(props);
		expect(mock.getSystemInstanceList()).andReturn(instances);
		
		replay(mock);
		SAPControlPortType j2ee = utils.getSAPControlWSProxyToFirstJ2EEInstance(mock);
		assertNull(j2ee);
	}
	
	@Test
	public void testFindIcmHttpAccessPoint() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		AccessPoint[] points = new AccessPoint[] {
				new AccessPoint("localhost", 2222, "TELNET", "icm", ""), 
				new AccessPoint("localhost", 8888, "HTTP", "other", ""), 
				new AccessPoint("localhost", 8080, "HTTP", "icm", "")
		};
		
		expect(mock.getAccessPointList()).andReturn(points);
		
		replay(mock);
		AccessPoint point = utils.findIcmHttpAccessPoint(mock);
		assertNotNull(point);
		assertEquals(points[2], point);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFindIcmHttpAccessPoint2() throws Exception {
		SAPControlPortType mock = createStrictMock(SAPControlPortType.class);
		
		AccessPoint[] points = new AccessPoint[] {
				new AccessPoint("localhost", 2222, "TELNET", "icm", ""), 
				new AccessPoint("localhost", 8888, "HTTP", "other", ""), 
		};
		
		expect(mock.getAccessPointList()).andReturn(points);
		
		replay(mock);
		utils.findIcmHttpAccessPoint(mock);
	}
	
	@Test
	public void testDetermineServerState_NoProcesses() throws Exception {
		assertEquals(ServerState.STOPPED, utils.determineServerState(null));
		assertEquals(ServerState.STOPPED, utils.determineServerState(new J2EEProcess[] { }));
	}
	
	@Test
	public void testDetermineServerState_Bootstrap() throws Exception {
		J2EEProcess bootstrap = new J2EEProcess();
		bootstrap.setType("J2EE Bootstrap");
		assertEquals(ServerState.STARTING, utils.determineServerState(new J2EEProcess[] { bootstrap }));
	}
	
	@Test
	public void testDetermineServerState_Initial() throws Exception {
		J2EEProcess process = new J2EEProcess();
		process.setType("J2EE Server");
		process.setStatetext("Initial");
		assertEquals(ServerState.STARTING, utils.determineServerState(new J2EEProcess[] { process }));
	}
	
	@Test
	public void testDetermineServerState_AllRunning() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value4); // running
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value4); // running

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value4); // running
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.RUNNING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_OneRunning() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value4); // running

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value2); // starting
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.RUNNING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStopped() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value1); // stopped

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.STOPPED, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStoppedOneStaring() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value2); // starting

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.STARTING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStoppedOneCoreRunning() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value3); // core running

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value1); // stopped
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.STARTING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStopping() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value5); // stopping
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value5); // stopping

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value5); // stopping
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.STOPPING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStoppedOneStopping() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value5); // stopped
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value5); // stopped

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value1); // stopping
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.STOPPING, utils.determineServerState(processes));
	}
	
	@Test
	public void testDetermineServerState_AllStrange() throws Exception {
		J2EEProcess p0 = new J2EEProcess();
		p0.setName("server0");
		p0.setType("J2EE Server");
		p0.setState(J2EEPSTATE.value6); // maintenance
		
		J2EEProcess p1 = new J2EEProcess();
		p1.setName("server1");
		p1.setType("J2EE Server");
		p1.setState(J2EEPSTATE.value6); // maintenance

		J2EEProcess p2 = new J2EEProcess();
		p2.setName("server2");
		p2.setType("J2EE Server");
		p2.setState(J2EEPSTATE.value7); // unknown
		
		J2EEProcess[] processes = new J2EEProcess[] { p0, p1, p2 }; 
		
		assertEquals(ServerState.UNKNOWN, utils.determineServerState(processes));
	}

}
