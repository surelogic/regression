package test;

import com.surelogic.Unique;

public class TestUnique {
	@Unique
	Object field;
	
	@Unique("return")
	TestUnique() {
	}
	
	@Unique("return")
	Object foo(@Unique Object f) {
		return null;
	}
	/*
	@Unique
	Object bar() {
		return null;
	}	
	*/
}
