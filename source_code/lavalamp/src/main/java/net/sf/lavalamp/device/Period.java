package net.sf.lavalamp.device;

import java.util.Calendar;

import net.sf.lavalamp.LavaLogger;
/**
 * A time period
 * @author stehal
 *
 */
public class Period {
	private final LavaLogger logger = new LavaLogger();
	private final TimeOfDay startTime;
	private final TimeOfDay endTime;

	
	public Period(TimeOfDay startTime, TimeOfDay endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public boolean isInPeriod(Calendar now) {

		TimeOfDay nowTime = new TimeOfDay(now.get(Calendar.HOUR_OF_DAY) ,
				 now.get(Calendar.MINUTE));
		
		
		if (startTime.compareTo(endTime)< 0) {
			return isInPeriodWhenStartAndEndOnSameDay(nowTime);
		} else  if (!startTime.equals(endTime)){
			return isInPeriodWhenEndIsNextDay(nowTime);
		}
		return false;

	}

	private boolean isInPeriodWhenEndIsNextDay(TimeOfDay nowTime) {
		assert startTime.compareTo(endTime) > 0;
		if (nowTime.compareTo(startTime) > 0 || nowTime.compareTo(endTime) < 0) {
			logger.debug("In period " + startTime + "-" + endTime);
			return true;
		}
		return false;
	}

	private boolean isInPeriodWhenStartAndEndOnSameDay(TimeOfDay nowTime) {
		assert startTime.compareTo(endTime) <0;
		if (nowTime.compareTo(startTime) >0  && nowTime.compareTo(endTime) < 0) {
			logger.debug("In period " + startTime + "-" + endTime);
			return true;
		}
		return false;
	}

	
}
