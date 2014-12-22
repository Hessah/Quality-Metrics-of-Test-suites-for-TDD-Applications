package functional.localization;

import java.util.Locale;

import wheel.annotations.ActionMethod;

public class Localized extends ParentComponent {
    public void buildComponent() {
        h1(message("message1"));
        h2(message("message2", "replacement1", "replacement2"));
        h3(message("message3"));
        h4(message("message4"));
    }

    @ActionMethod
    public void changeLocale() {
        getEngine().setLocale(new Locale("se"));
    }
}
