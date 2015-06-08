package test;

import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestFields {
	// No annotations
	// ----------------------------------------------------------------------
	// LEGAL
	private final Object f006 = null;

	
	
	// One annotation
	// ----------------------------------------------------------------------
	// LEGAL
	@Unique
	private final Object f007 = null;
	
	// LEGAL
	@UniqueInRegion("Instance")
	private final Object f009 = null;
	
	// LEGAL
	@UniqueInRegion("Instance into Instance")
	private final Object f011 = null;
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Unique
	@UniqueInRegion("Instance")
	private final Object f052 = null;
	
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f054 = null;
}
