package test;

import com.surelogic.Borrowed;
import com.surelogic.BorrowedInRegion;
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
	@Borrowed
	private final Object f001 = null;
	
	// LEGAL
	@BorrowedInRegion("Instance")
	private final Object f002 = null;

	// LEGAL
	@BorrowedInRegion("Instance into Instance")
	private final Object f003 = null;
	
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
	@Borrowed
	@BorrowedInRegion("Instance")
	private final Object f013 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance into Instance")
	private final Object f014 = null;
	
	@Borrowed
	@Immutable
	private final Object f016 = null;
	
	@Borrowed
	@Unique
	private final Object f017 = null;
	
	@Borrowed
	@UniqueInRegion("Instance")
	private final Object f019 = null;
	
	@Borrowed
	@UniqueInRegion("Instance into Instance")
	private final Object f021 = null;
	
	

	@BorrowedInRegion("Instance")
	@Immutable
	private final Object f024 = null;
	
	@BorrowedInRegion("Instance")
	@Unique
	private final Object f025 = null;
	
	@BorrowedInRegion("Instance")
	@UniqueInRegion("Instance")
	private final Object f027 = null;
	
	@BorrowedInRegion("Instance")
	@UniqueInRegion("Instance into Instance")
	private final Object f029 = null;
	
	

	@BorrowedInRegion("Instance into Instance")
	@Immutable
	private final Object f032 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@Unique
	private final Object f033 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@UniqueInRegion("Instance")
	private final Object f035 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@UniqueInRegion("Instance into Instance")
	private final Object f037 = null;
	
		
	
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
	@Borrowed
	@BorrowedInRegion("Instance")
	@Immutable
	private final Object f057 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance")
	@Unique
	private final Object f058 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance")
	@UniqueInRegion("Instance")
	private final Object f060 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance")
	@UniqueInRegion("Instance into Instance")
	private final Object f062 = null;


	@Borrowed
	@BorrowedInRegion("Instance into Instance")
	@Immutable
	private final Object f065 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance into Instance")
	@Unique
	private final Object f066 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance into Instance")
	@UniqueInRegion("Instance")
	private final Object f068 = null;
	
	@Borrowed
	@BorrowedInRegion("Instance into Instance")
	@UniqueInRegion("Instance into Instance")
	private final Object f070 = null;


	@Borrowed
	@Immutable
	@Unique
	private final Object f079 = null;
	
	@Borrowed
	@Immutable
	@UniqueInRegion("Instance")
	private final Object f081 = null;
	
	@Borrowed
	@Immutable
	@UniqueInRegion("Instance into Instance")
	private final Object f083 = null;


	@Borrowed
	@Unique
	@UniqueInRegion("Instance")
	private final Object f085 = null;
	
	@Borrowed
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f087 = null;
	

	@BorrowedInRegion("Instance")
	@Immutable
	@Unique
	private final Object f100 = null;
	
	@BorrowedInRegion("Instance")
	@Immutable
	@UniqueInRegion("Instance")
	private final Object f102 = null;
	
	@BorrowedInRegion("Instance")
	@Immutable
	@UniqueInRegion("Instance into Instance")
	private final Object f104 = null;
	
	
	@BorrowedInRegion("Instance")
	@Unique
	@UniqueInRegion("Instance")
	private final Object f106 = null;
	
	@BorrowedInRegion("Instance")
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f108 = null;
	
	
	@BorrowedInRegion("Instance into Instance")
	@Immutable
	@Unique
	private final Object f121 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@Immutable
	@UniqueInRegion("Instance")
	private final Object f123 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@Immutable
	@UniqueInRegion("Instance into Instance")
	private final Object f125 = null;
	
	
	@BorrowedInRegion("Instance into Instance")
	@Unique
	@UniqueInRegion("Instance")
	private final Object f127 = null;
	
	@BorrowedInRegion("Instance into Instance")
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f129 = null;
	
	
	@Immutable
	@Unique
	@UniqueInRegion("Instance")
	private final Object f149 = null;
	
	@Immutable
	@Unique
	@UniqueInRegion("Instance into Instance")
	private final Object f151 = null;
}
