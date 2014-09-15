package net.sf.lavalamp.device;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeOfDayTest {

	@Test
	public void testTimeOfDayString() {
		TimeOfDay tod = new TimeOfDay("04:30");
		assertEquals(new Integer(4), tod.getHours());
		assertEquals(new Integer(30), tod.getMinutes());
	}
	
	@Test
	public void testEqualsSame() {
		TimeOfDay tod = new TimeOfDay("04:30");
		assertTrue(tod.equals(tod));
		
	}
	
	@Test
	public void testEqualsNull() {
		TimeOfDay tod = new TimeOfDay("04:30");
		assertFalse(tod.equals(null));
		
	}
	
	@Test
	public void testEqualsWrongType() {
		TimeOfDay tod = new TimeOfDay("04:30");
		assertFalse(tod.equals(new Integer(4)));
		
	}
	@Test
	public void testEqualsWrongHour() {
		TimeOfDay tod = new TimeOfDay("04:30");
		TimeOfDay tod2 = new TimeOfDay("05:30");
		assertFalse(tod.equals(tod2));
		
	}
	
	@Test
	public void testEqualsWrongmin() {
		TimeOfDay tod = new TimeOfDay("04:30");
		TimeOfDay tod2 = new TimeOfDay("04:31");
		assertFalse(tod.equals(tod2));
		
	}
	
	@Test
	public void testHashWhenMinsDiffer() {
		TimeOfDay tod = new TimeOfDay("04:30");
		TimeOfDay tod2 = new TimeOfDay("04:31");
		assertTrue(tod.hashCode() != tod2.hashCode());
		
	}
	@Test
	public void testHashWhenHoursDiffer() {
		TimeOfDay tod = new TimeOfDay("05:31");
		TimeOfDay tod2 = new TimeOfDay("04:31");
		assertTrue(tod.hashCode() != tod2.hashCode());
		
	}
	
	@Test
	public void testHash() {
		TimeOfDay tod = new TimeOfDay("04:31");
		TimeOfDay tod2 = new TimeOfDay("04:31");
		assertTrue(tod.hashCode() == tod2.hashCode());
		
	}


}
