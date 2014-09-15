package net.sf.lavalamp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PauseTest {

	@Test 
	public void testSleep() throws InterruptedException {
		Pause pause = new Pause();
		long start = System.currentTimeMillis();
		pause.sleep(100);
		long elapsed = System.currentTimeMillis()- start;
		assertTrue("Elapsed " + elapsed, elapsed > 50);
		
	}

}
