package nested.anonymous;

import com.surelogic.RegionEffects;

@SuppressWarnings("unused")
public class OneCopy {
  public void method() {
  	// Class does not have a Static region of it's own: cannot have static fields
    new Object() {
      @RegionEffects("writes Static")
    	public void m() {
      	// empty    		
    	}
    };
  }
}
