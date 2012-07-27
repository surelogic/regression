package opLoad.viaTransferUseQualifiedReceiver.varargs;

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
    
    @RegionEffects("none")
    private void compromiseRef(final Object... varargs) {}
    
    public void compromiseBorrowed() {
    	compromiseRef(null, Test.this, null);
    	Object o = Test.this; // COMPROMISED READ
    }
  }
}
