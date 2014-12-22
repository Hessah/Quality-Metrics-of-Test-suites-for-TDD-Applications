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
package wheel.util;

import wheel.WheelException;
import wheel.components.Component;
import wheel.components.ElExpression;
import wheel.components.ISelectModel;
import wheel.components.StandaloneComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

//TODO documentation
public class DynamicSelectModel implements ISelectModel {
    private Component component;
    private StandaloneComponent topLevelComponent;
    private ElExpression label;
    private ElExpression value;
    private ElExpression collection;
    private ElExpression translator;
    private Collection objects;
    private Object emptyObject;

    public DynamicSelectModel(ElExpression collection, ElExpression label, ElExpression value) {
        validate();

        this.label = label;
        this.value = value;
        this.collection = collection;
    }

    public DynamicSelectModel() {
    }

    public DynamicSelectModel collection(String collection) {
        this.collection = new ElExpression(collection);
        return this;
    }

    public DynamicSelectModel label(String label) {
        this.label = new ElExpression(label);
        return this;
    }

    public DynamicSelectModel value(String value) {
        this.value = new ElExpression(value);
        return this;
    }

    public DynamicSelectModel enumeration(String enumeration) {
        this.collection = new ElExpression(enumeration + ".values()");
        this.label = new ElExpression("toString()");
        this.value = new ElExpression("ordinal()");

        return this;
    }

    public DynamicSelectModel translator(String translator) {
        this.translator = new ElExpression(translator);
        return this;
    }

    public DynamicSelectModel empty(Object o) {
        this.emptyObject = o;
        return this;
    }


    public int getOptionCount() {
        return getObjects().size();
    }

    public String getLabel(int index) {
        label.errorMessage("Could not evaluate expression " + label.getExpression() + " to create a label for dynamic ISelectModel. Index was " + index);
        Object obj = label.eval(getObjects().toArray()[index], component);
        return obj.toString();
    }

    public String getValue(int index) {
        value.errorMessage("Could not evaluate expression " + value + " to create a value for dynamic ISelectModel. Index was " + index);
        Object obj = value.eval(getObjects().toArray()[index], component);
        return obj.toString();
    }

    public Object translateValue(String value) {
        Object[] array = getObjects().toArray();
        for (int i = 0; i < array.length; i++) {
            String compareTo = getValue(i);

            if (compareTo.equals(value)) {
                if (translator != null) {
                    translator.errorMessage("Could not evaluate expression " + translator + " to translate value ' " + value + "'");
                    return translator.eval(array[i], component);
                }
                else
                    return array[i];
            }
        }

        return null;
    }

    public Collection getObjects() {
        if (objects != null)
            return objects;

        collection.errorMessage("Could not evaluate expression " + collection + " to create a dynamic ISelectModel.");
        Object obj = collection.eval(topLevelComponent, component);

        if (obj == null)
            throw new WheelException("Expression " + collection + " evaluated to null. Can't build a dynamic ISelectModel", component);

        if (obj instanceof Collection)
            objects = (Collection)obj;
        else if (obj instanceof Object[]) {
            Object[] array = (Object[])obj;
            Collection col = new ArrayList();
            for (int i = 0; i < array.length; i++) {
                col.add(array[i]);
            }

            objects = col;
        }
        else
            throw new WheelException("Expression " + collection + " evaluated to an object that is not an instance of Collection or Object[]. Can't build a dynamic ISelectModel", component);

        if (emptyObject != null) {
            Collection newCollection = new LinkedList();
            newCollection.add(emptyObject);
            newCollection.addAll(objects);
            objects = newCollection;
        }
        
        return objects;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public StandaloneComponent getTopLevelComponent() {
        return topLevelComponent;
    }

    public void setTopLevelComponent(StandaloneComponent topLevelComponent) {
        this.topLevelComponent = topLevelComponent;
    }

    public void validate() {
        if (collection == null)
            throw new WheelException("Could not create DynamicSelection model. Collection attribute was null or not an el-expression.", null);

        if (label == null)
            throw new WheelException("Could not create DynamicSelection model. Label attribute was null or not an el-expression.", null);

        if (value == null)
            throw new WheelException("Could not create DynamicSelection model. Value attribute was null or not an el-expression.", null);

    }

    public void reset() {
        objects = null;
    }
}
