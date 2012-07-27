package opLoad.viaTransferUseQualifiedReceiver.sharedReceiver;

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
    	Test.this. doStuff();
    	Object o = Test.this; // COMPROMISED READ
    }
  }
  
  
  // Shared Receiver
  @RegionEffects("none")
  public void doStuff() {}
}
