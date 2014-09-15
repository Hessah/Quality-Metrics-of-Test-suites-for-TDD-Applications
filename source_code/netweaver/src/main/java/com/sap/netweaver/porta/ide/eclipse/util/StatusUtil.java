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

import org.eclipse.core.runtime.IStatus;

public class StatusUtil {
	
	public static boolean hasErrorMessage(IStatus status) {
		return status.matches(IStatus.ERROR) && !hasEmptyMessage(status); 
	}
	
	public static boolean hasEmptyMessage(IStatus status) {
		String message = status.getMessage();
		return message == null || message.length() == 0;
	}
	
	public static IStatus merge(IStatus status, IStatus newStatus) {
		if (newStatus.getSeverity() > status.getSeverity()) {
			return newStatus;
		} else if (newStatus.getSeverity() == status.getSeverity() && hasEmptyMessage(status)) {
			return newStatus;
		} else {
			return status;
		}
	}

}
