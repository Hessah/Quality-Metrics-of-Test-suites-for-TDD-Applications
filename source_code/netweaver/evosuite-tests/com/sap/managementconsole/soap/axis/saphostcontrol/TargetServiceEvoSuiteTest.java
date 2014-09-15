/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.saphostcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.saphostcontrol.ServiceIdentifier;
import com.sap.managementconsole.soap.axis.saphostcontrol.ServiceType;
import com.sap.managementconsole.soap.axis.saphostcontrol.TargetService;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TargetServiceEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier((String) null);
      targetService0.setMServiceIdentifier(serviceIdentifier0);
      assertNull(serviceIdentifier0.getMIdentifier());
  }

  @Test
  public void test1()  throws Throwable  {
      ServiceType serviceType0 = ServiceType.value1;
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier("");
      TargetService targetService0 = new TargetService(serviceType0, serviceIdentifier0);
      TargetService targetService1 = new TargetService();
      boolean boolean0 = targetService0.equals((Object) targetService1);
      assertFalse(targetService1.equals(targetService0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test2()  throws Throwable  {
      Class<?> class0 = TargetService.class;
      QName qName0 = QName.valueOf("");
      BeanSerializer beanSerializer0 = (BeanSerializer)TargetService.getSerializer("", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanSerializer0.getMechanismType());
  }

  @Test
  public void test3()  throws Throwable  {
      ServiceType serviceType0 = ServiceType.value3;
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier();
      TargetService targetService0 = new TargetService(serviceType0, serviceIdentifier0);
      TargetService targetService1 = new TargetService(serviceType0, serviceIdentifier0);
      boolean boolean0 = targetService0.equals((Object) targetService1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test4()  throws Throwable  {
      Class<?> class0 = TargetService.class;
      QName qName0 = new QName("c[*(e", "c[*(e", "c[*(e");
      BeanDeserializer beanDeserializer0 = (BeanDeserializer)TargetService.getDeserializer("c[*(e", (Class) class0, qName0);
      assertEquals(false, beanDeserializer0.componentsReady());
  }

  @Test
  public void test5()  throws Throwable  {
      TypeDesc typeDesc0 = TargetService.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test6()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      boolean boolean0 = targetService0.equals((Object) null);
      assertEquals(false, boolean0);
  }

  @Test
  public void test7()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      TargetService targetService1 = new TargetService();
      boolean boolean0 = targetService0.equals((Object) targetService1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test8()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      ServiceType serviceType0 = ServiceType.value2;
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier("'vdiGzj");
      TargetService targetService1 = new TargetService(serviceType0, serviceIdentifier0);
      boolean boolean0 = targetService0.equals((Object) targetService1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test9()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier("");
      TargetService targetService1 = new TargetService((ServiceType) null, serviceIdentifier0);
      boolean boolean0 = targetService0.equals((Object) targetService1);
      assertFalse(targetService1.equals(targetService0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier((String) null);
      TargetService targetService1 = new TargetService((ServiceType) null, serviceIdentifier0);
      boolean boolean0 = targetService1.equals((Object) targetService0);
      assertFalse(targetService0.equals(targetService1));
      assertEquals(false, boolean0);
  }

  @Test
  public void test11()  throws Throwable  {
      TargetService targetService0 = new TargetService();
      ServiceType serviceType0 = ServiceType.value4;
      targetService0.setMServiceType(serviceType0);
      int int0 = targetService0.hashCode();
      assertEquals((-1846230928), int0);
  }

  @Test
  public void test12()  throws Throwable  {
      ServiceIdentifier serviceIdentifier0 = new ServiceIdentifier((String) null);
      TargetService targetService0 = new TargetService((ServiceType) null, serviceIdentifier0);
      int int0 = targetService0.hashCode();
      assertEquals(2, int0);
  }
}
