package org.jbehave.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GivenStories {
    
    public static final GivenStories EMPTY = new GivenStories("");

    private final List<GivenStory> givenStories = new ArrayList<GivenStory>();
    private final String givenStoriesAsString;
    private ExamplesTable examplesTable = ExamplesTable.EMPTY;

    public GivenStories(String givenStoriesAsString) {
        this.givenStoriesAsString = givenStoriesAsString;
        if ( !StringUtils.isBlank(givenStoriesAsString) ){
            parse();            
        }
    }

    private void parse() {
        givenStories.clear();
        for (String storyPath : givenStoriesAsString.split(",", -1)) {
            givenStories.add(new GivenStory(storyPath));
        }
    }

    public List<GivenStory> getStories() {
        for (GivenStory givenStory : givenStories) {            
            givenStory.useParameters(parametersByAnchor(givenStory.getAnchor()));
        }
        return givenStories;
    }

    private Map<String, String> parametersByAnchor(String anchor) {
        int examplesRow = -1;
        if ( !StringUtils.isBlank(anchor) ){
            try {
                examplesRow = Integer.parseInt(anchor);
            } catch (NumberFormatException e) {
                // continue
            }
        }
        Map<String, String> parameters = null;
        if ( examplesRow > -1 && examplesRow < examplesTable.getRowCount() ){
             parameters = examplesTable.getRow(examplesRow);
        }
        if ( parameters == null ){
            return new HashMap<String, String>();
        }
        return parameters;
    }

    public List<String> getPaths() {
        List<String> paths = new ArrayList<String>();
        for (GivenStory story : givenStories) {
            paths.add(story.asString().trim());
        }
        return Collections.unmodifiableList(paths);
    }

    public boolean requireParameters() {
        for (GivenStory givenStory : givenStories) {
            if ( givenStory.hasAnchor() ){
                return true;
            }
        }
        return false;
    }

    public void useExamplesTable(ExamplesTable examplesTable) {
        this.examplesTable = examplesTable;
    }
    
    public String asString() {
        return givenStoriesAsString;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
