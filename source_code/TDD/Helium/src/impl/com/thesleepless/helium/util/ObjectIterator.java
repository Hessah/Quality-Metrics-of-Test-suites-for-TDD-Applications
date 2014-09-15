/*
 * Created: Sep 20, 2004
 * File version: $Id: ObjectIterator.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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

import java.util.NoSuchElementException;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class ObjectIterator extends AbstractIterator {

  private Object obj;

  /**
   * Constructor for ObjectIterator.
   */
  public ObjectIterator(Object iterateObject) {
    super();
    obj = iterateObject;
  }

  /**
   * @see java.util.Iterator#hasNext()
   */
  public boolean hasNext() {
    return obj != null;
  }

  /**
   * @see java.util.Iterator#next()
   */
  public Object next() {
    if (obj == null)
      throw new NoSuchElementException();
    Object tmpObj = obj;
    obj = null;
    return tmpObj;
  }

}
