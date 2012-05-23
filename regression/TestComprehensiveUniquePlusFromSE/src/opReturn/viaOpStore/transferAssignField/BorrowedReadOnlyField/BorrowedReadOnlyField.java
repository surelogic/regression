package opReturn.viaOpStore.transferAssignField.BorrowedReadOnlyField;

import com.surelogic.Borrowed;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;

public class BorrowedReadOnlyField {
  @SuppressWarnings("unused")
  @Borrowed
  @ReadOnly
  private final Object borrowedReadOnlyField;

  
  
  @RegionEffects("reads o:Instance")
  public BorrowedReadOnlyField(@Borrowed(allowReturn=true) final Object o, int a, int b) {
    borrowedReadOnlyField = o; // CORRECT
  }

  
  
  @RegionEffects("none")
  public BorrowedReadOnlyField(@Borrowed Object o) {
    borrowedReadOnlyField = o; // "no allowReturn even though returned"
  }
  
  @RegionEffects("none")
  public BorrowedReadOnlyField(@Borrowed(allowReturn=true) final Object o, int a) {
    borrowedReadOnlyField = o; // "need read effect on allowReturn"
  }
  
  /* "need write effect" tested in BorrowedField, as that is the only
   * way to get it.
   */
}
