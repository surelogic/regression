package xxx;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;

public class Test {
  @RegionLock("M1 is lockM1 protects m1")
  public class Middle1 {
    public final Object lockM1 = new Object();
    public int m1;
    
    @RequiresLock("M1")
    public void accessM1() {}
    
    public Middle1() {
      synchronized (lockM1) {
        final Object s3 = new Object() { 
        	{ Middle1.this.m1 = 10; }
          { Middle1.this.accessM1(); }  // should assure
        };
      }
    }
  }
}
