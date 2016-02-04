package test;

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
        cc.ggg = 10;
      }
    };
  }
}
