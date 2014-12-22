package functional.errorhandling;

import functional.BaseTestPage;

public class ErrorPage extends BaseTestPage {
    @Override
    public void preBuild() {
        config()._setRenderDoctype(false);
    }
    
    public void buildComponent() {
        Throwable error = getEngine().getError();

        if (error != null)
            h1(error.getMessage());
    }
}
