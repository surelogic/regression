package opGet.viaTransferNestedClassUse;

import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestUnique {
  @Unique
  private Object u;
  
  public void method1(TestUnique other) {
    final Object x = other.u;
    final Object y = other.u; // kill 'x'
    other.u = null;
    
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



  public void method2(TestUnique other) {
    final Object x = other.u;
    final Object y = other.u; // kill 'x'
    other.u = null;
    
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
