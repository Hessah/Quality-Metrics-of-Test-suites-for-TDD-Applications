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

import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.Stub;

import org.apache.axis.AxisFault;

import com.sap.engine.services.dc.wsgate.DeployWSPortType;
import com.sap.engine.services.dc.wsgate.Option;
import com.sap.managementconsole.soap.axis.sapcontrol.AccessPoint;
import com.sap.managementconsole.soap.axis.sapcontrol.SAPControlPortType;
import com.sap.netweaver.porta.core.Application;
import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.DeployManager;
import com.sap.netweaver.porta.core.DeployResult;
import com.sap.netweaver.porta.core.NoWSGateException;
import com.sap.netweaver.porta.core.NotAuthorizedException;

public class DeployManagerImpl extends CoreModuleImpl implements DeployManager {
	
	private abstract class DeployOperationContext implements OperationContext {
		
		protected Object result;

		public AuthenticationCallback getAuthenticationCallback() {
			return callback;
		}

		public void setCredentials(String user, String password) {
			Stub stub = (Stub) deploy;
			stub._setProperty(Stub.USERNAME_PROPERTY, user);
			stub._setProperty(Stub.PASSWORD_PROPERTY, password);
			
			fileUploader.setCredentials(user, password);
		}

		public Object getResult() {
			return result;
		}

		public boolean handleFault(AxisFault fault) throws CoreException {
			if (FAULT_NOT_FOUND.getFaultReason().equals(fault.getFaultReason())) {
				String endpoint = (String) ((Stub) deploy)._getProperty(Stub.ENDPOINT_ADDRESS_PROPERTY);
				throw new NoWSGateException(fault, endpoint);
			}
			
			throw new CoreException(fault);
		}

	}
	
	private final LMUtils lmUtils;
	private final DMUtils dmUtils;
	
	private DeployWSPortType deploy;
//	private boolean local;
	
	private FileUploader fileUploader;
	
	public DeployManagerImpl(String host, int instNr) {
		this(host, instNr, new LMUtilsImpl(), new DMUtilsImpl());
	}
	
	DeployManagerImpl(String host, int instNr, LMUtils lmUtils, DMUtils dmUtils) {
		super(host, instNr);
		this.lmUtils = lmUtils;
		this.dmUtils = dmUtils;
		// to be initialized on first usage
		this.deploy = null;
	}

	protected void initialize() throws CoreException {
		try {
			// establish ws proxy to the SAPControl of the first J2EE instance
			URL url = lmUtils.getSAPControlWSUrlByInstance(host, instNr);
			SAPControlPortType control = lmUtils.getSAPControlWSProxy(url);
			SAPControlPortType j2ee = lmUtils.getSAPControlWSProxyToFirstJ2EEInstance(control);
			if (j2ee == null)
				throw new IllegalStateException("cannot determine the J2EE instance");
			
			// determine the deployWSUrl
			AccessPoint icmHttp = lmUtils.findIcmHttpAccessPoint(j2ee);
			URL deployWSUrl = dmUtils.getDeployWSUrl(icmHttp.getAddress(), icmHttp.getPort());
			
			// establish ws proxy to the DeplowWS of the J2EE instance
			deploy = dmUtils.getDeployWSProxy(deployWSUrl);
			
			// initialize the file uploader client
			fileUploader = dmUtils.getFileUploader(icmHttp.getAddress(), icmHttp.getPort());
			
//			try {
//				// determine whether the J2EE instance is on the local host of the deploy client
//				String host = deployWSUrl.getHost();
//				local = InetAddress.getByName(host).isLoopbackAddress() || 
//						InetAddress.getLocalHost().getHostAddress().equals(host);
//			} catch (UnknownHostException e) {
//				// cannot determine if the web service's host is local or remote. Assume it is remote
//				local = false;
//			}
		} catch (IllegalStateException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}
	
	protected boolean initialized() {
		return deploy != null; 
	}

	public DeployResult deploy(final File[] archives) throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		Object result = new Operation(new DeployOperationContext() {
			public void executeOperation() throws CoreException, RemoteException {
				String[] archivePaths = fileUploader.upload(archives);
				
				com.sap.engine.services.dc.wsgate.DeployResult deployResult =
					deploy.deployLocal(archivePaths, 
							new Option[] {
								new Option("delete.files", "true"), 
								new Option("delete.parent.folder", "true")
							});
				super.result = dmUtils.convertDeployResult(deployResult);
			}
		}).execute();
		
		return (DeployResult) result;
	}

	public Application[] getApplications() throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		Object result = new Operation(new DeployOperationContext() {
			public void executeOperation() throws RemoteException {
				super.result = deploy.getApplications(new Option[] { new Option("only.javaee", "true") });
				// if result is empty list, then Axis returns null
				// return empty array to avoid NPE on client side
				if (super.result == null) {
					super.result = new com.sap.engine.services.dc.wsgate.Application[0];
				}
			}
		}).execute();
		
		com.sap.engine.services.dc.wsgate.Application[] listedApp = ((com.sap.engine.services.dc.wsgate.Application[]) result);
		Application[] applications = new Application[listedApp.length];
		for (int i = 0; i < listedApp.length; i++) {
			applications[i] = new ApplicationImpl(listedApp[i]);
		}
		
		return applications;
	}

	public Application[] start(Application[] apps) throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		final com.sap.engine.services.dc.wsgate.Application[] applications = dmUtils.convertApplications(apps);
		
		Object result = new Operation(new DeployOperationContext() {
			public void executeOperation() throws RemoteException {
				super.result = deploy.start(applications, null);
			}
		}).execute();
		
		return dmUtils.convertApplications((com.sap.engine.services.dc.wsgate.Application[]) result);
	}

	public Application[] stop(Application[] apps) throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		final com.sap.engine.services.dc.wsgate.Application[] applications = dmUtils.convertApplications(apps);
		
		Object result = new Operation(new DeployOperationContext() {
			public void executeOperation() throws RemoteException {
				super.result = deploy.stop(applications, null);
			}
		}).execute();
		
		return dmUtils.convertApplications((com.sap.engine.services.dc.wsgate.Application[]) result);
	}

	public DeployResult undeploy(Application[] apps) throws NotAuthorizedException, CoreException {
		checkInitialized();
		
		final com.sap.engine.services.dc.wsgate.Application[] applications = new com.sap.engine.services.dc.wsgate.Application[apps.length];
		for (int i = 0; i < applications.length; i++) {
			applications[i] = dmUtils.convertApplication(apps[i]);
		}	
		
		Object result = new Operation(new DeployOperationContext() {
			public void executeOperation() throws RemoteException {
				com.sap.engine.services.dc.wsgate.DeployResult undeployResult = deploy.undeploy(applications, null);
				super.result = dmUtils.convertDeployResult(undeployResult);
			}
		}).execute();
		
		return (DeployResult) result;
	}

}
