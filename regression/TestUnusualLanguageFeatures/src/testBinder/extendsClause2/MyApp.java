package testBinder.extendsClause2;

import testBinder.extendsClause.HtmlPage;

/**
 * The embedded UI serves two pages at:
 * <br>http://localhost:8888/my and
 * <br>http://localhost:8888/my/anythingYouWant
 */
public class MyApp {

  // This is an app API
  public String anyAPI() { return "anything , really!"; }

  /*
  // Note this is static so it can be in any files.
  public static class MyController extends Controller {
    final MyApp app;

    // The app injection is optional
    @Inject MyController(MyApp app, RequestContext ctx) {
      super(ctx);
      this.app = app;
    }

    @Override
    public void index() {
      set("anything", "something ");
    }

    public void anythingYouWant() {
      set("anything", app.anyAPI());
    }
  }
  */

  // Ditto
  public static class MyView extends HtmlPage {
    // You can inject the app in views if needed.
    @Override
    public void render(Page.HTML<_> html) {
      html.
        title("My App").
        p("#content_id_for_css_styling").
          _("You can have", $("anything"))._()._();
      // Note, there is no _(); (to parent element) method at root level.
      // and IDE provides instant feedback on what level you're on in
      // the auto-completion drop-downs.
    }

	private String $(String string) {
		// TODO Auto-generated method stub
		return null;
	}
  }

  /*
  public static void main(String[] args) throws Exception {
    WebApps.$for(new MyApp()).at(8888).inDevMode().start().joinThread();
  }
  */
}
