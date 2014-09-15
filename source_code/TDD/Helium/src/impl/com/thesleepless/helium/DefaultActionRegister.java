/*
 * Created: Mar 30, 2005
 * File version: "$Id: DefaultActionRegister.java,v 1.3 2005/07/04 17:24:35 jaknowlden Exp $"
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

import java.util.HashMap;
import java.util.Map;

import com.thesleepless.helium.action.Action;

class DefaultActionRegister implements ActionRegister {

  private Map registeredActions;

  public DefaultActionRegister() {
    registeredActions = new HashMap();
  }

  public void register(String actionName, Class actionClass) throws HeliumException {
    if (actionName == null)
      throw new HeliumException("Registered action name not defined");
    else if (actionClass == null)
      throw new HeliumException("Registered action class not defined");
    else if (!Action.class.isAssignableFrom(actionClass))
      throw new HeliumException("Registered class [" + actionClass.getName() + "] not instance of "
          + Action.class.getName());
    registeredActions.put(actionName, actionClass);
  }

  public void register(String actionName, String actionClass) throws HeliumException {
    try {
      register(actionName, Class.forName(actionClass));
    } catch (ClassNotFoundException e) {
      throw new HeliumException("Action Class [" + actionClass + "] not found for Action ["
          + actionName + "]", e);
    }
  }

  public Action find(String actionName) throws HeliumException {
    if (registeredActions.containsKey(actionName))
      try {
        return (Action) ((Class) registeredActions.get(actionName)).newInstance();
      } catch (Exception e) {
        throw new HeliumException(e);
      }
    return null;
  }

}
