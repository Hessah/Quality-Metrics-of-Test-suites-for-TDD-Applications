/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.BuildSite;
import net.sf.lavalamp.site.impl.Hudson;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class BuildEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      Build build0 = new Build("");
      String string0 = build0.getIdentity();
      assertNotNull(string0);
      assertEquals(true, build0.isSuccessful());
      assertEquals("<font color='green'> build  successful (null)</font>", build0.toString());
  }

  @Test
  public void test1()  throws Throwable  {
      Build build0 = new Build("");
      build0.getBuildSite();
      assertEquals(true, build0.isSuccessful());
      assertEquals("<font color='green'> build  successful (null)</font>", build0.toString());
  }

  @Test
  public void test2()  throws Throwable  {
      Build build0 = new Build("81Lb`Qc@@cL2f");
      boolean boolean0 = build0.isSuccessful();
      assertEquals(true, boolean0);
  }

  @Test
  public void test3()  throws Throwable  {
      Build build0 = new Build("");
      Hudson hudson0 = new Hudson();
      build0.setBuildSite((BuildSite) hudson0);
      assertEquals("<font color='green'> build  successful (build site null)</font>", build0.toString());
      assertEquals(true, build0.isSuccessful());
  }

  @Test
  public void test4()  throws Throwable  {
      Build build0 = new Build("ua$)W`Z*pQ5\"");
      assertEquals(true, build0.isSuccessful());
      
      build0.setSuccessful(false);
      String string0 = build0.toString();
      assertEquals(false, build0.isSuccessful());
      assertEquals("<font color='red'> build ua$)W`Z*pQ5\" failed (null)</font>", string0);
  }

  @Test
  public void test5()  throws Throwable  {
      Build build0 = new Build("");
      String string0 = build0.toString();
      assertEquals("<font color='green'> build  successful (null)</font>", string0);
      assertNotNull(string0);
  }
}
