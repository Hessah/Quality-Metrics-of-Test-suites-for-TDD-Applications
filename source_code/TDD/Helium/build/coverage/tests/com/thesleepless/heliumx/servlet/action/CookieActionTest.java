/*
 * Created: Nov 3, 2004
 * File version: $Id: CookieActionTest.java,v 1.2 2005/06/25 16:01:35 jaknowlden Exp $
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

import javax.servlet.http.Cookie;

import org.apache.util.testharness.TestRequest;
import org.apache.util.testharness.TestResponse;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.heliumx.servlet.ServletHeliumTestFixture;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class CookieActionTest extends ServletHeliumTestFixture {

  /**
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("cookie", CookieAction.class);
  }

  public void testCookieNameArgNotDefined() throws Exception {
    try {
      TestRequest req = new TestRequest(TestRequest.GET);
      TestResponse res = new TestResponse();
      Article article = buildArticle("<article><cookie/></article>");
      article.parse(getServletHeliumContext(req, res));
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [name] not defined for Action [cookie]", e.getMessage());
    }
  }

  public void testCookieNotFound() throws Exception {
    Writer writer = new StringWriter();
    TestRequest req = new TestRequest(TestRequest.GET);
    req.addCookie(new Cookie("cookie1", "cookie value"));
    TestResponse res = new TestResponse();
    res.setWriter(new PrintWriter(writer));
    Article article = buildArticle("<article>[<cookie name=\"invalid\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[]", writer.toString());
  }

  public void testRetrieveCookieValue() throws Exception {
    Writer writer = new StringWriter();
    TestRequest req = new TestRequest(TestRequest.GET);
    req.addCookie(new Cookie("cookie1", "cookie value"));
    TestResponse res = new TestResponse();
    res.setWriter(new PrintWriter(writer));

    Article article = buildArticle("<article>[<cookie name=\"cookie1\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[cookie value]", writer.toString());
  }

  public void testRetrieveCookieValueWithTwoCookiesPresent() throws Exception {
    Writer writer = new StringWriter();
    TestRequest req = new TestRequest(TestRequest.GET);
    req.addCookie(new Cookie("cookie1", "cookie value"));
    req.addCookie(new Cookie("cookie2", "cookie 2 value"));
    TestResponse res = new TestResponse();
    res.setWriter(new PrintWriter(writer));

    Article article = buildArticle("<article>[<cookie name=\"cookie2\"/>]</article>");
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[cookie 2 value]", writer.toString());
  }

  public void testAddCookie() throws Exception {
    assertAddCookie("<article>[<cookie name=\"cookie1\" value=\"value1\"/>]</article>", newCookie(
        "cookie1", "value1"));
  }

  public void testAddCookieWithDomain() throws Exception {
    assertAddCookie(
        "<article>[<cookie name=\"cookie1\" value=\"value1\" domain=\".he.org\"/>]</article>",
        newCookie("cookie1", "value1", ".he.org"));
  }

  public void testAddCookieWithDomainAndPath() throws Exception {
    assertAddCookie(
        "<article>[<cookie name=\"cookie1\" value=\"value1\" domain=\".he.org\" path=\"/\"/>]</article>",
        newCookie("cookie1", "value1", ".he.org", "/"));
  }

  public void testAddCookieWithDomainPathAndAge() throws Exception {
    assertAddCookie(
        "<article>[<cookie name=\"cookie1\" value=\"value1\" domain=\".he.org\" path=\"/\" maxAge=\"100\"/>]</article>",
        newCookie("cookie1", "value1", ".he.org", "/", 100));
  }

  public void testAddCookieWithNonNumberAge() throws Exception {
    try {
      assertAddCookie(
          "<article>[<cookie name=\"cookie1\" value=\"value1\" maxAge=\"a\"/>]</article>", null);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Value [a] for argument [maxAge] of the Action [cookie] is not valid", e
          .getMessage());
    }
  }

  public void testAddCookieWithDomainPathAgeAndSecure() throws Exception {
    assertAddCookie(
        "<article>["
            + "<cookie name=\"cookie1\" value=\"value1\" domain=\".he.org\" path=\"/\" maxAge=\"100\" secure=\"true\"/>]"
            + "</article>", newCookie("cookie1", "value1", ".he.org", "/", 100, true));
  }

  public void testAddCookieWithSecureAsYes() throws Exception {
    assertAddCookie("<article>[" + "<cookie name=\"cookie1\" value=\"value1\" secure=\"yes\"/>]"
        + "</article>", newCookie("cookie1", "value1", null, null, -1, false));
  }

  private void assertAddCookie(String articleTxt, Cookie expectedCookie) throws Exception {
    Writer writer = new StringWriter();
    TestRequest req = new TestRequest(TestRequest.GET);
    TestResponse res = new TestResponse();
    res.setWriter(new PrintWriter(writer));

    assertNull(req.getCookies());
    Article article = buildArticle(articleTxt);
    article.parse(getServletHeliumContext(req, res));
    assertEquals("[]", writer.toString());
    assertEquals(1, res.getCookies().size());
    assertCookie(expectedCookie, (Cookie) res.getCookies().elementAt(0));
  }

  private void assertCookie(Cookie expectedCookie, Cookie actualCookie) {
    assertEquals(expectedCookie.getName(), actualCookie.getName());
    assertEquals(expectedCookie.getValue(), actualCookie.getValue());
    assertEquals(expectedCookie.getMaxAge(), actualCookie.getMaxAge());
    assertEquals(expectedCookie.getComment(), actualCookie.getComment());
    assertEquals(expectedCookie.getDomain(), actualCookie.getDomain());
    assertEquals(expectedCookie.getPath(), actualCookie.getPath());
    assertEquals(expectedCookie.getSecure(), actualCookie.getSecure());
  }

  private Cookie newCookie(String name, String value) {
    return newCookie(name, value, null);
  }

  private Cookie newCookie(String name, String value, String domain) {
    return newCookie(name, value, domain, null);
  }

  private Cookie newCookie(String name, String value, String domain, String path) {
    return newCookie(name, value, domain, path, -1);
  }

  private Cookie newCookie(String name, String value, String domain, String path, int maxAge) {
    return newCookie(name, value, domain, path, maxAge, false);
  }

  private Cookie newCookie(String name, String value, String domain, String path, int maxAge,
      boolean secure) {
    Cookie cookie = new Cookie(name, value);
    if (domain != null)
      cookie.setDomain(domain);
    if (path != null)
      cookie.setPath(path);
    cookie.setMaxAge(maxAge);
    cookie.setSecure(secure);
    return cookie;
  }

}