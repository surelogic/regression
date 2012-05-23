package opReturn.viaTransferCall;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

/* opReturn is called by transferCall() when assigning the implicit parameter
 * qualified receiver (IPQR) to the implicit field qualified receiver (IFQR)
 * when the IFQR is borrowed.  The IFQR cannot be @ReadOnly, so we cannot have 
 * the read effect error message,
 */
public class Test {
  @Borrowed("Test.this")
  public class Inner {
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance")
    public Inner() {
      super(); // correct
    }

    @Borrowed(value="Test.this")
    public Inner(int a) {
      super(); // "no allowReturn even though returned"
    }
    
    @Borrowed(value="Test.this", allowReturn=true)
    public Inner(int a, int b) {
      super(); // "need write effect on allowReturn"
    }
  }
}

