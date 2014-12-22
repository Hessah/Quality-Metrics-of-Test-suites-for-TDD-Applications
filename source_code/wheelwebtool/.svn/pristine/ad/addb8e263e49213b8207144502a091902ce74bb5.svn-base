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
package wheel;

import wheel.components.Component;
import wheel.components.StandaloneComponent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * Displays all unhandled exceptions if no error mapping or error page has been set in IEngine for the current request cycle.
 *
 * @author Henri Frilund
 */
public class ErrorPage extends StandaloneComponent {
    public void buildComponent() {
        config().setReusable(true);

        title("Application error");

        Component style = create().style();
        style.rawText("body {background: #d7cc80; font: 75%/1.419em Arial, Helvetica, Geneva, sans-serif; min-width: 630px;} \n" +
                "h1, h2, h3, h4, h5 {color: #666666} \n" +
                "h1 {padding-bottom: 20px;} \n" +
                "h5 {padding-left: 30px; line-height: 8px;} \n" +
                ".main {background-color: #eeeeee; margin: 6px; padding-top: 10px;} \n" +
                ".head {background-color: #eeeeee; margin: 5px; padding-left: 15px; } \n" +
                ".trace {background-color: #eeeeee; border: medium; margin: 10px; padding: 4px; padding-left: 15px;}");

        head().add(style);

        Throwable error = getEngine().getError();

        Component main = create().div().clasS("main");
        Component head = main.create().div().clasS("header");

        head.h1().b("Application error");
        
        if (error.getMessage() != null)
            head.h2("Reason: " + error.getMessage());

        if (error instanceof WheelException) {
            WheelException wheelException = (WheelException)error;

            if (wheelException.getSource() != null) {
                head.h3("Source:");
                head.h4().rawText(wheelException.getSource().toString());
                head.h4("Component class: " + wheelException.getSource().getClass().getName() + ", id: " + wheelException.getSource().getComponentId());

                try {
                    head.h4("Component container: " + wheelException.getSource()._getTopLevelComponent(false).getClass().getName() + ", id: " + wheelException.getSource()._getTopLevelComponent(false).getComponentId());
                } catch (Exception e) {}
            }
        }

        main.add(head);

        main.hr();

        Component requestData = create().div().clasS("trace");

        requestData.h3("Request data:");

        Map parameters = null;
        try {
            parameters = getEngine().getRequest().getParameterMap();
        } catch (Exception e) {}

        if (parameters != null && !parameters.isEmpty()) {
            for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                String[] value = (String[])parameters.get(key);

                StringBuffer sb = new StringBuffer(key + " = ");

                for (int i = 0; i < value.length; i++) {
                    String s = value[i];
                    sb.append(s);

                    if (i < value.length-1)
                        sb.append(", ");
                }

                requestData.h5(sb.toString());
            }
        }

        if (requestData._getChildren().size() > 1)
            main.add(requestData);

        Component sessionData = create().div().clasS("trace");

        sessionData.h3("Session data:");

        try {
            Enumeration sessionKeys = getEngine().getSession().getAttributeNames();

            if (sessionKeys != null) {
                while (sessionKeys.hasMoreElements()) {
                    String key = (String) sessionKeys.nextElement();

                    sessionData.h5(key + " = " + getEngine().getSession().getAttribute(key).toString());
                }
            }
        } catch (Exception e) {}

        if (sessionData._getChildren().size() > 1)
            main.add(sessionData);

        Component applicationData = create().div().clasS("trace");

        applicationData.h3("ServletContext data:");

        try {
            Enumeration contextKeys = getEngine().getContext().getAttributeNames();

            if (contextKeys != null) {
                while (contextKeys.hasMoreElements()) {
                    String key = (String) contextKeys.nextElement();

                    applicationData.h5(key + " = " + getEngine().getContext().getAttribute(key).toString());
                }
            }
        } catch (Exception e) {}

        if (applicationData._getChildren().size() > 1)
            main.add(applicationData);

        Component trace = main.create().div().clasS("trace");

        trace.h3("Stack trace:");

        Throwable t = error;

        trace.h4(t.getClass().getName() + " : " + t.getMessage());

        StackTraceElement[] stackTrace =  t.getStackTrace();

        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            trace.h5(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")");
        }

        while (t.getCause() != null) {
            t = t.getCause();
            trace.h4("Caused by: " + t.getClass().getName() + " : " + t.getMessage());

            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                trace.h5(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")");
            }
        }

        main.add(trace);

        add(main);
    }
}

