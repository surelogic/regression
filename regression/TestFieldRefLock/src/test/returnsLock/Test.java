package test.returnsLock;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

/*
 * Test field:Lock with @ReturnsLock annotations. 
 */

public class Test {
  private final Other o2 = new Other();
  private final More m2 = new More();
  
  
  
  @RequiresLock("o2:OtherLock")
  public void m4() {}
  
  @RequiresLock("m2:L")
  public void mm() {}
  
  
  
  public void caller() {
    synchronized (o2) {
      m4();
    }
    
    synchronized (m2.lock){
      mm();
    }
  }
  
  
  
  @ReturnsLock("o2:OtherLock")
  public Object getLock1() {
    return o2; // good
  }

  @ReturnsLock("o2:OtherLock")
  public Object getLock2() {
    return m2; // bad
  }
  
  @ReturnsLock("m2:L")
  public Object getLock3() {
    return m2.lock; // good
  }
  
  @ReturnsLock("m2:L")
  public Object getLock4() {
    return o2; // bad
  }
}

@RegionLock("OtherLock is this protects Instance")
class Other {
}

@RegionLock("L is lock protects Instance") 
class More {
  public final Object lock = new Object();
}
