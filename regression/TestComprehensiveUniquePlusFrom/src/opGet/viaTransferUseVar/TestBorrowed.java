package opGet.viaTransferUseVar;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

@SuppressWarnings("unused")
public class TestBorrowed {
  @Borrowed
  private final Object b;
  
  private Object other;
  
  @RegionEffects("writes o:Instance")
  public TestBorrowed(final @Borrowed(allowReturn=true) Object o) {
    b = o;
  }
  
  public void testOpGet() {
    Object t1 = this.b;
    Object t2 = this.b; // kills t1
    this.other = 
        t1; // undefined variable
  }
}
