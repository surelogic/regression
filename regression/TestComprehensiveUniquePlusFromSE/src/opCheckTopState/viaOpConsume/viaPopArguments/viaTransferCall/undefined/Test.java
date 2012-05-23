package opCheckTopState.viaOpConsume.viaPopArguments.viaTransferCall.undefined;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popArguments from
 * transferCall().  In this case, we use the effects of the called method to
 * make the field passed as the argument UNDEFINED.  
 */
public class Test {
  private final @Borrowed Object borrowedField = null;
  private @Unique(allowRead=true) Object uniqueWriteField = null;
  private @Unique Object uniqueField = null;

  
  
  // Methods to be called
  
  @RegionEffects("reads this:Instance")
  public void borrowedArgument(@Borrowed Object p) {}
  
  @RegionEffects("reads this:Instance")
  public void readOnlyArgument(@ReadOnly Object p) {}
  
  @RegionEffects("reads this:Instance")
  public void immutableArgument(@Immutable Object p) {}
  
  @RegionEffects("reads this:Instance")
  public void sharedArgument(Object p) {}
  
  @RegionEffects("reads this:Instance")
  public void uniqueWriteArgument(@Unique(allowRead=true) Object p) {}
  
  @RegionEffects("reads this:Instance")
  public void uniqueArgument(@Unique Object p) {}

  
  
  @RegionEffects("none")
  public void doTwoThings_borrowed(@Borrowed Object a, final Object b) {}
  
  @RegionEffects("none")
  public void doTwoThings_readOnly(@ReadOnly Object a, final Object b) {}
  
  @RegionEffects("none")
  public void doTwoThings_immutable(@Immutable Object a, final Object b) {}
  
  @RegionEffects("none")
  public void doTwoThings_shared(Object a, final Object b) {}
  
  @RegionEffects("none")
  public void doTwoThings_uniqueWrite(@Unique(allowRead=true) Object a, final Object b) {}
  
  @RegionEffects("none")
  public void doTwoThings_unique(@Unique Object a, final Object b) {}
  
  
  
  // Borrowed actual

  public void borrowedActual_borrowedField() {
    borrowedArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED
  }

  public void borrowedActual_uniqueWriteField() {
    borrowedArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
  }

  public void borrowedActual_uniqueField() {
    borrowedArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
  }
  
  public void borrowedActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_borrowed(x.b, x.doStuff());
  }
  
  public void borrowedActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_borrowed(x.uw, x.doStuff());
  }
  
  public void borrowedActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_borrowed(x.u, x.doStuff());
  }
  
  
  // Read Only actual

  public void readOnlyActual_borrowedField() {
    readOnlyArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void readOnlyActual_uniqueWriteField() {
    try {
      readOnlyArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void readOnlyActual_uniqueField() {
    try {
      readOnlyArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueField = null;
    }
  }
  
  public void readOnlyActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_readOnly(x.b, x.doStuff());
  }
  
  public void readOnlyActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_readOnly(x.uw, x.doStuff());
  }
  
  public void readOnlyActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_readOnly(x.u, x.doStuff());
  }

   
  // Immutable actual

  public void immutableActual_borrowedField() {
    immutableArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void immutableActual_uniqueWriteField() {
    try {
      immutableArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void immutableActual_uniqueField() {
    try {
      immutableArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueField = null;
    }
  }
  
  public void immutableActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_immutable(x.b, x.doStuff());
  }
  
  public void immutableActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_immutable(x.uw, x.doStuff());
  }
  
  public void immutableActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_immutable(x.u, x.doStuff());
  }

  
  // Shared actual

  public void sharedActual_borrowedField() {
    sharedArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void sharedActual_uniqueWriteField() {
    try {
      sharedArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void sharedActual_uniqueField() {
    try {
      sharedArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueField = null;
    }
  }
  
  public void sharedActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_shared(x.b, x.doStuff());
  }
  
  public void sharedActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_shared(x.uw, x.doStuff());
  }
  
  public void sharedActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_shared(x.u, x.doStuff());
  }

  
  // Unique write actual

  public void uniqueWriteActual_borrowedField() {
    uniqueWriteArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void uniqueWriteActual_uniqueWriteField() {
    try {
      uniqueWriteArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueWriteActual_uniqueField() {
    try {
      uniqueWriteArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueField = null;
    }
  }
  
  public void uniqueWriteActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_uniqueWrite(x.b, x.doStuff());
  }
  
  public void uniqueWriteActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_uniqueWrite(x.uw, x.doStuff());
  }
  
  public void uniqueWriteActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_uniqueWrite(x.u, x.doStuff());
  }

  
  // Unique actual

  public void uniqueActual_borrowedField() {
    uniqueArgument(this.borrowedField); // BAD: Method effects make the field value UNDEFINED: Borrowed reads as unique
    // BUT: field is compromised
  }

  public void uniqueActual_uniqueWriteField() {
    try {
      uniqueArgument(this.uniqueWriteField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueActual_uniqueField() {
    try {
      uniqueArgument(this.uniqueField); // BAD: Method effects make the field value UNDEFINED
    } finally {
      this.uniqueField = null;
    }
  }
  
  public void uniqueActual_borrowedField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_unique(x.b, x.doStuff());
  }
  
  public void uniqueActual_uniqueWriteField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_unique(x.uw, x.doStuff());
  }
  
  public void uniqueActual_uniqueField_invalidatedBySecondaryMethodCall(final X x) {
    doTwoThings_unique(x.u, x.doStuff());
  }
}


class X {
  public final @Borrowed Object b = null; 
  public @Unique(allowRead=true) Object uw;
  public @Unique Object u;
  
  @Borrowed("this")
  @RegionEffects("reads Instance")
  public Object doStuff() { return null; }
}

