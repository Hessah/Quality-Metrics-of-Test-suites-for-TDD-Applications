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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.runtime.SapNWRuntime;

public class SapNWRuntimeComposite extends Composite {
	
	protected IRuntimeWorkingCopy runtime;
	protected SapNWRuntime sapRuntime;
	
	private IWizardHandle wizard;
	
	private Text installDir;
	private Text name;
	private Button cacheJars;
	
	protected SapNWRuntimeComposite(Composite parent, IWizardHandle wizard) {
		super(parent, SWT.NONE);
		this.wizard = wizard;
		
		wizard.setTitle("New Runtime for SAP NetWeaver");
		wizard.setDescription("Specify the location of a Java instance. Use the Browse... button. ");
		
		// TODO wizard icon
		try {
			wizard.setImageDescriptor(ImageDescriptor.createFromURL(
					new URL(SapNWPlugin.getDefault().getBundle().getEntry("icons/"),
							"wizban/sap_wiz.png")));
		} catch (MalformedURLException e) {
			SapNWPlugin.logError("Cannot load wizard icon for the SAP NetWeaver runtime", e);
		}
		
		createControl();
	}

	protected void setRuntime(IRuntimeWorkingCopy newRuntime) {
		if (newRuntime == null) {
			runtime = null;
			sapRuntime = null;
		} else {
			runtime = newRuntime;
			sapRuntime = (SapNWRuntime) runtime.loadAdapter(SapNWRuntime.class, null);
			
			// update the page title with the correct runtime version
			wizard.setTitle(String.format("New Runtime for %s", runtime.getRuntimeType().getName()));
		}
		
		init();
		validate();
	}
	
	private void createControl() {
		setLayout(new GridLayout(2, false));
		setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		// TODO
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(this, ContextIds.RUNTIME_COMPOSITE);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Na&me:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		
		name = new Text(this, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		name.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				runtime.setName(name.getText());
				validate();
			}
		});
		
		// spacer
		new Label(this, SWT.NONE);
		
		Group jarsGroup = new Group(this, SWT.NONE);
		jarsGroup.setLayout(new GridLayout(3, false));
		jarsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 0));
		jarsGroup.setText("Java EE classpath JARs");
	
		label = new Label(jarsGroup, SWT.NONE);
		label.setText("Java instance &home:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
	
		installDir = new Text(jarsGroup, SWT.BORDER);
		installDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		installDir.setEditable(false);
		installDir.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				runtime.setLocation(new Path(installDir.getText()));
				validate();
			}
		});
		
		Button browse = new Button(jarsGroup, SWT.PUSH);
		browse.setText("B&rowse...");
		browse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		browse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(getShell());
				dialog.setMessage("Select the root directory of a Java instance: ");
				dialog.setFilterPath(installDir.getText());
				String selectedDirectory = dialog.open();
				if (selectedDirectory != null)
					installDir.setText(selectedDirectory);
			}
		});
		
		Label installDirDesc = new Label(jarsGroup, SWT.WRAP);
		installDirDesc.setText("This is the root location of the Java instance on the filesystem, e.g. /usr/sap/C01/J00. It could be a directory on the local filesystem or on a remote share. The runtime looks up the given location for the Java EE JARs to include in the classpath. ");
		GridData gd = new GridData(SWT.FILL, SWT.BEGINNING, false, false, 3, 0);
		gd.widthHint = 400; 
		installDirDesc.setLayoutData(gd);
		
		// spacer
		new Label(jarsGroup, SWT.NONE);
		
		cacheJars = new Button(jarsGroup, SWT.CHECK);
		cacheJars.setText("&Copy classpath JARs into workspace");
		cacheJars.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 0));
		cacheJars.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sapRuntime.setCacheJars(cacheJars.getSelection());
			}
		});
		
		Label cacheJarsDesc = new Label(jarsGroup, SWT.WRAP);
		cacheJarsDesc.setText("Enabling this option optimizes the classpath computing when the Java instance is on a remote system in slow network environment. ");
		gd = new GridData(SWT.FILL, SWT.BEGINNING, false, false, 3, 0);
		gd.widthHint = 400; 
		cacheJarsDesc.setLayoutData(gd);
		
		init();
		validate();
		
		Dialog.applyDialogFont(this);
		
		name.forceFocus();
	}
	
	protected void init() {
		if (name == null || runtime == null)
			return;
		
		if (runtime.getName() != null)
			name.setText(runtime.getName());
		else
			name.setText("");
		
		if (runtime.getLocation() != null)
			installDir.setText(runtime.getLocation().toOSString());
		else
			installDir.setText("");
		
		cacheJars.setSelection(sapRuntime.doesCacheJars());
	}

	protected void validate() {
		if (runtime == null) {
			wizard.setMessage("Internal error: runtime is null", IMessageProvider.ERROR);
			return;
		}
		
		IStatus status = runtime.validate(null);
		if (status == null || status.isOK())
			wizard.setMessage(null, IMessageProvider.NONE);
		else if (status.getSeverity() == IStatus.WARNING)
			wizard.setMessage(status.getMessage(), IMessageProvider.WARNING);
		else
			wizard.setMessage(status.getMessage(), IMessageProvider.ERROR);
		wizard.update();
	}
}
