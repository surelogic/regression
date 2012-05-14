package opGet.viaTransferUseVar;

import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestUnique {
  @Unique
  private Object u;
  
  private Object other;
  
  public void testOpGet() {
    Object t1 = this.u;
    Object t2 = this.u; // kills t1
    this.other = 
        t1; // undefined variable
  }
}
