package opCheckTopState.viaOpConsume.viaOpCompromise.viaTransferCall;

import com.surelogic.Borrowed;

/* Check opCheckTopState when called by opConsume via opCompromise via 
 * transferCall.  Being called by opCompromise, means the reference is 
 * going to be force to be SHARED.  This use from transferCall is to share
 * the IPQR when the IFQR is not @Borrowed.
 */
public class Test {
  class Inner {
    @Borrowed("Test.this")
    public Inner() {
      super(); // BAD
    }
    
    public Inner(int x) {
      super(); // GOOD
    }
  }
}
