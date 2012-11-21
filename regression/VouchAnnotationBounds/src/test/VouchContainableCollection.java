package test;

import java.util.ArrayList;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.UniqueInRegion;
import com.surelogic.Vouch;

@ThreadSafe
@Region("State")
@RegionLock("StateLock is this protects State")
public class VouchContainableCollection {

  @Vouch("AnnotationBounds")
  @UniqueInRegion("State")
  private final ArrayList<Runnable> f_tasks = new ArrayList<Runnable>();

  void m1() {
    synchronized (this) {
      f_tasks.add(new Thread());
      f_tasks.add(new Thread());
      System.out.println(f_tasks.toString());
      f_tasks.clear();
    }
  }
}
