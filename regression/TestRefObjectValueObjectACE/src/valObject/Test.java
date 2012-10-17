package valObject;

import com.surelogic.ValueObject;

@ValueObject
public abstract class Test {
  @ValueObject
  final class Inner extends Test { // bad
  }
  
  public void method() {
    final Test t = new Test() { // bad; point is that it is checked at all
      // empty
    };
    
    final Test v = new Test() { // bad; point is that it is checked at all
      // empty
    };
  }
}
