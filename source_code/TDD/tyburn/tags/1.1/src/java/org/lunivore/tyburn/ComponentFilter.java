package org.lunivore.tyburn;

import java.awt.Component;

public interface ComponentFilter {

    boolean matches(Component child);
    
}
