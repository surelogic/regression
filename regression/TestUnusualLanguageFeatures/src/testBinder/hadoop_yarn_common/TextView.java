package testBinder.hadoop_yarn_common;

import java.io.PrintWriter;

public abstract class TextView extends View {

  private final String contentType;

  protected TextView(ViewContext ctx, String contentType) {
    super(ctx);
    this.contentType = contentType;
  }

  @Override 
  public PrintWriter writer() {
    response().setContentType(contentType);
    return super.writer();
  }

  /**
   * Print strings as is (no newline, a la php echo).
   * @param args the strings to print
   */
  public void echo(Object... args) {
    PrintWriter out = writer();
    for (Object s : args) {
      out.print(s);
    }
  }

  /**
   * Print strings as a line (new line appended at the end, a la C/Tcl puts).
   * @param args the strings to print
   */
  public void puts(Object... args) {
    echo(args);
    writer().println();
  }
}
