package net.sf.lavalamp.device;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.AuthenticationException;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.application.ApplicationProperties;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.Builds;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.MissingBuildException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeviceControllerTest {

	private DeviceController deviceController;

	
	@Mock
	private Device device;

	@Mock
	private Builds builds;

	@Mock
	private Build build;
	@Mock
	Console console;

	ApplicationProperties properties;

	List<Device> devices;

	@Mock
	Actions actions;
	@Mock
	Pause pause;

	@Mock
	LavaLogger logger;

	private Calendar calendar;

	@Before
	public void setUp() throws FileNotFoundException, IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, AuthenticationException,
			MissingBuildException {
		MockitoAnnotations.initMocks(this);
		calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 10);

		List<Device> devices = new ArrayList<Device>();
		device.setBuilds(builds);

		List<Build> buildList = new ArrayList<Build>();
		buildList.add(build);

		when(builds.getBuilds()).thenReturn(buildList);
		when(build.getIdentity()).thenReturn("build_one");
		when(builds.getBuild(eq("build_one"))).thenReturn(build);

		when(builds.getBuild(eq("build_three"))).thenThrow(
				new MissingBuildException("whoops"));
		when(device.getBuilds()).thenReturn(builds);
		
		devices.add(device);

		deviceController = new DeviceController(devices);

		deviceController.setLogger(logger);
	}

	@Test
	public void shouldFindBuildInSecondDevice() throws MissingBuildException {

		deviceController.getBuild("ORIGOO");

	}

	@Test(expected = MissingBuildException.class)
	public void shouldntFindBuild() throws MissingBuildException {
		deviceController.getBuild("build_three");

	}

	@Test
	public void shouldFindBuildInFirstDevice() throws MissingBuildException {
		deviceController.getBuild("ORIGO");

	}

	@Test
	public void shouldCheckAllBuildsAndTurnOffWhenSuccessful()
			throws AuthenticationException {
		when(device.getActions()).thenReturn(actions);
		when(actions.getSuccessAction()).thenReturn(new TurnOff());
		when(actions.getFailureAction()).thenReturn(new TurnOn());

		when(builds.allSuccessful()).thenReturn(true);
		deviceController.switchDevices(calendar);
		verify(device).turnOff();
	}

	@Test
	public void shouldTurnOnWhenSuccessful() throws AuthenticationException {
		when(device.getActions()).thenReturn(actions);
		when(actions.getSuccessAction()).thenReturn(new TurnOn());
		when(builds.allSuccessful()).thenReturn(true);

		deviceController.switchDevices(calendar);
		verify(device).turnOn();
	}

	@Test
	public void shouldTurnOffWhenFail() throws AuthenticationException,
			MissingBuildException {
		when(device.getActions()).thenReturn(actions);
		when(actions.getSuccessAction()).thenReturn(new TurnOn());
		when(actions.getFailureAction()).thenReturn(new TurnOff());

		when(builds.allSuccessful()).thenReturn(false);
		deviceController.turnOffOrOn(new ArrayList<String>(), builds, device);
		verify(device).turnOff();
	}

	@Test
	public void shouldTurnOnWhenFail() throws AuthenticationException,
			MissingBuildException {
		when(device.getActions()).thenReturn(actions);
		when(actions.getFailureAction()).thenReturn(new TurnOn());
		when(builds.allSuccessful()).thenReturn(false);
		deviceController.turnOffOrOn(new ArrayList<String>(), builds, device);
		verify(device).turnOn();
	}

	@Test
	public void shouldCheckAllBuildsAndTurnOffWhenAlwaysOff()
			throws AuthenticationException {
		when(device.isAlwaysOff(calendar)).thenReturn(true);
		deviceController.switchDevices(calendar);
		verify(device).turnOff();
	}

	@Test
	public void shouldCheckAllBuildsAndTurnOn() throws AuthenticationException,
			MissingBuildException {
		when(device.getActions()).thenReturn(actions);
		when(actions.getFailureAction()).thenReturn(new TurnOn());

		deviceController.setStatusForBuild("build_one", false);
		deviceController.switchDevices(calendar);
		verify(device).turnOn();
	}

	@Test
	public void shouldSetStatusForBuild() throws MissingBuildException {
		deviceController.setStatusForBuild("build_one", false);
		Build origo = deviceController.getBuild("build_one");
		assertThat(origo.isSuccessful(), is(false));

	}

	@Test(expected = MissingBuildException.class)
	public void shouldBeExceptionWhenWrongBuildName()
			throws MissingBuildException {
		deviceController.getBuild("build_three");

	}

}
