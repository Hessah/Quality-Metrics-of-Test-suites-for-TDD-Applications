/*
 * Created: Jul 12, 2004
 * File version: $Id: XmlAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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

import java.io.PrintWriter;
import java.util.Iterator;

import com.thesleepless.helium.Argument;
import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class XmlAction extends AbstractAction {

  private static final char XmlOpen = '<';
  private static final String XmlEndOpen = "</";
  private static final char XmlClose = '>';
  private static final String XmlEmptyClose = "/>";

  private static final char SpaceChar = ' ';
  private static final String EqualsAndQuote = "=\"";
  private static final char QuoteChar = '"';

  /**
   * @see com.thesleepless.helium.action.Action#service(com.thesleepless.helium.Article, java.io.Writer)
   */
  public void service(Article article, HeliumContext context) throws HeliumException {
    PrintWriter writer = context.getWriter();
    writer.write(XmlOpen);
    writer.write(article.getName());
    echoArguments(article, writer);
    if (article.hasChildren()) {
      writer.write(XmlClose);
      doBody(article, context);
      writer.write(XmlEndOpen);
      writer.write(article.getName());
      writer.write(XmlClose);
    } else
      writer.write(XmlEmptyClose);
  }

  private static void echoArguments(Article article, PrintWriter writer) {
    for (Iterator iter = article.getArguments(); iter.hasNext();) {
      Argument arg = (Argument) iter.next();
      writer.write(SpaceChar);
      writer.write(arg.getName());
      writer.write(EqualsAndQuote);
      writer.write(arg.getValue());
      writer.write(QuoteChar);
    }
  }

}