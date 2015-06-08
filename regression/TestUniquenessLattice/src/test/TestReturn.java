package test;

import com.surelogic.Borrowed;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestReturn {
	// No annotations
	// ----------------------------------------------------------------------
	private Object m006() { return null; }

	
	
	// One annotation
	// ----------------------------------------------------------------------
	@Unique("return")
	private Object m007() { return null; }
}
