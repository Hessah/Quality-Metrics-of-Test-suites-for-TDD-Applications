package net.sf.lavalamp.application;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.lavalamp.Pause;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.BuildChecker;
import net.sf.lavalamp.site.Builds;
import net.sf.lavalamp.device.Action;
import net.sf.lavalamp.device.Actions;
import net.sf.lavalamp.device.Device;
import net.sf.lavalamp.device.DeviceController;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.LoginFailedException;
import net.sf.lavalamp.site.LoginRequiredException;
import net.sf.lavalamp.site.UrlGetter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WebRunTest {
	static EmbeddedWebRun twr = new EmbeddedWebRun();
	@Mock
	Actions actions;
	@Mock
	UrlGetter getter;
	@Mock
	private Build build;
	@Mock
	private Device device;
	@Mock
	private Console console;
	@Mock
	private Action errorAction;
	
	@Mock
	private DeviceController deviceController;
	@Mock
	private Pause pause;
	@Mock
	private Builds builds;
	@Mock
	private BuildChecker checker;

	@BeforeClass
	public static void classSetUp() throws InterruptedException {

		twr.start();
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		
	}

	@Test
	public void shouldInit() throws Exception {
		String fileName = "src/test/resources/test.yml";
		WebRun run = new WebRun();
		ApplicationProperties properties = new ApplicationPropertiesLoader()
				.load(fileName);
		run.setProperties(properties);

		run.init();
		assertNotNull(run.getDeviceController());
	}

	@Test(expected = IOException.class)
	public void shouldBeExceptionWhenBuildNotFound() throws Exception {
		new UrlGetter()
				.get("http://localhost:8092/lavalamp?buildId=xxx&successful=true");
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldBeExceptionWhenLoginFails() throws Exception {
		when(checker.check(any(Build.class), any(Console.class))).thenThrow(new LoginFailedException());
		
		WebRun run = new WebRun();
		run.checkBuild(checker, getter, console, device, build);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldPerformErrorAction() throws Exception {
		when(getter.get(anyString())).thenThrow(new LoginRequiredException());
		when(device.getActions()).thenReturn(actions);
		when(actions.getErrorAction()).thenReturn(errorAction);
		WebRun run = new WebRun();
		run.checkBuild(checker, getter, console, device, build);
		verify(errorAction).perform(any(List.class), any(Device.class));
	}
	
	@Test
	public void shouldCheckAllBuildsWhenNoDevice() throws Exception {
		
		when(deviceController.getDevices()).thenReturn(new ArrayList<Device>());
		WebRun run = new WebRun();
		run.checkAllBuilds(checker, getter, deviceController, pause, console, 10);
		verifyZeroInteractions(getter);
		verify(pause).sleep(10);
	}
	
	@Test
	public void shouldCheckAllBuildsWhenNoBuild() throws Exception {
		List<Device> devices = new ArrayList<Device>();
		devices.add(device);
		when(deviceController.getDevices()).thenReturn(devices);
		when(device.getBuilds()).thenReturn(builds);
		WebRun run = new WebRun();
		run.checkAllBuilds(checker, getter, deviceController, pause, console, 10);
		verifyZeroInteractions(getter);
		verify(pause).sleep(10);
	}



	@Test
	public void shouldHandle() throws Exception {
		String response = new UrlGetter()
				.get("http://localhost:8092/lavalamp?buildId=CATHCART-UNIT&successful=true");
		assertThat(response, containsString("turned off"));
	}

}
