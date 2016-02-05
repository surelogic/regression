package test;

import com.surelogic.GuardedBy;

class X {
  protected static final Object XX1 = new Object();
  protected final Object x1 = new Object();
}

class Y extends X {
  protected static final Object YY1 = new Object();
  protected final Object y1 = new Object();
}

class Unrelated {
  protected static final Object UU1 = new Object();
  protected final Object u1 = new Object();
}

public class GuardedByField extends Y {
  private static final Object staticLock1 = new Object();
  private static Object staticLock2 = new Object();
  private static final int staticLock3 = 1;
  
  private final Object lock1 = new Object();
  private Object lock2 = new Object();
  private final int lock3 = 1;
  
  
  
  @GuardedBy("staticLock1")
  private int f1; // good
  
  @GuardedBy("staticLock1")
  private static int s1; // good
  
  @GuardedBy("staticLock2")
  private int f2; // bad, referenced lock field is not final
  
  @GuardedBy("staticLock2")
  private static int s2; // bad, referenced lock field is not final
  
  @GuardedBy("staticLock3")
  private int f3; // bad, referenced lock field is not a reference type
  
  @GuardedBy("staticLock3")
  private static int s3; // bad, referenced lock field is not a reference type
  
  @GuardedBy("lock1")
  private int f4; // good
  
  @GuardedBy("lock1")
  private static int s4; // bad, field is static, lock is not
  
  @GuardedBy("lock2")
  private int f5; // bad, referenced lock field is not final
  
  @GuardedBy("lock2")
  private static int s5; // bad, referenced lock field is not final
  
  @GuardedBy("lock3")
  private int f6; // bad, referenced lock field is not a reference type
  
  @GuardedBy("lock3")
  private static int s6; // bad, referenced lock field is not a reference type

  
  
  @GuardedBy("staticLock1")
  private final int f10 = 0; // bad, field is final
  
  @GuardedBy("lock1")
  private final int f11 = 0; // bad, field is final
  
  
  
  // Test static fields from other class
  
  @GuardedBy("X.XX1")
  private int f20; // good
  
  @GuardedBy("XX1")
  private int f20a; // Good
  
  @GuardedBy("Y.YY1")
  private int f21; // good
  
  @GuardedBy("YY1")
  private int f21a; // good
  
  @GuardedBy("Unrelated.UU1")
  private int f22; // good
  
  @GuardedBy("UU1")
  private int f22a; // bad, cannot resolve UU1 this way
  
  @GuardedBy("Z.ZZ1")
  private int f23; // good
  
  @GuardedBy("ZZ1")
  private int f23a; // bad, cannot resolve ZZ1 this way
  
  
  
  // Test instance fields from other class
  
  @GuardedBy("X.x1")
  private int f30; // good
  
  @GuardedBy("x1")
  private int f30a; // Good
  
  @GuardedBy("Y.y1")
  private int f31; // good
  
  @GuardedBy("y1")
  private int f31a; // good
  
  @GuardedBy("Unrelated.u1")
  private int f32; // bad, Unrelated is not a superclass
  
  @GuardedBy("u1")
  private int f32a; // bad, cannot resolve u1 this way
  
  @GuardedBy("Z.z1")
  private int f33; // bad, Z is not a superclass
  
  @GuardedBy("z1")
  private int f33a; // bad, cannot resolve z1 this way
}

class Z extends GuardedByField {
  protected static final Object ZZ1 = new Object();
  protected final Object z1 = new Object();
}
