package functional.forms;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class BasicFormTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.forms");
        setApplicationPackages("functional", "functional.forms");
        initialize();
    }


    @Test
    public void testFormElementsRendering() {
        reset();
        load("BasicFormElements");

        assertXpath("hidden", "//input[@id='hidden1']/@type");
        assertXpath("hidden1Value", "//input[@id='hidden1']/@value");

        assertXpath("text", "//input[@id='textInput']/@type");
        assertXpath("textInputValue", "//input[@id='textInput']/@value");

        assertPresent("//textarea");
        assertXpath("textArea", "//textarea/@name");
        assertXpath("textAreaValue", "//textarea");

        assertXpath("radio", "//input[@id='radioButton']/@type");
        assertXpath("radioButton", "//input[@id='radioButton']/@name");
        assertXpath("radioValue", "//input[@id='radioButton']/@value");
        assertXpath("radioButton", "//input[@id='radioButton2']/@name");
        assertXpath("radioValue2", "//input[@id='radioButton2']/@value");

        assertXpath("select1", "//select/@name");
        assertXpath("first", "//select/option[1]/@value");
        assertXpath("second", "//select/option[2]/@value");
        assertXpath("third", "//select/option[3]/@value");
        assertXpath("1", "//select/option[1]");
        assertXpath("2", "//select/option[2]");
        assertXpath("3", "//select/option[3]");

        assertXpath("false", "//input[@id='checkbox1']/@value");
        assertXpath("checkbox", "//input[@id='checkbox1']/@type");
        assertXpath("true", "//input[@id='checkbox2']/@value");
        assertXpath("checked", "//input[@id='checkbox2']/@checked");

        assertXpath("submit1Value", "//input[@id='submit1']/@value");
        assertXpath("submit", "//input[@id='submit1']/@type");

        assertXpath("resetValue", "//input[@id='reset']/@value");
        assertXpath("reset", "//input[@id='reset']/@type");

        assertXpath("buttonValue", "//input[@id='button1']/@value");
        assertXpath("button", "//input[@id='button1']/@type");

        assertXpath("submit.gif", "//input[@id='imageSubmit1']/@src");
        assertXpath("image", "//input[@id='imageSubmit1']/@type");

        assertXpath("file", "//input[@id='fileInput']/@type");
    }

    @Test
    public void testTextInput() {
        reset();
        load("TextInput");

        assertXpath("", "//input[@id='unbound_no_value']/@value");
        assertXpath("unboundValue", "//input[@id='unbound_value']/@value");
        assertXpath("default value", "//input[@id='bound_default_value']/@value");
        assertXpath("45", "//input[@id='bound_persist']/@value");
        assertXpath("initial value", "//input[@id='bound_initial_value']/@value");

        createForm("textInput");
        addFormField("bound_no_value", "new value");
        addFormField("bound_default_value", "new value2");
        addFormField("bound_persist", "99");
        addFormField("bound_initial_value", "new value3");

        load("TextInput");

        assertXpath("new value", "//input[@id='bound_no_value']/@value");
        assertXpath("new value2", "//input[@id='bound_default_value']/@value");
        assertXpath("99", "//input[@id='bound_persist']/@value");
        assertXpath("new value3", "//input[@id='bound_initial_value']/@value");

        load("TextInput");

        assertXpath("default value", "//input[@id='bound_default_value']/@value");
        assertXpath("99", "//input[@id='bound_persist']/@value");
    }

    @Test
    public void testCheckbox() {
        reset();
        load("Checkbox");

        assertXpath("checked", "//input[@id='simple']/@checked");
        assertXpath("false", "//input[@id='bound']/@value");
        assertXpath("checked", "//input[@id='bound2']/@checked");

        createForm("checkboxForm");
        addFormField("bound", "true");
        //note that missing checkbox is interpreted as false value as this is how browsers work.

        load("Checkbox");

        assertXpath("true", "//input[@id='bound']/@value");
        assertXpath("false", "//input[@id='bound2']/@value");

        load("Checkbox");

        assertXpath("false", "//input[@id='bound']/@value");
        assertXpath("false", "//input[@id='bound2']/@value");
    }

    @Test
    public void testRadio() {
        reset();
        load("Radio");

        assertXpath("", "//input[@id='radio1']/@value");
        assertXpath("radio2Value", "//input[@id='radio2']/@value");
        assertXpath("field1Value", "//input[@id='radio3']/@value");

        assertXpath("radio2Value2", "//input[@id='radio22']/@value");
        assertXpath("radio2Value3", "//input[@id='radio23']/@value");
    }

    @Test
    public void testSelect() {
        reset();
        load("Select");

        //StringSelectModel
        assertXpath("", "//select[@id='empty']/option");
        assertXpath("value1", "//select[@id='basic']/option[1]/@value");
        assertXpath("label1", "//select[@id='basic']/option[1]");
        assertXpath("value2", "//select[@id='basic']/option[2]/@value");
        assertXpath("label2", "//select[@id='basic']/option[2]");
        assertXpath("value3", "//select[@id='basic']/option[3]/@value");
        assertXpath("label3", "//select[@id='basic']/option[3]");
        assertXpath("value4", "//select[@id='basic']/option[4]/@value");
        assertXpath("label4", "//select[@id='basic']/option[4]");

        //DynamicSelectModel
        assertXpath("1", "//select[@id='dynamic']/option[1]/@value");
        assertXpath("Hasse", "//select[@id='dynamic']/option[1]");
        assertXpath("2", "//select[@id='dynamic']/option[2]/@value");
        assertXpath("Albert", "//select[@id='dynamic']/option[2]");
        assertXpath("3", "//select[@id='dynamic']/option[3]/@value");
        assertXpath("Paavo", "//select[@id='dynamic']/option[3]");
        assertXpath("4", "//select[@id='dynamic']/option[4]/@value");
        assertXpath("Remu", "//select[@id='dynamic']/option[4]");

        //enumeration
        assertXpath("0", "//select[@id='enumeration']/option[1]/@value");
        assertXpath("mr", "//select[@id='enumeration']/option[1]");
        assertXpath("1", "//select[@id='enumeration']/option[2]/@value");
        assertXpath("ms", "//select[@id='enumeration']/option[2]");

        //multiselect
        assertXpath("multiple", "//select[@id='dynamicMulti']/@multiple");

        createForm("selectForm");
        addFormField("basic", "value3");
        addFormField("dynamic", "4");
        addFormField("enumeration", "1");
        addFormField("dynamicMulti", "1");
        addFormField("dynamicMulti", "4");

        load("Select");

        assertXpath("true", "//select[@id='basic']/option[3]/@selected");
        assertXpath("true", "//select[@id='dynamic']/option[4]/@selected");
        assertXpath("true", "//select[@id='enumeration']/option[2]/@selected");
        assertXpath("Remu", "//h1[1]");
        assertXpath("Hasse", "//p[1]");
        assertXpath("Remu", "//p[2]");


        load("Select");

        assertXpath("", "//select[@id='basic']/option[@selected='true']");
        assertXpath("true", "//select[@id='dynamic']/option[4]/@selected");
        assertXpath("Remu", "//h1[1]");
        assertXpath("Hasse", "//p[1]");
        assertXpath("Remu", "//p[2]");

    }

    @Test
    public void testDateInput() {
        reset();
        load("DateInput");

        assertXpath("text", "//input[@id='basic']/@type");
        assertXpath("01/01/08", "//input[@id='date1']/@value");

        createForm("dateInputForm");
        addFormField("date1", "2/25/05");
        addFormField("date2", "15.5.2008");
        addFormField("date3", "16.5.2008");

        load("DateInput");

        assertXpath("02/25/05", "//input[@id='date1']/@value");
        assertXpath("15.05.2008", "//input[@id='date2']/@value");
        assertXpath("16.05.2008", "//input[@id='date3']/@value");

        load("DateInput");

        assertXpath("", "//input[@id='date2']/@value");
        assertXpath("16.05.2008", "//input[@id='date3']/@value");
    }

    @Test
    public void testFileInput() {
        reset();

        String httpBody1 = "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"wheelSubmitId\"\r\n\r\n" +

                "fileInputForm\r\n" +
                "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"file1\"; filename=\"test.txt\"\r\n" +
                "Content-Type: text/plain\r\n\r\n" +

                "This is a test file content.\r\n" +
                "-----------------------------22722003023680--" +
                "\r\n";

        String httpBody2 = "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"wheelSubmitId\"\r\n\r\n" +

                "fileInputForm\r\n" +
                "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"file2\"; filename=\"test.txt\"\r\n" +
                "Content-Type: text/plain\r\n\r\n" +

                "This is a test file content.\r\n" +
                "-----------------------------22722003023680--" +
                "\r\n";

        String httpBody3 = "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"wheelSubmitId\"\r\n\r\n" +

                "fileInputForm\r\n" +
                "-----------------------------22722003023680\r\n" +
                "Content-Disposition: form-data; name=\"file3\"; filename=\"test.txt\"\r\n" +
                "Content-Type: text/plain\r\n\r\n" +

                "This is a test file content.\r\n" +
                "-----------------------------22722003023680--" +
                "\r\n";

        ByteArrayInputStream in = null;

        try {
            in = new ByteArrayInputStream(httpBody1.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        createFileUpload(in, httpBody1.length(), "---------------------------22722003023680");

        load("FileInput");

        assertXpath("This is a test file content.", "//h1");

        reset();

        try {
            in = new ByteArrayInputStream(httpBody2.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        createFileUpload(in, httpBody2.length(), "---------------------------22722003023680");

        load("FileInput");

        assertXpath("This is a test file content.", "//h2");

        reset();

        try {
            in = new ByteArrayInputStream(httpBody3.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        createFileUpload(in, httpBody3.length(), "---------------------------22722003023680");

        load("FileInput");

        assertXpath("This is a test file content.", "//h3");
        assertXpath("test.txt", "//h4[1]");
        assertXpath("28", "//h4[2]");
        assertXpath("text/plain", "//h4[3]");
    }

    @Test
    public void testNumberInput() {
        reset();
        load("NumberInput");

        assertXpath("10.53", "//input[@id='number1']/@value");

        createForm("numberInputForm");
        addFormField("number1", "105,34343");

        load("NumberInput");

        assertXpath("105.34", "//input[@id='number1']/@value");
    }

    @Test
    public void testRadioGroup() {
        reset();
        load("RadioGroup");

        assertXpath("radioGroup1", "//input[2]/@id");
        assertXpath("radio", "//input[2]/@type");
        assertXpath("1", "//input[2]/@value");
        assertXpath("Hasse", "//span[1]");

        assertXpath("radioGroup12", "//input[3]/@id");
        assertXpath("radio", "//input[3]/@type");
        assertXpath("2", "//input[3]/@value");
        assertXpath("Albert", "//span[2]");

        assertXpath("radioGroup13", "//input[4]/@id");
        assertXpath("radio", "//input[4]/@type");
        assertXpath("3", "//input[4]/@value");
        assertXpath("Paavo", "//span[3]");

        assertXpath("radioGroup14", "//input[5]/@id");
        assertXpath("radio", "//input[5]/@type");
        assertXpath("4", "//input[5]/@value");
        assertXpath("Remu", "//span[4]");

        //enhancing radiogroup
        assertXpath("radioGroup2", "//input[6]/@id");
        assertXpath("radio", "//input[6]/@type");
        assertXpath("1", "//input[6]/@value");
        assertXpath("Hasse Walli", "//p[1]");

        assertXpath("radioGroup22", "//input[7]/@id");
        assertXpath("radio", "//input[7]/@type");
        assertXpath("2", "//input[7]/@value");
        assertXpath("Albert Järvinen", "//p[2]");

        assertXpath("radioGroup23", "//input[8]/@id");
        assertXpath("radio", "//input[8]/@type");
        assertXpath("3", "//input[8]/@value");
        assertXpath("Paavo Maijanen", "//p[3]");

        assertXpath("radioGroup24", "//input[9]/@id");
        assertXpath("radio", "//input[9]/@type");
        assertXpath("4", "//input[9]/@value");
        assertXpath("Remu Aaltonen", "//p[4]");


        createForm("form1");
        addFormField("radioGroup1", "3");
        addFormField("radioGroup2", "4");

        load("RadioGroup");

        assertXpath("checked", "//input[4]/@checked");
        assertXpath("checked", "//input[9]/@checked");
        assertXpath("selected", "//input[9]/@class");
    }

    @Test
    public void testCheckboxGroup() {
        reset();
        load("CheckboxGroup");

        assertXpath("checkboxGroup1", "//input[2]/@id");
        assertXpath("checkbox", "//input[2]/@type");
        assertXpath("1", "//input[2]/@value");
        assertXpath("Hasse", "//span[1]");

        assertXpath("checkboxGroup12", "//input[3]/@id");
        assertXpath("checkbox", "//input[3]/@type");
        assertXpath("2", "//input[3]/@value");
        assertXpath("Albert", "//span[2]");

        assertXpath("checkboxGroup13", "//input[4]/@id");
        assertXpath("checkbox", "//input[4]/@type");
        assertXpath("3", "//input[4]/@value");
        assertXpath("Paavo", "//span[3]");

        assertXpath("checkboxGroup14", "//input[5]/@id");
        assertXpath("checkbox", "//input[5]/@type");
        assertXpath("4", "//input[5]/@value");
        assertXpath("Remu", "//span[4]");

        createForm("form1");
        addFormField("checkboxGroup1", "2");
        addFormField("checkboxGroup1", "3");

        load("CheckboxGroup");

        assertXpath("checked", "//input[3]/@checked");
        assertXpath("checked", "//input[4]/@checked");
        assertXpath("Albert", "//p[1]");
        assertXpath("Paavo", "//p[2]");
    }
}
