package net.sf.lavalamp.device;

import java.util.List;

import net.sf.lavalamp.site.Build;

public class HtmlFormatter {
	private final List<Device> devices;
		
	public HtmlFormatter(List<Device> devices) {
		this.devices = devices;
	}
	
	public String toHtml() {
		StringBuffer buffer = new StringBuffer();

		for (Device device: devices) {
			appendHeader(buffer, device);
			appendList(buffer, device);

		}
		return buffer.toString();
	}
	
	
	private void appendHeader(StringBuffer buffer, Device device) {
		buffer.append("<h2>");
		buffer.append(device.toString());
		buffer.append("</h2>");
	}

	private void appendList(StringBuffer buffer, Device device) {
		buffer.append("<ul>");
		for (Build build: device.getBuilds().getBuilds()) {
			appendListItem(buffer, build);
		}
		buffer.append("</ul>");
	}

	private void appendListItem(StringBuffer buffer, Build build) {
		buffer.append("<li>");
		buffer.append(build.toString());
		buffer.append("</li>");
	}

}
