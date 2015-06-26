package test;

import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class Test {
  private class Inner {
    public Inner() {}
  }

  public void m() {}

  public Test() {
    new Inner() {
      {
        m(); // Bad, Qualified receiver is partially initialized because Test is @TrackPartiallyInitialized
      }
    };
  }
}
