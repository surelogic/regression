package test;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;
import com.surelogic.ReturnsLock;

/**
 * Test that we flag cases where java.util.concurrent.locks.Lock objects are 
 * used with synchronized statements.  
 */
@Region("R")
@RegionLock("Exists is this protects R")
public class Test {
	@InRegion("R")
	private int f;
	
  /**
   * GOOD: parameter exists; lock exists; param is final
   */
  @ReturnsLock("p:Exists" /* is CONSISTENT */)
  public Object getLock_param_good(final Test p) {
    return p;
  }
  
  public void method(Test other) {
  	final Test t = new Test();
  	
  	synchronized (getLock_param_good(other)) {
  		other.f = 1;
  	}
  	
  	synchronized (getLock_param_good(t)) {
  		t.f = 2;
  	}
  	
  	synchronized (getLock_param_good(this)) {
  		this.f = 3;
  	}
  }
  
  @RequiresLock("p:Exists")
  public void doStuff(final Test p) {
  	p.f = 10;
  }
  
  @RequiresLock("q:Exists")
  public void doMore(final Test q) {
  	doStuff(q);
  }
}
