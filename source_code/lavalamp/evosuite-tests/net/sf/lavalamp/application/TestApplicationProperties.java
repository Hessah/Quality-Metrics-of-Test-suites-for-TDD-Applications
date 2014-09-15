/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.lavalamp.application.ApplicationProperties;
import net.sf.lavalamp.device.DeviceProperties;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestApplicationProperties {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      applicationProperties0.setPort(0);
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
  }

  @Test
  public void test1()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      applicationProperties0.getDeviceProperties();
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
      assertEquals(30000, applicationProperties0.getRunInterval());
  }

  @Test
  public void test2()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      int int0 = applicationProperties0.getRunInterval();
      assertEquals(30000, int0);
      assertEquals(false, applicationProperties0.isDebug());
  }

  @Test
  public void test3()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      boolean boolean0 = applicationProperties0.isDebug();
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
      assertEquals(false, boolean0);
  }

  @Test
  public void test4()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      String string0 = applicationProperties0.toString();
      assertNotNull(string0);
      assertEquals("debug=false, port=0, runInterval=30000, null", string0);
  }

  @Test
  public void test5()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      applicationProperties0.setDebug(false);
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
  }

  @Test
  public void test6()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
      
      applicationProperties0.setRunInterval(0);
      assertEquals("debug=false, port=0, runInterval=0, null", applicationProperties0.toString());
  }

  @Test
  public void test7()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      int int0 = applicationProperties0.getPort();
      assertEquals("debug=false, port=0, runInterval=30000, null", applicationProperties0.toString());
      assertEquals(0, int0);
  }

  @Test
  public void test8()  throws Throwable  {
      ApplicationProperties applicationProperties0 = new ApplicationProperties();
      DeviceProperties[] devicePropertiesArray0 = new DeviceProperties[7];
      applicationProperties0.setDeviceProperties(devicePropertiesArray0);
      // Undeclared exception!
      try {
        applicationProperties0.check();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
