/*
 * Created: Apr 8, 2005
 * File version: "$Id: ListActionTest.java,v 1.2 2005/06/25 01:13:56 jaknowlden Exp $"
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

import java.util.ArrayList;
import java.util.List;

import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumTestFixture;

public class ListActionTest extends HeliumTestFixture {

  public void testEmptyList() throws Exception {
    buildArticle("<article>[<list name=\"a\"/>]</article>").parse(getContext());
    List list = (List) getContext().getDataMap().get("a");
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(0, list.size());
    assertEquals("[]", getWrittenData());

    getContext().setWriter(newWriter());
    buildArticle("<article>[<list name=\"a\"></list>]</article>").parse(getContext());
    list = (List) getContext().getDataMap().get("a");
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(0, list.size());
    assertEquals("[]", getWrittenData());
  }

  public void testListWithChildText() throws Exception {
    buildArticle("<article>[<list name=\"b\">blah</list>]</article>").parse(getContext());
    List list = (List) getContext().getDataMap().get("b");
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(1, list.size());
    assertEquals("blah", list.get(0));
    assertEquals("[]", getWrittenData());
  }

  public void testListWithValueArg() throws Exception {
    buildArticle("<article>[<list name=\"b\" value=\"blah\"/>]</article>").parse(getContext());
    List list = (List) getContext().getDataMap().get("b");
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(1, list.size());
    assertEquals("blah", list.get(0));
    assertEquals("[]", getWrittenData());
  }

  public void testListWithValueArgAndChildText() throws Exception {
    buildArticle("<article>[<list name=\"b\" value=\"not blah\">blah</list>]</article>").parse(getContext());
    List list = (List) getContext().getDataMap().get("b");
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(1, list.size());
    assertEquals("blah", list.get(0));
    assertEquals("[]", getWrittenData());
  }

  public void testListNameNotDefined() throws Exception {
    try {
      buildArticle("<article>[<list/>]</article>").parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [name] not defined for Action [list]", e.getMessage());
    }
  }

  public void testListAlreadyHasItems() throws Exception {
    List list = new ArrayList();
    list.add("1");
    getContext().getDataMap().put("a", list);
    buildArticle("<article>[<list name=\"a\" value=\"2\"/>]</article>").parse(getContext());
    assertNotNull(list);
    assertEquals(ArrayList.class, list.getClass());
    assertEquals(2, list.size());
    assertEquals("1", list.get(0));
    assertEquals("2", list.get(1));
    assertEquals("[]", getWrittenData());
  }

  public void testListVarInUseButNotList() throws Exception {
    Object expectedObject = new Object();
    getContext().getDataMap().put("a", expectedObject);
    try {
      buildArticle("<article>[<list name=\"a\" value=\"2\"/>]</article>").parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Variable [a] not of expected type for Action [list]", e.getMessage());
      assertEquals(expectedObject, getContext().getDataMap().get("a"));
    }
  }

}
