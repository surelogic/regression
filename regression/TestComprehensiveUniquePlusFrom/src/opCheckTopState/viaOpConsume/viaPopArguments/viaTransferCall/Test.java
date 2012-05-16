package opCheckTopState.viaOpConsume.viaPopArguments.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popArguments from
 * transferCall().  This is used to check the state of an actual argument
 * against the annotation on the declared argument of the called method.
 */
public class Test {
  private final @Borrowed Object borrowedField = null;
  private @ReadOnly Object readOnlyField = null;
  private @Immutable Object immutableField = null;
  private Value valueField = null;
  private Object sharedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

  
  
  // Methods to be called
  
  @RegionEffects("reads nothing")
  public void borrowedArgument(@Borrowed Object p) {}
  
  @RegionEffects("reads nothing")
  public void readOnlyArgument(@ReadOnly Object p) {}
  
  @RegionEffects("reads nothing")
  public void immutableArgument(@Immutable Object p) {}
  
  @RegionEffects("reads nothing")
  public void sharedArgument(Object p) {}
  
  @RegionEffects("reads nothing")
  public void uniqueWriteArgument(@Unique(allowRead=true) Object p) {}
  
  @RegionEffects("reads nothing")
  public void uniqueArgument(@Unique Object p) {}

  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private static Object getReadOnly() { return null; }
  
  @Immutable("return")
  private static Object getImmutable() { return null; }
  
  private static Value getValue() { return null; }
  
  // Shared
  private static Object getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Object getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Object getUnique() { return null; }
  
 
  
  
  // ***** formal parameters

  // Borrowed actual
  
  public void borrowedActual_borrowedParam(@Borrowed Object p) {
    borrowedArgument(p); // GOOD
  }
  
  public void borrowedActual_readOnlyParam(@ReadOnly Object p) {
    borrowedArgument(p); // GOOD
  }
  
  public void borrowedActual_immutableParam(@Immutable Object p) {
    borrowedArgument(p); // GOOD
  }
  
  public void borrowedActual_valueParam(Value p) {
    borrowedArgument(p); // GOOD
  }

  public void borrowedActual_sharedParam(Object p) {
    borrowedArgument(p); // GOOD
  }

  public void borrowedActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    borrowedArgument(p); // GOOD
  }

  public void borrowedActual_uniqueParam(@Unique Object p) {
    borrowedArgument(p); // GOOD
  }

  // ReadOnly actual
  
  public void readOnlyActual_borrowedParam(@Borrowed Object p) {
    readOnlyArgument(p); // BAD
  }
  
  public void readOnlyActual_readOnlyParam(@ReadOnly Object p) {
    readOnlyArgument(p); // GOOD
  }
  
  public void readOnlyActual_immutableParam(@Immutable Object p) {
    readOnlyArgument(p); // GOOD
  }
  
  public void readOnlyActual_valueParam(Value p) {
    readOnlyArgument(p); // GOOD
  }

  public void readOnlyActual_sharedParam(Object p) {
    readOnlyArgument(p); // GOOD
  }

  public void readOnlyActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    readOnlyArgument(p); // GOOD
  }

  public void readOnlyActual_uniqueParam(@Unique Object p) {
    readOnlyArgument(p); // GOOD
  }

  // Immutable actual
  
  public void immutableActual_borrowedParam(@Borrowed Object p) {
    immutableArgument(p); // BAD
  }
  
  public void immutableActual_readOnlyParam(@ReadOnly Object p) {
    immutableArgument(p); // BAD
  }
  
  public void immutableActual_immutableParam(@Immutable Object p) {
    immutableArgument(p); // GOOD
  }
  
  public void immutableActual_valueParam(Value p) {
    immutableArgument(p); // GOOD
  }

  public void immutableActual_sharedParam(Object p) {
    immutableArgument(p); // BAD
  }

  public void immutableActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    immutableArgument(p); // GOOD
  }

  public void immutableActual_uniqueParam(@Unique Object p) {
    immutableArgument(p); // GOOD
  }

  // Shared actual
  
  public void sharedActual_borrowedParam(@Borrowed Object p) {
    sharedArgument(p); // BAD
  }
  
  public void sharedActual_readOnlyParam(@ReadOnly Object p) {
    sharedArgument(p); // BAD
  }
  
  public void sharedActual_immutableParam(@Immutable Object p) {
    sharedArgument(p); // BAD
  }
  
  public void sharedActual_valueParam(Value p) {
    sharedArgument(p); // GOOD
  }

  public void sharedActual_sharedParam(Object p) {
    sharedArgument(p); // GOOD
  }

  public void sharedActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    sharedArgument(p); // GOOD
  }

  public void sharedActual_uniqueParam(@Unique Object p) {
    sharedArgument(p); // GOOD
  }

  // Unique write actual
  
  public void uniqueWriteActual_borrowedParam(@Borrowed Object p) {
    uniqueWriteArgument(p); // BAD
  }
  
  public void uniqueWriteActual_readOnlyParam(@ReadOnly Object p) {
    uniqueWriteArgument(p); // BAD
  }
  
  public void uniqueWriteActual_immutableParam(@Immutable Object p) {
    uniqueWriteArgument(p); // BAD
  }

  public void uniqueWriteActual_valueParam(Value p) {
    uniqueWriteArgument(p); // BAD
  }
  
  public void uniqueWriteActual_sharedParam(Object p) {
    uniqueWriteArgument(p); // BAD
  }

  public void uniqueWriteActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    uniqueWriteArgument(p); // GOOD
  }

  public void uniqueWriteActual_uniqueParam(@Unique Object p) {
    uniqueWriteArgument(p); // GOOD
  }

  // Unique actual
  
  public void uniqueActual_borrowedParam(@Borrowed Object p) {
    uniqueArgument(p); // BAD
  }
  
  public void uniqueActual_readOnlyParam(@ReadOnly Object p) {
    uniqueArgument(p); // BAD
  }
  
  public void uniqueActual_immutableParam(@Immutable Object p) {
    uniqueArgument(p); // BAD
  }

  public void uniqueActual_valueParam(Value p) {
    uniqueArgument(p); // BAD
  }
  
  public void uniqueActual_sharedParam(Object p) {
    uniqueArgument(p); // BAD
  }

  public void uniqueActual_uniqueWriteParam(@Unique(allowRead=true) Object p) {
    uniqueArgument(p); // BAD
  }

  public void uniqueActual_uniqueParam(@Unique Object p) {
    uniqueArgument(p); // GOOD
  }
  
  // ***** method return parameters

  // Borrowed actual
  
  // cannot return a borrowed value

  public void borrowedActual_readOnlyReturn() {
    Object x = getReadOnly();
    borrowedArgument(x); // GOOD
  }

  public void borrowedActual_immutableReturn() {
    Object x = getImmutable();
    borrowedArgument(x); // GOOD
  }

  public void borrowedActual_valueReturn() {
    Value x = getValue();
    borrowedArgument(x); // GOOD
  }
  
  public void borrowedActual_sharedReturn() {
    Object x = getShared();
    borrowedArgument(x); // GOOD
  }

  public void borrowedActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    borrowedArgument(x); // GOOD
  }

  public void borrowedActual_uniqueReturn() {
    Object x = getUnique();
    borrowedArgument(x); // GOOD
  }

  // ReadOnly actual
  
  // cannot return a borrowed value

  public void readOnlyActual_readOnlyReturn() {
    Object x = getReadOnly();
    readOnlyArgument(x); // GOOD
  }

  public void readOnlyActual_immutableReturn() {
    Object x = getImmutable();
    readOnlyArgument(x); // GOOD
  }
  
  public void readOnlyActual_valueReturn() {
    Value x = getValue();
    readOnlyArgument(x); // GOOD
  }

  public void readOnlyActual_sharedReturn() {
    Object x = getShared();
    readOnlyArgument(x); // GOOD
  }

  public void readOnlyActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    readOnlyArgument(x); // GOOD
  }

  public void readOnlyActual_uniqueReturn() {
    Object x = getUnique();
    readOnlyArgument(x); // GOOD
  }

  // Immutable actual
  
  // cannot return a borrowed value

  public void immutableActual_readOnlyReturn() {
    Object x = getReadOnly();
    immutableArgument(x); // BAD
  }

  public void immutableActual_immutableReturn() {
    Object x = getImmutable();
    immutableArgument(x); // GOOD
  }

  public void immutableActual_valueReturn() {
    Value x = getValue();
    immutableArgument(x); // GOOD
  }
  
  public void immutableActual_sharedReturn() {
    Object x = getShared();
    immutableArgument(x); // BAD
  }

  public void immutableActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    immutableArgument(x); // GOOD
  }

  public void immutableActual_uniqueReturn() {
    Object x = getUnique();
    immutableArgument(x); // GOOD
  }

  // Shared actual
  
  // cannot return a borrowed value

  public void sharedActual_readOnlyReturn() {
    Object x = getReadOnly();
    sharedArgument(x); // BAD
  }

  public void sharedActual_immutableReturn() {
    Object x = getImmutable();
    sharedArgument(x); // BAD
  }

  public void sharedActual_valueReturn() {
    Value x = getValue();
    sharedArgument(x); // GOOD
  }
  
  public void sharedActual_sharedReturn() {
    Object x = getShared();
    sharedArgument(x); // GOOD
  }

  public void sharedActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    sharedArgument(x); // GOOD
  }

  public void sharedActual_uniqueReturn() {
    Object x = getUnique();
    sharedArgument(x); // GOOD
  }

  // UniqueWrite actual
  
  // cannot return a borrowed value

  public void uniqueWriteActual_readOnlyReturn() {
    Object x = getReadOnly();
    uniqueWriteArgument(x); // BAD
  }

  public void uniqueWriteActual_immutableReturn() {
    Object x = getImmutable();
    uniqueWriteArgument(x); // BAD
  }

  public void uniqueWriteActual_valueReturn() {
    Value x = getValue();
    uniqueWriteArgument(x); // BAD
  }
  
  public void uniqueWriteActual_sharedReturn() {
    Object x = getShared();
    uniqueWriteArgument(x); // BAD
  }

  public void uniqueWriteActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    uniqueWriteArgument(x); // GOOD
  }

  public void uniqueWriteActual_uniqueReturn() {
    Object x = getUnique();
    uniqueWriteArgument(x); // GOOD
  }

  // Unique actual
  
  // cannot return a borrowed value

  public void uniqueActual_readOnlyReturn() {
    Object x = getReadOnly();
    uniqueArgument(x); // BAD
  }

  public void uniqueActual_immutableReturn() {
    Object x = getImmutable();
    uniqueArgument(x); // BAD
  }

  public void uniqueActual_valueReturn() {
    Value x = getValue();
    uniqueArgument(x); // BAD
  }
  
  public void uniqueActual_sharedReturn() {
    Object x = getShared();
    uniqueArgument(x); // BAD
  }

  public void uniqueActual_uniqueWriteReturn() {
    Object x = getUniqueWrite();
    uniqueArgument(x); // BAD
  }

  public void uniqueActual_uniqueReturn() {
    Object x = getUnique();
    uniqueArgument(x); // GOOD
  }


  // ***** Field values
  
  // Borrowed actual

  public void borrowedActual_borrowedField() {
    borrowedArgument(this.borrowedField); // GOOD
  }

  public void borrowedActual_readOnlyField() {
    borrowedArgument(this.readOnlyField); // GOOD
  }

  public void borrowedActual_immutableField() {
    borrowedArgument(this.immutableField); // GOOD
  }

  public void borrowedActual_valueField() {
    borrowedArgument(this.valueField); // GOOD
  }
  
  public void borrowedActual_sharedField() {
    borrowedArgument(this.sharedField); // GOOD
  }

  public void borrowedActual_uniqueWriteField() {
    borrowedArgument(this.uniqueWriteField); // GOOD
  }

  public void borrowedActual_uniqueField() {
    borrowedArgument(this.uniqueField); // GOOD
  }
  
  // Read Only actual

  public void readOnlyActual_borrowedField() {
    readOnlyArgument(this.borrowedField); // GOOD: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void readOnlyActual_readOnlyField() {
    readOnlyArgument(this.readOnlyField); // GOOD
  }

  public void readOnlyActual_immutableField() {
    readOnlyArgument(this.immutableField); // GOOD
  }

  public void readOnlyActual_valueField() {
    readOnlyArgument(this.valueField); // GOOD
  }
  
  public void readOnlyActual_sharedField() {
    readOnlyArgument(this.sharedField); // GOOD
  }

  public void readOnlyActual_uniqueWriteField() {
    try {
      readOnlyArgument(this.uniqueWriteField); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void readOnlyActual_uniqueField() {
    try {
      readOnlyArgument(this.uniqueField); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
   
  // Immutable actual

  public void immutableActual_borrowedField() {
    immutableArgument(this.borrowedField); // GOOD: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void immutableActual_readOnlyField() {
    immutableArgument(this.readOnlyField); // BAD
  }

  public void immutableActual_immutableField() {
    immutableArgument(this.immutableField); // GOOD
  }

  public void immutableActual_valueField() {
    immutableArgument(this.valueField); // GOOD
  }
  
  public void immutableActual_sharedField() {
    immutableArgument(this.sharedField); // BAD
  }

  public void immutableActual_uniqueWriteField() {
    try {
      immutableArgument(this.uniqueWriteField); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void immutableActual_uniqueField() {
    try {
      immutableArgument(this.uniqueField); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Shared actual

  public void sharedActual_borrowedField() {
    sharedArgument(this.borrowedField); // GOOD: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void sharedActual_readOnlyField() {
    sharedArgument(this.readOnlyField); // BAD
  }

  public void sharedActual_immutableField() {
    sharedArgument(this.immutableField); // BAD
  }

  public void sharedActual_valueField() {
    sharedArgument(this.valueField); // GOOD
  }
  
  public void sharedActual_sharedField() {
    sharedArgument(this.sharedField); // GOOD
  }

  public void sharedActual_uniqueWriteField() {
    try {
      sharedArgument(this.uniqueWriteField); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void sharedActual_uniqueField() {
    try {
      sharedArgument(this.uniqueField); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Unique write actual

  public void uniqueWriteActual_borrowedField() {
    uniqueWriteArgument(this.borrowedField); // GOOD: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void uniqueWriteActual_readOnlyField() {
    uniqueWriteArgument(this.readOnlyField); // BAD
  }

  public void uniqueWriteActual_immutableField() {
    uniqueWriteArgument(this.immutableField); // BAD
  }

  public void uniqueWriteActual_valueField() {
    uniqueWriteArgument(this.valueField); // BAD
  }
  
  public void uniqueWriteActual_sharedField() {
    uniqueWriteArgument(this.sharedField); // BAD
  }

  public void uniqueWriteActual_uniqueWriteField() {
    try {
      uniqueWriteArgument(this.uniqueWriteField); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueWriteActual_uniqueField() {
    try {
      uniqueWriteArgument(this.uniqueField); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Unique actual

  public void uniqueActual_borrowedField() {
    uniqueArgument(this.borrowedField); // GOOD: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void uniqueActual_readOnlyField() {
    uniqueArgument(this.readOnlyField); // BAD
  }

  public void uniqueActual_immutableField() {
    uniqueArgument(this.immutableField); // BAD
  }

  public void uniqueActual_valueField() {
    uniqueArgument(this.valueField); // BAD
  }
  
  public void uniqueActual_sharedField() {
    uniqueArgument(this.sharedField); // BAD
  }

  public void uniqueActual_uniqueWriteField() {
    try {
      uniqueArgument(this.uniqueWriteField); // BAD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueActual_uniqueField() {
    try {
      uniqueArgument(this.uniqueField); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
}

@Immutable
class Value {
}
