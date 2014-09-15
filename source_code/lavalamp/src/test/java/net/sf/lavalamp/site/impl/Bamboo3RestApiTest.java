package net.sf.lavalamp.site.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.Getter;
import net.sf.lavalamp.site.LoginRequiredException;
import net.sf.lavalamp.site.SiteProperties;

import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Bamboo3RestApiTest {
	Bamboo3RestApi bamboo = new Bamboo3RestApi();
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
	public void shouldGetLastBuildUrl() throws UnsupportedEncodingException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		Build build = new Build("ID");

		assertEquals("http://myurl:8080/rest/api/latest/result/ID?expand=results%5B0%5D.result",
				bamboo.getLastBuildUrl(build));
	}
	
	@Test
	public void shouldGetLastBuildUrlWhenCredentialsSet() throws UnsupportedEncodingException {
		properties.setUrl("http://myurl:8080");
		bamboo.setProperties(properties);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("id", "pwd");
		bamboo.setCredentials("http://myurl:8080", credentials);
		bamboo.setUrlGetter(urlGetter);
		
		Build build = new Build("ID");

		assertEquals("http://myurl:8080/rest/api/latest/result/ID?expand=results%5B0%5D.result&os_authType=basic",
				bamboo.getLastBuildUrl(build));
	}

	
	
	
}
