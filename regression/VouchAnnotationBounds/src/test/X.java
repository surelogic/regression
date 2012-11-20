package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.Vouch;

@RegionLock("L is this protects Instance")
public class X {
  private int f;
  
  @Vouch("shazam")
  public X(X other) {
    other.foo();
  }
  
  public synchronized void n() {
    f = 2; // good
  }
  
  @Vouch("shazam")
  public void o() {
    f = 3; // bad, but vouched for
  }
  
  @RequiresLock("L")
  public void foo() {}
  
  @Vouch("shazam")
  public Object xx() {
    return new V<Runnable>();
  }
}

@AnnotationBounds(referenceObject="E")
class V<E> {}