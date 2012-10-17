package toString;

import com.surelogic.RegionEffects;

public enum Test {
	A, B, C;
	
	// BAD: java.lang.Enum clamps to the effects to "reads this:Instance"
	@RegionEffects("reads any(java.lang.Object):Instance")
	public String toString() {
		return super.toString();
	}
	
	
	enum Inner {
		X,
		
		Y {
			// GOOD: narrows the effects
			@RegionEffects("none")
			public String toString() {
				return "X";
			}
		},
		
		
		Z {
			// BAD: java.lang.Enum clamps to the effects to "reads this:Instance"
			@RegionEffects("writes All") 
			public String toString() {
				return super.toString();
			}
		};
	}
}
