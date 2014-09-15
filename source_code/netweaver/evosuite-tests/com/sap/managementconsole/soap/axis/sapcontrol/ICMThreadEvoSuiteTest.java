/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.sapcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.sapcontrol.ICMThread;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ICMThreadEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread("Unable to istantiate impementation class for ", "Unable to istantiate impementation class for ", 1928L, "Unable to istantiate impementation class for ", "Unable to istantiate impementation class for ");
      ICMThread iCMThread1 = new ICMThread("Unable to istantiate impementation class for ", "Unable to istantiate impementation class for ", 1928L, "Unable to istantiate impementation class for ", "Unable to istantiate impementation class for ");
      boolean boolean0 = iCMThread1.equals((Object) iCMThread0);
      assertEquals(true, boolean0);
      assertEquals(1928L, iCMThread0.getRequests());
  }

  @Test
  public void test1()  throws Throwable  {
      TypeDesc typeDesc0 = ICMThread.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test2()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      iCMThread0.setId("GK{DV]\"&]Ie-!");
      ICMThread iCMThread1 = new ICMThread((String) null, "GK{DV]\"&]Ie-!", 0L, "GK{DV]\"&]Ie-!", (String) null);
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test3()  throws Throwable  {
      Class<?> class0 = ICMThread.class;
      QName qName0 = QName.valueOf("u!W");
      BeanDeserializer beanDeserializer0 = (BeanDeserializer)ICMThread.getDeserializer("u!W", (Class) class0, qName0);
      assertEquals(false, beanDeserializer0.componentsReady());
  }

  @Test
  public void test4()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      iCMThread0.setRequests((-11L));
      assertEquals((-11L), iCMThread0.getRequests());
  }

  @Test
  public void test5()  throws Throwable  {
      Class<?> class0 = ICMThread.class;
      BeanSerializer beanSerializer0 = (BeanSerializer)ICMThread.getSerializer("setValueInTarget00", (Class) class0, (QName) null);
      assertEquals("Axis SAX Mechanism", beanSerializer0.getMechanismType());
  }

  @Test
  public void test6()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      boolean boolean0 = iCMThread0.equals((Object) "DBbd-tCs!");
      assertEquals(false, boolean0);
  }

  @Test
  public void test7()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread("'f", "'f", 1747L, "'f", "'f");
      ICMThread iCMThread1 = new ICMThread();
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertFalse(iCMThread1.equals(iCMThread0));
      assertEquals(1747L, iCMThread0.getRequests());
      assertEquals(false, boolean0);
  }

  @Test
  public void test8()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      ICMThread iCMThread1 = new ICMThread("sTB#d^=L3=", "sTB#d^=L3=", (-11L), "sTB#d^=L3=", "sTB#d^=L3=");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertEquals(false, boolean0);
      assertEquals((-11L), iCMThread1.getRequests());
  }

  @Test
  public void test9()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      ICMThread iCMThread1 = new ICMThread();
      boolean boolean0 = iCMThread1.equals((Object) iCMThread0);
      assertEquals(true, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      ICMThread iCMThread1 = new ICMThread((String) null, "t", 1332L, "t", "t");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertEquals(false, boolean0);
      assertEquals(1332L, iCMThread1.getRequests());
  }

  @Test
  public void test11()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread("sTB#d^=L3=", "sTB#d^=L3=", (-11L), "sTB#d^=L3=", "sTB#d^=L3=");
      ICMThread iCMThread1 = new ICMThread("sTB#d^=L3=", "DBbd-tCs!", (-11L), "DBbd-tCs!", "sTB#d^=L3=");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertEquals(false, boolean0);
      assertEquals((-11L), iCMThread0.getRequests());
      assertEquals("sTB#d^=L3=", iCMThread1.getRequesttype());
      assertEquals("sTB#d^=L3=", iCMThread1.getName());
      assertEquals("DBbd-tCs!", iCMThread1.getStatus());
      assertEquals("DBbd-tCs!", iCMThread1.getId());
  }

  @Test
  public void test12()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      iCMThread0.setId("TB#d^=L3K=");
      iCMThread0.setName("TB#d^=L3K=");
      ICMThread iCMThread1 = new ICMThread("TB#d^=L3K=", "TB#d^=L3K=", 4L, "TB#d^=L3K=", "TB#d^=L3K=");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertEquals(false, boolean0);
      assertEquals(4L, iCMThread1.getRequests());
  }

  @Test
  public void test13()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      ICMThread iCMThread1 = new ICMThread();
      assertTrue(iCMThread1.equals(iCMThread0));
      
      iCMThread0.setStatus("t");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertFalse(iCMThread1.equals(iCMThread0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test14()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      iCMThread0.setRequesttype("setValueInTarget00");
      ICMThread iCMThread1 = new ICMThread();
      boolean boolean0 = iCMThread1.equals((Object) iCMThread0);
      assertEquals(false, boolean0);
  }

  @Test
  public void test15()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      ICMThread iCMThread1 = new ICMThread();
      assertTrue(iCMThread1.equals(iCMThread0));
      
      iCMThread0.setRequesttype("sTB#d^=L3=");
      boolean boolean0 = iCMThread0.equals((Object) iCMThread1);
      assertFalse(iCMThread0.equals(iCMThread1));
      assertEquals(false, boolean0);
  }

  @Test
  public void test16()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread();
      int int0 = iCMThread0.hashCode();
      assertEquals(1, int0);
  }

  @Test
  public void test17()  throws Throwable  {
      ICMThread iCMThread0 = new ICMThread("sTB#d^=L3=", "sTB#d^=L3=", (-11L), "sTB#d^=L3=", "sTB#d^=L3=");
      int int0 = iCMThread0.hashCode();
      assertEquals(1537219039, int0);
  }
}
