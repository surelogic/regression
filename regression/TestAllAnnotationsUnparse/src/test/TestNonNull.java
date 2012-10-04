package test;

import com.surelogic.NonNull;

public class TestNonNull {
	@NonNull
	final Object field = null;
	
	@NonNull("return")
	void foo(@NonNull Object f) {
		
	}
}
