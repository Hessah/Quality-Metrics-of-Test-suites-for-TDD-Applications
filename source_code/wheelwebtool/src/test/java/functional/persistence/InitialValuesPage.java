package functional.persistence;

import functional.BaseTestPage;
import wheel.annotations.Persist;

import java.util.List;
import java.util.LinkedList;

public class InitialValuesPage extends BaseTestPage {
    @Persist
    private String field1 = "initialValue";

    @Persist
    private String field2;

    @Persist
    private List<String> list1;

    public InitialValuesPage() {
        field2 = "initialValue2";
        list1 = new LinkedList<String>();
        list1.add("one");
        list1.add("two");
    }

    public void buildComponent() {
        h1(field1);
        h2(field2);

        for (String s : list1) {
            h3(s);
        }
    }
}
