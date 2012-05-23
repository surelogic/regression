package opLoad.viaTransferUseField;

import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class TestUnique {
  @Unique
  public Object u;

  public Object s;
  
  public void compromiseUnique1() {
    this.s = this.u; // compromise u
    Object o = this.u;
  }
  
  @RegionEffects("none")
  public void compromiseRef(final Object o) {
    // do stuff
  }
  
  public void compromiseUnique2() {
    compromiseRef(this.u);
    Object o = this.u;
  }
}
