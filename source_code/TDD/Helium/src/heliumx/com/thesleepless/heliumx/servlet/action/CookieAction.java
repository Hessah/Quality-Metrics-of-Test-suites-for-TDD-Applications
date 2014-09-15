/*
 * Created: Nov 3, 2004
 * File version: $Id: CookieAction.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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
package com.thesleepless.heliumx.servlet.action;

import javax.servlet.http.Cookie;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.heliumx.servlet.ServletHeliumContext;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class CookieAction extends HttpServletAction {

  private static final String ArgSecure = "secure";
  private static final String ArgMaxAge = "maxAge";
  private static final String ArgPath = "path";
  private static final String ArgDomain = "domain";
  private static final String ArgValue = "value";

  /**
   * @see com.thesleepless.heliumx.servlet.action.HttpServletAction#service(com.thesleepless.helium.Article, com.thesleepless.heliumx.servlet.ServletHeliumContext)
   */
  protected void service(Article article, ServletHeliumContext context) throws HeliumException {
    String nameArg = checkRequiredArgument(article, ArgName);
    if (article.containsArgument(ArgValue))
      context.getResponse().addCookie(generateCookie(article, nameArg));
    else {
      Cookie cookie = findCookie(context, nameArg);
      if (cookie != null)
        context.getWriter().write(cookie.getValue());
    }
  }

  private Cookie generateCookie(Article article, String nameArg) throws HeliumException {
    Cookie cookie = new Cookie(nameArg, getArgumentValue(article, ArgValue));
    if (article.containsArgument(ArgDomain))
      cookie.setDomain(getArgumentValue(article, ArgDomain));
    if (article.containsArgument(ArgPath))
      cookie.setPath(getArgumentValue(article, ArgPath));
    if (article.containsArgument(ArgMaxAge))
      cookie.setMaxAge(getMaxAge(article));
    if (article.containsArgument(ArgSecure))
      cookie.setSecure(new Boolean(getArgumentValue(article, ArgSecure)).booleanValue());
    return cookie;
  }

  private int getMaxAge(Article article) throws HeliumException {
    try {
      return new Integer(getArgumentValue(article, ArgMaxAge)).intValue();
    } catch (NumberFormatException e) {
      throw new HeliumException("Value [" + getArgumentValue(article, ArgMaxAge)
          + "] for argument [" + ArgMaxAge + "] of the Action [" + article.getName()
          + "] is not valid", e);
    }
  }

  private Cookie findCookie(ServletHeliumContext context, String nameArg) {
    Cookie[] cookies = context.getRequest().getCookies();
    for (int i = 0; cookies != null && i < cookies.length; i++) {
      Cookie cookie = cookies[i];
      if (cookie.getName().equals(nameArg))
        return cookie;
    }
    return null;
  }

}