package opLoad.viaTransferUseField.sharedField;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  @Unique
  public Object u;
  
  @Borrowed
  public final Object b;
  
  // Shared
  public Object s;
  
  
  
  @RegionEffects("writes p:Instance")
  public Test(@Borrowed(allowReturn=true) final Object p) {
  	b = p;
  }
  
  
  
  public void compromiseUnique() {
  	this.s = this.u; // compromise u
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed() {
  	this.s = this.b; // compromise u
  	Object o = this.b; // COMPROMISED READ
  }
}
