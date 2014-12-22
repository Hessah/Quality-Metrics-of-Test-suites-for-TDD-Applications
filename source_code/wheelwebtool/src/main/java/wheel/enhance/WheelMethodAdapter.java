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

import wheel.asm.*;
import wheel.util.ActionRegistry;

import java.util.List;
import java.util.Set;

public class WheelMethodAdapter extends MethodAdapter implements Opcodes {
    private List<WheelAnnotatedField> wheelAnnotatedFields;
    private boolean persistentFieldMutator;
    private boolean getter;
    private WheelAnnotatedField wheelAnnotatedField;
    private Label lastLabel;
    private boolean aloadSeen;
    private boolean getFieldSeen;
    private boolean fieldReturned;
    private boolean generatedBytecode;
    private String methodName;
    private Set<String> actionRegistry;
    private String className;
    private WheelAnnotationVisitor wheelAnnotationVisitor;
    private MethodVisitor methodVisitor;

    public WheelMethodAdapter(final wheel.asm.MethodVisitor mv, List<WheelAnnotatedField> wheelAnnotatedFields, String methodName, Set<String> actionRegistry, String className) {
        super(mv);
        this.methodVisitor = mv;
        this.wheelAnnotatedFields = wheelAnnotatedFields;
        this.methodName = methodName;
        this.actionRegistry = actionRegistry;
        this.className = className;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, boolean visible) {
        if (name.equals("Lwheel/annotations/ActionMethod;")) {
            wheelAnnotationVisitor = new WheelAnnotationVisitor(methodVisitor.visitAnnotation(name, visible));
            return wheelAnnotationVisitor;
        }

        return super.visitAnnotation(name, visible);
    }

    @Override
    public void visitIntInsn(final int opcode, final int operand) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitTypeInsn(final int opcode, final String type) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitMethodInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitJumpInsn(final int opcode, final Label label) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLdcInsn(final Object cst) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitLdcInsn(cst);
    }

    @Override
    public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label[] labels) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(final String desc, final int dims) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitMultiANewArrayInsn(desc, dims);
    }

    @Override
    public void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String type) {
        aloadSeen = false;
        getFieldSeen = false;
        super.visitTryCatchBlock(start, end, handler, type);
    }

    @Override
    public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
        if (!persistentFieldMutator && (opcode == GETFIELD || opcode == PUTFIELD)) {
            for (WheelAnnotatedField wheelAnnotatedField : wheelAnnotatedFields) {
                if (name.equals(wheelAnnotatedField.getName())) {
                    this.wheelAnnotatedField = wheelAnnotatedField;

                    if (opcode == GETFIELD) {
                        visitMethodInsn(INVOKEVIRTUAL, owner, wheelAnnotatedField.getGetterName(), "()" + wheelAnnotatedField.getDesc());
                        return;
                    }
                    else if (opcode == PUTFIELD) {
                        visitMethodInsn(INVOKEVIRTUAL, owner, wheelAnnotatedField.getSetterName(), "(" + wheelAnnotatedField.getDesc() +")V");
                        return;
                    }
                }
            }

            super.visitFieldInsn(opcode, owner, name, desc);
        }
        else {
            if (aloadSeen && opcode == GETFIELD && name.equals(wheelAnnotatedField.getName()))
                getFieldSeen = true;
            else
                aloadSeen = false;

            super.visitFieldInsn(opcode, owner, name, desc);
        }
    }


    @Override
    public void visitInsn(final int opcode) {
        if ((opcode == RETURN || opcode == ARETURN || opcode == IRETURN || opcode == FRETURN || opcode == LRETURN || opcode == DRETURN) && getFieldSeen)
            fieldReturned= true;
        else {
            aloadSeen = false;
            getFieldSeen = false;
        }

        super.visitInsn(opcode);
    }


    @Override
    public void visitVarInsn(final int opcode, final int var) {
        aloadSeen = false;
        getFieldSeen = false;

        if (getter && var > 0 && !generatedBytecode) {
            super.visitVarInsn(opcode, var + 1);
            return;
        }

        if (opcode == ALOAD && var == 0)
            aloadSeen = true;

        super.visitVarInsn(opcode, var);
    }


    @Override
    public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index) {
        if (persistentFieldMutator) {
            if (name.equals("this"))
                super.visitLocalVariable(name, desc, signature, wheelAnnotatedField.getStartLabel(), end, index);
            else if (getter)
                super.visitLocalVariable(name, desc, signature, start, end, index + 1);
            else
                super.visitLocalVariable(name, desc, signature, start, end, index);
        }
        else
            super.visitLocalVariable(name, desc, signature, start, end, index);
    }


    @Override
    public void visitLabel(final Label label) {
        lastLabel = label;
        super.visitLabel(label);
    }

    @Override
    public void visitMaxs(final int maxStack, final int maxLocals) {
        if (persistentFieldMutator) {
            if (getter) {
                if (!aloadSeen)
                    visitIntInsn(ALOAD, 0);

                if (!getFieldSeen)
                    visitFieldInsn(GETFIELD, wheelAnnotatedField.getOwnerClassName(), wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc());

                if (!fieldReturned)
                    visitInsn(wheelAnnotatedField.getReturnOpCode());

                super.visitLocalVariable("___lcl", wheelAnnotatedField.getWrapperTypeInternal(), wheelAnnotatedField.getSignature(), wheelAnnotatedField.getStartLabel(), lastLabel, 1);

                if (maxStack < wheelAnnotatedField.getMaxStackSizeForGetter())
                    super.visitMaxs(wheelAnnotatedField.getMaxStackSizeForGetter(), maxLocals + 1);
                else
                    super.visitMaxs(maxLocals, maxLocals + 1);
            }
            else {
                if (maxStack < wheelAnnotatedField.getMaxStackSizeForSetter())
                    super.visitMaxs(wheelAnnotatedField.getMaxStackSizeForSetter(), maxLocals);
                else
                    super.visitMaxs(maxLocals, maxLocals);
            }

            return;
        }

        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();

        if (wheelAnnotationVisitor != null)
            actionRegistry.add(methodName + ":" + className + ":" + wheelAnnotationVisitor.isRebuild());
    }

    public void setPersistentFieldMutator(boolean persistentFieldMutator) {
        this.persistentFieldMutator = persistentFieldMutator;
    }


    public void setPersistentField(WheelAnnotatedField wheelAnnotatedField) {
        this.wheelAnnotatedField = wheelAnnotatedField;
    }


    public void setGetter(boolean getter) {
        this.getter = getter;
    }


    public void setGeneratedBytecode(boolean generatedBytecode) {
        this.generatedBytecode = generatedBytecode;
    }
}
