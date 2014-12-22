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

import org.mvel.MVEL;
import org.xmlpull.v1.XmlSerializer;
import wheel.WheelException;

import java.io.IOException;
import java.util.*;

/**
 * Represents an HTML form. Only complex components (instances of StandaloneComponent) can contain Forms.
 * @author Henri Frilund
 */
public class Form extends RenderableComponent implements IContainer, IBuildableComponent {
    public enum Method {GET, POST};
    private Method method = Method.POST;
    private Set<FormElement> formElements;
    private Set<FormElement> rewindFormElements;
    private List<ValidationRule> formValidationRules;
    private List<ValidationError> validationErrors;
    private ActionExpression action;
    private boolean built;

    Form(String componentId) {
        super(componentId);
    }

    Form(Component parent, String componentId, ActionExpression actionExpression) {
        super(parent, componentId);

        this.action = actionExpression.event("action");
        formElements = new HashSet<FormElement>();

        if (componentId == null || componentId.length() == 0)
            throw new IllegalArgumentException("A Form must always have a given componentId.");
    }


    public void buildComponent() {
        actionBinding(action);

        attribute("method", method.toString());

        FormElement hidden = create().hidden("wheelSubmitId").value(getComponentId());
        hidden.attribute("name", "wheelSubmitId");

        if (_getForm(false) != null) {
            renderSelf = false;
            hidden.renderSelf = false;
        }

        add(hidden);
    }

    public void preBuild() {}

    public void postBuild() {}

    public boolean _isBuilt() {
        return built;
    }

    public void _setBuilt(boolean built) {
        this.built = built;
    }

    /**
     * Sets the HTTP METHOD the form should use when submitted.
     * @param method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    public String defaultTagName() {
        return "form";
    }

    public ActionExpression getAction() {
        return action;
    }

    /**
     * Returns a list of fields in this form that are invalid. This information is available only when rewinding.
     * @return
     */
    public List<FormElement> getInvalidFields() {
        List<FormElement> result = new LinkedList<FormElement>();

        for (FormElement element : formElements) {
            if (!element.isValid())
                result.add(element);
        }

        return result;
    }

    /**
     * Returns false if the form containing complex component is rewinding and a form element with the given componentId is
     * found and the form element is not valid.
     * @param componentId
     * @return
     */
    public boolean isValid(String componentId) {
        if (_getTopLevelComponent(true).isRewinding()) {
            for (FormElement formElement : formElements) {
                if (formElement.getFormElementName().equals(componentId))
                    return formElement.isValid();
            }
        }

        return true;
    }

    /**
     * Returns true if the form is valid.
     * @return
     */
    public boolean isFormValid() {
        boolean valid = true;

        if (formValidationRules != null) {
            for (ValidationRule formValidationRule : formValidationRules) {

                Map vars = new HashMap();

                for (FormElement element : formElements) {
                    vars.put(element.getComponentId(), element);
                }

                vars.put("form", this);
                vars.put("formContainer", _getTopLevelComponent(true));

                Map otherVariables = _getTopLevelComponent(true).validationVariables;

                if (otherVariables != null)
                    vars.putAll(otherVariables);


                Boolean validB = null;

                try {
                    validB = (Boolean) MVEL.eval(formValidationRule.getElExpression(), Validations.getInstance(), vars);
                } catch (Throwable e) {
                    throw new WheelException("Validation expression " + formValidationRule.getElExpression() + " failed.", e, this);
                }

                if (!validB.booleanValue()) {
                    valid = false;

                    if (validationErrors == null)
                        validationErrors = new LinkedList<ValidationError>();

                    validationErrors.add(new ValidationError(eval(formValidationRule.getMessage()), this));
                }
            }
        }

        if (!getInvalidFields().isEmpty())
            valid = false;

        return valid;
    }

    /**
     * Lists all validation errors that were caused by erroneous evaluations of formValidationRules, added with addFormValidationRule().
     * @return
     */
    public List<ValidationError> getValidationErrors() {
        List<ValidationError> result = new LinkedList<ValidationError>();

        if (validationErrors != null)
            result.addAll(validationErrors);

        for (FormElement formElement : getInvalidFields()) {
            result.addAll(formElement.getErrors());
        }

        return result;
    }

    @Override
    public void _clear() {
        super._clear();

        if (validationErrors != null)
            validationErrors.clear();

        if (formValidationRules != null)
            formValidationRules.clear();

    }

    /**
     * Finds a FormElement from this Form with the given name.
     * @param fieldName
     * @return
     * @throws WheelException if no component was found with the given componentId.
     */
    public FormElement field(String fieldName) {
        for (FormElement formElement : formElements) {
            if (formElement.getFormElementName().equals(fieldName))
                return formElement;
        }

        throw new WheelException("Form field with name " + fieldName + " doesn't exist.", this);
    }


    /**
     * Returns all FormElements that this Form contains.
     * @return
     */
    public Set<FormElement> getFormElements() {
        return formElements;
    }


    @Override
    public Form id(String componentId) {
        return (Form)super.id(componentId);
    }


    @Override
    public Form renderHint(CharSequence renderHint) {
        return (Form)super.renderHint(renderHint);
    }

    /**
     * Adds a validation rule for the whole form. These validation are run after all fields are set (and validated).
     * All form elements are available in the el-expression.
     * @param elExpression
     * @param message
     * @return
     */
    public Form addFormValidationRule(String elExpression, String message) {
        if (formValidationRules == null)
            formValidationRules = new LinkedList<ValidationRule>();

        formValidationRules.add(new ValidationRule(elExpression, message));

        return this;
    }

    public Form addFormValidationError(String message) {
        if (validationErrors == null)
            validationErrors = new LinkedList<ValidationError>();

        validationErrors.add(new ValidationError(message, this));

        return this;
    }

    @Override
    public void _render(XmlSerializer serializer) throws IOException {
        for (FormElement element : formElements) {
            if (element instanceof FileInput) {
                attribute("enctype", "multipart/form-data");
                setMethod(Method.POST);
                break;
            }
        }

        boolean serialize = true;

        if (formValidationRules != null)
            serialize = false;

        for (FormElement formElement : formElements) {
            if (formElement.isComplex()) {
                serialize = false;
                break;
            }
        }

        if (_getForm(false) != null)
            serialize = false;

        if (serialize) {
            hidden("wheelSerializedForm").value(serialize());
        }

        super._render(serializer);
    }

    public void _renderActions(XmlSerializer serializer) throws IOException {
        if (_getActions() == null)
            return;

        for (ActionExpression action : _getActions()) {
            String domEvent = action.getEvent();

            if (domEvent == null)
                domEvent = defaultDomEvent();


            if (action.getUpdateTargetId() != null) {
                serializer.attribute("", domEvent, action.getUpdateComponentFunctionCall());
                continue;
            }

            if (action.getJavascript() != null) {
                serializer.attribute("", domEvent, action.getJavascript());
                continue;
            }

            if (domEvent.equals("action"))
                serializer.attribute("", domEvent, action.getActionUrl());
            else
                serializer.attribute("", domEvent, "window.location.href='" + action.getActionUrl() + "';");
        }
    }

    @Override
    protected String defaultDomEvent() {
        return "onsubmit";
    }

    Form addFormElement(FormElement element) {
        if (getPage().isPageRewinding())
            getRewindFormElements().add(element);

        formElements.add(element);

        return this;
    }

    Set<FormElement> getRewindFormElements() {
        if (rewindFormElements == null)
            rewindFormElements = new HashSet<FormElement>();

        return rewindFormElements;
    }

    private String serialize() {
        StringBuilder sb = new StringBuilder();

        StandaloneComponent top = _getTopLevelComponent(false);

        if (!top.isPage())
            sb.append(top.getComponentId()).append("|");
        else
            sb.append("|");

        sb.append(getComponentId()).append("|");

        Iterator<FormElement> formElementsI = formElements.iterator();

        while (formElementsI.hasNext()) {
            FormElement formElement = formElementsI.next();

            if (formElement.getFormElementName().equals("wheelSerializedForm") || formElement.getFormElementName().equals("wheelSubmitId"))
                continue;

            formElement.serialize(sb);

            if (formElementsI.hasNext())
                sb.append("|");
        }

        return sb.toString();
    }

    public Form _buildFromSerializedString(String[] split) {
        if (split.length > 2) {
            for (int i = 3; i < split.length; i++) {
                String s = split[i];
                add(deserializeFormElement(s));
            }
        }

        return this;
    }

    private  FormElement deserializeFormElement(String serializedString) {
        String[] split = serializedString.split("\\$\\$");

        String name = split[0];
        String binding = split[2];
        FormElement element = null;

        if (split[1].equals("Submit")) {
            element = create().submit(name);
        }
        else if (split[1].equals("Hidden")) {
            element = create().hidden(name);
        }
        else if (split[1].equals("Checkbox")) {
            element = create().hidden(name);
        }
        else if (split[1].equals("TextInput")) {
            element = create().textInput(name);
        }

        if (binding.startsWith("el:"))
            element.fieldBinding(binding.substring(3, binding.length()));
        else
            element.value(binding);


        if (split.length > 3) {
            for (int i = 3; i < split.length; i += 2) {
                String rule = split[i];
                String message = split[i+1];

                element.validationRule(rule, message.trim());
            }
        }

        return element;
    }

}
