/*
 * Created: Apr 5, 2005
 * File version: "$Id: CommentAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $"
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

public class CommentAction extends AbstractAction {

  private static final String CommentOpen = "<!--";
  private static final String CommentClose = "-->";

  public void service(Article article, HeliumContext context) throws HeliumException {
    context.getWriter().write(CommentOpen);
    context.getWriter().write(article.getText());
    context.getWriter().write(CommentClose);
  }

}
