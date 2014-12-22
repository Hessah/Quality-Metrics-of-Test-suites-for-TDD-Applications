package functional.errorhandling;

import functional.BaseTestPage;
import wheel.annotations.ActionMethod;
import wheel.RedirectException;

import java.io.IOException;

public class ErrorGeneratingPage extends BaseTestPage {
    @Override
    public void preBuild() {
        getEngine().addErrorMapping("java.lang.IllegalStateException", "ErrorPage");
        getEngine().addErrorMapping("java.io.IOException", "ErrorPage");
    }

    public void buildComponent() {
    }

    @ActionMethod
    public void uncheckedException() {
        throw new IllegalStateException("Test error 1");
    }

    @ActionMethod
    public void checkedException() throws IOException {
        throw new IOException("Test error 2");
    }

    @ActionMethod
    public void redirectException1()  {
        throw new RedirectException(new RedirectPage());
    }

    @ActionMethod
    public void redirectException2()  {
        throw new RedirectException("http://www.dilbert.com/");
    }
}
