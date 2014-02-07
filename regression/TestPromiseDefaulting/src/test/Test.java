package test;

import com.surelogic.*;

//@Promise("@NonNull")
public class Test {
	int foo;
	Object bar;
	
	Test() {
		
	}
	
	int incr() {
		return 0;
	}
	
	Object baz(int i, Object o) {
		return null;
	}
	
	@Nullable Object nullable;
	
	@Raw Object raw(Object o) {
		return null;
	}
	
	@NonNull Object nonnull;
}
