package net.sf.lavalamp.site;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DummyRestGetterTest {

	Getter getter = new DummyRestGetter();
	
	@Test (expected=LoginRequiredException.class)
	public void shouldBeExceptionWhenGetString() throws IOException, LoginRequiredException {
		getter.get("xxx");
	}
	
	@Test 
	public void testGetString() throws IOException, LoginRequiredException {
		assertEquals("state=\"Successful\"", getter.get("http://anyurl.se?os_authType=basic"));
	}

	@Test
	public void testGetStringCharArray() throws IOException, LoginRequiredException {
		char[] chars = "sdf".toCharArray();
		assertEquals("<auth>auth12345</auth>", getter.get("http://anyurl.se?os_authType=basic",chars ));
	}

}
