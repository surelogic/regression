package opGet.viaTransferNestedClassUse;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

@SuppressWarnings("unused")
public class TestBorrowed {
  @Borrowed
  private final Object b;
  
  @RegionEffects("writes o:Instance")
  public TestBorrowed(@Borrowed(allowReturn=true) final Object o) {
    b = o;
  }
  
  public void method1(TestBorrowed other) {
    final Object x = other.b;
    final Object y = other.b; // kill 'x'
    
    new Object() {
      public void n() {
        /* Reads undefined 'x' in transferNestedClassUse() as 'x' is 
         * compromised to simulate the fact that 'x' needs to have been
         * copied into a new field of the anonymous class.
         */
        Object y = x;
      }
    };
  }



  public void method2(TestBorrowed other) {
    final Object x = other.b;
    final Object y = other.b; // kill 'x'
    
    class C {
      public void n() {
        /* Reads undefined 'x' in transferNestedClassUse() as 'x' is 
         * compromised to simulate the fact that 'x' needs to have been
         * copied into a new field of the anonymous class.
         */
        Object y = x;
      }
    }
    
    new C(); // create an instance to trigger the flow through the nested class
  }
}
