package test;

import com.surelogic.Raw;

public class C extends B {
  public C() {
    super();
  }
  
  
  
  public void notRaw() {}
  
  @Raw(value="this")
  public void rawStar() {}
  
  @Raw(value="this", upTo="java.lang.Object")
  public void rawObject() {}
  
  @Raw(value="this", upTo="test.A")
  public void rawA() {}
  
  @Raw(value="this", upTo="test.B")
  public void rawB() {}
}
