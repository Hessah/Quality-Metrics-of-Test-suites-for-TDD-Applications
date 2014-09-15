/*
 * Created: Oct 25, 2004
 * File version: $Id: ParameterAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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
 * @version "$Revision: 1.1 $"
 */
public class ParameterAction extends HttpServletAction {

  /**
   * @see com.thesleepless.helium.action.Action#service(com.thesleepless.helium.Article, com.thesleepless.helium.HeliumContext)
   */
  public void service(Article article, ServletHeliumContext context) throws HeliumException {
    writeObject(context.getRequest().getParameter(checkRequiredArgument(article, ArgName)), context);
  }

}