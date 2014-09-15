package net.sf.lavalamp.site;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;

import net.sf.lavalamp.site.BuildSite;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BuildsCheckerTest {

	BuildChecker bc;

	@Mock
	BuildSite mockSite;
	Builds builds;
	Build bOne;

	@Mock
	Console console;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		bc = new BuildChecker();
		builds = new Builds();
		bOne = new Build("one");
		bOne.setBuildSite(mockSite);

	}

	@Test
	public void lastBuildShouldBeSuccessfulWhenOneBuildId()
			throws LoginRequiredException, IOException, LoginFailedException {
		builds.add(bOne);

		when(mockSite.wasLastBuildSuccessful(bOne)).thenReturn(true);
		bc.check(bOne, console);
		assertThat(builds.allSuccessful(), is(true));
	}

	@Test
	public void buildShouldNotBeSuccessfulWhenFails()
			throws LoginRequiredException, IOException, LoginFailedException {
		builds.add(bOne);
		when(mockSite.wasLastBuildSuccessful(bOne)).thenReturn(false);

		assertThat(bc.check(bOne, console), is(false));
	}

	@Test
	public void shouldLogonWhenCheckingAllBuilds() throws Exception {
		builds.add(bOne);
		when(mockSite.wasLastBuildSuccessful(bOne)).thenThrow(
				new LoginRequiredException()).thenReturn(true);
		bc.check(bOne, console);
		verify(mockSite).login();

	}
	
	@Test (expected=LoginFailedException.class)
	public void shouldThrowExceptionWhenLoginFails() throws Exception {
		 doThrow(new LoginRequiredException()).when(mockSite).login();
		
		bc.checkAgainAfterLoginAttempt(bOne, mockSite);

	}
}
