/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.core.ApplicationStatus;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestApplicationStatus {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ApplicationStatus applicationStatus0 = ApplicationStatus.UNKNOWN;
      String string0 = applicationStatus0.toString();
      assertEquals("unknown", string0);
  }

  @Test
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try {
        ApplicationStatus.getByName((String) null);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
      }
  }

  @Test
  public void test2()  throws Throwable  {
      ApplicationStatus applicationStatus0 = ApplicationStatus.getByName("starting");
      assertEquals(ApplicationStatus.STARTING, applicationStatus0);
  }
}
