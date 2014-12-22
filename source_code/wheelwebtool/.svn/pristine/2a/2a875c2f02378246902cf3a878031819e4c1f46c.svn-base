package functional.forms;

import functional.BaseTestPage;
import wheel.components.Form;
import wheel.annotations.Persist;

public class TextInput extends BaseTestPage {
    private String bound1;
    private String bound2 = "default value";
    @Persist
    private int bound3 = 45;
    private String bound4;

    public void buildComponent() {
        Form form = (Form)form("textInput");

        form.textInput("unbound_no_value");
        form.textInput("unbound_value").value("unboundValue");
        form.textInput("bound_no_value").fieldBinding("bound1");
        form.textInput("bound_default_value").fieldBinding("bound2");
        form.textInput("bound_persist").fieldBinding("bound3");
        form.textInput("bound_initial_value") .fieldBinding("bound4").initialFieldValue("initial value");
    }
}
