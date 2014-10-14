/*--

 Copyright (C) 2011-2014 Jason Hunter & Brett McLaughlin.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions, and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions, and the disclaimer that follows
    these conditions in the documentation and/or other materials
    provided with the distribution.

 3. The name "JDOM" must not be used to endorse or promote products
    derived from this software without prior written permission.  For
    written permission, please contact <request_AT_jdom_DOT_org>.

 4. Products derived from this software may not be called "JDOM", nor
    may "JDOM" appear in their name, without prior written permission
    from the JDOM Project Management <request_AT_jdom_DOT_org>.

 In addition, we request (but do not require) that you include in the
 end-user documentation provided with the redistribution and/or in the
 software itself an acknowledgement equivalent to the following:
     "This product includes software developed by the
      JDOM Project (http://www.jdom.org/)."
 Alternatively, the acknowledgment may be graphical using the logos
 available at http://www.jdom.org/images/logos.

 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE JDOM AUTHORS OR THE PROJECT
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 This software consists of voluntary contributions made by many
 individuals on behalf of the JDOM Project and was originally
 created by Jason Hunter <jhunter_AT_jdom_DOT_org> and
 Brett McLaughlin <brett_AT_jdom_DOT_org>.  For more information
 on the JDOM Project, please see <http://www.jdom.org/>.

 */

package org.jdom2.contrib.xpath.xalan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.QName;
import org.apache.xpath.VariableStack;
import org.apache.xpath.XPath;
import org.apache.xpath.XPathContext;
import org.apache.xpath.axes.NodeSequence;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Comment;
import org.jdom2.Content;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.EntityRef;
import org.jdom2.Namespace;
import org.jdom2.NamespaceAware;
import org.jdom2.ProcessingInstruction;
import org.jdom2.Text;
import org.jdom2.contrib.dom.DOM;
import org.jdom2.contrib.dom.Wrapper;
import org.jdom2.filter.Filter;
import org.jdom2.xpath.util.AbstractXPathCompiled;

/**
 * An XPathExpression that wraps the JDOM content in DOM wrappers
 * and then uses the Direct Xalan API to implement XPath.
 * 
 * @author Rolf Lear
 *
 * @param <T> the type of the coerced results.
 */
class XalanXPathExpression<T> extends AbstractXPathCompiled <T> implements PrefixResolver {
	
	private final XPath xpath;
	
	private final VariableStack variables = new VariableStack() {
		@Override
		public XObject getVariableOrParam(XPathContext xctxt, QName qname)
				throws TransformerException {
			if (qname == null) {
				throw new IllegalArgumentException("Null qname");
			}
	        final Object varValue = getVariable(qname.getLocalName(),
	        		Namespace.getNamespace(qname.getNamespaceURI()));		
	        if ( varValue == null ) {
	            throw new TransformerException(
	            		"No such variable " + qname.toNamespacedString());
	        } 
			return XObject.create(varValue, xctxt);
		}
	};
	
	/**
	 * Construct the XPathExpression.
	 * @param query The XPath query to create.
	 * @param filter The coercion filter.
	 * @param variables The variable map
	 * @param namespaces The scope namespaces.
	 */
	public XalanXPathExpression(final String query, final Filter<T> filter,
			final Map<String, Object> variables, final Namespace[] namespaces) {
		super(query, filter, variables, namespaces);
		
	    // Create an object to resolve namespace prefixes.
	    // XPath namespaces are resolved from the input context node's document element
	    // if it is a root node, or else the current context node (for lack of a better
	    // resolution space, given the simplicity of this sample code).

	    // Create the XPath object.
	    try {
			xpath = new XPath(query, null, this, XPath.SELECT, null);
		} catch (TransformerException e) {
			throw new IllegalArgumentException("Unable to parse: " + query, e);
		}

	}
	
	private final Node wrap(Object context) {
		if (context == null) {
			return DOM.wrap(new Document(), false);
		}
		if (context instanceof Document) {
			return DOM.wrap((Document)context);
		}
		if (context instanceof Content) {
			switch (((Content)context).getCType()) {
				case CDATA:
					return DOM.wrap((CDATA)context);
				case Comment:
					return DOM.wrap((Comment)context);
				case DocType:
					return DOM.wrap((DocType)context);
				case Element:
					return DOM.wrap((Element)context);
				case EntityRef:
					return DOM.wrap((EntityRef)context);
				case ProcessingInstruction:
					return DOM.wrap((ProcessingInstruction)context);
				case Text:
					return DOM.wrap((Text)context);
			}
		}
		if (context instanceof Attribute) {
			return DOM.wrap((Attribute)context);
		}
		throw new IllegalArgumentException("Unable to wrap context: " + context);
	}

	@Override
	protected List<?> evaluateRawAll(Object context) {
		
	    // Execute the XPath, and have it return the result
	    // return xpath.execute(xpathSupport, contextNode, prefixResolver);
		final XPathContext xpathSupport = new XPathContext(false);
		xpathSupport.setVarStack(variables);
		
		final Node contextNode = wrap(context);
	    final int ctxtNode = xpathSupport.getDTMHandleFromNode(contextNode);

	    try {
		    final XObject xo = xpath.execute(xpathSupport, ctxtNode, this);
	    	ArrayList<Object> ret = new ArrayList<Object>();
		    if (xo instanceof NodeSequence) {
		    	final NodeList nl = ((NodeSequence)xo).nodelist();
		    	final int len = nl.getLength();
		    	for (int i = 0; i < len; i++) {
		    		Node n = nl.item(i);
		    		if (n instanceof Wrapper) {
		    			ret.add(((Wrapper)n).getWrapped());
		    		} else if (n instanceof Attr) {
		    			// probably a Namespace in the form of an Attr.
		    			final Attr nsa = (Attr)n;
		    			if ("xmlns".equals(nsa.getLocalName())) {
		    				ret.add(Namespace.getNamespace(nsa.getValue()));
		    			} else if (nsa.getName().startsWith("xmlns")) {
		    				ret.add(Namespace.getNamespace(
		    						nsa.getLocalName(), nsa.getValue()));
		    			} else {
		    				throw new IllegalStateException(
		    						"Unexpected Attribute " + nsa.getName() + 
		    						"=\"" + nsa.getValue() + "\"");
		    			}
		    		} else {
	    				throw new IllegalStateException(
	    						"Unexpected Node " + n.getNodeName());
		    		}
		    	}
		    } else {
		    	ret.add(xo.object());
		    }
	
			return ret;
	    } catch (TransformerException te) {
	    	throw new IllegalArgumentException("Unable to process xpath.", te);
	    }
	}

	@Override
	protected Object evaluateRawFirst(Object context) {
		List<?> raw = evaluateRawAll(context);
		if (raw.isEmpty()) {
			return null;
		}
		return raw.get(0);
	}
	
	
	@Override
	public String getNamespaceForPrefix(String prefix) {
		return getNamespace(prefix).getURI();
	}

	@Override
	public String getNamespaceForPrefix(String prefix, Node context) {
		if (context == null) {
			return getNamespace(prefix).getPrefix();
		}
		if (prefix == null) {
			prefix = "";
		}
		if (context instanceof Wrapper) {
			Object o = ((Wrapper)context).getWrapped();
			if ((o instanceof NamespaceAware)) {
				for (Namespace ns : ((NamespaceAware)o).getNamespacesInScope()) {
					if (ns.getPrefix().equals(prefix)) {
						return ns.getURI();
					}
				}
			}
		}
		return null;
	}

	@Override
	public String getBaseIdentifier() {
		return null;
	}

	@Override
	public boolean handlesNullPrefixes() {
		return false;
	}
	

}
