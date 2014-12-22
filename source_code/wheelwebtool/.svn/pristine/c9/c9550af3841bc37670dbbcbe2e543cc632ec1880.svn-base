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
import org.mvel.PropertyAccessor;
import wheel.WheelException;
import wheel.util.WrappedException;

public class ElExpression extends Expression {
    private String errorMessage;

    public ElExpression(String expression) {
        super(expression);
    }

    public String getExpression() {
        return expression;
    }

    public Object eval(Object context, Component component) {
        try {
            return MVEL.eval(expression, context);
        } catch (Throwable e) {
            Throwable cause = e;

            while(cause.getCause() != null && (cause.getClass().getName().startsWith("java.lang.reflect") || cause.getClass().getName().startsWith("org.mvel")))
                cause = cause.getCause();

            if (cause.getClass().getName().startsWith("org.mvel"))
                throw new WheelException(errorMessage, e, component);

            if (cause != null && cause instanceof RuntimeException)
                throw (RuntimeException)cause;

            throw new WrappedException(cause, component);
        }
    }

    public void store(Object context, Component component, Object value) {
        try {
            PropertyAccessor.set(context, expression, value);
        } catch (Throwable e) {
            throw new WheelException("Could not bind property " + expression + " in class " + context.getClass().getName(), e, component);
        }
    }

    public ElExpression errorMessage(String message) {
        errorMessage = message;
        return this;
    }
}
