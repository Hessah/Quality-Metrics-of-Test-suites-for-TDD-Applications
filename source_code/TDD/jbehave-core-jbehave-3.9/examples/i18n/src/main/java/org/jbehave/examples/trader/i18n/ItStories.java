package org.jbehave.examples.trader.i18n;

import java.util.Locale;

import org.jbehave.examples.trader.i18n.steps.ItSteps;


public class ItStories extends LocalizedStories {
    
    @Override
    protected Locale locale() {
        return new Locale("it");
    }

    @Override
    protected String storyPattern() {
        return "**/*.storia";
    }

    @Override
    protected Object localizedSteps() {
        return new ItSteps();
    }
 
}
