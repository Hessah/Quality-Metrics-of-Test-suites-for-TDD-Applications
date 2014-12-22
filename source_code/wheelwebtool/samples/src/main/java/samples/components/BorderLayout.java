package samples.components;

import wheel.components.Block;
import wheel.components.StandaloneComponent;

public class BorderLayout extends StandaloneComponent {
    private Block north;
    private Block west;
    private Block center;
    private Block east;
    private Block south;
    private String leftCol;
    private String centerCol;
    private String rightCol;

    public BorderLayout(String leftCol, String centerCol, String rightCol) {
        super(null);
        config().setRenderSelf(false);
        this.leftCol = leftCol;
        this.centerCol = centerCol;
        this.rightCol = rightCol;
    }

    public void buildComponent() {
        table().
            colgroup().
                col().attribute("width", leftCol).end().
                col().attribute("width", centerCol).end().
                col().attribute("width", rightCol).up(2).

            tbody().
                tr().
                    td().id("north").attribute("colspan", "3").
                        placeholder("north").
                end("tr").

                tr().
                    td().id("west").
                        placeholder("west").
                    end("td").
                    td().id("center").
                        placeholder("center").
                    end("td").
                    td().id("east").
                        placeholder("east").
                end("tr").

                tr().
                    td().id("south").attribute("colspan", "3").
                        placeholder("south");

        north = (Block)get("north");
        west = (Block)get("west");
        east = (Block)get("east");
        center = (Block)get("center");
        south = (Block)get("south");
    }

    public Block north() {
        return north;
    }

    public Block west() {
        return west;
    }

    public Block center() {
        return center;
    }

    public Block east() {
        return east;
    }

    public Block south() {
        return south;
    }
}
