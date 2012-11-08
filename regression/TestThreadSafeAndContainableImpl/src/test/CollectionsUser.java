package test;

import java.util.ArrayList;
import java.util.List;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.UniqueInRegion;

@ThreadSafe
@Region("State")
@RegionLock("StateLock is this protects State")
public class CollectionsUser {

  /* This should be okay because it is a final field initialized to a new
   * containable type.  Originally the ThreadSafe analysis forgot to check
   * for this case, even though the Containable analysis does, and the ThreadSafe
   * analysis does when checking if the field is ThreadSafe.
   */
  @UniqueInRegion("State")
  private final List<String> f_strings = new ArrayList<String>();

  void m1() {
    synchronized (this) {
      f_strings.add("one");
      f_strings.add("two");
      System.out.println(f_strings.toString());
      f_strings.clear();
    }
  }
}
