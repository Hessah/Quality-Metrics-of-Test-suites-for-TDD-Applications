/*
 * Created: Jul 9, 2004
 * File version: $Id: DefaultArticle.java,v 1.1 2005/05/03 23:34:39 jaknowlden Exp $
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
package com.thesleepless.helium;

import java.util.Iterator;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.thesleepless.helium.util.IteratorFactory;
import com.thesleepless.helium.util.TagUtil;

/**
 * 
 * @author Justin Knowlden
 * @version "$Revision: 1.1 $"
 */
class DefaultArticle implements Article {

  private Node node;

  /**
   * Constructor for Article.
   */
  DefaultArticle(Node node) {
    super();
    this.node = node;
  }

  public String getName() {
    if (isTextArticle())
      return null;
    return node.getNodeName();
  }

  private boolean isNodeType(short type) {
    return node.getNodeType() == type;
  }

  public boolean isTextArticle() {
    return isNodeType(Node.TEXT_NODE);
  }

  public boolean isLiteralArticle() {
    return isNodeType(Node.CDATA_SECTION_NODE);
  }

  public boolean isCommentArticle() {
    return isNodeType(Node.COMMENT_NODE);
  }

  public boolean hasChildren() {
    return node.hasChildNodes();
  }

  public Article getFirstChildArticle() {
    return HeliumFactory.newArticle(node.getFirstChild());
  }

  public Article getNextArticle() {
    return HeliumFactory.newArticle(node.getNextSibling());
  }

  public String getText() {
    return node.getNodeValue();
  }

  public boolean containsArgument(String name) {
    return node.getAttributes().getNamedItem(name) != null;
  }

  public Argument getArgument(String name) {
    return HeliumFactory.newArgument(node.getAttributes().getNamedItem(name));
  }

  public Iterator getArguments() {
    return IteratorFactory.createArgumentIterator(node.getAttributes());
  }

  public void parse(HeliumContext context) throws HeliumException {
    NamedNodeMap attrs = node.getAttributes();
    for (int i = 0; attrs != null && i < attrs.getLength(); i++) {
      Node attr = attrs.item(i);
      attr.setNodeValue(TagUtil.replaceVariables(context, attr.getNodeValue()));
    }
    ActionRunner.locateAndRun(this, context);
    getNextArticle().parse(context);
  }

}