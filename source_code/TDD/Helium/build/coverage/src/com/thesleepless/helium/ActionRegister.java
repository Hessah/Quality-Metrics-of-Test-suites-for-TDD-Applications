/*
 * Created: Mar 30, 2005
 * File version: "$Id: ActionRegister.java,v 1.3 2005/07/04 17:24:35 jaknowlden Exp $"
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

import com.thesleepless.helium.action.Action;

public interface ActionRegister {
  public void register(String actionName, Class action) throws HeliumException;
  public void register(String actionName, String actionClass) throws HeliumException;
  public Action find(String actionName) throws HeliumException;
}
