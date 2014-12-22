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
package wheel.components;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import wheel.WheelException;

/**
 * An XHTML-table that uses thead, tbody and tfoot. Supports all table-features like colgroups, caption, headers and footers.
 * An example:<br/>
 * <pre>
 * table().attribute("border", "2").
 *      caption().label("Table caption").up(2).
 *
 *      thead().
 *          tr().
 *              th().label("column1").up(2).
 *              th().label("column2").up(2).
 *              th().label("column3").up(4).
 *      tbody().
 *          tr().
 *              td().p("Column1 content").up(2).
 *              td().p("Column2 content").up(2).
 *              td().p("Column3 content").up(4).
 *      tfoot().
 *          tr().
 *              td().label("footer text");
 *
 * </pre>
 *
 * Note that you can insert any component you like (as long as following xhtml rules) at any point.
 * Here's a brief example of creating a traditional (and not so recommended) border table layout:
 *
 * <br/>
 *
 * <pre>
 * table().
 *      tbody().
 *          tr().
 *              td().placeholder("north").up(3).
 *          tr().
 *              td().placeholder("west").up(2).
 *              td().placeholder("center").up(2).
 *              td().placeholder("east").up(3).
 *          tr().
 *              td().placeholder("south");
 * </pre>
 *
 * To access the layout you can do this:<br/>
 * <pre>get("center")</pre>
 *
 * Its also easy to store the placeholder in a variable and pass it around or make it inheritable.
 *
 * @author Henri Frilund
 */
public class Table extends RenderableComponent implements IContainer {
    private TableBlock header;
    private TableBlock footer;
    private TableBlock body;
    private Block caption;
    private List<TableBlock> colgroups;
    private TableBlock rows;
    private boolean modernMode;
    private boolean oldMode;

    Table(Component parent, String tableId) {
        super(parent, tableId);
    }

    @Override
    public TableBlock thead() {
        if (oldMode)
            throw new WheelException("When using table with only tr-elements, you can't create a thead-element.", this);

        if (header == null) {
            header = new TableBlock(this);
            header.renderHint("thead");
            add(header);
            modernMode = true;
        }

        return header;
    }

    @Override
    public TableBlock tfoot() {
        if (oldMode)
            throw new WheelException("When using table with only tr-elements, you can't create a tfoot-element.", this);

        if (footer == null) {
            footer = new TableBlock(this);
            footer.renderHint("tfoot");
            add(footer);
            modernMode = true;
        }

        return footer;
    }

    @Override
    public TableBlock tbody() {
        if (oldMode)
            throw new WheelException("When using table with only tr-elements, you can't create a tbody-element.", this);

        if (body == null) {
            body = new TableBlock(this);
            body.renderHint("tbody");
            add(body);
            modernMode = true;
        }

        return body;
    }

    @Override
    public Component caption() {
         if (caption == null) {
            caption = create().wBlock("caption");
            add(caption);
        }

        return caption;
    }

    @Override
    public TableBlock colgroup() {
        if (colgroups == null)
            colgroups = new LinkedList<TableBlock>();

        TableBlock colgroup = new TableBlock(this);
        colgroup.renderHint("colgroup");
        colgroups.add(colgroup);

        return colgroup;
    }

    public TableRow tr() {
        if (modernMode)
            throw new WheelException("When using table with thead, tfoot and tbody, you can't create rows directly under a table-component.", this);

        if (rows == null) {
            rows = new TableBlock(this);
            rows.config().setRenderSelf(false);
            oldMode = true;
        }


        TableRow tableRow = new TableRow(this);
        rows.add(tableRow);
        return tableRow;
    }


    public String defaultTagName() {
        return "table";
    }

    @Override
    public void renderComponent(XmlSerializer serializer) throws IOException {
        if (caption != null)
            caption._render(serializer);

        if (colgroups != null && colgroups.size() > 0) {
            for (TableBlock colgroup : colgroups) {
                colgroup._render(serializer);
            }
        }

        if (header != null)
            header._render(serializer);

        if (footer != null)
            footer._render(serializer);

        if (body != null)
            body._render(serializer);

        if (rows != null)
            rows._render(serializer);

    }


    @Override
    public Table id(String componentId) {
        return (Table)super.id(componentId);
    }


    @Override
    public Table renderHint(CharSequence renderHint) {
        return (Table)super.renderHint(renderHint);
    }

    @Override
    public synchronized void _clear() {
        super._clear();
        if (header != null)
            header._clear();

        if (body != null)
            body._clear();

        if (footer != null)
            footer._clear();

        if (caption != null)
            caption._clear();

        if (colgroups != null) {
            for (TableBlock colgroup : colgroups) {
                colgroup._clear();
            }
        }

    }
}
