package org.lunivore.tyburn.actors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import org.lunivore.tyburn.threaded.TimeoutException;

public class ButtonClicker {
    
    private Idler idler;

    public ButtonClicker() {
        idler = new Idler();
    }
    
    public void click(AbstractButton button) throws TimeoutException {
        QueueingButtonClicker queuer = new QueueingButtonClicker(button);
        
        try {
            button.doClick(200);
            queuer.waitForEvent();
        } finally {
            queuer.removeSelfFromComponent();
        }
        idler.waitForIdle();
    }

    private class QueueingButtonClicker extends QueueingComponentListener<AbstractButton> implements ActionListener {
        public QueueingButtonClicker(AbstractButton button) {
            super(button, "button click");
        }
        
        public void actionPerformed(ActionEvent e) {
            eventOccurred(e);
        }

        @Override
        protected void addSelfToComponent() {
            component.addActionListener(this);
        }

        @Override
        protected void removeSelfFromComponent() {
            component.removeActionListener(this);
        }
        
    }
}
