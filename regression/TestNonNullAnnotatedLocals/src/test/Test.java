package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Initialized;

/*
 * Previously we had a problem that local variables were being checked for
 * assignment compatibility even when they were unannotated.  This checks
 * that this is not the case.  The assignments to oo1, and oo2 should not
 * have any results in the JSure scan.  The assignments to pp1, pp2, qq1, qq2,
 * ss1, and ss2 are bad.  The assignments to rr1 and rr2 are good.  These should 
 * all have explicit result drops in the JSure scan.
 * 
 * We test the variable initializer and the assignment expression separately 
 * because they are processed as distinct syntactic entities.
 */
public class Test {
  public void testFieldRef(
      final boolean f, @Initialized(through="*") Other o3, @Initialized(through="Parent") Other o4) {
    Other oo1 = f ? o3 : o4; // no result
    Other oo2;
    oo2 = f ? o3 : o4; // no result
    
    @Nullable Other pp1 = f ? o3 : o4; // bad
    @Nullable Other pp2; // bad
    pp2 = f ? o3 : o4;
    
    @NonNull Other qq1 = f ? o3 : o4; // bad
    @NonNull Other qq2; // bad
    qq2 = f ? o3 : o4;
    
    @Initialized(through="*") Other rr1 = f ? o3 : o4; // good
    @Initialized(through="*") Other rr2;
    rr2 = f ? o3 : o4; // good
    
    @Initialized(through="Parent") Other ss1 = f ? o3 : o4; // bad / good
    @Initialized(through="Parent") Other ss2;
    ss2 = f ? o3 : o4; // bad / good
  }
}


class Parent {
}

class Other extends Parent {
  public static int s;
  public int f;
}

