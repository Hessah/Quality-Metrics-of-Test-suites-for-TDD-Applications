/*
 * Created: Jul 9, 2004
 * File version: $Id: ArticleBuilder.java,v 1.1 2005/05/03 23:34:39 jaknowlden Exp $
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
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class ArticleBuilder {

  public static Article locateAndBuild(String articleName, HeliumContext context)
      throws HeliumException {
    try {
      return ArticleBuilder.build(context.getArticleSource().getArticleReader(articleName));
    } catch (IOException e) {
      throw new HeliumException(e);
    }
  }

  public static Article build(Reader reader) throws HeliumException {
    if (reader == null)
      throw new NullPointerException("Article reader not defined");
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      builder.setErrorHandler(null);
      Document document = builder.parse(new InputSource(reader));
      return HeliumFactory.newArticle(document.getFirstChild());
    } catch (Exception e) {
      throw new HeliumException(e);
    }
  }
}
