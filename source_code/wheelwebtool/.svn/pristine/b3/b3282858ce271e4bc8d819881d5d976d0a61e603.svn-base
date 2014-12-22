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

import wheel.components.StandaloneComponent;

import java.util.Locale;

/**
 * A source for localized messages.
 *
 * @author Henri Frilund
 */
public interface IMessagesSource {

    /**
     * Tries to read a localized message from the given bundle with the given key and locale. If not found returns [KEY].
     * @param bundle Name of the bundle (in the long class name format)
     * @param key Name of the message inside the bundle
     * @param locale
     * @param caller The complex component that is asking for this message.
     * @return
     */
    public String getMessage(String bundle, String key, Locale locale, StandaloneComponent caller);

    /**
     * Returns true if a message with the given key exists in the given bundle with the given locale.
     * @param bundle
     * @param key
     * @param locale
     * @param caller The complex component that is asking for this message.
     * @return
     */
    public boolean exists(String bundle, String key, Locale locale, StandaloneComponent caller);
}
