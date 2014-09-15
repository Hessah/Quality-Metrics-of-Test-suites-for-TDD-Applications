package org.lunivore.tyburn.threaded;

public class ClockedTimeouter implements Timeouter {
    private Clock clock;
    private long endTime;
    
    public ClockedTimeouter(Clock clock) {
        this.clock = clock;
    }

    public void checkTime() throws TimeoutException {
        if (endTime <= clock.getTimeInMillis()) throw new TimeoutException();
    }

    public long getTimeLeftIfAny() {
        return endTime - clock.getTimeInMillis();
    }

    /** Overrides any previously set timeout. */
    public void start(long timeout) {
        this.endTime = clock.getTimeInMillis() + timeout;
    }

}
