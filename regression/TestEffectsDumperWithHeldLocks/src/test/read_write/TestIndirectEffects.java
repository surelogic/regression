package test.read_write;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
  @RegionLock("L1 is LOCK protects Y"),
  @RegionLock("L2 is LOCK protects Z")
})
public class TestIndirectEffects {
  public final ReadWriteLock LOCK = new ReentrantReadWriteLock();
  
  
  @UniqueInRegion("Instance into Instance, R into X, S into Y, T into Z")
  private final Other f = new Other();
  
  public void method(int v1, int v2) {
    LOCK.readLock().lock();
    try {
      // bad
      this.f.doStuff1(v1, v2); // needs lock this:L1 and this:L2
      // good
      this.f.doStuff2(v1, v2); // needs lock this:L1 and this:L2
    } finally {
      LOCK.readLock().unlock();
    }
    
    LOCK.writeLock().lock();
    try {
      // good
      this.f.doStuff1(v1, v2); // needs lock this:L1 and this:L2
      //bad
      this.f.doStuff2(v1, v2); // needs lock this:L1 and this:L2
    } finally {
      LOCK.writeLock().unlock();
    }
    
    // bad
    this.f.doStuff1(v1, v2); // needs lock this:L1 and this:L2
    // bad
    this.f.doStuff2(v1, v2); // needs lock this:L1 and this:L2
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
  public void doStuff1(int v1, int v2) {
    f1 = v1;
    f2 = v2;
  }
  
  @RegionEffects("reads R")
  public void doStuff2(int v1, int v2) {
    f1 = v1;
    f2 = v2;
  }
}