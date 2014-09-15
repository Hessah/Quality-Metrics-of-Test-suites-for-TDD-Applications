/*******************************************************************************
 * Copyright (c) 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev (SAP AG) - initial API and implementation
 *******************************************************************************/
package com.sap.netweaver.porta.ide.eclipse.util;

import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;

/**
 * Helper for facets. Mainly for compatibility with Callisto and Europa.
 * 
 * @see org.eclipse.jst.j2ee.project.facet.FacetUtil
 */ 
public class FacetUtil {

	public static final String ENTERPRISE_APPLICATION = IModuleConstants.JST_EAR_MODULE;
	public static final String APPLICATION_CLIENT = IModuleConstants.JST_APPCLIENT_MODULE;
	public static final String EJB = IModuleConstants.JST_EJB_MODULE;
	public static final String DYNAMIC_WEB = IModuleConstants.JST_WEB_MODULE;
	public static final String UTILITY = IModuleConstants.JST_UTILITY_MODULE;
	public static final String JCA = IModuleConstants.JST_CONNECTOR_MODULE;
	public static final String STATIC_WEB = IModuleConstants.WST_WEB_MODULE;
	public static final String JAVA = IModuleConstants.JST_JAVA;

	public static IProjectFacetVersion getProjectFacet(String facetName, String version) {
		return ProjectFacetsManager.getProjectFacet(facetName).getVersion(version);
	}
	
	public static boolean hasProjectFacet(IFacetedProject project, String facetName, String version) {
		try {
			IProjectFacetVersion facetVersion = getProjectFacet(facetName, version);
			return project.hasProjectFacet(facetVersion);
		} catch (IllegalArgumentException e) {
			// most probably the facet or facet version is not declared in this Eclipse version
			return false;
		}
	}
	
}