/*
 * Created: Jul 15, 2004
 * File version: $Id: IteratorFactoryTest.java,v 1.1 2005/05/03 23:34:45 jaknowlden Exp $
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
public class IteratorFactoryTest extends TestCase {

  private void assertNext(Iterator iterator, boolean hasNext, Object next) {
    assertEquals(hasNext, iterator.hasNext());
    if (hasNext)
      assertEquals(next, iterator.next());
    else
      try {
        iterator.next();
        fail("Should have failed");
      } catch (NoSuchElementException e) {
        assertNotNull(e);
      }
  }

  private void assertRemove(Iterator actual, Class expectedClass) {
    try {
      actual.remove();
      fail("Should have failed");
    } catch (UnsupportedOperationException e) {
      assertEquals(expectedClass.getName() + ": remove()", e.getMessage());
    }
  }

  public void testNullIterator() throws Exception {
    Iterator iterator = IteratorFactory.createIterator(null);
    assertEquals(ObjectIterator.class, iterator.getClass());

    assertNext(iterator, false, null);

    assertRemove(iterator, ObjectIterator.class);
  }

  public void testObjectIterator() throws Exception {
    Object tmpObj = new Object();
    Iterator iterator = IteratorFactory.createIterator(tmpObj);
    assertEquals(ObjectIterator.class, iterator.getClass());

    assertNext(iterator, true, tmpObj);
    assertNext(iterator, false, null);
    assertNext(iterator, false, null);

    assertRemove(iterator, ObjectIterator.class);
  }

  public void testStringIterator() throws Exception {
    String tmpObj = new String("hello");
    Iterator iterator = IteratorFactory.createIterator(tmpObj);
    assertEquals(ObjectIterator.class, iterator.getClass());

    assertNext(iterator, true, tmpObj);
    assertNext(iterator, false, null);
    assertNext(iterator, false, null);

    assertRemove(iterator, ObjectIterator.class);
  }

  public void testCollectionIterator() throws Exception {
    Collection tmpObj = new ArrayList(5);
    tmpObj.add("a");
    tmpObj.add("b");
    tmpObj.add("c");
    tmpObj.add("d");
    tmpObj.add("e");

    Iterator iterator = IteratorFactory.createIterator(tmpObj);
    assertEquals(tmpObj.iterator().getClass(), iterator.getClass());

    assertNext(iterator, true, "a");
    assertNext(iterator, true, "b");
    assertNext(iterator, true, "c");
    assertNext(iterator, true, "d");
    assertNext(iterator, true, "e");
    assertNext(iterator, false, null);
  }

  public void testIteratorIterator() throws Exception {
    Collection tmpObj = new ArrayList(5);
    tmpObj.add("a");
    tmpObj.add("b");
    tmpObj.add("c");
    tmpObj.add("d");
    tmpObj.add("e");

    Iterator iterator = IteratorFactory.createIterator(tmpObj.iterator());
    assertEquals(tmpObj.iterator().getClass(), iterator.getClass());

    assertNext(iterator, true, "a");
    assertNext(iterator, true, "b");
    assertNext(iterator, true, "c");
    assertNext(iterator, true, "d");
    assertNext(iterator, true, "e");
    assertNext(iterator, false, null);
  }

  public void testArrayIterator() throws Exception {
    String[] tmpObj = new String[] {"a", "b", "c", "d", "e"};

    Iterator iterator = IteratorFactory.createIterator(tmpObj);
    assertNotNull(iterator.getClass());

    assertNext(iterator, true, "a");
    assertNext(iterator, true, "b");
    assertNext(iterator, true, "c");
    assertNext(iterator, true, "d");
    assertNext(iterator, true, "e");
    assertNext(iterator, false, null);
  }

}
