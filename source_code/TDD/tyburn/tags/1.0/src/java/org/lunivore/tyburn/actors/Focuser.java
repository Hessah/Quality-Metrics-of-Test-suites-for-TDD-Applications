package org.lunivore.tyburn.actors;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class Focuser {

    public void requestFocusOn(Component component) {
        if (!component.hasFocus()) {
            QueueingFocusListener focusListener = new QueueingFocusListener(component);
            component.requestFocus();
            focusListener.waitForEvent();
        }
    }

    private class QueueingFocusListener extends QueueingComponentListener<Component> implements FocusListener {
        
        public QueueingFocusListener(Component component) {
            super(component, "FocusEvent");
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
