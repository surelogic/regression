package test;

import com.surelogic.Nullable;

public class TestNullable {
	@Nullable
	final Object field = null;
	
	@Nullable("return")
	void foo(@Nullable Object f) {
		
	}
}
