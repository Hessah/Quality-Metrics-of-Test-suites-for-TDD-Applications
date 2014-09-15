/*
 * Created: May 16, 2005
 * File version: "$Id: ReflectActionTest.java,v 1.9 2005/09/07 17:29:48 jaknowlden Exp $"
 * 
 * Helium, Dynamic content replacement
 * Copyright (C) 2005  The Sleepless, Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.thesleepless.helium.action;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumTestFixture;

public class ReflectActionTest extends HeliumTestFixture {

  public void testRequiredArgsNotDefined() throws Exception {
    assertArgumentMissing("<reflect field=\"field\"/>", "var", "reflect");
    getContext().getDataMap().put("myBean", new Object());
    assertArgumentMissing("<reflect var=\"myBean\"/>", "field", "reflect");
  }

  public void testGetter() throws Exception {
    ReflectActionBean bean = new ReflectActionBean();
    getContext().getDataMap().put("myVar", bean);
    Article a = buildArticle("<reflect var=\"myVar\" field=\"field1\"/>");
    a.parse(getContext());
    assertEquals("null", getWrittenData());

    getContext().setWriter(newWriter());
    bean.setField1("foo");
    a.parse(getContext());
    assertEquals("foo", getWrittenData());

    getContext().setWriter(newWriter());
    a = buildArticle("<reflect var=\"myVar\" field=\"field2\"/>");
    bean.setField2("bar");
    a.parse(getContext());
    assertEquals("bar", getWrittenData());

    getContext().setWriter(newWriter());
    a = buildArticle("<reflect var=\"myVar\" field=\"field2\"></reflect>");
    bean.setField2("baz");
    a.parse(getContext());
    assertEquals("baz", getWrittenData());

    getContext().setWriter(newWriter());
    a = buildArticle("<reflect var=\"myVar\" field=\"readOnlyField\"/>");
    a.parse(getContext());
    assertEquals("read only value", getWrittenData());

    getContext().setWriter(newWriter());
    bean.setBooleanField(true);
    a = buildArticle("<reflect var=\"myVar\" field=\"booleanField\"/>");
    a.parse(getContext());
    assertEquals("true", getWrittenData());
  }

  public void testCopyToVar() throws Exception {
    ReflectActionBean bean = new ReflectActionBean();
    Object expected = new Object();
    bean.setObject(expected);
    getContext().getDataMap().put("myVar", bean);

    Article a = buildArticle("<reflect var=\"myVar\" field=\"object\" toVar=\"foo\"/>");
    a.parse(getContext());
    assertEquals("", getWrittenData());
    assertEquals(expected, getContext().getDataMap().get("foo"));
  }

  public void testBeanNotInDataMap() throws Exception {
    try {
      Article a = buildArticle("<reflect var=\"myBean\" field=\"field1\"/>");
      a.parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Variable [myBean] not defined in DataMap for Action [reflect]", e.getMessage());
    }
  }

  public void testSetter() throws Exception {
    ReflectActionBean bean = new ReflectActionBean();
    getContext().getDataMap().put("myBean", bean);
    Article a = buildArticle("<reflect var=\"myBean\" field=\"field1\" value=\"foo\"/>");
    a.parse(getContext());
    assertEquals("", getWrittenData());
    assertEquals("foo", bean.getField1());

    Object obj = new Object();
    getContext().getDataMap().put("tmpObj", obj);
    a = buildArticle("<reflect var=\"myBean\" field=\"object\" fromVar=\"tmpObj\"/>");
    a.parse(getContext());
    assertEquals("", getWrittenData());
    assertEquals(obj, bean.getObject());

    a = buildArticle("<reflect var=\"myBean\" field=\"field2\">hello, world</reflect>");
    a.parse(getContext());
    assertEquals("hello, world", bean.getField2());
    assertEquals("", getWrittenData());

    bean.writeOnlyField = null;
    a = buildArticle("<reflect var=\"myBean\" field=\"writeOnlyField\" value=\"hello, world\"/>");
    a.parse(getContext());
    assertEquals("hello, world", bean.writeOnlyField);
    assertEquals("", getWrittenData());
  }

  public void testSetterWithFromVarAndChildContent() throws Exception {
    ReflectActionBean bean = new ReflectActionBean();
    getContext().getDataMap().put("myBean", bean);
    getContext().getDataMap().put("myVar", "foo");
    Article a = buildArticle("<reflect var=\"myBean\" field=\"field1\" fromVar=\"myVar\">not foo</reflect>");
    a.parse(getContext());
    assertEquals("", getWrittenData());
    assertEquals("foo", bean.getField1());
  }

  public void testSetterWithChildContentAndValue() throws Exception {
    ReflectActionBean bean = new ReflectActionBean();
    getContext().getDataMap().put("myBean", bean);
    Article a = buildArticle("<reflect var=\"myBean\" field=\"field1\" value=\"not foo\">foo</reflect>");
    a.parse(getContext());
    assertEquals("", getWrittenData());
    assertEquals("foo", bean.getField1());
  }

  private void assertBadField(Object bean, String xml, String fieldName, String exceptionMsg) {
    try {
      getContext().getDataMap().put("myBean", bean);
      Article a = buildArticle(xml);
      a.parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Field [" + fieldName + "] from Class [" + bean.getClass().toString()
          + "] for Action [reflect] threw Exception [" + exceptionMsg + "]", e.getMessage());
    }
  }

  public void testBadField() throws Exception {
    assertBadField(new ReflectActionBean(), "<reflect var=\"myBean\" field=\"badField\"/>",
        "badField", generateMethodNotFound("badField"));
    assertBadField(new ReflectActionBean(), "<reflect var=\"myBean\" field=\"writeOnlyField\"/>",
        "writeOnlyField", generateMethodNotFound("writeOnlyField"));
    assertBadField(new RuntimeExceptionBean(),
        "<reflect var=\"myBean\" field=\"protectedField\"/>", "protectedField",
        generateMethodNotFound("protectedField"));

    assertBadField(new RuntimeExceptionBean(), "<reflect var=\"myBean\" field=\"field\"/>",
        "field", new RuntimeException("field").toString());
    assertBadField(new RuntimeExceptionBean(),
        "<reflect var=\"myBean\" field=\"field\" value=\"foo\"/>", "field", new RuntimeException(
            "foo").toString());
    assertBadField(new RuntimeExceptionBean(),
        "<reflect var=\"myBean\" field=\"field\">foo</reflect>", "field", new RuntimeException(
            "foo").toString());
    getContext().getDataMap().put("foo", "bar");
    assertBadField(new RuntimeExceptionBean(),
        "<reflect var=\"myBean\" field=\"field\" fromVar=\"foo\"/>", "field", new RuntimeException(
            "bar").toString());
  }

  private String generateMethodNotFound(String fieldName) {
    return FieldNotFoundException.class.getName() + ": Field not found: " + fieldName;
  }

  public void testIntegerField() throws Exception {
    // TODO Invoke a bean that expects an int
    fail("Not yet implemented");
  }

  public void testIntegerFieldWithArgSizeMismatch() throws Exception {
    // TODO Invoke a bean that expects more than one var
    // TODO Invoke a bean that expects zero vars
    fail("Not yet implemented");
  }
}
