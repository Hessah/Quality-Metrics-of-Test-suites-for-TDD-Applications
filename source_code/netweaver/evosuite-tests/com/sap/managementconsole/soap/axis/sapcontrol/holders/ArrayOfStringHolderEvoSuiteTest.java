/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.sapcontrol.holders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.sapcontrol.holders.ArrayOfStringHolder;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ArrayOfStringHolderEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ArrayOfStringHolder arrayOfStringHolder0 = new ArrayOfStringHolder();
      ArrayOfStringHolder arrayOfStringHolder1 = new ArrayOfStringHolder(arrayOfStringHolder0.value);
      assertNotSame(arrayOfStringHolder0, arrayOfStringHolder1);
  }
}
