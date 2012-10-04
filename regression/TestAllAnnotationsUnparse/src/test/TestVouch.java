package test;

import com.surelogic.Vouch;

@Vouch("Just testing on a type")
public class TestVouch {
	@Vouch("Immutable")
	Object f;
	
	@Vouch("ThreadSafe")
	Object f2;
	
	@Vouch("Just testing on a constructor")
	TestVouch() {
		
	}
	
	@Vouch("Just testing on a method")
	void foo() {
		
	}
}
