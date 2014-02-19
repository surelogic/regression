package test;

import com.surelogic.*;

//@Promise("@NonNull")
public class Test {
	int foo;
	Object bar;
	
	Test() {
		bar = new Object();
		nonnull = new Object();
	}
	
	int incr() {
		return 0;
	}
	
	Object baz(int i, Object o) {
		return "";
	}
	
	@Nullable Object nullable;
	
	/*
	@Initialized(through="*") Object raw(Object o) {
		return null;
	}
	*/
	@NonNull Object nonnull;
}
