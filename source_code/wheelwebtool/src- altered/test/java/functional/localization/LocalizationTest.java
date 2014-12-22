package functional.localization;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocalizationTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.localization");
        setApplicationPackages("functional", "functional.localization");
        initialize();
    }

    @Test
    public void testDefaultLocale() {
        reset();
        load("Localized");

        assertXpath("Message1 content", "//h1");
        assertXpath("replacement1 Message2 content replacement2", "//h2");
    }

    @Test
    public void testDifferentLocale() {
        reset();
        load("Localized");

        assertXpath("Message1 content", "//h1");
        assertXpath("replacement1 Message2 content replacement2", "//h2");
        assertXpath("Message3 content", "//h3");
        assertXpath("Overridden content", "//h4");

        load("Localized.changeLocale");

        assertXpath("Message1 se content", "//h1");
        assertXpath("replacement1 Message2 se content replacement2", "//h2");
        assertXpath("Message3 content se", "//h3");
        assertXpath("Overridden content se", "//h4");

    }
}
