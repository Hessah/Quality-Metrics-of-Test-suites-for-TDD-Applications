package functional.xhtml;

import functional.BaseTestPage;

public class XhtmlPage extends BaseTestPage {
    public void buildComponent() {
        a();
        a().actionBinding("http://www.dilbert.com");
        a("Dilbert").actionBinding("http://www.dilbert.com");
        a().img("images/link.gif", "link image");
        a().text("Link text");
        a().attribute("name", "anchor");
        a("anchor2").clasS("linkClass");

        abbr().text("abbr");
        abbr("abbr2");

        acronym().text("acronym");
        acronym("acronym2");

        address().text("address");
        address("address2");

        map("map1").
            area("shape", "rect", "coords", "0,0,82,126", "href", "sun.htm", "target", "_blank", "alt", "Sun").end().
            area("shape", "circle", "coords", "90,58,3", "href", "mercury.htm", "target", "_blank", "alt", "Mercury");

        b().text("b");
        b("b2");

        head().base("http://www.foobar.com");

        bdo("rtl").text("This text is right to left.");

        big().text("big");
        big("big2");

        blockquote().text("blockquote");
        blockquote().
            p().
                text("Complex ").end().
                b("quotation ").end().
                text("text.");

        br().clasS("separator");

        button().text("button");

        cite().text("cite");
        cite("cite2");

        table().id("table1").
                caption().text("table1 caption").up(2).
                colgroup().
                    col().attributes("width", "33%").end().
                    col().attributes("width", "30%").end().
                    col().attributes("width", "36%");

        code().text("code");
        code("code2");

        dl().
            dt().text("dt").end("dt").
            dd().text("dd").end("dd").
            dt("dt2").end().
            dd("dd2");

        del().text("del");
        del("del2");

        dfn().text("dfn");
        dfn("dfn2");

        div();
        div().p("div2");
        div().div().div().p("div3");

        em().text("em");
        em("em2");

        form("form1").
            fieldset().
                textInput("input1").label("input1_label").value("input1_value").end().
                textarea("textarea").label("textarea_label").value("textarea_value");


        h1().text("h1");
        h1("h12");

        h2().text("h2");
        h2("h22");

        h3().text("h3");
        h3("h32");

        h4().text("h4");
        h4("h42");

        h5().text("h5");
        h5("h52");

        h6().text("h6");
        h6("h62");

        hr();

        i().text("i");
        i("i2");

        iframe().attribute("src", "iframe.html");

        img("images/test.gif", "Alt text").id("testImage");

        ins().text("ins");
        ins("ins2");

        kbd().text("kbd");
        kbd("kbd2");

        form("form2").
                label("label1").attribute("for", "input2").end().
                textInput("input2");

        form("form3").
                fieldset().
                    legend("legend");

        ol().
                li("li").end().
                li().p("li2").up(2).
                li().text("li3");

        head().link().attributes("rel", "bookmark", "href", "link.html");

        head().meta().attributes("name", "keywords", "content", "html,javascript");

        head().noscript().text("Your browser does not support JavaScript!");

        object().attributes("classid", "clsid:F08DF954-8592-11D1-B16A-00C0F0283628").id("slider1").
                param("BorderStyle", "1").end().
                param("Max", "10");

        p().id("p1").text("p");
        p("p2").id("p2");

        pre().text("pre");
        pre("pre2");

        q().text("q");
        q("q2");

        s().text("s");
        s("s2");

        samp().text("samp");
        samp("samp2");

        head().script().attribute("type", "text/javascript").
                rawText("var foobar = \"value\";");

        script().attribute("type", "text/javascript").
                rawText("document.write(\"hello world.\");");

        small().text("small");
        small("small2");

        span().text("span");
        span("span2");

        strike().text("strike");
        strike("strike2");

        strong().text("strong");
        strong("strong2");

        head().style().attribute("type", "text/css").
                rawText("#TabbedPanelTabs {\n" +
                        "    float:left;\n" +
                        "    width:100%;\n" +
                        "    background:#EFF4FA;\n" +
                        "    font-size:93%;\n" +
                        "    line-height:normal;\n" +
                        "    border-bottom:1px solid #DD740B;");
        
        sub().text("sub");
        sub("sub2");

        sup().text("sup");
        sup("sup2");

        table().id("table2").
                tr().
                    th().text("th1").up(2).
                    th().text("th2").up(3).
                tr().
                    td().text("td1").up(3).
                tr().
                    td().text("td2").up(2).
                    td().text("td3");

        table().id("table3").
                thead().
                    tr().
                        th().text("th1").up(2).
                        th().text("th2").up(4).
                tbody().
                    tr().
                        td().text("td1").up(2).
                        td().text("td2").up(3).
                    tr().
                        td().text("td3").up(4).
                tfoot().
                    tr().
                        td().text("td4");

        head().title("title");

        tt().text("tt");
        tt("tt2");

        u().text("u");
        u("u2");

        ul().
                li().text("li").up(2).
                li().text("li2");

        var().text("var");
        var("var2");

    }
}
