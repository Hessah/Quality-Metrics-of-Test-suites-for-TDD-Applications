package functional.errorhandling;

import functional.BaseTestPage;

public class RedirectPage extends BaseTestPage {
    @Override
    public void preBuild() {
        config()._setRenderDoctype(false);
    }

    public void buildComponent() {
        h1("Redirect page");
    }
}
