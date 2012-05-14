package opCheckTopState.viaOpConsume.viaTransferMethodBody;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume from transferMethodBody().
 * This is used to check the value returned by the method against the annotation
 * on the return node.
 */
public class Test {
  private final @Borrowed Object borrowedField = null;
  private @ReadOnly Object readOnlyField = null;
  private @Immutable Object immutableField = null;
  private Value valueField = null;
  private Object sharedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;
  
  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private static Object getReadOnly() { return null; }
  
  @Immutable("return")
  private static Object getImmutable() { return null; }
  
  // Return a value object
  private static Value getValue() { return null; }
  
  // Shared
  private static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Object getUnique() { return null; }
  
 
  
  
  // ***** return from formal parameters

  // cannot return a borrowed value
  
  // ReadOnly return
  
  @ReadOnly("return")
  @RegionEffects("writes p:Instance")
  public Object readOnlyReturn_borrowedParam(final @Borrowed(allowReturn=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_readOnlyParam(final @ReadOnly Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_immutableParam(final @Immutable Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_valueParam(final Value p) {
    Object local = p;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_sharedParam(final Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueParam(final @Unique Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  // Immutable return
  
  @Immutable("return")
  @RegionEffects("writes p:Instance")
  public Object immutableReturn_borrowedParam(final @Borrowed(allowReturn=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_readOnlyParam(final @ReadOnly Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_immutableParam(final @Immutable Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_valueParam(final Value p) {
    Object local = p;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_sharedParam(final Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueParam(final @Unique Object p) {
    Object local = p;
    return local; // GOOD
  }

  // Shared return
  
  @RegionEffects("writes p:Instance")
  public Object sharedReturn_borrowedParam(final @Borrowed(allowReturn=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  public Object sharedReturn_readOnlyParam(final @ReadOnly Object p) {
    Object local = p;
    return local; // BAD
  }
  
  public Object sharedReturn_immutableParam(final @Immutable Object p) {
    Object local = p;
    return local; // BAD
  }
  
  public Object sharedReturn_valueParam(final Value p) {
    Object local = p;
    return local; // GOOD
  }
  
  public Object sharedReturn_sharedParam(final Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueParam(final @Unique Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  // Unique write return
  
  @Unique(value="return", allowRead=true)
  @RegionEffects("writes p:Instance")
  public Object uniqueWriteReturn_borrowedParam(final @Borrowed(allowReturn=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_readOnlyParam(final @ReadOnly Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_immutableParam(final @Immutable Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_valueParam(final Value p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_sharedParam(final Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueParam(final @Unique Object p) {
    Object local = p;
    return local; // GOOD
  }
  
  // Unique return
  
  @Unique("return")
  @RegionEffects("writes p:Instance")
  public Object uniqueReturn_borrowedParam(final @Borrowed(allowReturn=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_readOnlyParam(final @ReadOnly Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_immutableParam(final @Immutable Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_valueParam(final Value p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_sharedParam(final Object p) {
    Object local = p;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_uniqueWriteParam(final @Unique(allowRead=true) Object p) {
    Object local = p;
    return local; // BAD
  }
  
  public Object uniqueReturn_uniqueParam(final @Unique Object p) {
    Object local = p;
    return local; // GOOD
  }



  // ***** return from method return value

  // cannot return a borrowed value
  
  // ReadOnly return
  
  // cannot return a borrowed value
  
  @ReadOnly("return")
  public Object readOnlyReturn_readOnlyReturn() {
    Object local = getReadOnly();
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_immutableReturn() {
    Object local = getImmutable();
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_valueReturn() {
    Object local = getValue();
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_sharedReturn() {
    Object local = getShared();
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueWriteReturn() {
    Object local = getUniqueWrite();
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueReturn() {
    Object local = getUnique();
    return local; // GOOD
  }
  
  // Immutable return
  
  // cannot return a borrowed value
  
  @Immutable("return")
  public Object immutableReturn_readOnlyReturn() {
    Object local = getReadOnly();
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_immutableReturn() {
    Object local = getImmutable();
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_valueReturn() {
    Object local = getValue();
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_sharedReturn() {
    Object local = getShared();
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueWriteReturn() {
    Object local = getUniqueWrite();
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueReturn() {
    Object local = getUnique();
    return local; // GOOD
  }
  
  // Shared return
  
  // cannot return a borrowed value
  
  public Object sharedReturn_readOnlyReturn() {
    Object local = getReadOnly();
    return local; // BAD
  }
  
  public Object sharedReturn_immutableReturn() {
    Object local = getImmutable();
    return local; // BAD
  }
  
  public Object sharedReturn_valueReturn() {
    Object local = getValue();
    return local; // GOOD
  }
  
  public Object sharedReturn_sharedReturn() {
    Object local = getShared();
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueWriteReturn() {
    Object local = getUniqueWrite();
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueReturn() {
    Object local = getUnique();
    return local; // GOOD
  }
  
  // Unique write return
  
  // cannot return a borrowed value
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_readOnlyReturn() {
    Object local = getReadOnly();
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_immutableReturn() {
    Object local = getImmutable();
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_valueReturn() {
    Object local = getValue();
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_sharedReturn() {
    Object local = getShared();
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueWriteReturn() {
    Object local = getUniqueWrite();
    return local; // GOOD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueReturn() {
    Object local = getUnique();
    return local; // GOOD
  }
  
  // Unique return
  
  // cannot return a borrowed value
  
  @Unique("return")
  public Object uniqueReturn_readOnlyReturn() {
    Object local = getReadOnly();
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_immutableReturn() {
    Object local = getImmutable();
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_valueReturn() {
    Object local = getValue();
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_sharedReturn() {
    Object local = getShared();
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_uniqueWriteReturn() {
    Object local = getUniqueWrite();
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_uniqueReturn() {
    Object local = getUnique();
    return local; // GOOD
  }



  // ***** return from field read

  // cannot return a borrowed value
  
  // ReadOnly return
  
  @ReadOnly("return")
  public Object readOnlyReturn_borrowedField() {
    Object local = borrowedField; // reads as unique
    return local; // GOOD
    // But, borrowed field is compromised
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_readOnlyField() {
    Object local = readOnlyField;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_immutableField() {
    Object local = immutableField;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_valueField() {
    Object local = valueField;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_sharedField() {
    Object local = sharedField;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueWriteField() {
    Object local = uniqueWriteField;
    uniqueWriteField = null;
    return local; // GOOD
  }
  
  @ReadOnly("return")
  public Object readOnlyReturn_uniqueField() {
    Object local = uniqueField;
    uniqueField = null;
    return local; // GOOD
  }
  
  // Immutable return
  
  @Immutable("return")
  public Object immutableReturn_borrowedField() {
    Object local = borrowedField; // reads as unique
    return local; // GOOD
    // But, borrowed field is compromised
  }
  
  @Immutable("return")
  public Object immutableReturn_readOnlyField() {
    Object local = readOnlyField;
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_immutableField() {
    Object local = immutableField;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_valueField() {
    Object local = valueField;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_sharedField() {
    Object local = sharedField;
    return local; // BAD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueWriteField() {
    Object local = uniqueWriteField;
    uniqueWriteField = null;
    return local; // GOOD
  }
  
  @Immutable("return")
  public Object immutableReturn_uniqueField() {
    Object local = uniqueField;
    uniqueField = null;
    return local; // GOOD
  }
  
  // Shared return
  
  public Object sharedReturn_borrowedField() {
    Object local = borrowedField; // reads as unique
    return local; // GOOD
    // But, borrowed field is compromised
  }
  
  public Object sharedReturn_readOnlyField() {
    Object local = readOnlyField;
    return local; // BAD
  }
  
  public Object sharedReturn_immutableField() {
    Object local = immutableField;
    return local; // BAD
  }
  
  public Object sharedReturn_valueField() {
    Object local = valueField;
    return local; // GOOD
  }
  
  public Object sharedReturn_sharedField() {
    Object local = sharedField;
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueWriteField() {
    Object local = uniqueWriteField;
    uniqueWriteField = null;
    return local; // GOOD
  }
  
  public Object sharedReturn_uniqueField() {
    Object local = uniqueField;
    uniqueField = null;
    return local; // GOOD
  }
  
  // Unique Write return
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_borrowedField() {
    Object local = borrowedField; // reads as unique
    return local; // GOOD
    // But, borrowed field is compromised
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_readOnlyField() {
    Object local = readOnlyField;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_immutableField() {
    Object local = immutableField;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_valueField() {
    Object local = valueField;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_sharedField() {
    Object local = sharedField;
    return local; // BAD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueWriteField() {
    Object local = uniqueWriteField;
    uniqueWriteField = null;
    return local; // GOOD
  }
  
  @Unique(value="return", allowRead=true)
  public Object uniqueWriteReturn_uniqueField() {
    Object local = uniqueField;
    uniqueField = null;
    return local; // GOOD
  }
  
  // Unique return
  
  @Unique("return")
  public Object uniqueReturn_borrowedField() {
    Object local = borrowedField; // reads as unique
    return local; // GOOD
    // But, borrowed field is compromised
  }
  
  @Unique("return")
  public Object uniqueReturn_readOnlyField() {
    Object local = readOnlyField;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_immutableField() {
    Object local = immutableField;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_valueField() {
    Object local = valueField;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_sharedField() {
    Object local = sharedField;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_uniqueWriteField() {
    Object local = uniqueWriteField;
    uniqueWriteField = null;
    return local; // BAD
  }
  
  @Unique("return")
  public Object uniqueReturn_uniqueField() {
    Object local = uniqueField;
    uniqueField = null;
    return local; // GOOD
  }
}


@Immutable
class Value {
}
