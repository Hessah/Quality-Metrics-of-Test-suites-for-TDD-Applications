package functional.forms;

import functional.BaseTestPage;
import wheel.annotations.Persist;

public class Checkbox extends BaseTestPage {
    private boolean b;
    @Persist
    private boolean b2 = true;

    public void buildComponent() {
        form("checkboxForm").
                checkbox("simple").value("true").end().
                checkbox("bound").fieldBinding("b").end().
                checkbox("bound2").fieldBinding("b2");
    }
}
