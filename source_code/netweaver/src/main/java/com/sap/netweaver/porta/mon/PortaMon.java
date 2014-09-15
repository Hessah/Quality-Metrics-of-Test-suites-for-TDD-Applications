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

import static com.sap.netweaver.porta.mon.Command.MAX_ID;
import static com.sap.netweaver.porta.mon.Command.MIN_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;

import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.Server;
import com.sap.netweaver.porta.core.ServerFactory;

public class PortaMon {

	private static final String INVALID_COMMAND_NUMBER = "command number should be numberic between "
			+ MIN_ID + " and " + MAX_ID;

	private static final String DEFAULT_HOST = "localhost";
	private static final String DEFAULT_INST_NR = "0";

	private static BufferedReader in;
	private static PrintStream out;
	private static Properties serverProps;

	private static LifecycleManagerAuthenticationCallback lmac;
	private static DeployManagerAuthenticationCallback dmac;

	private String status;

	public PortaMon() {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = System.out;
		lmac = new LifecycleManagerAuthenticationCallback();
		dmac = new DeployManagerAuthenticationCallback();
	}

	public void go() throws IOException {
		printInfo();
		initialize();
		commandLoop();
	}

	public static void main(String[] args) throws Exception {
		new PortaMon().go();
	}

	public static BufferedReader getIn() {
		return in;
	}

	public static PrintStream getOut() {
		return out;
	}

	public static Properties getServerProps() {
		return serverProps;
	}

	public static LifecycleManagerAuthenticationCallback getLifecycleManagerAuthenticationCallback() {
		return lmac;
	}

	public static DeployManagerAuthenticationCallback getDeployManagerAuthenticationCallback() {
		return dmac;
	}

	private void printInfo() {
		out.println("PortaMon v0.1");
		out.println();
	}

	private void initialize() throws IOException {
		serverProps = new Properties();
		serverProps.setProperty(ServerFactory.SERVER_TYPE, "NW7");

		boolean repeat;
		do {
			repeat = false;

			out.println("Enter SAP NetWeaver Application Server identity. ");
			out.print("Host ([Enter] " + DEFAULT_HOST + "): ");
			String host = in.readLine().trim();
			serverProps.setProperty("host", (host.length() == 0) ? DEFAULT_HOST : host);

			out.print("Instance Number ([Enter] " + DEFAULT_INST_NR + "): ");
			String instanceNumber = in.readLine().trim();
			serverProps.setProperty("instance.number", (instanceNumber.length() == 0) ? DEFAULT_INST_NR : instanceNumber);

			try {
				Server server = ServerFactory.createServer(serverProps);
				server.ping();
				status = "Server initialized successfully. ";
			} catch (CoreException e) {
				out.println("Cannot initialize server: " + e.getMessage());
				out.println("Try again.");
				repeat = true;
			}
		} while (repeat);
	}

	private void commandLoop() throws IOException {
		while (true) {
			printStatus();
			printMenu();

			int cmdId;
			try {
				cmdId = chooseCommand();
			} catch (IllegalArgumentException e) {
				status = "Error reading command number: " + e.getMessage();
				continue;
			}

			Command command = CommandFactory.createCommand(cmdId);
			try {
				status = command.execute();
			} catch (Exception e) {
				status = "Command execution failed: " + e.getMessage();
			}
		}
	}

	private void printStatus() {
		out.println("*******************************");
		out.println();
		out.println(status);
		out.println();
	}

	private void printMenu() {
		out.println("*******************************");
		out.println("* [0] Exit Program");
		out.println("* [1] Start AppServer");
		out.println("* [2] Stop AppServer");
		out.println("* [3] Restart AppServer");
		out.println("* [4] Get AppServer State");
		out.println("* [5] Enable Debugging");
		out.println("* [6] Disable Debugging");
		out.println("* [7] Deploy Application");
		out.println("* [8] Undeploy Application");
		out.println("* [9] List Applications");
		out.println("* [10] Start Application");
		out.println("* [11] Stop Application");
		out.println("*******************************");
	}

	private int chooseCommand() throws IOException, IllegalArgumentException {
		out.print("Choose command: ");
		String line = in.readLine().trim();

		try {
			int id = Integer.parseInt(line);
			if (id < MIN_ID || id > MAX_ID) {
				throw new IllegalArgumentException(INVALID_COMMAND_NUMBER);
			}
			return id;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_COMMAND_NUMBER);
		}
	}

}
