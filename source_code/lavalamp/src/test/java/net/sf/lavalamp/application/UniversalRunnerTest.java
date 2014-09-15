package net.sf.lavalamp.application;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.site.Console;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UniversalRunnerTest {

	@Mock
	LavaLogger logger;

	
	@Mock
	Application app;
	@Mock
	Console console;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldPrintUsageWhenNoArgs() throws Exception {

		UniversalRunner runner = new UniversalRunner();
		String[] args = {};
		runner.run(args, app, console, logger);
		verify(logger).error(any(String.class));
		
	}

	@Test
	public void shouldPrintUsageWhenTooManyArgs() throws Exception {
		UniversalRunner runner = new UniversalRunner();
		String[] args = { "", "" };
		runner.run(args, app, console, logger);
		verify(logger).error(any(String.class));
		
	}

	@Test
	public void shouldExec() throws Exception {

		String fileName = "src/test/resources/test.yml";
		UniversalRunner runner = new UniversalRunner();
		String[] args = { fileName };
		runner.run(args, app, console, logger);
		verify(logger, never()).error(any(String.class));

		verify(app).exec(eq(logger), any(Pause.class));
	}
}
