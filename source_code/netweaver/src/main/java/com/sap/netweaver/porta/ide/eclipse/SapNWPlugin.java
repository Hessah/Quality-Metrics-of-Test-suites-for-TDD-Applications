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
package com.sap.netweaver.porta.ide.eclipse;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

import com.sap.netweaver.porta.ide.eclipse.server.SapNWRefreshStateJob;

public class SapNWPlugin extends Plugin {

	public static final String PLUGIN_ID = "com.sap.netweaver.porta.ide.eclipse";

	public static final SapNWRefreshStateJob refreshStateJob = new SapNWRefreshStateJob();

	private static SapNWPlugin singleton = null;
	
	public SapNWPlugin() {
		super();
		singleton = this;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		singleton = null;
		super.stop(context);
	}

	public static SapNWPlugin getDefault() {
		return singleton;
	}
	
	public static void errorDialog(final String title, final String message) {
		final Display display = Display.getDefault();
    	display.syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), title, message);
			}
    	});
	}
	
	public static void errorDialog(String title, String message, Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		
		printWriter.println(message);
		
		if (throwable != null) {
			printWriter.println();
			throwable.printStackTrace(printWriter);
		}
		
		errorDialog(title, stringWriter.toString());
	}
	
	public static void logError(String msg, Throwable t) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, t));
	}
	
	public static void logWarning(String msg, Throwable t) {
		log(new Status(IStatus.WARNING, PLUGIN_ID, IStatus.OK, msg, t));
	}
	
	public static void logInfo(String msg, Throwable t) {
		log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK, msg, t));
	}
	
	private static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
	
}
