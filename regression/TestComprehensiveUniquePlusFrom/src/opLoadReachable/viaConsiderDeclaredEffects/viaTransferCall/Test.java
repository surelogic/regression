package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;


public class Test {
  private @Unique Object u;
  
  
  
  @RegionEffects("none")
  private static void compromiseRef(final Object o) {
    // do nothing
  }
  
  @RegionEffects("reads java.lang.Object:All")
  private static void doesAnything(Object o) {}
  
  @RegionEffects("reads x:Instance")
  private static void readsInstance(final Test x) {}
  
  
  
  public void foo(Test other) {
    // Trigger error via the SHARED pseudo variable
    compromiseRef(other.u);
    doesAnything(other); // trigger error in opLoadReachable() via considerEffects()
  }
  
  
  
  @Unique("this")
  public void bad1(@Unique Test other1, @Unique Test other2) {
    compromiseRef(other1.u);
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad2(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
    compromiseRef(other1.u);
    readsInstance(this); // okay
    readsInstance(other2); // okay
    readsInstance(other1); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad3(@Unique Test other1, @Unique Test other2) {
    // Test that different parameters are distinguished by the error
    compromiseRef(other2.u);
    readsInstance(this); // okay
    readsInstance(other1); // okay
    readsInstance(other2); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad4(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly recognized and handled as actual argument
    compromiseRef(this.u);
    readsInstance(this); // trigger error in opLoadReachable() via considerEffects()
  }


  
  @RegionEffects("reads this:Instance")
  @Borrowed("this")
  private void readsInstance() {}
  
  
  @Unique("this")
  public void bad5(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
    compromiseRef(this.u);
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad6(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
    compromiseRef(other1.u);
    this.readsInstance(); // good
    other2.readsInstance(); // good
    other1.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad7(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter and that other variables can be used as the actual 
    compromiseRef(other2.u);
    this.readsInstance(); // good
    other1.readsInstance(); // good
    other2.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
  
  @Unique("this")
  public void bad8(@Unique Test other1, @Unique Test other2) {
    // Test that receiver is properly handled as the formal parameter AND as actual
    compromiseRef(this.u);
    other1.readsInstance(); // good
    other2.readsInstance(); // good
    this.readsInstance(); // trigger error in opLoadReachable() via considerEffects()
  }
}


