package test;

import com.surelogic.Borrowed;
import com.surelogic.BorrowedInRegion;
import com.surelogic.Immutable;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestReturn {
	// No annotations
	// ----------------------------------------------------------------------
	private Object m006() { return null; }

	
	
	// One annotation
	// ----------------------------------------------------------------------
	@Immutable("return")
	private Object m005() { return null; }
	
	@Unique("return")
	private Object m007() { return null; }
	
	@Unique(value="this", allowRead=true)
	private Object m008() { return null; }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Immutable("return")
	@Unique("return")
	private Object m046() { return null; }
	
	@Immutable("return")
	@Unique(value="this", allowRead=true)
	private Object m047() { return null; }
}
