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
package com.sap.netweaver.porta.ide.eclipse.server.control;

import static org.eclipse.jst.j2ee.datamodel.properties.IJ2EEComponentExportDataModelProperties.*;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.jst.j2ee.application.internal.operations.EARComponentExportDataModelProvider;
import org.eclipse.jst.j2ee.internal.archive.operations.EARComponentExportOperation;
import org.eclipse.jst.j2ee.internal.plugin.IJ2EEModuleConstants;
import org.eclipse.jst.j2ee.internal.web.archive.operations.WebComponentExportDataModelProvider;
import org.eclipse.jst.j2ee.internal.web.archive.operations.WebComponentExportOperation;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.DataModelPausibleOperationImpl;
import org.eclipse.wst.server.core.IModule;

import com.sap.netweaver.porta.ide.eclipse.util.SapNWServerUtil;

public class ModuleExportOperation extends DataModelPausibleOperationImpl {

	public ModuleExportOperation(IModule module) {
		super(createExportOperation(module));
	}
	
	public File getArchiveFile() {
		return new File(getDataModel().getStringProperty(ARCHIVE_DESTINATION));
	}
	
	static IDataModelOperation createExportOperation(IModule module) {
		if (SapNWServerUtil.isEAR(module)) {
			return new EARComponentExportOperation(createDataModel(module));
		} else if (SapNWServerUtil.isWAR(module)) {
			return new WebComponentExportOperation(createDataModel(module));
		} else {
			throw new IllegalArgumentException("module must be EAR or WAR");
		}
	}

	static IDataModel createDataModel(IModule module) {
		IProject project = module.getProject();
		String projectName = project.getName();
		
		String tempDir = System.getProperty("java.io.tmpdir");
		File archiveFile = new File(tempDir, projectName + getFileExtension(module));
		archiveFile.deleteOnExit();
		String archiveDestination = archiveFile.toString(); 
		
		IDataModel dataModel = DataModelFactory.createDataModel(createDataModelProvider(module));
		dataModel.setStringProperty(ARCHIVE_DESTINATION, archiveDestination);		
		dataModel.setStringProperty(PROJECT_NAME, projectName);
		dataModel.setBooleanProperty(ALLOW_EXTENSIONS, true);
		dataModel.setBooleanProperty(EXPORT_SOURCE_FILES, false);
		dataModel.setBooleanProperty(RUN_BUILD, true);
		dataModel.setBooleanProperty(OVERWRITE_EXISTING, true);
		
		return dataModel;
	}

	static IDataModelProvider createDataModelProvider(IModule module) {
		if (SapNWServerUtil.isEAR(module)) {
			return new EARComponentExportDataModelProvider();
		} else if (SapNWServerUtil.isWAR(module)) {
			return new WebComponentExportDataModelProvider();
		} else {
			throw new IllegalArgumentException("module must be EAR or WAR");
		}
	}

	static String getFileExtension(IModule module) {
		if (SapNWServerUtil.isEAR(module)) {
			return IJ2EEModuleConstants.EAR_EXT;
		} else if (SapNWServerUtil.isWAR(module)) {
			return IJ2EEModuleConstants.WAR_EXT;
		} else {
			throw new IllegalArgumentException("module must be EAR or WAR");
		}
	}

}
