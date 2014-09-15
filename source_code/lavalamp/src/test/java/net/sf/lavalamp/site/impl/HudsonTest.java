package net.sf.lavalamp.site.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.site.AuthBuildSite;
import net.sf.lavalamp.site.Build;
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

public class HudsonTest {
	AuthBuildSite site = new Hudson();
	SiteProperties properties = new SiteProperties();

	@Mock
	Getter urlGetter;

	@Mock
	Console console;
	
	
	@Before
	public void setUp() throws IOException, LoginRequiredException {
		MockitoAnnotations.initMocks(this);
		when(urlGetter.get(contains("IDA"))).thenThrow(
				new LoginRequiredException());
		when(urlGetter.get(contains("IDS/lastBuild"))).thenReturn("5");
		when(urlGetter.get(contains("IDS/lastSucc"))).thenReturn("5");
		when(urlGetter.get(contains("IDF/lastBuild"))).thenReturn("5");
		when(urlGetter.get(contains("IDF/lastSucc"))).thenReturn("4");
	}
	
	
	@After
	public void tearDown() throws IOException, LoginRequiredException {
		site.clearCredentials();
		
	}

	@Test
	public void testGetLastBuildUrl() throws UnsupportedEncodingException {
		properties.setUrl("http://myurl:8080");
		site.setProperties(properties);
		Build build = new Build("ID");

		assertEquals("http://myurl:8080/job/ID/lastBuild/buildNumber", site
				.getLastBuildUrl(build));
	}

	@Test
	public void shouldLogin() throws LoginRequiredException, IOException,
			LoginFailedException {
		properties.setUrl("http://myurl:8080");
		site.setProperties(properties);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(
				console.readPassword(any(String.class), any(String.class),
						any(String.class))).thenReturn("pwd".toCharArray());
		site.setUrlGetter(urlGetter);
		site.setCredentials(console);
		site.login();
		assertThat(site.getCredentials().getUserName(), is("id"));
	}
	
	@Test
	public void lastBuildSuccessfulWhenCredentialSet() throws LoginRequiredException, IOException,
			LoginFailedException {
		properties.setUrl("http://myurl:8080");
		site.setProperties(properties);
		
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("id", "pwd");
		site.setCredentials("http://myurl:8080", credentials);
		
		when(urlGetter.get(anyString())).thenReturn("5").thenReturn("5");
		
		site.setUrlGetter(urlGetter);
		Build build = new Build("ID");
		site.wasLastBuildSuccessful(build);
		verify(urlGetter).setCredentials(any(UsernamePasswordCredentials.class));
	}





	

	@Test
	public void lastBuildSuccessful() throws LoginRequiredException,
			IOException {
		site.setUrlGetter(urlGetter);
		Build build = new Build("IDS");
		assertTrue(site.wasLastBuildSuccessful(build));
	}

	@Test(expected = LoginRequiredException.class)
	public void shouldAuthenticate() throws LoginRequiredException, IOException {
		site.setUrlGetter(urlGetter);
		Build build = new Build("IDA");
		site.wasLastBuildSuccessful(build);
	}

	@Test
	public void lastBuildFailure() throws LoginRequiredException, IOException {
		site.setUrlGetter(urlGetter);
		Build build = new Build("IDF");
		assertFalse(site.wasLastBuildSuccessful(build));
	}
}
