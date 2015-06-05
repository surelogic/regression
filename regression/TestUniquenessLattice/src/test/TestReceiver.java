package test;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
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
	
	@Immutable("this")
	private void m005() { /* empty */ }
	
	@Unique("this")
	private void m007() { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Immutable("this")
	private void m016() { /* empty */ }
	
	@Borrowed("this")
	@Unique("this")
	private void m017() { /* empty */ }
	
	@Immutable("this")
	@Unique("this")
	private void m046() { /* empty */ }



	// Three annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Immutable("this")
	@Unique("this")
	private void m079() { /* empty */ }
}
