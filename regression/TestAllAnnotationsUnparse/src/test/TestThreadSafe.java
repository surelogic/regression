package test;

import com.surelogic.ThreadSafe;

public class TestThreadSafe {
	@ThreadSafe
	class Inner {
		
	}

	@ThreadSafe(implementationOnly=true, verify=false)
	class Inner2 {
		
	}
}
