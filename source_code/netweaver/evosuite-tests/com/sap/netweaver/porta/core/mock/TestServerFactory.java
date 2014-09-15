/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.core.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.core.mock.ServerFactory;
import com.sap.netweaver.porta.core.mock.ServerMock;
import java.util.Properties;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestServerFactory {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ServerFactory serverFactory0 = new ServerFactory();
      assertNotNull(serverFactory0);
  }

  @Test
  public void test1()  throws Throwable  {
      Properties properties0 = new Properties();
      ServerMock serverMock0 = (ServerMock)ServerFactory.createServer(properties0);
      assertEquals("MCK", serverMock0.getSystemName());
  }
}
