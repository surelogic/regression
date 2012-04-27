package testBinder.importSearchingForPkgsInSubTypes;

import java.io.PrintWriter;
import java.util.EnumSet;

/**
 * Was trying to search subtypes of HamletImpl for a package called EOpt
 */
import static testBinder.importSearchingForPkgsInSubTypes.HamletImpl.EOpt.*;


/**
 * A simple unbuffered generic hamlet implementation.
 *
 * Zero copy but allocation on every element, which could be
 * optimized to use a thread-local element pool.
 *
 * Prints HTML as it builds. So the order is important.
 */
public class HamletImpl extends HamletSpec {
  private static final String INDENT_CHARS = "  ";
  static final int S_ID = 0;
  static final int S_CLASS = 1;

  int nestLevel;
  int indents; // number of indent() called. mostly for testing.
  private final PrintWriter out;
  private final StringBuilder sb = new StringBuilder(); // not shared
  private boolean wasInline = false;

  /**
   * Element options. (whether it needs end tag, is inline etc.)
   */
  public enum EOpt {
    /** needs end(close) tag */
    ENDTAG,
    /** The content is inline */
    INLINE,
    /** The content is preformatted */
    PRE
  };

  public HamletImpl(PrintWriter out, int nestLevel, boolean wasInline) {
    this.out = out;
    this.nestLevel = nestLevel;
    this.wasInline = wasInline;
  }

  public int nestLevel() {
    return nestLevel;
  }

  public boolean wasInline() {
    return wasInline;
  }

  public void setWasInline(boolean state) {
    wasInline = state;
  }

  public PrintWriter getWriter() {
    return out;
  }

  protected void printStartTag(String name, EnumSet<EOpt> opts) {
    indent(opts);
    sb.setLength(0);
    out.print(sb.append('<').append(name).toString()); // for easier mock test
  }

  protected void indent(EnumSet<EOpt> opts) {
    if (opts.contains(INLINE) && wasInline) {
      return;
    }
    if (wasInline) {
      out.println();
    }
    wasInline = opts.contains(INLINE) || opts.contains(PRE);
    for (int i = 0; i < nestLevel; ++i) {
      out.print(INDENT_CHARS);
    }
    ++indents;
  }

  protected void printEndTag(String name, EnumSet<EOpt> opts) {
    if (!opts.contains(ENDTAG)) {
      return;
    }
    if (!opts.contains(PRE)) {
      indent(opts);
    } else {
      wasInline = opts.contains(INLINE);
    }
    sb.setLength(0);
    out.print(sb.append("</").append(name).append('>').toString()); // ditto
    if (!opts.contains(INLINE)) {
      out.println();
    }
  }
}
