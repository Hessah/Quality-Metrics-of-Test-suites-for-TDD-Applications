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

import java.util.LinkedList;
import java.util.List;
import java.util.Collection;

/**
 * CheckboxGroup makes it possible to select objects with checkboxes from an ISelectModel. This component will render
 * one checkbox for each object in the ISelectModel. The behaviour is otherwise the same as with a Select-component in multiselect mode, ie.
 * you can select more than one object.
 *
 * @author Henri Frilund
 */
public class CheckboxGroup extends SelectModelFormElement {

    CheckboxGroup(Component parent, String elementName, String componentId, ISelectModel model, ElExpression binding) {
        super(parent, elementName, componentId, model, binding);
        this.model = model;
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
            FormElement checkbox = checkbox(getFormElementName()).value(model.getValue(i));

            checkbox.getAttributes().remove("checked");

            if (_getActions() != null) {
                for (ActionExpression action : _getActions()) {
                    checkbox.actionBinding(action);
                }
            }

            Object value = model.translateValue(model.getValue(i));

            boolean selected = false;

            if (boundObject instanceof Collection) {
                Collection collection = (Collection)boundObject;
                if (collection.contains(value)) {
                    selected = true;
                    checkbox.attribute("checked", "checked");
                }
            }
            else {
                if (value.equals(boundObject)) {
                    selected = true;
                    checkbox.attribute("checked", "checked");
                }
            }

            if (!enhance(checkbox, selected, i)) {
                checkbox.addRenderAfter(create().wLabel("span", model.getLabel(i)));

                if (i < (model.getOptionCount() - 1))
                    checkbox.addRenderAfter(create().wAny("br"));
            }
        }
    }

    @Override
    public void _setSubmitValue(String[] formValues) {
        this.value = formValues;

        validate();

        if (isValid()) {
            if (getBinding() instanceof ElExpression) {
                List boundObjects = new LinkedList();

                for (int i = 0; i < this.value.length; i++) {
                    String formValue = this.value[i];
                    boundObjects.add(model.translateValue(formValue));
                }

                ((ElExpression)getBinding()).store(_getTopLevelComponent(true), this, boundObjects);
            }
        }
    }
}
