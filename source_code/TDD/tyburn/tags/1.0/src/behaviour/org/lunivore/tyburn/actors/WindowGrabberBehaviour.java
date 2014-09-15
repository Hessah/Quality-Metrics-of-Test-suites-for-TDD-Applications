package org.lunivore.tyburn.actors;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;
import org.lunivore.tyburn.Behaviour;
import org.lunivore.tyburn.HeadlessChecker;
import org.lunivore.tyburn.actors.WindowGrabber;
import org.lunivore.tyburn.threaded.QueuedMiniMap;
import org.lunivore.tyburn.threaded.TimeoutException;



public class WindowGrabberBehaviour extends Behaviour {

    @SuppressWarnings("unchecked")
    @Test
    public void shouldGetAnyWindowFromMiniMap() throws TimeoutException {
        checkForHeadless();
        QueuedMiniMap<String, Window> miniMap = mock(QueuedMiniMap.class);
        
        WindowGrabber grabber = new WindowGrabber(miniMap);
        
        grabber.getWindow("frame.name");
        
        verify(miniMap).get("frame.name", WindowGrabber.DEFAULT_WINDOW_TIMEOUT);
        grabber.dispose();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void shouldAddNewWindowsToAndRemoveNewWindowsFromMiniMap() {
        checkForHeadless();
        QueuedMiniMap<String, Window> miniMap = mock(QueuedMiniMap.class);
        WindowGrabber grabber = new WindowGrabber(miniMap);
        
        JFrame frame = new JFrame();
        frame.setName("frame.name");
        frame.setVisible(true);
        frame.dispose();
        waitForIdle();
        grabber.dispose();

        verify(miniMap).put("frame.name", frame);
        verify(miniMap).remove("frame.name");
    }
    
    private void waitForIdle() {
        try {
            // Ensures that window grabber gets close event before mocks verified
            SwingUtilities.invokeAndWait(new Runnable() { public void run() {}});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    private void checkForHeadless() {
        new HeadlessChecker().check();
    }
}
