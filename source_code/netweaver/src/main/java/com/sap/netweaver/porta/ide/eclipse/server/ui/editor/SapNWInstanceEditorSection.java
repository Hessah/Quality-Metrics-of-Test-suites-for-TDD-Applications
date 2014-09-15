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
package com.sap.netweaver.porta.ide.eclipse.server.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;

import com.sap.netweaver.porta.ide.eclipse.SapNWPlugin;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;
import com.sap.netweaver.porta.core.CoreException;

public class SapNWInstanceEditorSection extends ServerEditorSection {
	
	private SapNWServer sapServer;

	public SapNWInstanceEditorSection() {
		// do nothing
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		
		if (server != null) {
			sapServer = (SapNWServer) server.loadAdapter(SapNWServer.class, null);
		}
	}



	@Override
	public void createSection(Composite parent) {
		super.createSection(parent);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());

		Section section = toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
			| ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | ExpandableComposite.FOCUS_TITLE);
		section.setText("Server Instance");
		section.setDescription("Settings specific to the server instance");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 5;
		layout.marginWidth = 10;
		layout.verticalSpacing = 5;
		layout.horizontalSpacing = 15;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));
		// TODO
//		IWorkbenchHelpSystem whs = PlatformUI.getWorkbench().getHelpSystem();
//		whs.setHelp(composite, ContextIds.SERVER_EDITOR);
//		whs.setHelp(section, ContextIds.SERVER_EDITOR);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		
		toolkit.createLabel(composite, "Instance number: ");
		Text instNrText = toolkit.createText(composite, Integer.toString(sapServer.getInstanceNumber()), SWT.SINGLE | SWT.READ_ONLY);
		instNrText.setEnabled(false);
		instNrText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		toolkit.createLabel(composite, "System name: ");
		Text systemNameText = toolkit.createText(composite, "", SWT.SINGLE | SWT.READ_ONLY);
		systemNameText.setEnabled(false);
		try {
			systemNameText.setText(sapServer.getServerCore().getSystemName());
		} catch (CoreException e) {
			SapNWPlugin.logError("Cannot retrieve system name", e);
		}
		systemNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	

}
