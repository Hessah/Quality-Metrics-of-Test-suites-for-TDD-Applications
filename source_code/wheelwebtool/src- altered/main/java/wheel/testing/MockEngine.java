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

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import wheel.AbstractEngine;
import wheel.IMessagesSource;
import wheel.MessageSourceResourceBundleImpl;
import wheel.IResourceManager;
import wheel.util.WheelURL;
import wheel.components.StandaloneComponent;
import wheel.persistence.IObjectStore;
import wheel.persistence.SessionStore;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MockEngine extends AbstractEngine {
    private XmlSerializer serializer;
    private HttpSession session;
    private ServletContext context;
    private IObjectStore objectStore;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private IMessagesSource messagesSource;
    private Throwable error;
    private Locale locale;
    private DateFormat dateFormat;
    private String basePackage;

    public MockEngine() throws XmlPullParserException, IOException {
        response = new MockHttpServletResponse();
        serializer = XmlPullParserFactory.newInstance().newSerializer();
        serializer.setOutput(response.getOutputStream(), getEncoding());
        context = new MockServletContext();
        session = new MockHttpSession(context);
        objectStore = new SessionStore(session);
        request = new MockHttpServletRequest();
        request.setSession(session);
        messagesSource = new MessageSourceResourceBundleImpl();

    }

    public XmlSerializer _getXmlSerializer() throws XmlPullParserException, IOException {
        return serializer;
    }

    public ServletContext getContext() {
        return context;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Set _getAvailableCssFiles() {
        return new HashSet();
    }

    public Set _getAvailableJsFiles() {
        return new HashSet();
    }

    public String getEncoding() {
        return "UTF-8";
    }

    public void setEncoding(String encoding) {

    }

    public HttpSession getSession() {
        return session;
    }

    public void processRequestInternal() {}


    public IObjectStore getObjectStore() {
        return objectStore;
    }


    public String getBasePackage() {
        return basePackage;
    }

    public String getCssPath() {
        return "";
    }

    public String getJsPath() {
        return "";
    }

    public Document getDocument() throws IOException, SAXException {
        return response.getResponseAsDocument();
    }

    public void reset() throws IOException, XmlPullParserException {
        response.resetMock();
        serializer = XmlPullParserFactory.newInstance().newSerializer();
        serializer.setOutput(response.getOutputStream(), getEncoding());
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public Throwable getError() {
        return error;
    }


    public Locale getLocale() {
        if (locale == null)
            return Locale.getDefault();
        
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


    public StandaloneComponent loadPage(String pagePath) {
        return null;
    }


    public DateFormat _getDateFormat() {
        return dateFormat;
    }

    public void _setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }


    public StandaloneComponent getErrorPage() {
        return null;
    }

    public void setErrorPage(StandaloneComponent errorPage) {

    }

    public void addErrorMapping(String exceptionClassName, String errorPageName) {
        
    }

    public void setBasePackageForPages(String basePackageForPages) {
        this.basePackage = basePackageForPages;
    }

    protected Map readRequestParameters(HttpServletRequest request) {
        return null;
    }

    public boolean isAjaxRequest() {
        return false;
    }

    //TODO
    public IResourceManager getResourceManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public StandaloneComponent getpage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public WheelURL getWheelURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void _addComponentType(String key, String type) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}


