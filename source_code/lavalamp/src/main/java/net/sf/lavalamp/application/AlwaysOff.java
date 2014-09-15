package net.sf.lavalamp.application;

import java.util.Calendar;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.device.DeviceController;

class AlwaysOff extends java.lang.Thread {
	private final WebRun runner;
	private final Pause pause;

	AlwaysOff(WebRun webRun, Pause pause) {
		runner = webRun;
		this.pause = pause;
		
	}

	@SuppressWarnings("static-access")
	public void run() {
		LavaLogger logger = new LavaLogger();
		try {
			while (true) {
				logger.info(runner.TICK);
				pause.sleep(60000);
				DeviceController  controller = runner.getDeviceController();
				controller.switchDevices(
						Calendar.getInstance());
				

			}
		} catch (InterruptedException e) {
			logger.debug("interrupted");
		}
	}
}