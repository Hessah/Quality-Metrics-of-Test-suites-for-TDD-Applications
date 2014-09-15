/*
 * Created: Apr 1, 2005
 * File version: "$Id: TagUtil.java,v 1.1 2005/05/03 23:34:41 jaknowlden Exp $"
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
package com.thesleepless.helium.util;

import com.thesleepless.helium.HeliumContext;

public class TagUtil {
  private static final String TagBegin = "#{";
  private static final int TagBeginLength = TagBegin.length();
  private static final String TagEnd = "}";
  private static final int TagEndLength = TagEnd.length();

  public static String replaceVariables(HeliumContext context, String in) {
    StringBuffer buf = new StringBuffer(in);
    int from = 0;
    while ((from = buf.indexOf(TagBegin, from)) > -1) {
      int to = buf.indexOf(TagEnd, from);
      int jumpTo = TagBeginLength;
      if (to > -1) {
        String name = buf.substring(from + TagBeginLength, to);
        String value = String.valueOf(context.getDataMap().get(name));
        buf.replace(from, to + TagEndLength, value);
        jumpTo = value.length();
      }
      from += jumpTo;
    }
    return buf.toString();
  }
}
