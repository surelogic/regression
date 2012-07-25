package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall.externalVar;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;


public class Test {
  private @Unique Object u;

  
  
  /* ==========================================================================
   * Compromise by being copied into a cache field of a local class
   * Load via the SHARED object through an effect on static state
   * ========================================================================== 
   */
  
  @RegionEffects("reads java.lang.Object:All")
  private static void doesAnything(Object o) {}
      
  public void foo(Test other) {
  	final Object v = other.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};
  	
    doesAnything(other); // trigger error in opLoadReachable() via considerEffects()
  }
  
  
  
  /* ==========================================================================
   * Compromise by being copied into a cache field of a local class
   * Load by being affected as a formal parameter to a method call.
   * ========================================================================== 
   */
  
  @RegionEffects("reads x:Instance")
  private static void readsInstance(final Test x) {}

  @Unique("this")
  public void bad1(@Unique Test other1, @Unique Test other2) {
  	final Object v = other1.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

  	readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad2(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
  	final Object v = other1.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    readsInstance(this); // okay
    readsInstance(other2); // okay
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad3(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
  	final Object v = other2.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    readsInstance(this); // okay
    readsInstance(other1); // okay
    readsInstance(other2); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad4(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly recognized and handled as actual argument
  	final Object v = this.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    readsInstance(this); // trigger error in opLoadReachable() via considerEffects()
  }


  
  /* ==========================================================================
   * Compromise by being copied into a cache field of a local class
   * Load by being affected as the receiver to a method call.
   * ========================================================================== 
   */

  @RegionEffects("reads this:Instance")
  @Borrowed("this")
  private void readsInstance() {}
  
  
  @Unique("this")
  public void bad5(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
  	final Object v = this.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad6(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
  	final Object v = other1.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    this.readsInstance(); // good
    other2.readsInstance(); // good
    other1.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad7(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
  	final Object v = other2.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

  	this.readsInstance(); // good
    other1.readsInstance(); // good
    other2.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad8(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
  	final Object v = this.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};

    other1.readsInstance(); // good
    other2.readsInstance(); // good
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
}


