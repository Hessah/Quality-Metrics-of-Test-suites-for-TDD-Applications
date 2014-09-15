package org.lunivore.tyburn.threaded;

import org.junit.Test;
import org.lunivore.tyburn.Behaviour;

public class ClockedTimeouterBehaviour extends Behaviour {
    
    private PseudoClock clock = new PseudoClock();
    
    @Test
    public void shouldTimeoutIffTimeoutHasBeenEqualledOrExceeded() {
        ClockedTimeouter timeouter = new ClockedTimeouter(clock);
        clock.setTimeInMillis(0);
        timeouter.start(20);
        
        for (int i = 1; i < 20; i++) {
            try {
                clock.setTimeInMillis(i);
                timeouter.checkTime();
                ensureThat(i, isLessThan(20));
            } catch (TimeoutException e) {
                ensureThat(i, isGreaterThanOrEq(20));
            }
        }
    }
}
