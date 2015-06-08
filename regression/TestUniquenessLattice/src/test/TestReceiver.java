package test;

import com.surelogic.Borrowed;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestReceiver {
	// No annotations
	// ----------------------------------------------------------------------
	private void m006() { /* empty */ }

	
	
	// One annotation
	// ----------------------------------------------------------------------
	@Borrowed("this")
	private void m001() { /* empty */ }
	
	@Unique("this")
	private void m007() { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Unique("this")
	private void m017() { /* empty */ }
}
