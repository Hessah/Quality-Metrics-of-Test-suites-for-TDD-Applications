package org.lunivore.tyburn;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Matchers.argThat;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.lunivore.tyburn.threaded.TimeoutException;

public class WindowControlBehaviour extends Behaviour {

    @Test
    public void shouldClickAButtonOnAWindow() throws Exception {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();
        frame.setName(AFrame.FRAME_NAME);
        
        JButton button = new JButton("Press Me!");
        button.setName("a.button");
        
        ActionListener actionListener = mock(ActionListener.class);
        
        button.addActionListener((ActionListener)actionListener);            
        
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);

        // When
        try {
            control.clickButton("a.button");            
        } finally {
            control.closeWindow();
        }
        
        // Then
        verify(actionListener).actionPerformed((ActionEvent) argThat(isA(ActionEvent.class)));
    }

    @Test
    public void shouldEnterTextIntoTextComponents() throws Exception {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();
        
        JTextComponent textField = new JTextField();
        textField.setName("a.textfield");
        
        JTextComponent textArea = new JTextArea();
        textArea.setName("b.textarea");
        
        frame.getContentPane().setLayout(new FlowLayout());
        
        frame.getContentPane().add(textField);
        frame.getContentPane().add(textArea);
        frame.pack();
        frame.setVisible(true);
        
        // When
        try {

            control.enterText("a.textfield", "Text1");
            control.enterText("b.textarea", "Text2");
        } finally {
            control.closeWindow();
        }
        
        // Then
        ensureThat(textField.getText(), eq("Text1"));
        ensureThat(textArea.getText(), eq("Text2"));
    }
    
    @Test
    public void shouldEnterTextIntoAComboBox() throws Exception {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();
        
        JComboBox comboBox = new JComboBox(new Object[] {"horse", "cow", "sheep"});
        comboBox.setName("a.combobox");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(comboBox);
        frame.pack();
        frame.setVisible(true);
        
        // When
        try {
            
            control.enterText("a.combobox", "cow");
        } finally {
            control.closeWindow();
        }
        ensureThat(comboBox.getSelectedItem(), eq((Object)"cow"));
    }

    @Test
    public void shouldEnterTextIntoAnEditableComboBox() throws Exception {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);

        AFrame frame = new AFrame();
        JComboBox comboBox = new JComboBox(new Object[] {"horse", "cow", "sheep"});
        comboBox.setName("a.combobox");
        comboBox.setEditable(true);
        comboBox.setSelectedItem("horse");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(comboBox);
        frame.pack();
        frame.setVisible(true);
        
        // When
        try {
            control.enterText("a.combobox", "cow");
        } finally {
            control.closeWindow();
        }
        
        // Then
        // Due to the different focusing behaviour of eg: macs, PCs, this could say
        // "cow" or "cowhorse"
        ensureThat(comboBox.getEditor().getItem().toString(), contains("cow"));
    }

    @Test
    public void shouldFindComponent() throws ComponentFinderException, TimeoutException  {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);

        AFrame frame = new AFrame();
        
        JPanel panel = new JPanel();
        panel.setName("a.panel");
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        Component found;
        
        // When
        try {
            found = control.findComponent("a.panel");
        } finally {
            control.closeWindow();
        }
        
        // Then
        ensureThat(found, eq((Component)panel));
    }

    @Test
    public void shouldCloseWindows() throws TimeoutException {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();
        
        // When
        control.closeWindow();
        
        // Then
        ensureThat(!frame.isShowing());        
        frame.dispose();
    }

    @Test
    public void shouldSimulateKeyPressesForInputMap() throws TimeoutException {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();            
        Action action = mock(Action.class);
        stub(action.isEnabled()).toReturn(true);

        frame.contentPanel.getActionMap().put(AFrame.ACTION_KEY, (Action) action);
        
        // When
        try {
            control.pressKeychar(' ');
        } finally {
            control.closeWindow();
        }
        
        // Then
        verify(action).actionPerformed((ActionEvent) argThat(isA(ActionEvent.class)));
    }

    @Test
    public void shouldSimulateKeyPressesForKeyListeners() throws TimeoutException {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        
        AFrame frame = new AFrame();
        KeyListener keyListener = mock(KeyListener.class);
        frame.contentPanel.addKeyListener(keyListener); 

        // When
        try {   
            control.pressKeychar(' ');
        } finally {
            control.closeWindow();
        }
        
        // Then
        verify(keyListener).keyReleased(argThat(matchesTheSpaceKey()));
    }
    
    @SuppressWarnings("serial")
	@Test
    public void shouldGrabAnImageOfAComponent() throws Exception {
    	WindowControl control = new WindowControl(AFrame.FRAME_NAME);
    	JPanel myPanel = new JPanel() {
    		@Override
    		public void paint(Graphics g) {
    			super.paint(g);
    			g.setColor(Color.CYAN);
    			g.fillRect(20, 20, 40, 40);
    		}
    	};
    	myPanel.setName("My panel");
    	myPanel.setPreferredSize(new Dimension(100, 120));
    	myPanel.setBackground(Color.WHITE);
		new AFrame(myPanel);
    	
		BufferedImage image = control.grabImageOf("My panel");
		assertThat(image.getRGB(0, 0), equalTo(Color.WHITE.getRGB()));
		assertThat(image.getRGB(30, 30), equalTo(Color.CYAN.getRGB()));
		assertThat(image.getWidth(), equalTo(myPanel.getWidth()));
		assertThat(image.getHeight(), equalTo(myPanel.getHeight()));
		
    }
    
    @Test
    public void shouldSimulateKeyPressesWhenKeyHasNoChar() throws TimeoutException {
        checkForHeadless();
        
        // Given
        WindowControl control = new WindowControl(AFrame.FRAME_NAME);
        AFrame frame = new AFrame();

        KeyListener keyListener = mock(KeyListener.class);
        frame.contentPanel.addKeyListener(keyListener);   
        
        // When
        try { 
            control.pressKeycode(KeyEvent.VK_RIGHT);
        } finally {
            control.closeWindow();
        }
        
        // Then
        verify(keyListener).keyReleased(argThat(matchesTheRightArrow()));
    }
    
    @Test
    public void shouldSimulateMouseClicks() throws Exception {
    	checkForHeadless();
    	
    	// Given
    	WindowControl control = new WindowControl(AFrame.FRAME_NAME);
    	JPanel mousey = new JPanel();
    	mousey.setName("mousey");
    	new AFrame(mousey);
    	
    	MouseListener mouseListener = mock(MouseListener.class);
    	mousey.addMouseListener(mouseListener);
    	
    	control.clickMouseOn("mousey", 10, 10);
    	
    	verify(mouseListener).mouseClicked(argThat(isAMouseEventAt(10, 10)));
    }

    private Matcher<MouseEvent> isAMouseEventAt(final int x, final int y) {
		return new BaseMatcher<MouseEvent>() {
			public boolean matches(Object obj) {
				MouseEvent event = (MouseEvent) obj;
				return event.getX() == x && event.getY() == y;
			}

			public void describeTo(Description desc) {
				desc.appendText("a mouse event at " + x + ", " + y);
			}
			
		};
	}

	private Matcher<KeyEvent> matchesTheSpaceKey() {
        return new BaseMatcher<KeyEvent>() {
            public boolean matches(Object arg) {
                return ((KeyEvent)arg).getKeyCode() == KeyEvent.VK_SPACE ||
                    ((KeyEvent)arg).getKeyChar() == ' ';
            }

			public void describeTo(Description desc) {
				desc.appendText("a space key event");
			}
        };
    }

    private BaseMatcher<KeyEvent> matchesTheRightArrow() {
        return new BaseMatcher<KeyEvent>() {
            public boolean matches(Object arg) {
                return ((KeyEvent)arg).getKeyCode() == KeyEvent.VK_RIGHT;
            }

			public void describeTo(Description desc) {
				desc.appendText("a right key event");
			}
        };
    }

    private void checkForHeadless() {
        new HeadlessChecker().check();
    }

    public static class AFrame extends JFrame {
        private static final long serialVersionUID = 1L;
        private static final String FRAME_NAME = "a.window";
        private static final String ACTION_KEY = "AFrame.action";
        
        
        private JPanel contentPanel;
        public AFrame() {
        	this(new JPanel());
        }
        
        public AFrame(JPanel contentPanel) {
            setName(FRAME_NAME);
            setContentPane(contentPanel);

            contentPanel.getInputMap().put(KeyStroke.getKeyStroke(' '), ACTION_KEY);
            
            this.pack();
            this.setVisible(true);
            this.contentPanel = contentPanel;
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
