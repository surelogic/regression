package testBinder.hadoop_yarn_common;

import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;

import testBinder.extendsClause.*;

/**
 * Base class for all views
 */
public abstract class View implements Params {
  public static final Logger LOG = LoggerFactory.getLogger(View.class);

  public static class ViewContext {
    final Controller.RequestContext rc;
    int nestLevel = 0;
    boolean wasInline;

    ViewContext(Controller.RequestContext ctx) {
      rc = ctx;
    }

    public int nestLevel() { return nestLevel; }
    public boolean wasInline() { return wasInline; }

    public void set(int nestLevel, boolean wasInline) {
      this.nestLevel = nestLevel;
      this.wasInline = wasInline;
    }

    public Controller.RequestContext requestContext() { return rc; }
  }

  private ViewContext vc;

  public View() {
    // Makes injection in subclasses optional.
    // Time will tell if this buy us more than the NPEs :)
  }

  public View(ViewContext ctx) {
    vc = ctx;
  }

  /**
   * The API to render the view
   */
  public abstract void render();

  public ViewContext context() {
    return vc;
  }

  public HttpServletResponse response() {
    return context().rc.response;
  }

  public Map<String, String> moreParams() {
    return context().rc.moreParams();
  }

  /**
   * Lookup a value from the current context.
   * @param key to lookup
   * @param defaultValue if key is missing
   * @return the value of the key or the default value
   */
  public String $(String key, String defaultValue) {
    // moreParams take precedence
    String value = moreParams().get(key);
    return value == null ? defaultValue : value;
  }

  /**
   * Lookup a value from the current context
   * @param key to lookup
   * @return the value of the key or empty string
   */
  public String $(String key) {
    return $(key, "");
  }

  /**
   * Set a context value. (e.g. UI properties for sub views.)
   * Try to avoid any application (vs view/ui) logic.
   * @param key to set
   * @param value to set
   */
  public void set(String key, String value) {
    moreParams().put(key, value);
  }

  public String root() {
	  return null;
  }
  
  public String prefix() {
    if(context().rc.prefix == null) {
      return root();
    } else {
      return ujoin(root(), context().rc.prefix);
    }
  }

  public void setTitle(String title) {
  }

  public void setTitle(String title, String url) {
  }

  /**
   * Create an url from url components
   * @param parts components to join
   * @return an url string
   */
  public String root_url(String... parts) {
    return ujoin(root(), parts);
  }

  
  /**
   * Create an url from url components
   * @param parts components to join
   * @return an url string
   */
  public String url(String... parts) {
    return ujoin(prefix(), parts);
  }

  private String ujoin(String prefix, String... parts) {
	// TODO Auto-generated method stub
	return null;
  }

/**
   * Render a sub-view
   * @param cls the class of the sub-view
   */
  public void render(Class<? extends SubView> cls) {
    int saved = context().nestLevel;
    if (context().nestLevel != saved) {
      throw new WebAppException("View "+ cls.getSimpleName() +" not complete");
    }
  }
  
  public PrintWriter writer() {
	  return null;
  }
}
