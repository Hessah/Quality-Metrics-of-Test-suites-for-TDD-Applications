package functional.forms;

import functional.BaseTestPage;

public class ValidationPage extends BaseTestPage {
    public void buildComponent() {
        form("form1", action("this.doPost")).
                textInput("required").required().end().
                textInput("int").isInt().end().
                textInput("required2").validationRule("required(value)").end().
                textInput("int2").validationRule("isInt(value)").end().
                textInput("numberRange").validationRule("isInt(value) && value > 0 && value < 100").end().
                textInput("email").validationRule("isEmail(value)", "email error").end().
                textInput("double").validationRule("isDouble(value)", "double error");

        if(!isValid("required"))
            h1("required error");

        if(!isValid("int"))
            h1("int error");

        if(!isValid("required2"))
                    h1("required2 error");

        if(!isValid("int2"))
            h1("int2 error");

        if(!isValid("numberRange"))
            h1("numberRange error");

        if (!isValid("email"))
            h2(getError("email").getMessage());

        if(!isValid("double"))
            h3(getError("double").getMessage());

    }
}
