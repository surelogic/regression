package test;

import java.util.concurrent.CopyOnWriteArrayList;

import com.surelogic.Vouch;

public class VouchParametersAndLocals {

  /**
   * Whole constructor
   */
  @Vouch("AnnotationBounds")
  public VouchParametersAndLocals() {
    CopyOnWriteArrayList<Runnable> asLocal = new CopyOnWriteArrayList<Runnable>();
    System.out.println(asLocal.toString());
  }

  /**
   * A parameter scoped vouch
   */
  public void asParam(@Vouch("AnnotationBounds") CopyOnWriteArrayList<Runnable> list) {
    System.out.println(list.toString());
  }

  /**
   * Whole method (only way to get the return value)
   */
  @Vouch("AnnotationBounds")
  public CopyOnWriteArrayList<Runnable> asReturn() {
    return new CopyOnWriteArrayList<Runnable>();
  }

  /**
   * A local variable scoped vouch
   */
  public void asLocal() {
    @Vouch("AnnotationBounds")
    CopyOnWriteArrayList<Runnable> asLocal = new CopyOnWriteArrayList<Runnable>();
    System.out.println(asLocal.toString());
  }

  /**
   * Whole method (only way to get the return value)
   */
  @Vouch("AnnotationBounds")
  public CopyOnWriteArrayList<Runnable> asReturnAndLocal() {
    CopyOnWriteArrayList<Runnable> asLocal = new CopyOnWriteArrayList<Runnable>();
    return asLocal;
  }
}
