package opLoad.viaTransferUseField.thrown;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  @Unique
  public RuntimeException u;
  
  @Borrowed
  public final RuntimeException b;
  
  
  
  @RegionEffects("writes p:Instance")
  public Test(@Borrowed(allowReturn=true) final RuntimeException p) {
  	b = p;
  }
  
  
  
  public void compromiseUnique() {
  	try {
  		throw this.u;
  	} finally {
    	Object o = this.u; // COMPROMISED READ
  	}
  }
  
  public void compromiseBorrowed() {
  	try {
  		throw this.b;
  	} finally {
    	Object o = this.b; // COMPROMISED READ
  	}
  }
}
