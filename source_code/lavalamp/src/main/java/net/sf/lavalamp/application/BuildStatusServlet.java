package net.sf.lavalamp.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.site.MissingBuildException;
import net.sf.lavalamp.device.DeviceController;
import net.sf.lavalamp.device.HtmlFormatter;
/**
 * Sets the status for a build. Handles GET request with format 
 * <code>http://<i>mydomain:port</i>/lavalamp?buildId=<i>MYBUILID</i>&successful=<i>true|false</i></code> 
 * 
 * @author Steven Hale
 *
 */
public class BuildStatusServlet extends HttpServlet {

	private static final long serialVersionUID = -6280526487995952411L;
	public static final String SUCCESSFUL = "successful";
	public static final String BUILD_ID = "buildId";
	private final DeviceController deviceController;

	public BuildStatusServlet(DeviceController deviceController) {
		this.deviceController = deviceController;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		new LavaLogger().debug(request.toString());
		
		String buildId = request.getParameter(BUILD_ID);
		boolean successful = Boolean.valueOf(request.getParameter(SUCCESSFUL));
		
		response.setContentType("text/html");
		
		try {
			deviceController.setStatusForBuild(buildId, successful);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (MissingBuildException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		List<String> events = deviceController.switchDevices(Calendar.getInstance());
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (String event: events) {
			out.println(event + "<br/>");
		}
		out.println(new HtmlFormatter(deviceController.getDevices()).toHtml());
		out.println("</body></html>");
		
	}
}