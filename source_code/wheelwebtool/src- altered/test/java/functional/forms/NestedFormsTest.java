package functional.forms;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

//TODO
public class NestedFormsTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.forms");
        setApplicationPackages("functional", "functional.forms");
        initialize();
    }

    @Test
    public void testNothing() {

    }
}
