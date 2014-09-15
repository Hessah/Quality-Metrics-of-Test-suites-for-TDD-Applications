package org.lunivore.tyburn.actors;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import org.lunivore.tyburn.Speed;
import org.lunivore.tyburn.listeners.QueueingKeyAdapter;
import org.lunivore.tyburn.threaded.TimeoutException;

/**
 * Used for pressing or typing all keys which have valid characters associated with them.
 */
public class CharacterTyper {

    private EventQueue sysQueue;
    private Idler idler;
    private Focuser focuser;
	private final Speed speed;

    public CharacterTyper(Speed speed) {
        this.speed = speed;
		sysQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        idler = new Idler();
        focuser = new Focuser(speed);
    }
    
    public void typeIntoComponent(Component component, String text) {
        focuser.requestFocusOn(component);
        QueueingKeyAdapter queuer;
        
        for (int i = 0; i < text.length(); i++) {
            if (component instanceof JComboBox && ((JComboBox) component).isEditable()) {
                queuer = new QueueingKeyAdapter(((JComboBox) component).getEditor().getEditorComponent(), speed);
            } else {
                queuer = new QueueingKeyAdapter(component, speed);
            }
            postKeyEvent(component, text.charAt(i));
            queuer.waitForEvent();
        }
    }
    
    /**
     * Use this for any key which has a valid character associated with it, when it is being pressed
     * (eg: as a game control key) rather than being typed into a text component.
     */
    public void pressKeychar(Window window, char key) throws TimeoutException {
        QueueingKeyAdapter queuer = null;
        
        if(window instanceof JFrame) {
            Container contentPane = ((JFrame)window).getContentPane();
            if (contentPane instanceof JComponent) {
                queuer = new QueueingKeyAdapter(contentPane, speed);
                focuser.requestFocusOn(contentPane);
            }
        } else {
            queuer = new QueueingKeyAdapter(window.getFocusOwner(), speed);
            focuser.requestFocusOn(window.getFocusOwner());
        }
        
        postKeyEvent(window, key);
        queuer.waitForEvent();
    }

    public void pressKeycode(Window window, int keycode) {
        QueueingKeyAdapter queuer = null;
        
        if(window instanceof JFrame) {
            Container contentPane = ((JFrame)window).getContentPane();
            if (contentPane instanceof JComponent) {
                queuer = new QueueingKeyAdapter(contentPane, speed);
                focuser.requestFocusOn(contentPane);
            }
        } else {
            queuer = new QueueingKeyAdapter(window.getFocusOwner(), speed);
            focuser.requestFocusOn(window.getFocusOwner());
        }
        
        postKeycodeEvent(window, keycode);
        queuer.waitForEvent();
    }

    private void postKeycodeEvent(Window window, int keycode) {
        sysQueue.postEvent(createKeyPressEvent(window, keycode, KeyEvent.KEY_PRESSED));
        sysQueue.postEvent(createKeyPressEvent(window, keycode, KeyEvent.KEY_RELEASED));  
        idler.waitForIdle();
    }

    private void postKeyEvent(final Component component, final char key) {
        sysQueue.postEvent(createKeyPressEvent(component, key, KeyEvent.KEY_PRESSED));
        sysQueue.postEvent(createKeyPressEvent(component, key, KeyEvent.KEY_RELEASED));
        sysQueue.postEvent(createKeyPressEvent(component, key, KeyEvent.KEY_TYPED));    
        idler.waitForIdle();
    }
    
    private AWTEvent createKeyPressEvent(Component component, char c, int id) {
        return new KeyEvent(component, 
                id, 
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                c);
    }
    
    private AWTEvent createKeyPressEvent(Component component, int keycode, int id) {
        return new KeyEvent(component, 
                id, 
                System.currentTimeMillis(),
                0,
                keycode,
                KeyEvent.CHAR_UNDEFINED);
    }
}
