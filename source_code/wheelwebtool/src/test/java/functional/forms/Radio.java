package functional.forms;

import functional.BaseTestPage;

public class Radio extends BaseTestPage {
    private String field1 = "field1Value";
    private boolean b;

    public void buildComponent() {
        form("radioForm").
                radio("radio1").end().
                radio("radio2").value("radio2Value").end().
                radio("radio3").fieldBinding("field1").end().
                radio("radio2").value("radio2Value2").end().
                radio("radio2").value("radio2Value3");
    }
}
