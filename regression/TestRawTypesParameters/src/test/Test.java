package test;

import com.surelogic.Raw;

public class Test {
  public Test(@Raw C p1, @Raw(upTo="java.lang.Object") C p2, @Raw(upTo="test.A") C p3,
      @Raw(upTo="test.B") C p4, C p5) {
    super();
  }

  public void m(@Raw C p1, @Raw(upTo="java.lang.Object") C p2, @Raw(upTo="test.A") C p3,
      @Raw(upTo="test.B") C p4, C p5) {
  }
}
