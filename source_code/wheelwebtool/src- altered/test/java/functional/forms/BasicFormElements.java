package functional.forms;

import functional.BaseTestPage;
import wheel.components.ISelectModel;
import wheel.util.StringSelectModel;

public class BasicFormElements extends BaseTestPage {
    private String selected;
    private boolean bool;
    private boolean bool2 = true;

    public void buildComponent() {
        form("form1").
                hidden("hidden1").value("hidden1Value").end().
                textInput("textInput").value("textInputValue").end().
                textarea("textArea").value("textAreaValue").end().
                radio("radioButton").value("radioValue").end().
                radio("radioButton").value("radioValue2").end().
                select("select1", getSelectModel(), el("selected")).end().
                checkbox("checkbox1").fieldBinding("bool").end().
                checkbox("checkbox2").fieldBinding("bool2").end().
                reset("reset").value("resetValue").end().
                buttonInput("button1").value("buttonValue").end().
                imageSubmit("imageSubmit1", "submit.gif").end().
                fileInput("fileInput").end().
                submit("submit1").value("submit1Value");
    }

    private ISelectModel getSelectModel() {
        StringSelectModel model = new StringSelectModel();
        model.addValue("1", "first");
        model.addValue("2", "second");
        model.addValue("3", "third");

        return model;
    }
}
