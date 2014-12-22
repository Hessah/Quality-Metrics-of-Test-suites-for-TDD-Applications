/*
Copyright (c) 2007-2008, Henri Frilund

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package wheel.xhtmlConversion;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * An utility class that can convert valid XHTML-code to Wheel component classes.
 */
public class Xhtml2Wheel extends DefaultHandler {
    private StringBuilder sb;
    private Node currentNode;
    private Node previousNode;
    private Stack<Node> openNodes;

    public Xhtml2Wheel(File input, String packageName) {

        Node.idCounter = 1;

        String originalFileName = input.getName();
        String className = Character.toUpperCase(originalFileName.charAt(0)) + originalFileName.substring(1, originalFileName.lastIndexOf("."));
        openNodes = new Stack<Node>();

        Node.className = className;

        sb = new StringBuilder();
        sb.append("package " + packageName + ";\n");
        sb.append("import wheel.components.StandaloneComponent;\n");
        sb.append("public class " + className + " extends StandaloneComponent {\n");
        sb.append("    public void buildComponent() {\n");

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            SAXParser builder = factory.newSAXParser();
            builder.parse(input, this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        sb.append("\n");
        sb.append("    }\n");
        sb.append("}\n");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributesA) throws SAXException {
        previousNode = currentNode;
        currentNode = new Node(qName.toLowerCase(), attributesA);

        if (currentNode.name.equals("html") || currentNode.name.equals("body") || currentNode.name.equals("head") || currentNode.name.equals("option")) {
            currentNode.skip = true;
            openNodes.push(currentNode);
            return;
        }

        openNode(currentNode);
    }


    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        Node node = openNodes.pop();

        if (node.closed)
            return;

        Node parent = !openNodes.isEmpty() ? openNodes.peek() : null;

        if (node.printed && node.text.length() > 0) {
            sb.append(".\n");

            for(int i = 0; i < openNodes.size()+1; i++)
                sb.append("    ");

            sb.append("text(\"" + node.text + "\").up()");
            node.text = "";
        }
        
        if (openNodes.size() > 2 && !node.skip) {
            if (!node.printed)
                node.print(sb);

            int upIndex = sb.lastIndexOf("up()");
            int up2Index =  sb.lastIndexOf("up(2)");
            int up3Index = sb.lastIndexOf("up(3)");

            if (upIndex == sb.length()-4)
                sb.replace(sb.length()-4, sb.length(), "up(2)");
            else if (up2Index == sb.length()-5)
                sb.replace(sb.length()-5, sb.length(), "up(3)");
            else if (up3Index == sb.length()-5)
                sb.replace(sb.length()-5, sb.length(), "up(4)");
            else
                sb.append(".up()");
        }

        if (parent != null && (parent.name.equals("head") || parent.name.equals("body"))) {
            if (!node.printed)
                node.print(sb);

            if (!node.skip)
                sb.append(";");
        }

        node.closed = true;

    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String text = new String(chars, start, length).trim();

        if (text.length() == 0)
            return;

        if (!currentNode.closed)
            currentNode.appendText(text);
        else
            currentNode.parent.appendText(text);
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        InputSource is = null;

        if (publicId.equals("-//W3C//DTD XHTML 1.0 Transitional//EN"))
            is = new InputSource(getClass().getResourceAsStream("xhtml1-transitional.dtd"));
        else if (publicId.equals("-//W3C//ENTITIES Latin 1 for XHTML//EN"))
            is = new InputSource(getClass().getResourceAsStream("xhtml-lat1.ent"));
        else if (publicId.equals("-//W3C//ENTITIES Symbols for XHTML//EN"))
            is = new InputSource(getClass().getResourceAsStream("xhtml-symbol.ent"));
        else if (publicId.equals("-//W3C//ENTITIES Special for XHTML//EN"))
            is = new InputSource(getClass().getResourceAsStream("xhtml-special.ent"));
        if (publicId.equals("-//W3C//DTD XHTML 1.0 Strict//EN"))
            is = new InputSource(getClass().getResourceAsStream("xhtml1-strict.dtd"));

        else
            return super.resolveEntity(publicId, systemId);

        return is;
    }

    public void openNode(Node node) {

        if (previousNode != null && !previousNode.skip && !previousNode.closed) {
            if (!previousNode.printed)
                previousNode.print(sb);
            else {
                if (previousNode.text.length() > 0) {
                    sb.append(".\n");
                    for(int i = 0; i < openNodes.size(); i++)
                        sb.append("    ");

                    sb.append(".text(\"" + previousNode.text + "\").up()");
                }

            }
        }

        Node parent = !openNodes.isEmpty() ? openNodes.peek() : null;

        if (parent != null && !parent.name.equals("html")) {
            node.parent = parent;

            if (parent.name.equals("head") || parent.name.equals("body"))
                sb.append("\n        ");
            else  {
                sb.append(".\n");
                for(int i = 0; i < openNodes.size(); i++)
                    sb.append("    ");
            }
        }

        openNodes.push(node);

    }

    public static void main(String[] args) {
        Xhtml2Wheel xhtml2Wheel = new Xhtml2Wheel(new File(args[0]), args[1]);
        System.out.println(xhtml2Wheel.sb.toString());
    }
}

class Node {
    String name;
    Map<String,String> attributes;
    boolean attributesProcessed;
    boolean hasText;
    String text = "";
    static int idCounter = 1;
    boolean skip;
    Node parent;
    boolean printed;
    static String className;
    boolean closed;

    Node(String name, Attributes attributes) {
        this.name = name;
        this.attributes = new HashMap<String,String>();

        for(int i = 0; i < attributes.getLength(); i++)
            this.attributes.put(attributes.getLocalName(i), attributes.getValue(i));

    }

    void appendText(String text) {
        this.text += text.replaceAll("\\\"", "\\\\\"").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    void print(StringBuilder sb) {
        printed = true;

        if (skip)
            return;

        if (name.equals("form")) {
            hasText = true;
            String id = attributes.remove("id");
            attributes.remove("action");
            attributes.remove("enctype");
            attributes.remove("method");

            sb.append("form(\"" + (id == null ? "form" + idCounter++ : id) + "\")");
        }
        else if (name.equals("input")) {
            hasText = true;
            String type = attributes.remove("type").toLowerCase();
            String name = attributes.remove("name");
            String value = attributes.remove("value");

            if (name == null)
                name = type + idCounter++;

            if (type.equals("hidden"))
                sb.append("hidden(\"" + name + "\")");
            else if (type.equals("text"))
                sb.append("textInput(\"" + name + "\")");
            else if (type.equals("radio"))
                sb.append("radio(\"" + name + "\")");
            else if (type.equals("checkbox"))
                sb.append("checkbox(\"" + name + "\")");
            else if (type.equals("text"))
                sb.append("textInput(\"" + name + "\")");
            else if (type.equals("submit"))
                sb.append("submit(\"" + name + "\")");
            else if (type.equals("password"))
                sb.append("passwordInput(\"" + name + "\")");
            else if (type.equals("reset"))
                sb.append("reset(\"" + name + "\")");
            else if (type.equals("file"))
                sb.append("fileInput(\"" + name + "\")");
            else if (type.equals("image"))
                sb.append("imageSubmit(\"" + name + "\", \"" + removePathFromSource(attributes.remove("src")) + "\")");
            else if (type.equals("button"))
                sb.append("buttonInput(\"" + name + "\")");

            if (value != null)
                sb.append(".value(\"" + value + "\")");
        }
        else if (name.equals("select")) {
            String name = attributes.remove("name");
            sb.append("select(\"" + name + "\", new wheel.util.StringSelectModel(), \"\")");
        }
        else if (name.equals("img")) {
            String src = attributes.remove("src").trim();
            String alt = attributes.remove("alt");

            if (alt == null)
                alt = "Alternative text missing.";

            sb.append("img(\"" + removePathFromSource(src) + "\", \"" + alt + "\")");
        }
        else if (name.equals("link")) {
            String rel = attributes.get("rel");

            if (!rel.equals("stylesheet")) {
                sb.append("head().link()");
            }
            else {
                attributes.remove("rel");
                String href = attributes.remove("href");
                String hrefStripped = removePathFromSource(href).toLowerCase();
                String media = attributes.remove("media");

                attributes.clear();

                if (!hrefStripped.startsWith(className.toLowerCase())) {
                    sb.append("config().useAsset(\"" + hrefStripped + "\"");

                    if (media != null)
                        sb.append(", \"" + media + "\"");

                    sb.append(")");
                }
                else
                    skip = true;
            }
        }
        else if (name.equals("script")) {
            if (text.length() > 0) {
                if (parent.name.equals("head"))
                    sb.append("head().");

                sb.append("script()");

                attributes.remove("xml:space");

                processAttributes(sb);
                attributesProcessed = true;

                sb.append(".rawText(\"" + text.replaceAll("\\\"", "\\\\\"") + "\")");

            }
            else {
                String src = removePathFromSource(attributes.remove("src"));
                attributes.clear();

                sb.append("config().useAsset(\"" + src + "\")");
            }
        }
        else {
            sb.append(name);

            if (text.length() > 0) {
                if (acceptsText())
                    sb.append("(\"" + text + "\")");
                else
                    sb.append("().text(\"" + text + "\").up()");
            }
            else
                sb.append("()");
        }

        if (!attributesProcessed)
            processAttributes(sb);

        text = "";

    }

    private String removePathFromSource(String source) {
        if (source == null)
            return "";

        if (source.indexOf('/') == -1)
            return source;

        return source.substring(source.lastIndexOf("/") + 1, source.length());
    }

    private boolean acceptsText() {
        if (name.equals("div"))
            return false;
        else if (name.equals("fieldset"))
            return false;
        else if (name.equals("button"))
            return false;
        else if (name.equals("blockquote"))
            return false;
        else if (name.equals("input"))
            return false;

        return true;
    }

    private void processAttributes(StringBuilder sb) {
        if (attributes.size() > 0) {
            attributes.remove("shape");
            attributes.remove("clear");
            attributes.remove("type");
            String id = attributes.remove("id");
            String clasS = attributes.remove("class");
            String href = attributes.remove("href");

            if (href != null) {
                if (href.contains("://") && !name.equals("a"))
                    attributes.put("href", href);
                else if(href.contains("://") && name.equals("a"))
                    sb.append(".actionBinding(\"" + href + "\")");
            }

            if (id != null)
                sb.append(".id(\"" + id + "\")");

            if (clasS != null)
                sb.append(".clasS(\"" + clasS + "\")");

            if (attributes.size() == 0)
                return;

            if (attributes.size() == 1)
                sb.append(".attribute(");
            else
                sb.append(".attributes(");



            Iterator<String> keys = attributes.keySet().iterator();

            while (keys.hasNext()) {
                String name = keys.next();
                String value = attributes.get(name);

                sb.append("\"" + name + "\", \"" + value + "\"");

                if (keys.hasNext())
                    sb.append(", ");
            }

            sb.append(")");
        }
    }
}