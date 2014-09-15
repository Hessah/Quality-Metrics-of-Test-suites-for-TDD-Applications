package net.sf.lavalamp;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LavaLoggerTest {

	private LavaLogger logger;
	private static final String NOW = "Sun May 31 08:26:33 CEST 2009";
	@Mock
	PrintStream out;
	
	@Mock
	PrintStream err;
	
	
	Calendar calendar;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		LavaLogger.setOut(out);
		LavaLogger.setErr(err);
		logger = new LavaLogger();
		calendar = Calendar.getInstance();
		calendar.setTimeInMillis(1243751193000l);
	
	}

	@Test
	public void testInfo() {
		logger.info(calendar, "info");
		verify(out).println(NOW + " info");
	}
	
	@Test
	public void testInfoWithoutCalendar() {
		logger.info( "info");
		verify(out).println(anyString());
	}

	@Test
	public void testErrorWithoutCalendar() {
		logger.error(new RuntimeException("whoops"));
		verify(err).println(anyString());
	}

	@Test
	public void testError() {
		logger.error(calendar, new RuntimeException("message"));

		verify(err).println(NOW + " message");
	}
	

	@Test
	public void testErrorOnlyMessage() {
		logger.error("message");

		verify(err).println("message");
	}

	@Test
	public void testNoDebug() {
		logger.debug(calendar, "debug");
		verify(out, never()).println(NOW + " debug");
	}

	@Test
	public void testDebug() {
		LavaLogger.setDebug(true);
		logger.debug(calendar, "debug");
		verify(out).println(NOW + " debug");
	}
	
}
