package net.sf.lavalamp.device;

import org.junit.Test;

public class CrashTest {

	@Test (expected=RuntimeException.class)
	public void testPerform() {
		new Crash().perform(null, null);
	}

}
