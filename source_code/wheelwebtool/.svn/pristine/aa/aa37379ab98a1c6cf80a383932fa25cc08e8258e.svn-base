package functional.errorhandling;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorHandlingTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.errorhandling");
        setApplicationPackages("functional", "functional.errorhandling");
        initialize();
    }

    @Test
    public void testUncheckedException() {
        reset();
        load("ErrorGeneratingPage.uncheckedException");

        assertXpath("Test error 1", "//h1");
    }

    @Test
    public void testCheckedException() {
        reset();
        load("ErrorGeneratingPage.checkedException");

        assertXpath("Test error 2", "//h1");
    }

    @Test
    public void testExceptionFromBuildComponent() {
        reset();
        load("ErrorGeneratingPage2");

        assertXpath("Test error 3", "//h1");
    }

    @Test
    public void testRedirectExceptionToPage() {
        reset();
        load("ErrorGeneratingPage.redirectException1");

        assertXpath("Redirect page", "//h1");
    }

    @Test
    public void testRedirectExceptionToUrl() {
        reset();
        load("ErrorGeneratingPage.redirectException2");

        assertEquals("http://www.dilbert.com/", getMockResponse().getRedirectTarget());
    }
}
