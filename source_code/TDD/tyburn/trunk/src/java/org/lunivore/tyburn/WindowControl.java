package org.lunivore.tyburn;

import java.awt.Component;
import java.awt.TextComponent;
import java.awt.Window;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

import javax.swing.AbstractButton;
import javax.swing.text.JTextComponent;

import org.lunivore.tyburn.actors.ButtonClicker;
import org.lunivore.tyburn.actors.CharacterTyper;
import org.lunivore.tyburn.actors.Focuser;
import org.lunivore.tyburn.actors.Idler;
import org.lunivore.tyburn.actors.MouseClicker;
import org.lunivore.tyburn.actors.WindowGrabber;
import org.lunivore.tyburn.threaded.TimeoutException;


public class WindowControl {
    public static final long DEFAULT_WINDOW_TIMEOUT = 30000;

    // Use of the WindowWrapper starts it grabbing windows ASAP.
    private static final WindowGrabber grabber = new WindowGrabber();
    
    private final CharacterTyper typer;
    private final ButtonClicker buttonClicker;
    private final MouseClicker mouseClicker;
    
    private final String windowName;
    private final ComponentFinder finder;
    private Window window;

    private Idler idler;

    private Focuser focuser;

	private final long timeout;

    public WindowControl(String windowName) {
        this(windowName, DEFAULT_WINDOW_TIMEOUT);
    }

    public WindowControl(String windowName, long timeout) {
		this(windowName, new ComponentFinder(), new PropertyDrivenSpeed(), timeout);
	}
    
    public WindowControl(String windowName, ComponentFinder finder, Speed speed, long timeout) {
		this.timeout = timeout;
		new HeadlessChecker().check();
        this.windowName = windowName;
        this.finder = finder;
        idler = new Idler();
        typer = new CharacterTyper(speed);
        buttonClicker = new ButtonClicker(speed);
        mouseClicker = new MouseClicker(speed);
        focuser = new Focuser(speed);
    }

	public void closeWindow() throws TimeoutException {
        getOpenWindow().dispose();
        idler.waitForIdle();
    }
    
    public void clickButton(String componentName) throws ComponentFinderException, TimeoutException {
        AbstractButton button = (AbstractButton) finder.findExactComponent(
                getOpenWindow(), new NamedComponentFilter(componentName));
        buttonClicker.click(button);
    }

	public void clickMouseOn(String componentName, int x, int y) throws ComponentFinderException, TimeoutException {
		Component component = findComponent(componentName);
		mouseClicker.click(component, x, y);
	}
    
    public void enterText(String componentName, String text) throws ComponentFinderException, TimeoutException {
        Component component = findComponent(componentName);
        typer.typeIntoComponent(component, text);
    }
        

    public void typeIntoTextComponent(TextComponent component, String text) {
        typer.typeIntoComponent(component, text);
    }
    
    public void typeIntoJTextComponent(JTextComponent component, String text) {
        typer.typeIntoComponent(component, text);
    }   
    
    /**
     * Use this for any key which doesn't have a corresponding character (eg: directional keys).
     * If the key has a character, listeners will not always detect this mimicry.
     */
    public void pressKeycode(int keycode) throws TimeoutException {
        typer.pressKeycode(getOpenWindow(), keycode);
    }

    /**
     * Use this for any key which has a valid character associated with it, when it is being pressed
     * (eg: as a game control key) rather than being typed into a text component.
     */
    public void pressKeychar(char key) throws TimeoutException {
        typer.pressKeychar(getOpenWindow(), key);
    }
    
    public Component findComponent(String componentName) throws ComponentFinderException, TimeoutException {
        return finder.findExactComponent(getOpenWindow(), new NamedComponentFilter(componentName));
    }
    
    public Window getOpenWindow() throws TimeoutException {
        if (window == null) {
            idler.waitForIdle();
            window = grabber.getWindow(windowName, timeout);
        }
        return window;
    }
    
    public void requestWindowFocus() throws TimeoutException {
        focuser.requestFocusOn(getOpenWindow());
        idler.waitForIdle();
    }

	public BufferedImage grabImageOf(String componentName) throws ComponentFinderException, TimeoutException {
		Component component = findComponent(componentName);
		BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), ColorSpace.TYPE_RGB);
		component.paint(image.createGraphics());
		return image;
	}

	public boolean hasFoundOpenWindow() {
		return grabber.hasFoundOpenWindow(windowName);
	}
    

}
