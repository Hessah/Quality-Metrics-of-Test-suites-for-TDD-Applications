/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.sapcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.sapcontrol.StartStopOption;
import java.io.ObjectStreamException;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.EnumDeserializer;
import org.apache.axis.encoding.ser.EnumSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class StartStopOptionEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      TypeDesc typeDesc0 = StartStopOption.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test1()  throws Throwable  {
      StartStopOption startStopOption0 = StartStopOption.value6;
      StartStopOption startStopOption1 = (StartStopOption)startStopOption0.readResolve();
      assertNotNull(startStopOption1);
      assertEquals("SAPControl-PRIORITY-LEVEL", startStopOption1.getValue());
  }

  @Test
  public void test2()  throws Throwable  {
      Class<?> class0 = StartStopOption.class;
      QName qName0 = new QName("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...", "[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
      EnumSerializer enumSerializer0 = (EnumSerializer)StartStopOption.getSerializer("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", enumSerializer0.getMechanismType());
  }

  @Test
  public void test3()  throws Throwable  {
      StartStopOption.fromString("");
  }

  @Test
  public void test4()  throws Throwable  {
      Class<?> class0 = Class.class;
      QName qName0 = new QName("", "");
      EnumDeserializer enumDeserializer0 = (EnumDeserializer)StartStopOption.getDeserializer("", (Class) class0, qName0);
      assertEquals(false, enumDeserializer0.componentsReady());
  }

  @Test
  public void test5()  throws Throwable  {
      StartStopOption startStopOption0 = StartStopOption.value2;
      String string0 = startStopOption0.getValue();
      assertEquals("SAPControl-SCS-INSTANCES", string0);
      assertNotNull(string0);
  }

  @Test
  public void test6()  throws Throwable  {
      StartStopOption startStopOption0 = StartStopOption.value6;
      int int0 = startStopOption0.hashCode();
      assertEquals(1424713421, int0);
  }

  @Test
  public void test7()  throws Throwable  {
      StartStopOption startStopOption0 = new StartStopOption("");
      assertEquals("", startStopOption0.getValue());
      assertNotNull(startStopOption0);
  }

  @Test
  public void test8()  throws Throwable  {
      try {
        StartStopOption.fromString("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
      }
  }

  @Test
  public void test9()  throws Throwable  {
      StartStopOption startStopOption0 = StartStopOption.value2;
      Object object0 = new Object();
      boolean boolean0 = startStopOption0.equals(object0);
      assertEquals(false, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      StartStopOption startStopOption0 = StartStopOption.value6;
      boolean boolean0 = startStopOption0.equals((Object) startStopOption0);
      assertEquals(true, boolean0);
  }
}
