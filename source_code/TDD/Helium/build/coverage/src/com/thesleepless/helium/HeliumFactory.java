/*
 * Created: Jul 11, 2004
 * File version: $Id: HeliumFactory.java,v 1.2 2005/06/25 16:35:37 jaknowlden Exp $
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
package com.thesleepless.helium;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.w3c.dom.Node;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class HeliumFactory {

  public static Article newArticle(Node node) {
    if (node == null)
      return new NullArticle();
    return new DefaultArticle(node);
  }

  public static Argument newArgument(Node node) {
    return new DefaultArgument(node);
  }

  public static ActionRegister newActionRegister() throws HeliumException, IOException {
    return new ActionRegisterBuilder().build();
  }

  public static HeliumContext newHeliumContext() throws HeliumException, IOException {
    HeliumContext context = new DefaultHeliumContext();
    context.setWriter(new PrintWriter(new NullWriter()));
    context.setDataMap(new HashMap());
    context.setActionRegister(newActionRegister());
    context.setArticleSource(new NullArticleSource());
    return context;
  }
}
