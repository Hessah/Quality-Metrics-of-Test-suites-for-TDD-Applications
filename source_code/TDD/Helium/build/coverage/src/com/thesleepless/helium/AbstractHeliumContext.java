/*
 * Created: Apr 1, 2005
 * File version: "$Id: AbstractHeliumContext.java,v 1.1 2005/05/03 23:34:39 jaknowlden Exp $"
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

import java.io.PrintWriter;
import java.util.Map;

public abstract class AbstractHeliumContext implements HeliumContext {

  private PrintWriter writer;
  private Map dataMap;
  private ActionRegister actionRegister;
  private ArticleSource articleSource;

  /**
   * @see com.thesleepless.helium.HeliumContext#getWriter()
   */
  public PrintWriter getWriter() {
    return writer;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#setWriter(java.io.Writer)
   */
  public void setWriter(PrintWriter newWriter) {
    writer = newWriter;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#getDataMap()
   */
  public Map getDataMap() {
    return dataMap;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#setDataMap(java.util.Map)
   */
  public void setDataMap(Map newDataMap) {
    dataMap = newDataMap;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#getActionRegister()
   */
  public ActionRegister getActionRegister() {
    return actionRegister;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#setActionRegister(com.thesleepless.helium.ActionRegister)
   */
  public void setActionRegister(ActionRegister newActionRegister) {
    actionRegister = newActionRegister;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#getArticleSource()
   */
  public ArticleSource getArticleSource() {
    return articleSource;
  }

  /**
   * @see com.thesleepless.helium.HeliumContext#setArticleSource(com.thesleepless.helium.ArticleSource)
   */
  public void setArticleSource(ArticleSource newArticleSource) {
    articleSource = newArticleSource;
  }

}
