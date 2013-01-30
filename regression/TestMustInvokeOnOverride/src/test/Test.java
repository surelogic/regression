package test;

import com.surelogic.*;

public class Test {
	@MustInvokeOnOverride
	void foo() {}
}

class NeedsAnnoAndSuperCall extends Test {
	// bad x2
	void foo() {}
}
 
class AnnotatedAndInvokesSuper extends Test {
	// good
	@MustInvokeOnOverride
	void foo() {
		super.foo();
	}
}

class OnlyInvokesSuper extends Test {
	// missing anno
	void foo() {
		super.foo();
	}
}

class OnlyAnnotatedButDoesntInvokeSuper extends Test {
	@MustInvokeOnOverride
	void foo() {
		// bad
	}
}

final class FinalClassDoesntCallSuper extends Test {
	@MustInvokeOnOverride // shouldn't be annotated
	void foo() {
		// bad
	}			
}

class FinalMethodCallsSuper extends Test {
	final void foo() {
		super.foo();
	}
}