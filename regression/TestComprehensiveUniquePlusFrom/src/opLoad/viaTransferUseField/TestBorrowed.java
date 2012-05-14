package opLoad.viaTransferUseField;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

@SuppressWarnings("unused")
public class TestBorrowed {
  @Borrowed
  public final Object b;

  public Object s;
  
  @RegionEffects("writes o:Instance")
  public TestBorrowed(final @Borrowed(allowReturn=true) Object o) {
    this.b = o;
  }
  
  public void compromiseBorrowed1() {
    this.s = this.b; // compromise u
    Object o = this.b;
  }
  
  @RegionEffects("none")
  public void compromiseRef(final Object o) {
    // do stuff
  }
  
  public void compromiseBorrowed2() {
    compromiseRef(this.b);
    Object o = this.b;
  }
}
