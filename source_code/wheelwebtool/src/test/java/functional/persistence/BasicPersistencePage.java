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
package functional.persistence;

import functional.BaseTestPage;
import wheel.annotations.ActionMethod;
import wheel.annotations.Persist;

import java.util.Calendar;
import java.util.Date;

public class BasicPersistencePage extends BaseTestPage {
    @Persist
    private int field1;
    @Persist
    private short field2;
    @Persist
    private long field3;
    @Persist
    private boolean field4;
    @Persist
    private double field5;
    @Persist
    private float field6;
    @Persist
    private Object field7;
    @Persist
    private Date field8;
    @Persist
    private Calendar field9;
    @Persist
    private byte[] field10;

    private static final String STATIC_FINAL = "test value";
    private final String FINAL = "test value";

    public void buildComponent() {
        h1(field1);
        h1(field2);
        h1(field3);
        h1(field4);
        h1(field5);
        h1(field6);
        h1(field7);
        h1(field8);
        h1(field9);
        h2(STATIC_FINAL);
        h3(FINAL);

        if (field10 == null)
            h1(field10);
        else
            h1(field10[0] + "" + field10[1] + "" + field10[2] + "" + field10[3]);
        
        NonUIClass nonUIClass = new NonUIClass();


    }

    @ActionMethod
    public void changeValues() {
        field1 = 1;
        field2 = 2;
        field3 = 3l;
        field4 = true;
        field5 = 4d;
        field6 = 5f;
        field7 = "field7";
        field10 = new byte[] {1,0,0,1};
    }

    public boolean isField4() {
        return field4;
    }

    public void setField4(boolean field4) {
        this.field4 = field4;
    }

    
}
