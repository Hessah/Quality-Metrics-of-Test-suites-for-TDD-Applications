package functional.forms;

import functional.BaseTestPage;

public class NumberInput extends BaseTestPage {
    private double number1 = 10.53434;

    public void buildComponent() {
        form("numberInputForm").
                numberInput("number1", "##.##").fieldBinding("number1");
    }
}
