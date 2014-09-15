/*
 * Created: Jul 12, 2004
 * File version: $Id: AbstractAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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

import java.io.PrintWriter;
import java.io.StringWriter;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.ArticleBuilder;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public abstract class AbstractAction implements Action {

  protected void doBody(Article article, HeliumContext context) throws HeliumException {
    article.getFirstChildArticle().parse(context);
  }

  /**
   * Renders the body of an Article and returns it as a String
   * @param article The Article instance containing the body
   * @param context The HeliumContext for the request
   * @return Rendered body
   * @throws HeliumException
   */
  protected String getBody(Article article, HeliumContext context) throws HeliumException {
    PrintWriter actualWriter = context.getWriter();
    StringWriter tmpWriter = new StringWriter();
    context.setWriter(new PrintWriter(tmpWriter));
    doBody(article, context);
    context.setWriter(actualWriter);
    return tmpWriter.toString();
  }

  protected void parseArticle(String articleName, HeliumContext context) throws HeliumException {
    ArticleBuilder.locateAndBuild(articleName, context).parse(context);
  }

  protected String getArgumentValue(Article article, String argName) {
    return article.getArgument(argName).getValue();
  }

  protected String checkRequiredArgument(Article article, String argName) throws HeliumException {
    if (!article.containsArgument(argName))
      throw new HeliumException("Argument [" + argName + "] not defined for Action ["
          + article.getName() + "]");
    return getArgumentValue(article, argName);
  }

}
