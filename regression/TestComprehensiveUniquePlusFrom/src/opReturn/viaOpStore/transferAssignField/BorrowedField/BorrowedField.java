package opReturn.viaOpStore.transferAssignField.BorrowedField;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

public class BorrowedField {
  @SuppressWarnings("unused")
  @Borrowed
  private final Object borrowedField;

  
  
  @RegionEffects("writes o:Instance")
  public BorrowedField(@Borrowed(allowReturn=true) final Object o, int a, int b) {
    borrowedField = o; // CORRECT
  }

  
  
  @RegionEffects("none")
  public BorrowedField(@Borrowed Object o) {
    borrowedField = o; // "no allowReturn even though returned"
  }
  
  @RegionEffects("none")
  public BorrowedField(@Borrowed(allowReturn=true) final Object o, int a) {
    borrowedField = o; // "need write effect on allowReturn"
  }
  
  /* "need read effect" tested in BorrowedReadOnlyField, as that is the only
   * way to get it.
   */
}
