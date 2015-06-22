package test;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class AL {
  protected transient Object[] array_;

  protected synchronized Object[] array() { return array_; }
  
  @Unique("return")
  public AL() {
  	super();
  }
  
  @RegionEffects("reads Instance")
  @Borrowed("this")
  public int size() {
  	// Bad call because array() might compromise the borrowed receiver.
  	// Makes the @Borrowed annotation a red X
    return this.array().length;
  }
}
