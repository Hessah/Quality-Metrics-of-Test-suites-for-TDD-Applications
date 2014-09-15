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
package com.sap.netweaver.porta.ide.eclipse.server.ui.wizard;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;
import com.sap.netweaver.porta.ide.eclipse.util.StatusUtil;

public class SapNWServerComposite extends Composite {
	
	protected IServerWorkingCopy server;
	private SapNWServer sapServer;
	
	private IWizardHandle wizard;
	
	private Text hostName;
	private Text instanceNumber;
	private Button pingServer;
	
	private boolean pinged;
	
	protected SapNWServerComposite(Composite parent, IWizardHandle wizard) {
		super(parent, SWT.NONE);
		this.wizard = wizard;
		
		wizard.setTitle("New Server for SAP NetWeaver");
		wizard.setDescription("Specify the host name and the instance number of a Java instance. ");
		
		// TODO wizard icon
		try {
			wizard.setImageDescriptor(ImageDescriptor.createFromURL(
					new URL(SapNWPlugin.getDefault().getBundle().getEntry("icons/"),
							"wizban/sap_wiz.png")));
		} catch (MalformedURLException e) {
			SapNWPlugin.logError("Cannot load wizard icon for the SAP NetWeaver server", e);
		}
		
		createControl();
	}

	protected void setServer(IServerWorkingCopy newServer) {
		if (newServer == null) {
			server = null;
			sapServer = null;
		} else {
			server = newServer;
			sapServer = (SapNWServer) server.loadAdapter(SapNWServer.class, null);
			
			// update the page title with the correct server version
			wizard.setTitle(String.format("New Server for %s", server.getRuntime().getRuntimeType().getName()));
		}
		
		init();
	}
	
	private void createControl() {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// TODO
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(this, ContextIds.SERVER_COMPOSITE);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("&Host name:");
		
		hostName = new Text(this, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		hostName.setLayoutData(data);
		hostName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				pinged = false;
				server.setHost(hostName.getText());
				validate();
			}
		});
	
		label = new Label(this, SWT.NONE);
		label.setText("&Instance number:");
		
		instanceNumber = new Text(this, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		instanceNumber.setLayoutData(data);
		instanceNumber.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				try {
					pinged = false;
					sapServer.setInstanceNumber(Integer.parseInt(instanceNumber.getText()));
				} catch (NumberFormatException exc) {
					// do nothing - the validation will catch this
				}
				validate();
			}
		});
		
		new Label(this, SWT.NONE);
		
		pingServer = new Button(this, SWT.PUSH);
		pingServer.setText("&Ping Server");
		data = new GridData(GridData.END, 0, false, false);
		pingServer.setLayoutData(data);
		pingServer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BusyIndicator.showWhile(getShell().getDisplay(), new Runnable() {
					public void run() {
						try {
							sapServer.getServerCore().ping();
							pinged = true;
							validate();
							MessageDialog.openInformation(getShell(), "Ping Successful", "Successfully connected to the specified server instance. ");
						} catch (CoreException exc) {
							SapNWPlugin.logError("Ping failed", exc);
							MessageDialog.openError(getShell(), "Ping Failed", "Cannot connect to the specified server instance. ");
						}
					}
				});
			}
		});
		
		Label note = new Label(this, SWT.WRAP);
		note.setText("Note: It is valid the server's host to differ from the host of the runtime location. ");
		GridData gd = new GridData(SWT.FILL, SWT.BEGINNING, false, false, 3, 0);
		gd.widthHint = 400; 
		note.setLayoutData(gd);
		
		init();
		
		Dialog.applyDialogFont(this);
		
		hostName.forceFocus();
	}
	
	protected void init() {
		if (server == null || hostName == null || hostName.isDisposed())
			return;
		
		hostName.setText(getDefaultHost());
		instanceNumber.setText(Integer.toString(sapServer.getInstanceNumber()));
		
		validate();
	}

	protected void validate() {
		if (server == null) {
			wizard.setMessage("Internal error: server is null", IMessageProvider.ERROR);
			return;
		}
		
		// validate the host
		IStatus status = validateHost(hostName.getText());
		// validate the instance number
		if (!StatusUtil.hasErrorMessage(status)) {
			status = StatusUtil.merge(status, validateInstanceNumber(instanceNumber.getText()));
		}
		// validate ping status
		if (!StatusUtil.hasErrorMessage(status)) {
			status = StatusUtil.merge(status, validatePingStatus());
		}
		
		if (status == null || status.isOK()) {
			wizard.setMessage(null, IMessageProvider.NONE);
		} else if (status.getSeverity() == IStatus.INFO) {
			wizard.setMessage(status.getMessage(), IMessageProvider.INFORMATION);
		} else if (status.getSeverity() == IStatus.WARNING) {
			wizard.setMessage(status.getMessage(), IMessageProvider.WARNING);
		} else {
			wizard.setMessage(status.getMessage(), IMessageProvider.ERROR);
		}
		
		pingServer.setEnabled(wizard.getMessageType() != IMessageProvider.ERROR);
		
		wizard.update();
	}
	
	IStatus validatePingStatus() {
		if (!pinged) {
			return new Status(IStatus.INFO, SapNWPlugin.PLUGIN_ID, IStatus.OK, "The server has not been pinged successfully yet. Use the Ping Server button. ", null);
		}
		return Status.OK_STATUS;
	}
	
	IStatus validateHost(String value) {
		if (value.trim().length() == 0) {
			return new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, "Host name must not be empty. ", null);
		}
		return Status.OK_STATUS;
	}
	
	IStatus validateInstanceNumber(String strValue) {
		boolean valid = true;
		try {
			int intValue = Integer.parseInt(strValue);
			if (intValue < 0 || intValue > 99) {
				valid = false;
			}
		} catch (NumberFormatException e) {
			valid = false;
		}
		
		if (!valid) {
			String message = "Instance number must be an integer in the range [0-99]. ";
			return new Status(IStatus.ERROR, SapNWPlugin.PLUGIN_ID, IStatus.OK, message, null);
		}
		return Status.OK_STATUS;
	}
	
	boolean isPinged() {
		return pinged;
	}
	
	private String getDefaultHost() {
		IPath runtimeLocation = server.getRuntime().getLocation();
		if (runtimeLocation.isUNC()) {
			return runtimeLocation.segment(0);
		} else if (server.getHost() != null) {
			return server.getHost();
		}
		return "localhost";
	}

}
