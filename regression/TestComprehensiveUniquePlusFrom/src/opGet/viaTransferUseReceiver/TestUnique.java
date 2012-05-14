package opGet.viaTransferUseReceiver;

import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestUnique {
  @Unique
  private Object u;
  
  private Object other;
  
  @Unique("this")
  public void testOpGet(TestUnique x) {
    x.u = this;
    Object t = x.u; // makes receiver undefined
    x.other = this;
  }
}
