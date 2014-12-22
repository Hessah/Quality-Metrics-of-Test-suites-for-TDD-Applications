package samples.pages;

import samples.components.BorderLayout;
import samples.components.NumberGuessingComponent;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LayoutExample extends SamplesApp {
    public void buildComponent() {
        super.buildComponent();

        BorderLayout layout = new BorderLayout("150", "*", "150");
        add(layout);

        layout.north().
            h4("This page shows these features of Wheel:").end().
            ol().
                li("How to use a layout component.").end().
                li("How powerful reusable components are in Wheel.").end().
                li("How assets work for pages and for reusable components");

        layout.west().
                h5("NumberGuessingComponent #1").end().
                add(new NumberGuessing("ng1")).end().
                h5("This is west placeholder that has a set width of 150px.");

        layout.center().
                h5("NumberGuessingComponent #2").end().
                add(new NumberGuessing("ng2"));

        layout.center().
                h5("This is center placeholder in the BorderLayout. This part of the page will expand horizontally as required.");


        layout.east().
                h5("NumberGuessingComponent #3").end().
                add(new NumberGuessing("ng3"));

    }
}
