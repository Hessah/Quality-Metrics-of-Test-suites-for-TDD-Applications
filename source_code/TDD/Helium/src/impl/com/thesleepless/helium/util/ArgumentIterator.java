/*
 * Created: Jul 12, 2004
 * File version: $Id: ArgumentIterator.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $
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

import org.w3c.dom.NamedNodeMap;

import com.thesleepless.helium.HeliumFactory;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class ArgumentIterator extends AbstractIterator {

  private NamedNodeMap arguments;
  private int position;

  public ArgumentIterator(NamedNodeMap arguments) {
    this.arguments = arguments;
    position = 0;
  }

  /**
   * @see java.util.Iterator#hasNext()
   */
  public boolean hasNext() {
    return position < arguments.getLength();
  }

  /**
   * @see java.util.Iterator#next()
   */
  public Object next() {
    return HeliumFactory.newArgument(arguments.item(position++));
  }

}
