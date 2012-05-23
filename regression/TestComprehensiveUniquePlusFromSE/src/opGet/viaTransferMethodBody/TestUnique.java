package opGet.viaTransferMethodBody;

import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestUnique {
  @Unique
  private Object u;
   
  public Object testOpGet() {
    try {
      return this.u;
    } finally {
      Object t2 = this.u;
      this.u = null;
    }
  }
}
