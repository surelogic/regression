package test;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;

@Region("public R")
@RegionLock("L is this protects R")
public class Test {
  public class Inner {
    @RequiresLock("Test.this:L")
    public void method() {
      // do stuff
    }
    
    public void caller1() {
      synchronized (Test.this) {
        method();
      }
    }
  }
  
  
  public void caller2(final Inner i, final Test t) {
    i.method();
    
    final Inner i2 = this. new Inner();
    synchronized (this) {
      i2.method();
    }
    
    final Inner i3 = t. new Inner();
    synchronized (t) {
      i3.method();
    }
  }
}
