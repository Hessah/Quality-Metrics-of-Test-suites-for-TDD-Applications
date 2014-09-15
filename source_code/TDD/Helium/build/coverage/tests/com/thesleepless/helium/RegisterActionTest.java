/*
 * Created: Jul 15, 2004
 * File version: $Id: RegisterActionTest.java,v 1.2 2005/06/23 14:53:27 jaknowlden Exp $
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
package com.thesleepless.helium;

import com.thesleepless.helium.action.Action;
import com.thesleepless.helium.action.BlahAction;
import com.thesleepless.helium.action.InvocationTargetExceptionAction;
import com.thesleepless.helium.action.OkAction;
import com.thesleepless.helium.action.ParseBodyAction;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class RegisterActionTest extends HeliumTestFixture {

  public void testRegisteredActions() throws Exception {
    String xml = "<article>0<test/>1</article>";
    Article article = buildArticle(xml);

    getContext().getActionRegister().register("test", OkAction.class);
    article.parse(getContext());
    assertEquals("0ok1", getWrittenData());

    xml = "<article>0<test1/>1<test/>2</article>";
    article = buildArticle(xml);
    getContext().setWriter(newWriter());
    getContext().getActionRegister().register("test", OkAction.class);
    getContext().getActionRegister().register("test1", BlahAction.class);
    article.parse(getContext());
    assertEquals("0blah1ok2", getWrittenData());
  }

  public void testClassNotFound() throws Exception {
    try {
      new DefaultActionRegister().register("test", "bad.class.Name");
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Action Class [bad.class.Name] not found for Action [test]", e.getMessage());
      assertEquals(ClassNotFoundException.class, e.getCause().getClass());
    }
  }

  public void testRegisteredClassNotAction() throws Exception {
    try {
      new DefaultActionRegister().register("test", Object.class);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Registered class [" + Object.class.getName() + "] not instance of "
          + Action.class.getName(), e.getMessage());
    }
  }

  public void testRegisterActionNullName() throws Exception {
    try {
      new DefaultActionRegister().register(null, Object.class);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Registered action name not defined", e.getMessage());
    }
  }

  public void testRegisterActionNullClass() throws Exception {
    try {
      new DefaultActionRegister().register("", (Class) null);
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals("Registered action class not defined", e.getMessage());
    }
  }

  public void testRegisteredActionInstantiationException() throws Exception {
    String xml = "<article>0<whoops/>1</article>";
    Article article = buildArticle(xml);
    getContext().getActionRegister().register("whoops", InvocationTargetExceptionAction.class);
    try {
      article.parse(getContext());
      fail("Should have failed");
    } catch (HeliumException e) {
      assertEquals(RuntimeException.class, e.getCause().getClass());
      assertEquals("Whoops!", e.getCause().getMessage());
    }
  }

  public void testTextWithinRegisteredAction() throws Exception {
    String xml = "<article>0<a>hello, world</a>1</article>";
    Article article = buildArticle(xml);
    getContext().getActionRegister().register("a", ParseBodyAction.class);
    article.parse(getContext());
    assertEquals("0hello, world1", getWrittenData());
  }

  public void testRegisteredActionWithinRegisteredAction() throws Exception {
    String xml = "<article>0<a>1<a>hello, world</a>2</a>3</article>";
    Article article = buildArticle(xml);
    getContext().getActionRegister().register("a", ParseBodyAction.class);
    article.parse(getContext());
    assertEquals("01hello, world23", getWrittenData());
  }

  public void testParseNullBody() throws Exception {
    String xml = "<article>0<a/>1</article>";
    Article article = buildArticle(xml);
    getContext().getActionRegister().register("a", ParseBodyAction.class);
    article.parse(getContext());
    assertEquals("01", getWrittenData());
  }

}
