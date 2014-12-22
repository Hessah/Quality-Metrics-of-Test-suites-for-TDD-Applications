package functional.errorhandling;

import functional.BaseTestPage;

public class ErrorGeneratingPage2 extends BaseTestPage {
    @Override
    public void preBuild() {
        getEngine().addErrorMapping("java.lang.IllegalStateException", "ErrorPage");
    }

    public void buildComponent() {
        throw new IllegalStateException("Test error 3");
    }
}
