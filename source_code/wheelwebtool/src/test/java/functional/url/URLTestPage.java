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
package functional.url;

import functional.BaseTestPage;
import wheel.annotations.ActionMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class URLTestPage extends BaseTestPage {
    private String value = "";
    private String exposedField;

    public URLTestPage() {
        config().exposeField("exposedField");
    }

    public void buildComponent() {
        h1("URLTestPage");
        h3(value);
        h4(exposedField);

        div().id("component1").
            h2("component content");
    }

    @ActionMethod
    public void myAction() {
        this.value = "Value changed";
    }

    @ActionMethod
    public void myAction2(String param) {
        this.value = param;
    }

    @ActionMethod
    public void myAction2(String param, String param2) {
        this.value = param + param2;
    }

    @ActionMethod
    public void myAction2(int param) {
        this.value = param + "";
    }

    @ActionMethod
    public void myAction2(double param) {
        this.value = param + "";
    }

    @ActionMethod
    public void myAction2(Calendar cal) {
        this.value = (new SimpleDateFormat("dd.MM.yyyy")).format(cal.getTime());
    }


    @ActionMethod
    public void myAction2(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.value = i1 + "" +  i2 + "" + i3 + "" + i4 + "" + i5 + "" + i6 + "" + i7 + "" + i8 + "" + i9 + "" + i10;
    }

    public void unmarkedAction() {

    }

    public String getExposedField() {
        return exposedField;
    }

    public void setExposedField(String exposedField) {
        this.exposedField = exposedField;
    }
}
