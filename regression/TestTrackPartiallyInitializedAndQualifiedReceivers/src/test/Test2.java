package test;

public class Test2 {
  private class Inner {
    public Inner() {}
  }

  public void m() {}

  public Test2() {
    new Inner() {
      {
        m(); // Good, qualified receiver is non-null because Test2 is not annotated with TrackPartiallyInitialized
      }
    };
  }
}
