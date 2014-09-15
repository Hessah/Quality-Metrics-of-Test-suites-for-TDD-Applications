/*
 * Created: Jun 21, 2005
 * File version: "$Id: ActionSetAction.java,v 1.3 2005/06/25 00:34:34 jaknowlden Exp $"
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import com.thesleepless.helium.Article;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumException;

public class ActionSetAction extends AbstractAction {

  private static final String Colon = ":";
  private static final String ArgPrefix = "prefix";
  private static final String ArgDefinition = "definition";

  public void service(Article article, HeliumContext context) throws HeliumException {
    String prefix = getArgumentValue(article, ArgPrefix, "");
    if (prefix.length() > 0)
      prefix += Colon;
    Properties definitions = loadPropertiesFile(checkRequiredArgument(article, ArgDefinition));
    for (Iterator iter = definitions.keySet().iterator(); iter.hasNext();) {
      String actionName = (String) iter.next();
      context.getActionRegister().register(prefix + actionName,
          definitions.getProperty(actionName));
    }
  }

  private String getArgumentValue(Article article, String argName, String defaultValue) {
    if (!article.containsArgument(argName))
      return defaultValue;
    return getArgumentValue(article, argName);
  }

  private Properties loadPropertiesFile(String definitionFileName) throws HeliumException {
    InputStream stream = this.getClass().getResourceAsStream(definitionFileName);
    if (stream == null)
      throw new HeliumException("Action Set definition file [" + definitionFileName + "] not found");
    Properties properties = new Properties();
    try {
      properties.load(stream);
      stream.close();
    } catch (IOException e) {
      throw new HeliumException(e);
    }
    return properties;
  }

}
