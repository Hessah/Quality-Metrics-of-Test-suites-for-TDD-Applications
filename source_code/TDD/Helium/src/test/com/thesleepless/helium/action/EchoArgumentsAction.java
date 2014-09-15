/*
 * Created: Apr 1, 2005
 * File version: "$Id: EchoArgumentsAction.java,v 1.1 2005/05/03 23:34:39 jaknowlden Exp $"
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

import java.util.Iterator;

import com.thesleepless.helium.Argument;
import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

public class EchoArgumentsAction implements Action {

  public void service(Article article, HeliumContext context) throws HeliumException {
    for (Iterator iter = article.getArguments(); iter.hasNext();) {
      Argument arg = (Argument) iter.next();
      context.getWriter().write("{" + arg.getName() + "=" + arg.getValue() + "}");
    } 
    
  }

}
