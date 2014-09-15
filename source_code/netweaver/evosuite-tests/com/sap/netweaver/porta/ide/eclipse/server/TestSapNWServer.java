/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.ide.eclipse.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.ide.eclipse.server.SapNWServer;
import java.net.URL;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleType;
import org.eclipse.wst.server.core.internal.DeletedModule;
import org.eclipse.wst.server.core.internal.ExternalModule;
import org.eclipse.wst.server.core.internal.ModuleType;
import org.eclipse.wst.server.core.model.ModuleDelegate;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestSapNWServer {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(true);
      // Undeclared exception!
      try {
        sapNWServer0.getInstanceNumber();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test1()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      // Undeclared exception!
      try {
        sapNWServer0.getServerPorts();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test2()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(false);
      // Undeclared exception!
      try {
        sapNWServer0.setDefaults((IProgressMonitor) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test3()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      NullProgressMonitor nullProgressMonitor0 = new NullProgressMonitor();
      sapNWServer0.modifyModules(iModuleArray0, iModuleArray0, (IProgressMonitor) nullProgressMonitor0);
      assertEquals(false, nullProgressMonitor0.isCanceled());
  }

  @Test
  public void test4()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      sapNWServer0.initialize();
  }

  @Test
  public void test5()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(false);
      // Undeclared exception!
      try {
        sapNWServer0.getModuleRootURL((IModule) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test6()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      sapNWServer0.dispose();
  }

  @Test
  public void test7()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      // Undeclared exception!
      try {
        sapNWServer0.setInstanceNumber(7);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test8()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      ExternalModule externalModule0 = new ExternalModule("_!Tdzwy'E>e", "_!Tdzwy'E>e", "_!Tdzwy'E>e", "_!Tdzwy'E>e", (ModuleDelegate) null);
      // Undeclared exception!
      try {
        sapNWServer0.getRootModules((IModule) externalModule0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test9()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(false);
      URL uRL0 = sapNWServer0.getModuleRootURL((IModule) null, "riLNA3wPFJ]=", 79);
      assertNotNull(uRL0);
      assertEquals("riLNA3wPFJ]=:79", uRL0.getAuthority());
  }

  @Test
  public void test10()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      ExternalModule externalModule0 = new ExternalModule("jst.web", "jst.web", "jst.web", "jst.web", (ModuleDelegate) null);
      // Undeclared exception!
      try {
        sapNWServer0.getModuleRootURL((IModule) externalModule0, "jst.web", 1120);
        fail("Expecting exception: NoSuchMethodError");
      } catch(NoSuchMethodError e) {
        /*
         * org.eclipse.core.runtime.Status.<init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         */
      }
  }

  @Test
  public void test11()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      ModuleType moduleType0 = ModuleType.getModuleType("My/e[Yx1", "My/e[Yx1");
      DeletedModule deletedModule0 = new DeletedModule("My/e[Yx1", "My/e[Yx1", (IModuleType) moduleType0);
      URL uRL0 = sapNWServer0.getModuleRootURL((IModule) deletedModule0, "My/e[Yx1", 7);
      assertEquals("http://My/e[Yx1:7/", uRL0.toString());
      assertNotNull(uRL0);
  }

  @Test
  public void test12()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      IModule[] iModuleArray1 = sapNWServer0.getChildModules(iModuleArray0);
      ExternalModule externalModule0 = new ExternalModule("jst.web", "jst.web", "jst.web", "jst.web", (ModuleDelegate) null);
      IModule[] iModuleArray2 = sapNWServer0.getRootModules((IModule) externalModule0, iModuleArray1);
      assertFalse(iModuleArray0.equals(iModuleArray2));
  }

  @Test
  public void test13()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      DeletedModule deletedModule0 = new DeletedModule("jst.web", "jst.web", (IModuleType) null);
      iModuleArray0[0] = (IModule) deletedModule0;
      IModule[] iModuleArray1 = sapNWServer0.getChildModules(iModuleArray0);
      assertFalse(iModuleArray0.equals(iModuleArray1));
  }

  @Test
  public void test14()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      ExternalModule externalModule0 = new ExternalModule("_!Tdzwy'E>e", "_!Tdzwy'E>e", "_!Tdzwy'E>e", "_!Tdzwy'E>e", (ModuleDelegate) null);
      IModule[] iModuleArray0 = new IModule[8];
      iModuleArray0[0] = (IModule) externalModule0;
      IModule[] iModuleArray1 = sapNWServer0.getChildModules(iModuleArray0);
      assertFalse(iModuleArray0.equals(iModuleArray1));
  }

  @Test
  public void test15()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      ModuleType moduleType0 = ModuleType.getModuleType("+b", "+b");
      DeletedModule deletedModule0 = new DeletedModule("+b", "+b", (IModuleType) moduleType0);
      iModuleArray0[0] = (IModule) deletedModule0;
      IModule[] iModuleArray1 = sapNWServer0.getChildModules(iModuleArray0);
      assertFalse(iModuleArray1.equals(iModuleArray0));
  }

  @Test
  public void test16()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(false);
      ExternalModule externalModule0 = new ExternalModule((String) null, (String) null, (String) null, (String) null, (ModuleDelegate) null);
      IModule[] iModuleArray0 = new IModule[10];
      // Undeclared exception!
      try {
        sapNWServer0.getRootModules((IModule) externalModule0, iModuleArray0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test17()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      IModule[] iModuleArray1 = sapNWServer0.getChildModules(iModuleArray0);
      ExternalModule externalModule0 = new ExternalModule("+b", "+b", "+b", "+b", (ModuleDelegate) null);
      IModule[] iModuleArray2 = sapNWServer0.getRootModules((IModule) externalModule0, iModuleArray1);
      assertFalse(iModuleArray2.equals(iModuleArray1));
  }

  @Test
  public void test18()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(false);
      IModule[] iModuleArray0 = new IModule[10];
      Status status0 = (Status)sapNWServer0.canModifyModules((IModule[]) null, iModuleArray0);
      assertNotNull(status0);
      assertEquals("Status ERROR: com.sap.netweaver.porta.ide.eclipse code=0 Only EARs and standalone WARs can be added/removed null", status0.toString());
  }

  @Test
  public void test19()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      Status status0 = (Status)sapNWServer0.canModifyModules(iModuleArray0, iModuleArray0);
      assertNotNull(status0);
      assertEquals("Status ERROR: com.sap.netweaver.porta.ide.eclipse code=0 Only EARs and standalone WARs can be added/removed null", status0.toString());
  }

  @Test
  public void test20()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      IModule[] iModuleArray0 = new IModule[1];
      ExternalModule externalModule0 = new ExternalModule("jst.web", "jst.web", "jst.web", "jst.web", (ModuleDelegate) null);
      iModuleArray0[0] = (IModule) externalModule0;
      Status status0 = (Status)sapNWServer0.canModifyModules(iModuleArray0, iModuleArray0);
      assertNotNull(status0);
      assertEquals("OK", status0.getMessage());
  }

  @Test
  public void test21()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer();
      // Undeclared exception!
      try {
        sapNWServer0.getServerCore("q}D5:-v\"-", 193);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * NW7 is not supported server type. Supported types are: []. 
         */
      }
  }

  @Test
  public void test22()  throws Throwable  {
      SapNWServer sapNWServer0 = new SapNWServer(true);
      // Undeclared exception!
      try {
        sapNWServer0.getServerCore("Hnp;&&qr0@Xx", (-780));
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * MOCK is not supported server type. Supported types are: []. 
         */
      }
  }
}
