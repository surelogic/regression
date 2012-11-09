package threadSafe.testClasses;

import immutable.helpers.C;
import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.ThreadSafe;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.UniqueInRegion;

@ThreadSafe(staticPart="ThreadSafe")
@Region("public static S")
@RegionLock("L is class protects S")
public class StaticPartThreadSafe {
  public static final int x = 0; // good
  public static final Other o = null; // bad
  public static final int[] a = new int[] { 0, 1, 2 }; // bad
  public static final I i = null; // good
  
  public static final TS ts = null; // good
  
  @UniqueInRegion("S")
  public static final C agg = new C();
}
