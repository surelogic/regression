package opCheckTopState.viaOpStore.viaTransferAssignField;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Check opCheckTopState() when called by opStore() via transferAssignField().
 * This only happens when the field being assigned to is @Unique or
 * @Unique(allowRead=true).
 */
@SuppressWarnings("unused")
public class Test {
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

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

  // UniqueWrite field
  
  public void uniqueWriteField_borrowedParam(final @Borrowed Object o) {
    uniqueWriteField = o; // BAD
  }
  
  public void uniqueWriteField_readOnlyParam(final @ReadOnly Object o) {
    uniqueWriteField = o; // BAD
  }
  
  public void uniqueWriteField_immutableParam(final @Immutable Object o) {
    uniqueWriteField = o; // BAD
  }
  
  public void uniqueWriteField_valueParam(final Value o) {
    uniqueWriteField = o; // BAD
  }
  
  public void uniqueWriteField_sharedParam(final Object o) {
    uniqueWriteField = o; // BAD
  }
  
  public void uniqueWriteField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    uniqueWriteField = o; // GOOD
  }
  
  public void uniqueWriteField_uniqueParam(final @Unique Object o) {
    uniqueWriteField = o; // GOOD
  }
  
  // Unique field
  
  public void uniqueField_borrowedParam(final @Borrowed Object o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_readOnlyParam(final @ReadOnly Object o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_immutableParam(final @Immutable Object o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_valueParam(final Value o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_sharedParam(final Object o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_uniqueWriteParam(final @Unique(allowRead=true) Object o) {
    uniqueField = o; // BAD
  }
  
  public void uniqueField_uniqueParam(final @Unique Object o) {
    uniqueField = o; // GOOD
  }

  
  
  // ***** Assignment from method return values
   
  // UniqueWrite field
  
  // Cannot have a borrowed return value
  
  public void uniqueWriteField_readOnlyReturn() {
    uniqueWriteField = getReadOnly(); // BAD
  }
  
  public void uniqueWriteField_immutableReturn() {
    uniqueWriteField = getImmutable(); // BAD
  }
  
  public void uniqueWriteField_valueReturn() {
    uniqueWriteField = getValue(); // BAD
  }
  
  public void uniqueWriteField_sharedReturn() {
    uniqueWriteField = getShared(); // BAD
  }
  
  public void uniqueWriteField_uniqueWriteReturn() {
    uniqueWriteField = getUniqueWrite(); // GOOD
  }
  
  public void uniqueWriteField_uniqueReturn() {
    uniqueWriteField = getUnique(); // GOOD
  }
  
  // Unique field
  
  // Cannot have a borrowed return value
  
  public void uniqueField_readOnlyReturn() {
    uniqueField = getReadOnly(); // BAD
  }
  
  public void uniqueField_immutableReturn() {
    uniqueField = getImmutable(); // BAD
  }
  
  public void uniqueField_valueReturn() {
    uniqueField = getValue(); // BAD
  }
  
  public void uniqueField_sharedReturn() {
    uniqueField = getShared(); // BAD
  }
  
  public void uniqueField_uniqueWriteReturn() {
    uniqueField = getUniqueWrite(); // BAD
  }
  
  public void uniqueField_uniqueReturn() {
    uniqueField = getUnique(); // GOOD
  }
  
  
  
  // ***** Assignment from fields

  // UniqueWrite field
  
  public void uniqueWriteField_borrowedField() {
    uniqueWriteField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public void uniqueWriteField_readOnlyField() {
    uniqueWriteField = readOnlyField2; // BAD
  }
  
  public void uniqueWriteField_immutableField() {
    uniqueWriteField = immutableField2; // BAD
  }
  
  public void uniqueWriteField_valueField() {
    uniqueWriteField = valueField2; // BAD
  }
  
  public void uniqueWriteField_sharedField() {
    uniqueWriteField = sharedField2; // BAD
  }
  
  public void uniqueWriteField_uniqueWriteField() {
    uniqueWriteField = uniqueWriteField2; // GOOD
    uniqueWriteField2 = null;
  }
  
  public void uniqueWriteField_uniqueField() {
    uniqueWriteField = uniqueField2; // GOOD
    uniqueField2 = null;
  }

  // Unique field
  
  public void uniqueField_borrowedField() {
    uniqueField = borrowedField2; // GOOD: Borrowed field reads as unique
    // BAD: borrowed field is compromised however
  }
  
  public void uniqueField_readOnlyField() {
    uniqueField = readOnlyField2; // BAD
  }
  
  public void uniqueField_immutableField() {
    uniqueField = immutableField2; // BAD
  }
  
  public void uniqueField_valueField() {
    uniqueField = valueField2; // BAD
  }
  
  public void uniqueField_sharedField() {
    uniqueField = sharedField2; // BAD
  }
  
  public void uniqueField_uniqueWriteField() {
    uniqueField = uniqueWriteField2; // BAD
    uniqueWriteField2 = null;
  }
  
  public void uniqueField_uniqueField() {
    uniqueField = uniqueField2; // GOOD
    uniqueField2 = null;
  }
}


@Immutable
class Value {
}
