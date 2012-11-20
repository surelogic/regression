package test;

import java.util.concurrent.CopyOnWriteArrayList;

import com.surelogic.ThreadSafe;
import com.surelogic.Vouch;

@ThreadSafe
public class VouchThreadSafe {

  @Vouch("AnnotationBounds")
  private final CopyOnWriteArrayList<Runnable> foo = new CopyOnWriteArrayList<Runnable>();

  @Override
  public String toString() {
    return foo.toString();
  }
}
