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
package com.sap.netweaver.porta.mon;

import java.io.PrintStream;

public class ExitCommand extends Command {

	@Override
	public String execute() {
		PrintStream out = PortaMon.getOut();
		out.println();
		out.println("Exiting by user request...");
		System.exit(0);
		return null;
	}

}
