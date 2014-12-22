package functional.xhtml;

import functional.BaseTestPage;

public class XhtmlCreatePage extends BaseTestPage {
    public void buildComponent() {
        add(create().a());
        add(create().a().actionBinding("http://www.dilbert.com"));
        add(create().a("Dilbert").actionBinding("http://www.dilbert.com"));
        add(create().a().img("images/link.gif", "link image").end());
        add(create().a().text("Link text").end());
        add(create().a().attribute("name", "anchor"));
        add(create().a("anchor2").clasS("linkClass"));

        add(create().abbr().text("abbr").end());
        add(create().abbr("abbr2"));

        add(create().acronym().text("acronym").end());
        add(create().acronym("acronym2"));

        add(create().address().text("address").end());
        add(create().address("address2"));

        add(create().map("map1").
                area("shape", "rect", "coords", "0,0,82,126", "href", "sun.htm", "target", "_blank", "alt", "Sun").end().
                area("shape", "circle", "coords", "90,58,3", "href", "mercury.htm", "target", "_blank", "alt", "Mercury").end());

        add(create().b().text("b").end());
        add(create().b("b2"));

        head().add(create().base("http://www.foobar.com"));

        add(create().bdo("rtl").text("This text is right to left.").end());

        add(create().big().text("big").end());
        add(create().big("big2"));

        add(create().blockquote().text("blockquote").end());
        add(create().blockquote().
                p().
                text("Complex ").end().
                b("quotation ").end().
                text("text.").up(2));

        add(create().br().clasS("separator"));

        add(create().button().text("button"));

        add(create().cite().text("cite").end());
        add(create().cite("cite2"));

        add(create().table().id("table1").
            caption().text("table1 caption").up(2).
            colgroup().
                col().attributes("width", "33%").end().
                col().attributes("width", "30%").end().
                col().attributes("width", "36%").up(2));

        add(create().code().text("code").end());
        add(create().code("code2"));

        add(create().dl().
            dt().text("dt").up(2).
            dd().text("dd").up(2).
            dt("dt2").end().
            dd("dd2").end());

        add(create().del().text("del").end());
        add(create().del("del2"));

        add(create().dfn().text("dfn").end());
        add(create().dfn("dfn2"));

        add(create().div());
        add(create().div().p("div2").end());
        add(create().div().div().div().p("div3").up(3));

        add(create().em().text("em").end());
        add(create().em("em2"));

        add(create().form("form1").
            fieldset().
                textInput("input1").label("input1_label").value("input1_value").end().
                textarea("textarea").label("textarea_label").value("textarea_value").up(2));


        add(create().h1().text("h1").end());
        add(create().h1("h12"));

        add(create().h2().text("h2").end());
        add(create().h2("h22"));

        add(create().h3().text("h3").end());
        add(create().h3("h32"));

        add(create().h4().text("h4").end());
        add(create().h4("h42"));

        add(create().h5().text("h5").end());
        add(create().h5("h52"));

        add(create().h6().text("h6").end());
        add(create().h6("h62"));

        add(create().hr());

        add(create().i().text("i").end());
        add(create().i("i2"));

        add(create().iframe().attribute("src", "iframe.html"));

        add(create().img("images/test.gif", "Alt text").id("testImage"));

        add(create().ins().text("ins").end());
        add(create().ins("ins2"));

        add(create().kbd().text("kbd").end());
        add(create().kbd("kbd2"));

        add(create().form("form2").
                label("label1").attribute("for", "input2").end().
                textInput("input2").end());

        add(create().form("form3").
                fieldset().
                legend("legend").up(2));

        add(create().ol().
                li("li").end().
                li().p("li2").up(2).
                li().text("li3").up(2));

        head().add(create().link().attributes("rel", "bookmark", "href", "link.html"));

        head().add(create().meta().attributes("name", "keywords", "content", "html,javascript"));

        head().add(create().noscript().text("Your browser does not support JavaScript!").end());

        add(create().object().attributes("classid", "clsid:F08DF954-8592-11D1-B16A-00C0F0283628").id("slider1").
                param("BorderStyle", "1").end().
                param("Max", "10").end());

        add(create().p().id("p1").text("p").end());
        add(create().p("p2").id("p2"));

        add(create().pre().text("pre").end());
        add(create().pre("pre2"));

        add(create().q().text("q").end());
        add(create().q("q2"));

        add(create().s().text("s").end());
        add(create().s("s2"));

        add(create().samp().text("samp").end());
        add(create().samp("samp2"));

        head().add(create().script().attribute("type", "text/javascript").
                rawText("var foobar = \"value\";").end());

        add(create().script().attribute("type", "text/javascript").
                rawText("document.write(\"hello world.\");").end());

        add(create().small().text("small").end());
        add(create().small("small2"));

        add(create().span().text("span").end());
        add(create().span("span2"));

        add(create().strike().text("strike").end());
        add(create().strike("strike2"));

        add(create().strong().text("strong").end());
        add(create().strong("strong2"));

        head().add(create().style().attribute("type", "text/css").
                rawText("#TabbedPanelTabs {\n" +
                        "    float:left;\n" +
                        "    width:100%;\n" +
                        "    background:#EFF4FA;\n" +
                        "    font-size:93%;\n" +
                        "    line-height:normal;\n" +
                        "    border-bottom:1px solid #DD740B;").end());

        add(create().sub().text("sub").end());
        add(create().sub("sub2"));

        add(create().sup().text("sup").end());
        add(create().sup("sup2"));

        add(create().table().id("table2").
            tr().
                th().text("th1").up(2).
                th().text("th2").up(3).
            tr().
                td().text("td1").up(3).
            tr().
                td().text("td2").up(2).
                td().text("td3").up(4));

        add(create().table().id("table3").
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
                    td().text("td4").up(4));

        add(create().tt().text("tt").end());
        add(create().tt("tt2"));

        add(create().u().text("u").end());
        add(create().u("u2"));

        add(create().ul().
            li().text("li").up(2).
            li().text("li2").up(2));

        add(create().var().text("var").end());
        add(create().var("var2"));

    }
}
