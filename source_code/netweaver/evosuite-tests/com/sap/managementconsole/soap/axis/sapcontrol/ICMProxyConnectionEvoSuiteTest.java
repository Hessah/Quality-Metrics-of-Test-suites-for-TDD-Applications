/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.managementconsole.soap.axis.sapcontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.managementconsole.soap.axis.sapcontrol.ICMProxyConnection;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class ICMProxyConnectionEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", 1898, "+)!pg,DW}C$/K#u^=", 1898, "+)!pg,DW}C$/K#u^=", 1898, 1898, "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", (Integer) 1898, "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=", "+)!pg,DW}C$/K#u^=");
      int int0 = iCMProxyConnection0.hashCode();
      assertEquals(1669053659, int0);
  }

  @Test
  public void test1()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setConid("x(m;Ms%JLkYC\"5dz<");
      assertNull(iCMProxyConnection0.getPartner());
  }

  @Test
  public void test2()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setLocalPort((-584));
      assertEquals(-584, iCMProxyConnection0.getLocalPort());
  }

  @Test
  public void test3()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection((String) null, (String) null, (String) null, 1605, (String) null, 1605, (String) null, 1605, 1605, (String) null, (String) null, (String) null, (Integer) 1605, (String) null, (String) null, (String) null, (String) null);
      iCMProxyConnection0.setPeerPort(1605);
      assertEquals(1605, iCMProxyConnection0.getSocket());
      assertEquals(1605, iCMProxyConnection0.getLocalPort());
      assertEquals(1605, iCMProxyConnection0.getNihdl());
      assertEquals(1605, iCMProxyConnection0.getPeerPort());
  }

  @Test
  public void test4()  throws Throwable  {
      Class<?> class0 = ICMProxyConnection.class;
      QName qName0 = QName.valueOf("x(m;Ms%JLkYC\"5dz<");
      BeanDeserializer beanDeserializer0 = (BeanDeserializer)ICMProxyConnection.getDeserializer("x(m;Ms%JLkYC\"5dz<", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanDeserializer0.getMechanismType());
  }

  @Test
  public void test5()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("[", "[", "[", 1217, "[", 1217, "[", 1217, 1217, "[", "[", "[", (Integer) 1217, "[", "[", "[", "[");
      iCMProxyConnection0.setTidUidMode("sP|,UdYLH[E");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("[", "[", "[", 1217, "[", 1217, "[", 1217, 1217, "[", "[", "[", (Integer) 1217, "[", "[", "[", "[");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(1217, iCMProxyConnection1.getSocket());
      assertEquals(false, boolean0);
      assertEquals(1217, iCMProxyConnection1.getPeerPort());
      assertEquals(1217, iCMProxyConnection1.getNihdl());
      assertEquals(1217, iCMProxyConnection1.getLocalPort());
  }

  @Test
  public void test6()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setPeerAddress((String) null);
      assertNull(iCMProxyConnection0.getTidUidMode());
  }

  @Test
  public void test7()  throws Throwable  {
      TypeDesc typeDesc0 = ICMProxyConnection.getTypeDesc();
      assertEquals(false, typeDesc0.hasAttributes());
  }

  @Test
  public void test8()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setDisconnectTime((String) null);
      assertNull(iCMProxyConnection0.getDisconnectTime());
  }

  @Test
  public void test9()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setInternalConvid("");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(0, iCMProxyConnection1.getSocket());
      assertEquals(0, iCMProxyConnection1.getPeerPort());
      assertEquals(0, iCMProxyConnection1.getLocalPort());
      assertEquals(0, iCMProxyConnection1.getNihdl());
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test10()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setSncContextLength((Integer) 0);
      assertEquals(0, iCMProxyConnection0.getNihdl());
  }

  @Test
  public void test11()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection(".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (-3), ".N;rB 2k", (-3), ".N;rB 2k", (-3), (-3), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (Integer) (-3), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", ".N;rB 2k");
      iCMProxyConnection0.setRole(".N;rB 2k");
      assertEquals(-3, iCMProxyConnection0.getPeerPort());
      assertEquals(-3, iCMProxyConnection0.getNihdl());
      assertEquals(-3, iCMProxyConnection0.getSocket());
      assertEquals(-3, iCMProxyConnection0.getLocalPort());
  }

  @Test
  public void test12()  throws Throwable  {
      Class<?> class0 = ICMProxyConnection.class;
      QName qName0 = QName.valueOf("[");
      BeanSerializer beanSerializer0 = (BeanSerializer)ICMProxyConnection.getSerializer("[", (Class) class0, qName0);
      assertEquals("Axis SAX Mechanism", beanSerializer0.getMechanismType());
  }

  @Test
  public void test13()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setObjectid(",\"A80JSYXDH;/");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(0, iCMProxyConnection0.getLocalPort());
      assertEquals(0, iCMProxyConnection0.getNihdl());
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
      assertEquals(0, iCMProxyConnection0.getPeerPort());
      assertEquals(0, iCMProxyConnection0.getSocket());
      assertEquals(false, boolean0);
  }

  @Test
  public void test14()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) null);
      assertEquals(false, boolean0);
  }

  @Test
  public void test15()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("", "", (String) null, 139, "", 139, "", 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("", "", "", 139, "", 139, "", 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(139, iCMProxyConnection1.getSocket());
      assertEquals(139, iCMProxyConnection1.getNihdl());
      assertEquals(139, iCMProxyConnection1.getPeerPort());
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
      assertEquals(139, iCMProxyConnection1.getLocalPort());
      assertEquals(false, boolean0);
  }

  @Test
  public void test16()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection((String) null, (String) null, (String) null, 10, (String) null, 10, (String) null, 10, 10, (String) null, (String) null, (String) null, (Integer) 10, (String) null, (String) null, (String) null, (String) null);
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection((String) null, (String) null, (String) null, 10, (String) null, (-18), (String) null, 10, 10, (String) null, (String) null, (String) null, (Integer) 10, (String) null, (String) null, (String) null, (String) null);
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(10, iCMProxyConnection1.getNihdl());
      assertEquals(-18, iCMProxyConnection1.getLocalPort());
      assertEquals(false, boolean0);
      assertEquals(10, iCMProxyConnection1.getSocket());
      assertEquals(10, iCMProxyConnection1.getPeerPort());
  }

  @Test
  public void test17()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("5`(G", "5`(G", "5`(G", (-1885), "5`(G", (-1885), (String) null, (-1885), (-1885), (String) null, (String) null, (String) null, (Integer) (-1885), "5`(G", (String) null, (String) null, "5`(G");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(-1885, iCMProxyConnection1.getPeerPort());
      assertEquals(-1885, iCMProxyConnection1.getSocket());
      assertEquals(-1885, iCMProxyConnection1.getLocalPort());
      assertEquals(false, boolean0);
      assertEquals(-1885, iCMProxyConnection1.getNihdl());
  }

  @Test
  public void test18()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("r?!V[", "r?!V[", "r?!V[", (-1), "r?!V[", (-1), "r?!V[", (-1), (-1), "r?!V[", "r?!V[", "r?!V[", (Integer) (-1), "r?!V[", "r?!V[", "r?!V[", "r?!V[");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(-1, iCMProxyConnection0.getLocalPort());
      assertEquals(-1, iCMProxyConnection0.getSocket());
      assertEquals(-1, iCMProxyConnection0.getPeerPort());
      assertEquals(false, boolean0);
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
  }

  @Test
  public void test19()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection((String) null, (String) null, (String) null, 1605, (String) null, 1605, (String) null, 1605, 1605, (String) null, (String) null, (String) null, (Integer) 1605, (String) null, (String) null, (String) null, (String) null);
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection((String) null, "#", (String) null, 1605, (String) null, 1605, (String) null, 1605, 1605, "#", (String) null, "#", (Integer) 1605, "#", "#", (String) null, (String) null);
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(1605, iCMProxyConnection1.getLocalPort());
      assertEquals(1605, iCMProxyConnection1.getSocket());
      assertEquals(false, boolean0);
      assertEquals(1605, iCMProxyConnection1.getPeerPort());
      assertEquals(1605, iCMProxyConnection1.getNihdl());
  }

  @Test
  public void test20()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection((String) null, (String) null, (String) null, 1605, (String) null, 1605, (String) null, 1605, 1605, (String) null, (String) null, (String) null, (Integer) 1605, (String) null, (String) null, (String) null, (String) null);
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection((String) null, "#", (String) null, 1605, (String) null, 1605, (String) null, 1605, 1605, "#", (String) null, "#", (Integer) 1605, "#", "#", (String) null, (String) null);
      boolean boolean0 = iCMProxyConnection1.equals((Object) iCMProxyConnection0);
      assertEquals(false, boolean0);
      assertEquals(1605, iCMProxyConnection1.getPeerPort());
      assertEquals(1605, iCMProxyConnection1.getSocket());
      assertEquals(1605, iCMProxyConnection1.getLocalPort());
      assertEquals(1605, iCMProxyConnection1.getNihdl());
  }

  @Test
  public void test21()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("", "", (String) null, 139, "", 139, "", 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("", "", "", 139, "", 139, (String) null, 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      boolean boolean0 = iCMProxyConnection1.equals((Object) iCMProxyConnection0);
      assertEquals(139, iCMProxyConnection1.getLocalPort());
      assertEquals(139, iCMProxyConnection1.getNihdl());
      assertEquals(139, iCMProxyConnection1.getPeerPort());
      assertEquals(false, boolean0);
  }

  @Test
  public void test22()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("", "", "", 139, "", 139, "", 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("", "", "", 139, "", 139, (String) null, 139, 139, "", "", "", (Integer) 139, "", "", "", "");
      boolean boolean0 = iCMProxyConnection1.equals((Object) iCMProxyConnection0);
      assertEquals(139, iCMProxyConnection0.getLocalPort());
      assertEquals(139, iCMProxyConnection0.getPeerPort());
      assertEquals(139, iCMProxyConnection0.getNihdl());
      assertEquals(139, iCMProxyConnection0.getSocket());
      assertEquals(false, boolean0);
  }

  @Test
  public void test23()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection(".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (-3), ".N;rB 2k", (-3), ".N;rB 2k", (-3), (-3), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (Integer) (-3), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", ".N;rB 2k");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection(".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (-5), ".N;rB 2k", (-5), ".N;rB 2k", (-3), (-5), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", (Integer) (-3), ".N;rB 2k", ".N;rB 2k", ".N;rB 2k", ".N;rB 2k");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(-3, iCMProxyConnection1.getNihdl());
      assertEquals(-5, iCMProxyConnection1.getSocket());
      assertEquals(-3, iCMProxyConnection0.getLocalPort());
      assertEquals(-5, iCMProxyConnection1.getPeerPort());
      assertEquals(false, boolean0);
  }

  @Test
  public void test24()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      assertTrue(iCMProxyConnection1.equals(iCMProxyConnection0));
      
      iCMProxyConnection1.setLocalAddress("]&}^Aa}NW");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test25()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setLocalAddress(")+nbXO_2[z&GE");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(0, iCMProxyConnection0.getPeerPort());
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
      assertEquals(false, boolean0);
  }

  @Test
  public void test26()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", 10, "E!N:E]=hitJ>3W.am", 10, "E!N:E]=hitJ>3W.am", 10, 10, (String) null, "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", (Integer) 10, "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", 10, "E!N:E]=hitJ>3W.am", 10, "E!N:E]=hitJ>3W.am", 10, 10, "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", (Integer) 10, "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am", "E!N:E]=hitJ>3W.am");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(10, iCMProxyConnection0.getPeerPort());
      assertEquals(10, iCMProxyConnection0.getNihdl());
      assertEquals(false, boolean0);
      assertEquals(10, iCMProxyConnection0.getLocalPort());
      assertEquals(10, iCMProxyConnection0.getSocket());
  }

  @Test
  public void test27()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(true, boolean0);
  }

  @Test
  public void test28()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      assertTrue(iCMProxyConnection1.equals(iCMProxyConnection0));
      
      iCMProxyConnection0.setStatus("[DE /] ");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertFalse(iCMProxyConnection0.equals(iCMProxyConnection1));
      assertEquals(false, boolean0);
  }

  @Test
  public void test29()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      iCMProxyConnection0.setSocket(1);
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(1, iCMProxyConnection0.getSocket());
      assertEquals(false, boolean0);
  }

  @Test
  public void test30()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection("[", "[", "[", 1217, "[", 1217, "[", 1217, 1217, "[", "[", "[", (Integer) 1217, "[", "[", "[", "[");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection("[", "[", "[", 1217, "[", 1217, "[", 1217, 1217, "[", "[", "[", (Integer) 1217, "[", "[", "[", "[");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(1217, iCMProxyConnection1.getPeerPort());
      assertEquals(1217, iCMProxyConnection1.getLocalPort());
      assertEquals(true, boolean0);
      assertEquals(1217, iCMProxyConnection1.getNihdl());
  }

  @Test
  public void test31()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      assertTrue(iCMProxyConnection1.equals(iCMProxyConnection0));
      
      iCMProxyConnection0.setPartner("]&}^Aa}NW");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertFalse(iCMProxyConnection0.equals(iCMProxyConnection1));
      assertEquals(false, boolean0);
  }

  @Test
  public void test32()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      iCMProxyConnection0.setExternalConvid("LG#s5nDgf]|}~p]fW");
      iCMProxyConnection0.setNihdl(1);
      iCMProxyConnection1.setNihdl(1);
      boolean boolean0 = iCMProxyConnection1.equals((Object) iCMProxyConnection0);
      assertEquals(1, iCMProxyConnection0.getNihdl());
      assertEquals(false, boolean0);
  }

  @Test
  public void test33()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection((String) null, (String) null, (String) null, 0, (String) null, 0, (String) null, 0, 0, (String) null, (String) null, (String) null, (Integer) 0, (String) null, (String) null, (String) null, (String) null);
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(0, iCMProxyConnection1.getPeerPort());
      assertEquals(0, iCMProxyConnection1.getLocalPort());
      assertEquals(0, iCMProxyConnection1.getSocket());
      assertEquals(0, iCMProxyConnection1.getNihdl());
      assertEquals(false, boolean0);
  }

  @Test
  public void test34()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      assertTrue(iCMProxyConnection1.equals(iCMProxyConnection0));
      
      iCMProxyConnection1.setFailoverStatus("");
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(false, boolean0);
  }

  @Test
  public void test35()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setFailoverStatus("[DE /] ");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection0.equals((Object) iCMProxyConnection1);
      assertEquals(0, iCMProxyConnection0.getSocket());
      assertEquals(0, iCMProxyConnection0.getLocalPort());
      assertFalse(iCMProxyConnection1.equals(iCMProxyConnection0));
      assertEquals(0, iCMProxyConnection0.getPeerPort());
      assertEquals(0, iCMProxyConnection0.getNihdl());
      assertEquals(false, boolean0);
  }

  @Test
  public void test36()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      iCMProxyConnection0.setTidUidMode("<'`3_FN,ps`");
      ICMProxyConnection iCMProxyConnection1 = new ICMProxyConnection();
      boolean boolean0 = iCMProxyConnection1.equals((Object) iCMProxyConnection0);
      assertEquals(0, iCMProxyConnection0.getPeerPort());
      assertEquals(0, iCMProxyConnection0.getLocalPort());
      assertEquals(0, iCMProxyConnection0.getSocket());
      assertEquals(false, boolean0);
      assertEquals(0, iCMProxyConnection0.getNihdl());
  }

  @Test
  public void test37()  throws Throwable  {
      ICMProxyConnection iCMProxyConnection0 = new ICMProxyConnection();
      int int0 = iCMProxyConnection0.hashCode();
      assertEquals(1, int0);
  }
}
