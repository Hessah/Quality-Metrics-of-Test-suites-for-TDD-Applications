package net.sf.lavalamp.site.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.Getter;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;
import net.sf.lavalamp.site.SiteProperties;
import net.sf.lavalamp.site.Build;

import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BambooRestApiTest {
	BambooRestApi bamboo = new BambooRestApi();
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
		when(urlGetter.get(contains("IDS"))).thenReturn(
				"sdafasdfas state=\"Successful\" sdfdf");
		when(urlGetter.get(contains("IDF"))).thenReturn(
				"sdafasdfas state=\"Failure\" sdfdf");
		
	}

	@After
	public void tearDown() throws IOException, LoginRequiredException {
		bamboo.clearCredentials();
		
	}
	@Test
	public void testGetLastBuildUrl() throws UnsupportedEncodingException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		Build build = new Build("ID");

		assertEquals("http://myurl:8080/rest/api/latest/build/ID/latest",
				bamboo.getLastBuildUrl(build));
	}
	
	@Test
	public void testGetLastBuildUrlWhenCredentialsSet() throws UnsupportedEncodingException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("id", "pwd");
		bamboo.setCredentials("http://myurl:8080", credentials);
		bamboo.setUrlGetter(urlGetter);
		
		Build build = new Build("ID");

		assertEquals("http://myurl:8080/rest/api/latest/build/ID/latest?os_authType=basic",
				bamboo.getLastBuildUrl(build));
	}

	@Test
	public void shouldLogin() throws LoginRequiredException, IOException,
			LoginFailedException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(
				console.readPassword(any(String.class), any(String.class),
						any(String.class))).thenReturn("pwd".toCharArray());
		bamboo.setUrlGetter(urlGetter);
		bamboo.setCredentials(console); 
		bamboo.login();
		assertThat(bamboo.getCredentials().getUserName(), is("id"));
	}

	@Test
	public void shouldShareCredentialsForSameUrl()
			throws LoginRequiredException, IOException, LoginFailedException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(
				console.readPassword(any(String.class), any(String.class),
						any(String.class))).thenReturn("pwd".toCharArray());
		bamboo.setUrlGetter(urlGetter);
		bamboo.setCredentials(console);
		bamboo.login();
		BambooRestApi bs2 = new BambooRestApi();
		SiteProperties site2Properties = new SiteProperties();
		site2Properties.setUrl("http://myurl:8080");
		bs2.setProperties(site2Properties);

		assertThat(bs2.getCredentials().getUserName(), is("id"));
		assertThat(bs2.getCredentials().getPassword(), is("pwd"));
	}

	@Test
	public void shouldNotShareCredentialsForDifferentUrl()
			throws LoginRequiredException, IOException, LoginFailedException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(console.readPassword(any(String.class), any(String.class),
						any(String.class))).thenReturn("pwd".toCharArray());
		bamboo.setUrlGetter(urlGetter);
		bamboo.setCredentials(console);
		bamboo.login();
		BambooRestApi bs2 = new BambooRestApi();
		SiteProperties site2Properties = new SiteProperties();
		site2Properties.setUrl("http://myurl:80");
		bs2.setProperties(site2Properties);

		assertThat(bs2.getCredentials(), nullValue());
	}

	@Test
	public void lastBuildSuccessful() throws LoginRequiredException,
			IOException {
		bamboo.setUrlGetter(urlGetter);
		Build build = new Build("IDS");
		assertTrue(bamboo.wasLastBuildSuccessful(build));
	}

	@Test(expected = LoginRequiredException.class)
	public void shouldAuthenticate() throws LoginRequiredException, IOException {
		bamboo.setUrlGetter(urlGetter);
		Build build = new Build("IDA");
		bamboo.wasLastBuildSuccessful(build);
	}

	@Test
	public void lastBuildFailure() throws LoginRequiredException, IOException {
		bamboo.setUrlGetter(urlGetter);
		Build build = new Build("IDF");
		assertFalse(bamboo.wasLastBuildSuccessful(build));
	}
}
