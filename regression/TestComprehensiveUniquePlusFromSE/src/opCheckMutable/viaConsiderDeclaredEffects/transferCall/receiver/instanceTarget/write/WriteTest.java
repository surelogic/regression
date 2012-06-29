package opCheckMutable.viaConsiderDeclaredEffects.transferCall.receiver.instanceTarget.write;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Test opCheckMutable() when it is called by considerDeclaredEffects() from
 * transferCall().  What this does is make sure that when we have a method call
 * "o.m(p)" that the effects of the method do not indicate that state of a 
 * @ReadOnly or @Immutable object reference passed to the method is written to.
 * 
 * Test the cases where 'o' is sourced from a receiver, 
 * formal parameter, return value, and field reference.
 * 
 * Here we test the case where the called method WRITES an instance target
 * that might affect the object passed as the receiver.
 */
public class WriteTest {
  private final @Borrowed C borrowedField;
  private final @Immutable C immutableField;
  private final @ReadOnly C readOnlyField;
  private final /*SHARED*/ C sharedField;
  private final @Unique(allowRead=true) C uniqueWriteField;
  private final @Unique C uniqueField;
  
  
  
  public WriteTest() {
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
  
  public void param_borrowed(final @Borrowed C p) {
    p.doStuff();
  }

  public void param_readOnly(final @ReadOnly C p) {
    p.doStuff(); // BAD
  }

  public void param_immutable(final @Immutable C p) {
    p.doStuff(); // BAD
  }

  public void param_shared(final /*SHARED*/ C p) {
    p.doStuff();
  }

  public void param_uniqueWrite(final @Unique(allowRead=true) C p) {
    p.doStuff();
  }

  public void param_unique(final @Unique C p) {
    p.doStuff();
  }



  /*
   * === Test Return Values
   */

  // no such thing as borrowed return value
  
  @ReadOnly("return")
  private C getReadOnly() {
    return null; // BAD
  }
  
  @Immutable("return")
  private C getImmutable() {
    return null; // BAD
  }
  
  /*SHARED return*/
  private C getShared() {
    return null;
  }
  
  @Unique(value="return", allowRead=true) 
  private C getUniqueWrite() {
    return null;
  }
  
  @Unique("return")
  private C getUnique() {
    return null;
  }
  
  // no such thing as a borrowed return value
  
  public void returnValue_readOnly() {
    C c = getReadOnly();
    c.doStuff(); // BAD
  }
  
  public void returnValue_immutable() {
    C c = getImmutable();
    c.doStuff(); // BAD
  }
  
  public void returnValue_shared() {
    C c = getShared();
    c.doStuff();
  }
  
  public void returnValue_uniqueWrite() {
    C c = getUniqueWrite();
    c.doStuff();
  }
  
  public void returnValue_unique() {
    C c = getUnique();
    c.doStuff();
  }



  /*
   * === Test Fields
   */

  public void fieldRef_borrowed() {
    this.borrowedField.doStuff();
  }

  public void fieldRef_readOnly() {
    this.readOnlyField.doStuff(); // BAD
  }

  public void fieldRef_immutable() {
    this.immutableField.doStuff(); // BAD
  }

  public void fieldRef_shared() {
    this.sharedField.doStuff();
  }

  public void fieldRef_uniqueWrite() {
    this.uniqueWriteField.doStuff();
  }

  public void fieldRef_unique() {
    this.uniqueField.doStuff();
  }
}



class C {
  @RegionEffects("writes this:Instance")
  @Borrowed("this")
  public void doStuff() {
    // stuff
  }
  
  
  
  /*
   * === Test Receivers
   */
  
  @Borrowed("this")
  public void receiver_borrowed() {
    this.doStuff();
  }
  
  @ReadOnly("this")
  public void receiver_readOnly() {
    this.doStuff(); // BAD
  }
  
  @Immutable("this")
  public void receiver_immutable() {
    this.doStuff(); // BAD
  }
  
  /*SHARED*/
  public void receiver_shared() {
    this.doStuff();
  }
  
  @Unique(value="this", allowRead=true)
  public void receiver_uniqueWrite() {
    this.doStuff();
  }
  
  @Unique("this")
  public void receiver_unique() {
    this.doStuff();
  }
}