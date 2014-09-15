package org.lunivore.tyburn;

import javax.swing.JButton;

import org.junit.Test;



public class NamedComponentFilterBehaviour extends Behaviour {

    @Test
    public void shouldMatchComponentsWithGivenName() {
        JButton buttonFrodo = new JButton("Frodo");
        buttonFrodo.setName("frodoButton");

        NamedComponentFilter filter = new NamedComponentFilter("frodoButton");
        ensureThat(filter.matches(buttonFrodo));    
    }
    
    @Test
    public void shouldNotMatchComponentsWithWrongName() {
        JButton buttonFrodo = new JButton("Frodo");
        buttonFrodo.setName("frodoButton");

        NamedComponentFilter filter = new NamedComponentFilter("gandalfButton");
        ensureThat(!filter.matches(buttonFrodo));        
    }

    @Test
    public void shouldMatchIfNullComponentsWithNullName() {
        JButton button = new JButton();

        NamedComponentFilter filter = new NamedComponentFilter(null);
        ensureThat(filter.matches(button));        
    }

    @Test
    public void shouldNotMatchIfNullComponentsWithNonNullName() {
        JButton buttonFrodo = new JButton("Frodo");
        buttonFrodo.setName("frodoButton");

        NamedComponentFilter filter = new NamedComponentFilter(null);
        ensureThat(!filter.matches(buttonFrodo));
    }
}
