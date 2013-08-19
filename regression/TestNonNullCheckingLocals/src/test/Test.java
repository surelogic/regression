package test;

import com.surelogic.NonNull;

public class Test {
  @NonNull
  private Object getNonNull() { return new Object(); }
  
  @SuppressWarnings("unused")
  public void testNonNullLocals(final boolean flag, final int v,
      final @NonNull Object p1, final Object p2) {
    @NonNull Object l1 = "not null"; // good
    Object l2;
    @NonNull Object l3; // bad
    
    if (v < 0) {
      l1 = p1;
    } else if(v == 0) {
      l1 = getNonNull();
    } else {
      l1 = new Object();
    }
    
    l1 = new Object[10];
    
    l2 = p2;
    l3 = l2;
    if (flag) {
      l3 = p2;
    } else {
      l3 = getNonNull();
    }
    l3 = new Object();
  }

  
  
  private @NonNull Object f1 = "not null";
  private @NonNull Object f3 = "not null";
  
  @SuppressWarnings("unused")
  public void testFields(final boolean flag, final int v,
      final @NonNull Object p1, final Object p2) {
    Object l2;
    
    if (v < 0) {
      f1 = p1;
    } else if(v == 0) {
      f1 = getNonNull();
    } else {
      f1 = new Object();
    }
    
    f1 = new Object[10];
    
    l2 = p2;
    f3 = l2;
    if (flag) {
      f3 = p2;
    } else {
      f3 = getNonNull();
    }
    f3 = new Object();
  }
}
