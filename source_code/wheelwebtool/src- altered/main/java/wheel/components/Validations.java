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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Validation methods available by default in validation expressions.
 * @author Henri Frilund
 * @see FormElement#validationRule(String, String)
 */
public class  Validations {
    private static Validations instance;
    private static Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");

    private Validations() {}

    /**
     * Returns true if value is an integer.
     * @param value
     * @return
     */
    public boolean isInt(String value) {
        if (value == null || value.length() == 0)
            return false;

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * Returns true if value is set.
     * @param value
     * @return
     */
    public boolean required(String value) {
        if (value == null || value.length() == 0)
            return false;

        return true;
    }

    /**
     * Returns true if value is a valid Double.
     * @param value
     * @return
     */
    public boolean isDouble(String value) {
        if (value == null || value.length() == 0)
            return false;

        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * Returns true if value is a valid email address. Uses ".+@.+\.[a-z]+" as the regural expression.
     * @param value
     * @return
     */
    public boolean isEmail(String value) {
        if (value == null|| value.length() == 0)
            return false;

        Matcher m = emailPattern.matcher(value);

        return m.matches();
    }

    public static Validations getInstance() {
        if (instance == null)
            instance = new Validations();

        return instance;
    }
}
