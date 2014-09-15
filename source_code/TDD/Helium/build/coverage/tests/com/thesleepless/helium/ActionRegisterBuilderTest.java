/*
 * Created: Apr 10, 2005
 * File version: "$Id: ActionRegisterBuilderTest.java,v 1.5 2005/07/04 17:24:35 jaknowlden Exp $"
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
package com.thesleepless.helium;

import junit.framework.TestCase;

import com.thesleepless.helium.action.ActionAction;
import com.thesleepless.helium.action.ArticleAction;
import com.thesleepless.helium.action.IncludeAction;
import com.thesleepless.helium.action.IterateAction;
import com.thesleepless.helium.action.ListAction;
import com.thesleepless.helium.action.OkAction;
import com.thesleepless.helium.action.VarAction;
import com.thesleepless.helium.action.WhenAction;
import com.thesleepless.helium.mock.ResourceHelper;

public class ActionRegisterBuilderTest extends TestCase {
  private ResourceHelper resourceHelper;

  protected void setUp() throws Exception {
    super.setUp();
    System.setProperty(ActionRegisterBuilder.ActionSystemProperty,
        ActionRegisterBuilder.DefaultProperties);
    resourceHelper = new ResourceHelper();
  }

  protected void tearDown() throws Exception {
    System.setProperty(ActionRegisterBuilder.ActionSystemProperty,
        ActionRegisterBuilder.DefaultProperties);
    resourceHelper.cleanupFiles();
    super.tearDown();
  }

  public void testDefault() throws Exception {
    ActionRegister register = new ActionRegisterBuilder().build();
    assertEquals(ArticleAction.class, register.find("article").getClass());
    assertEquals(VarAction.class, register.find("var").getClass());
    assertEquals(ListAction.class, register.find("list").getClass());
    assertEquals(WhenAction.class, register.find("when").getClass());
    assertEquals(IncludeAction.class, register.find("include").getClass());
    assertEquals(IterateAction.class, register.find("iterate").getClass());
    assertEquals(ActionAction.class, register.find("action").getClass());
  }

  public void testOverride() throws Exception {
    System.setProperty("helium.action", "/test-core.properties");
    resourceHelper.writeResource("test-core.properties",
        "ok=com.thesleepless.helium.action.OkAction");
    ActionRegister register = new ActionRegisterBuilder().build();
    assertNull(register.find("var"));
    assertNull(register.find("list"));
    assertNull(register.find("when"));
    assertNull(register.find("include"));
    assertNull(register.find("iterate"));
    assertNull(register.find("action"));
    assertEquals(OkAction.class, register.find("ok").getClass());
  }

  public void testClassNotFound() throws Exception {
    System.setProperty("helium.action", "/bad-core.properties");
    resourceHelper.writeResource("bad-core.properties", "myAction=a.bad.Action");
    try {
      new ActionRegisterBuilder().build();
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Action Class [a.bad.Action] could not be found", e.getMessage());
    }
  }

  public void testOverrideFileNotFound() throws Exception {
    System.setProperty("helium.action", "/bad-file.properties");
    try {
      new ActionRegisterBuilder().build();
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("File [" + System.getProperty("helium.action") + "] not found", e.getMessage());
    }
  }
}
