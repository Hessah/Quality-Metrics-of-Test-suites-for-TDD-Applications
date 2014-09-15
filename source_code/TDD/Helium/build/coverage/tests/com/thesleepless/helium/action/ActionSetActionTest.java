/*
 * Created: Jun 21, 2005
 * File version: "$Id: ActionSetActionTest.java,v 1.5 2005/07/04 17:24:28 jaknowlden Exp $"
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
import com.thesleepless.helium.mock.ResourceHelper;

public class ActionSetActionTest extends HeliumTestFixture {

  private ResourceHelper resourceHelper;

  protected void setUp() throws Exception {
    super.setUp();
    resourceHelper = new ResourceHelper();
  }

  protected void tearDown() throws Exception {
    resourceHelper.cleanupFiles();
    super.tearDown();
  }

  public void testAction() throws Exception {
    String contents = "foo=" + OkAction.class.getName() + "\nbar=" + BlahAction.class.getName();
    resourceHelper.writeResource("actionset-a.has", contents);
    buildArticle("<actionset prefix=\"a\" definition=\"/actionset-a.has\"/>").parse(getContext());
    assertEquals(OkAction.class, getContext().getActionRegister().find(
        "a:foo").getClass());
    assertEquals(BlahAction.class, getContext().getActionRegister().find(
        "a:bar").getClass());
  }

  public void testMissingArguments() throws Exception {
    assertArgumentMissing("<actionset prefix=\"blah\"/>", "definition", "actionset");
  }

  public void testDefinitionFileNotFound() throws Exception {
    try {
      buildArticle("<actionset prefix=\"a\" definition=\"no-file.has\"/>").parse(getContext());
      fail("Should have thrown Exception");
    } catch (HeliumException e) {
      assertEquals("Action Set definition file [no-file.has] not found", e.getMessage());
    }
  }

  public void testPrefixIsBlank() throws Exception {
    String contents = "foo=" + OkAction.class.getName() + "\nbar=" + BlahAction.class.getName();
    resourceHelper.writeResource("actionset-a.has", contents);
    buildArticle("<actionset prefix=\"\" definition=\"/actionset-a.has\"/>").parse(getContext());
    assertEquals(OkAction.class, getContext().getActionRegister().find(
        "foo").getClass());
    assertEquals(BlahAction.class, getContext().getActionRegister().find(
        "bar").getClass());
  }

  public void testPrefixIsMissing() throws Exception {
    String contents = "foo=" + OkAction.class.getName() + "\nbar=" + BlahAction.class.getName();
    resourceHelper.writeResource("actionset-a.has", contents);
    buildArticle("<actionset definition=\"/actionset-a.has\"/>").parse(getContext());
    assertEquals(OkAction.class, getContext().getActionRegister().find(
        "foo").getClass());
    assertEquals(BlahAction.class, getContext().getActionRegister().find(
        "bar").getClass());
  }

}
