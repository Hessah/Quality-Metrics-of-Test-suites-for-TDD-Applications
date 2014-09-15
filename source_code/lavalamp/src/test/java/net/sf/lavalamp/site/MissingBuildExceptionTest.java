package net.sf.lavalamp.site;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class MissingBuildExceptionTest {

	@Test
	public void testExceptionStringThrowable() {
		Exception e = new MissingBuildException("my message", new RuntimeException("whoops"));
		assertThat(e.getMessage(), is("my message"));
		assertThat(e.getCause().getMessage(), is("whoops"));
		
	}
	
	@Test
	public void testExceptionString() {
		Exception e = new MissingBuildException("my message");
		assertThat(e.getMessage(), is("my message"));
		
	}

}
