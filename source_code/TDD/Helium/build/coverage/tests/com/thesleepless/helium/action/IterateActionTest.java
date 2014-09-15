/*
 * Created: Sep 20, 2004
 * File version: $Id: IterateActionTest.java,v 1.2 2005/06/11 21:27:34 jaknowlden Exp $
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

import java.util.ArrayList;
import java.util.Collection;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumTestFixture;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class IterateActionTest extends HeliumTestFixture {

  private static final String ActionName = "iterate";

  public void testMissingArguments() throws Exception {
    assertArgumentMissing("<article>0<iterate itemVar=\"tmpVar\"/>1</article>", "var",
        ActionName);
    assertNull(getContext().getDataMap().get("tmpVar"));

    assertArgumentMissing("<article>0<iterate var=\"myVar\"/>1</article>", "itemVar",
        ActionName);
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateWithNoBody() throws Exception {
    Article article = buildArticle("<article>0<iterate var=\"myVar\" itemVar=\"tmpVar\"/>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertNull(getContext().getDataMap().get("myVar"));
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateOverNullValue() throws Exception {

    Article article = buildArticle("<article>0<iterate var=\"myVar\" itemVar=\"tmpVar\">blah</iterate>1</article>");
    article.parse(getContext());
    assertEquals("01", getWrittenData());
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateOverObjectInstance() throws Exception {

    Object myVar = new Object();
    getContext().getDataMap().put("myVar", myVar);
    Article article = buildArticle("<article>0<iterate var=\"myVar\" itemVar=\"tmpVar\">blah</iterate>1</article>");
    article.parse(getContext());
    assertEquals("0blah1", getWrittenData());
    assertEquals(myVar, getContext().getDataMap().get("myVar"));
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateOverObjectInstanceWithElement() throws Exception {

    String myVar = new String("hello");
    getContext().getDataMap().put("myVar", myVar);
    Article article = buildArticle("<article>0"
        + "<iterate var=\"myVar\" itemVar=\"tmpVar\">#{tmpVar}</iterate>" + "1</article>");
    article.parse(getContext());
    assertEquals("0hello1", getWrittenData());
    assertEquals(myVar, getContext().getDataMap().get("myVar"));
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateOverList() throws Exception {

    Collection myVar = new ArrayList(5);
    myVar.add("a");
    myVar.add("b");
    myVar.add("c");
    myVar.add("d");
    myVar.add("e");
    getContext().getDataMap().put("myVar", myVar);
    Article article = buildArticle("<article>0"
        + "<iterate var=\"myVar\" itemVar=\"tmpVar\">[#{tmpVar}]</iterate>"
        + "1</article>");
    article.parse(getContext());
    assertEquals("0[a][b][c][d][e]1", getWrittenData());
    assertEquals(myVar, getContext().getDataMap().get("myVar"));
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

  public void testIterateOverArray() throws Exception {

    String[] myVar = new String[]{"a", "b", "c", "d", "e"};
    getContext().getDataMap().put("myVar", myVar);
    Article article = buildArticle("<article>0"
        + "<iterate var=\"myVar\" itemVar=\"tmpVar\">[#{tmpVar}]</iterate>"
        + "1</article>");
    article.parse(getContext());
    assertEquals("0[a][b][c][d][e]1", getWrittenData());
    assertEquals(myVar, getContext().getDataMap().get("myVar"));
    assertNull(getContext().getDataMap().get("tmpVar"));
  }

}
