/*
 * Created: Apr 5, 2005
 * File version: "$Id: TryItAction.java,v 1.2 2005/04/26 03:19:55 jaknowlden Exp $"
 * 
 * HeliumExample, Examples of Helium
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
package com.thesleepless.helium.example.action;

import java.io.PrintWriter;
import java.io.StringReader;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.ArticleBuilder;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.action.AbstractAction;

public class TryItAction extends AbstractAction {

  public void service(Article article, HeliumContext context) throws HeliumException {
    String value = context.getDataMap().get(checkRequiredArgument(article, "var")).toString();
    try {
      Article subArticle = ArticleBuilder.build(new StringReader(value));
      context.getWriter().write(getBody(subArticle, context));
    } catch (Exception e) {
      e.printStackTrace(new PrintWriter(context.getWriter()));
    }
  }

}
