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
package com.sap.netweaver.porta.ide.eclipse.util;

import org.eclipse.wst.server.core.IModule;

public class SapNWServerUtil {

	public static boolean isWAR(IModule module) {
		return (module == null) ? false : FacetUtil.DYNAMIC_WEB.equals(module.getModuleType().getId());
	}

	public static boolean isEAR(IModule module) {
		return (module == null) ? false : FacetUtil.ENTERPRISE_APPLICATION.equals(module.getModuleType().getId());
	}
	
	public static boolean isDeployableModule(IModule module) {
		return isEAR(module) || isWAR(module);
	}
	
	public static boolean areAllDeployableModules(IModule[] modules) {
		for (IModule module : modules) {
			if (!isDeployableModule(module))
				return false;
		}
		return true;
	}

}
