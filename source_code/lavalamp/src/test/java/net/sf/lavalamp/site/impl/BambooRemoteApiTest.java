package net.sf.lavalamp.site.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;

import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.Getter;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;
import net.sf.lavalamp.site.SiteProperties;

import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BambooRemoteApiTest {
	@SuppressWarnings("deprecation")
	BambooRemoteApi bamboo = new BambooRemoteApi();
	SiteProperties properties = new SiteProperties();

	@Mock
	Getter urlGetter;

	@Mock
	Console console;

	@Before
	public void setUp() throws IOException, LoginRequiredException {
		MockitoAnnotations.initMocks(this);
		when(urlGetter.get(anyString(), any(char[].class))).thenReturn("<error>");

	}

	@After
	public void tearDown() throws IOException, LoginRequiredException {
		bamboo.clearCredentials();

	}

	@SuppressWarnings("deprecation")
	@Test(expected = LoginFailedException.class)
	public void testLogin() throws LoginRequiredException,
			LoginFailedException, IOException {
		properties.setUrl("http://myurl:8080");
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("id", "pwd");
		bamboo.setCredentials("http://myurl:8080", credentials);

		bamboo.setProperties(properties);
		bamboo.setUrlGetter(urlGetter);

		bamboo.login();
	}

}
