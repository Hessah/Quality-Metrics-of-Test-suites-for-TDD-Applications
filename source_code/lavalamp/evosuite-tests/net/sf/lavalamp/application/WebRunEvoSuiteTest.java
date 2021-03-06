/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.lavalamp.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import net.sf.lavalamp.LavaLogger;
import net.sf.lavalamp.Pause;
import net.sf.lavalamp.application.WebRun;
import net.sf.lavalamp.device.Device;
import net.sf.lavalamp.device.DeviceController;
import net.sf.lavalamp.device.DeviceProperties;
import net.sf.lavalamp.device.DummyDevice;
import net.sf.lavalamp.site.Build;
import net.sf.lavalamp.site.BuildChecker;
import net.sf.lavalamp.site.Console;
import net.sf.lavalamp.site.UrlGetter;
import org.evosuite.Properties.SandboxMode;
import org.evosuite.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class WebRunEvoSuiteTest {

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
      WebRun webRun0 = new WebRun();
      DeviceController deviceController0 = webRun0.getDeviceController();
      assertNull(deviceController0);
  }

  @Test
  public void test1()  throws Throwable  {
      WebRun webRun0 = new WebRun();
      try {
        webRun0.init();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test2()  throws Throwable  {
      WebRun webRun0 = new WebRun();
      UrlGetter urlGetter0 = new UrlGetter();
      Console console0 = new Console();
      DummyDevice dummyDevice0 = new DummyDevice();
      // Undeclared exception!
      try {
        webRun0.checkBuild((BuildChecker) null, urlGetter0, console0, (Device) dummyDevice0, (Build) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  @Test
  public void test3()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          WebRun webRun0 = new WebRun();
          LavaLogger lavaLogger0 = new LavaLogger();
          Pause pause0 = new Pause();
          try {
            webRun0.exec(lavaLogger0, pause0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.net.SocketPermission localhost:1024- listen,resolve)
             * java.lang.Thread.getStackTrace(Thread.java:1479)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkListen(SecurityManager.java:1118)
             * java.net.ServerSocket.bind(ServerSocket.java:327)
             * java.net.ServerSocket.<init>(ServerSocket.java:194)
             * java.net.ServerSocket.<init>(ServerSocket.java:150)
             * org.mortbay.jetty.bio.SocketConnector.newServerSocket(SocketConnector.java:80)
             * org.mortbay.jetty.bio.SocketConnector.open(SocketConnector.java:73)
             * org.mortbay.jetty.AbstractConnector.doStart(AbstractConnector.java:283)
             * org.mortbay.jetty.bio.SocketConnector.doStart(SocketConnector.java:147)
             * org.mortbay.component.AbstractLifeCycle.start(AbstractLifeCycle.java:50)
             * org.mortbay.jetty.Server.doStart(Server.java:235)
             * org.mortbay.component.AbstractLifeCycle.start(AbstractLifeCycle.java:50)
             * net.sf.lavalamp.application.WebRun.exec(WebRun.java:50)
             * sun.reflect.GeneratedMethodAccessor17.invoke(Unknown Source)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
             * java.lang.reflect.Method.invoke(Method.java:597)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:262)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:217)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:662)
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
      WebRun webRun0 = new WebRun();
      DeviceProperties[] devicePropertiesArray0 = new DeviceProperties[7];
      LinkedList<Device> linkedList0 = new LinkedList<Device>();
      // Undeclared exception!
      try {
        webRun0.initDevices(devicePropertiesArray0, (List<Device>) linkedList0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
