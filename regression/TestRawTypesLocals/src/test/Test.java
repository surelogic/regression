package test;

import com.surelogic.Initialized;

public class Test {
  public C notRaw() { return null; }
  
  @Initialized(through="Object", value=" return")
  public C rawStar() { return null; }
  
  @Initialized(value="return", through="java.lang.Object")
  public C rawObject() { return null; }
  
  @Initialized(value="return", through="test.A")
  public C rawA() { return null; }
  
  @Initialized(value="return", through="test.B")
  public C rawB() { return null; }
  
  

  public void test(final boolean flag, final C p1, final @Initialized(through="Object") C p2) {
    @Initialized(through="Object") C l1;
    C l2;
    @Initialized(through="test.A") C l3;
    C l4;
    
    
    l1 = rawB();
    if (flag) {
      l1 = rawA();
    }
    
    l3 = rawObject();
    l3 = notRaw();
  }
}
