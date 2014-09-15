package net.sf.lavalamp.device;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class PeriodTest {
	
	private Calendar now = Calendar.getInstance();

	@Before
	public void setUp() {
		now.set(Calendar.HOUR_OF_DAY, 10);
		now.set(Calendar.MINUTE, 0);
		
	}

	@Test
	public void shouldBeInPeriod() {
		Period period = new Period(new TimeOfDay(9,00), new TimeOfDay(11,0));
		assertTrue(period.isInPeriod(now));
	}
	
	@Test
	public void shouldBeOutOfPeriod() {
		Period period = new Period(new TimeOfDay(11,0), new TimeOfDay(12,0));
		assertFalse(period.isInPeriod(now));
	}
	
	@Test
	public void shouldBeOnWhenPeriodOverMidnight() {
		Period period = new Period(new TimeOfDay(11,0), new TimeOfDay(9,0));
		assertFalse(period.isInPeriod(now));
	}
	
	@Test
	public void shouldBeOffWhenPeriodOverMidnight() {
		Period period = new Period(new TimeOfDay(8,0), new TimeOfDay(7, 0));
		assertTrue(period.isInPeriod(now));
	}

}
