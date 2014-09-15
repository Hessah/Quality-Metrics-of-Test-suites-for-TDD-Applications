/*
 * Created: Apr 5, 2005
 * File version: "$Id: TryItActionTest.java,v 1.1 2005/05/03 23:34:46 jaknowlden Exp $"
 * 
 * HeliumExample, Examples of Helium
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
package com.thesleepless.helium.example.action;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import junit.framework.TestCase;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.ArticleBuilder;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumFactory;
import com.thesleepless.helium.action.VarAction;

public class TryItActionTest extends TestCase {
  private HeliumContext context;
  private Writer writer;

  protected void setUp() throws Exception {
    super.setUp();
    context = HeliumFactory.newHeliumContext();
    context.setWriter(new PrintWriter(writer = new StringWriter()));
    context.getActionRegister().register("tryit", TryItAction.class);
    context.getActionRegister().register("var", VarAction.class);
  }

  public void testSimpleContent() throws Exception {
    context.getDataMap().put("helloWorld", "<article>hello, world</article>");
    buildArticle("<tryit var=\"helloWorld\"/>").parse(context);
    assertEquals("hello, world", writer.toString());
  }

  public void testUsingVar() throws Exception {
    context.getDataMap().put("a", "<article><var name=\"tmp\">temp value</var>[#{tmp}]</article>");
    buildArticle("<tryit var=\"a\"/>").parse(context);
    assertEquals("[temp value]", writer.toString());
  }

  public void testNoContent() throws Exception {
    context.getDataMap().put("a", "");
    buildArticle("<tryit var=\"a\"/>").parse(context);
    assertTrue(writer.toString().indexOf("SAXParseException") > -1);
  }

  public void testNoVarArg() throws Exception {
    try {
      buildArticle("<tryit/>").parse(context);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [var] not defined for Action [tryit]", e.getMessage());
    }
  }

  private Article buildArticle(String xml) throws Exception {
    return ArticleBuilder.build(new StringReader(xml));
  }
}
