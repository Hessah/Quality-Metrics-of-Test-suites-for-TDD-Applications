package net.sf.lavalamp.application;

import java.util.ArrayList;
import java.util.List;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.device.Device;
import net.sf.lavalamp.device.DeviceController;
import net.sf.lavalamp.device.DeviceProperties;
import net.sf.lavalamp.factories.DeviceBuildsFactory;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.BuildChecker;
import net.sf.lavalamp.site.Builds;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.UrlGetter;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * Starts jetty and deploys a servlet to listen for build status requests. A
 * build server such as CruiseControl can be configured to report build status
 * using http notification.
 * 
 * @author Steven Hale
 * @see BuildStatusServlet
 */
public class WebRun extends DefaultApplication {

	private DeviceController deviceController;

	private int port;
	private final LavaLogger logger = new LavaLogger();
	private long runInterval;
	private final BuildChecker checker = new BuildChecker();

	@Override
	public void exec(LavaLogger logger, Pause pause) throws Exception {
		Server webServer = new Server(port);
		new AlwaysOff(this, pause).start();
		webServer = new Server(port);

		Context context = new Context(webServer, "/", Context.SESSIONS);
		context.addServlet(new ServletHolder(new BuildStatusServlet(
				deviceController)), "/lavalamp");

		webServer.start();

		while (true) {
			checkAllBuilds(checker, new UrlGetter(), deviceController, pause,
					console, runInterval);
		}

	}

	/**
	 * Checks the status of all the builds
	 * 
	 * @param pause
	 * @throws InterruptedException
	 */
	protected void checkAllBuilds(BuildChecker checker, UrlGetter getter,
			DeviceController deviceController, Pause pause, Console console,
			long runInterval) throws InterruptedException {

		for (Device device : deviceController.getDevices()) {
			logger.debug("device " + device);
			Builds builds = device.getBuilds();
			for (Build build : builds.getBuilds()) {
				checkBuild(checker, getter, console, device, build);
			}
		}
		pause.sleep(runInterval);

	}

	protected void checkBuild(BuildChecker checker, UrlGetter getter,
			Console console, Device device, Build build) {
		try {
			getter.get("http://localhost:" + port + "/lavalamp?buildId="
					+ build.getIdentity() + "&successful="
					+ checker.check(build, console));
		} catch (LoginFailedException e) {
			throw new RuntimeException("Login failed - Crash!", e);
		} catch (Exception e) {
			logger.error(e);
			List<String> events = new ArrayList<String>();
			device.getActions().getErrorAction().perform(events, device);
		}
	}

	@Override
	public void init() throws Exception {
		super.init();
		port = properties.getPort();
		runInterval = properties.getRunInterval();
		DeviceProperties[] deviceProperties = properties.getDeviceProperties();
		List<Device> devices = new ArrayList<Device>();
		initDevices(deviceProperties, devices);
	}

	protected void initDevices(DeviceProperties[] deviceProperties,
			List<Device> devices) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		for (DeviceProperties deviceProperty : deviceProperties) {
			Device device = new DeviceBuildsFactory().make(deviceProperty);
			devices.add(device);
		}
		deviceController = new DeviceController(devices);
	}

	public DeviceController getDeviceController() {
		return deviceController;
	}

}
