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

/**
 * A form element that makes it possible to choose a single object or multiple objects (using multiselect mode) from a collection of objects using the &lt;select&gt; element.
 * This component can be build either using an ISelectModel, DynamicSelectModel (by providing el-expressions for the collection, label and value) or
 * a custom IEnhancingSelectModel that lets you customize how the options are rendered.
 *
 * @author Henri Frilund
 */
public class Select extends SelectModelFormElement {
    private boolean multiSelect;

    Select(Component parent, String elementName, String componentId, ISelectModel model, CharSequence binding) {
        super(parent, elementName, componentId, model, binding);
    }

    Select(Component parent, String elementName, String componentId, CharSequence binding, ISelectModel model, boolean multiSelect) {
        super(parent, elementName, componentId, model, binding);
        this.multiSelect = multiSelect;
    }

    public final String defaultTagName() {
        return "select";
    }

    @Override
    public void _setSubmitValue(String[] formValues) {
        this.value = formValues;

        validate();

        if (isValid()) {
            if (getBinding() instanceof ElExpression) {
                ElExpression el = (ElExpression)getBinding();

                if (!multiSelect)
                    el.store(_getTopLevelComponent(true), this, model.translateValue(formValues[0]));
                else {
                    List boundObjects = new LinkedList();

                    for (int i = 0; i < formValues.length; i++) {
                        String formValue = formValues[i];
                        boundObjects.add(model.translateValue(formValue));
                    }

                    el.store(_getTopLevelComponent(true), this, boundObjects);
                }
            }
        }
    }

    public void buildComponent() {
        _getChildren().clear();
        
        if (multiSelect)
            attribute("multiple", "multiple");

        Object boundObject = getBinding();

        if (getBinding() instanceof ElExpression) {
            ElExpression el = (ElExpression)getBinding();
            el.errorMessage("Couldn't read value with binding " + getBinding() + " in class " + _getTopLevelComponent(true).getClass().getName());
            boundObject = el.eval(_getTopLevelComponent(true), this);
        }
        for (int i=0; i < model.getOptionCount(); i++) {
            Label option = create().wLabel("option", model.getLabel(i));

            Object value = model.translateValue(model.getValue(i));

            boolean selected = false;

            if (value.equals(boundObject)) {
                selected = true;
                option.attribute("selected", "true");
            }

            option.attribute("value", model.getValue(i));

            enhance(option, selected, i);

            add(option);
        }
    }

    protected String defaultDomEvent() {
        return "onselect";
    }
}
