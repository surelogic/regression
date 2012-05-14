package opCheckTopState.viaOpCompromiseNoRelease.transferAssignArray;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

public class Test {
  /* Array elements are SHARED */
  private final Object[] array = new Object[1];
  
  private final @Borrowed Object borrowedField = null;
  private final @ReadOnly Object readOnlyField = null;
  private final @Immutable Object immutableField = null;
  private final Value valueField = null;
  private final Object sharedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;
  
  
  
  /* Via formal parameters */
  
  public void formal_borrowed(final @Borrowed Object p) {
    array[0] = p; // bad
  }
  
  public void formal_readOnly(final @ReadOnly Object p) {
    array[0] = p; // bad
  }
  
  public void formal_immutable(final @Immutable Object p) {
    array[0] = p; // bad
  }
  
  public void formal_immutableTrick(final Value p) {
    array[0] = p; // good
  }
  
  public void formal_shared(final Object p) {
    array[0] = p; // good
  }
  
  public void formal_uniqueWrite(final @Unique(allowRead=true) Object p) {
    array[0] = p; // good
  }
  
  public void formal_unique(final @Unique Object p) {
    array[0] = p; // good
  }
  
  
  
  /* Via fields */
  
  public void field_borrowed() {
    array[0] = borrowedField; // okay, borrowed field read yields a @Unique value
    /* but, the borrowedField is compromised at the end of the method, and 
     * because the field must be final, it cannot be repaired.
     */
  }
  
  public void field_readOnly() {
    array[0] = readOnlyField; // bad
  }
  
  public void field_immutable() {
    array[0] = immutableField; // bad
  }
  
  public void field_immutableTrick() {
    array[0] = valueField; // good
  }
  
  public void field_shared() {
    array[0] = sharedField; // good
  }
  
  public void field_uniqueWrite() {
    array[0] = uniqueWriteField; // good
    uniqueWriteField = null;
  }
  
  public void field_unique() {
    array[0] = uniqueField; // good
    uniqueField = null;
  }
  
  
  
  /* Via return values */
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private Object getReadOnly() { return null; }
  
  @Immutable("return")
  private Object getImmutable() { return null; }
  
  // Return a value object
  private Value getValue() { return null; }
  
  // Shared
  private Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private Object getUnique() { return null; }
  
  
  
  // Cannot return a borrowed value
  
  public void returnValue_readOnly() {
    array[0] = getReadOnly(); // bad
  }
  
  public void returnValue_immutable() {
    array[0] = getImmutable(); // bad
  }
  
  public void returnValue_immutableTrick() {
    array[0] = getValue(); // good
  }
  
  public void returnValue_shared() {
    array[0] = getShared(); // good
  }
  
  public void returnValue_uniqueWrite() {
    array[0] = getUniqueWrite(); // good
  }
  
  public void returnValue_unique() {
    array[0] = getUnique(); // good
  }

}


@Immutable
class Value {
}