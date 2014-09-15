/*
 * Created: Jul 11, 2004
 * File version: $Id: ArticleParserTest.java,v 1.1 2005/05/03 23:34:42 jaknowlden Exp $
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


import com.thesleepless.helium.action.EchoArgumentsAction;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class ArticleParserTest extends HeliumTestFixture {

  public void testParseEmptyArticle() throws Exception {
    assertParse("<article/>", "");
  }

  public void testParseTextOnly() throws Exception {
    assertParse("<article>hello, world</article>", "hello, world");
  }

  public void testParseEmptyMarkupOnly() throws Exception {
    assertParse("<article><a/></article>", "<a/>");
  }

  public void testParseEmptyMarkupOnlyAlternate() throws Exception {
    assertParse("<article><b></b></article>", "<b/>");
  }

  public void testParseTextAndMarkup() throws Exception {
    assertParse("<article>hello <a/> world</article>", "hello <a/> world");
  }

  public void testParseMarkupWithText() throws Exception {
    assertParse("<article><a>hello, world</a></article>", "<a>hello, world</a>");
  }

  public void testParseMarkupWithTextAndMarkup() throws Exception {
    assertParse("<article><b>hello <a/> world</b></article>", "<b>hello <a/> world</b>");
  }

  public void testParseEmptyMarkupWithAttributes() throws Exception {
    assertParse("<article><a b=\"1\" c=\"2\"/></article>", "<a b=\"1\" c=\"2\"/>");
  }

  public void testParseMarkupWithTextAndAttributes() throws Exception {
    assertParse("<article><a b=\"1\" c=\"2\">hello, world</a></article>",
        "<a b=\"1\" c=\"2\">hello, world</a>");
  }

  public void testParseTextWithTags() throws Exception {
    getContext().getDataMap().put("a", "1");
    getContext().getDataMap().put("hello.world", "hello, world");
    assertParse("<article>[#{a}]</article>", "[1]");
    getContext().setWriter(newWriter());
    assertParse("<article>[#{a}][#{hello.world}][#{a}]</article>", "[1][hello, world][1]");
  }

  public void testParseAttributeValueWithScriptMarkup() throws Exception {
    getContext().getDataMap().put("a", "1");
    getContext().getDataMap().put("b", "2");
    getContext().getActionRegister().register("echo-args", EchoArgumentsAction.class);
    assertParse("<article>[<echo-args a=\"#{a}\"/>]</article>", "[{a=1}]");
    getContext().setWriter(newWriter());
    assertParse("<article><xml attr1=\"#{a}.#{b}\" attr2=\"/#{a} before #{b}/\"/></article>",
        "<xml attr1=\"1.2\" attr2=\"/1 before 2/\"/>");
  }

  public void testParseCDATA() throws Exception {
    assertParse("<article><![CDATA[$#{}<>]]></article>", "$#{}<>");
  }

  public void testParseComment() throws Exception {
    assertParse("<article><!-- comment --></article>", "<!-- comment -->");
  }

  private void assertParse(String xmlIn, String expectedOut) throws Exception {
    buildArticle(xmlIn).parse(getContext());
    assertEquals(expectedOut, getWrittenData());
  }
}