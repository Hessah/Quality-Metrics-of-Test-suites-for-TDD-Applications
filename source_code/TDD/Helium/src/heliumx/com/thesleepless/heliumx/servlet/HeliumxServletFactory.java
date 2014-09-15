/*
 * Created: Jun 25, 2005
 * File version: "$Id: HeliumxServletFactory.java,v 1.1 2005/06/25 16:02:00 jaknowlden Exp $"
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
package com.thesleepless.heliumx.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;
import com.thesleepless.helium.HeliumFactory;

public class HeliumxServletFactory {
  public static ServletHeliumContext newServletHeliumContext(HttpServletRequest request,
      HttpServletResponse response) throws HeliumException, IOException {
    HeliumContext context = HeliumFactory.newHeliumContext();
    context.setWriter(response.getWriter());
    return newServletHeliumContext(context, request, response);
  }

  public static ServletHeliumContext newServletHeliumContext(HeliumContext defaultContext,
      HttpServletRequest request, HttpServletResponse response) throws HeliumException, IOException {
    return new ServletHeliumContext(defaultContext, request, response);
  }
}
