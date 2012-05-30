package badBorrowedFieldInit;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

/* Test that we cannot assign a borrowed parameter to multiple Borrowed fields.
 */
@SuppressWarnings("unused")
public class DualIterator {
  private final @Borrowed Object collection1;
  private final @Borrowed Object collection2;

  @RegionEffects("writes o:Instance")
  public DualIterator(
      final @Borrowed(allowReturn=true) Object o) {
    collection1 = o;
    collection2 = o; // BAD, the receiver is undefined at this point.
  }
}
