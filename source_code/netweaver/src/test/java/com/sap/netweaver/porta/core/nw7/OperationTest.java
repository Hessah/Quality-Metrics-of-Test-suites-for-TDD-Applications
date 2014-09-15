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

import java.rmi.RemoteException;

import javax.xml.rpc.Stub;

import org.apache.axis.AxisFault;
import org.junit.Test;

import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.AuthenticationRefusedException;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Credentials;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class OperationTest {
	
	@Test
	public void testExecute_Normal() throws Exception {
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall();
		expect(mock.getResult()).andReturn("Success");
		
		replay(mock);
		assertEquals("Success", new Operation(mock).execute());
	}
	
	@Test
	public void testExecute_Unauthorized() throws Exception {
		AxisFault fault = new AxisFault();
		fault.setFaultReason(FaultReasons.FAULT_UNAUTHORIZED.getFaultReason());
		
		AuthenticationCallback callback = new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				assertEquals(AuthenticationReason.AUTHORIZATION_REQUIRED, reason);
				return new Credentials("user", "pass");
			}
		};
		
		Stub stubMock = createStrictMock(Stub.class);
		stubMock._setProperty(Stub.USERNAME_PROPERTY, "user");
		expectLastCall();
		stubMock._setProperty(Stub.PASSWORD_PROPERTY, "pass");
		expectLastCall();
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.getAuthenticationCallback()).andReturn(callback);
		mock.setCredentials("user", "pass");
		expectLastCall();
		mock.executeOperation();
		expectLastCall();
		expect(mock.getResult()).andReturn("Success");
		
		replay(mock, stubMock);
		assertEquals("Success", new Operation(mock).execute());
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void testExecute_NoCallback() throws Exception {
		AxisFault fault = new AxisFault();
		fault.setFaultReason(FaultReasons.FAULT_UNAUTHORIZED.getFaultReason());
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.getAuthenticationCallback()).andReturn(null);
		
		replay(mock);
		new Operation(mock).execute();
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void testExecute_AutorizationRefused() throws Exception {
		AxisFault fault = new AxisFault();
		fault.setFaultReason(FaultReasons.FAULT_UNAUTHORIZED.getFaultReason());
		
		AuthenticationCallback callback = new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				throw new AuthenticationRefusedException();
			}
		};
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.getAuthenticationCallback()).andReturn(callback);
		
		replay(mock);
		new Operation(mock).execute();
	}
	
	@Test
	public void testExecute_InvalidCredentials() throws Exception {
		AxisFault fault = new AxisFault();
		fault.setFaultReason(FaultReasons.FAULT_INVALID_CREDENTIALS.getFaultReason());
		
		AuthenticationCallback callback = new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				assertEquals(AuthenticationReason.INVALID_CREDENTIALS, reason);
				return new Credentials("user", "pass");
			}
		};
		
		Stub stubMock = createStrictMock(Stub.class);
		stubMock._setProperty(Stub.USERNAME_PROPERTY, "user");
		expectLastCall();
		stubMock._setProperty(Stub.PASSWORD_PROPERTY, "pass");
		expectLastCall();
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.getAuthenticationCallback()).andReturn(callback);
		mock.setCredentials("user", "pass");
		expectLastCall();
		mock.executeOperation();
		expectLastCall();
		expect(mock.getResult()).andReturn("Success");
		
		replay(mock, stubMock);
		assertEquals("Success", new Operation(mock).execute());
	}
	
	@Test
	public void testExecute_PermissionDenied() throws Exception {
		AxisFault fault = new AxisFault();
		fault.setFaultReason(FaultReasons.FAULT_PERMISSION_DENIED.getFaultReason());
		
		AuthenticationCallback callback = new AuthenticationCallback() {
			public Credentials getCredentials(AuthenticationReason reason)
					throws CoreException, AuthenticationRefusedException {
				assertEquals(AuthenticationReason.PERMISSION_DENIED, reason);
				return new Credentials("user", "pass");
			}
		};
		
		Stub stubMock = createStrictMock(Stub.class);
		stubMock._setProperty(Stub.USERNAME_PROPERTY, "user");
		expectLastCall();
		stubMock._setProperty(Stub.PASSWORD_PROPERTY, "pass");
		expectLastCall();
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.getAuthenticationCallback()).andReturn(callback);
		mock.setCredentials("user", "pass");
		expectLastCall();
		mock.executeOperation();
		expectLastCall();
		expect(mock.getResult()).andReturn("Success");
		
		replay(mock, stubMock);
		assertEquals("Success", new Operation(mock).execute());
	}
	
	@Test
	public void testExecute_OtherFault() throws Exception {
		AxisFault fault = new AxisFault();
		
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(fault);
		expect(mock.handleFault(fault)).andReturn(false);
		expect(mock.getResult()).andReturn("Success");
		
		replay(mock);
		assertEquals("Success", new Operation(mock).execute());
	}
	
	@Test(expected = CoreException.class)
	public void testExecute_RemoteException() throws Exception {
		OperationContext mock = createStrictMock(OperationContext.class);
		mock.executeOperation();
		expectLastCall().andThrow(new RemoteException());
		
		replay(mock);
		new Operation(mock).execute();
	}

}
