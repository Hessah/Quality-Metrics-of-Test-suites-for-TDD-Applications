package net.sf.lavalamp.device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.Builds;
import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.site.MissingBuildException;

/**
 * Controller which links the devices to the builds.
 * 
 * @author Steven Hale
 * 
 */
public class DeviceController implements Serializable {
	private static final long serialVersionUID = 8064874239904630283L;
	private transient LavaLogger logger = new LavaLogger();
	private final List<Device> devices;

	public void setLogger(LavaLogger logger) {
		this.logger = logger;
	}

	public void setStatusForBuild(String buildId, boolean successful)
			throws MissingBuildException {
		getBuild(buildId).setSuccessful(successful);
	}

	public Build getBuild(String buildId) throws MissingBuildException {
		for (Device device : devices) {
			try {
				return device.getBuilds().getBuild(buildId);
			} catch (MissingBuildException e) {
				logger.debug("Build " + buildId + " not found for device "
						+ device);
			}
		}

		throw new MissingBuildException(buildId + " not found");

	}

	public DeviceController(List<Device> devices) {

		this.devices = devices;

	}

	/**
	 * Switches devices off or on depending on status of builds.
	 * 
	 * @param calendar
	 * @return list of events
	 */
	public List<String> switchDevices(Calendar calendar) {
		logger.debug("checking");
		List<String> events = new ArrayList<String>();
		for (Device device : devices) {
			switchDevice(calendar, events, device);

		}
		return events;
	}

	protected void switchDevice(Calendar calendar, List<String> events,
			Device device) {
		Builds builds = device.getBuilds();
		logger.debug("device " + device);
		if (device.isAlwaysOff(calendar)) {
			events.add(device + " turned off during always off period");
			device.turnOff();
		} else {
			turnOffOrOn(events, builds, device);
		}
	}

	protected void turnOffOrOn(List<String> events, Builds builds, Device device) {
		if (builds.allSuccessful()) {
			device.getActions().getSuccessAction().perform(events, device);
		} else {
			device.getActions().getFailureAction().perform(events, device);

		}
	}
	
	public List<Device> getDevices() {
		return devices;
	}

}
