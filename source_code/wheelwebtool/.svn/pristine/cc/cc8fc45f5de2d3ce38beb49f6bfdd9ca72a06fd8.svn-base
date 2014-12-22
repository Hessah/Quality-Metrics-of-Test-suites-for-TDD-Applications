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

import wheel.AbstractEngine;
import wheel.IEngine;
import wheel.WheelException;
import wheel.util.DynamicSelectModel;
import wheel.util.InitialFieldValue;
import wheel.util.AbstractDateConversionHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The main API for Wheel. Contains most of the methods to manipulate the component tree for the page/component.
 * @author Henri Frilund
 */
public abstract class Component {
    private static final XmlEntityRef NBSP = new XmlEntityRef("nbsp");
    private Component parent;
    private LinkedList<Component> children;
    private String componentId;
    private List<CharSequence> renderHints;
    List<String> internalRenderHints;
    private List<ActionExpression> actions;
    private Map<String,Component> components;
    private Map<String,String> xhtmlAttributes;
    private boolean generatedId;
    private ComponentCreator componentCreator;


    /**
     * Minimum constructor for components that have given id's instead of generated ones.
     * @param componentId The identifier for this component.
     */
    public Component(String componentId) {
        if (componentId == null || componentId.length() == 0)
            this.componentId = this.getClass().getName().replace('.', '_');
        else
            this.componentId = componentId;
    }

    /**
     * Minimum constructor for components that have a generated component id.
     * @param parent The component to which this new component will be added to.
     */
    public Component(Component parent) {
        this.parent = parent;
        this.componentId = parent.getPage()._generateComponentId(this);
    }

    /**
     * Creates a new component with the given parent component and the given component id.
     * @param parent The component to which this new component will be added to.The component to which this new component will be added to.
     * @param componentId The identifier for this component.
     */
    public Component(Component parent, String componentId) {
        this.parent = parent;

        if (componentId != null && componentId.length() > 0)
            this.componentId = componentId;
        else
            this.componentId = parent.getPage()._generateComponentId(this);

        if (!generatedId && !(this instanceof FormElement))
            this.componentId = _wrapComponentId(componentId);
    }

    /**
     * Creates a new component with the given parent component, given component id and given render hint.
     * @param parent The component to which this new component will be added to.The component to which this new component will be added to.
     * @param componentId The identifier for this component.
     * @param renderHint Instruction on how to render this component.
     */
    public Component(Component parent, String componentId, CharSequence renderHint) {
        this.parent = parent;

        if (componentId != null && componentId.length() > 0)
            this.componentId = componentId;
        else
            this.componentId = parent.getPage()._generateComponentId(this);

        if (!generatedId && !(this instanceof FormElement))
            this.componentId = _wrapComponentId(componentId);

        renderHint(renderHint);
    }

    /**
     * Returns the identitfier for this component. Every component must have a component id, either a given one or a generated one.
     * @return
     */
    public String getComponentId() {
        return componentId;
    }

    /**
     * Returns the short classname of the component class. Example: for com.foo.bar.Component2 will return Component2.
     * @return
     */
    public String getComponentName() {
        String className = getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1, className.length());
    }


    /**
     * Adds a rendering hint to this component. A rendering hint can be either a css class reference or a xhtml specification tag name.
     * Many rendering hints can be given in one input string. Example: "h1 error" will cause the component to render as &lt;h1 class="error"&gt;.
     * Note that the html tag name doesn't have to be first.
     * @param renderHint
     * @return Will return the component itself to enable method chaining.
     */
    public Component renderHint(CharSequence renderHint) {
        if (renderHints == null)
            renderHints = new LinkedList<CharSequence>();

        if (internalRenderHints != null && !internalRenderHints.isEmpty())
            internalRenderHints.clear();

        if (renderHint instanceof String && renderHint.toString().indexOf(" ") != -1) {
            String[] renderHintSplit = renderHint.toString().split(" ");
            for (int i = 0; i < renderHintSplit.length; i++) {
                String s = renderHintSplit[i];

                if (!renderHints.contains(s))
                    renderHints.add(s);
            }
        }
        else {
            String hint = eval(renderHint);

            if (!renderHints.contains(hint))
                renderHints.add(eval(renderHint));
        }

        return this;
    }

    Map<String,String> getAttributes() {
        return xhtmlAttributes;
    }

    /**
     * Adds an xhtml-attribute to the component. No checks are made to ensure the attributes are valid.
     * @param name Name of the attribute
     * @param value Value of the attribute. Can be an el-expression or a message.
     * @return Will return the component itself to enable method chaining.
     */
    public Component attribute(String name, CharSequence value) {
        if (xhtmlAttributes == null)
            xhtmlAttributes = new HashMap<String,String>();

        xhtmlAttributes.put(name, eval(value));

        return this;
    }

    /**
     * Has the same functionality as addAsset(String fileUri) but uses varargs to enable adding multitple attributes at once.
     * @param attributes name/value pairs.
     * @return Will return the component itself to enable method chaining.
     */
    public Component attributes(String... attributes) {
        if (attributes == null || attributes.length == 0)
            return this;

        if (attributes.length % 2 > 0)
            throw new IllegalArgumentException("Attributes must be given in name, value pairs.");

        if (attributes.length > 1 && xhtmlAttributes == null)
            xhtmlAttributes = new HashMap<String,String>();

        for (int i = 0; i < attributes.length; i += 2) {
            String name = attributes[i];
            String value = attributes[i+1];

            xhtmlAttributes.put(name, value);
        }

        return this;
    }


    /**
     * Intended for internal use. Returns all attributes added to this component with calls to attribute() methods.
     * @return
     */
    public Map<String, String> _getXhtmlAttributes() {
        return xhtmlAttributes;
    }

    public Component actionBinding(String actionExpression) {
        ActionExpression action = new ActionExpression(actionExpression);
        action.setOwner(this);
        addAction(action);

        return this;
    }

    public Component actionBinding(ActionExpression actionExpression) {
        actionExpression.setOwner(this);
        addAction(actionExpression);

        return this;
    }


    public ActionExpression action(String expression) {
        return new ActionExpression(expression);
    }


    private void addAction(ActionExpression action) {
        if (actions == null)
            actions = new LinkedList<ActionExpression>();

        ActionExpression existing = _getAction();

        if (existing != null && existing.isSubmissible() && !action.isSubmissible()) {
            actions.clear();
        }

        actions.add(action);
    }

    /**
     * Intetnded for internal use. Will return all actions added to this component with addAction() method.
     * @return
     */
    public List<ActionExpression> _getActions() {
        return actions;
    }

    /**
     * Intetnded for internal use. Will the first action added to this component with addAction() method.
     * @return
     */
    public ActionExpression _getAction() {
        if (actions != null && !actions.isEmpty())
            return actions.get(0);

        return null;
    }

    /**
     * Intended for internal use. Will return all child components.
     * @return
     */
    public List<Component> _getChildren() {
        if (children == null)
            return Collections.EMPTY_LIST;

        return children;
    }

    /**
     * Intended for internal use. Will return all children of this component that implement the Renderable interface.
     * @return
     */
    public List<RenderableComponent> _getRenderableChildren() {
        List<RenderableComponent> result = new LinkedList<RenderableComponent>();

        if (children != null) {
            for (Component component : children) {
                if (component instanceof RenderableComponent)
                    result.add((RenderableComponent)component);
            }
        }

        return result;
    }

    public ComponentCreator create() {
        if (componentCreator == null)
            componentCreator = new ComponentCreator(this);

        return componentCreator;
    }

    /**
     * Intended for internal use. Will return all rendering hints added to this component.
     * @return
     */
    public List<CharSequence> _getRenderHints() {
        if (renderHints == null)
            return Collections.EMPTY_LIST;

        return renderHints;
    }

    /**
     * Adds a non-breaking-space to the component tree.
     * @return Will return the component itself to enable method chaining.
     */
    public Component nbsp() {
        add(NBSP);
        return this;
    }


    /**
     * Removes a component from the list of children for this componnent.
     * @param component The component to remove.
     * @return Will return the component itself to enable method chaining.
     */
    public Component remove(Component component) {
        children.remove(component);
        return this;
    }

    /**
     * Removes a component with the given component id from the list of children for this component.
     * @param componentId
     * @return Will return the component itself to enable method chaining.
     */
    public Component remove(String componentId) {
        if (!components.containsKey(componentId))
            throw new WheelException("Component with id " + componentId + " does not exist.", null, this);

        children.remove(components.get(componentId));
        return this;
    }

    /**
     * Adds a Table-component to the component tree and returns it.
     * @return
     */
    public Component table() {
        Table table = new Table(this, null);
        add(table);
        return table;
    }

    public Component caption() {
        throw new WheelException("Thead component can be added only to a Table.", this);
    }

    /**
     * Adds a thead-element to a surrounding Table-component. If the surrounding element is not a Table, thorws an exception.
     * @return
     */
    public Component thead() {
        throw new WheelException("Thead component can be added only to a Table.", this);
    }

    /**
     * Adds a colgroup-element to a surrounding Table-component. If the surrounding element is not a Table, thorws an exception.
     * @return
     */
    public Component colgroup() {
        throw new WheelException("Colgroup component can be added only to a Table.", this);
    }

    /**
     * Adds a col-element to a surrounding TableBlock-component. If the surrounding element is not a TableBlock, thorws an exception.
     * @return
     */
    public Component col() {
        throw new WheelException("Col component can be added only to a TableBlock.", this);
    }

    /**
     * Adds a tbody-element to a surrounding Table-component. If the surrounding element is not a Table, thorws an exception.
     * @return
     */
    public Component tbody() {
        throw new WheelException("Tbody component can be added only to a Table.", this);
    }

    /**
     * Adds a tfoot-element to a surrounding Table-component. If the surrounding element is not a Table, thorws an exception.
     * @return
     */
    public Component tfoot() {
        throw new WheelException("Tfoot component can be added only to a Table.", this);
    }

    /**
     * Adds a tr-element (a row) the a surrounding TableBlock-element. If the surrounding elemenent is not a TableBlock, throws an exception.
     * @return
     */
    public Component tr() {
        throw new WheelException("Tr component can be added only to a TableBlock.", this);
    }

    /**
     * Adds a td-element (a column) the a surrounding TableBlock-element. If the surrounding elemenent is not a TableBlock, throws an exception.
     * @return
     */
    public Component td() {
        throw new WheelException("Td component can be added only to a TableRow.", this);
    }

    /**
     * Adds a th-element (a header) the a surrounding TableBlock-element. If the surrounding elemenent is not a TableBlock, throws an exception.
     * @return
     */
    public Component th() {
        throw new WheelException("Th component can be added only to a TableRow.", this);
    }


    //TODO
    public Component link() {
        Block link = new Block(this);
        link.renderHint("link");
        add(link);
        return link;
    }

    public Component meta() {
        Any meta = new Any(this, "meta");
        add(meta);
        return meta;
    }

    /**
     * Adds an Image-component to the component tree and returns it.
     * @param url Either a full http-url or a filepath inside the web application.
     * @param alt Alt text for the image if it can't be loaded or displayed.
     * @return
     */
    public Component img(String url, String alt) {
        Image image = new Image(this, url, alt);
        add(image);
        return image;
    }

    /**
     * Adds a Block-component to the component tree and returns it.
     * @param renderHint
     * @return
     */
    public Component wBlock(CharSequence renderHint) {
        Block block = new Block(this, "");
        block.renderHint(renderHint);
        add(block);
        return block;
    }

    //TODO
    public Component label() {
        Block label = new Block(this);
        label.renderHint("label");
        add(label);
        return label;
    }

    //TODO
    public Component label(Object text) {
        Label label = new Label(this, text);
        label.renderHint("label");
        add(label);
        return label;
    }


    //TODO
    public Component legend() {
        Block legend = new Block(this);
        legend.renderHint("legend");
        add(legend);
        return legend;
    }

    //TODO
    public Component legend(Object text) {
        Label legend = new Label(this, text);
        legend.renderHint("legend");
        add(legend);
        return legend;
    }

    public Component map(String id) {
        Block map = new Block(this, id);
        map.renderHint("map");
        add(map);
        return map;
    }

    public Component noframes() {
        Block noframes = new Block(this);
        noframes.renderHint("noframes");
        Block body = new Block(noframes);
        body.renderHint("body");
        noframes.add(body);
        add(noframes);

        return body;
    }

    public Component noscript() {
        Block noscript = new Block(this);
        noscript.renderHint("noscript");
        add(noscript);
        return noscript;
    }

    public Component object() {
        Block object = new Block(this);
        object.renderHint("object");
        add(object);
        return object;
    }

    public Component param(CharSequence name, CharSequence value) {
        Any param = new Any(this, "param");
        param.attribute("name", name);
        param.attribute("value", value);
        add(param);
        return param;
    }

    //TODO
    public Component pre() {
        Block pre = new Block(this);
        pre.renderHint("pre");
        add(pre);
        return pre;
    }

    //TODO
    public Component pre(Object text) {
        Label pre = new Label(this, text);
        pre.renderHint("pre");
        add(pre);
        return pre;
    }

    //TODO
    public Component q() {
        Block q = new Block(this);
        q.renderHint("q");
        add(q);
        return q;
    }

    //TODO
    public Component q(Object text) {
        Label q = new Label(this, text);
        q.renderHint("q");
        add(q);
        return q;
    }

    //TODO
    public Component s() {
        Block s = new Block(this);
        s.renderHint("s");
        add(s);
        return s;
    }

    //TODO
    public Component s(Object text) {
        Label s = new Label(this, text);
        s.renderHint("s");
        add(s);
        return s;
    }

    //TODO
    public Component samp() {
        Block samp = new Block(this);
        samp.renderHint("samp");
        add(samp);
        return samp;
    }

    //TODO
    public Component samp(Object text) {
        Label samp = new Label(this, text);
        samp.renderHint("samp");
        add(samp);
        return samp;
    }

    //TODO
    public Component small() {
        Block small = new Block(this);
        small.renderHint("small");
        add(small);
        return small;
    }

    //TODO
    public Component small(Object text) {
        Label small = new Label(this, text);
        small.renderHint("small");
        add(small);
        return small;
    }

    //TODO
    public Component strike() {
        Block strike = new Block(this);
        strike.renderHint("strike");
        add(strike);
        return strike;
    }

    //TODO
    public Component strike(Object text) {
        Label strike = new Label(this, text);
        strike.renderHint("strike");
        add(strike);
        return strike;
    }

    //TODO
    public Component style() {
        Block style = new Block(this);
        style.renderHint("style");
        add(style);
        return style;
    }

    //TODO
    public Component sub() {
        Block sub = new Block(this);
        sub.renderHint("sub");
        add(sub);
        return sub;
    }

    //TODO
    public Component sub(Object text) {
        Label sub = new Label(this, text);
        sub.renderHint("sub");
        add(sub);
        return sub;
    }

    //TODO
    public Component sup() {
        Block sup = new Block(this);
        sup.renderHint("sup");
        add(sup);
        return sup;
    }

    //TODO
    public Component sup(Object text) {
        Label sup = new Label(this, text);
        sup.renderHint("sup");
        add(sup);
        return sup;
    }

    //TODO
    public Component tt() {
        Block tt = new Block(this);
        tt.renderHint("tt");
        add(tt);
        return tt;
    }

    //TODO
    public Component tt(Object text) {
        Label tt = new Label(this, text);
        tt.renderHint("tt");
        add(tt);
        return tt;
    }

    //TODO
    public Component u() {
        Block u = new Block(this);
        u.renderHint("u");
        add(u);
        return u;
    }

    //TODO
    public Component u(Object text) {
        Label u = new Label(this, text);
        u.renderHint("u");
        add(u);
        return u;
    }

    //TODO
    public Component var() {
        Block var = new Block(this);
        var.renderHint("var");
        add(var);
        return var;
    }

    //TODO
    public Component var(Object text) {
        Label var = new Label(this, text);
        var.renderHint("var");
        add(var);
        return var;
    }



    /**
     * Adds a Text-component to the component tree and returns it. Use this method to add text that might contain entity references like &lt;copy&gt; etc.
     * @param textS
     * @return
     */
    public Component text(Object textS) {
        Text text = new Text(this, textS);
        add(text);
        return text;
    }


    /**
     * Adds an XmlEntityRef-component to the component tree and returns it.
     * @param name Name of the entity without & or ;. Example: entity("copy") will produce &amp;copy; when rendered.
     * @return
     */
    public Component entity(String name) {
        XmlEntityRef entity = new XmlEntityRef(name);
        add(entity);
        return entity;
    }



    /**
     * Adds a DateInput component to the component tree and returns it.
     * @param elementName
     * @param datePattern Use the same pattern as in @see java.text.SimpleDateFormat
     * @return
     */
    public FormElement dateInput(String elementName, String datePattern) {
        DateInput dateInput = create().dateInput(elementName, datePattern);
        add(dateInput);
        return dateInput;
    }



    /**
     * Adds a NumberInput-component to the component tree and returns it.
     * This method uses the default number format pattern for the default locale.
     * @param elementName
     * @return
     */
    public FormElement numberInput(String elementName) {
        NumberInput numberInput = create().numberInput(elementName, null);
        add(numberInput);
        return numberInput;
    }

    /**
     * Adds a NumberInput-component to the component tree and returns it.
     * @param elementName
     * @param numberFormat Use the same pattern as in
     * @see java.text.DecimalFormat
     * @return
     */
    public FormElement numberInput(String elementName, CharSequence numberFormat) {
        NumberInput numberInput = create().numberInput(elementName, numberFormat);
        add(numberInput);
        return numberInput;
    }



    /**
     * Adds a Select-component to the component tree and returns it.
     * @param elementName
     * @param model @see ISelectModel
     * @return
     */
    public FormElement select(String elementName, ISelectModel model, CharSequence binding) {
        Select select = create().select(elementName, model, binding);
        add(select);
        return select;
    }


    /**
     * Adds a Select-component in multiselect mode to the component tree and returns it.
     * @param elementName
     * @param model
     * @param binding
     * @return
     */
    public FormElement multiSelect(String elementName, ISelectModel model, CharSequence binding) {
        Select select = create().multiSelect(elementName, model, binding);
        add(select);
        return select;
    }


    //TODO
    public Component head() {
        return getPage().getHead();
    }

    //TODO
    public Component title(String text) {
        Label title = new Label(this, text);
        title._setComponentId("title");
        title.renderHint("title");

        if (head()._getChildren().contains(title))
            head().remove(title);

        head().add(title);
        return title;
    }

    /**
     * Adds a Hidden-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement hidden(String elementName) {
        Hidden hidden = create().hidden(elementName);
        add(hidden);
        return hidden;
    }



    /**
     * Adds a Checkbox-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement checkbox(String elementName) {
        Checkbox checkbox = create().checkbox(elementName);
        add(checkbox);
        return checkbox;
    }



    /**
     * Adds a CheckboxGroup-component to the component tree and returns it.
     * @param elementName
     * @param model
     * @return
     */
    public FormElement checkboxGroup(String elementName, ISelectModel model, ElExpression binding) {
        CheckboxGroup checkboxGroup = create().checkboxGroup(elementName, model, binding);
        add(checkboxGroup);
        return checkboxGroup;
    }


    /**
     * Adds a Submit-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement submit(String elementName) {
        Submit submit = create().submit(elementName);
        add(submit);
        return submit;
    }

    /**
     * Adds a Submit-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement imageSubmit(String elementName, String src) {
        Submit submit = create().imageSubmit(elementName, src);
        add(submit);
        return submit;
    }

    /**
     * Adds a Submit-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement reset(String elementName) {
        Submit submit = create().reset(elementName);
        add(submit);
        return submit;
    }



    /**
     * Adds a Radio-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement radio(String elementName) {
        Radio radio = create().radio(elementName);
        add(radio);
        return radio;
    }


    /**
     * Adds a RadioGroup-component to the component tree and returns it.
     * @param elementName
     * @param model
     * @param binding
     * @return
     */
    public FormElement radioGroup(String elementName, ISelectModel model, ElExpression binding) {
        RadioGroup radioGroup = create().radioGroup(elementName, model, binding);
        add(radioGroup);
        return radioGroup;
    }

    /**
     * Adds a TextInput-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement textInput(String elementName) {
        TextInput textInput = create().textInput(elementName);
        add(textInput);
        return textInput;
    }

    /**
     * Adds a TextInput-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement buttonInput(String elementName) {
        TextInput textInput = create().buttonInput(elementName);
        add(textInput);
        return textInput;
    }

    /**
     * Adds a TextInput-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement passwordInput(String elementName) {
        TextInput textInput = create().passwordInput(elementName);
        add(textInput);
        return textInput;
    }


    /**
     * Adds a FileInput-component to the component tree and returns it.
     * @param elementName
     * @return
     */
    public FormElement fileInput(String elementName) {
        FileInput fileInput = create().fileInput(elementName);
        add(fileInput);
        return fileInput;
    }

    /**
     * Adds a FileInput-component to the component tree and returns it. Also sets metadata from uploaded file to the given metadataBinding. The bound field must be of type wheel.util.FileUploadMetadata.
     * @param elementName
     * @param metadataBinding
     * @return
     */
    public FormElement fileInput(String elementName, ElExpression metadataBinding) {
        FileInput fileInput = create().fileInput(elementName);
        fileInput.setMetadataBind(metadataBinding);
        add(fileInput);
        return fileInput;
    }


    /**
     * Adds a TextArea-component to the component tree and returns it.
     * @return
     */
    public FormElement textarea(String name) {
        TextArea textArea = create().textarea(name);
        add(textArea);
        return textArea;
    }



    /**
     * Adds a Form-component to the component tree and returns it.
     * @param formId
     * @param action What action-method to call on form submit. Use Whee's URL action format here.
     * @return
     */
    public Component form(String formId, ActionExpression action) {
        Form form = create().form(formId, action);
        add(form);
        return form;
    }

    public Component form(String formId) {
        Form form = create().form(formId);
        add(form);
        return form;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h1" and returns it.
     * @param text
     * @return
     */
    public Component h1(Object text) {
        Label h1 = new Label(this, text);
        h1.renderHint("h1");
        add(h1);
        return h1;
    }


    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h1" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h1() {
        Block h1 = new Block(this);
        h1.renderHint("h1");
        add(h1);
        return h1;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h2" and returns it.
     * @param text
     * @return
     */
    public Component h2(Object text) {
        Label h2 = new Label(this, text);
        h2.renderHint("h2");
        add(h2);
        return h2;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h2" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h2() {
        Block h2 = new Block(this);
        h2.renderHint("h2");
        add(h2);
        return h2;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h3" and returns it.
     * @param text
     * @return
     */
    public Component h3(Object text) {
        Label h3 = new Label(this, text);
        h3.renderHint("h3");
        add(h3);
        return h3;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h3" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h3() {
        Block h3 = new Block(this);
        h3.renderHint("h3");
        add(h3);
        return h3;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h4" and returns it.
     * @param text
     * @return
     */
    public Component h4(Object text) {
        Label h4 = new Label(this, text);
        h4.renderHint("h4");
        add(h4);
        return h4;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h4" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h4() {
        Block h4 = new Block(this);
        h4.renderHint("h4");
        add(h4);
        return h4;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h5" and returns it.
     * @param text
     * @return
     */
    public Component h5(Object text) {
        Label h5 = new Label(this, text);
        h5.renderHint("h5");
        add(h5);
        return h5;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h5" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h5() {
        Block h5 = new Block(this);
        h5.renderHint("h5");
        add(h5);
        return h5;
    }

    /**
     * Adds a Label-component to the component tree, sets redering hint to "h6" and returns it.
     * @param text
     * @return
     */
    public Component h6(Object text) {
        Label h6 = new Label(this, text);
        h6.renderHint("h6");
        add(h6);
        return h6;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "h6" and returns it. Use when you need to add some other tags
     * inside a &lt;h*&gt; tag.
     * @return
     */
    public Component h6() {
        Block h6 = new Block(this);
        h6.renderHint("h6");
        add(h6);
        return h6;
    }

    /**
     * Adds a Label-component to the component tree, sets rendering hint to "b" and returns it.
     * @param text
     * @return
     */
    public Component b(Object text) {
        Label b = new Label(this, text);
        b.renderHint("b");
        add(b);
        return b;
    }

    //TODO
    public Component b() {
        Block b = new Block(this);
        b.renderHint("b");
        add(b);
        return b;
    }

    /**
     * Adds a Label-component to the component tree, sets rendering hint to "i" and returns it.
     * @param text
     * @return
     */
    public Component i(Object text) {
        Label i = new Label(this, text);
        i.renderHint("i");
        add(i);
        return i;
    }

    //TODO
    public Component i() {
        Block i = new Block(this);
        i.renderHint("i");
        add(i);
        return i;
    }

    //TODO
    public Component script() {
        Block script = new Block(this);
        script.renderHint("script");
        add(script);
        return script;
    }

    //TODO
    public Component abbr() {
        Block abbr = new Block(this);
        abbr.renderHint("abbr");
        add(abbr);
        return abbr;
    }

    //TODO
    public Component abbr(Object text) {
        Label abbr = new Label(this, text);
        abbr.renderHint("abbr");
        add(abbr);
        return abbr;
    }

    //TODO
    public Component acronym() {
        Block acronym = new Block(this);
        acronym.renderHint("acronym");
        add(acronym);
        return acronym;
    }

    //TODO
    public Component acronym(Object text) {
        Label acronym = new Label(this, text);
        acronym.renderHint("acronym");
        add(acronym);
        return acronym;
    }

    //TODO
    public Component address() {
        Block address = new Block(this);
        address.renderHint("address");
        add(address);
        return address;
    }

    //TODO
    public Component address(Object text) {
        Label address = new Label(this, text);
        address.renderHint("address");
        add(address);
        return address;
    }

    public Component area(String... attributes) {
        Any area = new Any(this, "area");
        area.attributes(attributes);
        add(area);
        return area;
    }

    public Component base(CharSequence href) {
        Any base = new Any(this, "base");
        base.attribute("href", href);
        add(base);
        return base;
    }

    public Component bdo(CharSequence dir) {
        Block bdo = new Block(this);
        bdo.renderHint("bdo");
        bdo.attribute("dir", dir);
        add(bdo);
        return bdo;
    }

    //TODO
    public Component big() {
        Block big = new Block(this);
        big.renderHint("big");
        add(big);
        return big;
    }

    //TODO
    public Component big(Object text) {
        Label big = new Label(this, text);
        big.renderHint("big");
        add(big);
        return big;
    }

    public Component blockquote() {
        Block blockquote = new Block(this);
        blockquote.renderHint("blockquote");
        add(blockquote);
        return blockquote;
    }

    public Component button() {
        Block button = new Block(this);
        button.renderHint("button");
        add(button);
        return button;
    }

    //TODO
    public Component cite() {
        Block cite = new Block(this);
        cite.renderHint("cite");
        add(cite);
        return cite;
    }

    //TODO
    public Component cite(Object text) {
        Label cite = new Label(this, text);
        cite.renderHint("cite");
        add(cite);
        return cite;
    }


    //TODO
    public Component code() {
        Block code = new Block(this);
        code.renderHint("code");
        add(code);
        return code;
    }

    //TODO
    public Component code(Object text) {
        Label code = new Label(this, text);
        code.renderHint("code");
        add(code);
        return code;
    }

    //TODO
    public Component del() {
        Block del = new Block(this);
        del.renderHint("del");
        add(del);
        return del;
    }

    //TODO
    public Component del(Object text) {
        Label del = new Label(this, text);
        del.renderHint("del");
        add(del);
        return del;
    }

    //TODO
    public Component dfn() {
        Block dfn = new Block(this);
        dfn.renderHint("dfn");
        add(dfn);
        return dfn;
    }

    //TODO
    public Component dfn(Object text) {
        Label dfn = new Label(this, text);
        dfn.renderHint("dfn");
        add(dfn);
        return dfn;
    }

    public Component frame(CharSequence src) {
        getPage().getBody()._getRenderHints().clear();
        getPage().getBody().renderHint("frameset");
        Any frame = new Any(this, "frame");
        frame.attribute("src", src);
        add(frame);
        return frame;
    }

    public Component body() {
        return getPage().getBody();
    }

    public Component iframe() {
        Any iframe = new Any(this, "iframe");
        add(iframe);
        return iframe;
    }

    //TODO
    public Component ins() {
        Block ins = new Block(this);
        ins.renderHint("ins");
        add(ins);
        return ins;
    }

    //TODO
    public Component ins(Object text) {
        Label ins = new Label(this, text);
        ins.renderHint("ins");
        add(ins);
        return ins;
    }

    //TODO
    public Component kbd() {
        Block kbd = new Block(this);
        kbd.renderHint("kdb");
        add(kbd);
        return kbd;
    }

    //TODO
    public Component kbd(Object text) {
        Label kbd = new Label(this, text);
        kbd.renderHint("kbd");
        add(kbd);
        return kbd;
    }



    /**
     * Adds an Any-component to the component tree, sets rendering hint to "hr" and returns it.
     * @return
     */
    public Component hr() {
        Any hr = new Any(this, "hr");
        add(hr);
        return hr;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "div" and returns it.
     * @return
     */
    public Component div() {
        Block div = new Block(this, null);
        add(div);
        return div;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "ul" and returns it.
     * @return
     */
    public Component ul() {
        Block ul = new Block(this, null);
        ul.renderHint("ul");
        add(ul);
        return ul;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "li" and returns it.
     * @return
     */
    public Component li() {
        Block li = new Block(this, null);
        li.renderHint("li");
        add(li);
        return li;
    }

    //TODO
    public Component li(Object text) {
        Label li = new Label(this, text);
        li.renderHint("li");
        add(li);
        return li;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "dl" and returns it.
     * @return
     */
    public Component dl() {
        Block dl = new Block(this, null);
        dl.renderHint("dl");
        add(dl);
        return dl;
    }


    /**
     * Adds a Block-component to the component tree, sets rendering hint to "dd" and returns it.
     * @return
     */
    public Component dd() {
        Block dd = new Block(this, null);
        dd.renderHint("dd");
        add(dd);
        return dd;
    }

    //TODO
    public Component dd(Object text) {
        Label dd = new Label(this, text);
        dd.renderHint("dd");
        add(dd);
        return dd;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "dt" and returns it.
     * @return
     */
    public Component dt() {
        Block dt = new Block(this, null);
        dt.renderHint("dt");
        add(dt);
        return dt;
    }

    //TODO
    public Component dt(Object text) {
        Label dt = new Label(this, text);
        dt.renderHint("dt");
        add(dt);
        return dt;
    }


    /**
     * Adds a Block-component to the component tree, sets rendering hint to "ol" and returns it.
     * @return
     */
    public Component ol() {
        Block ol = new Block(this, null);
        ol.renderHint("ol");
        add(ol);
        return ol;
    }


    /**
     * Adds a Block-component to the component tree, sets rendering hint to "p" and returns it.
     * @return
     */
    public Component p() {
        Block p = new Block(this, null);
        p.renderHint("p");
        add(p);
        return p;
    }

    /**
     * Adds a Label-component to the component tree, sets rendering hint to "p" and returns it.
     * @return
     */
    public Component p(Object text) {
        Label p = new Label(this, text);
        p.renderHint("p");
        add(p);
        return p;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "span" and returns it.
     * @return
     */
    public Component span() {
        Block span = new Block(this, null);
        span.renderHint("span");
        add(span);
        return span;
    }

    /**
     * Adds a Label-component to the component tree, sets rendering hint to "p" and returns it.
     * @return
     */
    public Component span(Object text) {
        Label span = new Label(this, text);
        add(span);
        return span;
    }

    /**
     * Adds a Block-component to the component tree, sets rendering hint to "fieldset" and returns it.
     * @return
     */
    public Component fieldset() {
        Block fieldset = new Block(this, null);
        fieldset.renderHint("fieldset");
        add(fieldset);
        return fieldset;
    }

    /**
     * Adds a Text-component to the component tree and sets it in cdata-mode causing all the text to be rendered inside a CDATA-section.
     * Useful if you need to output for example javascript-code.
     * @param rawText
     * @return
     */
    public Component rawText(Object rawText) {
        Text text = new Text(this, rawText);
        text.renderSelf = false;
        text.setCdata(true);
        add(text);
        return text;
    }

    /**
     * Adds a Text-component to the component tree and sets it in html-mode. In html-mode the Text-component will treat the text as html-code and retain
     * all the html-tags.
     * @param htmlText
     * @return
     */
    public Component htmlText(Object htmlText) {
        Text text = new Text(this, htmlText);
        text.renderSelf = false;
        text.setHtml(true);
        add(text);
        return text;
    }



    /**
     * Changes the componentId.
     * @param componentId New component id.
     * @return
     */
    public Component id(String componentId) {
        Map<String,Component> components = ((Component) _getTopLevelComponent(true)).getComponents();

        components.remove(getComponentId());

        if (this instanceof FormElement || this instanceof Form)
            this.componentId = _wrapComponentId(componentId);
        else
            this.componentId = _wrapComponentId(componentId);

        components.put(componentId, this);

        if (generatedId)
            generatedId = false;

        if (this instanceof RenderableComponent) {
            RenderableComponent renderableComponent = (RenderableComponent)this;
            if (!getPage().renderGeneratedComponentIds && !renderableComponent.renderId)
                renderableComponent.renderId = true;
        }

        return this;
    }


    /**
     * Intended for internal use. Sets the component id directly bypassing all checks and wrappings.
     * @param componentId
     */
    public void _setComponentId(String componentId) {
        this.componentId = componentId;
    }

    /**
     * Returns the parent for this component. If the component is an instance of Page, will return null.
     * @return
     */
    public Component getParent() {
        return parent;
    }

    /**
     * Intended for internal use. Returns the Form-component (if any) surrounding this component.
     * @param returnSelf If true, will return this component if this instanceof Form.
     * @return
     */
    public Form _getForm(boolean returnSelf) {
        if (returnSelf && this instanceof Form)
            return (Form)this;

        Component parent = getParent();

        while (parent != null) {
            if (parent instanceof Form)
                return (Form)parent;

            parent = parent.getParent();
        }

        return null;
    }

    //TODO
    public Form _getVisibleForm(boolean returnSelf) {
        if (returnSelf && this instanceof Form) {
            Form form = (Form)this;

            if (form.renderSelf)
                return form;
        }

        Component parent = getParent();

        while (parent != null) {
            if (parent instanceof Form) {
                Form form = (Form)parent;

                if (form.renderSelf)
                    return form;
            }

            parent = parent.getParent();
        }

        return null;
    }

    /**
     * Returns the containing StandaloneComponent. Usually this will return the same objext as getPage(),
     * but for components living inside complex components, this will not return the page.
     * @param returnSelf If true, will return self if this component is the top level component itself, otherwise will return the surrounding complex component.
     * @return
     */
    public StandaloneComponent _getTopLevelComponent(boolean returnSelf) {
        if ((this instanceof StandaloneComponent) && returnSelf)
            return (StandaloneComponent)this;

        Component parent = getParent();

        while (parent != null) {
            if (parent instanceof StandaloneComponent)
                return (StandaloneComponent)parent;

            parent = parent.getParent();
        }

        throw new WheelException("No top level component found.", this);
    }

    /**
     * Returns the surrounding page where this component lives.
     * @return
     */
    public StandaloneComponent getPage() {
        Component parent = getParent();

        if (parent == null) {
            if (!(this instanceof StandaloneComponent))
                return AbstractEngine.getCurrentServer().getpage();

            return (StandaloneComponent)this;
        }

        while (parent.getParent() != null) {
            parent = parent.getParent();
        }

        return (StandaloneComponent) parent;
    }

    /**
     *
     * @return
     */
    public Map<String, Component> getComponents() {
        Map<String,Component> componentMap = components;

        if (!(this instanceof StandaloneComponent))
            componentMap = _getTopLevelComponent(true).getComponents();

        if (componentMap == null)
            return Collections.EMPTY_MAP;

        return componentMap;
    }

    public Component addFirst(Component component) {
        return addChild(component, true);
    }


    /**
     * Adds the given component to the component tree.
     * @param component
     * @return Will return the component itself to enable method chaining.
     */
    public Component add(Component component) {
        return addChild(component, false);
    }

    private Component addChild(Component component, boolean addFirst) {
        if (!(this instanceof IContainer))
            throw new WheelException("Can't add components to a component that is not an instance of IContainer.", this);

        component.parent = this;

        if (component instanceof StandaloneComponent) {
            StandaloneComponent standaloneComponent = (StandaloneComponent)component;

            if (standaloneComponent.ajaxComponent)
                getPage().loadJQuery();

            standaloneComponent.renderHint(standaloneComponent.getComponentName());

            getPage().addUsedStandaloneComponent(standaloneComponent);
            standaloneComponent._injectExposedFields();

            getEngine()._addComponentType(getPage().getPagePath() + "/" + component.getComponentId(), component.getClass().getName());
            

        }

        if (children == null)
            children = new LinkedList<Component>();

        if ((component instanceof RenderableComponent) && !getPage().renderGeneratedComponentIds && component._isGeneratedId())
            ((RenderableComponent)component).renderId = false;

        if (component instanceof IBuildableComponent) {
            IBuildableComponent buildableComponent = (IBuildableComponent) component;

            if (!buildableComponent._isBuilt()) {
                buildableComponent.preBuild();
                getPage()._addPostBuildCallback(buildableComponent);
            }

            buildableComponent.buildComponent();
            buildableComponent._setBuilt(true);
        }

        if (addFirst)
            children.addFirst(component);
        else
            children.add(component);

        if (component instanceof FormElement) {
            Form form = _getForm(true);

            if (form == null)
                throw new WheelException("Cannot add a form element. No surrounding form found.", component);

            if (component instanceof Submit) {
                if (form._getForm(false) != null) {
                    ActionExpression action = form.getAction();
                    action.event(null);
                    action.submissible(true);
                    component.actionBinding(action);
                }
            }

            form.addFormElement((FormElement)component);
        }
        else if (component instanceof StandaloneComponent) {
            StandaloneComponent topLevelComponent = component._getTopLevelComponent(false);

            if (topLevelComponent != null && !topLevelComponent.isPage())
                component._setComponentId(_wrapComponentId(component.getComponentId()));
        }

        Component topLevelComponent = _getTopLevelComponent(true);

        if (topLevelComponent.components == null)
            topLevelComponent.components = new HashMap<String,Component>();

        topLevelComponent.components.put(component.getComponentId(), component);

        component.afterAdd();

        return component;

    }

    Component addInternalRenderHint(String hint) {
        if (internalRenderHints == null)
            internalRenderHints = new LinkedList<String>();

        internalRenderHints.add(hint);

        return this;
    }

    /**
     * Inteded for internal use. Clears all attributes and child components.
     */
    public synchronized void _clear() {
        if (children != null)
            children.clear();

        if (renderHints != null)
            renderHints.clear();

        if (xhtmlAttributes != null)
            xhtmlAttributes.clear();

        if (components != null)
            components.clear();

        if (internalRenderHints != null)
            internalRenderHints.clear();

        if (xhtmlAttributes != null)
            xhtmlAttributes.clear();

        if (actions != null)
            actions.clear();
    }

    /**
     * Component equality is based on component id.
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        if (componentId != null ? !componentId.equals(component.componentId) : component.componentId != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (componentId != null ? componentId.hashCode() : 0);
    }

    /**
     * Adds an Any-component to the component tree, sets rendring hint to "br" and returns it.
     * @return
     */
    public Component br() {
        Any br = new Any(this, "br");
        add(br);
        return br;
    }


    /**
     * Same as up(), but makes it possible to move more then one level upwards at a time.
     * @param levels How many levels to move upwards.
     * @return
     */
    public Component up(int levels) {
        Component result = this;

        for (int i=0; i < levels; i++)
            result = result.getParent();

        return result;
    }

    /**
     * Returns the component with the given component id. Note that this only works inside a StandaloneComponent so that you can access only components that
     * are created in same buildComponent() / buildComponent() method. Useful for example for recalling previously created placeholders.
     * @param componentId
     * @return
     */
    public Component get(String componentId) {
        StandaloneComponent topLevelComponent = _getTopLevelComponent(true);

        Component component = null;

        if (!topLevelComponent.isPage() && topLevelComponent.wrapIds)
            component = topLevelComponent.getComponents().get(_wrapComponentId(componentId));
        else
            component = topLevelComponent.getComponents().get(componentId);

        if (component == null && !topLevelComponent.isPage()) {
            topLevelComponent = topLevelComponent._getTopLevelComponent(false);
            component = topLevelComponent.getComponents().get(componentId);
        }

        if (component == null)
            throw new WheelException("Could not find component with id '" + componentId + "'.", this);

        return component;
    }

    /**
     * Finds a component with the given component id.
     * @param componentId
     * @return
     * @throws WheelException if no component was found.
     */
    public Component find(String componentId) {
        componentId = _wrapComponentId(componentId);

        Iterator<Component> openLevel = _getChildren().iterator();
        Stack<Iterator> openLevels = new Stack<Iterator>();

        while (openLevel.hasNext()) {
            Component component = openLevel.next();

            if (component.getComponentId().equals(componentId))
                return component;

            if (component._getChildren().size() > 0) {
                openLevels.push(openLevel);
                openLevel = component._getChildren().iterator();
            }

            while (!openLevel.hasNext() && !openLevels.empty())
                openLevel = openLevels.pop();

        }

        throw new WheelException("Could not find component with id " + componentId + " on the page.", this);
    }

    /**
     * TODO
     * @param expression
     * @return
     */
    public List<Component> findAll(ElExpression expression) {
        List<Component> result = new LinkedList<Component>();

        Iterator<Component> openLevel = _getChildren().iterator();
        Stack<Iterator> openLevels = new Stack<Iterator>();

        while (openLevel.hasNext()) {
            Component component = openLevel.next();

            expression.errorMessage("Could not evaluate finder expression ' " + expression + "'");

            Object val = expression.eval(component, this);

            if (val == null || !(val instanceof Boolean))
                throw new WheelException("Finder expression didn't evaluate to a boolean value.", this);

            if (((Boolean)val).booleanValue())
                result.add(component);

            if (component._getChildren().size() > 0) {
                openLevels.push(openLevel);
                openLevel = component._getChildren().iterator();
            }

            while (!openLevel.hasNext() && !openLevels.empty())
                openLevel = openLevels.pop();

        }

        return result;
    }


    /**
     * Inteded for internal use. Sets the status of the component id. When true, means that the id for this component
     * was generated.
     * @param generatedId
     */
    public void _setGeneratedId(boolean generatedId) {
        this.generatedId = generatedId;
    }

    /**
     * Returns true if the id for this component was generated.
     * @return
     */
    public boolean _isGeneratedId() {
        return generatedId;
    }


    public String _wrapComponentId(String componentId) {
        StandaloneComponent topLevelComponent = _getTopLevelComponent(true);

        StringBuilder sb = new StringBuilder();

        while (topLevelComponent.wrapIds) {
            sb.append(topLevelComponent.getComponentId()).append("_");
            topLevelComponent = topLevelComponent._getTopLevelComponent(false);
        }

        if (this instanceof FormElement && getPage().wrapFormIds) {
            sb.setLength(0);
            sb.append(_getForm(true).getComponentId()).append("_");
        }

        sb.append(componentId);

        return sb.toString();
    }

    /**
     * Evaluates a String expression. Three different types are supported:
     * @param expression
     * @return Result of the evaluation.
     */
    public String eval(Object expression) {
        if (expression == null)
            return "null";

        if (expression instanceof ElExpression) {
            ElExpression el = (ElExpression) expression;
            el.errorMessage("Could not evaluate expression " + expression + " in class " + _getTopLevelComponent(true).getClass().getName());
            Object o = el.eval(_getTopLevelComponent(true), this);

            InitialFieldValue initialFieldValue = null;

            if (_getTopLevelComponent(true).initialFieldValues != null)
                initialFieldValue = _getTopLevelComponent(true).initialFieldValues.get(el.getExpression());

            if (initialFieldValue != null) {
                if (o instanceof Number) {
                    Number number = (Number)o;

                    if (initialFieldValue.getEmptyValue() != null && number.toString().equals(initialFieldValue.getEmptyValue()))
                        return eval(initialFieldValue.getStringReplacement());
                    else if (number.doubleValue() == 0)
                        return eval(initialFieldValue.getStringReplacement());
                }
                else {
                    if (initialFieldValue.getEmptyValue() != null && o != null && o.equals(initialFieldValue.getEmptyValue()))
                        return eval(initialFieldValue.getStringReplacement());
                    else if (o == null)
                        return eval(initialFieldValue.getStringReplacement());
                }
            }
            else {
                if (o instanceof Number) {
                    Number number = (Number)o;

                    if (number.doubleValue() == 0)
                        return "";
                }
                if (o == null)
                    return "";
            }

            return _applyFormat(o);
        }
        else {
            return expression.toString();
        }
    }



    /**
     * By overriding this method, its possible to apply some formatting to MVEL-evaluations in the eval() method.
     * @param value The result of an MVEL-evaluation.
     * @return A formattetd String based on the input Object.
     */
    public String _applyFormat(Object value) {
        return value.toString();
    }

    /**
     * Returns the IEngine instance that is serving this request-cycle.
     * @return
     */
    public IEngine getEngine() {
        return AbstractEngine.getCurrentServer();
    }


    /**
     * Request focus for this component on the browser. Note that only one component on a html page can have focus and
     * it will be the last component to call this method before the page is rendered.
     * @return
     */
    public Component requestFocus() {
        getPage().setFocus(this);
        return this;
    }

    /**
     * URL-encodes the given string and returns it.
     * @param string
     * @return
     */
    public String encode(String string) {
        try {
            return URLEncoder.encode(string, getEngine().getEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new WheelException("Could not encode string '" + string + "'.", e, this);
        }
    }

    public Component wrapSelf() {
        Block block = new Block(parent, componentId + "_wrapper");
        block._setComponentId(componentId + "_wrapper");

        Component originalParent = parent;

        this.parent.remove(this);
        block.add(this);

        parent = block;

        originalParent.add(block);

        return this;
    }



    /**
     * Returns a locaiized message with the given key.
     * @param key
     * @return
     * @see wheel.Messages
     */
    public String message(String key) {
        return _getTopLevelComponent(true).getMessages().getMessage(key);
    }

    /**
     * Returns a localized and parametrized message with all {0...n} escapes replaced with values from the given Object array.
     * @param key
     * @param params
     * @return
     * @see wheel.Messages
     */
    public String message(String key, Object... params) {
        String message = message(key);

        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            message = message.replace("{" + i + "}", eval(param));
        }

        return message;
    }

    public Component clasS(CharSequence Class) {
        return renderHint(Class);
    }

    public Component a(Object text) {
        Link link = new Link(this, eval(text));
        add(link);
        return link;
    }

    public Component a() {
        Link link = new Link(this, null);
        add(link);
        return link;
    }

    public Component em() {
        Block em = new Block(this);
        em.renderHint("em");
        add(em);
        return em;
    }

    public Component em(Object text) {
        Label em = new Label(this, eval(text));
        em.renderHint("em");
        add(em);
        return em;
    }

    public Component strong() {
        Block strong = new Block(this);
        strong.renderHint("strong");
        add(strong);
        return strong;
    }

    public Component strong(Object text) {
        Label strong = new Label(this, eval(text));
        strong.renderHint("strong");
        add(strong);
        return strong;
    }

    /**
     * A lifecycle method that is called after the component has been added to the component tree.
     * When overriding this method, always call super.afterAdd();!!
     */
    public void afterAdd() {

    }

    /**
     * Creates a placeholder. A placeholder is a Block-component that will not render itself.
     * This makes it possible to leave behind placeholders in the component tree. These placeholders
     * can be passed around for later use. Placeholders can also be accessed with the get() method.
     * @param placeholderId Identifier for the placeholder.
     * @return
     */
    public Block placeholder(String placeholderId) {
        Block block = new Block(this, placeholderId);
        block.renderSelf = false;
        add(block);
        return block;
    }

    //TODO
    public ElExpression el(String expression) {
        return new ElExpression(expression);
    }

    //TODO
    public DynamicSelectModel selectModel() {
        return new DynamicSelectModel();
    }

    public Calendar date() {
        return AbstractEngine.getCalendar();
    }

    public String dateFormat(String pattern, Object date) {
        SimpleDateFormat df = AbstractDateConversionHandler.getDateFormat();
        df.setCalendar(date());

        try {
            df.applyPattern(pattern);
        } catch (Exception e) {
            throw new WheelException("Failed to initialize SimpleDateFormat with pattern '" + pattern + "'.", e, this);
        }

        if (date instanceof Calendar)
            return df.format(((Calendar)date).getTime());
        else if (date instanceof Date)
            return df.format(date);
        else if (date instanceof Long) {
            Calendar c = date();
            c.setTimeInMillis(((Long)date).longValue());
            return df.format(c.getTime());
        }
        else {
            throw new WheelException("Unsupported type given for dateFormat. Supported types are: Date, Calendar, Long/long .", this);
        }

    }

    public Component end(String expression) {
        Component parent = getParent();

        while(parent != null) {
            if (!(parent instanceof RenderableComponent)) {
                parent = parent.getParent();
                continue;
            }

            if (parent.getComponentId().equals(expression))
                return parent.getParent();
                                
            if (((RenderableComponent)parent).getTagName().equals(expression))
                return parent.getParent();

            if (expression.indexOf(" ") != -1) {
                String[] split = expression.split(" ");
                int matched = 0;

                for (int i = 0; i < split.length; i++) {
                    String s = split[i];

                    if (parent._getRenderHints().contains(s))
                        matched++;
                    else
                        break;
                }

                if (matched == split.length)
                    return parent.getParent();
            }
            else {
                if (parent._getRenderHints().contains(expression))
                    return parent.getParent();
            }

            parent = parent.getParent();
        }

        throw new WheelException("No corresponding component found for end expression '" + expression + "'.", this);
    }

    public Component end() {
        if (getParent() == null)
            throw new WheelException("Could not end compoennt, already at root.", this);

        return getParent();
    }

    public void _setParent(Component parent) {
        this.parent = parent;
    }
}
