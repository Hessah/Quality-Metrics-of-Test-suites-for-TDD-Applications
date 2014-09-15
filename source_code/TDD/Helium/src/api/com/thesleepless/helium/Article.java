/*
 * Created: Jul 12, 2004
 * File version: $Id: Article.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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

import java.util.Iterator;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public interface Article {

  public String getName();

  public boolean isTextArticle();

  public boolean isLiteralArticle();

  public boolean isCommentArticle();

  public boolean hasChildren();

  public Article getFirstChildArticle();

  public Article getNextArticle();

  public String getText();

  public boolean containsArgument(String name);

  public Argument getArgument(String name);

  public Iterator getArguments();

  public void parse(HeliumContext context) throws HeliumException;
}
