package net.sf.lavalamp.device;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import net.sf.lavalamp.factories.DeviceBuildsFactory;
import net.sf.lavalamp.site.BuildProperties;

import org.junit.Test;

public class DeviceFactoryTest {
	DeviceBuildsFactory factory = new DeviceBuildsFactory();
	DeviceProperties properties = new DeviceProperties();
	BuildProperties[] buildProperties = { new BuildProperties() };

	@Test
	public void shouldGetDevice() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		properties.setBuildProperties(buildProperties);
		properties.setClassName("net.sf.lavalamp.device.impl.TellStick");
		assertThat(factory.make(properties), instanceOf(Device.class));

	}

}
