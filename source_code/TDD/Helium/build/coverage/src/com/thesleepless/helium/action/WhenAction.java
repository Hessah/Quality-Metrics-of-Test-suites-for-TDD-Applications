/*
 * Created: Apr 10, 2005
 * File version: "$Id: WhenAction.java,v 1.3 2007/03/05 22:11:47 jaknowlden Exp $"
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
package com.thesleepless.helium.action;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

public class WhenAction extends AbstractAction {

  private static final String VarExists = "exists";
  private static final String VarEquals = "equals";

  public void service(Article article, HeliumContext context) throws HeliumException {
    String varName = checkRequiredArgument(article, "var");
    if (article.containsArgument(VarEquals)) {
      String equals = getArgumentValue(article, VarEquals);
      Object varValue = context.getDataMap().get(varName);
      if (varValue != null && varValue.toString().equals(equals))
        doBody(article, context);
    } else if (article.containsArgument(VarExists)) {
      boolean exists = Boolean.valueOf(getArgumentValue(article, VarExists)).booleanValue();
      Object varValue = context.getDataMap().get(varName);
      if (exists == (varValue != null && varValue.toString().length() > 0))
        doBody(article, context);
    }
  }

}
