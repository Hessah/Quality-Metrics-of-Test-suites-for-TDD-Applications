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
package wheel.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.w3c.dom.Document;
import wheel.WheelServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WheelFunctionalTestCase {
    private static MockServletContext context;
    private static MockHttpServletResponse response;
    private static MockHttpServletRequest request;
    private static WheelServlet servlet;
    private static String basePackageForPages;
    private static String[] applicationPackages;
    private static boolean initialized;
    private static Document result;
    private static XPath xpath = XPathFactory.newInstance().newXPath();
    private static Map<String, MockHttpSession> users = new HashMap<String, MockHttpSession>();
    private static File resourceRoot;
    private static String contextName;
    private static MockForm form;


    protected static void initialize() {
        if (initialized) {
            response.resetMock();
            result = null;
            return;
        }

        if (basePackageForPages == null || basePackageForPages.length() == 0)
            throw new IllegalStateException("Call setBasePackageForPages() first.");

        if (applicationPackages == null || applicationPackages.length == 0)
            throw new IllegalStateException("Call setApplicationPackages() first.");

        context = new MockServletContext();
        context.setAttribute("wheelUnitTestMode", "");

        if (resourceRoot != null)
            context.setResourceRoot(resourceRoot);

        users.put("default user", new MockHttpSession(context));
        response = new MockHttpServletResponse();
        request = new MockHttpServletRequest();

        if (contextName != null)
            request.setContextName(contextName);

        servlet = new WheelServlet();

        try {
            servlet.init(new ServletConfig() {
                public String getServletName() {return null;}

                public ServletContext getServletContext() {
                    return context;
                }

                public String getInitParameter(String s) {
                    if (s.equals("basePackageForPages"))
                        return basePackageForPages;
                    else if (s.equals("applicationPackages")) {
                        StringBuffer sb = new StringBuffer();

                        for (int i = 0; i < applicationPackages.length; i++) {
                            String applicationPackage = applicationPackages[i];

                            sb.append(applicationPackage);

                            if (i < applicationPackages.length-1)
                                sb.append(",");
                        }
                        return sb.toString();
                    }
                    else
                        return null;
                }

                public Enumeration getInitParameterNames() {return null;}
            });
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        initialized = true;
    }

    public static void setBasePackageForPages(String base) {
        basePackageForPages = base;
    }

    public static void setApplicationPackages(String...packages) {
        applicationPackages = packages;
    }

    protected static void load(String url) {
        loadAsUser(url, "default user");
    }

    protected static void loadAsUser(String url, String user) {
        response.resetMock();
        request.setSession(users.get(user));
        request.setPathInfo(url);

        if (form != null) {
            request.addParameter("wheelSubmitId", form.getId());
            for (String name : form.getValues().keySet()) {
                String[] value = form.getValue(name);

                for (int i = 0; i < value.length; i++) {
                    String s = value[i];
                    request.addParameter(name, s);
                }
            }
        }

        try {
            servlet.doGet(request, response);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            request.reset();

            if (form != null)
                form.getValues().clear();
        }
    }

    protected static void load(String url, Object...params) {
        loadAsUser(url, "default user", params);
    }

    protected static void loadAsUser(String url, String user, Object...params) {
        response.resetMock();
        request.setSession(users.get(user));
        request.setPathInfo(url);

        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            try {
                request.addParameter(i + "", URLEncoder.encode(param.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        if (form != null) {
            request.addParameter("wheelSubmitId", form.getId());
            for (String name : form.getValues().keySet()) {
                String[] value = form.getValue(name);

                for (int i = 0; i < value.length; i++) {
                    String s = value[i];
                    request.addParameter(name, s);
                }
            }
        }

        try {
            servlet.doGet(request, response);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            request.reset();

            if (form != null)
                form.getValues().clear();
        }
    }

    protected static void addParameter(String name, Object value) {
        request.addParameter(name, value.toString());
    }


    /**
     * Enables to make Xpath-based assertions on the html-code created when the component was rendered with a call to render() method.
     * @param expectedValue Expected result of the xpath-expression.
     * @param xpathExpression A valid Xpath-expression
     */
    protected void assertXpath(String expectedValue, String xpathExpression) {
        try {
            xpath.reset();
            result = response.getResponseAsDocument();
            assertEquals(expectedValue, xpath.evaluate(xpathExpression, result.getDocumentElement()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks that an element is present in the output html.
     * @param xpathExpression A valid Xpath-expression
     */
    protected void assertPresent(String xpathExpression) {
        try {
            xpath.reset();
            result = response.getResponseAsDocument();
            assertNotNull(xpath.evaluate(xpathExpression, result.getDocumentElement()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    protected static MockServletContext getContext() {
        return context;
    }

    protected static void createUser(String name) {
        users.put(name, new MockHttpSession(context));
    }

    protected static void reset() {
        for (Iterator iterator = users.keySet().iterator(); iterator.hasNext();) {
            MockHttpSession session = (MockHttpSession) users.get(iterator.next());
            session.resetMock();
        }

        if (request != null)
            request.reset();

        if (response != null)
            response.resetMock();

        form = null;
    }

    protected void resetUser(String name) {
        users.get(name).resetMock();
    }

    protected void killUser(String name) {
        users.remove(name);
    }

    protected static void resetAll() {
        reset();

        if (context != null)
            context.resetMock();

        if (response != null)
            response.resetMock();

        initialized = false;
        resourceRoot = null;
        contextName = null;
        form = null;
    }

    protected static void setResourceRoot(File root) {
        resourceRoot = root;
    }

    protected static String getResponseAsString() {
        return response.getResponseAsString();
    }

    protected static void setContextName(String name) {
        contextName = name;
    }

    protected static void createForm(String id) {
        form = new MockForm(id);
    }

    protected static void addFormField(String name, String value) {
        if (form == null)
            throw new RuntimeException("No form available. Call createForm() first.");

        form.addField(name, value);
    }

    protected static MockHttpServletResponse getMockResponse() {
        return response;
    }

    protected static void createFileUpload(ByteArrayInputStream stream, int contentLength, String boundary) {
        request.setContentType("multipart/form-data; boundary=" + boundary);
        request.setInputStream(stream);
        request.setContentLength(contentLength);
        request.setMethod("POST");
    }
}
