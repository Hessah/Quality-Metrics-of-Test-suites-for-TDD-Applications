/*
 * Created: May 17, 2005
 * File version: "$Id: ReflectActionBean.java,v 1.3 2005/06/03 20:41:59 jaknowlden Exp $"
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

public class ReflectActionBean {
  private boolean booleanField;
  private String field1, field2;
  public String writeOnlyField;
  private Object object;

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public boolean isBooleanField() {
    return booleanField;
  }

  public void setBooleanField(boolean value) {
    booleanField = value;
  }

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public void setWriteOnlyField(String writeOnlyField) {
    this.writeOnlyField = writeOnlyField;
  }

  public String getReadOnlyField() {
    return "read only value";
  }

  public String toString() {
    return field1 + ", " + field2 + ", " + writeOnlyField;
  }
}
