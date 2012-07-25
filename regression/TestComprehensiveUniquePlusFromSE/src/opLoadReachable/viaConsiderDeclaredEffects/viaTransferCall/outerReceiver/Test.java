package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall.outerReceiver;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;


public class Test {
  private @Unique Object u;

  
  
  /* ==========================================================================
   * Compromise by being copied into the outer object reference
   * Load via the SHARED object through an effect on static state
   * ========================================================================== 
   */
  
  @RegionEffects("reads java.lang.Object:All")
  private static void doesAnything(Object o) {}
      
  @Unique("this")
  public void foo(Test other) {
  	other.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};
  	
    doesAnything(other); // trigger error in opLoadReachable() via considerEffects()
  }
  
  
  
  /* ==========================================================================
   * Compromise by being copied into the outer object reference
   * Load by being affected as a formal parameter to a method call.
   * ========================================================================== 
   */
  
  @RegionEffects("reads x:Instance")
  private static void readsInstance(final Test x) {}

  @Unique("this")
  public void bad1(@Unique Test other1, @Unique Test other2) {
  	other1.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};

  	readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad2(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
  	other1.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};

    readsInstance(this); // okay
    readsInstance(other2); // okay
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad3(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
  	other2.u = this;

  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};

    readsInstance(this); // okay
    readsInstance(other1); // okay
    readsInstance(other2); // trigger error in opLoadReachable() via considerEffects()
  }
  

  
  /* ==========================================================================
   * Compromise by being copied into the outer object reference
   * Load by being affected as the receiver to a method call.
   * ========================================================================== 
   */

  @RegionEffects("reads this:Instance")
  @Borrowed("this")
  private void readsInstance() {}
  
  @Unique("this")
  public void bad6(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual
  	other1.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};

    this.readsInstance(); // good
    other2.readsInstance(); // good
    other1.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad7(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
  	other2.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Caused the outer receiver to be shared
  		}
  	};

  	this.readsInstance(); // good
    other1.readsInstance(); // good
    other2.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
}


