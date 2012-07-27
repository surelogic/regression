package opLoad.viaTransferUseField.varargs;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  @Unique
  public Object u;
  
  @Borrowed
  public final Object b;

  
  
  @RegionEffects("writes p:Instance")
  public Test(@Borrowed(allowReturn=true) final Object p) {
  	b = p;
  }
  
  
  
  @RegionEffects("none")
  private static void compromiseRef(Object... varargs) {}
  
  
  public void compromiseUnique() {
  	compromiseRef(null, this.u, null); // compromise u
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed() {
  	compromiseRef(null, this.b, null); // compromise u
  	Object o = this.b; // COMPROMISED READ
  }
}
