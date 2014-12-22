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
package wheel.enhance;

import wheel.asm.AnnotationVisitor;
import wheel.persistence.Scope;


public class WheelAnnotationVisitor implements AnnotationVisitor {
    private AnnotationVisitor annotationVisitor;
    private Scope scope;
    private boolean rebuild;

    public WheelAnnotationVisitor(AnnotationVisitor annotationVisitor) {
        this.annotationVisitor = annotationVisitor;
    }

    public void visit(String name, Object value) {
        if (name.equals("rebuild"))
            rebuild = ((Boolean)value).booleanValue();

    }

    public void visitEnum(String name, String desc, String value) {
        scope = Scope.valueOf(value);
    }

    public AnnotationVisitor visitAnnotation(String string, String string1) {
       return annotationVisitor.visitAnnotation(string, string1);
    }

    public AnnotationVisitor visitArray(String string) {
        return annotationVisitor.visitArray(string);
    }

    public void visitEnd() {
        annotationVisitor.visitEnd();
    }


    public Scope getScope() {
        return scope;
    }

    public boolean isRebuild() {
        return rebuild;
    }
}
