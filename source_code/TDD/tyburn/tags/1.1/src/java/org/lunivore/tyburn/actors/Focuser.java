package org.lunivore.tyburn.actors;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import org.lunivore.tyburn.Speed;


public class Focuser {

    private final Speed speed;

    public Focuser(Speed speed) {
		this.speed = speed;
	}
    
	public void requestFocusOn(Component component) {
        if (!component.hasFocus()) {
            QueueingFocusListener focusListener = new QueueingFocusListener(component, speed);
            component.requestFocus();
            focusListener.waitForEvent();
        }
    }

    private class QueueingFocusListener extends QueueingComponentListener<Component> implements FocusListener {
        
        public QueueingFocusListener(Component component, Speed speed) {
            super(component, "FocusEvent", speed);
        }
        
        public void focusGained(FocusEvent e) {
            eventOccurred(e);
        }

        public void focusLost(FocusEvent e) {}
        
        protected void addSelfToComponent() {
            component.addFocusListener(this);
        }

        protected void removeSelfFromComponent() {
            component.removeFocusListener(this);
        }
    }   
}
