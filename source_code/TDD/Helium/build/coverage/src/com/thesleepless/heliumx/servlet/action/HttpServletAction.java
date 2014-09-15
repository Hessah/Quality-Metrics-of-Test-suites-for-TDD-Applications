/*
 * Created: Oct 25, 2004
 * File version: $Id: HttpServletAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.action.AbstractAction;
import com.thesleepless.heliumx.servlet.ServletHeliumContext;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public abstract class HttpServletAction extends AbstractAction {

  /**
   * @see com.thesleepless.helium.action.Action#service(com.thesleepless.helium.Article, com.thesleepless.helium.HeliumContext)
   */
  public void service(Article article, HeliumContext context) throws HeliumException {
    service(article, (ServletHeliumContext) context);
  }

  protected abstract void service(Article article, ServletHeliumContext context)
      throws HeliumException;

  /**
   * Writes an Object instance using toString or nothing if the obj to write is null.
   * @param object The object to write to the writer
   * @param writer The Writer instance to write to
   * @throws HeliumException
   */
  protected void writeObject(Object objectToWrite, HeliumContext context) throws HeliumException {
    if (objectToWrite != null)
      context.getWriter().write(objectToWrite.toString());
  }

  protected static final String ArgName = "name";
}