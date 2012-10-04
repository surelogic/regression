package test;

import com.surelogic.Immutable;

public class TestImmutable {
	@Immutable
	Object f;
	
	@Immutable("return")
	TestImmutable() {
	}
	
	@Immutable("return, this")
	Object foo(@Immutable Object f) {
		return null;
	}
	
	@Immutable
	class Inner {
		
	}

	@Immutable(implementationOnly=true, verify=false)
	class Inner2 {
		
	}
}
