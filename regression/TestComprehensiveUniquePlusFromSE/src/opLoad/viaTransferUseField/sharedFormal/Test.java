package opLoad.viaTransferUseField.sharedFormal;

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
  private static void compromiseRef(final /*SHARED*/ Object o) {}
  
  
  public void compromiseUnique() {
  	compromiseRef(this.u); // compromise u
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed() {
  	compromiseRef(this.b); // compromise u
  	Object o = this.b; // COMPROMISED READ
  }
}
