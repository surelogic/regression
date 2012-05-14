package opCheckMutable.viaOpStore.transferAssignField;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.Unique;

/* Test opCheckMutable() when it is called by opStore() from
 * transferAssignField().  What this does is make sure that when we have an
 * assignment "o.f = v" that 'o' does not refer to a @ReadOnly or @Immutable
 * reference.  
 * 
 * Need to test the cases where 'o' is a source from a receiver, 
 * formal parameter, return value, and field reference.
 */
public class Test {
  private final @Borrowed C borrowedField;
  private final @Immutable C immutableField;
  private final @ReadOnly C readOnlyField;
  private final /*SHARED*/ C sharedField;
  private final @Unique(allowRead=true) C uniqueWriteField;
  private final @Unique C uniqueField;
  
  
  
  public Test() {
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
    p.f = 1;
  }

  public void param_readOnly(final @ReadOnly C p) {
    p.f = 1;
  }

  public void param_immutable(final @Immutable C p) {
    p.f = 1;
  }

  public void param_shared(final /*SHARED*/ C p) {
    p.f = 1;
  }

  public void param_uniqueWrite(final @Unique(allowRead=true) C p) {
    p.f = 1;
  }

  public void param_unique(final @Unique C p) {
    p.f = 1;
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
    c.f = 1;
  }
  
  public void returnValue_immutable() {
    C c = getImmutable();
    c.f = 1;
  }
  
  public void returnValue_shared() {
    C c = getShared();
    c.f = 1;
  }
  
  public void returnValue_uniqueWrite() {
    C c = getUniqueWrite();
    c.f = 1;
  }
  
  public void returnValue_unique() {
    C c = getUnique();
    c.f = 1;
  }



  /*
   * === Test Fields
   */

  public void fieldRef_borrowed() {
    this.borrowedField.f = 1;
  }

  public void fieldRef_readOnly() {
    this.readOnlyField.f = 1;
  }

  public void fieldRef_immutable() {
    this.immutableField.f = 1;
  }

  public void fieldRef_shared() {
    this.sharedField.f = 1;
  }

  public void fieldRef_uniqueWrite() {
    this.uniqueWriteField.f = 1;
  }

  public void fieldRef_unique() {
    this.uniqueField.f = 1;
  }
}



class C {
  public int f;
  
  
  
  /*
   * === Test Receivers
   */
  
  @Borrowed("this")
  public void receiver_borrowed() {
    this.f = 1;
  }
  
  @ReadOnly("this")
  public void receiver_readOnly() {
    this.f = 1;
  }
  
  @Immutable("this")
  public void receiver_immutable() {
    this.f = 1;
  }
  
  /*SHARED*/
  public void receiver_shared() {
    this.f = 1;
  }
  
  @Unique(value="this", allowRead=true)
  public void receiver_uniqueWrite() {
    this.f = 1;
  }
  
  @Unique("this")
  public void receiver_unique() {
    this.f = 1;
  }
}
