/*
Copyright (c) 2007-2008, Henri Frilund

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, forComponent list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, forComponent list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from forComponent software without specific prior written permission.

forComponent SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF forComponent
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package wheel.components;

import wheel.WheelException;

import java.util.Set;

public class ComponentCreator {
    private Component forComponent;

    public ComponentCreator(Component forComponent) {
        this.forComponent = forComponent;
    }


    public Component h1(Object text) {
        Label h1 = new Label(forComponent, text);
        h1.renderHint("h1");

        return h1;
    }



    public Component h1() {
        Block h1 = new Block(forComponent);
        h1.renderHint("h1");

        return h1;
    }


    public Component h2(Object text) {
        Label h2 = new Label(forComponent, text);
        h2.renderHint("h2");

        return h2;
    }


    public Component h2() {
        Block h2 = new Block(forComponent);
        h2.renderHint("h2");

        return h2;
    }


    public Component h3(Object text) {
        Label h3 = new Label(forComponent, text);
        h3.renderHint("h3");

        return h3;
    }


    public Component h3() {
        Block h3 = new Block(forComponent);
        h3.renderHint("h3");

        return h3;
    }


    public Component h4(Object text) {
        Label h4 = new Label(forComponent, text);
        h4.renderHint("h4");

        return h4;
    }


    public Component h4() {
        Block h4 = new Block(forComponent);
        h4.renderHint("h4");

        return h4;
    }


    public Component h5(Object text) {
        Label h5 = new Label(forComponent, text);
        h5.renderHint("h5");

        return h5;
    }


    public Component h5() {
        Block h5 = new Block(forComponent);
        h5.renderHint("h5");

        return h5;
    }


    public Component h6(Object text) {
        Label h6 = new Label(forComponent, text);
        h6.renderHint("h6");

        return h6;
    }


    public Component h6() {
        Block h6 = new Block(forComponent);
        h6.renderHint("h6");

        return h6;
    }


    public Component b(Object text) {
        Label b = new Label(forComponent, text);
        b.renderHint("b");

        return b;
    }

    //TODO
    public Component b() {
        Block b = new Block(forComponent);
        b.renderHint("b");

        return b;
    }


    public Any br() {
        Any br = new Any(forComponent, "br");
        return br;
    }


    public Component i(Object text) {
        Label i = new Label(forComponent, text);
        i.renderHint("i");

        return i;
    }

    //TODO
    public Component i() {
        Block i = new Block(forComponent);
        i.renderHint("i");

        return i;
    }

    //TODO
    public Component script() {
        Block script = new Block(forComponent);
        script.renderHint("script");

        return script;
    }

    //TODO
    public Component abbr() {
        Block abbr = new Block(forComponent);
        abbr.renderHint("abbr");

        return abbr;
    }

    //TODO
    public Component abbr(Object text) {
        Label abbr = new Label(forComponent, text);
        abbr.renderHint("abbr");

        return abbr;
    }

    //TODO
    public Component acronym() {
        Block acronym = new Block(forComponent);
        acronym.renderHint("acronym");

        return acronym;
    }

    //TODO
    public Component acronym(Object text) {
        Label acronym = new Label(forComponent, text);
        acronym.renderHint("acronym");

        return acronym;
    }

    //TODO
    public Component address() {
        Block address = new Block(forComponent);
        address.renderHint("address");

        return address;
    }

    //TODO
    public Component address(Object text) {
        Label address = new Label(forComponent, text);
        address.renderHint("address");

        return address;
    }

    public Component area(String... attributes) {
        Any area = new Any(forComponent, "area");
        area.attributes(attributes);

        return area;
    }

    public Component base(CharSequence href) {
        Any base = new Any(forComponent, "base");
        base.attribute("href", href);

        return base;
    }

    public Component bdo(CharSequence dir) {
        Block bdo = new Block(forComponent);
        bdo.renderHint("bdo");
        bdo.attribute("dir", dir);

        return bdo;
    }

    //TODO
    public Component big() {
        Block big = new Block(forComponent);
        big.renderHint("big");

        return big;
    }

    //TODO
    public Component big(Object text) {
        Label big = new Label(forComponent, text);
        big.renderHint("big");

        return big;
    }

    public Component blockquote() {
        Block blockquote = new Block(forComponent);
        blockquote.renderHint("blockquote");

        return blockquote;
    }

    public Component button() {
        Block button = new Block(forComponent);
        button.renderHint("button");

        return button;
    }

    //TODO
    public Component cite() {
        Block cite = new Block(forComponent);
        cite.renderHint("cite");

        return cite;
    }

    //TODO
    public Component cite(Object text) {
        Label cite = new Label(forComponent, text);
        cite.renderHint("cite");

        return cite;
    }

    //TODO
    public Component code() {
        Block code = new Block(forComponent);
        code.renderHint("code");

        return code;
    }

    //TODO
    public Component code(Object text) {
        Label code = new Label(forComponent, text);
        code.renderHint("code");

        return code;
    }

    //TODO
    public Component del() {
        Block del = new Block(forComponent);
        del.renderHint("del");

        return del;
    }

    //TODO
    public Component del(Object text) {
        Label del = new Label(forComponent, text);
        del.renderHint("del");

        return del;
    }

    //TODO
    public Component dfn() {
        Block dfn = new Block(forComponent);
        dfn.renderHint("dfn");

        return dfn;
    }

    //TODO
    public Component dfn(Object text) {
        Label dfn = new Label(forComponent, text);
        dfn.renderHint("dfn");

        return dfn;
    }

    public Component frame(CharSequence src) {
        Any frame = new Any(forComponent, "frame");
        frame.attribute("src", src);

        return frame;
    }

    public Component frameset() {
        forComponent.getPage().getBody()._getRenderHints().clear();
        forComponent.getPage().getBody().renderHint("frameset");
        return forComponent.getPage().getBody();
    }

    public Component iframe() {
        Any iframe = new Any(forComponent, "iframe");

        return iframe;
    }

    //TODO
    public Component ins() {
        Block ins = new Block(forComponent);
        ins.renderHint("ins");

        return ins;
    }

    //TODO
    public Component ins(Object text) {
        Label ins = new Label(forComponent, text);
        ins.renderHint("ins");

        return ins;
    }

    //TODO
    public Component kbd() {
        Block kbd = new Block(forComponent);
        kbd.renderHint("kdb");

        return kbd;
    }

    //TODO
    public Component kbd(Object text) {
        Label kbd = new Label(forComponent, text);
        kbd.renderHint("kbd");

        return kbd;
    }




    public Component hr() {
        Any hr = new Any(forComponent, "hr");

        return hr;
    }


    public Component div() {
        Block div = new Block(forComponent, null);

        return div;
    }


    public Component ul() {
        Block ul = new Block(forComponent, null);
        ul.renderHint("ul");

        return ul;
    }


    public Component li() {
        Block li = new Block(forComponent, null);
        li.renderHint("li");

        return li;
    }

    //TODO
    public Component li(Object text) {
        Label li = new Label(forComponent, text);
        li.renderHint("li");

        return li;
    }


    public Component dl() {
        Block dl = new Block(forComponent, null);
        dl.renderHint("dl");

        return dl;
    }


    public Component dd() {
        Block dd = new Block(forComponent, null);
        dd.renderHint("dd");

        return dd;
    }

    public Component dd(Object text) {
        Label dd = new Label(forComponent, text);
        dd.renderHint("dd");

        return dd;
    }


    public Component dt() {
        Block dt = new Block(forComponent, null);
        dt.renderHint("dt");

        return dt;
    }

    //TODO
    public Component dt(Object text) {
        Label dt = new Label(forComponent, text);
        dt.renderHint("dt");

        return dt;
    }


    public Component ol() {
        Block ol = new Block(forComponent, null);
        ol.renderHint("ol");

        return ol;
    }



    public Component p() {
        Block p = new Block(forComponent, null);
        p.renderHint("p");

        return p;
    }


    public Component p(Object text) {
        Label p = new Label(forComponent, text);
        p.renderHint("p");

        return p;
    }


    public Component span() {
        Block span = new Block(forComponent, null);
        span.renderHint("span");

        return span;
    }


    public Component span(Object text) {
        Label span = new Label(forComponent, text);

        return span;
    }
    

    public Component text(Object textS) {
        Text text = new Text(forComponent, textS);
        return text;
    }


    public Component fieldset() {
        Block fieldset = new Block(forComponent, null);
        fieldset.renderHint("fieldset");

        return fieldset;
    }


    public Checkbox checkbox(String elementName) {
        Checkbox checkbox = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            checkbox = (Checkbox)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (checkbox == null) {
            checkbox = new Checkbox(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(checkbox);
        }

        return checkbox;
    }


    public Hidden hidden(String elementName) {
        Hidden hidden = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            hidden = (Hidden)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (hidden == null) {
            hidden = new Hidden(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(hidden);
        }

        return hidden;
    }


    public Select multiSelect(String elementName, ISelectModel model, CharSequence binding) {
        Select select = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            select = (Select)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (select == null) {
            select = new Select(forComponent, elementName, id, binding, model, true);
            forComponent.getPage()._getComponentStore().addComponent(select);
        }

        return select;
    }


    public Select select(String elementName, ISelectModel model, CharSequence binding) {
        Select select = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            select = (Select)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (select == null) {
            select = new Select(forComponent, elementName, id, model, binding);
            forComponent.getPage()._getComponentStore().addComponent(select);
        }

        return select;
    }


    public NumberInput numberInput(String elementName, CharSequence numberPattern) {
        NumberInput numberInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            numberInput = (NumberInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (numberInput == null) {

            if (numberPattern != null)
                numberInput = new NumberInput(forComponent, elementName, id, numberPattern);
            else
                numberInput = new NumberInput(forComponent, elementName, id);

            forComponent.getPage()._getComponentStore().addComponent(numberInput);
        }

        return numberInput;
    }


    public DateInput dateInput(String elementName, CharSequence datePattern) {
        DateInput dateInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            dateInput = (DateInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (dateInput == null) {
            dateInput = new DateInput(forComponent, elementName, id, datePattern);
            forComponent.getPage()._getComponentStore().addComponent(dateInput);
        }

        return dateInput;
    }


    public CheckboxGroup checkboxGroup(String elementName, ISelectModel model, ElExpression binding) {
        CheckboxGroup checkboxGroup = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName + "_container");

        if (forComponent.getPage()._isRewindingForm(form)) {
            checkboxGroup = (CheckboxGroup)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (checkboxGroup == null) {
            checkboxGroup = new CheckboxGroup(forComponent, elementName, id, model, binding);
            forComponent.getPage()._getComponentStore().addComponent(checkboxGroup);
        }

        return checkboxGroup;
    }


    public TextInput textInput(String elementName) {
        TextInput textInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            textInput = (TextInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }


        if (textInput == null) {
            textInput = new TextInput(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(textInput);
        }

        return textInput;
    }

    public TextInput passwordInput(String elementName) {
         TextInput textInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            textInput = (TextInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }


        if (textInput == null) {
            textInput = new TextInput(forComponent, elementName, id);
            textInput.attribute("type", "password");
            forComponent.getPage()._getComponentStore().addComponent(textInput);
        }

        return textInput;
    }

    public TextInput buttonInput(String elementName) {
         TextInput textInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            textInput = (TextInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }


        if (textInput == null) {
            textInput = new TextInput(forComponent, elementName, id);
            textInput.attribute("type", "button");
            forComponent.getPage()._getComponentStore().addComponent(textInput);
        }

        return textInput;
    }


    public FileInput fileInput(String elementName) {
        FileInput fileInput = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            fileInput = (FileInput)forComponent.getPage()._getComponentStore().getComponent(id);
        }

        if (fileInput == null) {
            fileInput = new FileInput(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(fileInput);
        }

        return fileInput;
    }


    public TextArea textarea(String elementName) {
        TextArea textArea = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            textArea = (TextArea)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (textArea == null) {
            textArea = new TextArea(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(textArea);
        }

        return textArea;
    }

    public Form form(String formId) {
        return form(formId, new ActionExpression("this"));
    }


    public Form form(String formId, ActionExpression action) {
        Form form = null;

        StandaloneComponent page = forComponent.getPage();

        if (page.isPageRewinding()) {
            form = (Form)page._getComponentStore().getComponent(forComponent._wrapComponentId(formId));
        }

        if (form == null) {
            form = new Form(forComponent, formId, action);
            page._getComponentStore().addComponent(form);
        }

        if (page.containsForm)
            page.wrapFormIds = true;
        else
            page.containsForm = true;

        return form;
    }


    public Radio radio(String formElementName) {
        Radio radio = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, formElementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            radio = (Radio)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (radio == null) {
            radio = new Radio(forComponent, formElementName, id);
            forComponent.getPage()._getComponentStore().addComponent(radio);
        }

        return radio;
    }


    public RadioGroup radioGroup(String elementName, ISelectModel model, ElExpression binding) {
        RadioGroup radioGroup = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName + "_container");

        if (forComponent.getPage()._isRewindingForm(form)) {
            radioGroup = (RadioGroup)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (radioGroup == null) {
            radioGroup = new RadioGroup(forComponent, elementName, id, model, binding);
            forComponent.getPage()._getComponentStore().addComponent(radioGroup);
        }

        return radioGroup;
    }


    public Submit submit(String elementName) {
        Submit submit = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            submit = (Submit)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (submit == null) {
            submit = new Submit(forComponent, elementName, id);
            forComponent.getPage()._getComponentStore().addComponent(submit);
        }

        return submit;
    }

    public Submit imageSubmit(String elementName, String src) {
        Submit submit = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            submit = (Submit)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (submit == null) {
            submit = new Submit(forComponent, elementName, id);
            submit.attributes("type", "image", "src", src);
            forComponent.getPage()._getComponentStore().addComponent(submit);
        }

        return submit;
    }

    public Submit reset(String elementName) {
        Submit submit = null;

        Form form = forComponent._getForm(true);

        if (form == null)
            throw new WheelException("Form elements can be created only by compoents that are attached to a form component.", forComponent);

        String id = ensureFormElementUniqueness(form, elementName);

        if (forComponent.getPage()._isRewindingForm(form)) {
            submit = (Submit)forComponent.getPage()._getComponentStore().getComponent(id);
        }
        if (submit == null) {
            submit = new Submit(forComponent, elementName, id);
            submit.attribute("type", "reset");
            forComponent.getPage()._getComponentStore().addComponent(submit);
        }

        return submit;
    }


    public Block placeholder(String placeholderId) {
        Block block = new Block(forComponent, placeholderId);
        block.renderSelf = false;
        return block;
    }


    public Table table() {
        Table table = new Table(forComponent, null);
        return table;
    }


    public Any wAny(CharSequence renderHint) {
        Any any = new Any(forComponent, renderHint);
        return any;
    }


    public Link wLink(String action, Object text) {
        Link link = new Link(forComponent, text);
        link.action(action);
        return link;
    }


    public Block wBlock() {
        Block block = new Block(forComponent, null);
        return block;
    }

    public Component caption() {
        throw new WheelException("Thead component can be added only to a Table.", forComponent);
    }


    public Component thead() {
        throw new WheelException("Thead component can be added only to a Table.", forComponent);
    }


    public Component colgroup() {
        throw new WheelException("Colgroup component can be added only to a Table.", forComponent);
    }


    public Component col() {
        throw new WheelException("Col component can be added only to a TableBlock.", forComponent);
    }


    public Component tbody() {
        throw new WheelException("Tbody component can be added only to a Table.", forComponent);
    }


    public Component tfoot() {
        throw new WheelException("Tfoot component can be added only to a Table.", forComponent);
    }


    public Component tr() {
        throw new WheelException("Tr component can be added only to a TableBlock.", forComponent);
    }


    public Component td() {
        throw new WheelException("Td component can be added only to a TableRow.", forComponent);
    }


    public Component th() {
        throw new WheelException("Th component can be added only to a TableRow.", forComponent);
    }

    //TODO
    public Component link() {
        Block link = new Block(forComponent);
        link.renderHint("link");
        return link;
    }

    public Component meta() {
        Any meta = new Any(forComponent, "meta");
        return meta;
    }


    public Component img(CharSequence url, CharSequence alt) {
        Image image = new Image(forComponent, url, alt);
        return image;
    }


    public Component block(CharSequence renderHint) {
        Block block = new Block(forComponent, "");
        block.renderHint(renderHint);
        return block;
    }

    //TODO
    public Component label() {
        Block label = new Block(forComponent);
        label.renderHint("label");
        return label;
    }

    //TODO
    public Component label(Object text) {
        Label label = new Label(forComponent, text);
        label.renderHint("label");
        return label;
    }


    //TODO
    public Component legend() {
        Block legend = new Block(forComponent);
        legend.renderHint("legend");
        return legend;
    }

    //TODO
    public Component legend(Object text) {
        Label legend = new Label(forComponent, text);
        legend.renderHint("legend");
        return legend;
    }

    public Component map(String id) {
        Block map = new Block(forComponent, id);
        map.renderHint("map");
        return map;
    }

    public Component noframes() {
        Block noframes = new Block(forComponent);
        noframes.renderHint("noframes");
        Block body = new Block(noframes);
        body.renderHint("body");
        noframes.add(body);

        return body;
    }

    public Component noscript() {
        Block noscript = new Block(forComponent);
        noscript.renderHint("noscript");
        return noscript;
    }

    public Component object() {
        Block object = new Block(forComponent);
        object.renderHint("object");
        return object;
    }

    public Component param(CharSequence name) {
        Any param = new Any(forComponent, "param");
        param.attribute("name", name);
        return param;
    }

    //TODO
    public Component pre() {
        Block pre = new Block(forComponent);
        pre.renderHint("pre");
        return pre;
    }

    //TODO
    public Component pre(Object text) {
        Label pre = new Label(forComponent, text);
        pre.renderHint("pre");
        return pre;
    }

    //TODO
    public Component q() {
        Block q = new Block(forComponent);
        q.renderHint("q");
        return q;
    }

    //TODO
    public Component q(Object text) {
        Label q = new Label(forComponent, text);
        q.renderHint("q");
        return q;
    }

    //TODO
    public Component s() {
        Block s = new Block(forComponent);
        s.renderHint("s");
        return s;
    }

    //TODO
    public Component s(Object text) {
        Label s = new Label(forComponent, text);
        s.renderHint("s");
        return s;
    }

    //TODO
    public Component samp() {
        Block samp = new Block(forComponent);
        samp.renderHint("samp");
        return samp;
    }

    //TODO
    public Component samp(Object text) {
        Label samp = new Label(forComponent, text);
        samp.renderHint("samp");
        return samp;
    }

    //TODO
    public Component small() {
        Block small = new Block(forComponent);
        small.renderHint("small");
        return small;
    }

    //TODO
    public Component small(Object text) {
        Label small = new Label(forComponent, text);
        small.renderHint("small");
        return small;
    }

    //TODO
    public Component strike() {
        Block strike = new Block(forComponent);
        strike.renderHint("strike");
        return strike;
    }

    //TODO
    public Component strike(Object text) {
        Label strike = new Label(forComponent, text);
        strike.renderHint("strike");
        return strike;
    }

    //TODO
    public Component style() {
        Block style = new Block(forComponent);
        style.renderHint("style");
        return style;
    }

    //TODO
    public Component sub() {
        Block sub = new Block(forComponent);
        sub.renderHint("sub");
        return sub;
    }

    //TODO
    public Component sub(Object text) {
        Label sub = new Label(forComponent, text);
        sub.renderHint("sub");
        return sub;
    }

    //TODO
    public Component sup() {
        Block sup = new Block(forComponent);
        sup.renderHint("sup");
        return sup;
    }

    //TODO
    public Component sup(Object text) {
        Label sup = new Label(forComponent, text);
        sup.renderHint("sup");
        return sup;
    }

     //TODO
    public Component tt() {
        Block tt = new Block(forComponent);
        tt.renderHint("tt");
        return tt;
    }

    //TODO
    public Component tt(Object text) {
        Label tt = new Label(forComponent, text);
        tt.renderHint("tt");
        return tt;
    }

    //TODO
    public Component u() {
        Block u = new Block(forComponent);
        u.renderHint("u");
        return u;
    }

    //TODO
    public Component u(Object text) {
        Label u = new Label(forComponent, text);
        u.renderHint("u");
        return u;
    }

    //TODO
    public Component var() {
        Block var = new Block(forComponent);
        var.renderHint("var");
        return var;
    }

    //TODO
    public Component var(Object text) {
        Label var = new Label(forComponent, text);
        var.renderHint("var");
        return var;
    }

    public Component a(Object text) {
        Link link = new Link(forComponent, text);
        return link;
    }

    public Component a() {
        Link link = new Link(forComponent, null);
        return link;
    }

    public Component em() {
        Block em = new Block(forComponent);
        em.renderHint("em");
        return em;
    }

    public Component em(Object text) {
        Label em = new Label(forComponent, text);
        em.renderHint("em");
        return em;
    }

    public Component strong() {
        Block strong = new Block(forComponent);
        strong.renderHint("strong");
        return strong;
    }

    public Component strong(Object text) {
        Label strong = new Label(forComponent, text);
        strong.renderHint("strong");
        return strong;
    }

    public Block wBlock(CharSequence renderHint) {
        Block block = new Block(forComponent);
        block.renderHint(renderHint);
        return block;
    }

    public Label wLabel(CharSequence renderHint, Object text) {
        Label label = new Label(forComponent, text);
        label.renderHint(renderHint);
        return label;
    }

    private String ensureFormElementUniqueness(Form form, String formElementName) {
        String id = formElementName;
        int counter = 2;
        Set<FormElement> elements = form.getPage().isPageRewinding() ? form.getRewindFormElements() : form.getFormElements();
        boolean found = false;

        do {
            found = false;

            for (FormElement element : elements) {
                if (element.getComponentId().equals(wrapComponentId(id, form))) {
                    found = true;
                    break;
                }
            }

            if (found)
                id = formElementName + counter++;

        } while(found);

        return wrapComponentId(id, form);
    }

    private String wrapComponentId(String componentId, Form form) {
        StringBuilder sb = new StringBuilder();

        if (form.getPage().wrapFormIds) {
            sb.append(form.getComponentId()).append("_");
        }

        sb.append(componentId);

        return sb.toString();
    }
}
