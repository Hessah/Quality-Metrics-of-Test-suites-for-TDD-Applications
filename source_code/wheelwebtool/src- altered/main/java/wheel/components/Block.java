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
 * Block is an all-purpose component that is used whenever you need a component that holds other (html) components.
 * By default will render itself as a &lt;div&gt; tag.
 *
 * @author Henri Frilund
 */
public class Block extends RenderableComponent implements IContainer {
    Block(Component parent) {
        super(parent);
    }

    Block(Component parent, String componentId) {
        super(parent, componentId);
    }

    public String defaultTagName() {
        return "div";
    }


    @Override
    public void _render(XmlSerializer serializer) throws IOException {
        if (_getRenderableChildren().size() == 0 && renderSelf) {
            String tagName = _renderTagStart(serializer);
            serializer.text(" ");
            serializer.endTag("", tagName);
            return;
        }

        if (renderSelf)
            super._render(serializer);
        else {
            for (RenderableComponent renderable : _getRenderableChildren()) {
                renderable._render(serializer);
            }
        }
    }


    @Override
    public Block id(String componentId) {
        return (Block)super.id(componentId);
    }


    @Override
    public Block renderHint(CharSequence renderHint) {
        return (Block)super.renderHint(renderHint);
    }
}
