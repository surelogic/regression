package opCheckTopState.viaOpConsume.viaPopReceiver.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popReceiver from
 * transferCall().  This is used to check the actual receiver against the
 * annotations on the declared receiver of the called method.
 */
public class Test {
  private final @Borrowed X borrowedField = null;
  private @ReadOnly X readOnlyField = null;
  private @Immutable X immutableField = null;
  private X sharedField = null;
  private @Unique(allowRead=true) X uniqueWriteField = null;
  private @Unique X uniqueField = null;
  
  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private static X getReadOnly() { return null; }
  
  @Immutable("return")
  private static X getImmutable() { return null; }
  
  // Shared
  private static X getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static X getUniqueWrite() { return null; }
  
  @Unique("return")
  private static X getUnique() { return null; }
  
 
  
  
  // ***** formal parameters

  // Borrowed receiver
  
  public void borrowedReceiver_borrowedParam(@Borrowed X p) {
    p.borrowedReceiver(); // GOOD
  }
  
  public void borrowedReceiver_readOnlyParam(@ReadOnly X p) {
    p.borrowedReceiver(); // GOOD
  }
  
  public void borrowedReceiver_immutableParam(@Immutable X p) {
    p.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_sharedParam(X p) {
    p.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueParam(@Unique X p) {
    p.borrowedReceiver(); // GOOD
  }

  // ReadOnly receiver
  
  public void readOnlyReceiver_borrowedParam(@Borrowed X p) {
    p.readOnlyReceiver(); // BAD
  }
  
  public void readOnlyReceiver_readOnlyParam(@ReadOnly X p) {
    p.readOnlyReceiver(); // GOOD
  }
  
  public void readOnlyReceiver_immutableParam(@Immutable X p) {
    p.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_sharedParam(X p) {
    p.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_uniqueParam(@Unique X p) {
    p.readOnlyReceiver(); // GOOD
  }

  // Immutable receiver
  
  public void immutableReceiver_borrowedParam(@Borrowed X p) {
    p.immutableReceiver(); // BAD
  }
  
  public void immutableReceiver_readOnlyParam(@ReadOnly X p) {
    p.immutableReceiver(); // BAD
  }
  
  public void immutableReceiver_immutableParam(@Immutable X p) {
    p.immutableReceiver(); // GOOD
  }

  public void immutableReceiver_sharedParam(X p) {
    p.immutableReceiver(); // BAD
  }

  public void immutableReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.immutableReceiver(); // GOOD
  }

  public void immutableReceiver_uniqueParam(@Unique X p) {
    p.immutableReceiver(); // GOOD
  }

  // Shared receiver
  
  public void sharedReceiver_borrowedParam(@Borrowed X p) {
    p.sharedReceiver(); // BAD
  }
  
  public void sharedReceiver_readOnlyParam(@ReadOnly X p) {
    p.sharedReceiver(); // BAD
  }
  
  public void sharedReceiver_immutableParam(@Immutable X p) {
    p.sharedReceiver(); // BAD
  }

  public void sharedReceiver_sharedParam(X p) {
    p.sharedReceiver(); // GOOD
  }

  public void sharedReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.sharedReceiver(); // GOOD
  }

  public void sharedReceiver_uniqueParam(@Unique X p) {
    p.sharedReceiver(); // GOOD
  }

  // Unique write receiver
  
  public void uniqueWriteReceiver_borrowedParam(@Borrowed X p) {
    p.uniqueWriteReceiver(); // BAD
  }
  
  public void uniqueWriteReceiver_readOnlyParam(@ReadOnly X p) {
    p.uniqueWriteReceiver(); // BAD
  }
  
  public void uniqueWriteReceiver_immutableParam(@Immutable X p) {
    p.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_sharedParam(X p) {
    p.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.uniqueWriteReceiver(); // GOOD
  }

  public void uniqueWriteReceiver_uniqueParam(@Unique X p) {
    p.uniqueWriteReceiver(); // GOOD
  }

  // Unique receiver
  
  public void uniqueReceiver_borrowedParam(@Borrowed X p) {
    p.uniqueReceiver(); // BAD
  }
  
  public void uniqueReceiver_readOnlyParam(@ReadOnly X p) {
    p.uniqueReceiver(); // BAD
  }
  
  public void uniqueReceiver_immutableParam(@Immutable X p) {
    p.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_sharedParam(X p) {
    p.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_uniqueWriteParam(@Unique(allowRead=true) X p) {
    p.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_uniqueParam(@Unique X p) {
    p.uniqueReceiver(); // GOOD
  }
  
  // ***** method return parameters

  // Borrowed receiver
  
  // cannot return a borrowed value

  public void borrowedReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_immutableReturn() {
    X x = getImmutable();
    x.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_sharedReturn() {
    X x = getShared();
    x.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueReturn() {
    X x = getUnique();
    x.borrowedReceiver(); // GOOD
  }

  // ReadOnly receiver
  
  // cannot return a borrowed value

  public void readOnlyReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_immutableReturn() {
    X x = getImmutable();
    x.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_sharedReturn() {
    X x = getShared();
    x.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_uniqueReturn() {
    X x = getUnique();
    x.readOnlyReceiver(); // GOOD
  }

  // Immutable receiver
  
  // cannot return a borrowed value

  public void immutableReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.immutableReceiver(); // BAD
  }

  public void immutableReceiver_immutableReturn() {
    X x = getImmutable();
    x.immutableReceiver(); // GOOD
  }

  public void immutableReceiver_sharedReturn() {
    X x = getShared();
    x.immutableReceiver(); // BAD
  }

  public void immutableReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.immutableReceiver(); // GOOD
  }

  public void immutableReceiver_uniqueReturn() {
    X x = getUnique();
    x.immutableReceiver(); // GOOD
  }

  // Shared receiver
  
  // cannot return a borrowed value

  public void sharedReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.sharedReceiver(); // BAD
  }

  public void sharedReceiver_immutableReturn() {
    X x = getImmutable();
    x.sharedReceiver(); // BAD
  }

  public void sharedReceiver_sharedReturn() {
    X x = getShared();
    x.sharedReceiver(); // GOOD
  }

  public void sharedReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.sharedReceiver(); // GOOD
  }

  public void sharedReceiver_uniqueReturn() {
    X x = getUnique();
    x.sharedReceiver(); // GOOD
  }

  // UniqueWrite receiver
  
  // cannot return a borrowed value

  public void uniqueWriteReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_immutableReturn() {
    X x = getImmutable();
    x.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_sharedReturn() {
    X x = getShared();
    x.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.uniqueWriteReceiver(); // GOOD
  }

  public void uniqueWriteReceiver_uniqueReturn() {
    X x = getUnique();
    x.uniqueWriteReceiver(); // GOOD
  }

  // Unique receiver
  
  // cannot return a borrowed value

  public void uniqueReceiver_readOnlyReturn() {
    X x = getReadOnly();
    x.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_immutableReturn() {
    X x = getImmutable();
    x.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_sharedReturn() {
    X x = getShared();
    x.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_uniqueWriteReturn() {
    X x = getUniqueWrite();
    x.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_uniqueReturn() {
    X x = getUnique();
    x.uniqueReceiver(); // GOOD
  }


  // ***** Field values
  
  // Borrowed receiver

  public void borrowedReceiver_borrowedField() {
    this.borrowedField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_readOnlyField() {
    this.readOnlyField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_immutableField() {
    this.immutableField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_sharedField() {
    this.sharedField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueWriteField() {
    this.uniqueWriteField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueField() {
    this.uniqueField.borrowedReceiver(); // GOOD
  }
  
  // Read Only receiver

  public void readOnlyReceiver_borrowedField() {
    this.borrowedField.readOnlyReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
  }

  public void readOnlyReceiver_readOnlyField() {
    this.readOnlyField.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_immutableField() {
    this.immutableField.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_sharedField() {
    this.sharedField.readOnlyReceiver(); // GOOD
  }

  public void readOnlyReceiver_uniqueWriteField() {
    try {
      this.uniqueWriteField.readOnlyReceiver(); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void readOnlyReceiver_uniqueField() {
    try {
      this.uniqueField.readOnlyReceiver(); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Immutable receiver

  public void immutableReceiver_borrowedField() {
    this.borrowedField.immutableReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
  }

  public void immutableReceiver_readOnlyField() {
    this.readOnlyField.immutableReceiver(); // BAD
  }

  public void immutableReceiver_immutableField() {
    this.immutableField.immutableReceiver(); // GOOD
  }

  public void immutableReceiver_sharedField() {
    this.sharedField.immutableReceiver(); // BAD
  }

  public void immutableReceiver_uniqueWriteField() {
    try {
      this.uniqueWriteField.immutableReceiver(); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void immutableReceiver_uniqueField() {
    try {
      this.uniqueField.immutableReceiver(); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Shared receiver

  public void sharedReceiver_borrowedField() {
    this.borrowedField.sharedReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
  }

  public void sharedReceiver_readOnlyField() {
    this.readOnlyField.sharedReceiver(); // BAD
  }

  public void sharedReceiver_immutableField() {
    this.immutableField.sharedReceiver(); // BAD
  }

  public void sharedReceiver_sharedField() {
    this.sharedField.sharedReceiver(); // GOOD
  }

  public void sharedReceiver_uniqueWriteField() {
    try {
      this.uniqueWriteField.sharedReceiver(); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void sharedReceiver_uniqueField() {
    try {
      this.uniqueField.sharedReceiver(); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Unique write receiver

  public void uniqueWriteReceiver_borrowedField() {
    this.borrowedField.uniqueWriteReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
  }

  public void uniqueWriteReceiver_readOnlyField() {
    this.readOnlyField.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_immutableField() {
    this.immutableField.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_sharedField() {
    this.sharedField.uniqueWriteReceiver(); // BAD
  }

  public void uniqueWriteReceiver_uniqueWriteField() {
    try {
      this.uniqueWriteField.uniqueWriteReceiver(); // GOOD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueWriteReceiver_uniqueField() {
    try {
      this.uniqueField.uniqueWriteReceiver(); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
  
  // Unique receiver

  public void uniqueReceiver_borrowedField() {
    this.borrowedField.uniqueReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
  }

  public void uniqueReceiver_readOnlyField() {
    this.readOnlyField.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_immutableField() {
    this.immutableField.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_sharedField() {
    this.sharedField.uniqueReceiver(); // BAD
  }

  public void uniqueReceiver_uniqueWriteField() {
    try {
      this.uniqueWriteField.uniqueReceiver(); // BAD
    } finally {
      this.uniqueWriteField = null;
    }
  }

  public void uniqueReceiver_uniqueField() {
    try {
      this.uniqueField.uniqueReceiver(); // GOOD
    } finally {
      this.uniqueField = null;
    }
  }
}


class X {
  @Borrowed("this")
  @RegionEffects("reads Instance")
  public void borrowedReceiver() {}
  
  @ReadOnly("this")
  @RegionEffects("reads Instance")
  public void readOnlyReceiver() {}
  
  @Immutable("this")
  @RegionEffects("reads Instance")
  public void immutableReceiver() {}
  
  @RegionEffects("reads Instance")
  public void sharedReceiver() {}
  
  @Unique(value="this", allowRead=true)
  @RegionEffects("reads Instance")
  public void uniqueWriteReceiver() {}
  
  @Unique("this")
  @RegionEffects("reads Instance")
  public void uniqueReceiver() {}
}

