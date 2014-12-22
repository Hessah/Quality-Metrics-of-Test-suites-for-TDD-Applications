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

import java.util.Collection;

/**
 * Same as IPropertySelectionModel in Tapestry 4.x. Implementations of this interface are used to create html-presentable
 * ways to select one (or many) objects from a collection of objects. How this works: <br/>
 *
 * First the ISelectModel is used to render a set of &lt;option&gt; tags. (pseudo code)<br/>
 * <pre>
 * for (int i=0; i < selectModel.getOptioncount(); i++) {
 *      &lt;option value="selectModel.getValue(i)"&gt;selectModel.getLabel(i)&lt;/option&gt;
 * }
 * </pre>
 *
 * When a form is submitted with the value from the selected option tag, its then translated to the selected object with
 * a call to translateValue(valueFromFormSubmit);
 *
 * @author Henri Frilund
 */
public interface ISelectModel {
    /**
     * Returns the total number of objects.
     * @return
     */
    public int getOptionCount();

    /**
     * Returns the label to use in the html-presentation for a given index.
     * @param index
     * @return
     */
    public String getLabel(int index);

    /**
     * Returns the String value that identifies the object in a html form.
     * @param index
     * @return
     */
    public String getValue(int index);

    /**
     * Translates the given String value (from form submit) to the corresponding Object.
     * @param value
     * @return
     */
    public Object translateValue(String value);

    //TODO
    public Collection getObjects();
}
