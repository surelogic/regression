package test;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;

public class Test {
  @RequiresLock("other:Lock")
  public void method1(final Other other) {
    // Okay, other is final, nothing to check
  }

  @RequiresLock("other:Lock")
  public void method2(Other other) {
    // Okay, other is read, but not modified
    Object o = other;
  }

  @RequiresLock("other:Lock")
  public void method3(Other other) {
    // BAD: other is modified
    other = new Other();
  }
}

@RegionLock("Lock is this protects Instance")
class Other {
  
}