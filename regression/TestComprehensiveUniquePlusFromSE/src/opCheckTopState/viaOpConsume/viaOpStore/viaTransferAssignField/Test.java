package opCheckTopState.viaOpConsume.viaOpStore.viaTransferAssignField;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Don't have to check for assignment to @Borrowed fields because 
 * opCheckTopState is not used for them, opReturn is.
 */
@SuppressWarnings("unused")
public class Test {
  private @ReadOnly Object readOnlyField = null;
  private @Immutable Object immutableField = null;
  private Value valueField = null;
  private Object sharedField = null;

  private final @Borrowed Object borrowedField2 = null;
  private @ReadOnly Object readOnlyField2 = null;
  private @Immutable Object immutableField2 = null;
  private Value valueField2 = null;
  private Object sharedField2 = null;
  private @Unique(allowRead=true) Object uniqueWriteField2 = null;
  private @Unique Object uniqueField2 = null;

  
  
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
  
 
  
  
  // ***** Assignment from formal parameters
  
  // ReadOnly field
  
  public void readOnlyField_borrowedParam(final @Borrowed Object o) {
    readOnlyField = o; // BAD
  }
  
  public void readOnlyField_readOnlyParam(final @ReadOnly Object o) {
    readOnlyField = o; // GOOD
  }
  
  public void readOnlyField_immutableParam(final @Immutable Object o) {
    readOnlyField = o; // GOOD
  }
  
  public void readOnlyField_valueParam(final Value o) {
    readOnlyField = o; // GOOD
  }
  
  public void readOnlyField_sharedParam(final Object o) {
    readOnlyField = o; // GOOD
  }
  
  public void readOnlyField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    readOnlyField = o; // GOOD
  }
  
  public void readOnlyField_uniqueParam(final @Unique Object o) {
    readOnlyField = o; // GOOD
  }
  
  // Immutable field
  
  public void immutableField_borrowedParam(final @Borrowed Object o) {
    immutableField = o; // BAD
  }
  
  public void immutableField_readOnlyParam(final @ReadOnly Object o) {
    immutableField = o; // BAD
  }
  
  public void immutableField_immutableParam(final @Immutable Object o) {
    immutableField = o; // GOOD
  }
  
  public void immutableField_valueParam(final Value o) {
    immutableField = o; // GOOD
  }
  
  public void immutableField_sharedParam(final Object o) {
    immutableField = o; // BAD
  }
  
  public void immutableField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    immutableField = o; // GOOD
  }
  
  public void immutableField_uniqueParam(final @Unique Object o) {
    immutableField = o; // GOOD
  }
  
  // Shared field
  
  public void sharedField_borrowedParam(final @Borrowed Object o) {
    sharedField = o; // BAD
  }
  
  public void sharedField_readOnlyParam(final @ReadOnly Object o) {
    sharedField = o; // BAD
  }
  
  public void sharedField_immutableParam(final @Immutable Object o) {
    sharedField = o; // BAD
  }
  
  public void sharedField_valueParam(final Value o) {
    sharedField = o; // GOOD
  }
  
  public void sharedField_sharedParam(final Object o) {
    sharedField = o; // GOOD
  }
  
  public void sharedField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    sharedField = o; // GOOD
  }
  
  public void sharedField_uniqueParam(final @Unique Object o) {
    sharedField = o; // GOOD
  }

  
  
  // ***** Assignment from method return values
  
  // ReadOnly field
  
  // Cannot have a borrowed return value
  
  public void readOnlyField_readOnlyReturn() {
    readOnlyField = getReadOnly(); // GOOD
  }
  
  public void readOnlyField_immutableReturn() {
    readOnlyField = getImmutable(); // GOOD
  }
  
  public void readOnlyField_valueReturn() {
    readOnlyField = getValue(); // GOOD
  }
  
  public void readOnlyField_sharedReturn() {
    readOnlyField = getShared(); // GOOD
  }
  
  public void readOnlyField_uniqueWriteReturn() {
    readOnlyField = getUniqueWrite(); // GOOD
  }
  
  public void readOnlyField_uniqueReturn() {
    readOnlyField = getUnique(); // GOOD
  }
  
  // Immutable field
  
  // Cannot have a borrowed return value
  
  public void immutableField_readOnlyReturn() {
    immutableField = getReadOnly(); // BAD
  }
  
  public void immutableField_immutableReturn() {
    immutableField = getImmutable(); // GOOD
  }
  
  public void immutableField_valueReturn() {
    immutableField = getValue(); // GOOD
  }
  
  public void immutableField_sharedReturn() {
    immutableField = getShared(); // BAD
  }
  
  public void immutableField_uniqueWriteReturn() {
    immutableField = getUniqueWrite(); // GOOD
  }
  
  public void immutableField_uniqueReturn() {
    immutableField = getUnique(); // GOOD
  }
  
  // Shared field
  
  // Cannot have a borrowed return value
  
  public void sharedField_readOnlyReturn() {
    sharedField = getReadOnly(); // BAD
  }
  
  public void sharedField_immutableReturn() {
    sharedField = getImmutable(); // BAD
  }
  
  public void sharedField_valueReturn() {
    sharedField = getValue(); // GOOD
  }
  
  public void sharedField_sharedReturn() {
    sharedField = getShared(); // GOOD
  }
  
  public void sharedField_uniqueWriteReturn() {
    sharedField = getUniqueWrite(); // GOOD
  }
  
  public void sharedField_uniqueReturn() {
    sharedField = getUnique(); // GOOD
  }
  
  
  
  // ***** Assignment from fields
  
  // ReadOnly field
  
  public void readOnlyField_borrowedField() {
    readOnlyField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public void readOnlyField_readOnlyField() {
    readOnlyField = readOnlyField2; // GOOD
  }
  
  public void readOnlyField_immutableField() {
    readOnlyField = immutableField2; // GOOD
  }
  
  public void readOnlyField_valueField() {
    readOnlyField = valueField2; // GOOD
  }
  
  public void readOnlyField_sharedField() {
    readOnlyField = sharedField2; // GOOD
  }
  
  public void readOnlyField_uniqueWriteField() {
    readOnlyField = uniqueWriteField2; // GOOD
    uniqueWriteField2 = null;
  }
  
  public void readOnlyField_uniqueField() {
    readOnlyField = uniqueField2; // GOOD
    uniqueField2 = null;
  }

  // Immutable field
  
  public void immutableField_borrowedField() {
    immutableField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public void immutableField_readOnlyField() {
    immutableField = readOnlyField2; // BAD
  }
  
  public void immutableField_immutableField() {
    immutableField = immutableField2; // GOOD
  }
  
  public void immutableField_valueField() {
    immutableField = valueField2; // GOOD
  }
  
  public void immutableField_sharedField() {
    immutableField = sharedField2; // BAD
  }
  
  public void immutableField_uniqueWriteField() {
    immutableField = uniqueWriteField2; // GOOD
    uniqueWriteField2 = null;
  }
  
  public void immutableField_uniqueField() {
    immutableField = uniqueField2; // GOOD
    uniqueField2 = null;
  }

  // Shared field
  
  public void sharedField_borrowedField() {
    sharedField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public void sharedField_readOnlyField() {
    sharedField = readOnlyField2; // BAD
  }
  
  public void sharedField_immutableField() {
    sharedField = immutableField2; // BAD
  }
  
  public void sharedField_valueField() {
    sharedField = valueField2; // GOOD
  }
  
  public void sharedField_sharedField() {
    sharedField = sharedField2; // GOOD
  }
  
  public void sharedField_uniqueWriteField() {
    sharedField = uniqueWriteField2; // GOOD
    uniqueWriteField2 = null;
  }
  
  public void sharedField_uniqueField() {
    sharedField = uniqueField2; // GOOD
    uniqueField2 = null;
  }

}


@Immutable
class Value {
}
