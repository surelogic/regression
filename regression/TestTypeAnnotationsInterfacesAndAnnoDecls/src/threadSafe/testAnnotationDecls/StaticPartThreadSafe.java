package threadSafe.testAnnotationDecls;

import immutable.helpers.C;
import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.UniqueInRegion;

@ThreadSafe(staticPart="ThreadSafe")
@Region("public static S")
@RegionLock("L is class protects S")
public @interface StaticPartThreadSafe {
  public static int x = 0; // good
  public static Other o = null; // bad
  public static int[] a = new int[] { 0, 1, 2 }; // bad
  public static I i = null; // good
  
  public static TS ts = null; // good
  
  @UniqueInRegion("S")
  public static C agg = new C();
}
