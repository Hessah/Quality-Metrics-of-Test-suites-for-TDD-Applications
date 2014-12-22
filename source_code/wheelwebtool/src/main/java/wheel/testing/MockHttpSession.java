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
package wheel.testing;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.*;

public class MockHttpSession implements HttpSession {
    private long creationTime;
    private String id;
    private long lastAccessedTime;
    private ServletContext context;
    private Map<String,Object> attributes;


    public MockHttpSession(ServletContext context) {
        this.context = context;
        creationTime = System.currentTimeMillis();
        attributes = new HashMap<String,Object>();
        id = "MockSession";
    }

    public long getCreationTime() {
        updateLastAccessedTime();
        return creationTime;
    }

    public String getId() {
        updateLastAccessedTime();
        return id;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public ServletContext getServletContext() {
        updateLastAccessedTime();
        return context;
    }

    public void setMaxInactiveInterval(int i) {
        updateLastAccessedTime();
    }

    public int getMaxInactiveInterval() {
        updateLastAccessedTime();
        return 0;
    }

    public HttpSessionContext getSessionContext() {
        updateLastAccessedTime();
        return null;
    }

    public Object getAttribute(String string) {
        updateLastAccessedTime();
        return attributes.get(string);
    }

    public Object getValue(String string) {
        updateLastAccessedTime();
        return getAttribute(string);
    }

    public Enumeration getAttributeNames() {
        updateLastAccessedTime();
        final Iterator keys = attributes.keySet().iterator();

        return new Enumeration() {
            public boolean hasMoreElements() {
                return keys.hasNext();
            }

            public Object nextElement() {
                return keys.next();
            }
        };
    }

    public String[] getValueNames() {
        updateLastAccessedTime();
        Set keys = attributes.keySet();
        return (String[])keys.toArray();
    }

    public void setAttribute(String string, Object object) {
        updateLastAccessedTime();
        attributes.put(string, object);
    }

    public void putValue(String string, Object object) {
        updateLastAccessedTime();
        setAttribute(string, object);
    }

    public void removeAttribute(String string) {
        updateLastAccessedTime();
        attributes.remove(string);
    }

    public void removeValue(String string) {
        updateLastAccessedTime();
        removeAttribute(string);
    }

    public void invalidate() {}

    public boolean isNew() {
        updateLastAccessedTime();
        return false;
    }

    private void updateLastAccessedTime() {
        lastAccessedTime = System.currentTimeMillis();
    }

    public void resetMock() {
        attributes.clear();
    }
}
