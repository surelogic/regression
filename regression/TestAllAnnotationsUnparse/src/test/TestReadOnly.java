package test;

import com.surelogic.ReadOnly;

public class TestReadOnly {
	@ReadOnly
	Object field;
	
	@ReadOnly("return")
	TestReadOnly() {
	}
	
	@ReadOnly("return, this")
	Object foo(@ReadOnly Object f) {
		return null;
	}

	/*
	@ReadOnly
	Object bar() {
		return null;
	}
	*/	
}
