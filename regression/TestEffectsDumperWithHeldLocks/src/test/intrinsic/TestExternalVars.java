package test.intrinsic;

import com.surelogic.RegionLock;

public class TestExternalVars {
  @RegionLock("CC_Lock is this protects Instance")
  public static class CC { 
    public int ggg;
  }
  
  
  
  public void method(final CC cc) {
    new Runnable() {
      public void run() {
        synchronized (cc) {
          cc.ggg = 10; // needs lock on cc even though effect is AnyInstance
        }
        // unprotected 
        cc.ggg = 10; // needs lock on cc even though effect is AnyInstance
      }
    };
  }
}
