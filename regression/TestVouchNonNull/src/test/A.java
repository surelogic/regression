package test;

import com.surelogic.NonNull;

public class A {
  private final @NonNull B peer;
  
  public A() {
    peer = new B(this);
  }
}
