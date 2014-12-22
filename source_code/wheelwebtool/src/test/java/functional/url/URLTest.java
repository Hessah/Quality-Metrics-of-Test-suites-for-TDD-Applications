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

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class URLTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.url");
        setApplicationPackages("functional","functional.url");
        initialize();
    }

    @Test
    public void testUnmarkedAction() {
        load("URLTestPage.unmarkedAction");
        assertXpath("Reason: Method 'unmarkedAction()' is not registered as an action. Add @ActionMethod annotation to all methods that are action methods.", "//h2[1]");
    }

    @Test
    public void testBasicPageLoading() {
        load("URLTestPage");
        assertXpath("URLTestPage", "//h1[1]");
    }

    @Test
    public void testPageLoadingFromSubPackage() {
        load("admin/SubPackagePage");
        assertXpath("SubPackagePage", "//h1[1]");
    }

    @Test
    public void testPageLoadingFromSubSubPackage() {
        load("admin/adminsub/SubSubPackagePage");
        assertXpath("This is a sub sub package page.", "//h1[1]");
    }

    @Test
    public void testComponentRenderUrl() {
        load("URLTestPage$component1");
        assertXpath("component content", "/div/h2");
    }

    @Test
    public void testBasicAction() {
        load("URLTestPage.myAction");
        assertXpath("Value changed", "//h3[1]");
    }

    @Test
    public void testActionWithSingleParameter() {
        load("URLTestPage.myAction2", "Another value");
        assertXpath("Another value", "//h3[1]");
    }

    @Test
    public void testActionWithTwoParameters() {
        load("URLTestPage.myAction2", "1", "2");
        assertXpath("12", "//h3[1]");

    }

    @Test
    public void testActionWithSingleIntParameter() {
        load("URLTestPage.myAction2", 150);
        assertXpath("150", "//h3[1]");
    }

    @Test
    public void testActionWithManyIntegerParameters() {
        load("URLTestPage.myAction2", 0,1,2,3,4,5,6,7,8,9);
        assertXpath("0123456789", "//h3[1]");
    }

    @Test
    public void testActionWithDoubleParameter() {
        load("URLTestPage.myAction2", 150.456d);
        assertXpath("150.456", "//h3[1]");
    }

    @Test
    public void testActionWithDateParameter() {
        load("URLTestPage.myAction2", "10.3.2008");
        assertXpath("10.3.2008", "//h3[1]");    
    }

    @Test
    public void testMissingParameter() {
        load("URLTestPage.myAction2");
        assertXpath("Reason: Failed to call method 'myAction2()' in class functional.url.URLTestPage", "//h2[1]");    
    }

    @Test
    public void testNonExistingMethod() {
        load("URLTestPage.foobar");
        assertXpath("Reason: Method 'foobar()' is not registered as an action. Add @ActionMethod annotation to all methods that are action methods.", "//h2[1]");
    }

    @Test
    public void testNonExistentPage() {
        load("Garbage");
        assertXpath("Reason: Could not find page class with name 'functional.url.Garbage'. Check that the package of the desired page is configured as an applicationPackage.", "//h2[1]");
    }

    @Test
    public void testDefaultPage() {
        load("");
        assertXpath("This is the default page", "//h1[1]");    
    }

    @Test
    public void testSpecialCharactersInParameter() {
        load("URLTestPage.myAction2", " !#¤%&/()=äöÄÖ");
        assertXpath(" !#¤%&/()=äöÄÖ", "//h3[1]");
    }

    @Test
    public void testExposedField() {
        load("URLTestPage");
        assertXpath("null", "//h4[1]");

        addParameter("exposedField", "Value");
        load("URLTestPage");

        assertXpath("Value", "//h4[1]");
    }
}


