package org.lunivore.tyburn.actors;

import javax.swing.SwingUtilities;

public class Idler {
    
    private static final Runnable EMPTY_RUNNABLE = new Runnable() { public void run() {}};

    public Idler() {
    }
    
    public void waitForIdle() {
        try {
            SwingUtilities.invokeAndWait(EMPTY_RUNNABLE);
        } catch (Exception ignored) {}
    }
}
