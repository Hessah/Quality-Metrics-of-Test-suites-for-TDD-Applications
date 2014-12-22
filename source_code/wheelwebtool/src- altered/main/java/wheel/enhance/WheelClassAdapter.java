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
import wheel.asm.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WheelClassAdapter extends ClassAdapter implements Opcodes {
    private List<WheelAnnotatedField> wheelAnnotatedFields = new LinkedList<WheelAnnotatedField>();
    private String className;
    private Set<String> actionRegistry;
    private WheelClassLoader loader;
    private boolean enhance;

    public WheelClassAdapter(ClassVisitor classVisitor, Set<String> actionRegistry, WheelClassLoader loader) {
        super(classVisitor);
        this.actionRegistry = actionRegistry;
        this.loader = loader;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        WheelFieldVisitor fieldVisitor = new WheelFieldVisitor(super.visitField(access, name, desc, signature, value), wheelAnnotatedFields, access, name, desc, signature);

        return fieldVisitor;
    }


    @Override
    public void visit(final int version, final int access, final String name, final String signature, final String superName, final String[] interfaces) {
        className = name;

        Class superClass = null;
        try {
            superClass = loader.loadClass(superName.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            throw new WheelException("Could not load class '" + superName.replace('/', '.') + "'.", null);
        }

        while(!superClass.getName().equals("java.lang.Object")) {
            if (superClass.getName().equals("wheel.components.StandaloneComponent")) {
                enhance = true;
                break;
            }

            try {
                superClass = loader.loadClass(superClass.getSuperclass().getName());
            } catch (ClassNotFoundException e) {
                throw new WheelException("Could not load super class.", null);
            }
        }

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!enhance || name.equals("<init>"))
            return super.visitMethod(access, name, desc, signature, exceptions);

        WheelMethodAdapter mv = new WheelMethodAdapter(super.visitMethod(access,name,desc,signature,exceptions), wheelAnnotatedFields, name, actionRegistry, className);

        if (wheelAnnotatedFields != null && wheelAnnotatedFields.size() > 0) {

            for (WheelAnnotatedField wheelAnnotatedField : wheelAnnotatedFields) {
                wheelAnnotatedField.setOwnerClassName(className);

                if (name.equals(wheelAnnotatedField.getSetterName())) {
                    wheelAnnotatedField.setSetterAvailable(true);
                    mv.setPersistentFieldMutator(true);
                    mv.setPersistentField(wheelAnnotatedField);
                    mv.setGeneratedBytecode(true);
                    enhanceSetter(mv, wheelAnnotatedField);
                    mv.setGeneratedBytecode(false);
                }
                else if (name.equals(wheelAnnotatedField.getGetterName())) {
                    wheelAnnotatedField.setGetterAvailable(true);
                    mv.setPersistentFieldMutator(true);
                    mv.setGetter(true);
                    mv.setPersistentField(wheelAnnotatedField);
                    mv.setGeneratedBytecode(true);
                    enhanceGetter(mv, wheelAnnotatedField);
                    mv.setGeneratedBytecode(false);
                }
            }
        }

        return mv;
    }


    public List<WheelAnnotatedField> getPersistentFields() {
        return wheelAnnotatedFields;
    }

    private void enhanceSetter(MethodVisitor mv, WheelAnnotatedField wheelAnnotatedField) {
        Label start = new Label();

        mv.visitLabel(start);

        mv.visitIntInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKEVIRTUAL, className, "getEngine", "()Lwheel/IEngine;");
        mv.visitMethodInsn(INVOKEINTERFACE, "wheel/IEngine", "getObjectStore", "()Lwheel/persistence/IObjectStore;");
        mv.visitLdcInsn(wheelAnnotatedField.getName());

        mv.visitIntInsn(ALOAD, 0);
        //mv.visitMethodInsn(INVOKEVIRTUAL, className, "getPage", "()Lwheel/components/StandaloneComponent;");
        mv.visitMethodInsn(INVOKEVIRTUAL, "wheel/components/StandaloneComponent", "getPagePath", "()Ljava/lang/String;");

        if (wheelAnnotatedField.needsWrapping()) {
            mv.visitTypeInsn(NEW, wheelAnnotatedField.getWrapperType());
            mv.visitInsn(DUP);
            mv.visitIntInsn(wheelAnnotatedField.getLoadOpcode(), 1);
            mv.visitMethodInsn(INVOKESPECIAL, wheelAnnotatedField.getWrapperType(), "<init>", "(" + wheelAnnotatedField.getDesc() + ")V");
        }
        else {
            mv.visitIntInsn(ALOAD, 1);
        }

        mv.visitFieldInsn(GETSTATIC, "wheel/persistence/Scope", wheelAnnotatedField.getScope().toString(), "Lwheel/persistence/Scope;");
        mv.visitIntInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKEINTERFACE, "wheel/persistence/IObjectStore", "put", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lwheel/persistence/Scope;Lwheel/components/Component;)V");

        mv.visitIntInsn(ALOAD, 0);

        mv.visitIntInsn(wheelAnnotatedField.getLoadOpcode(), 1);

        mv.visitFieldInsn(PUTFIELD, className, wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc());

        wheelAnnotatedField.setStartLabel(start);

    }

    private void enhanceGetter(MethodVisitor mv, WheelAnnotatedField wheelAnnotatedField) {
        Label start = new Label();
        Label putfield = new Label();
        Label setDefaultValue = new Label();
        Label end = new Label();

        mv.visitLabel(start);

        mv.visitIntInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKEVIRTUAL, className, "getEngine", "()Lwheel/IEngine;");
        mv.visitMethodInsn(INVOKEINTERFACE, "wheel/IEngine", "getObjectStore", "()Lwheel/persistence/IObjectStore;");
        mv.visitLdcInsn(wheelAnnotatedField.getName());

        mv.visitIntInsn(ALOAD, 0);
        //mv.visitMethodInsn(INVOKEVIRTUAL, className, "getPage", "()Lwheel/components/StandaloneComponent;");
        mv.visitMethodInsn(INVOKEVIRTUAL, "wheel/components/StandaloneComponent", "getPagePath", "()Ljava/lang/String;");


        mv.visitLdcInsn(Type.getType(wheelAnnotatedField.getWrapperTypeInternal()));
        mv.visitIntInsn(ALOAD, 0);
        mv.visitFieldInsn(GETSTATIC, "wheel/persistence/Scope", wheelAnnotatedField.getScope().toString(), "Lwheel/persistence/Scope;");
        mv.visitMethodInsn(INVOKEINTERFACE, "wheel/persistence/IObjectStore", "get", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lwheel/components/Component;Lwheel/persistence/Scope;)Ljava/lang/Object;");
        mv.visitTypeInsn(CHECKCAST, wheelAnnotatedField.getWrapperType());
        mv.visitIntInsn(ASTORE, 1);

        mv.visitIntInsn(ALOAD, 1);
        mv.visitJumpInsn(IFNONNULL, putfield);

        if (wheelAnnotatedField.needsWrapping())
            mv.visitJumpInsn(GOTO, end);


        if (!wheelAnnotatedField.needsWrapping()) {
            mv.visitIntInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, className, wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc());
            mv.visitIntInsn(ASTORE, 1);
            mv.visitIntInsn(ALOAD, 1);
            mv.visitJumpInsn(IFNONNULL, setDefaultValue);


            //store the default value to ObjectStore
            mv.visitLabel(setDefaultValue);
            mv.visitIntInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, className, "getEngine", "()Lwheel/IEngine;");
            mv.visitMethodInsn(INVOKEINTERFACE, "wheel/IEngine", "getObjectStore", "()Lwheel/persistence/IObjectStore;");
            mv.visitLdcInsn(wheelAnnotatedField.getName());

            mv.visitIntInsn(ALOAD, 0);
            //mv.visitMethodInsn(INVOKEVIRTUAL, className, "getPage", "()Lwheel/components/StandaloneComponent;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "wheel/components/StandaloneComponent", "getPagePath", "()Ljava/lang/String;");

            mv.visitIntInsn(ALOAD, 1);

            mv.visitFieldInsn(GETSTATIC, "wheel/persistence/Scope", wheelAnnotatedField.getScope().toString(), "Lwheel/persistence/Scope;");
            mv.visitIntInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEINTERFACE, "wheel/persistence/IObjectStore", "putDefaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lwheel/persistence/Scope;Lwheel/components/Component;)V");
        }

        mv.visitLabel(putfield);

        mv.visitIntInsn(ALOAD, 0);
        mv.visitIntInsn(ALOAD, 1);

        if (wheelAnnotatedField.needsWrapping())
            mv.visitMethodInsn(INVOKEVIRTUAL, wheelAnnotatedField.getWrapperType(), wheelAnnotatedField.getNarrowingMethod(), "()" + wheelAnnotatedField.getDesc());

        mv.visitFieldInsn(PUTFIELD, className, wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc());


        mv.visitLabel(end);

        wheelAnnotatedField.setStartLabel(start);
    }


    @Override
    public void visitEnd() {
        if (enhance) {
            for (WheelAnnotatedField wheelAnnotatedField : wheelAnnotatedFields) {
                if (!wheelAnnotatedField.isGetterAvailable()) {
                    MethodVisitor mv = super.visitMethod(ACC_PUBLIC, wheelAnnotatedField.getGetterName(), "()" + wheelAnnotatedField.getDesc(), wheelAnnotatedField.getSignature(), null);
                    mv.visitCode();
                    enhanceGetter(mv, wheelAnnotatedField);
                    mv.visitIntInsn(ALOAD, 0);
                    mv.visitFieldInsn(GETFIELD, className, wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc());
                    mv.visitInsn(wheelAnnotatedField.getReturnOpCode());
                    Label l1 = new Label();
                    mv.visitLabel(l1);
                    mv.visitLocalVariable("this", "L" + className + ";", null, wheelAnnotatedField.getStartLabel(), l1, 0);
                    mv.visitLocalVariable("___lcl", wheelAnnotatedField.getWrapperTypeInternal(), wheelAnnotatedField.getSignature(), wheelAnnotatedField.getStartLabel(), l1, 1);
                    mv.visitEnd();
                    mv.visitMaxs(wheelAnnotatedField.getMaxStackSizeForGetter(), 2);

                }

                if (!wheelAnnotatedField.isSetterAvailable()) {
                    MethodVisitor mv = super.visitMethod(ACC_PUBLIC, wheelAnnotatedField.getSetterName(), "(" + wheelAnnotatedField.getDesc() + ")V", wheelAnnotatedField.getSignature(), null);
                    mv.visitCode();
                    Label l0 = new Label();
                    mv.visitLabel(l0);
                    enhanceSetter(mv, wheelAnnotatedField);
                    mv.visitInsn(RETURN);
                    Label l1 = new Label();
                    mv.visitLabel(l1);
                    mv.visitLocalVariable("this", "L" + className + ";", null, l0, l1, 0);
                    mv.visitLocalVariable(wheelAnnotatedField.getName(), wheelAnnotatedField.getDesc(), wheelAnnotatedField.getSignature(), l0, l1, 1);
                    mv.visitEnd();
                    mv.visitMaxs(wheelAnnotatedField.getMaxStackSizeForSetter(), wheelAnnotatedField.isWideNativeType() ? 3 : 2);
                }
            }
        }

        super.visitEnd();
    }
}
