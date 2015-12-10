package test.intrinsic;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionEffects;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.UniqueInRegion;

@Regions({
  @Region("public X"),
  @Region("public Y extends X"),
  @Region("public Z extends X")
})
@RegionLocks({
  @RegionLock("L1 is this protects Y"),
  @RegionLock("L2 is this protects Z")
})
public class TestIndirectEffects {
  @UniqueInRegion("Instance into Instance, R into X, S into Y, T into Z")
  private final Other f = new Other();
  
  public void method(int v1, int v2) {
    synchronized (this) {
      this.f.doStuff(v1, v2); // needs lock this:L1 and this:L2
    }
    // unprotected 
    this.f.doStuff(v1, v2); // needs lock this:L1 and this:L2
  }
}


@Regions({
  @Region("public R"),
  @Region("public S extends R"),
  @Region("public T extends R")
})
class Other {
  @InRegion("S")
  private int f1;
  
  @InRegion("T")
  private int f2;
  
  @RegionEffects("writes R")
  public void doStuff(int v1, int v2) {
    f1 = v1;
    f2 = v2;
  }
}