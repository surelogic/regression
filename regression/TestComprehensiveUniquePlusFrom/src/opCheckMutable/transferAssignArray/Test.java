package opCheckMutable.transferAssignArray;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Test opCheckMutable() when it is called from transferAssignArray().
 * What this does is make sure that when we have an assignment "a[i] = x"
 * that a does not refer to a @ReadOnly or @Immutable
 * reference.  
 * 
 * Need to test the cases where 'a' is from a 
 * formal parameter (cannot be the receiver), return value, and field reference.
 */
public class Test {
  private final @Borrowed int[] borrowedField;
  private final @Immutable int[] immutableField;
  private final @ReadOnly int[] readOnlyField;
  private final /*SHARED*/ int[] sharedField;
  private final @Unique(allowRead=true) int[] uniqueWriteField;
  private final @Unique int[] uniqueField;
  
  
  
  public Test() {
    borrowedField = null;
    immutableField = null;
    readOnlyField = null;
    sharedField = null;
    uniqueWriteField = null;
    uniqueField = null;
  }
  
  
  
  /*
   * === Test Formal Parameters (non-receiver)
   */
  
  public void param_borrowed(final @Borrowed int[] p) {
    p[0] = 1;
  }

  public void param_readOnly(final @ReadOnly int[] p) {
    p[0] = 1;
  }

  public void param_immutable(final @Immutable int[] p) {
    p[0] = 1;
  }

  public void param_shared(final /*SHARED*/ int[] p) {
    p[0] = 1;
  }

  public void param_uniqueWrite(final @Unique(allowRead=true) int[] p) {
    p[0] = 1;
  }

  public void param_unique(final @Unique int[] p) {
    p[0] = 1;
  }



  /*
   * === Test Return Values
   */

  // no such thing as borrowed return value
  
  @ReadOnly("return")
  private int[] getReadOnly() {
    return null;
  }
  
  @Immutable("return")
  private int[] getImmutable() {
    return null;
  }
  
  /*SHARED return*/
  private int[] getShared() {
    return null;
  }
  
  @Unique(value="return", allowRead=true) 
  private int[] getUniqueWrite() {
    return null;
  }
  
  @Unique("return")
  private int[] getUnique() {
    return null;
  }
  
  // no such thing as a borrowed return value
  
  public void returnValue_readOnly() {
    int[] c = getReadOnly();
    c[0] = 1;
  }
  
  public void returnValue_immutable() {
    int[] c = getImmutable();
    c[0] = 1;
  }
  
  public void returnValue_shared() {
    int[] c = getShared();
    c[0] = 1;
  }
  
  public void returnValue_uniqueWrite() {
    int[] c = getUniqueWrite();
    c[0] = 1;
  }
  
  public void returnValue_unique() {
    int[] c = getUnique();
    c[0] = 1;
  }



  /*
   * === Test Fields
   */

  public void fieldRef_borrowed() {
    this.borrowedField[0] = 1;
  }

  public void fieldRef_readOnly() {
    this.readOnlyField[0] = 1;
  }

  public void fieldRef_immutable() {
    this.immutableField[0] = 1;
  }

  public void fieldRef_shared() {
    this.sharedField[0] = 1;
  }

  public void fieldRef_uniqueWrite() {
    this.uniqueWriteField[0] = 1;
  }

  public void fieldRef_unique() {
    this.uniqueField[0] = 1;
  }
}
