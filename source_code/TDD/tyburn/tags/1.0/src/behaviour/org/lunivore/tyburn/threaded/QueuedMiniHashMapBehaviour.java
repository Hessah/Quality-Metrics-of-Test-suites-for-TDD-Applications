package org.lunivore.tyburn.threaded;

import org.junit.Test;
import org.lunivore.tyburn.Behaviour;



public class QueuedMiniHashMapBehaviour extends Behaviour {
    
    private PseudoClock clock = new PseudoClock();
    
    @Test
    public void shouldReturnExistingObjectMatchingKey() throws TimeoutException {
        QueuedMiniHashMap<String, String> queuedMiniMap = new QueuedMiniHashMap<String, String>(new ClockedTimeouterFactory(clock));
        
        queuedMiniMap.put("F", "Frodo");
        ensureThat(queuedMiniMap.get("F", 100), eq("Frodo"));
    }
    
    @Test
    public void shouldReturnObjectMatchingKeyWhenAddedLater() {
        final QueuedMiniHashMap<String, String> queuedMiniMap = new QueuedMiniHashMap<String, String>(new ClockedTimeouterFactory(clock));
        final ObjectHolder objectHolder = new ObjectHolder();
        
        Thread threadForGetToRun = new Thread(new Runnable() {
            public void run() {
                try {
                    objectHolder.object = queuedMiniMap.get("F", 100);
                } catch (TimeoutException e) { }
                synchronized(QueuedMiniHashMapBehaviour.this) {
                    QueuedMiniHashMapBehaviour.this.notifyAll();
                }
            }
        });
        
        threadForGetToRun.start();
        
        // Add an item to the map. Wait until all objects verified
        // before ending the test.
        synchronized (this) {
            // Wait for a short while, just to be sure that the getThread is running and
            // waiting on the item (otherwise this test passes anyway, bizarrely)
            try {
                wait(200); 
            } catch (InterruptedException e) {};
            
            queuedMiniMap.put("F", "Frodo");
            try {
                while (threadForGetToRun.isAlive()) { wait(200); }
            } catch (InterruptedException e) {}
        }
        ensureThat(objectHolder.object, eq((Object)"Frodo"));
    }
    
    @Test
    public void shouldTimeoutIfTooLate() {
        final ObjectHolder objectHolder = new ObjectHolder();
        final QueuedMiniHashMap<String, String> queuedMiniMap = 
            new QueuedMiniHashMap<String, String>(new ClockedTimeouterFactory(clock));
        
        Thread threadForGetToRun = new Thread(new Runnable() {
            public void run() {
                try  {
                    queuedMiniMap.get("F", 100);
                } catch (TimeoutException e) {
                    objectHolder.object = e;
                }
                synchronized(QueuedMiniHashMapBehaviour.this) {
                    QueuedMiniHashMapBehaviour.this.notifyAll();
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
                        
        ensureThat((Exception)objectHolder.object, isA(TimeoutException.class));
    }
    
    private class ObjectHolder {
        public Object object;
    }
}
