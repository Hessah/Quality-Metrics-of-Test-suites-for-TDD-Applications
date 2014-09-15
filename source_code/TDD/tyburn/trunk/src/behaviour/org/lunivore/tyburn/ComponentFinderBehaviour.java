package org.lunivore.tyburn;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;


public class ComponentFinderBehaviour extends Behaviour {
    
    @Test
    public void shouldFindMatchingComponentsFromFilter() {
        checkForHeadless();
        JFrame frame = new JFrame();
        JPanel centrePanel = new JPanel();
        JPanel southPanel = new JPanel();
        
        JButton leftTwinButton = new JButton("twin");
        JButton rightTwinButton = new JButton("twin");
        
        southPanel.add(leftTwinButton);
        southPanel.add(rightTwinButton);
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(centrePanel, BorderLayout.CENTER);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
                
        ComponentFinder componentFinder = new ComponentFinder();
        
        Component[] components = componentFinder.findComponents(frame, new ComponentFilter() {
            public boolean matches(Component candidate) {
                return (candidate instanceof JButton 
                        && ((JButton)candidate).getText().equals("twin"));
            }            
        });
        
        List<Component> componentList = Arrays.asList(components);

        ensureThat(componentList.size(), eq(2));
        ensureThat(componentList.contains(leftTwinButton));
        ensureThat(componentList.contains(rightTwinButton));
    }

    @Test
    public void shouldFindExactMatchingComponentFromFilter() throws ComponentFinderException {
        checkForHeadless();
        JFrame frame = new JFrame();
        JPanel centrePanel = new JPanel();
        JPanel southPanel = new JPanel();
        
        JButton onlyButton = new JButton("only");
        
        southPanel.add(onlyButton);
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(centrePanel, BorderLayout.CENTER);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
                
        ComponentFinder componentFinder = new ComponentFinder();
        
        Component component = componentFinder.findExactComponent(frame, new ComponentFilter() {
            public boolean matches(Component candidate) {
                return (candidate instanceof JButton
                        && ((JButton)candidate).getText().equals("only"));
            }
        });
        
        ensureThat(component, eq((Component)onlyButton));
    }

    @Test
    public void shouldThrowExceptionIfExactComponentSoughtAndNoComponentFound() {
        checkForHeadless();
        JFrame frame = new JFrame();
                               
        ComponentFinder componentFinder = new ComponentFinder();
        
        ComponentFilter filter = new ComponentFilter() {
            public boolean matches(Component candidate) {
                return false;
            }            
        };
        
        try {
            componentFinder.findExactComponent(frame, filter);
            ensureThat(anExceptionIsThrown());
        } catch (ComponentFinderException cfe) { }
    }

    @Test
    public void shouldThrowExceptionIfExactComponentSoughtAndMoreThanOneFound() {
        checkForHeadless();
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JButton());
        frame.getContentPane().add(new JButton());
        
        ComponentFinder componentFinder = new ComponentFinder();
        
        ComponentFilter filter = new ComponentFilter() {
            public boolean matches(Component candidate) {
                return true; // will also match on root pane, content pane etc.
            }            
        };
        
        try {
            componentFinder.findExactComponent(frame, filter);
            ensureThat(anExceptionIsThrown());
        } catch (ComponentFinderException cfe) { }
    }
    
    
    private boolean anExceptionIsThrown() {
        return false;
    }
    
    
    private void checkForHeadless() {
        new HeadlessChecker().check();
    }
}
