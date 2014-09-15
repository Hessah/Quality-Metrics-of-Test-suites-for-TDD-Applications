package net.sf.lavalamp.device;

import java.io.Serializable;
import java.util.Arrays;

import net.sf.lavalamp.properties.MissingPropertyException;
import net.sf.lavalamp.properties.Off;
import net.sf.lavalamp.site.BuildProperties;

public class DeviceProperties implements Serializable {
	private static final long serialVersionUID = -7368737596438032435L;
	private String identity;
	private String className;
	private String path;
	private boolean onWhenSuccessful = false;
	private OnError onError = OnError.BLINK;
	private BuildProperties[] buildProperties;
	private transient Off off = new Off();

	public BuildProperties[] getBuildProperties() {
		return buildProperties;
	}

	@Override
	public String toString() {
		return "\n\tdevice=" + identity + ", className=" + className
				+ ",  off=" + off + ", onError=" + onError
				+ ", onWhenSuccessful=" + onWhenSuccessful + ", path=" + path
				+ Arrays.toString(buildProperties);
	}

	public void check() {
		if (identity == null) {
			throw new MissingPropertyException(
					"identity must be specified in properties file");
		}
		if (className == null) {
			throw new MissingPropertyException(
					"className must be specified in properties file");
		}

		for (BuildProperties properties : buildProperties) {
			properties.check();
		}

	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void setBuildProperties(BuildProperties[] buildProperties) {
		this.buildProperties = buildProperties;
	}

	public OnError getOnError() {
		return onError;
	}

	public void setOnError(OnError onError) {
		this.onError = onError;
	}

	public Off getOff() {
		return off;
	}

	public void setOff(Off off) {
		this.off = off;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isOnWhenSuccessful() {
		return onWhenSuccessful;
	}

	public void setOnWhenSuccessful(boolean onWhenSuccessful) {
		this.onWhenSuccessful = onWhenSuccessful;
	}
}
