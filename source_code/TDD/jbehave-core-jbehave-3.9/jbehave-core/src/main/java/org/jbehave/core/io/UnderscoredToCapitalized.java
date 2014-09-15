package org.jbehave.core.io;

import static org.apache.commons.lang.StringUtils.contains;
import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;
import static org.apache.commons.lang.WordUtils.capitalize;

public class UnderscoredToCapitalized implements StoryNameResolver {

    private final String extension;

    public UnderscoredToCapitalized() {
        this(".story");
    }

    public UnderscoredToCapitalized(String extension) {
        this.extension = extension;
    }

    public String resolveName(String path) {
        String name = path;
        if (contains(name, extension)) {
            name = substringBeforeLast(name, extension);
        }
        if (contains(name, '/')) {
            name = substringAfterLast(name, "/");
        }
        if (contains(name, '.')) {
            name = substringAfterLast(name, ".");
        }
        return capitalize(name.replace("_", " "));
    }

}
