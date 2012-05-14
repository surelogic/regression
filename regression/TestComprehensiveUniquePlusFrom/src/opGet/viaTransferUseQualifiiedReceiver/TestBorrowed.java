package opGet.viaTransferUseQualifiiedReceiver;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestBorrowed {
  /* 
   * I don't think it's possible to make 'C.this' undefined via borrowed fields.
   * The equivalent for TestUnique is below, but this generates different
   * errors before we ever try to use 'this' because we cannot read the
   * borrowed fields of other objects.
   * 
   */
//  @Borrowed
//  private final Object b;
//  
//  private Object other;
//
//  @RegionEffects("writes o:Instance")
//  public TestBorrowed(final @Borrowed(allowReturn=true) Object o) {
//    this.b = o;
//  }
//  
//  @Unique("this")
//  public void testOpGet() {
//    TestBorrowed x = new TestBorrowed(this);
//    Object t = x.b; // makes receiver undefined
//    x.other = this;
//  }
}
