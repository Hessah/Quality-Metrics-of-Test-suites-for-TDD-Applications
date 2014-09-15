/*
 * Created: Jul 15, 2004
 * File version: $Id: NullArticle.java,v 1.1 2005/05/03 23:34:39 jaknowlden Exp $
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
public class NullArticle implements Article {

  /**
   * @see com.thesleepless.helium.Article#getName()
   */
  public String getName() {
    return null;
  }

  /**
   * @see com.thesleepless.helium.Article#isTextArticle()
   */
  public boolean isTextArticle() {
    return false;
  }

  public boolean isLiteralArticle() {
    return false;
  }

  public boolean isCommentArticle() {
    return false;
  }

  /**
   * @see com.thesleepless.helium.Article#hasChildren()
   */
  public boolean hasChildren() {
    return false;
  }

  /**
   * @see com.thesleepless.helium.Article#getFirstChildArticle()
   */
  public Article getFirstChildArticle() {
    return null;
  }

  /**
   * @see com.thesleepless.helium.Article#getNextArticle()
   */
  public Article getNextArticle() {
    return this;
  }

  /**
   * @see com.thesleepless.helium.Article#getText()
   */
  public String getText() {
    return null;
  }

  /**
   * @see com.thesleepless.helium.Article#containsArgument(java.lang.String)
   */
  public boolean containsArgument(String name) {
    return false;
  }

  /**
   * @see com.thesleepless.helium.Article#getArgument(java.lang.String)
   */
  public Argument getArgument(String name) {
    return null;
  }

  /**
   * @see com.thesleepless.helium.Article#getArguments()
   */
  public Iterator getArguments() {
    return null;
  }

  public void parse(HeliumContext context) throws HeliumException {
  }

  
}
