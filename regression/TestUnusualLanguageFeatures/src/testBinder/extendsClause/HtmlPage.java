package testBinder.extendsClause;
//package org.apache.hadoop.yarn.webapp.view;

import java.io.PrintWriter;
import java.util.EnumSet;

import testBinder.extendsClause2.Hamlet;
import testBinder.extendsClause2.TextView;

/**
 * The parent class of all HTML pages.  Override 
 * {@link #render(testBinder.unknownProblem2b.apache.hadoop.yarn.webapp.hamlet.Hamlet.HTML)}
 * to actually render the page.
 */
public abstract class HtmlPage extends TextView {

  public static class _ implements Hamlet._ {
  }

  public class Page extends Hamlet {
    Page(PrintWriter out) {
      super(out, 0, false);
    }

    @Override
    protected void subView(Class<? extends SubView> cls) {
      context().set(nestLevel(), wasInline());
      render(cls);
      setWasInline(context().wasInline());
    }

    public HTML<HtmlPage._> html() {
      return new HTML<HtmlPage._>("html", null, EnumSet.of(EOpt.ENDTAG));
    }
  }

  public static final String DOCTYPE =
      "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\""+
      " \"http://www.w3.org/TR/html4/strict.dtd\">";

  private Page page;

  private Page page() {
    if (page == null) {
      page = new Page(writer());
    }
    return page;
  }

  protected HtmlPage() {
    this(null);
  }

  protected HtmlPage(ViewContext ctx) {
    super(ctx, MimeType.HTML);
  }

  @Override
  public void render() {
    puts(DOCTYPE);
    render(page().html().meta_http("Content-type", MimeType.HTML));
    if (page().nestLevel() != 0) {
      throw new WebAppException("Error rendering page: nestLevel="+
                                page().nestLevel());
    }
  }

/**
   * Render the the HTML page.
   * @param html the page to render data to.
   */
  protected abstract void render(Page.HTML<_> html);
}

