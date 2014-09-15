package org.lunivore.tyburn.actors;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;
import org.lunivore.tyburn.Behaviour;
import org.lunivore.tyburn.HeadlessChecker;
import org.lunivore.tyburn.threaded.QueuedMiniHashMap;
import org.lunivore.tyburn.threaded.QueuedMiniMap;
import org.lunivore.tyburn.threaded.TimeoutException;

public class WindowGrabberBehaviour extends Behaviour {

    @SuppressWarnings("unchecked")
    @Test
    public void shouldGetAnyWindowFromMiniMap() throws TimeoutException {
        checkForHeadless();
        QueuedMiniMap<String, Window> miniMap = mock(QueuedMiniMap.class);
        
        WindowGrabber grabber = new WindowGrabber(miniMap);
        
        grabber.getWindow("frame.name", 1000);
        
        verify(miniMap).get("frame.name", 1000);
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
    
    @Test
    public void shouldTellMeIfItHasFoundAnOpenWindowYet() {
        checkForHeadless();
        WindowGrabber grabber = new WindowGrabber(new QueuedMiniHashMap<String, Window>());
        
        JFrame frame = new JFrame();
        frame.setName("frame.name");
        
        assertFalse(grabber.hasFoundOpenWindow("frame.name"));
        
        frame.setVisible(true);
        waitForIdle();
        
        assertTrue(grabber.hasFoundOpenWindow("frame.name"));
        
        grabber.dispose();
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
