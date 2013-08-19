package test;

import com.surelogic.NonNull;

public class Test {
  public void needsNonNull(@NonNull Object o) {
    // do stuff
  }
  
  public void test() {
    needsNonNull("String");
    needsNonNull(new Object());
    needsNonNull(this);
    needsNonNull(E.A);
    needsNonNull(E.B);
    needsNonNull(E.C);
  }
}
