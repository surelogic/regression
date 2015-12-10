package test.intrinsic;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.UniqueInRegion;


// this, class, O.class, instance field, static field, other static field

@RegionLocks({
  @RegionLock("A is this protects x"),
  @RegionLock("B is this protects y"),
  @RegionLock("AggLock is this protects Agg"),
  @RegionLock("L1 is this protects Q1"),
  @RegionLock("L2 is this protects Q2")
})
@Regions({
  @Region("public Agg"),
  @Region("public Q1"),
  @Region("public Q2")
})
public class TestAggregation {
  private int x;
  private int y;
  
  @UniqueInRegion("Agg")
  private int[] array = new int[10];
  
  @UniqueInRegion("Instance into Instance, R1 into Q1, R2 into Q2")
  private final WWW sub = new WWW();

  
  
  public void doStuff() {
    synchronized (this) {
      array[0] = 1;
      this.sub.f1 = 10;
      this.sub.f2 = 20;
    }

    // unprotected
    array[0] = 1;
    this.sub.f1 = 10;
    this.sub.f2 = 20;
  }
  
  
  public void method(TestAggregation other) {
    TestAggregation alias = other;
    @SuppressWarnings("unused")
    int v = other.x + this.y;
    
    synchronized (alias) {
      alias.x = 10; // lock should name alias not other  Effect is on other.
    }

    // not protected
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
