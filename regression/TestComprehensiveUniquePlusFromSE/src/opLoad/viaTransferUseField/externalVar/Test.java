package opLoad.viaTransferUseField.externalVar;

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
  
  
  
  public void compromiseUnique() {
  	final Object v = this.u;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};
  	
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed() {
  	final Object v = this.b;
  	new Object() {
  		public Object m() {
  			return v; // Using v in the local class compromises the reference in v
  		}
  	};
  	
  	Object o = this.b; // COMPROMISED READ
  }
}
