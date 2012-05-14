package opCheckMutable.viaOpStore.transferInitializationOfField;

import com.surelogic.Borrowed;

/* Test opCheckMutable() when it is called by opStore() from
 * transferInitializationOfField().  What this does is make sure that when we
 * have a field initialization "C f = ...;" that the receiver does not 
 * refer to a @ReadOnly or @Immutable reference.  
 */
public class Test {
  public int f = 1;
  
  
  
  /*
   * === Test Receivers
   */
  
  @Borrowed("this")
  public Test(int a) {
  }
  
  // ReadOnly receiver on a constructor is not possible

  // Immutable receiver on a constructor is not possible
  
  /*SHARED*/
  public Test(int a, int b, int c, int d) {
  }
  
  // UniqueWrite receiver on a constructor is not possible

  // Unique receiver on a constructor is not possible
}
