package test;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class AS {
	// Uniqueness does not assure because the field is possible compromised
	// by a bad method call.  Point is that the @Borrowed annotations on any
	// methods that the unique field is passed to should be linked to the 
	// @Unique annotation
	@Unique
  protected final AL al;

  public AS() {
  	al = new AL();
  }

  @Borrowed("this")
  @RegionEffects("reads Instance")
  public int size() {
  	// This call is indirectly bad because the @Borrowed annotation
  	// on AL.size() does not assure
  	return al.size();
  }
}
