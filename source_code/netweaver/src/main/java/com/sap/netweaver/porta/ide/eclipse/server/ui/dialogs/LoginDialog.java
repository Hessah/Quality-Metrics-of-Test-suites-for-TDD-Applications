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

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LoginDialog extends MessageDialog {

	private String username = null;
	private String password = null;

	private Text usernameText = null;
	private Text passwordText = null;
	private final String defaultUser;

	public LoginDialog(Shell parentShell, String title, String message, String defaultUser) {
		super(parentShell, title, null, message, MessageDialog.QUESTION, 
				new String[] { "Login", IDialogConstants.CANCEL_LABEL }, 0);
		this.defaultUser = defaultUser;
	}

	protected Control createCustomArea(Composite parent) {

		final Composite area = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;

		area.setLayout(gridLayout);

		Label label0 = new Label(area, SWT.NONE);
		label0.setText("Username :");
		GridData data = new GridData();
		label0.setLayoutData(data);

		usernameText = new Text(area, SWT.BORDER);
		usernameText.setText(defaultUser);

		data = new GridData();
		data.widthHint = 150;
		usernameText.setLayoutData(data);

		Label label3 = new Label(area, SWT.NONE);
		label3.setText("Password :");
		data = new GridData();
		label3.setLayoutData(data);

		passwordText = new Text(area, SWT.BORDER | SWT.PASSWORD);
		passwordText.setText("");
		data = new GridData();
		data.widthHint = 150;
		passwordText.setLayoutData(data);
		passwordText.setFocus();
		
		return area;
	}

	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			username = usernameText.getText();
			password = passwordText.getText();
		}
		super.buttonPressed(buttonId);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
