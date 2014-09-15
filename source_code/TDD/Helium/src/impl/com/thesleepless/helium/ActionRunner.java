/*
 * Created: Mar 31, 2005
 * File version: "$Id: ActionRunner.java,v 1.2 2005/07/04 17:24:35 jaknowlden Exp $"
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

import com.thesleepless.helium.action.Action;
import com.thesleepless.helium.action.CommentAction;
import com.thesleepless.helium.action.LiteralAction;
import com.thesleepless.helium.action.TextAction;
import com.thesleepless.helium.action.XmlAction;

public class ActionRunner {
  private static final Action TextAction = new TextAction();
  private static final Action LiteralAction = new LiteralAction();
  private static final Action CommentAction = new CommentAction();
  private static final Action XmlAction = new XmlAction();

  public static void locateAndRun(Article article, HeliumContext context) throws HeliumException {
    findProperAction(article, context).service(article, context);
  }

  private static Action findProperAction(Article article, HeliumContext context) throws HeliumException {
    Action action = context.getActionRegister().find(article.getName());
    if (action != null)
      return action;
    else if (article.isTextArticle())
      return TextAction;
    else if (article.isLiteralArticle())
      return LiteralAction;
    else if (article.isCommentArticle())
      return CommentAction;
    return XmlAction;
  }
}
