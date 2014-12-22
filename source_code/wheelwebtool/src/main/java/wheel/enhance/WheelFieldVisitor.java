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

import wheel.WheelException;
import wheel.asm.AnnotationVisitor;
import wheel.asm.Attribute;
import wheel.asm.FieldVisitor;
import wheel.asm.Opcodes;
import wheel.persistence.Scope;

import java.util.List;

public class WheelFieldVisitor implements FieldVisitor {
    private FieldVisitor fieldVisitor;
    private WheelAnnotationVisitor wheelAnnotationVisitor;
    private List<WheelAnnotatedField> wheelAnnotatedFields;
    private int access;
    private String name;
    private String desc;
    private String signature;

    public WheelFieldVisitor(FieldVisitor fieldVisitor, List<WheelAnnotatedField> wheelAnnotatedFields, int access, String name, String desc, String signature) {
        this.fieldVisitor = fieldVisitor;
        this.wheelAnnotatedFields = wheelAnnotatedFields;
        this.access = access;
        this.name = name;
        this.desc = desc;
        this.signature = signature;
    }

    public AnnotationVisitor visitAnnotation(String name, boolean visible) {
        if (name.equals("Lwheel/annotations/Persist;")) {
            wheelAnnotationVisitor = new WheelAnnotationVisitor(fieldVisitor.visitAnnotation(name, visible));
            return wheelAnnotationVisitor;
        }

        return fieldVisitor.visitAnnotation(name, visible);
    }

    public void visitAttribute(Attribute attribute) {
        fieldVisitor.visitAttribute(attribute);
    }

    public void visitEnd() {
        if (wheelAnnotationVisitor != null) {

            if (access != Opcodes.ACC_PRIVATE)
                throw new WheelException("Persistent field " + name + " must have private access.", null);

            //if (desc.startsWith("["))
            //    throw new WheelException("Field " + name + " is an array type. Arrays are not supported currently. Use Collections instead.", null);

            WheelAnnotatedField field = new WheelAnnotatedField(name, desc, signature, wheelAnnotationVisitor.getScope());

            if (wheelAnnotationVisitor.getScope() == null)
                field.setScope(Scope.component);

            wheelAnnotatedFields.add(field);
        }
        else {
            if (access == Opcodes.ACC_PRIVATE) {
                //if (desc.startsWith("["))
                //    throw new WheelException("Field " + name + " is an array type. Arrays are not supported currently. Use Collections instead.", null);

                WheelAnnotatedField field = new WheelAnnotatedField(name, desc, signature, Scope.request);
                wheelAnnotatedFields.add(field);
            }
        }

        fieldVisitor.visitEnd();
    }

    public WheelAnnotationVisitor getPersistAnnotationVisitor() {
        return wheelAnnotationVisitor;
    }
}
