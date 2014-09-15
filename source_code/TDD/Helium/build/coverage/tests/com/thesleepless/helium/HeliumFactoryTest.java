/*
 * Created: Apr 24, 2005
 * File version: "$Id: HeliumFactoryTest.java,v 1.1 2005/05/03 23:34:42 jaknowlden Exp $"
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
package com.thesleepless.helium;

import java.io.PrintWriter;
import java.util.HashMap;

import junit.framework.TestCase;

public class HeliumFactoryTest extends TestCase {

  public void testNewContext() throws Exception {
    HeliumContext context = HeliumFactory.newHeliumContext();
    assertEquals(PrintWriter.class, context.getWriter().getClass());
    assertEquals(HashMap.class, context.getDataMap().getClass());
    assertEquals(DefaultActionRegister.class, context.getActionRegister().getClass());
    assertEquals(NullArticleSource.class, context.getArticleSource().getClass());

    context.getWriter().print('1');
    context.getWriter().flush();
    context.getWriter().close();

    try {
      context.getArticleSource().getArticleReader("test-article.he");
      fail("Should have failed");
    } catch (ArticleNotFoundException e) {
      assertEquals("Article [test-article.he] not found", e.getMessage());
    }
  }

}
