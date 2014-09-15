/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.saphostcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.saphostcontrol.ResponseMessage;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ResponseMessageEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      Class<?> class0 = QName.class;
      QName qName0 = new QName("");
      BeanDeserializer beanDeserializer0 = (BeanDeserializer)ResponseMessage.getDeserializer("", (Class) class0, qName0);
      assertEquals(false, beanDeserializer0.componentsReady());
  }

  @Test
  public void test1()  throws Throwable  {
      Class<?> class0 = QName.class;
      QName qName0 = new QName("");
      BeanSerializer beanSerializer0 = (BeanSerializer)ResponseMessage.getSerializer("", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanSerializer0.getMechanismType());
  }

  @Test
  public void test2()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      responseMessage0.setMMessageKey("6t@Le70f");
      ResponseMessage responseMessage1 = new ResponseMessage("6t@Le70f", "6t@Le70f");
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals(false, boolean0);
      assertFalse(responseMessage1.equals(responseMessage0));
  }

  @Test
  public void test3()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      responseMessage0.setMMessageValue("mMessageKeVy");
      responseMessage0.setMMessageKey("(6sIc`)g'");
      ResponseMessage responseMessage1 = new ResponseMessage("(6sIc`)g'", "(6sIc`)g'");
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test4()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage("& ]", "& ]");
      ResponseMessage responseMessage1 = new ResponseMessage("& ]", "& ]");
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test5()  throws Throwable  {
      TypeDesc typeDesc0 = ResponseMessage.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test6()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      Object object0 = new Object();
      boolean boolean0 = responseMessage0.equals(object0);
      assertEquals(false, boolean0);
  }

  @Test
  public void test7()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage("& ]", "& ]");
      ResponseMessage responseMessage1 = new ResponseMessage("rdQ", "& ]");
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals("& ]", responseMessage1.getMMessageValue());
      assertEquals(false, boolean0);
  }

  @Test
  public void test8()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      ResponseMessage responseMessage1 = new ResponseMessage("*i/9$^>1F+{uw6|A", "*i/9$^>1F+{uw6|A");
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test9()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      ResponseMessage responseMessage1 = new ResponseMessage();
      boolean boolean0 = responseMessage0.equals((Object) responseMessage1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage("& ]", "& ]");
      int int0 = responseMessage0.hashCode();
      assertEquals(75207, int0);
  }

  @Test
  public void test11()  throws Throwable  {
      ResponseMessage responseMessage0 = new ResponseMessage();
      int int0 = responseMessage0.hashCode();
      assertEquals(1, int0);
  }
}
