package opGet.viaTransferMethodBody;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

@SuppressWarnings("unused")
public class TestBorrowed {
  @Borrowed
  private final Object b;
   
  @RegionEffects("writes o:Instance")
  public TestBorrowed(final @Borrowed(allowReturn=true) Object o) {
    b = o;
  }
  
  public Object testOpGet() {
    try {
      return this.b;
    } finally {
      Object t2 = this.b;
    }
  }
}
