/*
 * Created: Nov 1, 2004
 * File version: $Id: AttributeAction.java,v 1.2 2005/06/11 21:53:17 jaknowlden Exp $
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
package com.thesleepless.heliumx.servlet.action;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.heliumx.servlet.ServletHeliumContext;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class AttributeAction extends HttpServletAction {

  private static final String ArgValue = "value";
  private static final String ArgFromAttribute = "fromAttribute";
  private static final String ArgFromVar = "fromVar";

  /**
   * @see com.thesleepless.heliumx.servlet.action.HttpServletAction#service(com.thesleepless.helium.Article, com.thesleepless.heliumx.servlet.ServletHeliumContext)
   */
  protected void service(Article article, ServletHeliumContext context) throws HeliumException {
    String nameArg = checkRequiredArgument(article, ArgName);
    if (article.containsArgument(ArgFromAttribute))
      setAttribute(context, nameArg, context.getRequest().getAttribute(
          getArgumentValue(article, ArgFromAttribute)));
    else if (article.containsArgument(ArgFromVar))
      setAttribute(context, nameArg, context.getDataMap().get(
          getArgumentValue(article, ArgFromVar)));
    else if (article.hasChildren())
      setAttribute(context, nameArg, getBody(article, context));
    else if (article.containsArgument(ArgValue))
      setAttribute(context, nameArg, getArgumentValue(article, ArgValue));
    else
      writeObject(context.getRequest().getAttribute(nameArg), context);
  }

  /**
   * @param context
   * @param nameArg
   * @param attr
   */
  private void setAttribute(ServletHeliumContext context, String nameArg, Object value) {
    if (value != null)
      context.getRequest().setAttribute(nameArg, value);
  }

}