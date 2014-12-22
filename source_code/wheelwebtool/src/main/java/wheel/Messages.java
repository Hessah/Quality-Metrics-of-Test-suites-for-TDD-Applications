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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Handles localized message loading.
 *
 * @author Henri Frilund
 */
public class Messages  {
    private final Logger log = LoggerFactory.getLogger(Messages.class);
    private StandaloneComponent owner;
    private IMessagesSource source;
    private IEngine engine;

    public Messages(StandaloneComponent owner) {
        this.owner = owner;
    }

    /**
     * Returns a localized message with the following rules:<br/>
     * <ol>
     *  <li>Search a .properties file with the same name as the owning complex component from the same package as the complex component</li>
     *  <li>If not found, search from a .properties file with the same name and package as the owning complex component's super class.</li>
     *  <li>Repeat #2 until a message is found or the name of the class is wheel.components.Component.
     * @param key
     * @return
     */
    public String getMessage(String key) {
        if (engine == null)
            engine = owner.getEngine();

        String cacheKey = null;

        if (owner.isPage())
            cacheKey = "wheelMessagesCache_" + owner.getPagePath() + "_" + engine.getLocale().toString();
        else
            cacheKey = "wheelMessagesCache_" + owner.getComponentId() + "_" + engine.getLocale().toString();

        Map<String,String> cache = (Map<String,String>) engine.getContext().getAttribute(cacheKey);

        if (cache == null)
            cache = new HashMap<String,String>();

        if (source == null)
            source = engine._getMessagesSource();

        if (cache.containsKey(key))
            return cache.get(key);

        Locale locale = engine.getLocale();
        String loadMessagesFrom;
        Class clazz = owner.getClass();
        String message = "[" + key.toUpperCase() + "]";

        while (true) {
            loadMessagesFrom = clazz.getName().replace('.', '/');

            if (source.exists(loadMessagesFrom, key, locale, owner)) {
                message = source.getMessage(loadMessagesFrom, key, locale, owner);
                break;
            }
            else {
                clazz = clazz.getSuperclass();

                if (clazz.getName().equals("wheel.components.Component")) {
                    log.warn("No message was found with key '{}'. Check that you have created properties file with the same name as the StandaloneComponent class (or it's super class) using the message.", key);
                    break;
                }
            }
        }

        cache.put(key, message);

        engine.getContext().setAttribute(cacheKey, cache);

        return message;
    }

    /**
     * Flushes message cache.
     */                                                                                                                                          
    public void flushCache() {
        if (engine == null)
            engine = owner.getEngine();

        Enumeration cacheKeys = engine.getContext().getAttributeNames();

        while (cacheKeys.hasMoreElements()) {
            String key = (String) cacheKeys.nextElement();

            if (key.startsWith(owner.getComponentId()))
                engine.getContext().setAttribute(key, null);
        }
    }
}
