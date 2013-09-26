package test.returnsLock2;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

public class TestUseOfReturnedLock {
  private final Other o2 = new Other();

  @ReturnsLock("o2:OtherLock")
  public Object getLock1() {
    return o2; // good
  }
  
  @RequiresLock("o2:OtherLock")
  public void needsLock() {}
  
  
  
  public static void doStuff(final TestUseOfReturnedLock a, final TestUseOfReturnedLock b) {
    synchronized (a.getLock1()) {
      a.needsLock(); // good
    }

    synchronized (b.getLock1()) {
      b.needsLock(); // good
    }

    synchronized (b.getLock1()) {
      a.needsLock(); // bad
    }

    synchronized (a.getLock1()) {
      b.needsLock(); // bad
    }
}
}

@RegionLock("OtherLock is this protects Instance")
class Other {
}
