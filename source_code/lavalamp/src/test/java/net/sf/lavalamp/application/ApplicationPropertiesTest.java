package net.sf.lavalamp.application;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import net.sf.lavalamp.device.DeviceProperties;

import org.junit.Before;
import org.junit.Test;

public class ApplicationPropertiesTest {

	ApplicationProperties applicationProperties;
	DeviceProperties[] deviceProperties;

	@Before
	public void setUp() throws FileNotFoundException {
		applicationProperties = new ApplicationPropertiesLoader()
				.load("src/test/resources/test.yml");

		deviceProperties = applicationProperties.getDeviceProperties();
		
		

	}

	@Test
	public void shouldLoadApplicationLevelProperties()
			throws FileNotFoundException {

		assertEquals(5000, applicationProperties.getRunInterval());
		
		assertEquals(false, applicationProperties.isDebug());
	}
	
	@Test
	public void shouldLoadWebApplicationLevelProperties()
			throws FileNotFoundException {

		assertEquals(8092, applicationProperties.getPort());
		
		
	}

	
	


}
