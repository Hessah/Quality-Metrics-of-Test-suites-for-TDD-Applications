package samples.pages;

import wheel.annotations.ActionMethod;
import wheel.annotations.Persist;

import java.util.Locale;

public class LocalizationExample extends SamplesApp {
    @Persist
    private Locale locale;

    @Override
    public void preBuild() {
        if (locale != null)
            getEngine().setLocale(locale);
    }

    public void buildComponent() {
        super.buildComponent();

        h3(message("message1"));
        h4(message("message2"));
        h4(message("appMessage1"));
        h4(message("replacementExample", "##Replacement 0##", "##Replacement 1##"));
        a(message("frontpageLinkText")).actionBinding(message("frontpageLinkHref"));
        br();
        a("Change locale").actionBinding("this.changeLocale");
    }

    @ActionMethod
    public void changeLocale() {
        this.locale = new Locale("se");
        getEngine().setLocale(locale);
    }
}
