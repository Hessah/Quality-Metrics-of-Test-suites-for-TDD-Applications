/*
 * Created: Jul 9, 2004
 * File version: $Id: ArticleBuilderTest.java,v 1.2 2005/06/23 14:53:27 jaknowlden Exp $
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
package com.thesleepless.helium;

import java.io.IOException;
import java.io.StringReader;

import org.xml.sax.SAXParseException;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class ArticleBuilderTest extends HeliumTestFixture {

  private void assertArticle(Article child, String name, String text, boolean children) {
    assertEquals(name, child.getName());
    assertEquals(text, child.getText());
    assertEquals(children, child.hasChildren());
  }

  private void assertNullArticle(Article article) {
    assertEquals(NullArticle.class, article.getClass());
    assertNull(article.getName());
    assertFalse(article.isTextArticle());
    assertFalse(article.isLiteralArticle());
    assertFalse(article.isCommentArticle());
    assertNull(article.getText());
    assertEquals(article, article.getNextArticle());
    assertFalse(article.hasChildren());
    assertNull(article.getFirstChildArticle());
    assertFalse(article.containsArgument(null));
    assertNull(article.getArgument(null));
    assertNull(article.getArguments());
  }

  public void testBuildNullReader() throws Exception {
    try {
      ArticleBuilder.build(null);
      fail("Should have failed");
    } catch (NullPointerException e) {
      assertEquals("Article reader not defined", e.getMessage());
    }
  }

  public void testBuildNoDocumentRoot() throws Exception {
    try {
      ArticleBuilder.build(new StringReader(""));
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals(SAXParseException.class, e.getCause().getClass());
    }
  }

  public void testBuildEmptyArticle() throws Exception {
    Article article = ArticleBuilder.build(new StringReader("<article/>"));
    assertNotNull(article);
    assertArticle(article, "article", null, false);
  }

  public void testBuildTextOnlyArticle() throws Exception {
    Article article = ArticleBuilder.build(new StringReader("<article>hello, world</article>"));
    assertArticle(article, "article", null, true);
    assertNullArticle(article.getNextArticle());

    Article child = article.getFirstChildArticle();
    assertArticle(child, null, "hello, world", false);
  }

  public void testBuildTextAndMarkup() throws Exception {
    Article article = ArticleBuilder.build(new StringReader("<article>hello <a/> world</article>"));
    assertArticle(article, "article", null, true);
    assertNullArticle(article.getNextArticle());

    Article text1 = article.getFirstChildArticle();
    assertArticle(text1, null, "hello ", false);

    Article markup = text1.getNextArticle();
    assertArticle(markup, "a", null, false);

    Article text2 = markup.getNextArticle();
    assertArticle(text2, null, " world", false);
  }

  public void testLocateAndBuild() throws Exception {
    ShuntArticleSource source = new ShuntArticleSource();
    getContext().setArticleSource(source);
    source.addArticleContents("article.a", "<article>hello, world</article>");

    Article article = ArticleBuilder.locateAndBuild("article.a", getContext());
    assertArticle(article, "article", null, true);
    assertNullArticle(article.getNextArticle());

    Article child = article.getFirstChildArticle();
    assertArticle(child, null, "hello, world", false);
    assertFalse(child.hasChildren());
  }

  public void testLocateAndBuildIoException() throws Exception {
    ArticleSource source = new IoExceptionArticleSource();
    getContext().setArticleSource(source);

    try {
      ArticleBuilder.locateAndBuild("article.a", getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals(IOException.class, e.getCause().getClass());
      assertEquals(IoExceptionArticleSource.Message, e.getCause().getMessage());
    }
  }

}
