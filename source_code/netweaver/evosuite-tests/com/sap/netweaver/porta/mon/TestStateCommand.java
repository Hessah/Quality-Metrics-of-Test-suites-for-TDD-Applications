/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.mon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.mon.StateCommand;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestStateCommand {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      StateCommand stateCommand0 = new StateCommand();
      try {
        stateCommand0.execute();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
        /*
         * properties cannot be null
         */
      }
  }
}
