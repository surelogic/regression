package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public enum TestEnum {
  Q1(getB(), getB(), getB()),    // good, good, bad
  Q2(getB2(), getB2(), getB2()), // good, good, bad
  Q3(getB3(), getB3(), getB3()), // good, good, good

  Q4(getC(), getC(), getC()),    // good, good, bad
  Q5(getC2(), getC2(), getC2()), // good, good, bad
  Q6(getC3(), getC3(), getC3()), // good, good, good

  Q7(getD(), getD(), getD()),    // good, good, bad
  Q8(getD2(), getD2(), getD2()), // good, good, bad
  Q9(getD3(), getD3(), getD3()), // good, good, good

  
  W1(getB(), getB(), getB()) {},    // good, good, bad
  W2(getB2(), getB2(), getB2()) {}, // good, good, bad
  W3(getB3(), getB3(), getB3()) {}, // good, good, good

  W4(getC(), getC(), getC()) {},    // good, good, bad
  W5(getC2(), getC2(), getC2()) {}, // good, good, bad
  W6(getC3(), getC3(), getC3()) {}, // good, good, good

  W7(getD(), getD(), getD()) {},    // good, good, bad
  W8(getD2(), getD2(), getD2()) {}, // good, good, bad
  W9(getD3(), getD3(), getD3()) {}; // good, good, good

  
  
  TestEnum(B p1, @Nullable B p2, @NonNull B p3) {
    // do nothing
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
}

