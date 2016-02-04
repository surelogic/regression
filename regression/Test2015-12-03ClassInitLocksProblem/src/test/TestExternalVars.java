package test;

import com.surelogic.RegionLock;

@RegionLock("L1 is A.class protects f_a")
class A {
  public static int f_a = 1;
}

@RegionLock("L2 is B.class protects f_b")
class B extends A {
  public static int f_b = 2;
}

@RegionLock("L3 is C.class protects f_c")
class C extends B {
  public static int f_c = 3;
}


@RegionLock("LL is O.class protects f_o")
class O {
  public static int f_o = 3;
}

