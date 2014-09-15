/*
 * Created: Oct 23, 2004
 * File version: $Id: CommandLineTest.java,v 1.4 2005/06/25 03:21:11 jaknowlden Exp $
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

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import com.thesleepless.helium.ArticleNotFoundException;
import com.thesleepless.helium.action.OkAction;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.4 $"
 */
public class CommandLineTest extends TestCase {
  private static final String TmpDir = System.getProperty("java.io.tmpdir");
  private static final String NewLine = System.getProperty("line.separator");

  private MockOutputStream out;
  private MockOutputStream err;
  private Set tmpFiles;

  protected void setUp() throws Exception {
    super.setUp();
    mockSystemStreams();
    tmpFiles = new HashSet(2);
  }

  private void mockSystemStreams() {
    System.setOut(new PrintStream(out = new MockOutputStream()));
    System.setErr(new PrintStream(err = new MockOutputStream()));
  }

  protected void tearDown() throws Exception {
    for (Iterator iter = tmpFiles.iterator(); iter.hasNext();) {
      File tmpFile = (File) iter.next();
      assertTrue("Temp file [" + tmpFile.getAbsolutePath() + "] not deleted", tmpFile.delete());
      assertFalse("Temp file [" + tmpFile.getAbsolutePath() + "] still exists", tmpFile.exists());
    }
    super.tearDown();
  }

  private File writeFile(String fileName, String content) throws Exception {
    File tmpFile = new File(TmpDir + "/" + fileName);
    Writer writer = new FileWriter(tmpFile);
    writer.write(content);
    writer.close();
    tmpFiles.add(tmpFile);
    return tmpFile;
  }

  private File writeArticle(String fileName, String content) throws Exception {
    return writeFile(fileName, "<article>" + content + "</article>");
  }

  private String getStdoutAsString() {
    return out.toString();
  }

  private String getStderrAsString() {
    return err.toString();
  }

  private void assertUsage(String msg) {
    assertTrue(getStderrAsString().startsWith(
        "Usage: " + Helium.class.getName()
            + " <path-to-article> [[-V<key>=<value>] [-P<filename>]]" + NewLine + " ! " + msg));
  }

  public void testZeroArgs() throws Exception {
    Helium.main(new String[0]);
    assertUsage("Path to article not defined");
  }

  public void testNullArticlePathArg() throws Exception {
    Helium.main(new String[1]);
    assertUsage("Path to article not defined");
  }

  public void testArticleNotFound() throws Exception {
    try {
      Helium.main(new String[]{TmpDir + "/non-existent.he"});
      fail("Should have failed");
    } catch (ArticleNotFoundException e) {
      assertEquals("Article [" + TmpDir + "/non-existent.he] not found", e.getMessage());
    }
  }

  public void testCommandLineArgNotRecognized() throws Exception {
    Helium.main(new String[]{"/does/not/matter", "-Xfoo=bar"});
    assertUsage("Command [-Xfoo=bar] not recognized");
    assertEquals("", getStdoutAsString());
  }

  public void testInjectVarFromCommandLine() throws Exception {
    File tmpFile = writeArticle("tmp.he", "[#{foo}]");
    Helium.main(new String[]{tmpFile.getAbsolutePath(), "-Vfoo=bar"});
    assertEquals("", getStderrAsString());
    assertEquals("[bar]", getStdoutAsString());

    mockSystemStreams();
    Helium.main(new String[]{tmpFile.getAbsolutePath(), "-Vfoo="});
    assertEquals("", getStderrAsString());
    assertEquals("[]", getStdoutAsString());

    mockSystemStreams();
    Helium.main(new String[]{tmpFile.getAbsolutePath(), "-Vfoo=bar baz bum"});
    assertEquals("", getStderrAsString());
    assertEquals("[bar baz bum]", getStdoutAsString());

    mockSystemStreams();
    Helium.main(new String[]{"/does/not/matter", "-Vfoo"});
    assertUsage("No value defined [-Vfoo]");
    assertEquals("", getStdoutAsString());
  }

  public void testInjectVarAsPropertyFile() throws Exception {
    File varFile = writeFile("vars.prop", "foo=1\nbar=2\nbaz=3");
    File tmpFile = writeArticle("tmp.he", "[#{foo}#{bar}#{baz}]");
    Helium.main(new String[]{tmpFile.getAbsolutePath(), "-P" + varFile.getAbsolutePath()});
    assertEquals("", getStderrAsString());
    assertEquals("[123]", getStdoutAsString());

    mockSystemStreams();
    Helium.main(new String[]{"/does/not/matter", "-P"});
    assertUsage("Problems loading property file [-P]:  (No such file or directory)");
    assertEquals("", getStdoutAsString());

    mockSystemStreams();
    Helium.main(new String[]{"/does/not/matter", "-Pno.file"});
    assertUsage("Problems loading property file [-Pno.file]: no.file (");
    assertEquals("", getStdoutAsString());
  }

  public void testParsePlainArticle() throws Exception {
    File tmpFile = writeArticle("article.he", "hello, world");
    Helium.main(new String[]{tmpFile.getAbsolutePath()});
    assertEquals("hello, world", getStdoutAsString());
  }

  public void testParseArticleWithVarTag() throws Exception {
    File tmpFile = writeArticle("article.he",
        "0<var name=\"tmpVar\" value=\"hello, world\"/>#{tmpVar}1");
    Helium.main(new String[]{tmpFile.getAbsolutePath()});
    assertEquals("0hello, world1", getStdoutAsString());
  }

  public void testParseArticleWithIncludeTag() throws Exception {
    File includeFile = writeArticle("article2.he", "hello, world");
    File mainFile = writeArticle("article1.he", "0<include article=\""
        + includeFile.getAbsolutePath() + "\"/>1");
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals("0hello, world1", getStdoutAsString());
  }

  public void testParseArticleWithWhenTag() throws Exception {
    File mainFile = writeArticle("article.he", "0<var name=\"var1\" value=\"hello, world\"/>"
        + "<when var=\"var1\" exists=\"true\">[#{var1}]</when>1");
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals("0[hello, world]1", getStdoutAsString());
  }

  public void testParseArticleWithIterateTag() throws Exception {
    File mainFile = writeArticle("article.he", "0<var name=\"var1\" value=\"hello, world\"/>"
        + "<iterate var=\"var1\" itemVar=\"tmpVar\">[#{tmpVar}]" + "</iterate>1");
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals("0[hello, world]1", getStdoutAsString());
  }

  public void testParseArticleWithActionTag() throws Exception {
    File mainFile = writeArticle("article.he", "0<action name=\"runOk\" class=\""
        + OkAction.class.getName() + "\"/>[<runOk/>]1");
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals("0[ok]1", getStdoutAsString());

    // make sure the Action registration is gone
    mockSystemStreams();
    String articleTxt = "0<runOk/>1";
    mainFile = writeArticle("article.he", articleTxt);
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals(articleTxt, getStdoutAsString());
  }

  public void testParseArticleWithListTag() throws Exception {
    File mainFile = writeArticle("article.he",
        "0<list name=\"var1\" value=\"1\"/><list name=\"var1\" value=\"2\"/>"
            + "<iterate var=\"var1\" itemVar=\"tmpVar\">[#{tmpVar}]</iterate>1");
    Helium.main(new String[]{mainFile.getAbsolutePath()});
    assertEquals("0[1][2]1", getStdoutAsString());
  }

}