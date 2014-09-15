package net.sf.lavalamp.device.impl;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Calendar;

import net.sf.lavalamp.device.DeviceProperties;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TellStickJniTest {
	TellStickJni device = new TellStickJni();
	
	@Mock
	TellStickLibrary library;

	DeviceProperties properties;
	Calendar calendar;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		device.setLibrary(library);
		properties = new DeviceProperties();
		properties.setPath("PATH");
		properties.setIdentity("1");
		
		device.setProperties(properties);
		calendar = Calendar.getInstance();
		calendar.set(2009, 1, 1, 4, 45);
	}
	
	@Test (expected=RuntimeException.class)
	public void shouldBeExceptionTurnOn() throws IOException {
		when(library.devTurnOn(1)).thenReturn(false);
		device.turnOn();
		
	}

	@Test (expected=RuntimeException.class)
	public void shouldBeExceptionTurnOff() throws IOException {
		when(library.devTurnOff(1)).thenReturn(false);
		device.turnOff();
	
	}
	
	@Test 
	public void shouldTurnOn() throws IOException {
		when(library.devTurnOn(1)).thenReturn(true);
		device.turnOn();
		
	}

	@Test 
	public void shouldTurnOff() throws IOException {
		when(library.devTurnOff(1)).thenReturn(true);
		device.turnOff();
		
	}
}
