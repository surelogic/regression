package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Initialized;

public class TestBArray {
  public Object[] yyyy(@NonNull A[][] foo) {
    return foo; // GOOD
  }
  
  // Nullable
  public B[] maybeNullImplied(int x,
      A[] a1, B[] b1, C[] c1, D[] d1,
      @Nullable A[] a2, @Nullable B[] b2, @Nullable C[] c2, @Nullable D[] d2,
      @NonNull A[] a3, @NonNull B[] b3, @NonNull C[] c3, @NonNull D[] d3) {
    B[] bNull = null;
    
    switch (x) {
    case 0:
//      return a1;  // Illegal
    case 1:
      return b1; // Good
    case 2:
      return c1; // Good
    case 3:
      return d1; // Good
    case 4:
//      return a2; // Illegal
    case 5:
      return b2; // Good
    case 6:
      return c2; // Good
    case 7:
      return d2; // Good
    case 8:
//      return a3; // Illegal
    case 9:
      return b3; // Good
    case 10:
      return c3; // Good
    case 11:
      return d3; // Good
    case 12:
      return bNull; // Good
    default:
      return null; // good NULL
    }
  }
  
  @Nullable
  public B[] maybeNull(int x,
      A[] a1, B[] b1, C[] c1, D[] d1,
      @Nullable A[] a2, @Nullable B[] b2, @Nullable C[] c2, @Nullable D[] d2,
      @NonNull A[] a3, @NonNull B[] b3, @NonNull C[] c3, @NonNull D[] d3) {
    B[] bNull = null;
    
    switch (x) {
    case 0:
//      return a1;  // Illegal
    case 1:
      return b1; // Good
    case 2:
      return c1; // Good
    case 3:
      return d1; // Good
    case 4:
//      return a2; // Illegal
    case 5:
      return b2; // Good
    case 6:
      return c2; // Good
    case 7:
      return d2; // Good
    case 8:
//      return a3; // Illegal
    case 9:
      return b3; // Good
    case 10:
      return c3; // Good
    case 11:
      return d3; // Good
    case 12:
      return bNull; // Good
    default:
      return null; // good NULL
    }
  }
  
  @NonNull
  public B[] nonNull(int x,
      A[] a1, B[] b1, C[] c1, D[] d1,
      @Nullable A[] a2, @Nullable B[] b2, @Nullable C[] c2, @Nullable D[] d2,
      @NonNull A[] a3, @NonNull B[] b3, @NonNull C[] c3, @NonNull D[] d3) {
    B[] bNull = null;
    
    switch (x) {
    case 0:
//      return a1;  // Illegal
    case 1:
      return b1; // Bad
    case 2:
      return c1; // Bad
    case 3:
      return d1; // Bad
    case 4:
//      return a2; // Illegal
    case 5:
      return b2; // Bad
    case 6:
      return c2; // Bad
    case 7:
      return d2; // Bad
    case 8:
//      return a3; // Illegal
    case 9:
      return b3; // Good
    case 10:
      return c3; // Good
    case 11:
      return d3; // Good
    case 12:
      return bNull; // Bad
    default:
      return null; // Bad NULL
    }
  }
}
