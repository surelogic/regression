package opLoad.viaTransferUseField.outerReceiver;

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
  
  
  
  @Unique("this")
  public void compromiseUnique(final Test other) {
  	other.u = this;
  	
  	new Object() {
  		public Object m() {
  			return Test.this; // Cause the outer receiver to be shared
  		}
  	};
  	
  	Object o = other.u; // COMPROMISED READ
  }

  public void compromiseBorrowed() {
  	// Borrowed fields cannot be assigned to (they are final)
  }
}
