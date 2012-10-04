package test;

import com.surelogic.Borrowed;

public class TestBorrowed {
	@Borrowed
	final Object field = null;
	
	@Borrowed("this")
	TestBorrowed() {
	}
	
	/*
	@Borrowed("return")
	Object bar() {
		return null;
	}
	*/
	
	@Borrowed("this")
	void foo(@Borrowed Object f) {
		
	}
}
