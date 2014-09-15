/*
 * Created: Apr 10, 2005
 * File version: "$Id: WhenActionTest.java,v 1.3 2007/03/05 22:15:59 jaknowlden Exp $"
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

import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumTestFixture;

public class WhenActionTest extends HeliumTestFixture {

  protected void setUp() throws Exception {
    super.setUp();
    getContext().getActionRegister().register("when", WhenAction.class);
  }

  public void testVarArgNotDefined() throws Exception {
    try {
      buildArticle("<when/>").parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [var] not defined for Action [when]", e.getMessage());
    }
  }

  public void testVarOnlyDefined() throws Exception {
    buildArticle("<when var=\"a\"/>").parse(getContext());
    assertEquals("", getWrittenData());
  }

  public void testVarOnlyDefinedWithChildContent() throws Exception {
    buildArticle("<when var=\"a\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "b");
    buildArticle("<when var=\"a\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());
  }

  public void testExistsTrue() throws Exception {
    buildArticle("<when var=\"a\" exists=\"true\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "");
    buildArticle("<when var=\"a\" exists=\"true\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "1");
    buildArticle("<when var=\"a\" exists=\"true\">hello, world</when>").parse(getContext());
    assertEquals("hello, world", getWrittenData());
  }

  public void testExistsFalse() throws Exception {
    buildArticle("<when var=\"a\" exists=\"false\">hello, world</when>").parse(getContext());
    assertEquals("hello, world", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "");
    buildArticle("<when var=\"a\" exists=\"false\">hello, world</when>").parse(getContext());
    assertEquals("hello, world", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "1");
    buildArticle("<when var=\"a\" exists=\"false\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());
  }

  public void testEquals() throws Exception {
    buildArticle("<when var=\"a\" equals=\"foo\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "");
    buildArticle("<when var=\"a\" equals=\"foo\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "bar");
    buildArticle("<when var=\"a\" equals=\"foo\">hello, world</when>").parse(getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "foo");
    buildArticle("<when var=\"a\" equals=\"foo\">hello, world</when>").parse(getContext());
    assertEquals("hello, world", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "foo");
    buildArticle("<when var=\"a\" equals=\"#{a}\">hello, world</when>").parse(getContext());
    assertEquals("hello, world", getWrittenData());
  }

  public void testEqualsBeforeExists() throws Exception {
    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "bar");
    buildArticle("<when var=\"a\" equals=\"foo\" exists=\"true\">hello, world</when>").parse(
        getContext());
    assertEquals("", getWrittenData());

    getContext().setWriter(newWriter());
    getContext().getDataMap().put("a", "foo");
    buildArticle("<when var=\"a\" equals=\"foo\" exists=\"false\">hello, world</when>").parse(
        getContext());
    assertEquals("hello, world", getWrittenData());
  }

}
