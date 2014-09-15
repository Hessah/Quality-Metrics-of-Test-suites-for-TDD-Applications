/*
 * Created: Jun 25, 2005
 * File version: "$Id: UrlEncodeAction.java,v 1.1 2005/06/26 00:04:23 jaknowlden Exp $"
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
package com.thesleepless.heliumx.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.action.AbstractAction;

public class UrlEncodeAction extends AbstractAction {

  private static final String ArgCharset = "charset";
  private static final String ArgFromVar = "fromVar";
  private static final String Utf8 = "UTF-8";
  private static final String ArgValue = "value";

  public void service(Article article, HeliumContext context) throws HeliumException {
    try {
      context.getWriter().print(URLEncoder.encode(getTextToEncode(article, context), getEncoding(article)));
    } catch (UnsupportedEncodingException e) {
      throw new HeliumException(e);
    }
  }

  private String getTextToEncode(Article article, HeliumContext context) throws HeliumException {
    if (article.containsArgument(ArgFromVar))
      return fromVarToString(article, context);
    else if (article.hasChildren())
      return getBody(article, context);
    return checkRequiredArgument(article, ArgValue);
  }

  private String fromVarToString(Article article, HeliumContext context) throws HeliumException {
    String fromVarName = getArgumentValue(article, ArgFromVar);
    Object fromVarObj = context.getDataMap().get(fromVarName);
    if (fromVarObj == null)
      throw new HeliumException("Var [" + fromVarName + "] not defined for Action ["
          + article.getName() + "]");
    return fromVarObj.toString();
  }

  private String getEncoding(Article article) throws HeliumException {
    if (article.containsArgument(ArgCharset))
      return getArgumentValue(article, ArgCharset);
    return Utf8;
  }

}
