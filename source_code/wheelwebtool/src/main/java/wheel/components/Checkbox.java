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
 * Will render an &lt;input type="checkbox"/&gt; form element. A Checkbox must be bound to a boolean field.
 *
 * @author Henri Frilund
 */
public class Checkbox extends FormElement {

    Checkbox(Component parent, String elementName, String componentId) {
        super(parent, elementName, componentId);
        attribute("type", "checkbox");
    }

    public String defaultTagName() {
        return "input";
    }


    @Override
    public void renderComponent(XmlSerializer serializer) throws IOException {
        if (getBinding() instanceof ElExpression) {
            Boolean value = (Boolean) ((ElExpression)getBinding()).eval(_getTopLevelComponent(true), this);

            if (value != null && value.booleanValue()) {
                serializer.attribute("", "checked", "checked");

            }

            serializer.attribute("", "value", eval(getBinding()));
        }
        else {
            if (eval(getBinding()).equalsIgnoreCase("true"))
                serializer.attribute("", "checked", "checked");

            serializer.attribute("", "value", eval(getBinding()));
        }
        
        super.renderComponent(serializer);
    }

    @Override
    protected String defaultDomEvent() {
        return "onclick";
    }

    @Override
    public FormElement value(String value) {
        setBinding(value);
        return this;
    }
}
