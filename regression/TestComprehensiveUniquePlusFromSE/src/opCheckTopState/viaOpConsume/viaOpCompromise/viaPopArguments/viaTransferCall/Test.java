package opCheckTopState.viaOpConsume.viaOpCompromise.viaPopArguments.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via opCompromise via popArguments
 * from transferCall().  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from popArguments is to shared 
 * the actuals that are bundled into an array when varags are used.
 */
public class Test {
  private final @Borrowed Object borrowedField = null;
  private @ReadOnly Object readOnlyField = null;
  private @Immutable Object immutableField = null;
  private Object sharedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

    
  
  @ReadOnly("return")
  private static Object getReadOnly() { return null; }
  
  @Immutable("return")
  private static Object getImmutable() { return null; }
  
  // Shared
  private static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Object getUnique() { return null; }


  
  @RegionEffects("none")
  public void method(final int x, final Object... varargs) {
    // do nothing
  }
  
  
  
  // ***** From formal parameters
  
  public void borrowedParam(final @Borrowed Object p) {
    method(0, p); // BAD
  }
  
  public void readOnlyParam(final @ReadOnly Object p) {
    method(0, p); // BAD
  }
  
  public void immutableParam(final @Immutable Object p) {
    method(0, p); // BAD
  }
  
  public void sharedParam(final Object p) {
    method(0, p); // GOOD
  }
  
  public void uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    method(0, p); // GOOD
  }
  
  public void uniqueParam(final @Unique Object p) {
    method(0, p); // GOOD
  }



  // ***** From method return
  
  // Cannot return a borrowed value
  
  public void readOnlyReturn() {
    method(0, getReadOnly()); // BAD
  }
  
  public void immutableReturn() {
    method(0, getImmutable()); // BAD
  }
  
  public void sharedReturn() {
    method(0, getShared()); // GOOD
  }
  
  public void uniqueWriteReturn() {
    method(0, getUniqueWrite()); // GOOD
  }
  
  public void uniqueReturn() {
    method(0, getUnique()); // GOOD
  }



  // ***** From fields
  
  public void borrowedField() {
    method(0, borrowedField); // GOOD: reads as unique
    // BAD: borrowed field becomes compromised
  }

  public void readOnlyField() {
    method(0, readOnlyField); // BAD
  }
  
  public void immutableField() {
    method(0, immutableField); // BAD
  }
  
  public void sharedField() {
    method(0, sharedField); // GOOD
  }
  
  public void uniqueWriteField() {
    try {
      method(0, uniqueWriteField); // GOOD
    } finally {
      uniqueWriteField = null;
    }
  }
  
  public void uniqueField() {
    try {
      method(0, uniqueField); // GOOD
    } finally {
      uniqueField = null;
    }
  }
}
