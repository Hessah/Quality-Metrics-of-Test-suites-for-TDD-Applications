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

import wheel.asm.Label;
import wheel.asm.Opcodes;
import wheel.persistence.Scope;

public class WheelAnnotatedField {
    private String name;
    private String desc;
    private String signature;
    private Scope scope;
    private boolean setterAvailable;
    private boolean getterAvailable;
    private Label startLabel;
    private int localVarIndex = -1;
    private String ownerClassName;


    public WheelAnnotatedField(String name, String desc, String signature, Scope scope) {
        this.name = name;
        this.scope = scope;
        this.desc = desc;
        this.signature = signature;

        if (scope == null)
            this.scope = Scope.session;
    }

    public String getName() {
        return name;
    }

    public Scope getScope() {
        return scope;
    }


    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public String getDesc() {
        return desc;
    }

    public String getSignature() {
        return signature;
    }

    public boolean isSetterAvailable() {
        return setterAvailable;
    }

    public void setSetterAvailable(boolean setterAvailable) {
        this.setterAvailable = setterAvailable;
    }

    public boolean isGetterAvailable() {
        return getterAvailable;
    }

    public void setGetterAvailable(boolean getterAvailable) {
        this.getterAvailable = getterAvailable;
    }

    public String getSetterName() {
        return "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length());
    }

    public String getGetterName() {
        if (desc.equals("Z"))
            return "is" + Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length());

        return "get" + Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length());
    }

    public boolean isGetterOrSetterForThisField(String methodName) {
        if (methodName.equals(getGetterName())) {
            getterAvailable = true;
            return true;
        }

        if (methodName.equals(getSetterName())) {
            setterAvailable = true;
            return true;
        }

        return false;
    }

    public int getLoadOpcode() {
        if (desc.equals("I") || desc.equals("C") || desc.equals("S") || desc.equals("Z") || desc.equals("B")) {
            return Opcodes.ILOAD;
        } else if (desc.equals("J")) {
            return Opcodes.LLOAD;
        } else if (desc.equals("F")) {
            return Opcodes.FLOAD;
        } else if (desc.equals("D")) {
            return Opcodes.DLOAD;
        } else if (desc.startsWith("L") || desc.startsWith("[")) {
           return Opcodes.ALOAD;
        }

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public int getStoreOpcode() {
        if (desc.equals("I") || desc.equals("C") || desc.equals("S") || desc.equals("Z") || desc.equals("B")) {
            return Opcodes.ISTORE;
        } else if (desc.equals("J")) {
            return Opcodes.LSTORE;
        } else if (desc.equals("F")) {
            return Opcodes.FSTORE;
        } else if (desc.equals("D")) {
            return Opcodes.DSTORE;
        } else if (desc.startsWith("L") || desc.startsWith("[")) {
           return Opcodes.ASTORE;
        }

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public int getReturnOpCode() {
        if (desc.equals("I") || desc.equals("C") || desc.equals("S") || desc.equals("Z") || desc.equals("B")) {
            return Opcodes.IRETURN;
        } else if (desc.equals("J")) {
            return Opcodes.LRETURN;
        } else if (desc.equals("F")) {
            return Opcodes.FRETURN;
        } else if (desc.equals("D")) {
            return Opcodes.DRETURN;
        } else if (desc.startsWith("L") || desc.startsWith("[")) {
           return Opcodes.ARETURN;
        }

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public String getWrapperType() {
        if (desc.equals("I")) {
            return "java/lang/Integer";
        } else if (desc.equals("J")) {
            return "java/lang/Long";
        } else if (desc.equals("F")) {
            return "java/lang/Float";
        } else if (desc.equals("D")) {
            return "java/lang/Double";
        } else if (desc.equals("Z")) {
            return "java/lang/Boolean";
        } else if (desc.equals("C")) {
            return "java/lang/Character";
        } else if (desc.equals("S")) {
            return "java/lang/Short";
        } else if (desc.equals("B")) {
            return "java/lang/Byte";
        }

        return getClassName();
    }

    public String getWrapperTypeInternal() {
        if (desc.equals("I")) {
            return "Ljava/lang/Integer;";
        } else if (desc.equals("J")) {
            return "Ljava/lang/Long;";
        } else if (desc.equals("F")) {
            return "Ljava/lang/Float;";
        } else if (desc.equals("D")) {
            return "Ljava/lang/Double;";
        } else if (desc.equals("Z")) {
            return "Ljava/lang/Boolean;";
        } else if (desc.equals("C")) {
            return "Ljava/lang/Character;";
        } else if (desc.equals("S")) {
            return "Ljava/lang/Short;";
        } else if (desc.equals("B")) {
            return "Ljava/lang/Byte;";
        }

        return desc;
    }

    public String getNarrowingMethod() {
        if (desc.equals("I")) {
            return "intValue";
        } else if (desc.equals("J")) {
            return "longValue";
        } else if (desc.equals("F")) {
            return "floatValue";
        } else if (desc.equals("D")) {
            return "doubleValue";
        } else if (desc.equals("Z")) {
            return "booleanValue";
        } else if (desc.equals("C")) {
            return "charValue";
        } else if (desc.equals("S")) {
            return "shortValue";
        } else if (desc.equals("B")) {
            return "byteValue";
        }

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public boolean needsWrapping() {
        if (!desc.startsWith("L") && !desc.startsWith("["))
            return true;

        return false;
    }

    public String getClassName() {
        if (!needsWrapping() && desc.length() > 2)
            return desc.substring(1, desc.length()-1);

        return desc;
    }


    public Label getStartLabel() {
        return startLabel;
    }

    public void setStartLabel(Label startLabel) {
        this.startLabel = startLabel;
    }


    public int getLocalVarIndex() {
        return localVarIndex;
    }

    public void setLocalVarIndex(int localVarIndex) {
        this.localVarIndex = localVarIndex;
    }

    public int getMaxStackSizeForSetter() {
        if (desc.equals("I") || desc.equals("C") || desc.equals("S") || desc.equals("Z") || desc.equals("B"))
            return 6;
        else if (desc.equals("D") || desc.equals("J") || desc.equals("F"))
            return 7;
        else if (desc.startsWith("L") || desc.startsWith("["))
            return 6;

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public int getMaxStackSizeForGetter() {
        if (desc.equals("I") || desc.equals("C") || desc.equals("S") || desc.equals("Z") || desc.equals("B"))
            return 7;
        else if (desc.equals("D") || desc.equals("J") || desc.equals("F"))
            return 7;
        else if (desc.startsWith("L") || desc.startsWith("["))
            return 7;

        throw new IllegalStateException("Field description is of unknown type.");
    }

    public boolean isWideNativeType() {
        if (desc.equals("D") || desc.equals("J") || desc.equals("F"))
            return true;

        return false;
    }


    public String getOwnerClassName() {
        return ownerClassName;
    }

    public void setOwnerClassName(String ownerClassName) {
        this.ownerClassName = ownerClassName;
    }

}
