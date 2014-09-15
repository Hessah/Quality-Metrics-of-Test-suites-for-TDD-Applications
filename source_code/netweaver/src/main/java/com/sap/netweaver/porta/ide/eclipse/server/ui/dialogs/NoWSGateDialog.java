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
package com.sap.netweaver.porta.ide.eclipse.server.ui.dialogs;

import java.net.URL;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import com.sap.netweaver.porta.core.NoWSGateException;
import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;

public class NoWSGateDialog extends MessageDialog {
	
	private String endpoint;

	public NoWSGateDialog(Shell parentShell, NoWSGateException exception) {
		super(parentShell, 
				"Deploy Web Service Not Available", 
				null, /* dialogTitleImage */ 
				exception.getLocalizedMessage(),
				MessageDialog.WARNING, 
				new String[] { "&Open Instructions", IDialogConstants.CLOSE_LABEL }, 
				0);
		this.endpoint = exception.getEndpoint();
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = 8;
        layout.marginWidth = 0;
        layout.verticalSpacing = 0;
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        createLabel(composite, "Web Service endpoint:");
        createLink(composite, endpoint);
        new Label(composite, SWT.NONE);
		createLabel(composite, "Click on the Open Instructions button if you need instructions about installing the Deploy Web Service application. ");
		
		return composite;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			// open sdn wiki page
			IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();
			try {
				browserSupport.createBrowser(IWorkbenchBrowserSupport.LOCATION_BAR | IWorkbenchBrowserSupport.NAVIGATION_BAR, "SDN", null, null).
						openURL(new URL("http://sourceforge.net/apps/trac/sapnweclipse/wiki/InstallDeployWSApp"));
			} catch (Exception e) {
				SapNWPlugin.logError("Failed to open the SDN wiki", e);
			}
		}
		super.buttonPressed(buttonId);
	}
	
	private Label createLabel(Composite parent, String text) {
		Label label = new Label(parent, getMessageLabelStyle());
		label.setText(text);
		GridDataFactory
				.fillDefaults()
				.align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false)
				.hint(
						convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH),
						SWT.DEFAULT).applyTo(label);
		return label;
	}
	
	private Link createLink(Composite parent, String text) {
		Link link = new Link(parent, getMessageLabelStyle());
		link.setText("<a>" + text + "</a>");
		GridDataFactory
				.fillDefaults()
				.align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false)
				.hint(
						convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH),
						SWT.DEFAULT).applyTo(link);
		link.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				getButton(getDefaultButtonIndex()).setFocus();
			}
		});
		return link;
	}

}
