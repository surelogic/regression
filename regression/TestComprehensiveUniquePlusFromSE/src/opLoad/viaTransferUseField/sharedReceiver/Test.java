package opLoad.viaTransferUseField.sharedReceiver;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  @Unique
  public Other u;
  
  @Borrowed
  public final Other b;

  
  
  @RegionEffects("writes p:Instance")
  public Test(@Borrowed(allowReturn=true) final Other p) {
  	b = p;
  }
  

  
  public void compromiseUnique() {
  	this.u. call();  // compromise u
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed() {
  	this.b. call();  // compromise u
  	Object o = this.b; // COMPROMISED READ
  }
}
