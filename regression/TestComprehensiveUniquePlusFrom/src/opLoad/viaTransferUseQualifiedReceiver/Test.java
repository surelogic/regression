package opLoad.viaTransferUseQualifiedReceiver;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;

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
    
    public void compromiseBorrowed1() {
      this.s = Test.this;
      Object o = Test.this;
    }
    
    @RegionEffects("none")
    public void compromiseRef(final Object o) {
      // do stuff
    }
    
    public void compromiseBorrowed2() {
      compromiseRef(Test.this);
      Object o = Test.this;
    }
  }
}
