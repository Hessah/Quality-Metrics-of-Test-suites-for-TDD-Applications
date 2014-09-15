package net.sf.lavalamp.site;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BuildsTest {
	
	
	
	Builds builds = new Builds();
	@Mock
	Build successfulBuild;
	@Mock
	Build anotherSuccessfulBuild;
	@Mock
	Build failingBuild;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(successfulBuild.isSuccessful()).thenReturn(true);
		when(anotherSuccessfulBuild.isSuccessful()).thenReturn(true);
		when(failingBuild.isSuccessful()).thenReturn(false);
	}

	@Test
	public void shouldBeSuccessfulWhenOneSuccessfulBuild() {
		builds.add(successfulBuild);
		assertThat(builds.allSuccessful(), is(true));
	}
	
	@Test
	public void shouldNotBeSuccessfulWhenOneFailedBuild() {
		builds.add(failingBuild);
		assertThat(builds.allSuccessful(), is(false));
	}
	
	@Test
	public void shouldNotBeSuccessfulWhenOneFailedBuildAndOneSuccessful() {
		builds.add(failingBuild);
		builds.add(successfulBuild);
		assertThat(builds.allSuccessful(), is(false));
	}
	
	@Test
	public void shouldNotBeSuccessfulWhenOneSuccessfulAndOneFailedBuild() {
		builds.add(successfulBuild);
		builds.add(failingBuild);
	
		assertThat(builds.allSuccessful(), is(false));
	}
	
	@Test
	public void shouldNotBeSuccessfulWhenTwoSuccessfulBuilds() {
		builds.add(successfulBuild);
		builds.add(anotherSuccessfulBuild);
	
		assertThat(builds.allSuccessful(), is(true));
	}

}
