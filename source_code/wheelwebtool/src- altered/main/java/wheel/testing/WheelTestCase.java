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
package wheel.testing;

import junit.framework.TestCase;
import org.w3c.dom.Document;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import wheel.AbstractEngine;
import wheel.components.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * A JUnit-test case to extend your own tests when testing wheel components and pages.
 * Example:
 * <pre>
 * public class MyPageTest extends WheelTestCase {
 *  public void testSomething() {
 *      //first create an instance of the page/component you want to test
 *      MyPage page = new MyPage();
 *
 *      //possibly set some properties to initialize state etc.
 *      page.setPropertyX(...);
 *
 *      //set the component on the "test bench"
 *      setComponent(page);
 *
 *      //trigger rendering
 *      render();
 *
 *      //then do assertions with normal JUnit-assertions or then ones provided by WheelTestCase
 *      assertXPath("desired output", "//h1[@id='componentId']");
 *      assertPresent("//div[@id='componentId']");
 *  }
 * }
 * </pre>
 * @author Henri Frilund
 */
public abstract class WheelTestCase extends TestCase {
    private Document result;
    private MockEngine server;
    private MockForm mockForm;
    private RenderableComponent component;
    private StandaloneComponent page;
    private static XPath xpath = XPathFactory.newInstance().newXPath();


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        server = new MockEngine();
        AbstractEngine.setCurrentServer(server);
    }

    /**
     * Causes an immidiate rendering of the component. Call this method always before doing assertXpath() or assertPresent() calls.
     * Also remember to re-render the component after state-changes.
     */
    protected void render() {
        try {
            reset();
            if (component instanceof IBuildableComponent) {
                IBuildableComponent buildableComponent = (IBuildableComponent)component;
                buildableComponent.preBuild();
                buildableComponent.buildComponent();
                buildableComponent.postBuild();
            }

            if (component instanceof StandaloneComponent && ((StandaloneComponent)component).isPage()) {
                page.config()._setRenderDoctype(false);
                page._render(server._getXmlSerializer());
            }
            else {
                XmlSerializer serializer = server._getXmlSerializer();
                serializer.startDocument(server.getEncoding(), null);
                component._render(serializer);
                serializer.endDocument();
                serializer.flush();
            }

            result = server.getDocument();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }

    /**
     * Creates a mock form where you can manually set values and then submit it to the component. Useful for testing form validations.
     * @param id Must match the componentId of the Form-component you want to mock.
     */
    protected void createForm(String id) {
        mockForm = new MockForm(id);
    }


    /**
     * Adds field value to the mock form. Call createForm() before calling this method. Call this method with the same name-parameter multiple times
     * to mock an array field value (like in multiselect).
     * @param name
     * @param value
     */
    protected void addFormField(String name, String value) {
        if (mockForm == null)
            return;

        mockForm.addField(name, value);
    }


    /**
     * Pre-requirement for using any of the methods in this class. Calling this method indicates the component you want to test.
     * @param component The component can be any as long as instanceof RenderableComponent is true.
     */
    protected void setComponent(RenderableComponent component) {
        this.component = component;

        if (!(component instanceof StandaloneComponent)) {
            setBasePackageForPages("wheel.testing");
            this.page = new MockPage();
            page.add(component);
        }
        else {
            String className = component.getClass().getName();
            setBasePackageForPages(className.substring(0, className.lastIndexOf(".")));
            page = (StandaloneComponent)component;
        }
    }

    /**
     * Submits the mock form created with createForm() method. Calling this method causes a new rendering of the component also.
     */
    protected void submitForm() {
        if (page == null)
            fail("Cannot submit form without a page. Call setPage() first.");

        if (mockForm == null)
            fail("Cannot submit form. Call createForm() first.");

        page.preBuild();
        page._setPageRewinding(false);
        page.buildComponent();

        Form form = (Form)page.find(mockForm.getId());
        StandaloneComponent formContainer = form._getTopLevelComponent(true);
        page._setSubmittedForm(form);
        page._setSubmitTarget(formContainer.getComponentId());

        for (FormElement element : form.getFormElements()) {
            if (!mockForm.contains(element.getFormElementName()) && !(element instanceof Checkbox)) {
                continue;
            }

            if (element instanceof Checkbox) {
                if (!mockForm.contains(element.getFormElementName()))
                    element._setSubmitValue(new String[]{"false"});
                else
                    element._setSubmitValue(new String[]{"true"});

                continue;
            }

            element._setSubmitValue((String[])mockForm.getValue(element.getFormElementName()));
        }

        if (!form.config().isRenderSelf()) {
            for (FormElement element : form._getForm(false).getFormElements()) {
               if (!mockForm.contains(element.getFormElementName()) && !(element instanceof Checkbox)) {
                continue;
            }

            if (element instanceof Checkbox) {
                if (!mockForm.contains(element.getFormElementName()))
                    element._setSubmitValue(new String[]{"false"});
                else
                    element._setSubmitValue(new String[]{"true"});

                continue;
            }

            element._setSubmitValue((String[])mockForm.getValue(element.getFormElementName()));
            }
        }


        form._clear();
        page._clear();
        page._setPageRewinding(true);
        page.buildComponent();
        page.postBuild();

        mockForm.clear();
        render();
    }

    /**
     * Enables to make Xpath-based assertions on the html-code created when the component was rendered with a call to render() method.
     * @param expectedValue Expected result of the xpath-expression.
     * @param xpathExpression A valid Xpath-expression
     */
    protected void assertXpath(String expectedValue, String xpathExpression) {
        if (result == null)
            fail("No output available from redering.");

        try {
            xpath.reset();
            assertEquals(expectedValue, xpath.evaluate(xpathExpression, result.getDocumentElement()));
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks that an element is present in the output html.
     * @param xpathExpression A valid Xpath-expression
     */
    protected void assertPresent(String xpathExpression) {
        if (result == null)
            fail("No output available from redering.");

        try {
            xpath.reset();
            assertNotNull(xpath.evaluate(xpathExpression, result.getDocumentElement()));
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Resets the html-output from the previous rendering.
     */
    protected void reset() {
        try {
            server.reset();
            page._clear();
            component._clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Returns the Page being used. If you've called setComponent() with a component that isn't an instance of Page,
     * this method will return an instance of MockPage where your component is attached.
     * @return
     */
    protected StandaloneComponent getPage() {
        return page;
    }

    /**
     * By default the basePackage will be "wheel.testing" for components that are not Pages and the package-part of the class name
     * for Page-instances. Example: if you call setComponent() with an instance of com.foo.bar.pages.MyPage, the basePackageForPages in the MockEngine
     * would be set to com.foo.bar.pages. By calling this method you can set the basePackage to any value you like if the defaults aren't ok.
     * @param basePackage
     */
    protected void setBasePackageForPages(String basePackage) {
        server.setBasePackageForPages(basePackage);
    }

    protected void setResult(Document document) {
        this.result = document;
    }

}
