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

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class MockServletContext implements ServletContext {
    private Map<String,Object> attributes;
    private File resourceRoot;


    public MockServletContext() {
        attributes = new HashMap<String,Object>();
    }

    public String getContextPath() {
        return "mock";
    }

    public ServletContext getContext(String string) {
        return null;
    }

    public int getMajorVersion() {
        return 2;
    }

    public int getMinorVersion() {
        return 5;
    }

    public String getMimeType(String string) {
        if (string.endsWith(".css"))
            return "text/css";
        else if (string.endsWith(".js"))
            return "text/javascript";
        
        return "";
    }

    public Set getResourcePaths(String path) {
        Set result = new HashSet();

        if (resourceRoot != null) {
            File f = new File(resourceRoot.getAbsolutePath() + path);
            File[] files = f.listFiles();

            if (files == null)
                return result;

            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                if (file.isDirectory())
                    result.add(path + file.getName() + "/");
                else
                    result.add(path + file.getName());
            }
        }

        return result;
    }

    public URL getResource(String string) throws MalformedURLException {
        return new URL("emptyUrl");
    }

    public InputStream getResourceAsStream(String string) {
        return null;
    }

    public RequestDispatcher getRequestDispatcher(String string) {
        return null;
    }

    public RequestDispatcher getNamedDispatcher(String string) {
        return null;
    }

    public Servlet getServlet(String string) throws ServletException {
        return null;
    }

    public Enumeration getServlets() {
        return null;
    }

    public Enumeration getServletNames() {
        return null;
    }

    public void log(String string) {

    }

    public void log(Exception exception, String string) {

    }

    public void log(String string, Throwable throwable) {

    }

    public String getRealPath(String string) {
        return "";
    }

    public String getServerInfo() {
        return "";
    }

    public String getInitParameter(String string) {
        return "";
    }

    public Enumeration getInitParameterNames() {
        return null;
    }

    public Object getAttribute(String string) {
        return attributes.get(string);
    }

    public Enumeration getAttributeNames() {
        final Iterator keys = attributes.keySet().iterator();

        return new Enumeration() {
            public boolean hasMoreElements() {
                return keys.hasNext();
            }

            public Object nextElement() {
                return keys.next();
            }
        };
    }

    public void setAttribute(String string, Object object) {
        attributes.put(string, object);
    }

    public void removeAttribute(String string) {
        attributes.remove(string);
    }

    public String getServletContextName() {
        return "mock";
    }

    public void resetMock() {
        attributes.clear();
    }

    public void setResourceRoot(File resourceRoot) {
        this.resourceRoot = resourceRoot;
    }
}
