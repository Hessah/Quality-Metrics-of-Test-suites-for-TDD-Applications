package net.sf.lavalamp.device.impl;

import java.io.IOException;

import net.sf.lavalamp.device.AbstractDevice;
/**
 * Uses Tellstick's tdtool.exe to control any tellstick compatible devices.
 * @author Steven Hale
 *
 */
public class TellStick extends AbstractDevice {
	private static final long serialVersionUID = 2715775049805997472L;
	private static final String EXEC = "tdtool.exe";
	private transient Runtime runtime;

	public void turnOff() {
		super.turnOff();
		logger.debug(offString());
		exec(offString());
	}

	public void init() {
		this.runtime = Runtime.getRuntime();
	}

	protected void exec(String command) {
		try {
			runtime.exec(command);
					} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected String offString() {
		return String.format("%s/%s --off %s", properties.getPath(), EXEC, identity);
	}

	protected String onString() {
		return String.format("%s/%s --on %s", properties.getPath(), EXEC, identity);
	}

	public void turnOn() {
		super.turnOn();
		logger.debug(onString());
		exec(onString());
	}

	public String toString() {
		return String.format("TellStick %s ", identity);
	}

	public void setRuntime(Runtime runtime) {
		this.runtime = runtime;
	}


	

}
