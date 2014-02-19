package test;

import com.surelogic.NonNull;

public class TestNonNull {
	@NonNull
	final Object field = null;
	
	@NonNull
	Object foo(@NonNull Object f) {
		return new Object();
	}
}
