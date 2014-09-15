package org.lunivore.tyburn.actors;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.lunivore.tyburn.Speed;

public class MouseClicker {

    private Idler idler;
	private EventQueue sysQueue;
	private final Speed speed;

    public MouseClicker(Speed speed) {
        this.speed = speed;
		idler = new Idler();
        sysQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
    }
    
	public void click(Component component, int x, int y) {
		QueueingMouseClicker queuer = new QueueingMouseClicker(component);
        
        try {
            sysQueue.postEvent(new MouseEvent(component, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), MouseEvent.BUTTON1_MASK, x, y, 1, false));
            sysQueue.postEvent(new MouseEvent(component, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), MouseEvent.BUTTON1_MASK, x, y, 1, false));
            sysQueue.postEvent(new MouseEvent(component, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), MouseEvent.BUTTON1_MASK, x, y, 1, false));
            queuer.waitForEvent();
        } finally {
            queuer.removeSelfFromComponent();
        }
        idler.waitForIdle();
	}

    private class QueueingMouseClicker extends QueueingComponentListener<Component> implements MouseListener {
        public QueueingMouseClicker(Component component) {
            super(component, "mouse click", speed);
        }
        
        public void mouseClicked(MouseEvent e) {
        	eventOccurred(e);
        }

        @Override
        protected void addSelfToComponent() {
            component.addMouseListener(this);
        }

        @Override
        protected void removeSelfFromComponent() {
            component.removeMouseListener(this);
        }

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
        
    }

}
