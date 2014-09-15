/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.ide.eclipse.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.core.ProxyException;
import com.sap.netweaver.porta.ide.eclipse.util.ProxyUtilCaller;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ProxyUtilCallerEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try {
        ProxyUtilCaller.handleProxyException((ProxyException) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test1()  throws Throwable  {
      ProxyUtilCaller proxyUtilCaller0 = new ProxyUtilCaller();
      assertNotNull(proxyUtilCaller0);
  }
}
