package org.lunivore.tyburn.threaded;

public interface Timeouter {

    void start(long timeout);
    
    void checkTime() throws TimeoutException;

    long getTimeLeftIfAny();

}
