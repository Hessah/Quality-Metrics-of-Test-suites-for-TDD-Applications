/*
 * Created: Apr 8, 2005
 * File version: "$Id: ListAction.java,v 1.2 2005/06/25 01:13:43 jaknowlden Exp $"
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

import java.util.ArrayList;
import java.util.List;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

public class ListAction extends AbstractAction {

  private static final String ArgValue = "value";
  private static final String ArgName = "name";

  public void service(Article article, HeliumContext context) throws HeliumException {
    String name = checkRequiredArgument(article, ArgName);
    List list = generateList(article, context, name);

    if (article.hasChildren())
      list.add(getBody(article, context));
    else if (article.containsArgument(ArgValue))
      list.add(article.getArgument(ArgValue).getValue());
    context.getDataMap().put(name, list);
  }

  private List generateList(Article article, HeliumContext context, String name)
      throws HeliumException {
    try {
      return (context.getDataMap().containsKey(name)) ? (List) context.getDataMap().get(name)
          : new ArrayList();
    } catch (ClassCastException e) {
      throw new HeliumException("Variable [" + name + "] not of expected type for Action ["
          + article.getName() + "]");
    }
  }

}
