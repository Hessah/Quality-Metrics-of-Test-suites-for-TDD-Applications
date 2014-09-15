/*
 * Created: Apr 10, 2005
 * File version: "$Id: FakeArticle.java,v 1.1 2005/06/23 14:53:27 jaknowlden Exp $"
 * 
 * Helium, Dynamic content replacement
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

import java.util.Iterator;
import java.util.Map;

public class FakeArticle implements Article {

  public static FakeArticle newArticle(String name) {
    FakeArticle article = new FakeArticle();
    article.setName(name);
    return article;
  }

  public static FakeArticle newArticle(String name, Map arguments) {
    FakeArticle article = newArticle(name);
    article.setArguments(arguments);
    return article;
  }

  private String name;
  private Map arguments;

  public String getName() {
    return name;
  }

  private void setName(String newName) {
    name = newName;
  }

  public boolean isTextArticle() {
    return false;
  }

  public boolean isLiteralArticle() {
    return false;
  }

  public boolean isCommentArticle() {
    return false;
  }

  public boolean hasChildren() {
    return false;
  }

  public Article getFirstChildArticle() {
    return null;
  }

  public Article getNextArticle() {
    return null;
  }

  public String getText() {
    return null;
  }

  public boolean containsArgument(String name) {
    return false;
  }

  public Argument getArgument(String name) {
    return (Argument) arguments.get(name);
  }

  public Iterator getArguments() {
    return arguments.values().iterator();
  }

  private void setArguments(Map arguments) {
    this.arguments = arguments;
  }

  public void parse(HeliumContext context) throws HeliumException {
  }

}
