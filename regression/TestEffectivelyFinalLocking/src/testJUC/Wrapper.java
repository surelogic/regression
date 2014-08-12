package testJUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

@RegionLock("Lock is lock protects Instance")
public class Wrapper {
  private final Lock lock = new ReentrantLock();
  
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
  public Lock getLock() {
    return lock;
  }
}
