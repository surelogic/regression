package test;

import com.surelogic.Containable;

public class TestContainable {
	@Containable
	class Inner {
		
	}

	@Containable(implementationOnly=true, verify=false)
	class Inner2 {
		
	}
}
