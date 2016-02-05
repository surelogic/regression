package test.method;

import com.surelogic.GuardedBy;

class X {
  protected static Object XX1() { return "1"; }
  protected Object x1() { return "2"; }
}

class Y extends X {
  protected static Object YY1() { return "3"; }
  protected Object y1() { return "4"; }
}

class Unrelated {
  protected static Object UU1() { return "5"; }
  protected Object u1() { return "6"; }
}

public class GuardedByMethod extends Y {
  public Object bad1(int x) { return "q"; }
  public void bad2() { return; }
  public int bad3() { return 0; }

  
  
  @GuardedBy("GuardedByMethod()")
  private int ff1; // bad, cannot use constructor
  
  @GuardedBy("bad1()")
  private int ff2; // bad, not nil-ary
  
  @GuardedBy("bad2()")
  private int ff3; // bad, void return type
  
  @GuardedBy("bad3()")
  private int ff4; // bad, primitive return type
  
  
  
  public static Object staticLock1() { return "a"; }
  public Object lock1() { return "b"; }
  
  
  
  @GuardedBy("staticLock1()")
  private int f1; // good
  
  @GuardedBy("staticLock1()")
  private static int s1; // good

  @GuardedBy("lock1()")
  private int f4; // good
  
  @GuardedBy("lock1()")
  private static int s4; // bad, field is static, lock is not

  @GuardedBy("staticLock1()")
  private final int f10 = 0; // bad, field is final
  
  @GuardedBy("lock1()")
  private final int f11 = 0; // bad, field is final
  
  
  
  // Test static fields from other class
  
  @GuardedBy("X.XX1()")
  private int f20; // good
  
  @GuardedBy("XX1()")
  private int f20a; // Good
  
  @GuardedBy("Y.YY1()")
  private int f21; // good
  
  @GuardedBy("YY1()")
  private int f21a; // good
  
  @GuardedBy("Unrelated.UU1()")
  private int f22; // good
  
  @GuardedBy("UU1()")
  private int f22a; // bad, cannot resolve UU1 this way
  
  @GuardedBy("Z.ZZ1()")
  private int f23; // good
  
  @GuardedBy("ZZ1()")
  private int f23a; // bad, cannot resolve ZZ1 this way
  
  
  
  // Test instance fields from other class
  
  @GuardedBy("X.x1()")
  private int f30; // good
  
  @GuardedBy("x1()")
  private int f30a; // Good
  
  @GuardedBy("Y.y1()")
  private int f31; // good
  
  @GuardedBy("y1()")
  private int f31a; // good
  
  @GuardedBy("Unrelated.u1()")
  private int f32; // bad, Unrelated is not a superclass
  
  @GuardedBy("u1()")
  private int f32a; // bad, cannot resolve u1 this way
  
  @GuardedBy("Z.z1()")
  private int f33; // bad, Z is not a superclass
  
  @GuardedBy("z1()")
  private int f33a; // bad, cannot resolve z1 this way
}

class Z extends GuardedByMethod {
  protected static Object ZZ1() { return "7"; }
  protected Object z1() { return "8"; }
}
