package test;

import com.surelogic.Nullable;

public class TestNullable {
	@Nullable
	final Object field = null;
	
	@Nullable("return")
	Object foo(@Nullable Object f) {
		return null;
	}
}
