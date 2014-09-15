/*
 * Created: Aug 18, 2005
 * File version: "$Id: ResponseAction.java,v 1.1 2005/08/23 19:26:56 jaknowlden Exp $"
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
package com.thesleepless.heliumx.servlet.action;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.action.ReflectionHelper;
import com.thesleepless.heliumx.servlet.ServletHeliumContext;

public class ResponseAction extends HttpServletAction {

  private static final String ArgValue = "value";
  private static final String ArgField = "field";

  protected void service(Article article, ServletHeliumContext context) throws HeliumException {
    String propertyName = checkRequiredArgument(article, ArgField);
    String value = checkRequiredArgument(article, ArgValue);
    Object bean = context.getResponse();
    try {
      ReflectionHelper.writeToBean(propertyName, bean, value);
    } catch (InvocationTargetException e) {
      ReflectionHelper.throwFieldException(article, propertyName, bean, e.getCause());
    } catch (IntrospectionException e) {
      ReflectionHelper.throwFieldNotFoundException(article, propertyName, bean);
    } catch (Exception e) {
      ReflectionHelper.throwFieldException(article, propertyName, bean, e);
    }
  }

}
