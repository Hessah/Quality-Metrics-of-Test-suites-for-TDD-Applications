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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wheel.components.StandaloneComponent;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class MessageSourceResourceBundleImpl implements IMessagesSource {
    private final Logger log = LoggerFactory.getLogger(MessageSourceResourceBundleImpl.class);

    public String getMessage(String bundle, String key, Locale locale, StandaloneComponent caller) {

        ResourceBundle resourceBundle = loadBundle(bundle, locale);

        if (resourceBundle == null)
            throw new WheelException("No resource bundle found for '" + bundle + "' with locale '" + locale.toString() + "'.", null);

        try {
            String value = resourceBundle.getString(key);
            return fixEncoding(value);
        } catch (Exception e) {
            log.warn("No message was found in bundle '{}' with key '{}'.", new Object[]{bundle, key});
            return "[" + key.toUpperCase() + "]";
        }
    }


    public boolean exists(String bundle, String key, Locale locale, StandaloneComponent caller) {

        ResourceBundle resourceBundle = null;
        try {
            resourceBundle = loadBundle(bundle, locale);
        } catch (Exception e) {
            return false;
        }

        if (resourceBundle == null)
            return false;

        Enumeration keys = resourceBundle.getKeys();

        while (keys.hasMoreElements()) {
            String s = (String) keys.nextElement();

            if (s.equals(key))
                return true;
        }

        return false;
    }

    private ResourceBundle loadBundle(String bundle, Locale locale) {
        LocalizedBundleKey bundleKey = new LocalizedBundleKey(locale, bundle);

        Map<LocalizedBundleKey, ResourceBundle> bundleCache = (Map<LocalizedBundleKey, ResourceBundle>) AbstractEngine.getCurrentServer().getContext().getAttribute("wheelMessagesCache");

        if (bundleCache == null)
            bundleCache = new HashMap<LocalizedBundleKey, ResourceBundle>();

        if (!bundleCache.containsKey(bundleKey)) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, locale, Thread.currentThread().getContextClassLoader());

            if (resourceBundle == null)
                return null;

            bundleCache.put(bundleKey, resourceBundle);

            AbstractEngine.getCurrentServer().getContext().setAttribute("wheelMessagesCache", bundleCache);
        }

        ResourceBundle resourceBundle = bundleCache.get(bundleKey);

        return resourceBundle;
    }

    private String fixEncoding(String value) {
        String encoding = AbstractEngine.getCurrentServer().getEncoding();

        if (!encoding.equals("ISO-8859-1")) {
            try {
                value = new String(value.getBytes("ISO-8859-1"), encoding);
            } catch (UnsupportedEncodingException e) {
                log.error("Could not encode message '" + value + "' because of unsupported encoding " + encoding, e);
            }
        }
        return value;
    }

    class LocalizedBundleKey {
        private Locale locale;
        private String bundle;


        public LocalizedBundleKey(Locale locale, String bundle) {
            this.locale = locale;
            this.bundle = bundle;
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LocalizedBundleKey that = (LocalizedBundleKey) o;

            if (bundle != null ? !bundle.equals(that.bundle) : that.bundle != null) return false;
            if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;

            return true;
        }

        public int hashCode() {
            int result;
            result = (locale != null ? locale.hashCode() : 0);
            result = 31 * result + (bundle != null ? bundle.hashCode() : 0);
            return result;
        }
    }
}
