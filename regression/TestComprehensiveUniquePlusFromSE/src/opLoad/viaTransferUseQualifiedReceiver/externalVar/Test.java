package opLoad.viaTransferUseQualifiedReceiver.externalVar;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  protected int f = 1;
  
  @Borrowed("Test.this")
  public class Inner {
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance")
    public Inner() {
      super();
    }
    
    public void compromiseBorrowed() {
    	final Object v = Test.this;
    	new Object() {
    		public Object m() {
    			return v; // Using v in the local class compromises the reference in v 
    		}
    	};
    	Object o = Test.this; // COMPROMISED READ
    }
  }
}
