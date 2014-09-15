package org.lunivore.tyburn.actors;

import java.awt.AWTEvent;
import java.awt.Component;

import org.lunivore.tyburn.threaded.QueuedObjectHolder;
import org.lunivore.tyburn.threaded.TimeoutException;

/**
 * Used by the actors who are asked to sense events. This listener will add itself to
 * the component when created, and remove itself if the event is sensed or if it times out.
 * The actual implementation of adding, removing and sensing the event is up to the
 * subclass; see 
 */
public abstract class QueueingComponentListener<T extends Component> {

    private QueuedObjectHolder<AWTEvent> holder = new QueuedObjectHolder<AWTEvent>();
    private Idler idler = new Idler();
    protected final T component;
    private String eventType;

    public QueueingComponentListener(T component, String eventType) {
        this.component = component;
        this.eventType = eventType;
        addSelfToComponent();
    }

    public void waitForEvent() {
        try {
            holder.get(1000);
        } catch (TimeoutException e) {
            removeSelfFromComponent();
            throw new RuntimeException("Expected " + eventType + " on component " + component.getName() + " was not received");
        }
        holder.clear();
        removeSelfFromComponent();
        idler.waitForIdle();
    }

    protected abstract void addSelfToComponent();
    
    protected abstract void removeSelfFromComponent();
    
    public void eventOccurred(AWTEvent e) {
        holder.set(e);
    }

}
