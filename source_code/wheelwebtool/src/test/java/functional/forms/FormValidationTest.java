package functional.forms;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

//TODO
public class FormValidationTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.forms");
        setApplicationPackages("functional", "functional.forms");
        initialize();
    }

    @Test
    public void testBasicValidation() {
        reset();

        createForm("form1");
        addFormField("required", "");

        load("ValidationPage");

        assertXpath("required error", "//h1");

        createForm("form1");
        addFormField("int", "xxx");

        load("ValidationPage");

        assertXpath("int error", "//h1");

        createForm("form1");
        addFormField("required2", "");

        load("ValidationPage");

        assertXpath("required2 error", "//h1");

        createForm("form1");
        addFormField("int2", "xxx");

        load("ValidationPage");

        assertXpath("int2 error", "//h1");

        createForm("form1");
        addFormField("numberRange", "101");

        load("ValidationPage");

        assertXpath("numberRange error", "//h1");

        createForm("form1");
        addFormField("email", "xxx");

        load("ValidationPage");

        assertXpath("email error", "//h2");

        createForm("form1");
        addFormField("double", "xxx");

        load("ValidationPage");

        assertXpath("double error", "//h3");
    }
}
