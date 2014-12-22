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

import org.xmlpull.v1.XmlSerializer;
import wheel.WheelException;
import wheel.util.AbstractDateConversionHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A form element that can be used for handling Dates and Calendars.
 * Uses java.text.SimpleDateFormat internally to convert from String expressions to Date/Calendar instances.
 * The date pattern must use the same syntax as described in SimpleDateFormat.
 * @see java.text.SimpleDateFormat
 * @author Henri Frilund
 */
public class DateInput extends FormElement {
    private CharSequence pattern;

    DateInput(Component parent, String elementName, String componentId, CharSequence datePattern) {
        super(parent, elementName, componentId);
        this.pattern = datePattern;
        attribute("type", "text");
        genericFieldErrorMessage = "dateInputError";
    }

    public String defaultTagName() {
        return "input";
    }

    @Override
    public void _setSubmitValue(String[] value) {
        SimpleDateFormat df = AbstractDateConversionHandler.getDateFormat();
        df.setCalendar(date());

        try {
            df.applyPattern(eval(pattern));
        } catch (Exception e) {
            throw new WheelException("Failed to initialize SimpleDateFormat with pattern '" + pattern + "'.", e, this);
        }

        super._setSubmitValue(value);
    }

    @Override
    public void renderComponent(XmlSerializer serializer) throws IOException {
        if (isValid()) {
            serializer.attribute("", "value", eval(getBinding()));
        }
        else
            serializer.attribute("", "value", _getSubmitValue());

        super.renderComponent(serializer);
    }


    @Override
    public String _applyFormat(Object value) {
        if (value instanceof Date || value instanceof Calendar || value instanceof Long)
            return dateFormat(eval(pattern), value);

        return super._applyFormat(value);
    }
}
