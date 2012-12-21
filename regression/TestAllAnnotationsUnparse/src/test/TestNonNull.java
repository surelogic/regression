package test;

import com.surelogic.NonNull;

public class TestNonNull {
	@NonNull
	final Object field = null;
	
	@NonNull("return")
	Object foo(@NonNull Object f) {
		return new Object();
	}
}
