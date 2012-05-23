package opCheckTopState.viaOpConsume.viaPopQualifiedReceiver.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Check opCheckTopState when called by opConsume via popQualifiedReceiver from
 * transferCall().  This is used to check the actual qualified receiver against the
 * annotations on the declared qualified receiver of the called method.
 */
@SuppressWarnings("unused")
public class Test {
  @Borrowed("Test.this")
  class X {
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance")
    @Unique("return")
    public X() {}
  }
  
  class Y {
    @RegionEffects("none")
    public Y() {}
  }


  
  private final @Borrowed Test borrowedField = null;
  private @ReadOnly Test readOnlyField = null;
  private @Immutable Test immutableField = null;
  private Test sharedField = null;
  private @Unique(allowRead=true) Test uniqueWriteField = null;
  private @Unique Test uniqueField = null;
  
  
  
  // no way to return a borrowed value
  
  @ReadOnly("return")
  private static Test getReadOnly() { return null; }
  
  @Immutable("return")
  private static Test getImmutable() { return null; }
  
  // Shared
  private static Test getShared() { return null; }
  
  @Unique(value="return", allowRead=true) 
  private static Test getUniqueWrite() { return null; }
  
  @Unique("return")
  private static Test getUnique() { return null; }
  
  
  
  // ***** formal parameters

  // Borrowed qualified receiver
  
  public void borrowedQualifiedRcvr_borrowedParam(final @Borrowed(allowReturn=true) Test p) {
    Object o = p. new X(); // GOOD
  }
  
  public void borrowedQualifiedRcvr_readOnlyParam(@ReadOnly Test p) {
    Object o = p. new X(); // GOOD
  }
  
  public void borrowedQualifiedRcvr_immutableParam(@Immutable Test p) {
    Object o = p. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_sharedParam(Test p) {
    Object o = p. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueWriteParam(@Unique(allowRead=true) Test p) {
    Object o = p. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueParam(@Unique Test p) {
    Object o = p. new X(); // GOOD
  }


  // Shared qualified receiver
  
  public void sharedQualifiedRcvr_borrowedParam(final @Borrowed(allowReturn=true) Test p) {
    Object o = p. new Y(); // BAD
  }
  
  public void sharedQualifiedRcvr_readOnlyParam(@ReadOnly Test p) {
    Object o = p. new Y(); // BAD
  }
  
  public void sharedQualifiedRcvr_immutableParam(@Immutable Test p) {
    Object o = p. new Y(); // BAD
  }

  public void sharedQualifiedRcvr_sharedParam(Test p) {
    Object o = p. new Y(); // GOOD
  }

  public void sharedQualifiedRcvr_uniqueWriteParam(@Unique(allowRead=true) Test p) {
    Object o = p. new Y(); // GOOD
  }

  public void sharedQualifiedRcvr_uniqueParam(@Unique Test p) {
    Object o = p. new Y(); // GOOD
  }
  
  
  
  // ***** method return values

  // Borrowed qualified receiver
  
  // Cannot return a borrowed value
  
  public void borrowedQualifiedRcvr_readOnlyReturn() {
    Object o = getReadOnly(). new X(); // GOOD
  }
  
  public void borrowedQualifiedRcvr_immutableReturn() {
    Object o = getImmutable(). new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_sharedReturn() {
    Object o = getShared(). new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueWriteReturn() {
    Object o = getUniqueWrite(). new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueReturn() {
    Object o = getUnique(). new X(); // GOOD
  }


  // Shared qualified receiver
  
  // Cannot return a borrowed value
  
  public void sharedQualifiedRcvr_readOnlyReturn() {
    Object o = getReadOnly(). new Y(); // BAD
  }
  
  public void sharedQualifiedRcvr_immutableReturn() {
    Object o = getImmutable(). new Y(); // BAD
  }

  public void sharedQualifiedRcvr_sharedReturn() {
    Object o = getShared(). new Y(); // GOOD
  }

  public void sharedQualifiedRcvr_uniqueWriteReturn() {
    Object o = getUniqueWrite(). new Y(); // GOOD
  }

  public void sharedQualifiedRcvr_uniqueReturn() {
    Object o = getUnique(). new Y(); // GOOD
  }



  // ***** field reads

  // Borrowed qualified receiver
  
  public void borrowedQualifiedRcvr_borrowedField() {
    Object o = borrowedField. new X(); // GOOD
  }
  
  public void borrowedQualifiedRcvr_readOnlyField() {
    Object o = readOnlyField. new X(); // GOOD
  }
  
  public void borrowedQualifiedRcvr_immutableField() {
    Object o = immutableField. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_sharedField() {
    Object o = sharedField. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueWriteField() {
    Object o = uniqueWriteField. new X(); // GOOD
  }

  public void borrowedQualifiedRcvr_uniqueField() {
    Object o = uniqueField. new X(); // GOOD
  }


  // Shared qualified receiver
  
  public void sharedQualifiedRcvr_borrowedField() {
    Object o = borrowedField. new Y(); // GOOD: reads as unique
    // but field is compromised
  }
  
  public void sharedQualifiedRcvr_readOnlyField() {
    Object o = readOnlyField. new Y(); // BAD
  }
  
  public void sharedQualifiedRcvr_immutableField() {
    Object o = immutableField. new Y(); // BAD
  }

  public void sharedQualifiedRcvr_sharedField() {
    Object o = sharedField. new Y(); // GOOD
  }

  public void sharedQualifiedRcvr_uniqueWriteField() {
    try {
      Object o = uniqueWriteField. new Y(); // GOOD
    } finally {
      uniqueWriteField = null;
    }
  }

  public void sharedQualifiedRcvr_uniqueField() {
    try {
      Object o = uniqueField. new Y(); // GOOD
    } finally {
      uniqueField = null;
    }
  }
}
