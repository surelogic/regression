package opLoad.viaTransferUseQualifiedReceiver.sharedField;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  protected int f = 1;
  
  @Borrowed("Test.this")
  public class Inner {
    private Object s;
    
    @Borrowed(value="Test.this", allowReturn=true)
    @RegionEffects("writes Test.this:Instance")
    public Inner() {
      super();
    }
    
    public void compromiseBorrowed() {
    	s = Test.this;
    	Object o = Test.this; // COMPROMISED READ
    }
  }
}
