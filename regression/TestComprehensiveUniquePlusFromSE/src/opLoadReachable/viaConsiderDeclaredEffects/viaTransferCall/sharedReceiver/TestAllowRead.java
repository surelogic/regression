package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall.sharedReceiver;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class TestAllowRead {
  private @Unique(allowRead=true) Other u;
  
  
  
  /* ==========================================================================
   * Compromise by being a SHARED receiver 
   * Load via the SHARED object through an effect on static state
   * ========================================================================== 
   */
  
  @RegionEffects("reads java.lang.Object:All")
  private static void doesAnything(Object o) {}
      
  public void foo(TestAllowRead other) {
    // Trigger error via the SHARED pseudo variable
  	other.u. call();
    doesAnything(other); // trigger error in opLoadReachable() via considerEffects()
  }
  
  
  
  /* ==========================================================================
   * Compromise by being a SHARED receiver 
   * Load by being affected as a formal parameter to a method call.
   * ========================================================================== 
   */
  
  @RegionEffects("reads x:Instance")
  private static void readsInstance(final TestAllowRead x) {}

  @Unique("this")
  public void bad1(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    other1.u. call();
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad2(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that different parameters are distinguished by the error
    other1.u. call();
    readsInstance(this); // okay
    readsInstance(other2); // okay
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad3(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that different parameters are distinguished by the error
    other2.u. call();
    readsInstance(this); // okay
    readsInstance(other1); // okay
    readsInstance(other2); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad4(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly recognized and handled as actual argument
    this.u. call();
    readsInstance(this); // trigger error in opLoadReachable() via considerEffects()
  }


  
  /* ==========================================================================
   * Compromise by being a SHARED receiver 
   * Load by being affected as the receiver to a method call.
   * ========================================================================== 
   */

  @RegionEffects("reads this:Instance")
  @Borrowed("this")
  private void readsInstance() {}
  
  
  @Unique("this")
  public void bad5(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
    this.u. call();
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad6(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
    other1.u. call();
    this.readsInstance(); // good
    other2.readsInstance(); // good
    other1.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad7(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
    other2.u. call();
    this.readsInstance(); // good
    other1.readsInstance(); // good
    other2.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad8(@Unique TestAllowRead other1, @Unique TestAllowRead other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
    this.u. call();
    other1.readsInstance(); // good
    other2.readsInstance(); // good
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
}


