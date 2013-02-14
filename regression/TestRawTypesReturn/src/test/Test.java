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
  
  
  
  public void test(boolean flag) {
    final C notRaw = notRaw();
    final C rawStar = rawStar();
    final C rawObject = rawObject();
    final C rawA = rawA();
    final C rawB = rawB();
    
    final C foo1 = flag ? rawA : rawB; // => rawA
    final C foo2 = flag ? rawObject : rawA; // => rawObject
    final C foo3;
    if (flag) {
      foo3 = rawObject;
    } else {
      foo3 = rawB;
    } // => rawObject
    
    C foo4 = rawB;
    foo4 = rawA;
    foo4 = rawObject;
    foo4 = rawStar;
    foo4 = notRaw; // => notRaw
    
    final C foo5 = new C(); // => notRaw;
    final Object[] foo6 = new Object[10]; // => notRaw
    final Test foo7 = this; // => notRaw;
  }


  public void test2(boolean flag,
      C notRaw,
      @Raw C rawStar,
      @Raw(upTo="java.lang.Object") C rawObject,
      @Raw(upTo="test.A") C rawA,
      @Raw(upTo="test.B") C rawB) {
    final C foo1 = flag ? rawA : rawB; // => rawA
    final C foo2 = flag ? rawObject : rawA; // => rawObject
    final C foo3;
    if (flag) {
      foo3 = rawObject;
    } else {
      foo3 = rawB;
    } // => rawObject
    
    C foo4 = rawB;
    foo4 = rawA;
    foo4 = rawObject;
    foo4 = rawStar;
    foo4 = notRaw; // => notRaw
    
    final C foo5 = new C(); // => notRaw;
    final Object[] foo6 = new Object[10]; // => notRaw
    final Test foo7 = this; // => notRaw;
  }
}
