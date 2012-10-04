package test;

import com.surelogic.*;

@Region("Stuff")
@RegionLock("L is this protects Stuff")
@PolicyLock("P is p")
public class TestLockStuff {
	final Object p = null;
	
	@UniqueInRegion("Stuff")
	Object q;
	
	@UniqueInRegion("Instance into Stuff")
	final Object r = new Object();
	
	@RequiresLock("L,P")
	void test() {
		
	}
	
	@ReturnsLock("L")
	Object getLock() {
		return this;
	}
}
