package refObject;

import com.surelogic.ReferenceObject;

@ReferenceObject
public class Test {
  @ReferenceObject
  final class Inner extends Test {
  }
  
  public void method() {
    final Test t = new Test() { // good
      // empty
    };
    
    final Test v = new Test() { // bad
      public boolean equals(final Object o) {
        return false;
      }
    };
  }
}
