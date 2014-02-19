package test;

import com.surelogic.Initialized;

public class C extends B {
  public C() {
    super();
  }
  
  
  
  public void notRaw() {}
  
  @Initialized(value="this", through="Object")
  public void rawStar() {}
  
  @Initialized(value="this", through="java.lang.Object")
  public void rawObject() {}
  
  @Initialized(value="this", through="test.A")
  public void rawA() {}
  
  @Initialized(value="this", through="test.B")
  public void rawB() {}
}
