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

import wheel.components.ElExpression;
import wheel.components.StandaloneComponent;

import java.io.Serializable;
import java.util.*;

public class LinkToDomain implements Serializable {
    private ElExpression fieldName;
    private ElExpression elExpression;
    private int hashCode;


    public LinkToDomain(ElExpression fieldName, ElExpression elExpression) {
        this.fieldName = fieldName;
        this.elExpression = elExpression;

        this.fieldName.errorMessage("Could not evaluate expression " + this.fieldName + " to access field.");
        this.elExpression.errorMessage("Could not evaluate expression " + this.elExpression + " to access linked domain object.");
    }

    public ElExpression getFieldName() {
        return fieldName;
    }

    public ElExpression getElExpression() {
        return elExpression;
    }

    public int getHashCode() {
        return hashCode;
    }


    public Object getCopy(StandaloneComponent topLevelComponent) {
        Object domainValue = null;

        try {
            domainValue = elExpression.eval(topLevelComponent, topLevelComponent);
        } catch (Exception e) {}

        if (domainValue != null)
            hashCode = domainValue.hashCode();

        if (domainValue == null)
            return null;

        return copyObject(domainValue);
    }

    public void writeToDomain(StandaloneComponent topLevelComponent) {
        Object fieldValue = fieldName.eval(topLevelComponent, topLevelComponent);
        
        fieldValue = copyObject(fieldValue);
        
        //TODO this might be a bit too optimistic solution
        if (fieldValue.hashCode() == hashCode)
            return;

        hashCode = fieldValue.hashCode();

        if (fieldValue instanceof Collection) {
            Collection collection = (Collection)fieldValue;
            Object[] asArray = collection.toArray();

            for (int i = 0; i < asArray.length; i++) {
                Object o = asArray[i];
                new ElExpression(elExpression.getExpression() + "[" + i + "]").store(topLevelComponent, topLevelComponent, o);
            }
        } else if (fieldValue instanceof Map) {
            Map map = (Map)fieldValue;

            for (Object key : map.keySet()) {
                Object value = map.get(key);
                new ElExpression(elExpression.getExpression() + "[" + key + "]").store(topLevelComponent, topLevelComponent, value);
            }
        }
        else
            elExpression.store(topLevelComponent, topLevelComponent, fieldValue);
    }

    public void copyFromDomain(StandaloneComponent topLevelComponent) {
        Object domainValue = getCopy(topLevelComponent);


        fieldName.store(topLevelComponent, topLevelComponent, domainValue);
    }

    private Object copyObject(Object obj) {
        if (obj instanceof Date)
            return new Date(((Date)obj).getTime());
        else if (obj instanceof Calendar) {
            Calendar copy = new GregorianCalendar();
            copy.setTimeInMillis(((Calendar)obj).getTimeInMillis());
            return copy;
        } else if (obj instanceof List) {
            List copy = new LinkedList();

            List original = (List)obj;

            for (Object o : original) {
                copy.add(copyObject(o));
            }

            return copy;
        } else if (obj instanceof Set) {
            Set copy = new HashSet();

            Set original = (Set)obj;

            for (Object o : original) {
                copy.add(copyObject(o));
            }

            return copy;
        } else if (obj instanceof Map) {
            Map copy = new HashMap();

            Map original = (Map)obj;

            for (Object key : original.keySet()) {
                copy.put(key, copyObject(original.get(key)));
            }

            return copy;
        } else if (obj instanceof Integer) {
            return new Integer(((Integer)obj).intValue());
        } else if (obj instanceof Double) {
            return new Double(((Double)obj).doubleValue());
        } else if (obj instanceof Short) {
            return new Short(((Short)obj).shortValue());
        } else if (obj instanceof Boolean) {
            return new Boolean(((Boolean)obj).booleanValue());
        } else if (obj instanceof Float) {
            return new Float(((Float)obj).floatValue());
        } else if (obj instanceof Long) {
            return new Long(((Long)obj).longValue());
        } else if (obj instanceof Character) {
            return new Character(((Character)obj).charValue());
        } else if (obj instanceof Byte) {
            return new Byte(((Byte)obj).byteValue());
        } else if (obj instanceof String)
            return new String((String)obj);

        return obj;
    }
}
