package test;

import com.surelogic.*;

public class TestRegionEffects {
	@RegionEffects("reads nothing")
	void nothing() {
		
	}
	@RegionEffects("writes nothing")
	void writes() {
		
	}
	
	@RegionEffects("writes Instance, java.lang.Object:Static")
	void writesMore() {
		
	}
}
