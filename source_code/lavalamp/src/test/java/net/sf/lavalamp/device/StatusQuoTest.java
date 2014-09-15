package net.sf.lavalamp.device;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatusQuoTest {
	
	
	List<String> events = new ArrayList<String>();
	
	
	@Mock
	Device device;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldDoNothing() throws InterruptedException {
		StatusQuo action = new StatusQuo();
		action.perform(events, device);
		assertThat(events.size(), is(equalTo(0)));
		
		
	}
	
	

}
