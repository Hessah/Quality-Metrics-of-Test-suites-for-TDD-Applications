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
 * Renders an &lt;img/&gt; tag.
 * The source can be a full url or then a file path relative to the web app root.
 * @author Henri Frilund
 */
public class Image extends RenderableComponent {
    private String source;
    private String alt;


    Image(Component parent, CharSequence source, CharSequence alt) {
        super(parent);
        this.source = eval(source);
        this.alt = eval(alt);
    }

    public String defaultTagName() {
        return "img";
    }


    @Override
    public void renderComponent(XmlSerializer serializer) throws IOException {
        serializer.attribute("", "alt", alt);

        if (source.indexOf("://") != -1) {
            serializer.attribute("", "src", source);
            return;
        }

        if (_getTopLevelComponent(false).reusable) {
            String className = _getTopLevelComponent(true).getClass().getName();
            serializer.attribute("", "src", "asset/" + className.substring(0, className.lastIndexOf(".")).replace('.', '/') + "/" + removePathFromSource());
        }

        else {
            serializer.attribute("", "src", getEngine().getRequest().getContextPath() + "/" +  source);
        }
    }

    private String removePathFromSource() {
        if (source.indexOf('/') == -1)
            return source;

        return source.substring(source.lastIndexOf("/") + 1, source.length());
    }
}