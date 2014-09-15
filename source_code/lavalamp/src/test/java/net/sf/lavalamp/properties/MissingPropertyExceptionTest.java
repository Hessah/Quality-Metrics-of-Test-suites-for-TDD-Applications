package net.sf.lavalamp.properties;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class MissingPropertyExceptionTest {

	@Test
	public void testMissingPropertyExceptionStringThrowable() {
		MissingPropertyException mpe = new MissingPropertyException("my message", new RuntimeException("whoops"));
		assertThat(mpe.getMessage(), is("my message"));
		assertThat(mpe.getCause().getMessage(), is("whoops"));
		
	}
	
	@Test
	public void testMissingPropertyExceptionString() {
		MissingPropertyException mpe = new MissingPropertyException("my message");
		assertThat(mpe.getMessage(), is("my message"));
		
	}

}
