/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.lavalamp.Pause;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class PauseEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      Pause pause0 = new Pause();
      // Undeclared exception!
      try {
        pause0.sleep((-722L));
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * timeout value is negative
         */
      }
  }
}
