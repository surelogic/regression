package test;

import com.surelogic.RegionEffects;

public class Test {
  @RegionEffects("reads args:Instance")
  public static void method(final int count, String... args) {
    // do stuff
  }
  
  // BAD: doesn't account for the effects on the array foo
  @RegionEffects("none")
  public void call1(String[] foo) {
    method(foo.length, foo);
  }
  
  // GOOD: The new expression is masked
  @RegionEffects("none")
  public void call2() {
    method(3, new String[] { "a", "b", "c" });
  }
  
  // GOOD: The VarArgsExpresion is masked like a new expression
  @RegionEffects("none")
  public void call3() {
    method(3, "a", "b", "c");
  }

  // GOOD: The (empty) VarArgsExpression is masked like a new expression
  @RegionEffects("none")
  public void call4() {
    method(0);
  }
}
