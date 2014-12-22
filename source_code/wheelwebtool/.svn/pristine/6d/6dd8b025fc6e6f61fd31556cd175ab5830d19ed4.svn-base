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
package wheel.components;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * Represents a link either to another page inside the application or to an external URL.
 * Examples of valid links:<br/>
 * <ol>
 *  <li><pre>link("FrontPage", "Take me to frontpage");</pre> - will finnd a Page class named FrontPage from the basePackageForPages.</li>
 *  <li><pre>link("FrontPage?field1=hello&field2=34", "Take me to frontpage");</pre> - Same as above but will try to set given parameters to the page-class if fields with
 *  thoe names exists. Note that basic type translation works.</li>
 *  <li><pre>link("http://www.dilber.com", "Take me to Dilbert");</pre></li>
 *  <li><pre>link("FrontPage.myMethod()", "Call myMethod");</pre> - Loads FrontPage, builds it and calls myMethod().</li>
 *  <li><pre>link("this.onAction()", "Show some action");</pre> - Calls the onAction() method on the current page.</li>
 *  <li><pre>link("this.onAction('parameter1')", "Show more action");</pre> - Calls onAction-method that takes a String-parameter and passes given value.</li>
 *  <li><pre>link("FrontPage:myComponent.foobar()", "Whoa");</pre> - Loads FrontPage, builds the page, finds a complex component with id "myComponent" and calls foobar() method on it.</li>
 * </ol>
 *
 * @author Henri Frilund
 */
public class Link extends RenderableComponent implements IContainer {
    private CharSequence text;

    Link(Component parent, Object text) {
        super(parent);
        if (text == null)
            this.text = "";
        else
            this.text = eval(text);
    }

    public String defaultTagName() {
        return "a";
    }

    public void renderComponent(XmlSerializer serializer) throws IOException {
        if (text != null && text.length() > 0)
            serializer.text(text.toString());

        else {
            for (RenderableComponent renderable : _getRenderableChildren()) {
                renderable._render(serializer);
            }
        }
    }

    public void _renderActions(XmlSerializer serializer) throws IOException {
        ActionExpression action = _getAction();

        if (action == null)
            return;
        
        if (action.isExternalUrl()) {
            serializer.attribute("", "href", action.getActionExpression());
            return;
        }

        if (action.getUpdateTargetId() != null) {
            serializer.attribute("", "href", "#");
            serializer.attribute("", action.getEvent(), action.getUpdateComponentFunctionCall() + "return false;");
        }
        else {
            if (action.getJavascript() != null)
                serializer.attribute("", "href", "javascript:" + action.getActionExpression());
            else
                serializer.attribute("", "href", action.getActionUrl());
        }
    }
}
