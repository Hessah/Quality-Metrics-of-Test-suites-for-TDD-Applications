package net.sf.lavalamp.site;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DummyRemoteGetterTest {

	Getter getter = new DummyRemoteGetter();
	@Test 
	public void shouldBeExceptionWhenGetString() throws IOException, LoginRequiredException {
		assertEquals("<error>User not authenticated",getter.get("xxx"));
	}
	
	@Test 
	public void testGetString() throws IOException, LoginRequiredException {
		assertEquals("<buildState>Successful</buildState>", getter.get("http://anyurl.se?auth=auth12345"));
	}

	@Test
	public void testGetStringCharArray() throws IOException, LoginRequiredException {
		char[] chars = "sdf".toCharArray();
		assertEquals("<auth>auth12345</auth>", getter.get("http://anyurl.se?os_authType=basic",chars ));
	}

}
