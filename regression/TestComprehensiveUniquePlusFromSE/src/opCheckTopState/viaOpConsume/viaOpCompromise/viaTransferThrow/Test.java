package opCheckTopState.viaOpConsume.viaOpCompromise.viaTransferThrow;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via opCompromise via 
 * transferThrow.  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from transferThrow 
 * compromises a reference to an exception when it is thrown.
 */
public class Test {
  private final @Borrowed Exception borrowedField = null;
  private @ReadOnly Exception readOnlyField = null;
  private @Immutable Exception immutableField = null;
  private Exception sharedField = null;
  private @Unique(allowRead=true) Exception uniqueWriteField = null;
  private @Unique Exception uniqueField = null;

  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private Exception getReadOnly() { return null; }
  
  @Immutable("return")
  private Exception getImmutable() { return null; }
  
  // Shared
  private Exception getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private Exception getUniqueWrite() { return null; }
  
  @Unique("return")
  private Exception getUnique() { return null; }

  
  
  public void borrowedParam(final @Borrowed Exception e) throws Exception {
    throw e; // bad
  }
  
  public void readOnlyParam(final @ReadOnly Exception e) throws Exception {
    throw e; // bad
  }
  
  public void immutableParam(final @Immutable Exception e) throws Exception {
    throw e; // bad
  }
  
  public void sharedParam(final Exception e) throws Exception {
    throw e; // good
  }
  
  public void uniqueWriteParam(final @Unique(allowRead=true) Exception e) throws Exception {
    throw e; // good
  }
  
  public void uniqueParam(final @Unique Exception e) throws Exception {
    throw e; // good
  }

  
  
  // cannot return a borrowed value
  
  public void readOnlyReturn() throws Exception {
    throw getReadOnly(); // bad
  }
  
  public void immutableReturn() throws Exception {
    throw getImmutable(); // bad
  }
  
  public void sharedReturn() throws Exception {
    throw getShared(); // good
  }
  
  public void uniqueWriteReturn() throws Exception {
    throw getUniqueWrite(); // good
  }
  
  public void uniqueReturn() throws Exception {
    throw getUnique(); // good
  }

  
  
  public void borrowedField() throws Exception {
    throw borrowedField; // GOOD: reads as unique
    // BAD: borrowed field is compromised
  }

  public void readOnlyField() throws Exception {
    throw readOnlyField; // bad
  }

  public void immutableField() throws Exception {
    throw immutableField; // bad
  }

  public void sharedField() throws Exception {
    throw sharedField; // good
  }

  public void uniqueWriteField() throws Exception {
    try {
      throw uniqueWriteField; // good
    } finally {
      uniqueWriteField = null;
    }
  }

  public void uniqueField() throws Exception {
    try {
      throw uniqueField; // good
    } finally {
      uniqueField = null;
    }
  }
}
