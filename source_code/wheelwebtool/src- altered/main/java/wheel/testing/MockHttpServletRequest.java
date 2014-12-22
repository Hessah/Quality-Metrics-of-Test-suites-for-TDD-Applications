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
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.Principal;
import java.util.*;

public class MockHttpServletRequest implements HttpServletRequest {
    private HttpSession session;
    private Map<String, String[]> parameters = new HashMap<String, String[]>();
    private String pathInfo;
    private String contextName;
    private Map<String,Object> attributes = new HashMap<String,Object>();
    private String contentType = "text/html";
    private MockServletInputStream inputStream;
    private int contentLength;
    private String method = "GET";

    public MockHttpServletRequest() {
    }

    public String getAuthType() {
        return BASIC_AUTH;
    }

    public Cookie[] getCookies() {
        return new Cookie[0];
    }

    public long getDateHeader(String string) {
        return System.currentTimeMillis();
    }

    public String getHeader(String string) {
        return "";
    }

    public Enumeration getHeaders(String string) {
        return null;
    }

    public Enumeration getHeaderNames() {
        return null;
    }

    public int getIntHeader(String string) {
        return 0;
    }

    public String getMethod() {
        return method;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public String getPathTranslated() {
        return "";
    }

    public String getContextPath() {
        if (contextName != null)
            return contextName;

        return "";
    }

    public String getQueryString() {
        return "";
    }

    public String getRemoteUser() {
        return "";
    }

    public boolean isUserInRole(String string) {
        return false;
    }

    public Principal getUserPrincipal() {
        return null;
    }

    public String getRequestedSessionId() {
        return "";
    }

    public String getRequestURI() {
        return "";
    }

    public StringBuffer getRequestURL() {
        return null;
    }

    public String getServletPath() {
        return "/app";
    }

    public HttpSession getSession(boolean b) {
        return session;
    }

    public HttpSession getSession() {
        return session;
    }

    public boolean isRequestedSessionIdValid() {
        return true;
    }

    public boolean isRequestedSessionIdFromCookie() {
        return true;
    }

    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    public boolean isRequestedSessionIdFromUrl() {
        return false;
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

    public String getCharacterEncoding() {
        return "UTF-8";
    }

    public void setCharacterEncoding(String string) throws UnsupportedEncodingException {
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public ServletInputStream getInputStream() throws IOException {
        return inputStream;
    }

    public String getParameter(String string) {
        if (!parameters.containsKey(string))
            return null;

        return parameters.get(string)[0];
    }

    public Enumeration getParameterNames() {
        final Iterator keys = parameters.keySet().iterator();

        return new Enumeration() {
            public boolean hasMoreElements() {
                return keys.hasNext();
            }

            public Object nextElement() {
                return keys.next();
            }
        };
    }

    public String[] getParameterValues(String string) {
        return parameters.get(string);
    }

    public Map getParameterMap() {
        return parameters;
    }

    public String getProtocol() {
        return "http";
    }

    public String getScheme() {
        return "";
    }

    public String getServerName() {
        return "";
    }

    public int getServerPort() {
        return 8080;
    }

    public BufferedReader getReader() throws IOException {
        return null;
    }

    public String getRemoteAddr() {
        return "127.0.0.1";
    }

    public String getRemoteHost() {
        return "localhost";
    }

    public void setAttribute(String string, Object object) {
        attributes.put(string, object);
    }

    public void removeAttribute(String string) {
        attributes.remove(string);
    }

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public Enumeration getLocales() {
        return null;
    }

    public boolean isSecure() {
        return false;
    }

    public RequestDispatcher getRequestDispatcher(String string) {
        return null;
    }

    public String getRealPath(String string) {
        return "";
    }

    public int getRemotePort() {
        return 0;
    }

    public String getLocalName() {
        return "";
    }

    public String getLocalAddr() {
        return "";
    }

    public int getLocalPort() {
        return 0;
    }

    //non-api methods for testing purposes

    public void addParameter(String name, String value) {
        String[] values = parameters.get(name);

        if (values != null) {
            String[] newValues = new String[values.length + 1];

            for (int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }

            newValues[values.length] = value;
            parameters.put(name, newValues);
        }
        else
            parameters.put(name, new String[]{value});
    }

    public void setPathInfo(String pathInfo) {
        this.pathInfo = "/" + pathInfo;
    }

    public void reset() {
        parameters.clear();
        pathInfo = "";
        attributes.clear();
        contentType = "text/html";
        inputStream = null;
        contentLength = 0;
        method = "GET";
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public void setInputStream(ByteArrayInputStream in) {
        this.inputStream = new MockServletInputStream(in);
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private class MockServletInputStream extends ServletInputStream {
        static final byte CR = 0x0D;
        static final byte LF = 0x0A;
        
        ByteArrayInputStream in;

        private MockServletInputStream(ByteArrayInputStream in) {
            this.in = in;
        }

        public int read() throws IOException {
            return in.read();
        }

        @Override
        public int read(byte[] bytes) throws IOException {
            return in.read(bytes);
        }

        @Override
        public int read(byte[] bytes, int i, int i1) throws IOException {
            return in.read(bytes, i, i1); 
        }

        @Override
        public long skip(long l) throws IOException {
            return in.skip(l);
        }

        @Override
        public int available() throws IOException {
            return in.available();
        }

        @Override
        public void close() throws IOException {
            in.close();
        }

        @Override
        public synchronized void mark(int i) {
            in.mark(i);
        }

        @Override
        public synchronized void reset() throws IOException {
            in.reset();
        }

        @Override
        public boolean markSupported() {
            return in.markSupported();
        }

        @Override
        public int readLine(byte[] bytes, int i, int i1) throws IOException {
            return super.readLine(bytes, i, i1);    //To change body of overridden methods use File | Settings | File Templates.
        }
    }
}
