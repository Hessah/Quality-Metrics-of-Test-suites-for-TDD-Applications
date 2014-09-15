/*
 * Created: May 26, 2005
 * File version: "$Id: ConstructActionTest.java,v 1.1 2005/05/27 03:37:30 jaknowlden Exp $"
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

import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumTestFixture;

public class ConstructActionTest extends HeliumTestFixture {

  public void testConstruct() throws Exception {
    buildArticle("<construct class=\"java.lang.Object\" toVar=\"foo\"/>").parse(getContext());
    assertEquals(Object.class, getContext().getDataMap().get("foo").getClass());

    buildArticle("<construct class=\"java.lang.String\" toVar=\"bar\"/>").parse(getContext());
    assertEquals(String.class, getContext().getDataMap().get("bar").getClass());
  }

  public void testMissingArguments() throws Exception {
    assertArgumentMissing("<construct toVar=\"foo\"/>", "class", "construct");
    assertArgumentMissing("<construct class=\"foo\"/>", "toVar", "construct");
  }

  public void testClassNotFound() throws Exception {
    try {
      buildArticle("<construct class=\"class.not.Found\" toVar=\"foo\"/>").parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Class [class.not.Found] not found for Action [construct]", e.getMessage());
    }
  }

  public void testCouldNotBeConstructed() throws Exception {
    assertCouldNotBeConstructed(InstantiationExceptionBean.class);
    assertCouldNotBeConstructed(IllegalAccessBean.class);
    assertCouldNotBeConstructed(MultiArgConstructorBean.class);
  }

  private void assertCouldNotBeConstructed(Class clazz) {
    try {
      buildArticle("<construct class=\"" + clazz.getName() + "\" toVar=\"foo\"/>").parse(
          getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Class [" + clazz.getName()
          + "] for Action [construct] could not be constructed", e.getMessage());
    }
  }
}
