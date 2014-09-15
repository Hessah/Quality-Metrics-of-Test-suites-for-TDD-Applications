package net.sf.lavalamp.device;

import java.io.Serializable;
import java.util.Calendar;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.site.Builds;

public abstract class AbstractDevice implements Device, Serializable {
	private static final long serialVersionUID = -707948956275520549L;

	protected transient LavaLogger logger = new LavaLogger();

	protected String identity;
	protected Period offPeriod;
	protected DeviceProperties properties;
	private transient Actions actions;
	protected Builds builds;

	@Override
	public Actions getActions() {
		return actions;
	}
	
	@Override
	public void setProperties(DeviceProperties properties) {
		this.properties = properties;
		identity = properties.getIdentity();
		makeActions();
		offPeriod = new Period( new TimeOfDay(properties.getOff().getStart()), new TimeOfDay(properties
				.getOff().getEnd()));

	}
	@Override
	public String toString() {
		return String.format("device %s", identity);
	}
	
	@Override
	public void turnOn() {
		logger.info("turning on " + this.toString());
	}
	
	@Override
	public void turnOff() {
		logger.info("turning off " + this.toString());
	}

	private void makeActions() {
		Action successAction = null;
		Action failureAction = null;
		Action errorAction = null;

		if (properties.isOnWhenSuccessful()) {
			successAction = new TurnOn();
			failureAction = new TurnOff();
		} else {
			successAction = new TurnOff();
			failureAction = new TurnOn();
		}
		errorAction = makeErrorAction();

		actions = new Actions(successAction, failureAction, errorAction);
	}

	private Action makeErrorAction() {
		Action errorAction;
		OnError onError = properties.getOnError();
		if (onError.equals(OnError.CRASH)) {
			errorAction = new Crash();
		} else if (onError.equals(OnError.STATUSQUO)) {
			errorAction = new StatusQuo();
		} else {
			errorAction = new Blink();
		}

		return errorAction;
	}

	@Override
	public void setAlwaysOffPeriod(Period period) {
		this.offPeriod = period;
	}

	@Override
	public boolean isAlwaysOff(Calendar now) {
		return offPeriod.isInPeriod(now);
	}
	
	@Override
	public Builds getBuilds() {
		return builds;
	}
	
	@Override
	public void setBuilds(Builds builds) {
		this.builds = builds;
	}

}
