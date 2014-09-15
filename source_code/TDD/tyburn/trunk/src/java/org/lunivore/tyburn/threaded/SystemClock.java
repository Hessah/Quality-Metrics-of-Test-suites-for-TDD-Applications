package org.lunivore.tyburn.threaded;

public class SystemClock implements Clock {

    public long getTimeInMillis() {
        return System.currentTimeMillis();
    }

}
