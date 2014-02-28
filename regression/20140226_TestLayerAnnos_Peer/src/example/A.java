package example;

import com.surelogic.MayReferTo;
import com.surelogic.NonNull;
import com.surelogic.RegionEffects;
import com.surelogic.Starts;
import com.surelogic.ThreadSafe;
import com.surelogic.Initialized;

@ThreadSafe
@MayReferTo("nothing")
public class A {

  @NonNull
  private final B peer;

  @RegionEffects("none")
  @Starts("nothing")
  public A() {
    peer = new B(this);
    m1();
  }

  @Initialized(through = "Object")
  private void m1() {
    System.out.println("m1()");
  }

  void bad() {
    C.foo();
    C.foo2();
  }

  public static void main(String[] args) {
  }
}
