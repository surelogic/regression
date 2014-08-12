package testSynchronized;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

@RegionLock("Lock is this protects Instance")
public class Wrapper {
  private int value;
  
  @Borrowed("this")
  public Wrapper(int v) {
    value = v;
  }
  
  @RequiresLock("Lock")
  public int get() {
    return value;
  }
  
  @RequiresLock("Lock")
  public void set(int v) {
    value = v;
  }
  
  @ReturnsLock("Lock")
  public Object getLock() {
    return this;
  }
}
