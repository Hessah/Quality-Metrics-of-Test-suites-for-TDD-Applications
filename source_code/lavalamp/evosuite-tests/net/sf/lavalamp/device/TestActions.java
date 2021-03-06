/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.device;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.lavalamp.device.Action;
import net.sf.lavalamp.device.Actions;
import net.sf.lavalamp.device.Blink;
import net.sf.lavalamp.device.TurnOn;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestActions {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      TurnOn turnOn0 = new TurnOn();
      Actions actions0 = new Actions((Action) turnOn0, (Action) turnOn0, (Action) turnOn0);
      TurnOn turnOn1 = (TurnOn)actions0.getSuccessAction();
      assertSame(turnOn1, turnOn0);
  }

  @Test
  public void test1()  throws Throwable  {
      TurnOn turnOn0 = new TurnOn();
      Actions actions0 = new Actions((Action) turnOn0, (Action) turnOn0, (Action) turnOn0);
      TurnOn turnOn1 = (TurnOn)actions0.getErrorAction();
      assertSame(turnOn0, turnOn1);
  }

  @Test
  public void test2()  throws Throwable  {
      Blink blink0 = new Blink();
      Actions actions0 = new Actions((Action) blink0, (Action) blink0, (Action) blink0);
      Blink blink1 = (Blink)actions0.getFailureAction();
      assertSame(blink0, blink1);
  }
}
