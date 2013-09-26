package test.sanity;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

/**
 * Test the sanity checking of <field>:Lock
 */

public class TestSanityChecking {
  private static Other s1 = new Other();
  private static final Other s2 = new Other();
  private Other o1 = new Other();
  private final Other o2 = new Other();

  private final int intF = 0;

  
  
  @RequiresLock("s1:OtherLock")
  public void m1() {}
  
  @RequiresLock("s2:OtherLock")
  public void m2() {}
  
  @RequiresLock("o1:OtherLock")
  public void m3() {}
  
  @RequiresLock("o2:OtherLock")
  public void m4() {}
  
  @RequiresLock("o2:NoSuchLock")
  public void m5() {}
  
  @RequiresLock("intF:Crap")
  public void m6() {}
  
  
  
  @ReturnsLock("s1:OtherLock")
  public Object r1() { return null; }
  
  @ReturnsLock("s2:OtherLock")
  public Object r2() { return null; }
  
  @ReturnsLock("o1:OtherLock")
  public Object r3() { return null; }
  
  @ReturnsLock("o2:OtherLock")
  public Object r4() { return null; }
  
  @ReturnsLock("o2:NoSuchLock")
  public Object r5() { return null; }
  
  @ReturnsLock("intF:Crap") // crashes binder?
  public Object r6() { return null; }
}

@RegionLock("OtherLock is this protects Instance")
class Other {
}
