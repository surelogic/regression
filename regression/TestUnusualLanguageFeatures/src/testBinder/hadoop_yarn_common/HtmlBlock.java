package testBinder.hadoop_yarn_common;

import java.io.PrintWriter;

import testBinder.extendsClause.*;

public abstract class HtmlBlock extends TextView implements SubView {

  public class Block extends Hamlet {
    Block(PrintWriter out, int level, boolean wasInline) {
      super(out, level, wasInline);
    }

    @Override
    protected void subView(Class<? extends SubView> cls) {
      context().set(nestLevel(), wasInline());
      render(cls);
      setWasInline(context().wasInline());
    }
  }

  private Block block;

  private Block block() {
    if (block == null) {
      block = new Block(writer(), context().nestLevel(), context().wasInline());
    }
    return block;
  }

  protected HtmlBlock() {
    this(null);
  }

  protected HtmlBlock(ViewContext ctx) {
    super(ctx, MimeType.HTML);
  }

  @Override
  public void render() {
    int nestLevel = context().nestLevel();
    //LOG.debug("Rendering {} @{}", getClass(), nestLevel);
    render(block());
    if (block.nestLevel() != nestLevel) {
      throw new WebAppException("Error rendering block: nestLevel="+
                                block.nestLevel() +" expected "+ nestLevel);
    }
    context().set(nestLevel, block.wasInline());
  }

  //@Override
  public void renderPartial() {
    render();
  }

  /**
   * Render a block of html. To be overridden by implementation.
   * @param html the block to render
   */
  protected abstract void render(Block html);
}
