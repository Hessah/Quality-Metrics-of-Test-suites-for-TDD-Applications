package net.sf.lavalamp.device;

import java.util.Calendar;

import net.sf.lavalamp.site.Builds;

/**
 * Device that is to be turned on or off
 * @author stehal
 *
 */
public interface Device {
	 
	 Actions getActions(); 
	   
     void setProperties(DeviceProperties properties);
     
     void init();
     
     void turnOn();
     
     void turnOff();
     
     /**
      * Sets the period when the device should be turned off irrespective of build status
      * @param period the period when the device should be off
      */
     void setAlwaysOffPeriod(Period period);
     
     /**
      * 
      * @param now
      * @return true if the device must be off now irrespective of build status
      */
     boolean isAlwaysOff(Calendar now);
     
     Builds getBuilds();
 	 
     void setBuilds(Builds builds);

	

    
}
