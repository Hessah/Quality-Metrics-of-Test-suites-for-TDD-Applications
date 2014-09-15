/*
 * Created: Oct 23, 2004
 * File version: $Id: Helium.java,v 1.2 2005/06/25 03:21:16 jaknowlden Exp $
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
package com.thesleepless.helium.ui.text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.thesleepless.helium.ArticleBuilder;
import com.thesleepless.helium.FileSystemArticleSource;
import com.thesleepless.helium.HeliumContext;
import com.thesleepless.helium.HeliumFactory;

/**
 * Command line utility for parsing Helium Articles.
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class Helium {
  public static void main(String[] args) throws Exception {
    try {
      if (args.length >= 1 && args[0] != null) {
        Map dataMap = new HashMap(16);
        processArguments(args, dataMap);
        HeliumContext context = HeliumFactory.newHeliumContext();
        context.setWriter(new PrintWriter(System.out));
        context.setDataMap(dataMap);
        context.setArticleSource(new FileSystemArticleSource());
        ArticleBuilder.locateAndBuild(args[0], context).parse(context);
        context.getWriter().checkError();
      } else
        throw new InvalidCommandException("Path to article not defined");
    } catch (InvalidCommandException e) {
      usage(e.getMessage());
    }
  }

  private static void processArguments(String[] args, Map dataMap) throws InvalidCommandException {
    for (int i = 1; i < args.length; i++)
      handleArgument(dataMap, args[i]);
  }

  private static void handleArgument(Map dataMap, String arg) throws InvalidCommandException {
    if (arg.startsWith("-V"))
      dataMap.put(getKey(arg), getValue(arg));
    else if (arg.startsWith("-P"))
      loadPropertyFile(dataMap, arg);
    else
      throw new InvalidCommandException("Command [" + arg + "] not recognized");
  }

  private static void loadPropertyFile(Map dataMap, String propFileName)
      throws InvalidCommandException {
    try {
      FileInputStream propFile = null;
      propFile = new FileInputStream(propFileName.substring(2));
      Properties props = new Properties();
      props.load(propFile);
      for (Iterator iter = props.keySet().iterator(); iter.hasNext();) {
        String key = (String) iter.next();
        dataMap.put(key, props.get(key));
      }
      propFile.close();
    } catch (IOException e) {
      throw new InvalidCommandException("Problems loading property file [" + propFileName + "]: "
          + e.getMessage());
    }
  }

  private static String getKey(String arg) throws InvalidCommandException {
    try {
      return arg.substring(2, arg.indexOf('='));
    } catch (RuntimeException e) {
      throw new InvalidCommandException("No value defined [" + arg + "]");
    }
  }

  private static String getValue(String arg) {
    return arg.substring(arg.indexOf('=') + 1);
  }

  private static final void usage(String msg) {
    System.err.println("Usage: " + Helium.class.getName()
        + " <path-to-article> [[-V<key>=<value>] [-P<filename>]]");
    System.err.println(" ! " + msg);
  }

}