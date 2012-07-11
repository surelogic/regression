package test;

public class Test {
  private static void forceRead(final Object o) {
    // Do nothing
  }
  
  
  
  public void transferAllocation() {
    Object o;
    
    o = new Test();
    forceRead(o); // @NonNull
    
    o = new Test() { @Override public String toString() { return "X"; } };
    forceRead(o); // @NonNull
  }
  
  public void transferArrayCreation() {
    Object a;
    
    a = new Object[10];
    forceRead(a); // @NonNull
    
    a = new Object[10][20][30];
    forceRead(a); // @NonNull
  }
  
  /* transferAssignVar: see transferLiteral */
  
  public void transferBox() {
    Object o;
    
    o = 2;
    forceRead(o); // @NonNull
  }
  
  public void transferConcat(final String s1, final String s2) {
    Object o;
    o = s1 + s2; // @Nullable / @Nullable
    forceRead(o); // @NonNull
  }
  
  public void transferEq(final Object unknown) {
    Object o;
    
    o = null;
    if (o == null) { // @Nullable
      forceRead(o); // @Nullable
    } else {
      forceRead(o); // @NonNull
    }
    
    if (null == o) { // @Nullable
      forceRead(o); // @Nullable
    } else {
      forceRead(o); // @NonNull
    }
    
    if (o != null) { // @Nullable
      forceRead(o); // @NonNull
    } else {
      forceRead(o); // @Nullable
    }
    
    if (null != o) { // @Nullable
      forceRead(o); // @NonNull
    } else {
      forceRead(o); // @Nullable
    }

    
    
    o = "string";
    if (o == null) { // @NonNull
      forceRead(o); // @NonNull---true branch doesn't change the state
    } else {
      forceRead(o); // @NonNull
    }
    
    if (null == o) { // @NonNull
      forceRead(o); // @NonNull---true branch doesn't change the state
    } else {
      forceRead(o); // @NonNull
    }
    
    if (o != null) { // @NonNull
      forceRead(o); // @NonNull
    } else {
      forceRead(o); // @NonNull---true branch doesn't change the state
    }
    
    if (null != o) { //@NonNull
      forceRead(o); // @NonNull
    } else {
      forceRead(o); // @NonNull---true branch doesn't change the state
    }    

  
  
    if (unknown == null) { // @Nullable
      forceRead(unknown); // @Nullable
    } else {
      forceRead(unknown); // @NonNull
    }
    
    if (null == unknown) { // @Nullable
      forceRead(unknown); // @Nullable
    } else {
      forceRead(unknown); // @NonNull
    }
    
    if (unknown != null) { // @Nullable
      forceRead(unknown); // @NonNull
    } else {
      forceRead(unknown); // @Nullable
    }
    
    if (null != unknown) { // @Nullable
      forceRead(unknown); // @NonNull
    } else {
      forceRead(unknown); // @Nullable
    }    
  }
  
  public void transferImplicitArrayCreation() {
    Object[] a = { 0, 1, 2 };
    forceRead(a); // @NonNull
  }
  
  public void transferInitializationOfVar(final boolean flag, final Object o) {
    final Object a = null;
    final Object b = new Object();
    
    final Object c = a; // @Nullable
    final Object d = b; // @NonNull
    final Object e = o; // @Nullable
    final Object f = flag ? a : b; // @Nullable / @NonNull
    
    forceRead(c); // @Nullable
    forceRead(d); // @NonNull
    forceRead(e); // @Nullable
    forceRead(f); // @Nullable;
  }
  
  public void transferInstanceOf(final Object o) {
    if (o instanceof Object) { // @Nullable
      forceRead(o); // @NonNull
    } else {
      forceRead(o); // @Nullable
    }
    forceRead(o); // @Nullable
  }
  
  public void transferIsObject(final Other unknown, final int[] array,
      final Integer p) {
    Other v;
    int[] a;
    Integer i;
    
    v = unknown; // @Nullable
    v.f = 10; // @Nullable
    forceRead(v); // @NonNull
    
    a = array; // @Nullable
    final int z = a.length; // @Nullable;
    forceRead(a); // @NonNull
    
    i = p; // @Nullable
    int y = i; // @Nullable
    forceRead(i); // @NonNull
    
    v = unknown; // @Nullable
    v.m(); // @Nullable
    forceRead(v); // @NonNull
    
    v = unknown; // @Nullable
    v. new C(); // @Nullable
    forceRead(v); // @NonNull 

    a = array; // @Nullable
    a[0] = 10; // @Nullable;
    forceRead(a); // @NonNull
    
    v = unknown; // @Nullable
    synchronized (v) { // @Nullable
      forceRead(v); // @NonNull
    }
  }
  
  // Also tests transferAssignVar
  public void transferLiteral(final boolean flag) {
    Object o;
    
    o = "String";
    forceRead(o); // @NonNull
    o = null;
    forceRead(o); // maybe null
    o = "S";
    forceRead(o); // @NonNull
    
    if (flag) {
      o = null;
    } else {
      o = "x";
    }
    forceRead(o); // @Nullable
  }
  
  /* No way to test transferToString() because it is not actually called. */
  
  public void transferUseQualifiedReceiver() {
    class X {
      public void m() {
        Object o = Test.this;
        forceRead(o); // @NonNull
      }
    }
  }
  
  public void transferUseReceiver() {
    Test o = this;
    forceRead(o); // @NonNull
  }
  
  public void transferUseVar(final boolean flag) {
    Object a;
    Object b;
    Object c;
    
    a = null;
    
    b = null;
    c = flag ? a : b; // @Nullable / @Nullable
    forceRead(c); // @Nullable
    
    b = "s";
    c = flag ? a : b; // @Nullable / @NonNull
    forceRead(c); // @Nullable;
    
    a = "s";
    
    b = null;
    c = flag ? a : b; // @NonNull / @Nullable
    forceRead(c); // @Nullable
    
    b = "s";
    c = flag ? a : b; // @NonNull / @NonNull
    forceRead(c); // @NonNull
  }
}

class Other {
  public int f;
  
  public void m() {}
  
  public class C {}
}
