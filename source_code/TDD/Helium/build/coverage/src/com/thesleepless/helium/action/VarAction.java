/*
 * Created: Jul 17, 2004
 * File version: $Id: VarAction.java,v 1.2 2005/06/11 19:37:45 jaknowlden Exp $
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
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class VarAction extends AbstractAction {

  private static final String ArgValue = "value";
  private static final String ArgFromVar = "fromVar";
  private static final String ArgName = "name";

  /**
   * @see com.thesleepless.helium.action.Action#service(com.thesleepless.helium.Article, java.io.Writer)
   */
  public void service(Article article, HeliumContext context) throws HeliumException {
    String varName = checkRequiredArgument(article, ArgName);
    if (article.containsArgument(ArgFromVar))
      context.getDataMap().put(varName,
          context.getDataMap().get(getArgumentValue(article, ArgFromVar)));
    else if (article.hasChildren())
      context.getDataMap().put(varName, getBody(article, context));
    else if (article.containsArgument(ArgValue))
      context.getDataMap().put(varName, getArgumentValue(article, ArgValue));
  }

}