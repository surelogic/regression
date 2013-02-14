package test;

import com.surelogic.Raw;

public class Test {
  public C notRaw() { return null; }
  
  @Raw("return")
  public C rawStar() { return null; }
  
  @Raw(value="return", upTo="java.lang.Object")
  public C rawObject() { return null; }
  
  @Raw(value="return", upTo="test.A")
  public C rawA() { return null; }
  
  @Raw(value="return", upTo="test.B")
  public C rawB() { return null; }
  
  

  public void test(final boolean flag, final C p1, final @Raw C p2) {
    @Raw C l1;
    C l2;
    @Raw(upTo="test.A") C l3;
    C l4;
    
    
    l1 = rawB();
    if (flag) {
      l1 = rawA();
    }
    
    l3 = rawObject();
    l3 = notRaw();
  }
}
