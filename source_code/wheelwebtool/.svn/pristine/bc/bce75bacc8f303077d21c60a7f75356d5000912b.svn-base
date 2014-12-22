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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Label is a component that is used whenever you need to output text. By default will render the text inside a &lt;span&gt tags.
 * Component-class provides many shortcuts to this component. In cases where a shorthand method is not available, Label can be
 * used to represent any html-tag that contains only text.
 *
 * @author Henri Frilund
 */
public class Label extends RenderableComponent implements IContainer {
    private static Pattern entityMatcher;
    private CharSequence text;

    public Label(Component parent, Object text) {
        super(parent);
        this.text = eval(text);
    }

    public String defaultTagName() {
        return "span";
    }

    @Override
    public void renderComponent(XmlSerializer serializer) throws IOException {
        if (text != null) {
            text = eval(text);

            handleEntities(text.toString(), serializer);
        }

        for (RenderableComponent renderableComponent : _getRenderableChildren()) {
            renderableComponent._render(serializer);
        }
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void handleEntities(String text, XmlSerializer serializer) throws IOException {
        if (text.contains("&") && getPage().renderDoctype) {
            if (entityMatcher == null)
                entityMatcher = Pattern.compile("(\\&\\w+;)");

            Matcher matcher = entityMatcher.matcher(text);
            int textPos = 0;

            while (matcher.find()) {
                String entity = matcher.group(1);
                int matchPos = matcher.start();
                String precedingText = text.substring(textPos, matchPos);
                textPos += precedingText.length() + entity.length();

                if (precedingText.length() > 0)
                    serializer.text(precedingText);

                serializer.entityRef(entity.substring(1, entity.length()-1));
            }

            if (textPos < text.length())
                serializer.text(text.substring(textPos, text.length()));
        }
        else {
            serializer.text(text);
        }
    }
}
