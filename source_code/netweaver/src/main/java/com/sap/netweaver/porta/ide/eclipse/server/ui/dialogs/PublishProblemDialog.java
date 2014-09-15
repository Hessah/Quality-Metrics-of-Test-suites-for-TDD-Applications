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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.sap.netweaver.porta.core.DeployResultStatus;
import com.sap.netweaver.porta.ide.eclipse.server.control.PublishException;

public class PublishProblemDialog extends MessageDialog {
	
	private final static int DETAILS_BUTTON_ID = 0;
	private static final int DETAILS_TEXT_LINE_COUNT = 15;
	
	private Text detailsText;
	
	private PublishException exception;

	public PublishProblemDialog(Shell parentShell, PublishException exception) {
		super(parentShell, 
				"Publishing Problem", 
				null, /* dialogTitleImage */ 
				exception.getMessage(),
				getImage(exception.getDeployResult().getStatus()), 
				new String[] { IDialogConstants.SHOW_DETAILS_LABEL, IDialogConstants.CLOSE_LABEL }, 
				1);
		this.exception = exception;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	private static int getImage(DeployResultStatus status) {
		switch (status) {
			case ERROR: return MessageDialog.ERROR;
			case WARNING: return MessageDialog.WARNING;
			default: return MessageDialog.NONE;
		}
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == DETAILS_BUTTON_ID) { 
            toggleDetailsArea();
        } else {
            super.buttonPressed(buttonId);
        }
    }

	private void toggleDetailsArea() {
		Point windowSize = getShell().getSize();
        Point oldSize = getContents().computeSize(SWT.DEFAULT, SWT.DEFAULT);

        if (detailsText != null) {
            detailsText.dispose();
            detailsText = null;
            getButton(DETAILS_BUTTON_ID).setText(IDialogConstants.SHOW_DETAILS_LABEL);
        } else {
            createDropDownText((Composite) getContents());
            getButton(DETAILS_BUTTON_ID).setText(IDialogConstants.HIDE_DETAILS_LABEL);
        }

        Point newSize = getContents().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        getShell().setSize(new Point(windowSize.x, windowSize.y + (newSize.y - oldSize.y)));
	}

	private void createDropDownText(Composite parent) {
        detailsText = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL);
        detailsText.setFont(parent.getFont());
        detailsText.setText(exception.getDeployResult().getStatusDetails());

        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = detailsText.getLineHeight() * DETAILS_TEXT_LINE_COUNT;
        data.horizontalSpan = 2;
        detailsText.setLayoutData(data);
	}
}
