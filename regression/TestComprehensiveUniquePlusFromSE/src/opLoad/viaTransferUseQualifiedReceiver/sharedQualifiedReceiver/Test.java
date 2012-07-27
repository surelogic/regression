package opLoad.viaTransferUseQualifiedReceiver.sharedQualifiedReceiver;

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
    	Test.this. new Other();
    	Object o = Test.this; // COMPROMISED READ
    }
  }
    
    
  public class Other {
		@RegionEffects("writes Test.this:Instance")
		@Unique("return")
		public Other() {
			super();
		}
  }
}
