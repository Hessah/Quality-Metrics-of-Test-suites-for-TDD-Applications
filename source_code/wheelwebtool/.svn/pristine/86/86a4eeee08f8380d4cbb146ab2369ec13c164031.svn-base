/*
Copyright (c) 2007-2008, Henri Frilund

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package wheel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * The servlet that handles all requests to Wheel. Has three functions:<br/>
 * <ol>
 *  <li>Reads configuration from web.xml.</li>
 *  <li>Dispatches requests to EngineImpl</li>
 *  <li>Isolates the wheel.enhance.WheelClassLoader from other classloaders to enable non-delegating class loading.</li>
 * </ol>
 *
 * <b>Configuration settings:</b><br/>
 *
 * <dl>
 *  <dt><b>basePackageForPages</b></dt>
 *  <dd>Mandatory. Tells Wheel where to load pages. The value must be a java package name that is given up to the point where Wheel sould start loading pages.
 *  Example: Your page-classes are in com.foo.bar.pages -package which is what you'd set as the value for this parameter. When the application starts, all pages that
 *  are in that package can be viewed by simply appending the page class name at the end of the url. Also sub-packages for the given package are available by appending also the sub-packagename
 *  to the url and replacing '.' with '/'. So for example "admin/Main" would load the class com.foo.bar.pages.admin.Main.
 *  </dd>
 *  <dt><b>applicationPackages</b></dt>
 *  <dd>Mandatory. All packages that will contain pages or components used by your application should be here, inlcuding the package given in basePackageForPages.
 *  For example if you use components from an external jar, you need to add the package here. Package names are separated by comma.</dd>
 *  <dt><b>cssPath</b></dt>
 *  <dd>Optional. Sets the path relative to the application root where css-files are. The default is: "css"</dd>
 *  <dt><b>jsPath</b></dt>
 *  <dd>Optional. Sets the path relative to the application root where js-files are. The default is: "js"</dd>
 *  <dt><b>startPage</b></dt>
 *  <dd>Optional. Sets the page to load when no page is given. The default is: "Home"</dd>
 *  <dt><b>developmentMode</b></dt>
 *  <dd>Optional. Enables automatic class reloading. Will slow the application down considrebaly, use with caution.. The default is: "false"</dd>
 *  <dt><b>watchForUpdate</b></dt>
 *  <dd>Optional. When developmentMode is set on, this setting can be used to add additional locations to check for modified files. The comma-separated entries can be
 *  either context-related files (starting with '/') or relative file paths relative to the startup directory.</dd>
 * </dl>
 *
 * @author Henri Frilund
 */
public class WheelServlet extends HttpServlet {
    private final Logger log = LoggerFactory.getLogger(WheelServlet.class);
    private ServletContext context;
    private boolean developmentMode;
    private Set<String> applicationPackages;
    private String cssRoot;
    private Set<String> watchForUpdate;

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        handleRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        handleRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        context = servletConfig.getServletContext();
        String basePackage = servletConfig.getInitParameter("basePackageForPages");
        String applicationPackagesS = servletConfig.getInitParameter("applicationPackages");
        cssRoot = servletConfig.getInitParameter("cssPath") == null ? "css" : servletConfig.getInitParameter("cssPath");
        String jsRoot = servletConfig.getInitParameter("jsPath") == null ? "js" : servletConfig.getInitParameter("jsPath");
        String startPage = servletConfig.getInitParameter("startPage") == null ? "Home" : servletConfig.getInitParameter("startPage");
        String developmentModeS = servletConfig.getInitParameter("developmentMode");
        developmentMode = developmentModeS != null && developmentModeS.equalsIgnoreCase("true");
        String watchForUpdateS = servletConfig.getInitParameter("watchForUpdate");

        if (developmentMode) {
            log.warn("Development mode is on. Make sure you do not leave it on in production!");
            context.setAttribute("wheelDevelopmentMode", "");
        }

        context.setAttribute("wheelCssPath", cssRoot);
        context.setAttribute("wheelJsPath", jsRoot);
        context.setAttribute("wheelStartPage", startPage);


        assert (basePackage != null && basePackage.length() > 0);
        assert (applicationPackagesS != null && applicationPackagesS.length() > 0);

        context.setAttribute("basePackageForPages", basePackage);

        applicationPackages = new HashSet<String>();
        String[] packagesSplit = applicationPackagesS.split(",");

        for (int i = 0; i < packagesSplit.length; i++) {
            String packageS = packagesSplit[i];
            applicationPackages.add(packageS.trim());
        }

        applicationPackages.add("wheel");
        context.setAttribute("wheelApplicationPackages", applicationPackages);
        
        if (watchForUpdateS != null) {
            watchForUpdate = new HashSet<String>();

            String[] watchForUpdateSplit = watchForUpdateS.split(",");

            for (int i = 0; i < watchForUpdateSplit.length; i++) {
                String location = watchForUpdateSplit[i];
                watchForUpdate.add(location);
            }
        }
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String serverClassName = "wheel.EngineImpl";

        if (isMultipartRequest(request))
            serverClassName = "wheel.MultipartEngineImpl";

        IResourceManager resourceManager = null;

        if (developmentMode)
            resourceManager = new DevelopmentResourceManager(context);
        else
            resourceManager = new DefaultResourceManager(context);

        try {
            Class serverClass = resourceManager.loadClass(serverClassName);
            Constructor cons = serverClass.getConstructor(HttpServletRequest.class, HttpServletResponse.class, ServletContext.class);
            Object serverObject = cons.newInstance(request, response, context);
            Method processRequestMethod = serverClass.getMethod("processRequest");
            processRequestMethod.invoke(serverObject);
        } catch (ClassNotFoundException e) {
            log.error("Could not load wheel.EngineImpl.", e);
        } catch (NoSuchMethodException e) {
            log.error("Could not execute processRequest.", e);
        } catch (IllegalAccessException e) {
            log.error("Could not access wheel.Engine1Impl", e);
        } catch (InvocationTargetException e) {
            log.error("Error while processing request.", e);
        } catch (InstantiationException e) {
            log.error("Could not instantiate wheel.EngineImpl.", e);
        }
    }


    private boolean isMultipartRequest(HttpServletRequest request) {
        if (!"post".equals(request.getMethod().toLowerCase())) {
            return false;
        }

        String contentType = request.getContentType();

        if (contentType == null) {
            return false;
        }
        if (contentType.toLowerCase().startsWith("multipart/")) {
            return true;
        }
        return false;
    }
}
