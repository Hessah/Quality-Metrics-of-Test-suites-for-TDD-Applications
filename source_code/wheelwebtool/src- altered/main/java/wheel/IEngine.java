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

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import wheel.components.StandaloneComponent;
import wheel.persistence.IObjectStore;
import wheel.util.WheelURL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;
import java.util.Calendar;

/**
 * An implementation of this interface handles the request-cycle.
 * <ol>
 *  <li>Request is recieved.</li>
 *  <li>A new instance of IEngine-implementation is created.</li>
 *  <li>Request, response, context, session etc. are set to the instance.</li>
 *  <li>processRequest() is called.</li>
 * </ol>
 * @author Henri Frilund
 */
public interface IEngine {
    /**
     * Intended for internal use.
     * @return An Xpp3 serializer for rendering output.
     * @throws XmlPullParserException
     * @throws IOException
     */
    public XmlSerializer _getXmlSerializer() throws XmlPullParserException, IOException;

    /**
     * The ServletContext instance.
     * @return
     */
    public ServletContext getContext();

    /**
     * The active HttpSerlvetRequest for this request.
     * @return
     */
    public HttpServletRequest getRequest();

    /**
     * The active HttpServletResponse for this request.
     * @return
     */
    public HttpServletResponse getResponse();

    /**
     * Intended for internal use.
     * @return
     */
    public Set _getAvailableCssFiles();

    /**
     * Intended for internal use.
     * @return
     */
    public Set _getAvailableJsFiles();

    /**
     * The encoding used during this request cycle for all output as well as URL encoding. Value encoding is UTF-8.
     * @return
     */
    public String getEncoding();

    /**
     * Sets the encoding to use during this request cycle.
     * @param encoding
     */
    public void setEncoding(String encoding);

    public HttpSession getSession();

    /**
     * Calling this method will start the request handling process. Typically this method is called from a Servlet.
     */
    public void processRequest();

    /**
     * Gives access to the internal object store that is used with automatic persistence.
     * @return An IObjectStore implementation.
     */
    public IObjectStore getObjectStore();

    /**
     * The base package name for page loading. Example: com.foo.bar.pages (pagename FrontPage from URL will be translated to com.foo.bar.pages.FrontPage).
     * @return
     */
    public String getBasePackage();

    /**
     * Server root-based path to css-files. Example: /contextname/css/
     * @return
     */
    public String getCssPath();

    /**
     * Server root-based path to js-files. Example: /contextname/js/
     * @return
     */
    public String getJsPath();

    /**
     * Sets the error that will be accessible to an error page.
     * @param error
     */
    public void setError(Throwable error);

    /**
     * Active error for this request process cycle.
     * @return
     */
    public Throwable getError();

    /**
     *
     * @return Locale for this request cycle. By default will delegate to HttpServletRequest.getLocale();
     */
    public Locale getLocale();

    /**
     * Sets the Locale for this request cycle. Note that this setting is not persistent and will have to be set for every request separately.
     * @param locale
     */
    public void setLocale(Locale locale);

    /**
     * Intended for internal use.
     * @return Returns an implementation of IMessageSource.
     */
    public IMessagesSource _getMessagesSource();

    /**
     * Intended for internal use. Sets the used IMessageSource implementation.
     * @param messagesSource
     */
    public void _setMessagesSource(IMessagesSource messagesSource);

    /**
     * This method can be used to load Page-classes when the page path is known. Useful for example when you need to return a Page from an action
     * method, ie. forward internally to another page. Will delegate the loading to IPageLoader.
     * @param pagePath The path to wanted page in the URL-format, ie. stripped of basePackageForPages. Example: "FrontPage" or "admin/TestPage".
     * @return An instance of the desired Page-class with this IEngine-instance attached.
     * @throws WheelException if loading the page fails.
     */
    public StandaloneComponent loadPage(String pagePath);


    /**
     * The error page to render if an exception is caugth.
     * @return
     */
    public StandaloneComponent getErrorPage();

    /**
     * Sets the page to render if an exception is caught.
     * @param errorPage
     */
    public void setErrorPage(StandaloneComponent errorPage);

    /**
     * Adds a mapping that will map exception classnames to page names.
     * Example: addErrorMapping("java.io.IOException", "MyErrorPage"); would cause MyErrorPage to be rendered whenever an IOException is thrown.
     * @param exceptionClassName The full classname of the mapped exception.
     * @param errorPageName Name of the page to render.
     */
    public void addErrorMapping(String exceptionClassName, String errorPageName);

    //TODO
    public boolean isAjaxRequest();

    //TODO
    public IResourceManager getResourceManager();

    public StandaloneComponent getpage();

    public WheelURL getWheelURL();

    public void _addComponentType(String key, String type);

}
