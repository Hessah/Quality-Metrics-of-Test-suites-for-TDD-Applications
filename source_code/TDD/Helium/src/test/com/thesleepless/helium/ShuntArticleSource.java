/*
 * Created: Jul 15, 2004
 * File version: $Id: ShuntArticleSource.java,v 1.1 2005/06/23 14:53:27 jaknowlden Exp $
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
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class ShuntArticleSource implements ArticleSource {

  private Map articles;

  /**
   * Constructor for MockArticleSource.
   */
  public ShuntArticleSource() {
    super();
    articles = new HashMap(16);
  }

  public void addArticleContents(String articleName, String articleContents) {
    articles.put(articleName, articleContents);
  }

  /**
   * @see com.thesleepless.helium.ArticleSource#getArticleReader(java.lang.String)
   */
  public Reader getArticleReader(String articleName) throws IOException, ArticleNotFoundException{
    if (articles.containsKey(articleName))
      return new StringReader(articles.get(articleName).toString());
    throw new ArticleNotFoundException(articleName);
  }

}
