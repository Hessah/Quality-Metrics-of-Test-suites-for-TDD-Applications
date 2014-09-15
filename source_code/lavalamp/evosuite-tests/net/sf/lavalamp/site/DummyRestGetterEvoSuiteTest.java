/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.IOException;
import net.sf.lavalamp.site.DummyRestGetter;
import net.sf.lavalamp.site.LoginRequiredException;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class DummyRestGetterEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      char[] charArray0 = new char[1];
      String string0 = dummyRestGetter0.get("os_authType=basic", charArray0);
      assertEquals("<auth>auth12345</auth>", string0);
  }

  @Test
  public void test1()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      try {
        dummyRestGetter0.get("N=m3-nd%PgSeE;LpY");
        fail("Expecting exception: LoginRequiredException");
      } catch(LoginRequiredException e) {
      }
  }

  @Test
  public void test2()  throws Throwable  {
      DummyRestGetter dummyRestGetter0 = new DummyRestGetter();
      String string0 = dummyRestGetter0.get("os_authType=basic");
      assertEquals("state=\"Successful\"", string0);
      assertNotNull(string0);
  }
}
