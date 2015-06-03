package test;

import com.surelogic.Borrowed;
import com.surelogic.BorrowedInRegion;
import com.surelogic.Immutable;
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
	
	private void m005(@Immutable Object o) { /* empty */ }
	
	private void m007(@Unique Object o) { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	private void m016(@Borrowed @Immutable Object o) { /* empty */ }
	
	private void m017(@Borrowed @Unique Object o) { /* empty */ }
		

	private void m046(@Immutable @Unique Object o) { /* empty */ }



	// Three annotations
	// ----------------------------------------------------------------------
	private void m079(@Borrowed @Immutable @Unique Object o) { /* empty */ }
}
