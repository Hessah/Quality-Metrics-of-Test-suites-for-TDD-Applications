package samples.pages;

import wheel.components.ISelectModel;
import wheel.util.StringSelectModel;

public class Home extends SamplesApp {
    private boolean bool = true;
    private String sel;

    public void buildComponent() {
        super.buildComponent();

        div().clasS("main").
            h1("Samples application").end().
            h3("Available samples").end().
            ol().
                li().a("HelloWorld").actionBinding("HelloWorld").up(2).
                li().a("Number guessing game").actionBinding("NumberGuessing").up(2).
                li().a("Localization example").actionBinding("LocalizationExample").up(2).
                li().a("Layout example").actionBinding("LayoutExample").up(2).
                li().a("Tabbed panel example").actionBinding("TabbedPanelExample");

    }

    private ISelectModel getSelectModel() {
        StringSelectModel model = new StringSelectModel();
        model.addValue("1", "first");
        model.addValue("2", "second");
        model.addValue("3", "third");

        return model;
    }
}
