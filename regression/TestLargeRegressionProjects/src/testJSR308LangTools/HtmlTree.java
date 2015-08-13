package testJSR308LangTools;

public class HtmlTree extends Content {
    public HtmlTree(HtmlTag tag, Content... contents) {
    }
	
    public static HtmlTree HTML(String lang, Content head, Content body) {
        HtmlTree htmltree = new HtmlTree(HtmlTag.HTML, nullCheck(head), nullCheck(body));
        //htmltree.addAttr(HtmlAttr.LANG, nullCheck(lang));
        return htmltree;
    }
}
