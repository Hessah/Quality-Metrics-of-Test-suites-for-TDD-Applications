package net.sf.lavalamp.application;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;

class EmbeddedWebRun extends java.lang.Thread {
	private final WebRun webRun = new WebRun();

	Pause pause = new Pause();

	public void run() {
		LavaLogger logger = new LavaLogger();
		try {
			
			ApplicationProperties properties  =
			new ApplicationPropertiesLoader().load("src/test/resources/test.yml");
			webRun.setProperties(properties);
			
			webRun.init();
			
			webRun.exec(logger, pause);
			
			while (true) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			logger.debug("interrupted");
		}
	}

}