/*
 * Created: Mar 31, 2005
 * File version: "$Id: IoExceptionArticleSource.java,v 1.1 2005/05/03 23:34:42 jaknowlden Exp $"
 * 
 * Helium, description
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

import java.io.IOException;
import java.io.Reader;

public class IoExceptionArticleSource implements ArticleSource {

  public static final String Message = "Mock exception for testing purposes";

  public Reader getArticleReader(String articleName) throws IOException {
    throw new IOException(Message);
  }

}
