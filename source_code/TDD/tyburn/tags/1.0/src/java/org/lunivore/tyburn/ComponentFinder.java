package org.lunivore.tyburn;

import java.awt.Component;
import java.awt.Container;
import java.util.HashSet;
import java.util.Set;

public class ComponentFinder {

    public Component findExactComponent(Container container, ComponentFilter filter) throws ComponentFinderException {
        Component[] matchedComponents = findComponents(container, filter);
        if (matchedComponents.length == 0) {
            throw new ComponentFinderException("No matching component found");
        }
        if (matchedComponents.length > 1) {
            throw new ComponentFinderException("More than one matching component found");
        }
        return matchedComponents[0];
    }
    
    public Component[] findComponents(Container container, ComponentFilter filter) {
        Set<Component> matchedSet = new HashSet<Component>();
        addMatchingComponentsToSet(container, filter, matchedSet);
        return matchedSet.toArray(new Component[matchedSet.size()]);
    }
    
    private void addMatchingComponentsToSet(Container container, ComponentFilter filter, Set<Component> matchedSet) {
        int numberOfChildren = container.getComponentCount();
        for (int i = 0; i < numberOfChildren; i++) {
            Component child = container.getComponent(i);
            if (filter.matches(child)) matchedSet.add(child);
            if (child instanceof Container) {
                addMatchingComponentsToSet((Container)child, filter, matchedSet);
            }
        }
    }
}
