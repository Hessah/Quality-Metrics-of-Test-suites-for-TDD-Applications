package org.lunivore.tyburn;

import java.awt.HeadlessException;


public class HeadlessChecker {

    public void check() throws HeadlessException {
        if (isHeadless()) {
            throw new HeadlessException("Cannot verify behaviour when performing in headless mode.");
        }
    }

    public boolean isHeadless() {
        return "true".equals(System.getProperty("java.awt.headless"));
    }

}
