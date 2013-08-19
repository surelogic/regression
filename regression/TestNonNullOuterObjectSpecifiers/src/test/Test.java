package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  public class Inner {
    // empty
  }
  
  public static @Nullable Test getTest() { return null; }
  
  public void testNormal(boolean flag, Test t, @Nullable Test t2, @NonNull Test t3) {
    t. new Inner(); // bad (but no warning)
    t2. new Inner(); // bad
    t3. new Inner(); // good
    
    Test x = flag ? getTest() : t3;
    x. new Inner(); // bad
    
    x = new Test();
    x. new Inner(); // good
  }
  
  public void testAnonymousClass(boolean flag, Test t, @Nullable Test t2, @NonNull Test t3) {
    t. new Inner() {}; // bad (but no warning)
    t2. new Inner() {}; // bad
    t3. new Inner() {}; // good
    
    Test x = flag ? getTest() : t3;
    x. new Inner() {}; // bad
    
    x = new Test() {};
    x. new Inner() {}; // good
  }
}

class Sub extends Test.Inner {
  public Sub(Test t) {
    t.super(); // bad (but no warning)
  }
  
  public Sub(int x, @Nullable Test t) {
    t.super(); // bad
  }
  
  public Sub(boolean b, @NonNull Test t) {
    t.super(); // good
  }
  
  public Sub() {
    Test.getTest().super(); // bad
  }
}