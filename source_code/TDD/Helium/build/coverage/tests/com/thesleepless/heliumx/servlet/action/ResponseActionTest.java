/*
 * Created: Jul 4, 2005
 * File version: "$Id: ResponseActionTest.java,v 1.1 2005/08/23 19:26:56 jaknowlden Exp $"
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

import com.thesleepless.heliumx.servlet.ServletHeliumTestFixture;

public class ResponseActionTest extends ServletHeliumTestFixture {

  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("response", ResponseAction.class);
  }

  public void testMissingArguments() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    assertArgumentMissing("<response value=\"foo\"/>", "field", "response", getServletHeliumContext(req, res));
    assertArgumentMissing("<response field=\"bar\"/>", "value", "response", getServletHeliumContext(req, res));
  }

  public void testSetContentType() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    assertNull(res.getContentType());
    buildArticle("<response field=\"contentType\" value=\"foo/bar\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals("foo/bar", res.getContentType());
  }

  public void testSetIntegerFields() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    Writer writer = new StringWriter();
    res.setWriter(new PrintWriter(writer));
    buildArticle("<response field=\"contentLength\" value=\"10\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals(10, res.getContentLength());
    buildArticle("<response field=\"bufferSize\" value=\"20\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals(20, res.getBufferSize());
    buildArticle("<response field=\"status\" value=\"500\"/>").parse(
        getServletHeliumContext(req, res));
    assertEquals(500, res.getStatus());
  }
  public void testBadField() throws Exception {
    // TODO Invoke response using field name that does not exist
    fail("Not yet implemented");
  }
}
