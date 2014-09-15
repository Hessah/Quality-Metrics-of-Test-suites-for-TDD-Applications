/*
 * Created: Jul 17, 2004
 * File version: $Id: VarActionTest.java,v 1.3 2005/06/11 19:37:45 jaknowlden Exp $
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
package com.thesleepless.helium.action;

import java.io.Writer;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumTestFixture;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.3 $"
 */
public class VarActionTest extends HeliumTestFixture {

  public void testSetVarValue() throws Exception {
    Article article = buildArticle("<article>0<var name=\"myVar\" value=\"val\"/>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertEquals("val", getContext().getDataMap().get("myVar").toString());
  }

  public void testSetNameArgNotDefined() throws Exception {
    assertArgumentMissing("<article>0<var value=\"val\"/>1</article>", "name", "var");
  }

  public void testCopyVarValue() throws Exception {
    getContext().getDataMap().put("myVar", "test value");
    Article article = buildArticle("<article>0<var name=\"newVar\" fromVar=\"myVar\"/>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertEquals("test value", getContext().getDataMap().get("newVar"));
    assertEquals("test value", getContext().getDataMap().get("myVar"));
  }

  public void testSetValueOfArgNotProvided() throws Exception {
    Article article = buildArticle("<article>0<var name=\"myVar\" fromVar=\"\"/>1</article>");
    article.parse(getContext());
    assertEquals(null, getContext().getDataMap().get("myVar"));
  }

  public void testSetVarValueFromBody() throws Exception {
    Writer expectedWriter = getContext().getWriter();
    Article article = buildArticle("<article>0<var name=\"myVar\">test body</var>1</article>");
    article.parse(getContext());
    assertEquals("test body", getContext().getDataMap().get("myVar"));

    article = buildArticle("<article>0<var name=\"myVar\"><a>b</a></var>1</article>");
    article.parse(getContext());
    assertEquals("<a>b</a>", getContext().getDataMap().get("myVar"));
    assertEquals(expectedWriter, getContext().getWriter());
  }

  public void testRetrieveValue() throws Exception {
    getContext().getDataMap().put("myVar", "value retrieved");
    Article article = buildArticle("<article>0#{myVar}1</article>");
    article.parse(getContext());
    assertEquals("0value retrieved1", getWrittenData());
    assertEquals("value retrieved", getContext().getDataMap().get("myVar"));
  }

  public void testRetrieveValueNotExist() throws Exception {
    Article article = buildArticle("<article>0<var name=\"myVar\"/>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertNull(getContext().getDataMap().get("myVar"));
  }

  public void testRetrieveNullValue() throws Exception {
    getContext().getDataMap().put("myVar", null);
    Article article = buildArticle("<article>0<var name=\"myVar\"/>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertNull(getContext().getDataMap().get("myVar"));
  }

}
