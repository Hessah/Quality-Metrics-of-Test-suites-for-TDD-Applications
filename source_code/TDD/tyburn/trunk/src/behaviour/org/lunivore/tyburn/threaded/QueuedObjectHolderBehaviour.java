package org.lunivore.tyburn.threaded;

import org.junit.Test;
import org.lunivore.tyburn.Behaviour;

public class QueuedObjectHolderBehaviour extends Behaviour {
    
    @Test
    public void shouldReturnExistingObject() throws TimeoutException {
        QueuedObjectHolder<String> holder = new QueuedObjectHolder<String>(1000);
        holder.set("Frodo");
        ensureThat(holder.get(), eq("Frodo"));
    }
    
    @Test
    public void shouldReturnObjectWhenAddedLater() {
        final QueuedObjectHolder<String> holderUnderTest = new QueuedObjectHolder<String>(1000);
        
        final ObjectHolder<String> ourHolder = new ObjectHolder<String>();
        
        Thread threadForGetToRun = new Thread(new Runnable() {
            public void run() {
                try {
                    ourHolder.held = holderUnderTest.get();
                } catch (TimeoutException e) { }
                synchronized(QueuedObjectHolderBehaviour.this) {
                    QueuedObjectHolderBehaviour.this.notifyAll();
                }
            }
        });
        
        threadForGetToRun.start();
        
        // Add an item to the holder. Wait for thread to initialise and
        // start getting things.
        synchronized (this) {
            try {
                wait(200); 
            } catch (InterruptedException e) {};
            
            holderUnderTest.set("Frodo");
            try {
                while (threadForGetToRun.isAlive()) { wait(200); }
            } catch (InterruptedException e) {}
        }
        
        ensureThat(ourHolder.held, eq("Frodo"));
    }
    
    @Test
    public void shouldTimeoutIfTooLate() {
        PseudoClock clock = new PseudoClock();
        
        final QueuedObjectHolder<ClockedTimeouterFactory> holderUnderTest = 
            new QueuedObjectHolder<ClockedTimeouterFactory>(new ClockedTimeouterFactory(clock), 100);
        final ObjectHolder<TimeoutException> ourHolder = new ObjectHolder<TimeoutException>();
        
        Thread threadForGetToRun = new Thread(new Runnable() {
            public void run() {
                try  {
                    holderUnderTest.get();
                } catch (TimeoutException e) {
                    ourHolder.held = e;
                }
                synchronized(QueuedObjectHolderBehaviour.this) {
                    QueuedObjectHolderBehaviour.this.notifyAll();
                }
            }
        });
        
        threadForGetToRun.start();          
        
        synchronized (this) {
            // Wait for a short while to let the thread run
            try {
                wait(100); 
            } catch (InterruptedException e) {};
        }
        

        clock.setTimeInMillis(clock.getTimeInMillis() + 2000);           

        synchronized (this) {
            // Wait for a short while to let the thread throw exception
            try {
                while (threadForGetToRun.isAlive()) { wait(100); }
            } catch (InterruptedException e) {};
        }
                        
        ensureThat(ourHolder.held, isA(TimeoutException.class));
    }    
    
    private static class ObjectHolder<T> {
        private T held;
    }
}
