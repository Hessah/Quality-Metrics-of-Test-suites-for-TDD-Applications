/*
 * Created: Jul 15, 2004
 * File version: $Id: IncludeActionTest.java,v 1.2 2005/06/23 14:53:27 jaknowlden Exp $
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

import com.thesleepless.helium.Article;
import com.thesleepless.helium.ArticleNotFoundException;
import com.thesleepless.helium.HeliumTestFixture;
import com.thesleepless.helium.ShuntArticleSource;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class IncludeActionTest extends HeliumTestFixture {

  private static final String ActionName = "include";
  private ShuntArticleSource articleSource;

  protected void setUp() throws Exception {
    super.setUp();
    getContext().setArticleSource(articleSource = new ShuntArticleSource());
    getContext().getActionRegister().register(ActionName, IncludeAction.class);
  }

  public void testIncludeArticle() throws Exception {
    articleSource.addArticleContents("my-article", "<article>blah</article>");

    Article article = buildArticle("<article>0<include article=\"my-article\"/>1</article>");
    article.parse(getContext());
    assertEquals("0blah1", getWrittenData());
  }

  public void testArticleArgumentNotDefined() throws Exception {
    assertArgumentMissing("<article>0<include/>1</article>", "article", ActionName);
  }

  public void testArticleNotFound() throws Exception {
    Article article = buildArticle("<article>0<include article=\"does-not-exist\"/>1</article>");
    try {
      article.parse(getContext());
      fail("Should have failed");
    } catch (ArticleNotFoundException e) {
      assertEquals("Article [does-not-exist] not found", e.getMessage());
    }
  }

  public void testIncludeArticleThatIncludesArticle() throws Exception {
    articleSource.addArticleContents("my-article",
        "<article>a<include article=\"my-sub-article\"/>b</article>");
    articleSource.addArticleContents("my-sub-article", "<article>blah</article>");

    Article article = buildArticle("<article>0<include article=\"my-article\"/>1</article>");
    article.parse(getContext());
    assertEquals("0ablahb1", getWrittenData());
  }

  public void testIncludeAsTemplate() throws Exception {
    getContext().getActionRegister().register("var", VarAction.class);
    articleSource.addArticleContents("article-2", "<article>a#{var1}b</article>");

    Article article = buildArticle("<article>0<include article=\"article-2\"><var name=\"var1\" value=\"val1\"/></include>1</article>");
    article.parse(getContext());
    assertEquals("0aval1b1", getWrittenData());
    assertFalse(getContext().getDataMap().containsKey("var1"));
  }

}