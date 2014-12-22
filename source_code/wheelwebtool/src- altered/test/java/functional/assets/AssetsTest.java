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
package functional.assets;

import org.junit.BeforeClass;
import org.junit.Test;
import wheel.testing.WheelFunctionalTestCase;
import static org.junit.Assert.*;

import java.io.File;

public class AssetsTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUpp()  {
        resetAll();
        setBasePackageForPages("functional.assets");
        setApplicationPackages("functional", "functional.assets");
        setResourceRoot(new File("target/test-classes/functional/assets"));
        setContextName("test");
        initialize();
    }

    @Test
    public void testBasicCSS() {
        load("AssetTestPage");
        assertXpath("test/css/AssetTestPage.css", "//head/link[1]/@href");
    }

    @Test
    public void testBasicJS() {
        load("AssetTestPage");
        assertXpath("test/js/AssetTestPage.js", "//head/script[1]/@src");        
    }

    @Test
    public void testCustomCSS() {
        load("AssetTestPage");
        assertXpath("test/css/Custom.css?expires=48", "//head/link[2]/@href");

        load("ComponentContainer2");
        assertXpath("test/css/NormalComponent.css?expires=48", "//head/link[1]/@href");
    }

    @Test
    public void testCustomJS() {
        load("AssetTestPage");
        assertXpath("test/js/Custom.js?expires=48", "//head/script[2]/@src");
    }

    @Test
    public void testExpiration() {
        load("AssetTestPage");
        assertXpath("test/css/Custom2.css?expires=120", "//head/link[3]/@href");
    }

    @Test
    public void testMedia() {
        load("AssetTestPage");
        assertXpath("test/css/MediaTest.css?expires=48", "//head/link[4]/@href");
        assertXpath("print", "//head/link[4]/@media");
    }

    @Test
    public void testMediaWithExpiration() {
        load("AssetTestPage");
        assertXpath("test/css/MediaTest2.css?expires=250", "//head/link[5]/@href");
        assertXpath("print", "//head/link[5]/@media");   
    }

    @Test
    public void testReusableCSS() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/Custom.css?expires=48", "//head/link[1]/@href");
    }

    @Test
    public void testReusableJS() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/Custom.js?expires=48", "//head/script[1]/@src");
    }

    @Test
    public void testReusableExpiration() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/Custom2.css?expires=120", "//head/link[2]/@href");
    }

    @Test
    public void testReusableMedia() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/MediaTest.css?expires=48", "//head/link[3]/@href");
        assertXpath("print", "//head/link[3]/@media");        
    }

    @Test
    public void testReusableMediaWithExpiration() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/MediaTest2.css?expires=250", "//head/link[4]/@href");
        assertXpath("print", "//head/link[4]/@media");
    }

    @Test
    public void testReusableComponentCSS() {
        load("ComponentContainer");
        assertXpath("test/css/ComponentContainer.css", "//head/link[1]/@href");
        assertXpath("asset/functional/assets/Custom.css?expires=48", "//head/link[2]/@href");
        assertXpath("", "//head/link[3]/@href");
    }

    @Test
    public void testExternalCSS() {
        load("AssetTestPage");
        assertXpath("http://www.foobar.com/test.css", "//head/link[6]/@href");

        load("ComponentContainer2");
        assertXpath("http://www.foobar.com/extCss.css", "//head/link[4]/@href");
    }

    @Test
    public void testExternalJS() {
        load("AssetTestPage");
        assertXpath("http://www.foobar.com/test.js", "//head/script[3]/@src");

        load("ComponentContainer2");
        assertXpath("http://www.foobar.com/extJs.js", "//head/script[1]/@src");
    }

    @Test
    public void testNormalImages() {
        load("AssetTestPage");
        assertXpath("test/images/normalImage.jpg", "//img[1]/@src");
        assertXpath("http://www.foobar.com/image1.jpg", "//img[2]/@src");

        load("ComponentContainer2");
        assertXpath("test/images/test.jpg", "//img[1]/@src");

        load("ComponentContainer");
        assertXpath("http://www.foobar.com/test.jpg", "//img[1]/@src");
    }

    @Test
    public void testReusableImages() {
        load("ReusableAssetPage");
        assertXpath("asset/functional/assets/test.jpg", "//img[1]/@src");
        assertXpath("asset/functional/assets/test2.jpg", "//img[2]/@src");
    }

    @Test
    public void testReplacement() {
        load("ComponentContainer2");
        assertXpath("test/css/functional/assets/ReusableComponent2.css?expires=48", "//head/link[2]/@href");
    }

    @Test
    public void testCSSUrlReplacement() {
        load("asset/functional/assets/TestCss.css");
        assertEquals("body {background: url(test/app/asset/functional/assets/test.jpg)}", getResponseAsString());
    }
}
