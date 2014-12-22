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

import wheel.IEngine;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class WheelURL {
    private String page;
    private String component;
    private String method;
    private boolean ajax;
    private boolean asset;
    private String updateTargetId;
    private String methodName;
    private Map parameters;

    public WheelURL(String path, Map parameters, IEngine engine) throws UnsupportedEncodingException {
        this.parameters = parameters;
        page = "";
        method = "";
        component = "";
        methodName = "";
        updateTargetId = "";

        if (path.startsWith("asset/"))
            asset = true;


        if (parameters.containsKey("updateTargetId")) {
            updateTargetId = ((String[])parameters.get("updateTargetId"))[0];
            ajax = true;
        }

        String[] pathSplit = path.split("\\$");
        page = pathSplit[0];

        if (pathSplit.length > 1) {
            component = pathSplit[1];
            String[] methodSplit = component.split("\\.");

            if (methodSplit.length > 1) {
                component = methodSplit[0];
                method = methodSplit[1];
            }

        }

        else {
            String[] methodSplit = page.split("\\.");

            if (methodSplit.length > 1) {
                page = methodSplit[0];
                method = methodSplit[1];
            }
        }

        if (method.length() > 0) {
            methodName = method;

            StringBuffer sb = new StringBuffer(method);
            sb.append("(");

            for (int i = 0; i < 10; i++) {
                String[] methodParam = (String[])parameters.get(i + "");

                if (methodParam != null) {
                    if (i > 0)
                        sb.append(",");

                    sb.append("'").append(URLDecoder.decode(methodParam[0], engine.getEncoding())).append("'");
                }
            }

            sb.append(")");
            method = sb.toString();

        }
        else {
            if (component.length() > 0)
                ajax = true;
        }
    }

    public boolean isAssetUrl() {
        return asset;
    }

    public boolean isAjaxUrl() {
        return ajax;
    }

    public String getPage() {
        return page;
    }

    public String getComponent() {
        return component;
    }

    public String getMethod() {
        return method;
    }

    public String getUpdateTargetId() {
        return updateTargetId;
    }

    public String getMethodName() {
        return methodName;
    }

    public Map getParameters() {
        return parameters;
    }
}
