package functional.xhtml;

import functional.BaseTestPage;

public class FramesPage extends BaseTestPage {
    public void buildComponent() {
        body().attribute("cols", "33%, 33%, 33%");

        noframes().p("Your browser doesn't handle frames.");
        frame("frame1.html");
        frame("frame2.html");
        frame("frame3.html");
        
    }
}
