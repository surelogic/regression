package test.jucLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.UniqueInRegion;


// this, class, O.class, instance field, static field, other static field

@RegionLocks({
  @RegionLock("A is LOCK protects x"),
  @RegionLock("B is LOCK protects y"),
  @RegionLock("AggLock is LOCK protects Agg"),
  @RegionLock("L1 is LOCK protects Q1"),
  @RegionLock("L2 is LOCK protects Q2")
})
@Regions({
  @Region("public Agg"),
  @Region("public Q1"),
  @Region("public Q2")
})
public class TestAggregation {
  public final Lock LOCK = new ReentrantLock();

  private int x;
  private int y;
  
  @UniqueInRegion("Agg")
  private int[] array = new int[10];
  
  @UniqueInRegion("Instance into Instance, R1 into Q1, R2 into Q2")
  private final WWW sub = new WWW();

  
  
  public void doStuff() {
    @SuppressWarnings("unused")
    int x;
    
    LOCK.lock();
    try {
      array[0] = 1; // good
      x = array[1]; // good
      
      this.sub.f1 = 10; // good
      x = this.sub.f1; // good
      
      this.sub.f2 = 20; // good
      x = this.sub.f2; // good
    } finally {
      LOCK.unlock();
    }
    
    array[0] = 1; // bad
    x = array[1]; // bad
    
    this.sub.f1 = 10; // bad
    x = this.sub.f1; // bad
    
    this.sub.f2 = 20; // bad
    x = this.sub.f2; // bad
  }
  
  
  public void method(TestAggregation other) {
    TestAggregation alias = other;
    @SuppressWarnings("unused")
    int v = other.x + this.y;
    
    alias.LOCK.lock();
    try {
      alias.x = 10; // lock should name alias not other  Effect is on other.
    } finally {
      alias.LOCK.unlock();
    }

    alias.x = 10; // lock should name alias not other  Effect is on other.
  }
}



@Regions({
  @Region("public R1"),
  @Region("public R2")
})
class WWW {
  @InRegion("R1")
  public int f1;
  
  @InRegion("R2")
  public int f2;
}
