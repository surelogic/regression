package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Initialized;

public class Test {
  private @Nullable Integer f1 = new Integer(0);
  private @NonNull Integer f2 = new Integer(0);
  
  public static @Nullable Float getFloat1() { return null; }
  public static @NonNull Float getFloat2() { return new Float(0.0f); }
  
  public static @Nullable int[] getArray1() { return new int[0]; }
  public static @NonNull int[] getArray2() { return new int[0]; }
  
  public static @Nullable Other getOther1() { return new Other(); }
  public static @Nullable Integer getInteger1() { return new Integer(0); }
  
  
  
  @SuppressWarnings("unused")
  public void testUnbox(final @Nullable Long p1, final @NonNull Long p2, final @Nullable Short p3) {
    Short l1 = p3; // possibly null
    Short l2a = new Short((short) 0); // explicit new object
    Short l2b = (short) 1; // boxing creates a new non-null object
    
    // bad (x4)
    final Double d1 = ((double) f1) + getFloat1() + p1 + l1;
    
    // good
    final Double d2 = ((double) f2) + getFloat2() + p2 + l2a + l2b;
  }
  
  
  
  public void testThrow(
      final int v, final @Nullable Exception e1, final @NonNull Throwable e2)
  throws Throwable {
    if (v <= 0) {
      throw null; // definitely null (but no warning message)
    } else if (v <= 5) {
      throw e1; // possibly null (warning)
    } else if (v <= 10) {
      throw e2; // not null
    } else {
      throw new IllegalArgumentException(); // not null
    }
  }
  
  
  
  public void testSynchronized(final boolean f, final @Nullable Object o1, final @NonNull Object o2) {
    synchronized (o1) {} // bad
    synchronized (o2) {} // good
    
    synchronized (f1) {} // bad
    synchronized (f2) {} // good
    
    synchronized (getFloat1()) {} // bad
    synchronized (getFloat2()) {} // good
  
    Object o = getFloat1();
    Object p = getFloat2();
    Object r = f ? o : p;
    synchronized (o) {} // bad
    synchronized (p) {} // good
    synchronized (r) {} // bad
  }
  
  
  
  @SuppressWarnings("unused")
  public void testArrayLength(final @Nullable int[] a1, final @NonNull int[] a2) {
    int l1 = a1.length; // bad
    int l2 = a2.length; // good
    int l3 = getArray1().length + getArray2().length; // bad / good
  }
  
  @SuppressWarnings({ "unused", "static-access" })
  public void testFieldRef(final boolean f, final @Nullable Other o1,
      final @NonNull Other o2, @Initialized(through="*") Other o3, @Initialized(through="Parent") Other o4) {
    int l1 = o1.f; // bad
    int l2 = o1.s; // good
    int l3 = Other.s; // good
    int l4 = o2.f; // good
    int l5 = o2.s; // good
    int l6 = ((Other) null).s; // good 
    int l7 = (f ? null : o2).f; // bad
    
    int x1 = o3.f; // good
    int x2 = o4.f; // good
    Other oo = f ? o3 : o4;
    int x3 = oo.f; // good
    oo = f ? getOther1() : o3;
    int x4 = oo.f; // bad
    oo = f ? o2 : o3; 
    int x5 = oo.f; // good
  }



  @SuppressWarnings("unused")
  public void testArrayRef(final @Nullable int[] a1, final @NonNull int[] a2) {
    int l1 = a1[0]; // bad
    int l2 = a2[1]; // good
    int l3 = getArray1()[0] + getArray2()[1]; // bad / good
  }
  
  
  
  @SuppressWarnings("static-access")
  public void testSimpleAssignment(
      final boolean f, final @Nullable Other o1,
      final @NonNull Other o2, @Initialized(through="*") Other o3, @Initialized(through="Parent") Other o4,
      final @Nullable int[] a1, final @NonNull int[] a2) {
    o1.f = 0; // bad
    o1.s = 0; // good
    Other.s = 0; // good
    o2.f = 0; // good
    o2.s = 0; // good
    ((Other) null).s = 0; // good 
    (f ? null : o2).f = 0; // bad
    
    o3.f = 0; // good
    o4.f = 0; // good
    Other oo = f ? o3 : o4;
    oo.f = 0; // good
    oo = f ? getOther1() : o3;
    oo.f = 0; // bad
    oo = f ? o2 : o3; 
    oo.f = 0; // good

    a1[0] = 0; // bad
    a2[1] = 0; // good
    getArray1()[0] = 0; // bad
    getArray2()[1] = 0; // good
  }

 
  
  public void testCrementErrorFromUnbox(
      @NonNull Test t, @Nullable Integer i, @NonNull Integer i2) {
    t.f1++; // bad
    ++t.f2; // good
    --i; // bad
    i2--; // good
    
  }
  
  public void testCrement(
      final boolean f, @Nullable Integer i1,
      @NonNull Integer i2, @Initialized(through="*") Integer i3, @Initialized(through="java.lang.Object") Integer o4,
      @Nullable int[] a1, @NonNull int[] a2, @Nullable final Other o1,
      final @NonNull Other o2, @Initialized(through="*") Other o3) {
    i1++; // bad
    i2--; // good
    
    ++i3; // good
    --o4; // good
    Integer oo = f ? i3 : o4;
    oo++; // good
    oo = f ? getInteger1() : i3;
    oo--; // bad
    oo = f ? i2 : i3; 
    --oo; // good
    
    ++a1[0]; // bad
    a2[0]--; // good
    
    o1.f++; // bad
    --o2.f; // good
    ++o3.f; // good
  }

 
  
  @SuppressWarnings("static-access")
  public void testCompoundAssignment(
      final boolean f, final @Nullable Other o1,
      final @NonNull Other o2, @Initialized(through="*") Other o3, @Initialized(through="Parent") Other o4,
      final @Nullable int[] a1, final @NonNull int[] a2) {
    o1.f += 0; // bad
    o1.s += 0; // good
    Other.s += 0; // good
    o2.f += 0; // good
    o2.s += 0; // good
    ((Other) null).s += 0; // good 
    (f ? null : o2).f += 0; // bad
    
    o3.f += 0; // good
    o4.f += 0; // good
    Other oo = f ? o3 : o4;
    oo.f += 0; // good
    oo = f ? getOther1() : o3;
    oo.f += 0; // bad
    oo = f ? o2 : o3; 
    oo.f += 0; // good
  
    a1[0] += 0; // bad
    a2[1] += 0; // good
    getArray1()[0] += 0; // bad
    getArray2()[1] += 0; // good
  }
  
  public void testCompoundAssignmentErrorFromUnbox(
      final boolean f, @Nullable Integer o1,
      @NonNull Integer o2, @Initialized(through="*") Integer o3, @Initialized(through="java.lang.Object") Integer o4) {
    o1 += 0; // bad
    @Initialized(through="*")
    Integer x = o2 += 0; // good
    o3 += 0; // good
    o4 += 0; // good
    Integer oo = f ? o3 : o4;
    oo += 0; // good
    oo = f ? getInteger1() : o3;
    oo += 0; // bad
    oo = f ? o2 : o3; 
    oo += 0; // good
  }
}


class Parent {
}

class Other extends Parent {
  public static int s;
  public int f;
}

