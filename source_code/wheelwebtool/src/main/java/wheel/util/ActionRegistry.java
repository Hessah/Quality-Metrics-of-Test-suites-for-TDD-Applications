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

import wheel.components.Component;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class ActionRegistry {
    private Set<Entry> entries = new HashSet<Entry>();

    public Entry addEntry(String methodName, String className, boolean rebuild) {
        Entry entry = new Entry(methodName, className, rebuild);
        entries.add(entry);
        return entry;
    }

    public boolean isActionMethod(Component component, String methodName) {
        List<String> classNames = new LinkedList<String>();

        Class clazz = component.getClass();

        while (clazz != null && !clazz.getName().equals("wheel.components.StandaloneComponent")) {
            classNames.add(clazz.getName().replace('.', '/'));
            clazz = clazz.getSuperclass();
        }

        for (Entry entry : entries) {
            if (classNames.contains(entry.className) && entry.methodName.equals(methodName))
                return true;
        }

        return false;
    }

    public boolean needsRebuilding(Component component, String methodName) {
        for (Entry entry : entries) {
            if (entry.className.equals(component.getClass().getName()) && entry.methodName.equals(methodName) && entry.rebuild)
                return true;
        }

        return false;
    }
}

class Entry {
    String methodName;
    String className;
    boolean rebuild;

    Entry(String methodName, String className, boolean rebuild) {
        this.methodName = methodName;
        this.className = className;
        this.rebuild = rebuild;
    }
}
