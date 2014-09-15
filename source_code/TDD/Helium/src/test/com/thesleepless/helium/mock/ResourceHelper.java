/*
 * Created: Jun 24, 2005
 * File version: "$Id: ResourceHelper.java,v 1.1 2005/06/25 01:37:51 jaknowlden Exp $"
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
package com.thesleepless.helium.mock;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

public class ResourceHelper {
  private List filesToDelete;

  public ResourceHelper() {
    filesToDelete = new ArrayList(16);
  }

  public void cleanupFiles() {
    for (Iterator iter = filesToDelete.iterator(); iter.hasNext();) {
      File file = (File) iter.next();
      if (file.exists())
        Assert.assertTrue("File [" + file.getName() + "] not deleted", file.delete());
      Assert.assertFalse("File [" + file.getName() + "] still exists", file.exists());
      iter.remove();
    }
  }

  public File writeResource(String resourcePathAndName, String contents) throws Exception {
    URL baseUrl = getClass().getResource("/");
    String basePath = baseUrl.toString();
    File file = new File(new URI(basePath + "/" + resourcePathAndName));
    filesToDelete.add(file);
    Writer writer = new FileWriter(file);
    try {
      writer.write(contents);
    } finally {
      writer.close();
    }
    return file;
  }

  protected void finalize() throws Throwable {
    cleanupFiles();
  }
}
