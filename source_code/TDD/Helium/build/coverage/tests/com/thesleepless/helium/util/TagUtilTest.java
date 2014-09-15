/*
 * Created: Apr 1, 2005
 * File version: "$Id: TagUtilTest.java,v 1.1 2005/05/03 23:34:45 jaknowlden Exp $"
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

import com.thesleepless.helium.HeliumTestFixture;

public class TagUtilTest extends HeliumTestFixture {

  public void testNothingToReplace() throws Exception {
    assertEquals("a", TagUtil.replaceVariables(null, "a"));
    assertEquals("abcde", TagUtil.replaceVariables(null, "abcde"));
  }

  public void testReplaceNonExistingVar() throws Exception {
    assertEquals("null", TagUtil.replaceVariables(getContext(), "#{a}"));
    assertEquals("[null]", TagUtil.replaceVariables(getContext(), "[#{abcd}]"));
  }

  public void testReplaceWithVar() throws Exception {
    getContext().getDataMap().put("a", "1");
    getContext().getDataMap().put("ab#{c", "literal #{ value");
    assertEquals("[1]", TagUtil.replaceVariables(getContext(), "[#{a}]"));
    assertEquals("[literal #{ valued}]", TagUtil.replaceVariables(getContext(), "[#{ab#{c}d}]"));
  }

  public void testReplaceWithVarMultipleTimes() throws Exception {
    getContext().getDataMap().put("a", "1");
    getContext().getDataMap().put("ab", "2");
    getContext().getDataMap().put("abc", "3");
    assertEquals("[1][2][3]", TagUtil.replaceVariables(getContext(), "[#{a}][#{ab}][#{abc}]"));
  }

  public void testFalseAlarm() throws Exception {
    assertEquals("[#{blah]", TagUtil.replaceVariables(null, "[#{blah]"));
  }
}
