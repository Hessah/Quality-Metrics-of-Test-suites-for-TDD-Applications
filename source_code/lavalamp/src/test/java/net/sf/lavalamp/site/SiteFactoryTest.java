package net.sf.lavalamp.site;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.io.IOException;

import net.sf.lavalamp.site.impl.BambooRemoteApi;
import net.sf.lavalamp.site.BuildSite;

import org.junit.Test;
@SuppressWarnings("deprecation")
public class SiteFactoryTest {

	@Test
	public void testMake() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		
		SiteProperties siteProperties = new SiteProperties();
		siteProperties.setClassName(
				"net.sf.lavalamp.site.impl.BambooRemoteApi");
		siteProperties.setUrl( "url");

		BuildSite server = new SiteFactory().make(siteProperties);
		assertThat(server, instanceOf(BambooRemoteApi.class));
	}

	@Test(expected = ClassNotFoundException.class)
	public void testMakeWithBadClass() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		
		SiteProperties siteProperties = new SiteProperties();
		siteProperties.setClassName(
				"bad.Class");
		
		new SiteFactory().make(siteProperties);

	}

}
