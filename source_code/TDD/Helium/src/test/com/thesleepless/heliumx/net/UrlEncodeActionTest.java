/*
 * Created: Jun 25, 2005
 * File version: "$Id: UrlEncodeActionTest.java,v 1.1 2005/06/26 00:04:25 jaknowlden Exp $"
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
package com.thesleepless.heliumx.net;

import java.io.UnsupportedEncodingException;

import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumTestFixture;

public class UrlEncodeActionTest extends HeliumTestFixture {
  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("encode", UrlEncodeAction.class);
  }

  public void testEncodeChildContent() throws Exception {
    buildArticle("<encode> #</encode>").parse(getContext());
    assertEquals("+%23", getWrittenData());
  }

  public void testEncodeValueArg() throws Exception {
    buildArticle("<encode value=\"# \"/>").parse(getContext());
    assertEquals("%23+", getWrittenData());
  }

  public void testEncodeFromVarArg() throws Exception {
    getContext().getDataMap().put("foo", " #");
    buildArticle("<encode fromVar=\"foo\"/>").parse(getContext());
    assertEquals("+%23", getWrittenData());
  }

  public void testEncodeFromVarArgButVarNotExist() throws Exception {
    try {
      buildArticle("<encode fromVar=\"foo\"/>").parse(getContext());
      fail("Should have thrown Exception");
    } catch (HeliumException e) {
      assertEquals("Var [foo] not defined for Action [encode]", e.getMessage());
    }
  }

  public void testFromVarBeatsChildContent() throws Exception {
    getContext().getDataMap().put("foo", "bar");
    buildArticle("<encode fromVar=\"foo\">whoops!</encode>").parse(getContext());
    assertEquals("bar", getWrittenData());
  }

  public void testChildContentBeatsValueArg() throws Exception {
    buildArticle("<encode value=\"whoops!\">foo</encode>").parse(getContext());
    assertEquals("foo", getWrittenData());
  }

  public void testMissingArg() throws Exception {
    assertArgumentMissing("<encode/>", "value", "encode");
  }

  public void testProvideDifferentCharset() throws Exception {
    buildArticle("<encode charset=\"US-ASCII\">" + '\u1234' + "</encode>").parse(getContext());
    assertEquals("%3F", getWrittenData());
  }

  public void testProvideBadCharset() throws Exception {
    try {
      buildArticle("<encode charset=\"FOO\">foo</encode>").parse(getContext());
      fail("Should have thrown Exception");
    } catch (HeliumException e) {
      assertEquals(UnsupportedEncodingException.class, e.getCause().getClass());
      assertEquals("FOO", e.getCause().getMessage());
    }
  }
}
