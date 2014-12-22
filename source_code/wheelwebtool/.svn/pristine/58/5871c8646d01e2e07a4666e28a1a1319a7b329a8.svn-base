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

public class RenderableComponentConfiguration {
    private RenderableComponent forComponent;

    public RenderableComponentConfiguration(RenderableComponent forComponent) {
        this.forComponent = forComponent;
    }

     /**
     * Returns true if this component should render its componentId as id-attribute in the xhtml-code.
     * @return
     */
    public boolean isRenderId() {
        return forComponent.renderId;
    }

    /**
     * Calling this method with false is useful when you want to suppress id-attribute for a single component.
     * @param renderId
     */
    public RenderableComponentConfiguration setRenderId(boolean renderId) {
        forComponent.renderId = renderId;
        return this;
    }


    /**
     * Returns true if this component should render its opening and closing tags. Setting renderSelf to false doesn't
     * stop it from rendering its content.
     * @return
     */
    public boolean isRenderSelf() {
        return forComponent.renderSelf;
    }

    /**
     * @see this#isRenderSelf()
     * @param renderSelf
     */
    public RenderableComponentConfiguration setRenderSelf(boolean renderSelf) {
        forComponent.renderSelf = renderSelf;
        return this;
    }

    /**
     * Returns true if the component is using xhtml-mode. Xhtml-mode means that all rendering hints that match any xhtml-tags, will
     * be interpreted as the desired tagname and all others as values for the class-attribute. In non-xhtml mode only the first rendering hint
     * will be used and it will determine the tagname.
     * @return
     */
    public boolean isUseXhtml() {
        return forComponent.useXhtml;
    }

    /**
     * Sets the xhtml-mode. By default xhtml-mode is always on, but if you want to disable it to output xml instead of xhtml, call
     * setUseXhtml(false). This setting is inheritable. It means that all components you add to this component, will also be in non-xhtml mode.
     * @param useXhtml
     */
    public RenderableComponentConfiguration setUseXhtml(boolean useXhtml) {
        forComponent.useXhtml = useXhtml;
        forComponent.renderId = false;
        return this;
    }

    //TODO document me
    public boolean isVisible() {
        return forComponent.visible;
    }

    public RenderableComponentConfiguration setVisible(boolean visible) {
        forComponent.visible = visible;
        return this;
    }
}
