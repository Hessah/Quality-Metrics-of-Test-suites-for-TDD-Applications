/*
 * Created: Jun 26, 2005
 * File version: "$Id: ReflectionHelper.java,v 1.2 2005/08/23 19:26:56 jaknowlden Exp $"
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
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumException;

public class ReflectionHelper {

  public static Object readFromBean(String propertyName, Object bean)
      throws IntrospectionException, IllegalAccessException, InvocationTargetException {
    try {
      return newPropertyDescriptor(propertyName, bean, appendPrefix(propertyName, "is"), null)
          .getReadMethod().invoke(bean, null);
    } catch (IntrospectionException e) {
      return newPropertyDescriptor(propertyName, bean, appendPrefix(propertyName, "get"), null)
          .getReadMethod().invoke(bean, null);
    }
  }

  public static void writeToBean(String propertyName, Object bean, Object obj)
      throws IntrospectionException, IllegalAccessException, InvocationTargetException {
    Method write = newPropertyDescriptor(propertyName, bean, null,
        appendPrefix(propertyName, "set")).getWriteMethod();
    if (write.getParameterTypes()[0] == int.class)
      write.invoke(bean, new Object[]{Integer.valueOf(obj.toString())});
    else
      write.invoke(bean, new Object[]{obj});
  }

  private static PropertyDescriptor newPropertyDescriptor(String propertyName, Object bean,
      String getter, String setter) throws IntrospectionException {
    return new PropertyDescriptor(propertyName, bean.getClass(), getter, setter);
  }

  private static String appendPrefix(String propertyName, String prefix) {
    return new StringBuffer().append(prefix).append(capitalize(propertyName)).toString();
  }

  private static String capitalize(String propertyName) {
    char[] chars = propertyName.toCharArray();
    chars[0] = Character.toUpperCase(chars[0]);
    return new String(chars);
  }

  public static void throwFieldNotFoundException(Article article, String propertyName, Object bean)
      throws HeliumException {
    throwFieldException(article, propertyName, bean, new FieldNotFoundException(propertyName));
  }

  public static void throwFieldException(Article article, String propertyName, Object bean,
      Throwable e) throws HeliumException {
    throw new HeliumException("Field [" + propertyName + "] from Class [" + bean.getClass()
        + "] for Action [" + article.getName() + "] threw Exception [" + e.toString() + "]");
  }
}
