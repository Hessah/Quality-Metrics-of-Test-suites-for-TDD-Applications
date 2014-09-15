/*
 * Created: Oct 24, 2004
 * File version: $Id: HeliumServlet.java,v 1.2 2005/06/25 16:02:00 jaknowlden Exp $
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
package com.thesleepless.heliumx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thesleepless.helium.ArticleBuilder;
import com.thesleepless.helium.ArticleNotFoundException;
import com.thesleepless.helium.HeliumContext;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class HeliumServlet extends HttpServlet {

  /**
   * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
      IOException {
    handleGetAndPost(req, res);
  }

  /**
   * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
      IOException {
    handleGetAndPost(req, res);
  }

  private void handleGetAndPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    try {
      res.setContentType("text/html");
      HeliumContext context = HeliumxServletFactory.newServletHeliumContext(req, res);
      context.setArticleSource(new ServletArticleSource(getServletContext()));
      ArticleBuilder.locateAndBuild(req.getServletPath(), context).parse(context);
    } catch (ArticleNotFoundException e) {
      res.sendError(HttpServletResponse.SC_NOT_FOUND, req.getContextPath() + req.getServletPath());
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}