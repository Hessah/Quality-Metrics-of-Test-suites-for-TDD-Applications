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

public class ActionExpression extends Expression {
    private String updateTargetId;
    private Component owner;
    private String event;
    private String javascript;
    private Component updateTarget;
    private boolean submitForm = true;
    private List<String> parameters;
    private boolean submissible;

    public ActionExpression(String expression) {
        super(expression);
    }

    public ActionExpression submitForm(boolean submitForm) {
        this.submitForm = submitForm;
        return this;
    }

    public ActionExpression updateComponent(String componentId) {
        this.updateTargetId = componentId;
        return this;
    }

    public ActionExpression event(String event) {
        this.event = event;
        return this;
    }

    public ActionExpression setOwner(Component owner) {
        this.owner = owner;
        return this;
    }

    public ActionExpression javascript(String javascript) {
        this.javascript = javascript;
        return this;
    }


    public String getActionUrl() {
        StringBuffer actionUrl = new StringBuffer(resolveAction(expression));

        boolean questionMarkUsed = false;

        if (parameters != null) {
            for (int i = 0; i < parameters.size(); i++) {
                String param = (String) parameters.get(i);

                if (i == 0) {
                    actionUrl.append("?0=");
                    questionMarkUsed = true;
                }

                else
                    actionUrl.append("&").append(i).append("=");

                actionUrl.append(owner.encode(param));
            }
        }

        if (updateTargetId != null) {
            if (questionMarkUsed)
                actionUrl.append("&");
            else
                actionUrl.append("?");

            actionUrl.append("updateTargetId=").append(updateTargetId);
        }

        return actionUrl.toString();
    }

    public String getUpdateTargetId() {
        if (updateTargetId != null)
            updateTargetId = owner._wrapComponentId(updateTargetId) + "_wrapper";

        StandaloneComponent topLevelComponent = owner._getTopLevelComponent(true);

        if (topLevelComponent.config().isAjaxComponent())
            updateTargetId = topLevelComponent.getComponentId();

        return updateTargetId;
    }

    public String getActionExpression() {
        return expression;
    }

    private String resolveAction(String expression) {
        if (expression.indexOf("://") != -1)
            return expression;

        expression = owner.eval(expression);

        StandaloneComponent topLevelComponent = owner._getTopLevelComponent(true);

        if (!(topLevelComponent.isPage())) {
            if (expression.startsWith("this"))
                expression = expression.replace("this", owner.getPage().getPagePath() + "$" + topLevelComponent.getComponentId());
            else if (expression.startsWith("page"))
                expression = expression.replace("page", owner.getPage().getPagePath());
        }
        else {
            if (expression.startsWith("this"))
                expression = expression.replace("this", owner.getPage().getPagePath());
        }

        return expression;
    }

    public String extractMethod() {
        String method = expression.replace("this.", "");
        method = method.replace("page.", "");

        return method;
    }

    public String extractComponent() {
        StandaloneComponent topLevelComponent = owner._getTopLevelComponent(true);

        if (!topLevelComponent.isPage() && expression.contains("this.")) {
            return topLevelComponent.getComponentId();
        }

        return "";
    }

    public String getStrippedDomEvent() {
        return event.substring(2, event.length()).toLowerCase();
    }

    public String getSourceId() {
        return owner.getComponentId();
    }

    public String getEvent() {
        return event;
    }

    public boolean isSubmitForm() {
        return submitForm;
    }


    public String getJavascript() {
        return javascript;
    }

    public Component getUpdateTarget() {
        if (updateTarget == null)
            updateTarget = owner.getPage().find(updateTargetId);

        return updateTarget;
    }

    public String getUpdateComponentFunctionCall() {
        if (javascript == null)
            return "$('#" + getUpdateTarget().getComponentId() + "').load('" + getActionUrl() + "');";

        return "$('#" + getUpdateTarget().getComponentId() + "').load('" + getActionUrl() + "', " + javascript + ");";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionExpression action = (ActionExpression) o;

        if (expression != null ? !expression.equals(action.expression) : action.expression != null)
            return false;
        if (event != null ? !event.equals(action.event) : action.event != null) return false;
        if (javascript != null ? !javascript.equals(action.javascript) : action.javascript != null) return false;
        if (updateTargetId != null ? !updateTargetId.equals(action.updateTargetId) : action.updateTargetId != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (updateTargetId != null ? updateTargetId.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (javascript != null ? javascript.hashCode() : 0);
        return result;
    }

    public boolean isExternalUrl() {
        return expression.indexOf("://") != -1;
    }

    public ActionExpression parameter(Object value) {
        if (parameters == null)
            parameters = new LinkedList<String>();

        parameters.add(value.toString());

        return this;
    }

    public ActionExpression parameters(Object... params) {
        if (parameters == null)
            parameters = new LinkedList<String>();

        for (int i = 0; i < params.length; i++) {
            Object param = params[i];

            if (param != null)
                parameters.add(param.toString());
        }

        return this;
    }

    public boolean isSubmissible() {
        return submissible;
    }

    public ActionExpression submissible(boolean submissible) {
        this.submissible = submissible;
        return this;
    }
}
