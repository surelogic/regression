package test.read_write;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.RegionLock;

public class TestExternalVars {
  @RegionLock("CC_Lock is LOCK protects Instance")
  public static class CC { 
    public final ReadWriteLock LOCK = new ReentrantReadWriteLock();
    
    public int ggg;
  }
  
  
  
  public void method(final CC cc) {
    new Runnable() {
      public void run() {
        @SuppressWarnings("unused")
        int x;
        
        cc.LOCK.readLock().lock();
        try {
          cc.ggg = 10; // good
          x = cc.ggg; // bad
        } finally {
          cc.LOCK.readLock().unlock();
        }
        
        cc.LOCK.writeLock().lock();
        try {
          cc.ggg = 10; // good
          x = cc.ggg; // good
        } finally {
          cc.LOCK.writeLock().unlock();
        }
        
        cc.ggg = 10; // bad
        x = cc.ggg; // bad
      }
    };
  }
}
