package test;

import com.surelogic.*;

//@Promise("@NonNull")
@TrackPartiallyInitialized
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
	@Initialized(through="Object") Object raw(Object o) {
		return null;
	}
	*/
	@NonNull Object nonnull;
}
