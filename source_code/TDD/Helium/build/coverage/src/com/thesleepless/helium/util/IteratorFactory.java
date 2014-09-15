/*
 * Created: May 29, 2004
 * File version: $Id: IteratorFactory.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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
package com.thesleepless.helium.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.w3c.dom.NamedNodeMap;

/**
 * Generates an Iterator out of any Object type.
 * <LI> Collection's will return a normal Iterator per the Collection
 *   API.
 * <LI> Map's will return the Iterator for the key-set.
 * <LI> Non-null object instances will return an ObjectIterator.
 * <LI> Null object instances will return a NullIterator.
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class IteratorFactory {

  public static Iterator createArgumentIterator(NamedNodeMap arguments) {
    return new ArgumentIterator(arguments);
  }

  public static Iterator createIterator(Object obj) {
    if (obj != null) {
      if (Iterator.class.isAssignableFrom(obj.getClass()))
        return (Iterator) obj;
      else if (Collection.class.isAssignableFrom(obj.getClass()))
        return ((Collection) obj).iterator();
      else if (obj instanceof Object[])
        return Arrays.asList((Object[]) obj).iterator();
    }
    return new ObjectIterator(obj);
  }
}
