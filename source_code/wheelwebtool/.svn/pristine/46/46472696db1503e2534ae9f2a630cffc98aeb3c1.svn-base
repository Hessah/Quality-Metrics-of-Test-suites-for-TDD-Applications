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

import java.io.Serializable;

public class StoredObject implements Serializable {
    private Object value;
    private Scope scope;
    private String pagename;
    private String key;
    private int hashCode;
    private boolean locked;


    public StoredObject(Object value, Scope scope, String key) {
        this.value = value;
        this.scope = scope;
        this.pagename = "";
        this.key = key;
    }


    public StoredObject(Object value, Scope scope, String pagename, String key) {
        this.value = value;
        this.scope = scope;
        this.key = key;

        if (pagename != null && pagename.length() > 0)
            this.pagename = pagename;
    }

    public Object getValue() {
        return value;
    }


    public void setValue(Object value) {
        this.value = value;
    }

    public Scope getScope() {
        return scope;
    }


    public String getPagename() {
        return pagename;
    }

    public int getHashCode() {
        return hashCode;
    }


    public void setHashCode(int hashCode) {
        if (locked)
            return;

        this.hashCode = hashCode;
        locked = true;
    }

    public String getKey() {
        return key;
    }

    public void releaseLock() {
        locked = false;
    }


    @Override
    public String toString() {
        return "StoredObject: [scope=" + scope.toString() + ", value=" + value.toString() + "]";
    }
}
