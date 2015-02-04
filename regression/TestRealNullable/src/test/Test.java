package test;

import com.surelogic.NonNull;
import com.surelogic.Initialized;
import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class Test {
  @NonNull
  private Object f1;
  
  @NonNull
  private Object f2;
  
  @NonNull
  private Object f3;
  
  
  public Test(final boolean flag) {
    f1 = new Object();
    
    if (flag) {
      f2 = new Object();
    } else {
      f2 = f1;
    }
    
    if (flag) f3 = new Object();
    
    // f1 and f2 are good; f3 is bad
  }
  
  public Test() {
    this(false);
    // f1, f2, f3 are good
  }



  public C notRaw() { return null; }
  
  @Initialized(through="Object", value=" return")
  public C rawStar() { return null; }
  
  @Initialized(value="return", through="java.lang.Object")
  public C rawObject() { return null; }
  
  @Initialized(value="return", through="test.A")
  public C rawA() { return null; }
  
  @Initialized(value="return", through="test.B")
  public C rawB() { return null; }
  
  

  @SuppressWarnings("unused")
  public void test(final boolean flag, final C p1, final @Initialized(through="Object") C p2) {
    @Initialized(through="Object") C l1 = new C();
    C l2;
    @Initialized(through="test.A") C l3 = new C();
    C l4;
    
    
    l1 = rawB();
    if (flag) {
      l1 = rawA();
    }
    
    l3 = rawObject();
    l3 = notRaw();
  }
  
  @NonNull
  private Object getNonNull() { return new Object(); }
  
  @SuppressWarnings("unused")
  public void testNonNullLocals(final boolean flag, final int v,
      final @NonNull Object p1, final Object p2) {
    @NonNull Object l1 = "not null"; // good
    Object l2;
    @NonNull Object l3; // bad
    
    if (v < 0) {
      l1 = p1;
    } else if(v == 0) {
      l1 = getNonNull();
    } else {
      l1 = new Object();
    }
    
    l1 = new Object[10];
    
    l2 = p2;
    l3 = l2;
    if (flag) {
      l3 = p2;
    } else {
      l3 = getNonNull();
    }
    l3 = new Object();
  }
}
