/*
 * Created: Sep 20, 2004
 * File version: $Id: IterateAction.java,v 1.2 2005/06/11 21:27:37 jaknowlden Exp $
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

import java.util.Iterator;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.util.IteratorFactory;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class IterateAction extends AbstractAction {

  private static final String ArgVar = "var";
  private static final String ArgItemVar = "itemVar";

  /**
   * @see com.thesleepless.helium.action.Action#service(com.thesleepless.helium.Article, com.thesleepless.helium.HeliumContext)
   */
  public void service(Article article, HeliumContext context) throws HeliumException {
    String valueOf = checkRequiredArgument(article, ArgVar);
    String elementVarName = checkRequiredArgument(article, ArgItemVar);
    if (context.getDataMap().containsKey(valueOf)) {
      Iterator iter = IteratorFactory.createIterator(context.getDataMap().get(valueOf));
      while (iter.hasNext()) {
        context.getDataMap().put(elementVarName, iter.next());
        doBody(article, context);
        context.getDataMap().remove(elementVarName);
      }
    }
  }

}
