/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.impl.Bamboo3RestApi;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestAuthBuildSite {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      Bamboo3RestApi bamboo3RestApi0 = new Bamboo3RestApi();
      UsernamePasswordCredentials usernamePasswordCredentials0 = bamboo3RestApi0.getCredentials();
      assertNull(usernamePasswordCredentials0);
  }

  @Test
  public void test1()  throws Throwable  {
      Bamboo3RestApi bamboo3RestApi0 = new Bamboo3RestApi();
      Console console0 = new Console();
      // Undeclared exception!
      try {
        bamboo3RestApi0.setCredentials(console0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test2()  throws Throwable  {
      Bamboo3RestApi bamboo3RestApi0 = new Bamboo3RestApi();
      bamboo3RestApi0.setCredentials("enter HttpClient.executeMethod(HttpMethod)", (UsernamePasswordCredentials) null);
      assertEquals("build site null", bamboo3RestApi0.toString());
  }

  @Test
  public void test3()  throws Throwable  {
      Bamboo3RestApi bamboo3RestApi0 = new Bamboo3RestApi();
      bamboo3RestApi0.clearCredentials();
      assertEquals("build site null", bamboo3RestApi0.toString());
  }
}
