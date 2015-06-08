package test;

import com.surelogic.Borrowed;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestParam {
	// No annotations
	// ----------------------------------------------------------------------
	private void m006(Object o) { /* empty */ }

	
	
	// One annotation
	// ----------------------------------------------------------------------
	private void m001(@Borrowed Object o) { /* empty */ }
	
	private void m007(@Unique Object o) { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	private void m017(@Borrowed @Unique Object o) { /* empty */ }
}
