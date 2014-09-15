package net.sf.lavalamp.factories;

import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.Builds;
import net.sf.lavalamp.device.Device;
import net.sf.lavalamp.site.BuildProperties;
import net.sf.lavalamp.device.DeviceProperties;
import net.sf.lavalamp.site.SiteFactory;
import net.sf.lavalamp.site.SiteProperties;

public class DeviceBuildsFactory {

	public Device make(DeviceProperties properties)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		String deviceClass = properties.getClassName();
		Device device = (Device) Class.forName(deviceClass).newInstance();
		device.setProperties(properties);

		device.init();

		Builds builds = initBuilds(properties);
		device.setBuilds(builds);
		return device;
	}

	private Builds initBuilds(DeviceProperties properties)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Builds builds = new Builds();

		for (BuildProperties buildProperties : properties.getBuildProperties()) {
			Build build = new Build(buildProperties.getBuild());
			SiteProperties siteProperties = buildProperties.getSiteProperties();
			if (siteProperties != null) {
				build.setBuildSite(new SiteFactory().make(siteProperties));
			}
			builds.add(build);

		}
		return builds;
	}

}
