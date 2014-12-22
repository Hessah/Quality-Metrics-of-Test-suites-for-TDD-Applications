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
package wheel;

import org.mvel.DataConversion;
import wheel.util.CalendarConversionHandler;
import wheel.util.DateConversionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * An abstract implementation of IEngine. Provides a way to get the current IEngine that is handling the request cycle from any class
 * withing thread-bounds.
 *
 * @author Henri Frilund
 */
public abstract class AbstractEngine implements IEngine {
    private static ThreadLocal currentServer = new ThreadLocal();
    private static ThreadLocal calendar = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new GregorianCalendar();
        };
    };

    static {
        DataConversion.addConversionHandler(Calendar.class, new CalendarConversionHandler());
        DataConversion.addConversionHandler(Date.class, new DateConversionHandler());
    }

    /**
     * Returns the IEngine that is processing the request cycle.
     * @return
     */
    public static IEngine getCurrentServer() {
        return (IEngine)currentServer.get();
    }

    public static void setCurrentServer(IEngine engine) {
        currentServer.set(engine);
    }

    public static Calendar getCalendar() {
        Calendar c =  (Calendar)calendar.get();
        c.setTimeInMillis(System.currentTimeMillis());
        return c;
    }

    /**
     * Default implemetation delegates to processRequestInternal. Makes sure that all IEngine instances get garbage collected.
     */
    public void processRequest() {
        try {
            currentServer.set(this);
            processRequestInternal();
        } finally {
            currentServer.set(null);
        }
    }

    protected abstract void processRequestInternal();

    protected abstract Map readRequestParameters(HttpServletRequest request);

   
}
