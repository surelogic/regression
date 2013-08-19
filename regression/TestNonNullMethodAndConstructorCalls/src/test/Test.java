package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  public Test(int x, B p1, @Nullable B p2, @NonNull B p3) {
    // do nothing
  }
  
  public Test() {
    this(1, getB3(), getC3(), getD3()); // good, good, good
  }
  
  private static B getB() { return new B(); }
  private static @Nullable B getB2() { return new B(); }
  private static @NonNull B getB3() { return new B(); }
  
  private static C getC() { return new C(); }
  private static @Nullable C getC2() { return new C(); }
  private static @NonNull C getC3() { return new C(); }
  
  private static D getD() { return new D(); }
  private static @Nullable D getD2() { return new D(); }
  private static @NonNull D getD3() { return new D(); }
  
  
  
  public void testConstructor() {
    new Test(0, getB(), getB(), getB());    // good, good, bad
    new Test(0, getB2(), getB2(), getB2()); // good, good, bad
    new Test(0, getB3(), getB3(), getB3()); // good, good, good

    new Test(0, getC(), getC(), getC());    // good, good, bad
    new Test(0, getC2(), getC2(), getC2()); // good, good, bad
    new Test(0, getC3(), getC3(), getC3()); // good, good, good

    new Test(0, getD(), getD(), getD());    // good, good, bad
    new Test(0, getD2(), getD2(), getD2()); // good, good, bad
    new Test(0, getD3(), getD3(), getD3()); // good, good, good
  }
  
  
  
  public void testAnonymomusClass() {
    new Test(0, getB(), getB(), getB()) {};    // good, good, bad
    new Test(0, getB2(), getB2(), getB2()) {}; // good, good, bad
    new Test(0, getB3(), getB3(), getB3()) {}; // good, good, good

    new Test(0, getC(), getC(), getC()) {};    // good, good, bad
    new Test(0, getC2(), getC2(), getC2()) {}; // good, good, bad
    new Test(0, getC3(), getC3(), getC3()) {}; // good, good, good

    new Test(0, getD(), getD(), getD()) {};    // good, good, bad
    new Test(0, getD2(), getD2(), getD2()) {}; // good, good, bad
    new Test(0, getD3(), getD3(), getD3()) {}; // good, good, good
  }
}

class Sub extends Test {
  public Sub() {
    super(2, null, null, null); // good, good, bad
  }
}
