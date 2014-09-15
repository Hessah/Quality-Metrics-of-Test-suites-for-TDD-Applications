/*
 * Created: Oct 25, 2004
 * File version: $Id: ParameterActionTest.java,v 1.2 2005/06/25 16:01:35 jaknowlden Exp $
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
import com.thesleepless.heliumx.servlet.ServletHeliumTestFixture;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class ParameterActionTest extends ServletHeliumTestFixture {

  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("parameter", ParameterAction.class);
  }

  public void testReadParameter() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    req.setParameter("param1", "paramVal1");
    req.setParameter("param2", "paramVal2");
    Article article = buildArticle("<article>[<parameter name=\"param1\"/>][<parameter name=\"param2\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[paramVal1][paramVal2]", writer.toString());
  }

  public void testReadEmptyParameterName() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article>[<parameter name=\"\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[]", writer.toString());
  }
}