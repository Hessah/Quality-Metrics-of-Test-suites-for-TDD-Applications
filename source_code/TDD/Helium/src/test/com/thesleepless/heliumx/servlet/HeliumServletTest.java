/*
 * Created: Oct 24, 2004
 * File version: $Id: HeliumServletTest.java,v 1.4 2005/06/30 04:02:40 jaknowlden Exp $
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
package com.thesleepless.heliumx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.util.testharness.ServletHarness;
import org.apache.util.testharness.TestRequest;
import org.apache.util.testharness.TestResponse;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.4 $"
 */
public class HeliumServletTest extends ServletHeliumTestFixture {

  private ServletHarness he;

  /**
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception {
    super.setUp();
    he = new ServletHarness(HeliumServlet.class, null);
  }

  private void setBootstrappedResource(String path, String baseContents) {
    StringBuffer buf = new StringBuffer();
    buf.append("<article>");
    buf.append("<actionset definition=\"/com/thesleepless/heliumx/servlet/servlet.has\"/>");
    buf.append(baseContents);
    buf.append("</article>");
    he.setStreamableResource(path, buf.toString());
  }

  public void testGetAndPostRequests() throws Exception {
    he.setStreamableResource("/get-article.he", "<article>hello, get</article>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/get-article.he");
    TestResponse res = he.service(req);
    assertEquals("hello, get", res.getContentAsString());

    he.setStreamableResource("/post-article.he", "<article>hello, post</article>");
    req = new TestRequest(TestRequest.POST, "http://localhost/post-article.he");
    res = he.service(req);
    assertEquals("hello, post", res.getContentAsString());
  }

  public void testArticleNotFound() throws Exception {
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/context/bad-article.he");
    req.setContextPath("/context");
    req.setServletPath("/bad-article.he");
    TestResponse res = he.service(req);
    assertEquals(404, res.getStatus());
    assertEquals("/context/bad-article.he", res.getError());
    assertEquals("", res.getContentAsString());
  }

  public void testActionFails() throws Exception {
    he.setStreamableResource("/e.he", "<action name=\"blah\" class=\"no.Class\"/>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/e.he");
    try {
      he.service(req);
      fail("Should have failed");
    } catch (ServletException e) {
      assertEquals("Action Class [no.Class] not found for Action [blah]", e.getMessage());
    }
  }

  public void testParameterAction() throws Exception {
    setBootstrappedResource("/param-article.he",
        "<article>[<parameter name=\"param1\"/>]</article>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/param-article.he");
    req.setParameter("param1", "param-val1");
    TestResponse res = he.service(req);
    assertEquals("[param-val1]", res.getContentAsString());
  }

  public void testAttributeAction() throws Exception {
    setBootstrappedResource("/attr-article.he", "<article>[<attribute name=\"attr1\"/>]</article>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/attr-article.he");
    req.setAttribute("attr1", "attr-val1");
    TestResponse res = he.service(req);
    assertEquals("[attr-val1]", res.getContentAsString());
  }

  public void testCookieAction() throws Exception {
    setBootstrappedResource("/cookie-article.he", "<article>[<cookie name=\"cookie1\"/>]</article>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/cookie-article.he");
    req.addCookie(new Cookie("cookie1", "cookie value"));
    TestResponse res = he.service(req);
    assertEquals("[cookie value]", res.getContentAsString());
  }

  public void testRequestAction() throws Exception {
    setBootstrappedResource("/request-article.he",
        "<article>[<request field=\"contextPath\"/>]</article>");
    TestRequest req = new TestRequest(TestRequest.GET, "http://localhost/request-article.he");
    req.setContextPath("/context");
    TestResponse res = he.service(req);
    assertEquals("[/context]", res.getContentAsString());
  }
}