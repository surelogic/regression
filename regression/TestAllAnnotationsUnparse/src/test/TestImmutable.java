package test;

import com.surelogic.Immutable;

public class TestImmutable {
	
	@Immutable
	class Inner {
		
	}

	@Immutable(implementationOnly=true, verify=false)
	class Inner2 {
		
	}
}
