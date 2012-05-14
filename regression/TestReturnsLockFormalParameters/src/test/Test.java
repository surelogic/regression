package test;

import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;

public class Test {
  @ReturnsLock("other:Lock")
  public Object method1(final Other other) {
    // Okay, other is final, nothing to check
  	return other;
  }

  @ReturnsLock("other:Lock")
  public Object method2(Other other) {
    // Okay, other is read, but not modified
    // Issue a warning to make the parameter final
    Object o = other;
    return other;
  }

  @ReturnsLock("other:Lock")
  public Object method3(Other other) {
    // BAD: other is modified
    other = new Other();
    return other;
  }
}

@RegionLock("Lock is this protects Instance")
class Other {
  
}