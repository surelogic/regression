package opLoad.viaTransferUseField.arrayElement;

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
  
  
  
  public void compromiseUnique(final Object[] array) {
  	array[0] = this.u; // compromise u
  	Object o = this.u; // COMPROMISED READ
  }
  
  public void compromiseBorrowed(final Object[] array) {
  	array[0] = this.b; // compromise u
  	Object o = this.b; // COMPROMISED READ
  }
}
