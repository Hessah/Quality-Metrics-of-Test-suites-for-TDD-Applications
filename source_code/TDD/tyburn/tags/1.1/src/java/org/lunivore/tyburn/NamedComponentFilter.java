package org.lunivore.tyburn;

import java.awt.Component;

public class NamedComponentFilter implements ComponentFilter {

    private String name;

    public NamedComponentFilter(String name) {
        this.name = name;
    }

    public boolean matches(Component child) {
        if (name == null) return child.getName() == null;
        return name.equals(child.getName());
    }

}
