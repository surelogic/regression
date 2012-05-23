package opCheckTopState.viaOpConsume.viaPopReceiver.viaTransferCall.undefined;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popReceiver from
 * transferCall().  In this case, we use the effects of the called method to
 * make the field passed as the argument UNDEFINED.  
 */
public class Test {
  private final @Borrowed X borrowedField = null;
  private @Unique(allowRead=true) X uniqueWriteField = null;
  private @Unique X uniqueField = null;


  @RegionEffects("none")
  public static void doTwoThings(final Object a, final Object b) {}
  
  @RegionEffects("reads Instance")
  public Object readState() { return null; }
  
  

  // ***** Field values
  
  // Borrowed receiver

  public void borrowedReceiver_borrowedField() {
    this.borrowedField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueWriteField() {
    this.uniqueWriteField.borrowedReceiver(); // GOOD
  }

  public void borrowedReceiver_uniqueField() {
    this.uniqueField.borrowedReceiver(); // GOOD
  }
  
  public void borrowedReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.borrowedReceiver(), this.readState());
  }
  
  public void borrowedReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.borrowedReceiver(), this.readState());
  }
  
  public void borrowedReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.borrowedReceiver(), this.readState());
  }
  
  // Read Only receiver

  public void readOnlyReceiver_borrowedField() {
    this.borrowedField.readOnlyReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
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
  
  public void readOnlyReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.readOnlyReceiver(), this.readState());
  }
  
  public void readOnlyReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.readOnlyReceiver(), this.readState());
  }
  
  public void readOnlyReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.readOnlyReceiver(), this.readState());
  }
    
  // Immutable receiver

  public void immutableReceiver_borrowedField() {
    this.borrowedField.immutableReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
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
  
  public void immutableReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.immutableReceiver(), this.readState());
  }
  
  public void immutableReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.immutableReceiver(), this.readState());
  }
  
  public void immutableReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.immutableReceiver(), this.readState());
  }
     
  // Shared receiver

  public void sharedReceiver_borrowedField() {
    this.borrowedField.sharedReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
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
  
  public void sharedReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.sharedReceiver(), this.readState());
  }
  
  public void sharedReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.sharedReceiver(), this.readState());
  }
  
  public void sharedReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.sharedReceiver(), this.readState());
  }
     
  // Unique write receiver

  public void uniqueWriteReceiver_borrowedField() {
    this.borrowedField.uniqueWriteReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
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
  
  public void uniqueWriteReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.uniqueWriteReceiver(), this.readState());
  }
  
  public void uniqueWriteReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.uniqueWriteReceiver(), this.readState());
  }
  
  public void uniqueWriteReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.uniqueWriteReceiver(), this.readState());
  }
     
  // Unique receiver

  public void uniqueReceiver_borrowedField() {
    this.borrowedField.uniqueReceiver(); // GOOD: Borrowed reads as unique
    // But, field is compromised
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
  
  public void uniqueReceiver_borrowedField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.borrowedField.uniqueReceiver(), this.readState());
  }
  
  public void uniqueReceiver_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueWriteField.uniqueReceiver(), this.readState());
  }
  
  public void uniqueReceiver_uniqueField_invalidatedBySecondaryMethodCall() {
    doTwoThings(this.uniqueField.uniqueReceiver(), this.readState());
  }
}


class X {
  @Borrowed("this")
  @RegionEffects("reads any(X):Instance")
  public Object borrowedReceiver() { return null; }
  
  @ReadOnly("this")
  @RegionEffects("reads any(X):Instance")
  public Object readOnlyReceiver() { return null; }
  
  @Immutable("this")
  @RegionEffects("reads any(X):Instance")
  public Object immutableReceiver() { return null; }
  
  @RegionEffects("reads any(X):Instance")
  public Object sharedReceiver() { return null; }
  
  @Unique(value="this", allowRead=true)
  @RegionEffects("reads any(X):Instance")
  public Object uniqueWriteReceiver() { return null; }
  
  @Unique("this")
  @RegionEffects("reads any(X):Instance")
  public Object uniqueReceiver() { return null; }
}

