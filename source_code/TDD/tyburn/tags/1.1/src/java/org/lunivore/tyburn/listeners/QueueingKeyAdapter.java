/**
 * 
 */
package org.lunivore.tyburn.listeners;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.lunivore.tyburn.Speed;
import org.lunivore.tyburn.actors.QueueingComponentListener;

public class QueueingKeyAdapter extends QueueingComponentListener<Component> implements KeyListener {
    
    public QueueingKeyAdapter(Component component, Speed speed) {
        super(component, "KeyEvent", speed);
    }
    
    protected void addSelfToComponent() {
        component.addKeyListener(this);
    }
    protected void removeSelfFromComponent() {
        component.removeKeyListener(this);
    }
    
    public void keyPressed(KeyEvent e) {
        // Wait for key to be released or typed
    }
    
    public void keyReleased(KeyEvent e) {
        eventOccurred(e);
    }
    
    public void keyTyped(KeyEvent e) {
        eventOccurred(e);
    }
}