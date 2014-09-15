/*
 * Created: Jun 25, 2005
 * File version: "$Id: RequestActionTest.java,v 1.1 2005/06/30 04:02:14 jaknowlden Exp $"
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
package com.thesleepless.heliumx.servlet.action;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.util.testharness.TestRequest;
import org.apache.util.testharness.TestResponse;

import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.action.FieldNotFoundException;
import com.thesleepless.heliumx.servlet.ServletHeliumTestFixture;

public class RequestActionTest extends ServletHeliumTestFixture {
  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("request", RequestAction.class);
  }

  public void testContextPath() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    req.setContextPath("/foo/bar");
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    buildArticle("<request field=\"contextPath\"/>").parse(getServletHeliumContext(req, res));
    assertEquals("/foo/bar", writer.toString());
  }

  public void testServletPath() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    req.setServletPath("/bar/goo");
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    buildArticle("<request field=\"servletPath\"/>").parse(getServletHeliumContext(req, res));
    assertEquals("/bar/goo", writer.toString());
  }

  public void testBadField() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    req.setContextPath("/foo/bar");
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    try {
      buildArticle("<request field=\"badField\"/>").parse(getServletHeliumContext(req, res));
      fail("Should have thrown Exception");
    } catch (HeliumException e) {
      assertEquals("Field [badField] from Class [" + TestRequest.class.toString()
          + "] for Action [request] threw Exception [" + generateMethodNotFound("badField") + "]",
          e.getMessage());
    }
  }

  private String generateMethodNotFound(String fieldName) {
    return FieldNotFoundException.class.getName() + ": Field not found: " + fieldName;
  }

  public void testMissingArguments() throws Exception {
    assertArgumentMissing("<request/>", "field", "request");
  }

  public void testContextPathToVar() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    req.setContextPath("/foo/bar");
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));

    assertNull(getServletHeliumContext(req, res).getDataMap().get("servletPath"));
    buildArticle("<request field=\"contextPath\" toVar=\"baz\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals("", writer.toString());
    assertEquals("/foo/bar", getServletHeliumContext(req, res).getDataMap().get("baz"));
  }

  public void testServletPathToVar() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    req.setServletPath("/bar/goo");
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));

    assertNull(getServletHeliumContext(req, res).getDataMap().get("servletPath"));
    buildArticle("<request field=\"servletPath\" toVar=\"foo\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals("", writer.toString());
    assertEquals("/bar/goo", getServletHeliumContext(req, res).getDataMap().get("foo"));
  }

}
