/*
 * Created: Jul 17, 2004
 * File version: $Id: HeliumTestFixture.java,v 1.3 2005/06/30 04:02:40 jaknowlden Exp $
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

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import junit.framework.TestCase;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.3 $"
 */
public class HeliumTestFixture extends TestCase {

  private HeliumContext context;
  private Writer writer;

  /**
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception {
    super.setUp();
    context = HeliumFactory.newHeliumContext();
    context.setWriter(newWriter());
  }

  public HeliumContext getContext() {
    return context;
  }

  protected PrintWriter newWriter() {
    return new PrintWriter(writer = new StringWriter());
  }

  public String getWrittenData() {
    return writer.toString();
  }

  protected Article buildArticle(String xml) throws HeliumException {
    return ArticleBuilder.build(new StringReader(xml));
  }

  protected void assertArgumentMissing(String articleTxt, String missingArg, String actionName)
      throws Exception {
    assertArgumentMissing(articleTxt, missingArg, actionName, context);
  }

  protected void assertArgumentMissing(String articleTxt, String missingArg, String actionName,
      HeliumContext heliumContext) throws Exception {
    Article article = buildArticle(articleTxt);
    try {
      article.parse(heliumContext);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Argument [" + missingArg + "] not defined for Action [" + actionName + "]", e
          .getMessage());
    }
  }

}
