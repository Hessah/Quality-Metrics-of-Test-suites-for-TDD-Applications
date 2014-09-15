package org.lunivore.tyburn.threaded;

public class QueuedObjectHolder<T> {

    public static final long DEFAULT_TIMEOUT = 30000;
    
    private T object;
    private Object waitingPlace = new Object();
    private final ClockedTimeouterFactory timeouterFactory;
    private final long timeoutInMillis;

    public QueuedObjectHolder() {
        this(DEFAULT_TIMEOUT);
    }
    
    public QueuedObjectHolder(long timeoutInMillis) {
        this(new ClockedTimeouterFactory(), timeoutInMillis);
    }


    public QueuedObjectHolder(ClockedTimeouterFactory factory) {
        this(factory, DEFAULT_TIMEOUT);
    }
    
    public QueuedObjectHolder(ClockedTimeouterFactory factory, long timeoutInMillis) {
        this.timeouterFactory = factory;
        this.timeoutInMillis = timeoutInMillis;
    }

    public void set(T object) {
        this.object = object;
        synchronized(waitingPlace) {
            waitingPlace.notifyAll();
        }
    }

    public T get() throws TimeoutException {
        return get(timeoutInMillis);
    }
    
    public T get(long timeoutInMillis) throws TimeoutException {
        Timeouter timeouter = timeouterFactory.createTimeouter();
        timeouter.start(timeoutInMillis);
        synchronized(waitingPlace) {    
            while (object == null) {
                timeouter.checkTime();
                try {
                    waitingPlace.wait(timeouter.getTimeLeftIfAny());
                } catch (InterruptedException ie) {}
            }
        }
        return object;
    }

    public void clear() {
        synchronized(waitingPlace) {
            object = null;
        }
    }

}
