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

import org.junit.BeforeClass;
import org.junit.Test;
import wheel.testing.WheelFunctionalTestCase;
import static org.junit.Assert.*;

public class PersistenceTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.persistence");
        setApplicationPackages("functional", "functional.persistence");
        initialize();
    }

    @Test
    public void testBAsicPersistence() {
        load("BasicPersistencePage");
        assertXpath("0", "//h1[1]");
        assertXpath("null", "//h1[8]");
        assertXpath("null", "//h1[10]");

        load("BasicPersistencePage.changeValues");

        assertXpath("1", "//h1[1]");
        assertXpath("true", "//h1[4]");
        assertXpath("field7", "//h1[7]");
        assertXpath("1001", "//h1[10]");

        load("ResetterPage");

        load("BasicPersistencePage");

        assertXpath("1", "//h1[1]");
        assertXpath("true", "//h1[4]");
        assertXpath("field7", "//h1[7]");
    }

    @Test
    public void testScopes() {
        load("ScopesTestPage");

        assertXpath("null", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("null", "//h2[1]");

        //global scope
        load("ScopesTestPage.changeGlobal", "new global value");

        assertXpath("new global value", "//h2[1]");
        assertNotNull(getContext().getAttribute("wheelData:global:global"));

        //page scope
        load("ScopesTestPage.changeValue", "page scope value");

        assertXpath("page scope value", "//h1[1]");

        load("ResetterPage");

        load("ScopesTestPage");

        assertXpath("null", "//h1[1]");

        //component scope
        load("ScopesTestPage$component1.changeValue", "component1 value");
        load("ScopesTestPage$component2.changeValue", "component2 value");

        load("ResetterPage");

        load("ScopesTestPage");

        assertXpath("component1 value", "//div[@id = 'component1']/h1");
        assertXpath("component2 value", "//div[@id = 'component2']/h1");
    }

    @Test
    public void testTwoUsers() {
        reset();
        createUser("user2");

        load("ScopesTestPage");

        assertXpath("null", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        loadAsUser("ScopesTestPage", "user2");

        assertXpath("null", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        load("ScopesTestPage.changeValue", "page scope value");

        assertXpath("page scope value", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        loadAsUser("ScopesTestPage.changeValue", "user2", "page scope value, user2");

        assertXpath("page scope value, user2", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        load("ScopesTestPage");

        assertXpath("page scope value", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        loadAsUser("ResetterPage", "user2");

        loadAsUser("ScopesTestPage", "user2");

        assertXpath("null", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        load("ScopesTestPage");

        assertXpath("page scope value", "//h1[1]");
        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
        assertXpath("new global value", "//h2[1]");

        load("ScopesTestPage.changeGlobal", "another global value");
        assertXpath("another global value", "//h2[1]");

        loadAsUser("ScopesTestPage", "user2");
        assertXpath("another global value", "//h2[1]");

        loadAsUser("ScopesTestPage$component1.changeValue", "user2", "component1 value");

        assertXpath("component1 value", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");

        load("ScopesTestPage");

        assertXpath("null", "//div[@id = 'component1']/h1");
        assertXpath("null", "//div[@id = 'component2']/h1");
    }

    @Test
    public void testInitialValues() {
        load("InitialValuesPage");

        assertXpath("initialValue", "//h1");
        assertXpath("initialValue2", "//h2");
        assertXpath("one", "//h3[1]");
        assertXpath("two", "//h3[2]");
    }

    @Test
    public void testInvalidFields() {
        reset();
        load("InvalidPersistentPage");

        assertXpath("Reason: Persistent field invalidField must have private access.", "//h2[1]");
    }
}
