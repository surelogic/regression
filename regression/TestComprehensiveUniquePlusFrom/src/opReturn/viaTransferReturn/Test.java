
package opReturn.viaTransferReturn;

import com.surelogic.Borrowed;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;

/*
 * OpReturn only checks the state of a borrowed value.  It doesn't do anything
 * about the fact that a borrowed value cannot actually be returned as the
 * return value of a method.
 */
public class Test {
  public Object m1(final @Borrowed Object o) {
    return o; // "no allowReturn even though returned"
  }

  public Object m2(final @Borrowed(allowReturn=true) Object o) {
    return o; // "need write effect on allowReturn"
  }

  @ReadOnly("return")
  public Object m3(final @Borrowed(allowReturn=true) Object o) {
    return o; // "need read effect on allowReturn"
  }



  @RegionEffects("reads o:Instance")
  @ReadOnly("return")
  public Object m4(final @Borrowed(allowReturn=true) Object o) {
    // No error here as far as opReturn is concerned
    return o; // error from opCheckTopState -- can never return a borrowed value
  }
}
