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
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import wheel.components.*;
import wheel.persistence.IObjectStore;
import wheel.persistence.SessionStore;
import wheel.util.WheelURL;
import wheel.util.WrappedException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.SocketException;
import java.util.*;
import java.lang.reflect.Constructor;

/**
 * "main loop" for Wheel. Handles all the request processing.
 *
 * TODO move common functionality to AbstractEngine
 * @author Henri Frilund
 */
public class EngineImpl extends AbstractEngine {
    private final Logger log = LoggerFactory.getLogger(EngineImpl.class);
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String basePackage;
    private String startPage ;
    private String cssPath;
    private String jsPath;
    private OutputStream out;
    private XmlSerializer serializer;
    private String encoding = "UTF-8";

    private ServletContext context;
    private IObjectStore objectStore;
    private Throwable error;
    private Map<String,String> errorMap;
    private StandaloneComponent errorPage;
    private IMessagesSource messagesSource;
    private Locale locale;
    private boolean ajax = false;
    private WheelURL wheelURL;
    private boolean unitTestMode;
    private IResourceManager resourceManager;
    private boolean developmentMode;
    private StandaloneComponent page;
    private Map<String,String> componentTypes;

    public EngineImpl(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        this.request = request;
        this.response = response;
        this.context = context;
        basePackage = (String)context.getAttribute("basePackageForPages");

        startPage = (String)context.getAttribute("wheelStartPage");
        cssPath = (String)context.getAttribute("wheelCssPath");
        jsPath = (String)context.getAttribute("wheelJsPath");

        if (context.getAttribute("wheelUnitTestMode") != null)
            unitTestMode = true;

        if (context.getAttribute("wheelDevelopmentMode") != null) {
            developmentMode = true;
            resourceManager = new DevelopmentResourceManager(context);
        }
        else
            resourceManager = new DefaultResourceManager(context);

        session = request.getSession(false);

        if (session == null)
            session = request.getSession(true);

        messagesSource = new MessageSourceResourceBundleImpl();
        locale = request.getLocale();
        componentTypes = (Map<String,String>)session.getAttribute("wheel.componentTypes");

        if (componentTypes == null)
            componentTypes = new HashMap<String,String>();

    }

    public void processRequestInternal() {
        try {
            Map parameters = readRequestParameters(request);
            String path = request.getPathInfo();

            if (path == null || path.length() == 0) {
                try {
                    response.sendRedirect(request.getContextPath() + request.getServletPath() + "/" + startPage);
                    return;
                } catch (IOException e) {
                    log.error("Could not redirect to '/" + request.getContextPath() + "/" + request.getServletPath() + "/" + startPage + "'.");
                }
            }
            else if (path.equals("/"))
                path = startPage;
            else
                path = path.substring(1, path.length());

            try {
                wheelURL = new WheelURL(path, parameters, this);
            } catch (UnsupportedEncodingException e) {
                log.error("Could not decode URL.", e);
            }

            if (wheelURL.isAssetUrl()) {
                processAssetRequest(path);
                return;
            }

            String updateTargetId = wheelURL.getUpdateTargetId();

            ajax = wheelURL.isAjaxUrl();

            evictPageScope(wheelURL.getPage());

            RenderableComponent renderThis = null;

            try {
                renderThis = buildRenderable(wheelURL.getPage(), new ElExpression(wheelURL.getMethod()), wheelURL.getComponent(), parameters, ajax);
            } catch (RedirectException redirectException) {
                if (redirectException.getPage() != null) {
                    StandaloneComponent redirectedPage = redirectException.getPage();
                    response.setContentType(redirectedPage.config().getContentType());

                    try {
                        response.reset();
                        evictPageScope(redirectedPage.getPagePath());
                        redirectedPage.preBuild();
                        redirectedPage.buildComponent();
                        redirectedPage.postBuild();
                        redirectedPage._render(_getXmlSerializer());
                        return;
                    } catch (Exception e) {
                        log.error("Failed to build redirected page '" + redirectedPage.getPagePath() + "'.", e);
                        setError(e);
                        renderErrorPage();
                        return;
                    }
                }
                else if (redirectException.getUrl() != null) {
                    try {
                        response.reset();
                        response.sendRedirect(redirectException.getUrl());
                        return;
                    } catch (IOException e) {
                        log.error("Failed to send redirect to url '" + redirectException.getUrl() + "'.", e);
                        return;
                    }
                }
            } catch (AbortProcessingException abortException) {
                return;
            } catch(WrappedException wrappedException) {
                setError(wrappedException.getCause());
                renderErrorPage();
                return;
            } catch(Throwable e) {
                setError(e);
                log.error("Failed to build renderable page or component.", e);

                renderErrorPage();

                return;
            } finally{
                if (objectStore != null)
                    objectStore.cleanup();
            }


            StandaloneComponent page = null;

            if (parameters.containsKey("xml"))
                response.setContentType("text/xml");

            try {
                if (ajax) {
                    if (updateTargetId.length() > 0)
                        renderThis = (RenderableComponent)renderThis.getPage().find(updateTargetId);

                    if (renderThis instanceof StandaloneComponent) {
                        StandaloneComponent standaloneComponent = (StandaloneComponent)renderThis;

                        if (!standaloneComponent.isPage())
                            response.setContentType(((StandaloneComponent)renderThis).config().getContentType());
                        else
                            response.setContentType(renderThis.getPage().config().getContentType());
                    }

                    XmlSerializer serializer = _getXmlSerializer();
                    serializer.startDocument(getEncoding(), null);
                    renderThis._render(serializer);
                    serializer.endDocument();
                    serializer.flush();
                }
                else {
                    page = (StandaloneComponent)renderThis;
                    response.setContentType(page.config().getContentType());

                    page._render(_getXmlSerializer());
                    page._getComponentStore().clear();
                }
            } catch (Exception e) {
                log.error("Failed to render page or component with id '" + renderThis.getComponentId() + "'.", e);

                if (!(e instanceof SocketException)) {
                    setError(e);
                    renderErrorPage();
                }
            }


        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("Failed to close output stream." , e);
                }
            }
            session.setAttribute("wheel.componentTypes", componentTypes);
        }
    }

    void setServletContext(ServletContext servletContext) {
        context = servletContext;
    }

    public Set _getAvailableCssFiles() {
        return resourceManager.getResourcesFromPath(cssPath);
    }

    public Set _getAvailableJsFiles() {
        return resourceManager.getResourcesFromPath(jsPath);
    }

    public String getBasePackage() {
        return basePackage;
    }

    private RenderableComponent buildRenderable(String pagePath, ElExpression targetMethod, String targetComponent, Map parameters, boolean ajax) {
        page = loadPage(pagePath);
        Component component = null;
        boolean rebuildPage = false;

        page.preBuild();

        if (parameters.containsKey("wheelSubmitId")) {
            page._setPageRewinding(false);
            page.buildComponent();
            page._postBuildPage();

            Form form = (Form)page.find(((String[])parameters.get("wheelSubmitId"))[0]);

            if (form == null) {
                error = new WheelException("Could not find a Form component that matches the recieved submit.", null);
                renderErrorPage();
            }

            StandaloneComponent formContainer = form._getTopLevelComponent(true);
            page._setSubmittedForm(form);
            page._setSubmitTarget(formContainer.getComponentId());


            for (FormElement element : form.getFormElements()) {
                if (!parameters.containsKey(element.getFormElementName()) && !(element instanceof Checkbox)) {
                    continue;
                }

                if (element instanceof Checkbox) {
                    if (!parameters.containsKey(element.getFormElementName()))
                        element._setSubmitValue(new String[]{"false"});
                    else
                        element._setSubmitValue(new String[]{"true"});

                    continue;
                }

                element._setSubmitValue((String[])parameters.get(element.getFormElementName()));
            }

            if (!form.config().isRenderSelf()) {
                for (FormElement element : form._getForm(false).getFormElements()) {
                    if (!parameters.containsKey(element.getFormElementName()) && !(element instanceof Checkbox)) {
                        continue;
                    }

                    if (element instanceof Checkbox) {
                        if (!parameters.containsKey(element.getFormElementName()))
                            element._setSubmitValue(new String[]{"false"});
                        else
                            element._setSubmitValue(new String[]{"true"});

                        continue;
                    }

                    element._setSubmitValue((String[])parameters.get(element.getFormElementName()));
                }
            }

            if (form.isFormValid() && targetMethod.length() > 0) {
                if (!resourceManager.getActionRegistry().isActionMethod(targetComponent.length() > 0 ? page.find(targetComponent) : page, wheelURL.getMethodName())) {
                    error = new WheelException("Method '" + targetMethod + "' is not registered as an action. Add @ActionMethod annotation to all methods that are action methods.", null);
                    renderErrorPage();
                }

                targetMethod.errorMessage("Form action " + targetMethod + " could not be executed. Make sure you've provided such a method.");
                Object retVal = targetMethod.eval(targetComponent.length() > 0 ? page.find(targetComponent) : formContainer, formContainer);

                if (retVal instanceof StandaloneComponent) {
                    page = (StandaloneComponent)retVal;
                    evictPageScope(page.getPagePath());
                    page.preBuild();
                }
                else if (retVal instanceof String) {
                    page = loadPage((String)retVal);
                    evictPageScope(page.getPagePath());
                    page.preBuild();
                }
                else if (retVal instanceof Boolean) {
                    if (!((Boolean)retVal).booleanValue())
                        throw new AbortProcessingException();
                }
            }

            rebuildPage = true;
            form._clear();
            page._setPageRewinding(true);

        }
        else {
            page._setPageRewinding(false);
            rebuildPage = true;
            page._injectExposedFields();

            if (targetMethod != null && targetMethod.length() > 0) {
                if (targetComponent != null && targetComponent.length() > 0) {

                    boolean findFromPage = false;

                    if (componentTypes.containsKey(pagePath + "/" + targetComponent)) {
                        try {
                            Class componentClazz = resourceManager.loadClass(componentTypes.get(pagePath + "/" + targetComponent));
                            Constructor cons = componentClazz.getConstructor(String.class);
                            component = (Component)cons.newInstance(targetComponent);
                            component._setParent(page);
                        } catch (Exception e) {
                            findFromPage = true;
                        }

                        if (!findFromPage && resourceManager.getActionRegistry().needsRebuilding(component, wheelURL.getMethodName())) {
                            findFromPage = true;
                        }
                    }

                    if (findFromPage) {
                        page.buildComponent();
                        page._postBuildPage();
                        component = page.find(targetComponent);
                    }
                }

                if (!resourceManager.getActionRegistry().isActionMethod(component != null ? component : page, wheelURL.getMethodName())) {
                    throw new WheelException("Method '" + targetMethod + "' is not registered as an action. Add @ActionMethod annotation to all methods that are action methods.", null);
                }

                targetMethod.errorMessage("Failed to call method '" + targetMethod + "' in class " + (component != null ? component : page).getClass().getName());
                Object retVal = targetMethod.eval(component != null ? component : page, component != null ? component : page);

                if (retVal instanceof StandaloneComponent) {
                    page = (StandaloneComponent)retVal;
                    evictPageScope(page.getPagePath());
                    page.preBuild();
                }
                else if (retVal instanceof String) {
                    page = loadPage((String)retVal);
                    evictPageScope(page.getPagePath());
                    page.preBuild();
                }
                else if (retVal instanceof Boolean) {
                    if (!((Boolean)retVal).booleanValue())
                        throw new AbortProcessingException();
                }

                rebuildPage = true;
            }
        }

        if (rebuildPage) {
            page._clear();
            page.buildComponent();
            page._postBuildPage();
        }

        page._postProcessRequest();
        page.postBuild();

        if (targetMethod.length() == 0 && targetComponent.length() > 0 && !parameters.containsKey("wheelSubmitId")) {
            component = page.find(targetComponent);
        }

        if (component != null && ajax)
            return (RenderableComponent)component;

        return page;
    }

    private void renderErrorPage() {
        try {
            response.reset();
            serializer = null;

            StandaloneComponent errorPage = getErrorPage();

            if (errorPage == null && errorMap != null && errorMap.containsKey(error.getClass().getName()))
                errorPage = loadPage(errorMap.get(error.getClass().getName()));

            if (errorPage == null) {
                errorPage = new ErrorPage();
            }

            if (unitTestMode)
                errorPage.config()._setRenderDoctype(false);

            errorPage.buildComponent();
            errorPage._render(_getXmlSerializer());
        } catch (Throwable e) {
            log.error("Failed to render error page.", e);
            try {
                response.sendError(500, e.getMessage());
            } catch (IOException e1) {}
        }
    }

    private void processAssetRequest(String assetPath) {
        assetPath = assetPath.substring(6, assetPath.length());
        //String[] assetSplit = assetPath.split("\\;");
        String packageName = assetPath.substring(0, assetPath.lastIndexOf("/"));
        String assetName = assetPath.replace(packageName, "");

        String mimeType = context.getMimeType(assetName);
        response.setContentType(mimeType);

        boolean developmentMode = false;

        if (context.getAttribute("wheelDevelopmentMode") != null)
            developmentMode = true;

        int expires = 0;

        if (!developmentMode) {
            String expiresS = request.getParameter("expires");

            try {
                expires = Integer.parseInt(expiresS);
            } catch (NumberFormatException e) {
                log.warn("Could not get a valid expiration time for an asset. Recieved value was '" + expiresS + "'.");
            }

            if (expires > 0) {
                Calendar cal = new GregorianCalendar();
                response.setDateHeader("Date", cal.getTimeInMillis());

                cal.add(Calendar.HOUR_OF_DAY, expires);

                response.setDateHeader("Expires", cal.getTimeInMillis());
                response.setHeader("Cache-Control", "cache");
                response.setHeader("Pragma", "cache");
            }
        }

        Map<String,byte[]> assetCache = (Map<String,byte[]>)context.getAttribute("wheelAssetCache");

        if (assetCache == null)
            assetCache = new HashMap<String,byte[]>();

        InputStream is = null;

        try {
            if (assetCache.containsKey(assetPath)) {
                is = new ByteArrayInputStream(assetCache.get(assetPath));

                OutputStream out = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int read = is.read(buffer);

                while (read > 0) {
                    out.write(buffer, 0, read);
                    read = is.read(buffer);
                }

                out.flush();
                out.close();

            }
            else {
                is = resourceManager.loadAsset(packageName + assetName);

                if (!mimeType.equals("text/css")) {
                    ByteArrayOutputStream toCache = new ByteArrayOutputStream();
                    OutputStream out = response.getOutputStream();

                    byte[] buffer = new byte[4096];
                    int read = is.read(buffer);

                    while (read > 0) {
                        out.write(buffer, 0, read);
                        toCache.write(buffer, 0, read);
                        read = is.read(buffer);
                    }

                    out.flush();
                    out.close();

                    assetCache.put(assetPath, toCache.toByteArray());

                } else {
                    OutputStream out = new ByteArrayOutputStream();

                    byte[] buffer = new byte[4096];
                    int read = is.read(buffer);

                    while (read > 0) {
                        out.write(buffer, 0, read);
                        read = is.read(buffer);
                    }

                    String cssString = ((ByteArrayOutputStream)out).toString(encoding);
                    AssetProcessor assetProcessor = new AssetProcessor();
                    byte[] result = assetProcessor.replaceUrls(cssString,  request.getContextPath() + request.getServletPath() + "/asset/" + packageName, expires).getBytes();
                    assetCache.put(assetPath, result);
                    ByteArrayInputStream bin = new ByteArrayInputStream(result);

                    out = response.getOutputStream();

                    read = bin.read(buffer);

                    while (read > 0) {
                        out.write(buffer, 0, read);
                        read = bin.read(buffer);
                    }

                    out.flush();
                    out.close();
                }
            }

        } catch (Exception e) {
            log.error("Failed to load asset '" + assetPath + "'.", e);
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {}

            context.setAttribute("wheelAssetCache", assetCache);
        }
    }

    public HttpServletResponse getResponse() {
        return response;
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public String getCssPath() {
        if (developmentMode)
            return "asset/file/" + cssPath + "/";

        return request.getContextPath() + "/" + cssPath + "/";
    }

    public String getJsPath() {
        if (developmentMode)
            return "asset/file/" + jsPath + "/";

        return request.getContextPath() + "/" + jsPath + "/";
    }


    public ServletContext getContext() {
        return context;
    }

    public synchronized XmlSerializer _getXmlSerializer() throws XmlPullParserException, IOException {
        if (serializer == null) {
            if (out == null)
                out = response.getOutputStream();

            serializer = XmlPullParserFactory.newInstance().newSerializer();
            serializer.setOutput(out, encoding);
            serializer.setProperty("http://xmlpull.org/v1/doc/properties.html#serializer-indentation", "  ");
        }

        return serializer;
    }


    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


    public HttpSession getSession() {
        return session;
    }

    public IObjectStore getObjectStore() {
        if (objectStore == null)
            objectStore = new SessionStore(session);

        return objectStore;
    }

    public StandaloneComponent loadPage(String pagePath) {
        String className = "/" + pagePath;
        StandaloneComponent page = resourceManager.loadPage(basePackage + className.replace('/', '.'));

        if (unitTestMode)
            page.config()._setRenderDoctype(false);

        return page;
    }


    public void setError(Throwable error) {
        this.error = error;
    }

    public Throwable getError() {
        return error;
    }

    public void addErrorMapping(String exceptionClassName, String errorPageName) {
        if (errorMap == null)
            errorMap = new HashMap<String,String>();

        errorMap.put(exceptionClassName, errorPageName);
    }


    public StandaloneComponent getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(StandaloneComponent errorPage) {
        this.errorPage = errorPage;
    }


    public Locale getLocale() {
        return locale;
    }


    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public IMessagesSource _getMessagesSource() {
        return messagesSource;
    }

    public void _setMessagesSource(IMessagesSource messagesSource) {
        this.messagesSource = messagesSource;
    }

    protected Map readRequestParameters(HttpServletRequest request) {
        return request.getParameterMap();
    }

    public boolean isAjaxRequest() {
        return ajax;
    }

    private void evictPageScope(String pageName) {
        String previousPagename = (String)session.getAttribute("wheelPreviousPagename");

        if (previousPagename != null && !previousPagename.equals(pageName)) {
            SessionStore store = new SessionStore(session);
            store.evictPage(pageName);
        }

        session.setAttribute("wheelPreviousPagename", pageName);
    }

    public IResourceManager getResourceManager() {
        return resourceManager;
    }

    public StandaloneComponent getpage() {
        return page;
    }

    public WheelURL getWheelURL() {
        return wheelURL;
    }

    public void _addComponentType(String key, String type) {
        componentTypes.put(key, type);
    }
}

