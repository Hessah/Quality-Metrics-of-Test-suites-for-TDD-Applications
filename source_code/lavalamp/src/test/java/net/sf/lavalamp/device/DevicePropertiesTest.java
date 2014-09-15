package net.sf.lavalamp.device;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import net.sf.lavalamp.application.ApplicationProperties;
import net.sf.lavalamp.application.ApplicationPropertiesLoader;
import net.sf.lavalamp.properties.MissingPropertyException;
import net.sf.lavalamp.site.BuildProperties;

import org.junit.Before;
import org.junit.Test;

public class DevicePropertiesTest {

	DeviceProperties[] deviceProperties;

	@Before
	public void setUp() throws FileNotFoundException {
		ApplicationProperties applicationProperties = new ApplicationPropertiesLoader()
				.load("src/test/resources/test.yml");

		deviceProperties = applicationProperties.getDeviceProperties();

	}

	@Test(expected = MissingPropertyException.class)
	public void shouldThrowExceptionWhenIdentityMissing()
			throws FileNotFoundException {
		new ApplicationPropertiesLoader()
				.load("src/test/resources/test_missing_identity.yml");

	}

	@Test(expected = MissingPropertyException.class)
	public void shouldThrowExceptionWhenClassnameMissing()
			throws FileNotFoundException {
		new ApplicationPropertiesLoader()
				.load("src/test/resources/test_missing_classname.yml");

	}

	@Test
	public void shouldLoadFirstDeviceProperties()
			throws FileNotFoundException {

		DeviceProperties deviceProperty = deviceProperties[0];
		assertEquals("net.sf.lavalamp.device.DummyDevice",
				deviceProperty.getClassName());
		assertEquals("C:/Program Files/Telldus", deviceProperty.getPath());
	}

	@Test
	public void shouldHaveOffSet() throws FileNotFoundException {

		DeviceProperties deviceProperty = deviceProperties[0];
		assertEquals("07:00", deviceProperty.getOff().getStart());

	}

	@Test
	public void shouldLoadFirstDeviceFirstBuildProperties()
			throws FileNotFoundException {

		DeviceProperties deviceProperty = deviceProperties[0];
		BuildProperties buildProperty = deviceProperty.getBuildProperties()[0];
		assertEquals("ORIGO", buildProperty.getBuild());

		
	}

	@Test
	public void shouldLoadFirstDeviceSecondBuildProperties()
			throws FileNotFoundException {

		DeviceProperties deviceProperty = deviceProperties[0];

		BuildProperties buildProperty = deviceProperty.getBuildProperties()[1];
		assertEquals("ORIGOO", buildProperty.getBuild());

		
	}

	@Test
	public void shouldLoadSecondDeviceBuildProperties()
			throws FileNotFoundException {

		DeviceProperties deviceProperty = deviceProperties[1];
		BuildProperties buildProperty = deviceProperty.getBuildProperties()[0];
		assertEquals("ORIGOX", buildProperty.getBuild());
		

	}
}
