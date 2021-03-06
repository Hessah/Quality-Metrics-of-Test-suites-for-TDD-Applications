/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.sapcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.sapcontrol.InstanceProperty;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class InstancePropertyEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      QName qName0 = new QName("$WLF|.kH");
      Class<?> class0 = QName.class;
      BeanDeserializer beanDeserializer0 = (BeanDeserializer)InstanceProperty.getDeserializer("$WLF|.kH", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanDeserializer0.getMechanismType());
  }

  @Test
  public void test1()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty("i)9O-k yrq5Gw1", "i)9O-k yrq5Gw1", "i)9O-k yrq5Gw1");
      int int0 = instanceProperty0.hashCode();
      assertEquals(61882717, int0);
  }

  @Test
  public void test2()  throws Throwable  {
      QName qName0 = QName.valueOf("yZz{QwOK@@m");
      Class<?> class0 = QName.class;
      BeanSerializer beanSerializer0 = (BeanSerializer)InstanceProperty.getSerializer("yZz{QwOK@@m", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanSerializer0.getMechanismType());
  }

  @Test
  public void test3()  throws Throwable  {
      TypeDesc typeDesc0 = InstanceProperty.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test4()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      instanceProperty0.setPropertytype("");
      InstanceProperty instanceProperty1 = new InstanceProperty();
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertFalse(instanceProperty1.equals(instanceProperty0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test5()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      instanceProperty0.setProperty("$WLF|.kH");
      InstanceProperty instanceProperty1 = new InstanceProperty("$WLF|.kH", "$WLF|.kH", "$WLF|.kH");
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test6()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty("i)9O-k yrq5Gw1", "i)9O-k yrq5Gw1", "i)9O-k yrq5Gw1");
      boolean boolean0 = instanceProperty0.equals((Object) "i)9O-k yrq5Gw1");
      assertEquals(false, boolean0);
  }

  @Test
  public void test7()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      InstanceProperty instanceProperty1 = new InstanceProperty("yZz{QwOK@@m", "yZz{QwOK@@m", "yZz{QwOK@@m");
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test8()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      InstanceProperty instanceProperty1 = new InstanceProperty("yZz{QwOK@@m", "yZz{QwOK@@m", "yZz{QwOK@@m");
      boolean boolean0 = instanceProperty1.equals((Object) instanceProperty0);
      assertEquals(false, boolean0);
  }

  @Test
  public void test9()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      InstanceProperty instanceProperty1 = new InstanceProperty();
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty("yZz{QwOK@@m", "yZz{QwOK@@m", "yZz{QwOK@@m");
      InstanceProperty instanceProperty1 = new InstanceProperty("yZz{QwOK@@m", "yZz{QwOK@@m", "yZz{QwOK@@m");
      boolean boolean0 = instanceProperty1.equals((Object) instanceProperty0);
      assertEquals(true, boolean0);
  }

  @Test
  public void test11()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      InstanceProperty instanceProperty1 = new InstanceProperty();
      assertTrue(instanceProperty1.equals(instanceProperty0));
      
      instanceProperty1.setValue("");
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertFalse(instanceProperty0.equals(instanceProperty1));
      assertEquals(false, boolean0);
  }

  @Test
  public void test12()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      InstanceProperty instanceProperty1 = new InstanceProperty();
      assertTrue(instanceProperty1.equals(instanceProperty0));
      
      instanceProperty0.setValue("E3c9o84bUS|%i%");
      boolean boolean0 = instanceProperty0.equals((Object) instanceProperty1);
      assertFalse(instanceProperty1.equals(instanceProperty0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test13()  throws Throwable  {
      InstanceProperty instanceProperty0 = new InstanceProperty();
      int int0 = instanceProperty0.hashCode();
      assertEquals(1, int0);
  }
}
