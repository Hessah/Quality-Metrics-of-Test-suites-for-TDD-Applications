package org.lunivore.tyburn;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;
import org.lunivore.tyburn.actors.Focuser;

public class FocuserBehaviour extends Behaviour {

    @Test
    public void shouldRequestFocusOnAComponent() {
        checkForHeadless();
        Focuser focuser = new Focuser(Speed.FLAT_OUT);
        AFrame frame = new AFrame();            
        
        try {

            JComboBox comboBox = new JComboBox(new Object[] {"horse", "cow", "sheep"});
            comboBox.setName("a.combobox");
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(comboBox);
            frame.pack();
            frame.setVisible(true);
            
            focuser.requestFocusOn(comboBox);
            
            ensureThat(comboBox.hasFocus());
        } finally {
            frame.dispose();
        }
    }

    @Test
    public void shouldNotChangeAnythingIfFocusAlreadyOnAComponent() {
        checkForHeadless();
        Focuser focuser = new Focuser(Speed.FLAT_OUT);
        AFrame frame = new AFrame();            
        
        try {

            JComboBox comboBox = new JComboBox(new Object[] {"horse", "cow", "sheep"});
            comboBox.setName("a.combobox");
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(comboBox);
            frame.pack();
            frame.setVisible(true);
            
            focuser.requestFocusOn(comboBox);
            focuser.requestFocusOn(comboBox);
            
            ensureThat(comboBox.hasFocus());
        } finally {
            frame.dispose();
        }
    }
    
    public static class AFrame extends JFrame {
        private static final long serialVersionUID = 1L;

        private static final String FRAME_NAME = "a.window";
        
        private JPanel contentPanel = new JPanel();
        public AFrame() {
            setName(FRAME_NAME);
            setContentPane(contentPanel);

            this.pack();
            this.setVisible(true);
            
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    private void checkForHeadless() {
        new HeadlessChecker().check();
    }    
}