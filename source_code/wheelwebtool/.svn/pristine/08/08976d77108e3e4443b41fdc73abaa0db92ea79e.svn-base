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

/**
 * This interface makes it possible to add additional components before and after the generated input element.
 * Useful with CheckboxGroup and RadioGroup when you want to customize the way the form input elements are created.
 *
 * @author Henri Frilund
 */
public interface IEnhancingSelectModel extends ISelectModel {
    /**
     * A callback method that is called to enable adding components that will be rendered before the input element.
     * To create a component that will be rendered before or after the input element, use component.addRenderAfter(create().XXX());. <br/>
     *
     * Example:<br/>
     * <pre>
     * public void renderBefore(RenderableComponent component, int index, boolean selected) {
     *      component.addRenderBefore(create().h4("select me"));
     *      component.renderHint("myClass");
     *      return true;
     * }
     * </pre>
     *
     * @param component The input element that was genereated based on the ISelectModel
     * @param index At what index are we at
     * @param selected Is this the selected element
     * @return True if the component was enhanced.
     */
    public boolean enhanceComponent(RenderableComponent component, int index, boolean selected);
}
