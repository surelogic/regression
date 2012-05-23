package opCheckTopState.viaOpConsume.viaPopQualifiedReceiver.viaTransferCall.undefined;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popQualifiedReceiver from
 * transferCall(). In this case, we use the effects of the called method to
 * make the field passed as the argument UNDEFINED.  
 */
@SuppressWarnings("unused")
public class Test {
  @Borrowed("Test.this")
  class X {
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance, any(Test):Instance")
    @Unique("return")
    public X() {}
    
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance")
    @Unique("return")
    public X(final int v) {}
  }
  
  class Y {
    @RegionEffects("writes any(Test):Instance")
    public Y() {}

    @RegionEffects("none")
    public Y(final int v) {}
  }


  
  private final @Borrowed Test borrowedField = null;
  private @Unique(allowRead=true) Test uniqueWriteField = null;
  private @Unique Test uniqueField = null;
  
  
  
  @RegionEffects("reads Instance")
  public int doStuff() { return 0; }
  
  
  
  // ***** field reads

  // Borrowed qualified receiver
  
  public void borrowedQualifiedRcvr_borrowedField() {
    Object o = borrowedField. new X(); // BAD: Field becomes undefined due to the method effects
  }

  public void borrowedQualifiedRcvr_uniqueWriteField() {
    Object o = uniqueWriteField. new X(); // BAD: Field becomes undefined due to the method effects
  }

  public void borrowedQualifiedRcvr_uniqueField() {
    Object o = uniqueField. new X(); // BAD: Field becomes undefined due to the method effects
  }
  
  public void borrowedQualifiedRcvr_borrowedField_invalidatedBySecondaryMethodCall() {
    Object o = borrowedField. new X(this.doStuff());
  }
  
  public void borrowedQualifiedRcvr_uniqueField_invalidatedBySecondaryMethodCall() {
    Object o = uniqueWriteField. new X(this.doStuff());
  }
  
  public void borrowedQualifiedRcvr_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    Object o = uniqueField. new X(this.doStuff());
  }


  // Shared qualified receiver
  
  public void sharedQualifiedRcvr_borrowedField() {
    Object o = borrowedField. new Y(); // BAD: Field becomes undefined due to the method effects: reads as unique
    // but field is compromised
  }

  public void sharedQualifiedRcvr_uniqueWriteField() {
    try {
      Object o = uniqueWriteField. new Y(); // BAD: Field becomes undefined due to the method effects
    } finally {
      uniqueWriteField = null;
    }
  }

  public void sharedQualifiedRcvr_uniqueField() {
    try {
      Object o = uniqueField. new Y(); // BAD: Field becomes undefined due to the method effects
    } finally {
      uniqueField = null;
    }
  }
  
  public void sharedQualifiedRcvr_borrowedField_invalidatedBySecondaryMethodCall() {
    Object o = borrowedField. new Y(this.doStuff());
  }
  
  public void sharedQualifiedRcvr_uniqueField_invalidatedBySecondaryMethodCall() {
    Object o = uniqueWriteField. new Y(this.doStuff());
  }
  
  public void sharedQualifiedRcvr_uniqueWriteField_invalidatedBySecondaryMethodCall() {
    Object o = uniqueField. new Y(this.doStuff());
  }
}
