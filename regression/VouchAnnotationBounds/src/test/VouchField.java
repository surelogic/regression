package test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.surelogic.Vouch;

public class VouchField {

  /**
   * Should vouch both the field type and the new expression
   */
  @Vouch("AnnotationBounds")
  public CopyOnWriteArrayList<Runnable> foo = new CopyOnWriteArrayList<Runnable>();

  /**
   * Should vouch just the new expression
   */
  @Vouch("AnnotationBounds")
  public List<Runnable> bar = new CopyOnWriteArrayList<Runnable>();

}
