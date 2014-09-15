/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.engine.services.dc.wsgate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.engine.services.dc.wsgate.Application;
import com.sap.engine.services.dc.wsgate.ArchiveFile;
import com.sap.engine.services.dc.wsgate.DeployFault;
import com.sap.engine.services.dc.wsgate.DeployWSPortTypeBindingStub;
import com.sap.engine.services.dc.wsgate.Option;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.evosuite.Properties.SandboxMode;
import org.evosuite.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestDeployWSPortTypeBindingStub {

  private static ExecutorService executor; 

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
    org.evosuite.Properties.SANDBOX_MODE = SandboxMode.RECOMMENDED; 
    Sandbox.initializeSecurityManagerForSUT(); 
    executor = Executors.newCachedThreadPool(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    executor.shutdownNow(); 
    Sandbox.resetDefaultSecurityManager(); 
  } 

  @Before 
  public void initTestCase(){ 
    Sandbox.goingToExecuteSUTCode(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    Sandbox.doneWithExecutingSUTCode(); 
  } 


  @Test
  public void test0()  throws Throwable  {
      Call call0 = null;
      try {
        call0 = new Call((URL) null);
        fail("Expecting exception: NoClassDefFoundError");
      } catch(NoClassDefFoundError e) {
        /*
         * Could not initialize class org.apache.axis.client.Call
         */
      }
  }

  @Test
  public void test1()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test2()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          deployWSPortTypeBindingStub0.setMaintainSession(true);
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test3()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          deployWSPortTypeBindingStub0.setUsername("Tf>+dQ~vv");
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test4()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          deployWSPortTypeBindingStub0.setPassword("");
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test5()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          deployWSPortTypeBindingStub0.setTimeout(4470);
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test6()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          deployWSPortTypeBindingStub0.setPortName("Tf>+dQ~vv");
          try {
            deployWSPortTypeBindingStub0.createCall();
            fail("Expecting exception: AxisFault");
          } catch(AxisFault e) {
            /*
             * Failure trying to get the Call object; nested exception is: 
             * \tjava.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.Call
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test7()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          Option[] optionArray0 = new Option[37];
          Application[] applicationArray0 = new Application[13];
          try {
            deployWSPortTypeBindingStub0.stop(applicationArray0, optionArray0);
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test8()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          try {
            deployWSPortTypeBindingStub0.getVersion();
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test9()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          ArchiveFile[] archiveFileArray0 = new ArchiveFile[10];
          Option[] optionArray0 = new Option[10];
          try {
            deployWSPortTypeBindingStub0.deploy(archiveFileArray0, optionArray0);
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test10()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          Option[] optionArray0 = new Option[6];
          try {
            deployWSPortTypeBindingStub0.getApplications(optionArray0);
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test11()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          Option[] optionArray0 = new Option[10];
          Application[] applicationArray0 = new Application[9];
          try {
            deployWSPortTypeBindingStub0.undeploy(applicationArray0, optionArray0);
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  @Test
  public void test12()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          DeployWSPortTypeBindingStub deployWSPortTypeBindingStub0 = new DeployWSPortTypeBindingStub();
          String[] stringArray0 = new String[24];
          Option[] optionArray0 = new Option[20];
          try {
            deployWSPortTypeBindingStub0.deployLocal(stringArray0, optionArray0);
            fail("Expecting exception: NoEndPointException");
          } catch(NoEndPointException e) {
            /*
             * No endpoint
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }
}
