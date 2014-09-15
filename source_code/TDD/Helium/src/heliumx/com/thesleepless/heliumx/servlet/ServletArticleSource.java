/*
 * Created: Oct 24, 2004
 * File version: $Id: ServletArticleSource.java,v 1.1 2005/05/03 23:34:44 jaknowlden Exp $
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
package com.thesleepless.heliumx.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletContext;

import com.thesleepless.helium.ArticleNotFoundException;
import com.thesleepless.helium.ArticleSource;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
class ServletArticleSource implements ArticleSource {

  private ServletContext servletContext;

  public ServletArticleSource(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  /**
   * @see com.thesleepless.helium.ArticleSource#getArticleReader(java.lang.String)
   */
  public Reader getArticleReader(String articleName) throws IOException, ArticleNotFoundException {
    InputStream stream = servletContext.getResourceAsStream(articleName);
    if (stream == null)
      throw new ArticleNotFoundException(articleName);
    return new InputStreamReader(stream);
  }

}
