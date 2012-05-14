package opCheckMutable.viaConsiderDeclaredEffects.transferCall.formal.instanceTarget.read;

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
 * Test the cases where 'p' is sourced from a receiver, 
 * formal parameter, return value, and field reference.
 * 
 * Here we test the case where the called method READS an instance target
 * that might affect the object passed as the receiver.
 */
public class ReadTest {
  private final @Borrowed C borrowedField;
  private final @Immutable C immutableField;
  private final @ReadOnly C readOnlyField;
  private final /*SHARED*/ C sharedField;
  private final @Unique(allowRead=true) C uniqueWriteField;
  private final @Unique C uniqueField;
  
  
  
  public ReadTest() {
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
    C.sharedC.doStuff(p);
  }

  public void param_readOnly(final @ReadOnly C p) {
    C.sharedC.doStuff(p);
  }

  public void param_immutable(final @Immutable C p) {
    C.sharedC.doStuff(p);
  }

  public void param_shared(final /*SHARED*/ C p) {
    C.sharedC.doStuff(p);
  }

  public void param_uniqueWrite(final @Unique(allowRead=true) C p) {
    C.sharedC.doStuff(p);
  }

  public void param_unique(final @Unique C p) {
    C.sharedC.doStuff(p);
  }



  /*
   * === Test Return Values
   */

  // no such thing as borrowed return value
  
  @ReadOnly("return")
  private C getReadOnly() {
    return null;
  }
  
  @Immutable("return")
  private C getImmutable() {
    return null;
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
    C.sharedC.doStuff(c);
  }
  
  public void returnValue_immutable() {
    C c = getImmutable();
    C.sharedC.doStuff(c);
  }
  
  public void returnValue_shared() {
    C c = getShared();
    C.sharedC.doStuff(c);
  }
  
  public void returnValue_uniqueWrite() {
    C c = getUniqueWrite();
    C.sharedC.doStuff(c);
  }
  
  public void returnValue_unique() {
    C c = getUnique();
    C.sharedC.doStuff(c);
  }



  /*
   * === Test Fields
   */

  public void fieldRef_borrowed() {
    C.sharedC.doStuff(this.borrowedField);
  }

  public void fieldRef_readOnly() {
    C.sharedC.doStuff(this.readOnlyField);
  }

  public void fieldRef_immutable() {
    C.sharedC.doStuff(this.immutableField);
  }

  public void fieldRef_shared() {
    C.sharedC.doStuff(this.sharedField);
  }

  public void fieldRef_uniqueWrite() {
    C.sharedC.doStuff(this.uniqueWriteField);
  }

  public void fieldRef_unique() {
    C.sharedC.doStuff(this.uniqueField);
  }
}



class C {
  public static final C sharedC = new C();
  
  @RegionEffects("reads o:Instance")
  @Borrowed("this")
  public void doStuff(final @Borrowed C o) {
    // stuff
  }
  
  
  
  /*
   * === Test Receivers
   */
  
  @Borrowed("this")
  public void receiver_borrowed() {
    sharedC.doStuff(this);
  }
  
  @ReadOnly("this")
  public void receiver_readOnly() {
    sharedC.doStuff(this);
  }
  
  @Immutable("this")
  public void receiver_immutable() {
    sharedC.doStuff(this);
  }
  
  /*SHARED*/
  public void receiver_shared() {
    sharedC.doStuff(this);
  }
  
  @Unique(value="this", allowRead=true)
  public void receiver_uniqueWrite() {
    sharedC.doStuff(this);
  }
  
  @Unique("this")
  public void receiver_unique() {
    sharedC.doStuff(this);
  }
}
