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

import java.util.List;
import java.util.LinkedList;

/**
 * A form element that makes it possible to choose a single object from a collection of objects using radio buttons.
 * This component can be build either using an ISelectModel, DynamicSelectModel (by providing el-expressions for the collection, label and value) or
 * a custom IEnhancingSelectModel that lets you customize how the radio buttons are rendered.
 * By default when not using IEnhancingSelectModel, this component will render an &lt;input type="radio"/&gt; for each object in the collection,
 * followed by &lt;span&gt;[object label]&lt;/span&gt;.
 *
 * @author Henri Frilund
 */
public class RadioGroup extends SelectModelFormElement {

    RadioGroup(Component parent, String elementName, String componentId, ISelectModel model, ElExpression binding) {
        super(parent, elementName, componentId, model, binding);
    }

    public String defaultTagName() {
        return "input";
    }

    public void buildComponent() {
        _getChildren().clear();

        renderSelf = false;

        Object boundObject = getBinding();

        if (getBinding() instanceof ElExpression) {
            ElExpression el = (ElExpression)getBinding();
            el.errorMessage("Couldn't read value with binding " + getBinding() + " in class " + _getTopLevelComponent(true).getClass().getName());
            boundObject = el.eval(_getTopLevelComponent(true), this);
        }

        for (int i=0; i < model.getOptionCount(); i++) {
            FormElement radio = radio(getFormElementName()).value(model.getValue(i));

            radio.getAttributes().remove("checked");

            if (_getActions() != null) {
                for (ActionExpression action : _getActions()) {
                    radio.actionBinding(action);
                }
            }

            Object value = model.translateValue(model.getValue(i));

            boolean selected = false;

            if (value.equals(boundObject)) {
                selected = true;
                radio.attribute("checked", "checked");
            }

            if (!enhance(radio, selected, i)) {
                radio.addRenderAfter(create().span(model.getLabel(i)));

                if (i < (model.getOptionCount() - 1))
                    radio.addRenderAfter(create().br());
            }
        }
    }

    @Override
    public void _setSubmitValue(String[] formValues) {
        this.value = formValues;

        validate();

        if (isValid()) {
            if (getBinding() instanceof ElExpression) {
                ElExpression el = (ElExpression)getBinding();

                el.store(_getTopLevelComponent(true), this, model.translateValue(this.value[0]));
            }
        }
    }
}
