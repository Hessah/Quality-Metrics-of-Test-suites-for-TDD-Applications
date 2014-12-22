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
package wheel.persistence;

import wheel.components.Component;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


public class SessionStore implements IObjectStore {
    private HttpSession session;
    private Map<String,StoredObject> returnedObjects;


    public SessionStore(HttpSession session) {
        this.session = session;
        returnedObjects = new HashMap<String,StoredObject>();
    }

    public HttpSession getSession() {
        return session;
    }

    public Object get(String key, String page, Class clazz, Component component, Scope scope) {
        String sessionKey = createSessionIdentifier(key, page, component, scope);
        StoredObject storedObject = null;

        try {
            if (scope == Scope.session || scope == Scope.page || scope == Scope.component)
                storedObject = (StoredObject)session.getAttribute(sessionKey);
            else if (scope == Scope.request)
                storedObject = (StoredObject)component.getEngine().getRequest().getAttribute(sessionKey);
            else
                storedObject = (StoredObject)session.getServletContext().getAttribute(sessionKey);
        } catch (ClassCastException e) {
            //tomcat weirdness
        }

        if (storedObject == null) {
            storedObject = new StoredObject(null, scope, page, sessionKey);

            returnedObjects.put(sessionKey, storedObject);
            return null;
        }

        if (storedObject.getValue() != null)
            storedObject.setHashCode(storedObject.getValue().hashCode());

        if (scope != Scope.request)
            returnedObjects.put(sessionKey, storedObject);

        return storedObject.getValue();
    }

    public void put(String key, String page, Object object, Scope scope, Component component) {
        String sessionKey = createSessionIdentifier(key, page, component, scope);

        returnedObjects.remove(sessionKey);

        StoredObject storedObject = null;

        try {
            if (scope == Scope.session || scope == Scope.page || scope == Scope.component)
                storedObject = (StoredObject)session.getAttribute(sessionKey);
            else if (scope == Scope.request)
                storedObject = (StoredObject)component.getEngine().getRequest().getAttribute(sessionKey);
            else
                storedObject = (StoredObject)session.getServletContext().getAttribute(sessionKey);
        } catch (ClassCastException e) {
            //tomcat weirdness
        }


        if (storedObject == null)
            storedObject = new StoredObject(object, scope, page, sessionKey);
        else
            storedObject.setValue(object);


        if (scope == Scope.session || scope == Scope.page || scope == Scope.component)
            session.setAttribute(sessionKey, storedObject);
        else if (scope == Scope.request)
            component.getEngine().getRequest().setAttribute(sessionKey, storedObject);
        else {
            session.getServletContext().setAttribute(sessionKey, storedObject);
        }
    }


    public void putDefaultValue(String key, String page, Object object, Scope scope, Component component) {
        String sessionKey = createSessionIdentifier(key, page, component, scope);

        StoredObject storedObject = returnedObjects.get(sessionKey);
        storedObject.setValue(object);

        if (scope == Scope.session || scope == Scope.page || scope == Scope.component)
            storedObject = (StoredObject)session.getAttribute(sessionKey);
        else if (scope == Scope.request)
            storedObject = (StoredObject)component.getEngine().getRequest().getAttribute(sessionKey);
        else
            storedObject = (StoredObject)session.getServletContext().getAttribute(sessionKey);
    }

    public void evict(String key, String page, Component component, Scope scope) {
        session.setAttribute(createSessionIdentifier(key, page, component, scope), null);
        session.getServletContext().setAttribute(createSessionIdentifier(key, page, component, scope), null);
    }


    public void evictPage(String page) {
        Enumeration attributes = session.getAttributeNames();

        while (attributes.hasMoreElements()) {
            String name = (String) attributes.nextElement();

            if (name.startsWith("wheelData:" + Scope.page.toString())) {
                session.setAttribute(name, null);
            }
        }

    }

    private String createSessionIdentifier(String key, String page, Component component, Scope scope) {
        StringBuffer sb = new StringBuffer("wheelData:" + scope.toString() + ":");

        if (scope == Scope.component)
            sb.append(page).append(":");

        if (scope == Scope.component || scope == Scope.page || scope == Scope.request)
            sb.append(component.getComponentId() + ":");

        sb.append(key);


        return sb.toString();
    }


    public void cleanup() {
        if (!returnedObjects.isEmpty()) {
            for (StoredObject storedObject : returnedObjects.values()) {
                int hashCode = 0;

                if (storedObject.getValue() != null)
                    hashCode = storedObject.getValue().hashCode();

                if (hashCode != storedObject.getHashCode()) {
                    if (storedObject.getScope() != Scope.global)
                        session.setAttribute(storedObject.getKey(), storedObject);
                    else
                        session.getServletContext().setAttribute(storedObject.getKey(), storedObject);
                }

                storedObject.releaseLock();
            }

            returnedObjects.clear();
        }
    }

    public boolean stateChanged() {
        for (StoredObject storedObject : returnedObjects.values()) {
            int hashCode = 0;

            if (storedObject.getValue() != null)
                hashCode = storedObject.getValue().hashCode();

            if (hashCode != storedObject.getHashCode()) {
                return true;
            }
        }

        return false;
    }
}
