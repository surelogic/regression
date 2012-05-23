package opCheckTopState.viaOpConsume.viaOpCompromise.viaTransferArrayInitializer;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via opCompromise via 
 * transferArrayInitializer.  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from transferArrayInitializer 
 * is to share references that are placed in an array during an array
 * initialization: "new Object[] { a, b, c }" or simply "{ a, b, c }".
 */
@SuppressWarnings("unused")
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

  
  
  
  // ***** From formal parameters
  
  public void borrowedParam(final @Borrowed Object p) {
    Object[] o = { p }; // BAD
  }
  
  public void readOnlyParam(final @ReadOnly Object p) {
    Object[] o = { p }; // BAD
  }
  
  public void immutableParam(final @Immutable Object p) {
    Object[] o = { p }; // BAD
  }
  
  public void sharedParam(final Object p) {
    Object[] o = { p }; // GOOD
  }
  
  public void uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object[] o = { p }; // GOOD
  }
  
  public void uniqueParam(final @Unique Object p) {
    Object[] o = { p }; // GOOD
  }



  // ***** From method return
  
  // Cannot return a borrowed value
  
  public void readOnlyReturn() {
    Object[] o = { getReadOnly() }; // BAD
  }
  
  public void immutableReturn() {
    Object[] o = { getImmutable() }; // BAD
  }
  
  public void sharedReturn() {
    Object[] o = { getShared() }; // GOOD
  }
  
  public void uniqueWriteReturn() {
    Object[] o = { getUniqueWrite() }; // GOOD
  }
  
  public void uniqueReturn() {
    Object[] o = { getUnique() }; // GOOD
  }



  // ***** From fields
  
  public void borrowedField() {
    Object[] o = { borrowedField }; // GOOD: reads as unique
    // BAD: borrowed field becomes compromised
  }

  public void readOnlyField() {
    Object[] o = { readOnlyField }; // BAD
  }
  
  public void immutableField() {
    Object[] o = { immutableField }; // BAD
  }
  
  public void sharedField() {
    Object[] o = { sharedField }; // GOOD
  }
  
  public void uniqueWriteField() {
    try {
      Object[] o = { uniqueWriteField }; // GOOD
    } finally {
      uniqueWriteField = null;
    }
  }
  
  public void uniqueField() {
    try {
      Object[] o = { uniqueField }; // GOOD
    } finally {
      uniqueField = null;
    }
  }
}
