/*
 * Created: Mar 31, 2005
 * File version: "$Id: ServletHeliumTestFixture.java,v 1.2 2005/06/30 04:02:40 jaknowlden Exp $"
 * 
 * Helium, description
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
package com.thesleepless.heliumx.servlet;

import org.apache.util.testharness.TestRequest;
import org.apache.util.testharness.TestResponse;

import com.thesleepless.helium.HeliumTestFixture;

public class ServletHeliumTestFixture extends HeliumTestFixture {

  protected ServletHeliumContext getServletHeliumContext(TestRequest req, TestResponse res)
      throws Exception {
    getContext().setWriter(res.getWriter());
    return HeliumxServletFactory.newServletHeliumContext(getContext(), req, res);
  }

  protected void assertArgumentMissing(String articleText, String missingArg, String actionName)
      throws Exception {
    assertArgumentMissing(articleText, missingArg, actionName, getServletHeliumContext(
        new TestRequest(TestRequest.GET), new TestResponse()));
  }
}
