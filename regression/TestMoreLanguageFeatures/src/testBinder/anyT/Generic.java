package testBinder.anyT;

import com.surelogic.*;

public class Generic<T> {
	//@RegionEffects("writes any(T):Instance")
	void foo() {		
	}
	
	//@RegionEffects("writes any(E):Instance")
	<E> void bar() {		
	}
}
