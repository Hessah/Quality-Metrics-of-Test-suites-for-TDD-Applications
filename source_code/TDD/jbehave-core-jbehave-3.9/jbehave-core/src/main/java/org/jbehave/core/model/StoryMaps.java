package org.jbehave.core.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Provides an view of a list of {@link StoryMap}s, indexed by meta filters.
 */
public class StoryMaps {
    
    private Map<String, StoryMap> indexed = new LinkedHashMap<String, StoryMap>();

    public StoryMaps(List<StoryMap> maps) {
        index(maps);
    }

    private void index(List<StoryMap> storyMaps) {
        for (StoryMap storyMap : storyMaps) {
            indexed.put(storyMap.getMetaFilter(), storyMap);
        }
    }

    public List<String> getMetaFilters() {
        return new ArrayList<String>(indexed.keySet());
    }

    public StoryMap getMap(String metaFilter) {
        return indexed.get(metaFilter);
    }

    public List<StoryMap> getMaps() {
        return new ArrayList<StoryMap>(indexed.values());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("metaFilters", indexed.keySet()).toString();
    }

}
