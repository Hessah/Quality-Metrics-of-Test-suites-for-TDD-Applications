/*
 * Created: Nov 1, 2004
 * File version: $Id: AttributeActionTest.java,v 1.3 2005/06/25 16:01:35 jaknowlden Exp $
 * 
 * Helium, Dynamic content replacement
 * Copyright (C) 2004  The Sleepless, Inc.
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
package com.thesleepless.heliumx.servlet.action;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.util.testharness.TestRequest;
import org.apache.util.testharness.TestResponse;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.heliumx.servlet.ServletHeliumTestFixture;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.3 $"
 */
public class AttributeActionTest extends ServletHeliumTestFixture {

  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("attribute", AttributeAction.class);
  }

  public void testAttributeNameNotDefined() throws Exception {
    try {
      TestRequest req = new TestRequest(TestRequest.GET);
      TestResponse res = new TestResponse();
      Article article = buildArticle("<article><attribute/></article>");
      article.parse(getServletHeliumContext(req, res));
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [name] not defined for Action [attribute]", e.getMessage());
    }
  }

  public void testReadAttribute() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    req.setAttribute("attr1", "attrVal1");
    req.setAttribute("attr2", "attrVal2");
    Article article = buildArticle("<article>[<attribute name=\"attr1\"/>][<attribute name=\"attr2\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[attrVal1][attrVal2]", writer.toString());
  }

  public void testReadEmptyAttributeName() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article>[<attribute name=\"\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[]", writer.toString());
  }

  public void testWriteToAttribute() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article><attribute name=\"attr1\" value=\"attrVal1\"/>[<attribute name=\"attr1\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[attrVal1]", writer.toString());
    assertEquals("attrVal1", req.getAttribute("attr1"));
  }

  public void testWriteToAttributeWithEmptyValue() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article><attribute name=\"attr1\" value=\"\"/>[<attribute name=\"attr1\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[]", writer.toString());
    assertEquals("", req.getAttribute("attr1"));
  }

  public void testCopyAttribute() throws Exception {
    Object origObj = new Object();
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    req.setAttribute("origAttr", origObj);
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article><attribute name=\"attr1\" fromAttribute=\"origAttr\"/></article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("", writer.toString());
    assertEquals(origObj, req.getAttribute("attr1"));
  }

  public void testCopyNullAttribute() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article><attribute name=\"attr1\" fromAttribute=\"origAttr\"/></article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("", writer.toString());
    assertNull(req.getAttribute("attr1"));
  }

  public void testCopyVarToAttribute() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));

    HeliumContext context = getServletHeliumContext(req, res);
    context.getDataMap().put("var1", "var1Val");

    Article article = buildArticle("<article><attribute name=\"attr1\" fromVar=\"var1\"/>[<attribute name=\"attr1\"/>]</article>");
    article.parse(context);
    assertEquals("[var1Val]", writer.toString());
    assertEquals("var1Val", req.getAttribute("attr1"));
  }

  public void testWriteBodyToAttribute() throws Exception {
    Object origObj = new Object();
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    req.setAttribute("origAttr", origObj);
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article><attribute name=\"attr1\">my value</attribute>[<attribute name=\"attr1\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[my value]", writer.toString());
    assertEquals("my value", req.getAttribute("attr1"));
  }

}