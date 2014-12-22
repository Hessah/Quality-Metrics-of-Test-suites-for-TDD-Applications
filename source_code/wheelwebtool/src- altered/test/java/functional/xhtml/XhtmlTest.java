package functional.xhtml;

import wheel.testing.WheelFunctionalTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class XhtmlTest extends WheelFunctionalTestCase {
    @BeforeClass
    public static void setUp() {
        resetAll();
        setBasePackageForPages("functional.xhtml");
        setApplicationPackages("functional", "functional.xhtml");
        initialize();
    }

    @Test
    public void testBasicXhtmlTags() {
        reset();
        load("XhtmlPage");

        assertXpath("", "//a[1]");
        assertXpath("http://www.dilbert.com", "//a[2]/@href");
        assertXpath("http://www.dilbert.com", "//a[3]/@href");
        assertXpath("Dilbert", "//a[3]");
        assertXpath("/images/link.gif", "//a[4]/img/@src");
        assertXpath("Link text", "//a[5]");
        assertXpath("anchor", "//a[6]/@name");
        assertXpath("linkClass", "//a[7]/@class");

        assertXpath("abbr", "//abbr[1]");
        assertXpath("abbr2", "//abbr[2]");

        assertXpath("acronym", "//acronym[1]");
        assertXpath("acronym2", "//acronym[2]");

        assertXpath("address", "//address[1]");
        assertXpath("address2", "//address[2]");

        assertXpath("map1", "//map/@id");
        assertXpath("Sun", "//area[1]/@alt");
        assertXpath("sun.htm", "//area[1]/@href");
        assertXpath("rect", "//area[1]/@shape");
        assertXpath("0,0,82,126", "//area[1]/@coords");
        assertXpath("Mercury", "//area[2]/@alt");
        assertXpath("mercury.htm", "//area[2]/@href");
        assertXpath("circle", "//area[2]/@shape");
        assertXpath("90,58,3", "//area[2]/@coords");

        assertXpath("b", "//b[1]");
        assertXpath("b2", "//b[2]");

        assertXpath("http://www.foobar.com", "//head/base/@href");

        assertXpath("This text is right to left.", "//bdo");
        assertXpath("rtl", "//bdo/@dir");

        assertXpath("big", "//big[1]");
        assertXpath("big2", "//big[2]");

        assertXpath("blockquote", "//blockquote[1]");
        assertXpath("Complex quotation text.", "//blockquote[2]/p");
        assertXpath("quotation ", "//blockquote[2]/p/b");

        assertXpath("separator", "//br/@class");

        assertPresent("//button");

        assertXpath("cite", "//cite[1]");
        assertXpath("cite2", "//cite[2]");

        assertXpath("code", "//code[1]");
        assertXpath("code2", "//code[2]");

        assertXpath("table1 caption", "//table[@id='table1']/caption");
        assertXpath("33%", "//table[@id='table1']/colgroup/col[1]/@width");
        assertXpath("30%", "//table[@id='table1']/colgroup/col[2]/@width");
        assertXpath("36%", "//table[@id='table1']/colgroup/col[3]/@width");

        assertXpath("dt", "//dl/dt[1]");
        assertXpath("dt2", "//dl/dt[2]");
        assertXpath("dd", "//dl/dd[1]");
        assertXpath("dd2", "//dl/dd[2]");

        assertXpath("del", "//del[1]");
        assertXpath("del2", "//del[2]");

        assertXpath("dfn", "//dfn[1]");
        assertXpath("dfn2", "//dfn[2]");

        assertPresent("//div[1]");
        assertXpath("div2", "//div[2]/p");
        assertXpath("div3", "//div[3]/div/div/p");

        assertXpath("em", "//em[1]");
        assertXpath("em2", "//em[2]");

        assertXpath("input1_value", "//form[1]/fieldset/input[1]/@value");
        assertXpath("textarea_value", "//form[1]/fieldset/textarea");

        assertXpath("h1", "//h1[1]");
        assertXpath("h12", "//h1[2]");

        assertXpath("h2", "//h2[1]");
        assertXpath("h22", "//h2[2]");

        assertXpath("h3", "//h3[1]");
        assertXpath("h32", "//h3[2]");

        assertXpath("h4", "//h4[1]");
        assertXpath("h42", "//h4[2]");

        assertXpath("h5", "//h5[1]");
        assertXpath("h52", "//h5[2]");

        assertXpath("h6", "//h6[1]");
        assertXpath("h62", "//h6[2]");

        assertPresent("//hr");

        assertXpath("i", "//i[1]");
        assertXpath("i2", "//i[2]");

        assertXpath("iframe.html", "//iframe[1]/@src");

        assertXpath("/images/test.gif", "//img[@id='testImage']/@src");
        assertXpath("Alt text", "//img[@id='testImage']/@alt");

        assertXpath("ins", "//ins[1]");
        assertXpath("ins2", "//ins[2]");

        assertXpath("label1", "//form[@id='form2']/label");
        assertXpath("input2", "//form[@id='form2']/label/@for");

        assertXpath("legend", "//form[@id='form3']/fieldset/legend");

        assertXpath("li", "//ol[1]/li[1]");
        assertXpath("li2", "//ol[1]/li[2]/p");
        assertXpath("li3", "//ol[1]/li[3]");

        assertXpath("link.html", "//head/link[1]/@href");
        assertXpath("bookmark", "//head/link[1]/@rel");

        assertXpath("html,javascript", "//head/meta[2]/@content");
        assertXpath("keywords", "//head/meta[2]/@name");

        assertXpath("Your browser does not support JavaScript!", "//head/noscript");

        assertXpath("clsid:F08DF954-8592-11D1-B16A-00C0F0283628", "//object[1]/@classid");
        assertXpath("slider1", "//object[1]/@id");
        assertXpath("BorderStyle", "//object[1]/param[1]/@name");
        assertXpath("1", "//object[1]/param[1]/@value");
        assertXpath("Max", "//object[1]/param[2]/@name");
        assertXpath("10", "//object[1]/param[2]/@value");

        assertXpath("p", "//p[@id='p1']");
        assertXpath("p2", "//p[@id='p2']");

        assertXpath("pre", "//pre[1]");
        assertXpath("pre2", "//pre[2]");

        assertXpath("q", "//q[1]");
        assertXpath("q2", "//q[2]");

        assertXpath("s", "//s[1]");
        assertXpath("s2", "//s[2]");

        assertXpath("samp", "//samp[1]");
        assertXpath("samp2", "//samp[2]");

        assertXpath("var foobar = \"value\";", "//head/script[1]");
        assertXpath("document.write(\"hello world.\");", "//body/script[1]");

        assertXpath("small", "//small[1]");
        assertXpath("small2", "//small[2]");

        assertXpath("span", "//span[1]");
        assertXpath("span2", "//span[2]");

        assertXpath("strike", "//strike[1]");
        assertXpath("strike2", "//strike[2]");

        assertXpath("strong", "//strong[1]");
        assertXpath("strong2", "//strong[2]");

        assertXpath("#TabbedPanelTabs {\n" +
                "    float:left;\n" +
                "    width:100%;\n" +
                "    background:#EFF4FA;\n" +
                "    font-size:93%;\n" +
                "    line-height:normal;\n" +
                "    border-bottom:1px solid #DD740B;", "//head/style[1]");

        assertXpath("sub", "//sub[1]");
        assertXpath("sub2", "//sub[2]");

        assertXpath("sup", "//sup[1]");
        assertXpath("sup2", "//sup[2]");

        assertXpath("th1", "//table[@id='table2']/tr[1]/th[1]");
        assertXpath("th2", "//table[@id='table2']/tr[1]/th[2]");
        assertXpath("td1", "//table[@id='table2']/tr[2]/td[1]");
        assertXpath("td2", "//table[@id='table2']/tr[3]/td[1]");
        assertXpath("td3", "//table[@id='table2']/tr[3]/td[2]");

        assertXpath("th1", "//table[@id='table3']/thead/tr[1]/th[1]");
        assertXpath("th2", "//table[@id='table3']/thead/tr[1]/th[2]");
        assertXpath("td1", "//table[@id='table3']/tbody/tr[1]/td[1]");
        assertXpath("td2", "//table[@id='table3']/tbody/tr[1]/td[2]");
        assertXpath("td3", "//table[@id='table3']/tbody/tr[2]/td[1]");
        assertXpath("td4", "//table[@id='table3']/tfoot/tr[1]/td[1]");

        assertXpath("title", "//head/title");

        assertXpath("tt", "//tt[1]");
        assertXpath("tt2", "//tt[2]");

        assertXpath("u", "//u[1]");
        assertXpath("u2", "//u[2]");

        assertXpath("li", "//ul/li[1]");
        assertXpath("li2", "//ul/li[2]");

        assertXpath("var", "//var[1]");
        assertXpath("var2", "//var[2]");
    }

    @Test
    public void testFrames() {
        reset();
        load("FramesPage");

        assertXpath("33%, 33%, 33%", "//frameset/@cols");
        assertXpath("frame1.html", "//frameset/frame[1]/@src");
        assertXpath("frame2.html", "//frameset/frame[2]/@src");
        assertXpath("frame3.html", "//frameset/frame[3]/@src");
        assertXpath("Your browser doesn't handle frames.", "//frameset/noframes/body/p");
    }

    @Test
    public void testComponentCreator() {
        reset();
        load("XhtmlCreatePage");

        assertXpath("", "//a[1]");
        assertXpath("http://www.dilbert.com", "//a[2]/@href");
        assertXpath("http://www.dilbert.com", "//a[3]/@href");
        assertXpath("Dilbert", "//a[3]");
        assertXpath("/images/link.gif", "//a[4]/img/@src");
        assertXpath("Link text", "//a[5]");
        assertXpath("anchor", "//a[6]/@name");
        assertXpath("linkClass", "//a[7]/@class");

        assertXpath("abbr", "//abbr[1]");
        assertXpath("abbr2", "//abbr[2]");

        assertXpath("acronym", "//acronym[1]");
        assertXpath("acronym2", "//acronym[2]");

        assertXpath("address", "//address[1]");
        assertXpath("address2", "//address[2]");

        assertXpath("map1", "//map/@id");
        assertXpath("Sun", "//area[1]/@alt");
        assertXpath("sun.htm", "//area[1]/@href");
        assertXpath("rect", "//area[1]/@shape");
        assertXpath("0,0,82,126", "//area[1]/@coords");
        assertXpath("Mercury", "//area[2]/@alt");
        assertXpath("mercury.htm", "//area[2]/@href");
        assertXpath("circle", "//area[2]/@shape");
        assertXpath("90,58,3", "//area[2]/@coords");

        assertXpath("b", "//b[1]");
        assertXpath("b2", "//b[2]");

        assertXpath("http://www.foobar.com", "//head/base/@href");

        assertXpath("This text is right to left.", "//bdo");
        assertXpath("rtl", "//bdo/@dir");

        assertXpath("big", "//big[1]");
        assertXpath("big2", "//big[2]");

        assertXpath("blockquote", "//blockquote[1]");
        assertXpath("Complex quotation text.", "//blockquote[2]/p");
        assertXpath("quotation ", "//blockquote[2]/p/b");

        assertXpath("separator", "//br/@class");

        assertPresent("//button");

        assertXpath("cite", "//cite[1]");
        assertXpath("cite2", "//cite[2]");

        assertXpath("code", "//code[1]");
        assertXpath("code2", "//code[2]");

        assertXpath("table1 caption", "//table[@id='table1']/caption");
        assertXpath("33%", "//table[@id='table1']/colgroup/col[1]/@width");
        assertXpath("30%", "//table[@id='table1']/colgroup/col[2]/@width");
        assertXpath("36%", "//table[@id='table1']/colgroup/col[3]/@width");

        assertXpath("dt", "//dl/dt[1]");
        assertXpath("dt2", "//dl/dt[2]");
        assertXpath("dd", "//dl/dd[1]");
        assertXpath("dd2", "//dl/dd[2]");

        assertXpath("del", "//del[1]");
        assertXpath("del2", "//del[2]");

        assertXpath("dfn", "//dfn[1]");
        assertXpath("dfn2", "//dfn[2]");

        assertPresent("//div[1]");
        assertXpath("div2", "//div[2]/p");
        assertXpath("div3", "//div[3]/div/div/p");

        assertXpath("em", "//em[1]");
        assertXpath("em2", "//em[2]");

        assertXpath("input1_value", "//form[1]/fieldset/input[1]/@value");
        assertXpath("textarea_value", "//form[1]/fieldset/textarea");

        assertXpath("h1", "//h1[1]");
        assertXpath("h12", "//h1[2]");

        assertXpath("h2", "//h2[1]");
        assertXpath("h22", "//h2[2]");

        assertXpath("h3", "//h3[1]");
        assertXpath("h32", "//h3[2]");

        assertXpath("h4", "//h4[1]");
        assertXpath("h42", "//h4[2]");

        assertXpath("h5", "//h5[1]");
        assertXpath("h52", "//h5[2]");

        assertXpath("h6", "//h6[1]");
        assertXpath("h62", "//h6[2]");

        assertPresent("//hr");

        assertXpath("i", "//i[1]");
        assertXpath("i2", "//i[2]");

        assertXpath("iframe.html", "//iframe[1]/@src");

        assertXpath("/images/test.gif", "//img[@id='testImage']/@src");
        assertXpath("Alt text", "//img[@id='testImage']/@alt");

        assertXpath("ins", "//ins[1]");
        assertXpath("ins2", "//ins[2]");

        assertXpath("label1", "//form[@id='form2']/label");
        assertXpath("input2", "//form[@id='form2']/label/@for");

        assertXpath("legend", "//form[@id='form3']/fieldset/legend");

        assertXpath("li", "//ol[1]/li[1]");
        assertXpath("li2", "//ol[1]/li[2]/p");
        assertXpath("li3", "//ol[1]/li[3]");

        assertXpath("link.html", "//head/link[1]/@href");
        assertXpath("bookmark", "//head/link[1]/@rel");

        assertXpath("html,javascript", "//head/meta[2]/@content");
        assertXpath("keywords", "//head/meta[2]/@name");

        assertXpath("Your browser does not support JavaScript!", "//head/noscript");

        assertXpath("clsid:F08DF954-8592-11D1-B16A-00C0F0283628", "//object[1]/@classid");
        assertXpath("slider1", "//object[1]/@id");
        assertXpath("BorderStyle", "//object[1]/param[1]/@name");
        assertXpath("1", "//object[1]/param[1]/@value");
        assertXpath("Max", "//object[1]/param[2]/@name");
        assertXpath("10", "//object[1]/param[2]/@value");

        assertXpath("p", "//p[@id='p1']");
        assertXpath("p2", "//p[@id='p2']");

        assertXpath("pre", "//pre[1]");
        assertXpath("pre2", "//pre[2]");

        assertXpath("q", "//q[1]");
        assertXpath("q2", "//q[2]");

        assertXpath("s", "//s[1]");
        assertXpath("s2", "//s[2]");

        assertXpath("samp", "//samp[1]");
        assertXpath("samp2", "//samp[2]");

        assertXpath("var foobar = \"value\";", "//head/script[1]");
        assertXpath("document.write(\"hello world.\");", "//body/script[1]");

        assertXpath("small", "//small[1]");
        assertXpath("small2", "//small[2]");

        assertXpath("span", "//span[1]");
        assertXpath("span2", "//span[2]");

        assertXpath("strike", "//strike[1]");
        assertXpath("strike2", "//strike[2]");

        assertXpath("strong", "//strong[1]");
        assertXpath("strong2", "//strong[2]");

        assertXpath("#TabbedPanelTabs {\n" +
                "    float:left;\n" +
                "    width:100%;\n" +
                "    background:#EFF4FA;\n" +
                "    font-size:93%;\n" +
                "    line-height:normal;\n" +
                "    border-bottom:1px solid #DD740B;", "//head/style[1]");

        assertXpath("sub", "//sub[1]");
        assertXpath("sub2", "//sub[2]");

        assertXpath("sup", "//sup[1]");
        assertXpath("sup2", "//sup[2]");

        assertXpath("th1", "//table[@id='table2']/tr[1]/th[1]");
        assertXpath("th2", "//table[@id='table2']/tr[1]/th[2]");
        assertXpath("td1", "//table[@id='table2']/tr[2]/td[1]");
        assertXpath("td2", "//table[@id='table2']/tr[3]/td[1]");
        assertXpath("td3", "//table[@id='table2']/tr[3]/td[2]");

        assertXpath("th1", "//table[@id='table3']/thead/tr[1]/th[1]");
        assertXpath("th2", "//table[@id='table3']/thead/tr[1]/th[2]");
        assertXpath("td1", "//table[@id='table3']/tbody/tr[1]/td[1]");
        assertXpath("td2", "//table[@id='table3']/tbody/tr[1]/td[2]");
        assertXpath("td3", "//table[@id='table3']/tbody/tr[2]/td[1]");
        assertXpath("td4", "//table[@id='table3']/tfoot/tr[1]/td[1]");

        assertXpath("tt", "//tt[1]");
        assertXpath("tt2", "//tt[2]");

        assertXpath("u", "//u[1]");
        assertXpath("u2", "//u[2]");

        assertXpath("li", "//ul/li[1]");
        assertXpath("li2", "//ul/li[2]");

        assertXpath("var", "//var[1]");
        assertXpath("var2", "//var[2]");
    }
}
