package opLoad.viaTransferUseQualifiedReceiver.sharedFormal;

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
    private void compromiseRef(final /*Shared*/ Object o) {}
    
    public void compromiseBorrowed() {
    	compromiseRef(Test.this);
    	Object o = Test.this; // COMPROMISED READ
    }
  }
}
