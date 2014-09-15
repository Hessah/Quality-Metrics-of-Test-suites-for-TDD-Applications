package net.sf.lavalamp.application;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.application.WebRun;
import net.sf.lavalamp.device.DeviceController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlwaysOffTest {
	@Mock
	private WebRun run;
	@Mock
	Pause pause;
	@Mock
	DeviceController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		LavaLogger.setDebug(false);
	}

	@Test
	public void testRun() throws InterruptedException {
		when(run.getDeviceController()).thenReturn(controller);
		doNothing().doThrow(new InterruptedException()).when(pause).sleep(
				anyLong());

		new AlwaysOff(run, pause).run();
		verify(controller).switchDevices(any(Calendar.class));

	}

}
