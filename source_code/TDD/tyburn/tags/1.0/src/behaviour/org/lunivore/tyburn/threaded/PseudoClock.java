package org.lunivore.tyburn.threaded;

import org.lunivore.tyburn.threaded.Clock;


public class PseudoClock implements Clock {

    private long timeInMillis;

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

}
