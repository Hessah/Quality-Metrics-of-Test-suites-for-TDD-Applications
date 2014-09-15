package net.sf.lavalamp.factories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.sf.lavalamp.device.Device;
import net.sf.lavalamp.device.DeviceProperties;
import net.sf.lavalamp.site.SiteProperties;
import net.sf.lavalamp.site.BuildProperties;
import net.sf.lavalamp.site.MissingBuildException;

import org.junit.Before;
import org.junit.Test;

public class DeviceBuildsFactoryTest {
	DeviceBuildsFactory factory = new DeviceBuildsFactory();
	DeviceProperties properties = new DeviceProperties();
	BuildProperties bp = new BuildProperties();
	SiteProperties siteProperties = new SiteProperties();

	@Before
	public void setUp() {
		
		bp.setBuild("build_one");
		
	}

	@Test
	public void shouldMake() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, MissingBuildException {

		siteProperties
				.setClassName("net.sf.lavalamp.site.impl.BambooRestApi");
		bp.setSiteProperties(siteProperties);
		BuildProperties[] buildProperties = { bp };
		properties.setClassName("net.sf.lavalamp.device.DummyDevice");
		properties.setBuildProperties(buildProperties);

		Device appBuilds = factory.make(properties);
		assertTrue(appBuilds instanceof net.sf.lavalamp.device.DummyDevice);
		assertNotNull(appBuilds.getBuilds().getBuild("build_one").getBuildSite().getUrlGetter());

	}
	
	
	@Test (expected = ClassNotFoundException.class)
	public void shouldBeExceptionWhenWrongSite() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		siteProperties
				.setClassName("wrong.class");
		bp.setSiteProperties(siteProperties);
		BuildProperties[] buildProperties = { bp };
		properties.setClassName("net.sf.lavalamp.device.DummyDevice");
		properties.setBuildProperties(buildProperties);

		factory.make(properties);
		
	}

}
