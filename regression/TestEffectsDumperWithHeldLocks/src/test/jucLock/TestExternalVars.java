package test.jucLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.RegionLock;

public class TestExternalVars {
  @RegionLock("CC_Lock is LOCK protects Instance")
  public static class CC { 
    public final Lock LOCK = new ReentrantLock();
    
    public int ggg;
  }
  
  
  
  public void method(final CC cc) {
    new Runnable() {
      public void run() {
        @SuppressWarnings("unused")
        int x;
        
        cc.LOCK.lock();
        try {
          cc.ggg = 10; // good
          x = cc.ggg; // good
        } finally {
          cc.LOCK.unlock();
        }
        
        cc.ggg = 10; // bad
        x = cc.ggg; // bad
      }
    };
  }
}
