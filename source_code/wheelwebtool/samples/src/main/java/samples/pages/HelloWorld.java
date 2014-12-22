package samples.pages;

public class HelloWorld extends SamplesApp {
    public void buildComponent() {
        super.buildComponent();

        h1("Hello World!");
        a("Back").actionBinding("Home");
    }
}
