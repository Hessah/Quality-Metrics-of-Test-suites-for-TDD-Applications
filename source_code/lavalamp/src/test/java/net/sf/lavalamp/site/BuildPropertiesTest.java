package net.sf.lavalamp.site;

import java.io.FileNotFoundException;

import net.sf.lavalamp.application.ApplicationPropertiesLoader;
import net.sf.lavalamp.properties.MissingPropertyException;
import org.junit.Test;

public class BuildPropertiesTest {
	BuildProperties buildProperties;

	@Test(expected = MissingPropertyException.class)
	public void shouldThrowExceptionWhenIdentityMissing()
			throws FileNotFoundException {
		buildProperties = new ApplicationPropertiesLoader().load(
				"src/test/resources/test_missing_build.yml")
				.getDeviceProperties()[0].getBuildProperties()[0];
	}

}
