package net.sf.lavalamp.application;

import java.util.Arrays;

import net.sf.lavalamp.device.DeviceProperties;

public class ApplicationProperties {
	private int runInterval = 30000;
	private int port;
	private boolean debug = false;
	
	private DeviceProperties[] deviceProperties;

	public void check() {
		for (DeviceProperties properties : deviceProperties) {
			properties.check();
		}

	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getRunInterval() {
		return runInterval;
	}

	public void setRunInterval(int runInterval) {
		this.runInterval = runInterval;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}


	public DeviceProperties[] getDeviceProperties() {
		return deviceProperties;
	}

	public void setDeviceProperties(DeviceProperties[] deviceProperties) {
		this.deviceProperties = deviceProperties;
	}

	@Override
	public String toString() {
		return "debug=" + debug + ", port=" + port
				+ ", runInterval=" + runInterval + ", "
				+ Arrays.toString(deviceProperties);
	}

}
