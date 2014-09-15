/*
 * Created: Apr 10, 2005
 * File version: "$Id: ActionRegisterBuilder.java,v 1.3 2005/06/25 16:35:37 jaknowlden Exp $"
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class ActionRegisterBuilder {

  static final String ActionSystemProperty = "helium.action";
  static final String DefaultProperties = "/com/thesleepless/helium/core.has";

  public ActionRegister build() throws HeliumException, IOException {
    String sysProp = System.getProperty(ActionSystemProperty);
    ActionRegister register = new DefaultActionRegister();
    Properties registerDef = getCoreProperties(sysProp);
    try {
      for (Iterator iter = registerDef.keySet().iterator(); iter.hasNext();) {
        String actionName = iter.next().toString();
        register.register(actionName, Class.forName(registerDef.getProperty(actionName)));
      }
    } catch (ClassNotFoundException e) {
      throw new HeliumException("Action Class [" + e.getMessage() + "] could not be found");
    }
    return register;
  }

  private Properties getCoreProperties(String sysProp) throws HeliumException, IOException {
    InputStream stream = ActionRegisterBuilder.class
        .getResourceAsStream(sysProp == null ? DefaultProperties : sysProp);
    if (stream == null)
      throw new HeliumException("File [" + sysProp + "] not found");
    Properties registerDef = new Properties();
    registerDef.load(stream);
    stream.close();
    return registerDef;
  }
}
