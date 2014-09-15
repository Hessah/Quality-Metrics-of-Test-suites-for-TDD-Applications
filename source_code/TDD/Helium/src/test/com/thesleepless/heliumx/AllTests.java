/*
 * Created: Oct 24, 2004
 * File version: $Id: AllTests.java,v 1.2 2005/06/26 00:04:25 jaknowlden Exp $
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
package com.thesleepless.heliumx;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.2 $"
 */
public class AllTests {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for com.thesleepless.heliumx");
    //$JUnit-BEGIN$
    suite.addTest(com.thesleepless.heliumx.servlet.AllTests.suite());
    suite.addTest(com.thesleepless.heliumx.net.AllTests.suite());
    //$JUnit-END$
    return suite;
  }
}
