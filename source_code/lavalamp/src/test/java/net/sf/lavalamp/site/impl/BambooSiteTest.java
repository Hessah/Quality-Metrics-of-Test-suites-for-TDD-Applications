package net.sf.lavalamp.site.impl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;

import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.Getter;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;
import net.sf.lavalamp.site.SiteProperties;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@SuppressWarnings("deprecation")
public class BambooSiteTest {
	@Mock
	SiteProperties llp;
	private static final String RESPONSE_FAILED = "<response>" + "<build>"
			+ "<name>Confluence Stable - LDAP User Management</name>"
			+ "<key>AAA-LDAP</key>" + "<buildState>failed</buildState>"
			+ "<buildNumber>146</buildNumber>"
			+ "<failedTestCount>0</failedTestCount>"
			+ "<successfulTestCount>4</successfulTestCount>"
			+ "<buildTime>2008-02-12 23:21:41</buildTime>" + "</build>";
	private static final String RESPONSE_SUCCESSFUL = "<response>" + "<build>"
			+ "<name>Confluence Stable - LDAP User Management</name>"
			+ "<key>AAA-LDAP</key>" + "<buildState>Successful</buildState>"
			+ "<buildNumber>146</buildNumber>"
			+ "<failedTestCount>0</failedTestCount>"
			+ "<successfulTestCount>4</successfulTestCount>"
			+ "<buildTime>2008-02-12 23:21:41</buildTime>" + "</build>";
	private static final String LOGIN_ACTION = "/api/rest/login.action?username=id&password=";
	private static final String AUTH = "aU5ybWbzfw";
	private static final String RESPONSE_AUTH = "<response><auth>aU5ybWbzfw</auth></response>";
	private static final String RESPONSE_AUTH_ERROR = "<error>User not authenticated</error>";

	private static final String ID = "id";
	private static final String SERVER_URL = "http://localhost:80/build";
	private static final String SERVER2_URL = "http://localhost:8080/build";
	
	BambooRemoteApi bs = new BambooRemoteApi();
	SiteProperties siteProperties;
	Build bOne;
	Build bTwo;

	@Mock
	Getter urlGetter;
	@Mock
	Console console;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		siteProperties = new SiteProperties();
		siteProperties.setUrl(SERVER_URL);
		bOne = new Build("one");
		bTwo = new Build("two");
	}

	
	@Test
	public void shouldGetLoginUrl() {
		bs.setProperties(siteProperties);
		assertThat(bs.getLoginUrl(ID).toString(), is(SERVER_URL + LOGIN_ACTION));
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowRuntimeLogin() throws LoginRequiredException,
			IOException, LoginFailedException {
		when(urlGetter.get(SERVER_URL + LOGIN_ACTION, "pwd".toCharArray()))
				.thenReturn(RESPONSE_AUTH_ERROR);
		bs.setCredentials(console);
		bs.setUrlGetter(urlGetter);
		bs.setProperties(siteProperties);
		bs.login();
	}

	
	@Test
	public void shouldLogin() throws LoginRequiredException, IOException, LoginFailedException {
		when(urlGetter.get(SERVER_URL + LOGIN_ACTION, "pwd".toCharArray()))
				.thenReturn(RESPONSE_AUTH);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(console.readPassword(any(String.class), any(String.class), any(String.class))).thenReturn( "pwd".toCharArray());
		bs.setUrlGetter(urlGetter);

		bs.setProperties(siteProperties);
		bs.setCredentials(console);
		
		bs.login();
		assertThat(bs.getAuthenticationKey(), is(AUTH));
	}
	
	@Test
	public void shouldShareAuthForSameUrl() throws LoginRequiredException, IOException, LoginFailedException {
		when(urlGetter.get(SERVER_URL + LOGIN_ACTION, "pwd".toCharArray()))
				.thenReturn(RESPONSE_AUTH);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(console.readPassword(any(String.class), any(String.class), any(String.class))).thenReturn( "pwd".toCharArray());
		bs.setUrlGetter(urlGetter);

		bs.setProperties(siteProperties);
		bs.setCredentials(console);
		
		bs.login();
		
		BambooRemoteApi bs2 = new BambooRemoteApi();
		SiteProperties site2Properties = new SiteProperties();
		site2Properties.setUrl(SERVER_URL);
		bs2.setProperties(site2Properties);
		assertThat(bs2.getAuthenticationKey(), is(AUTH));

	}

	@Test
	public void shouldNotShareAuthForDifferentUrl() throws LoginRequiredException, IOException, LoginFailedException {
		when(urlGetter.get(SERVER_URL + LOGIN_ACTION, "pwd".toCharArray()))
				.thenReturn(RESPONSE_AUTH);
		when(console.readLine(any(String.class))).thenReturn("id");
		when(console.readPassword(any(String.class), any(String.class), any(String.class))).thenReturn( "pwd".toCharArray());
		bs.setUrlGetter(urlGetter);

		bs.setProperties(siteProperties);
		bs.setCredentials(console);
		
		bs.login();
		
		BambooRemoteApi bs2 = new BambooRemoteApi();
		SiteProperties site2Properties = new SiteProperties();
		site2Properties.setUrl(SERVER2_URL);
		bs2.setProperties(site2Properties);
		assertThat(bs2.getAuthenticationKey(), not(AUTH));

	}


	@Test(expected = LoginRequiredException.class)
	public void shouldThrowExceptionWhenNotAuthenticated()
			throws LoginRequiredException {
		bs.wasBuildSuccessful(RESPONSE_AUTH_ERROR);
	}

	@Test
	public void shouldFindAuth() {
		assertThat(bs.findAuth(RESPONSE_AUTH), is(AUTH));
	}

	@Test
	public void shouldBeSuccessful() throws LoginRequiredException {
		assertThat(bs.wasBuildSuccessful(RESPONSE_SUCCESSFUL), is(true));
	}

	@Test
	public void shouldBeFailed() throws LoginRequiredException {
		assertThat(bs.wasBuildSuccessful(RESPONSE_FAILED), is(false));
	}

	@Test(expected = RuntimeException.class)
	public void shouldBeException() throws LoginRequiredException, IOException, LoginFailedException {
		bs.setUrlGetter(urlGetter);
		when(urlGetter.get(anyString())).thenReturn(RESPONSE_AUTH_ERROR);
		bs.login();
	}

}
