package test.usecase;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;

/**
 * The original example that spurned the need for being able to name 
 * final fields in locks.  This kind of thing happens a lot in 
 * Android code.
 */

@RegionLock("Lock is this protects Instance")
public class Outer {
  @RequiresLock("Lock") // Good
  void doSomething() {
  }

  class Inner {
    @RequiresLock("Outer.this:Lock") // Good
    void callService() {
      doSomething();
    }
  }
}

class Other {
  final Outer service = null;

  void baz() {
    synchronized (service) {
      callService();
    }
  }

  /* This is the new feature, requiring that the lock on the 
   * field this.service be held before calling this method.
   */
  @RequiresLock("service:Lock") // Good
  void callService() {
    service.doSomething();
  }
}
