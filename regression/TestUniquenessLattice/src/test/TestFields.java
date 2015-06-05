package test;

import com.surelogic.Immutable;
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
	@Immutable
	private final Object f005 = null;
	
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
	@Immutable
	@Unique
	private final Object f046 = null;
	
	@Immutable
	@UniqueInRegion("Instance")
	private final Object f048 = null;
	
	@Immutable
	@UniqueInRegion("Instance into Instance")
	private final Object f050 = null;
	
	
	@Unique
	@UniqueInRegion("Instance")
	private final Object f052 = null;
	
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f054 = null;
	

	// Three annotations
	// ----------------------------------------------------------------------
	@Immutable
	@Unique
	@UniqueInRegion("Instance")
	private final Object f149 = null;
	
	@Immutable
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f151 = null;
}
