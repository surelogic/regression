package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall.arrayElement;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;


public class TestAllowRead {
  private @Unique(allowRead=true) Object u;
  
  
  
  /* ==========================================================================
   * Compromise by being assigned to an array element
   * Load via the SHARED object through an effect on static state
   * ========================================================================== 
   */
  
  @RegionEffects("reads java.lang.Object:All")
  private static void doesAnything(Object o) {}
      
  public void foo(final Object[] array, TestAllowRead other) {
    // Trigger error via the SHARED pseudo variable
    array[0] = other.u;
    doesAnything(other); // trigger error in opLoadReachable() via considerEffects()
  }
  
  
  
  /* ==========================================================================
   * Compromise by being assigned to an array element
   * Load by being affected as a formal parameter to a method call.
   * ========================================================================== 
   */
  
  @RegionEffects("reads x:Instance")
  private static void readsInstance(final TestAllowRead x) {}

  @Unique("this")
  public void bad1(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
  	array[0] = other1.u;
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad2(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that different parameters are distinguished by the error
  	array[0] = other1.u;
    readsInstance(this); // okay
    readsInstance(other2); // okay
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad3(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that different parameters are distinguished by the error
  	array[0] = other2.u;
    readsInstance(this); // okay
    readsInstance(other1); // okay
    readsInstance(other2); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad4(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly recognized and handled as actual argument
  	array[0] = this.u;
    readsInstance(this); // trigger error in opLoadReachable() via considerEffects()
  }


  
  /* ==========================================================================
   * Compromise by being assigned to an array element
   * Load by being affected as the receiver to a method call.
   * ========================================================================== 
   */

  @RegionEffects("reads this:Instance")
  @Borrowed("this")
  private void readsInstance() {}
  
  
  @Unique("this")
  public void bad5(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
  	array[0] = this.u;
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad6(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
  	array[0] = other1.u;
    this.readsInstance(); // good
    other2.readsInstance(); // good
    other1.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad7(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
  	array[0] = other2.u;
    this.readsInstance(); // good
    other1.readsInstance(); // good
    other2.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad8(final Object[] array, @Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
  	array[0] = this.u;
    other1.readsInstance(); // good
    other2.readsInstance(); // good
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
}


