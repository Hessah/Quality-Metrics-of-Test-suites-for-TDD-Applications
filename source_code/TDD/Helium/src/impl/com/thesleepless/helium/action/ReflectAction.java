/*
 * Created: May 17, 2005
 * File version: "$Id: ReflectAction.java,v 1.8 2005/09/07 17:29:48 jaknowlden Exp $"
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
package com.thesleepless.helium.action;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

public class ReflectAction extends AbstractAction {

  private static final String ArgToVar = "toVar";
  private static final String ArgFromVar = "fromVar";
  private static final String ArgValue = "value";
  private static final String ArgField = "field";
  private static final String ArgVar = "var";

  public void service(Article article, HeliumContext context) throws HeliumException {
    String varName = checkRequiredArgument(article, ArgVar);
    String propertyName = checkRequiredArgument(article, ArgField);
    Object bean = checkBean(article, context, varName);

    try {
      if (article.containsArgument(ArgFromVar))
        ReflectionHelper.writeToBean(propertyName, bean, context.getDataMap().get(
            getArgumentValue(article, ArgFromVar)));
      else if (article.hasChildren())
        ReflectionHelper.writeToBean(propertyName, bean, getBody(article, context));
      else if (article.containsArgument(ArgValue))
        ReflectionHelper.writeToBean(propertyName, bean, getArgumentValue(article, ArgValue));
      else
        processGetter(article, context, propertyName, bean);
    } catch (InvocationTargetException e) {
      ReflectionHelper.throwFieldException(article, propertyName, bean, e.getCause());
    } catch (IntrospectionException e) {
      ReflectionHelper.throwFieldNotFoundException(article, propertyName, bean);
    } catch (Exception e) {
      ReflectionHelper.throwFieldException(article, propertyName, bean, e);
    }
  }

  private void processGetter(Article article, HeliumContext context, String propertyName,
      Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
    Object o = ReflectionHelper.readFromBean(propertyName, bean);
    if (article.containsArgument(ArgToVar))
      context.getDataMap().put(getArgumentValue(article, ArgToVar), o);
    else
      context.getWriter().print(o);
  }

  private Object checkBean(Article article, HeliumContext context, String varName)
      throws HeliumException {
    Object bean = context.getDataMap().get(varName);
    if (bean == null)
      throw new HeliumException("Variable [" + varName + "] not defined in DataMap for Action ["
          + article.getName() + "]");
    return bean;
  }
}
