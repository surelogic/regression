package test;

import com.surelogic.Initialized;

public class Test {
  public Test(@Initialized(through="*") C p1, @Initialized(through="java.lang.Object") C p2, @Initialized(through="test.A") C p3,
      @Initialized(through="test.B") C p4, C p5) {
    super();
  }

  public void m(@Initialized(through="*") C p1, @Initialized(through="java.lang.Object") C p2, @Initialized(through="test.A") C p3,
      @Initialized(through="test.B") C p4, C p5) {
  }
}
