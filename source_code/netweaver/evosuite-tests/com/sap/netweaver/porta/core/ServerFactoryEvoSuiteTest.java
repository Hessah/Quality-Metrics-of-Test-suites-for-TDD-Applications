/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.ServerFactory;
import java.util.Properties;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ServerFactoryEvoSuiteTest {

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
      // Undeclared exception!
      try {
        ServerFactory.createServer(properties0);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * server.type property missing
         */
      }
  }

  @Test
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try {
        ServerFactory.createServer((Properties) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
        /*
         * properties cannot be null
         */
      }
  }

  @Test
  public void test3()  throws Throwable  {
      Properties properties0 = new Properties();
      properties0.put((Object) "server.type", (Object) "server.type");
      // Undeclared exception!
      try {
        ServerFactory.createServer(properties0);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * server.type is not supported server type. Supported types are: []. 
         */
      }
  }
}
