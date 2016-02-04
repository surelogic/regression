package test;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;


/*
 * Warn for e.f'.f when
 * (1) e.f' is not unique
 * (2) f is not final or volatile or lock-protected
 * (3) e.f' is final or volatile in a lock-protected class, or is lock-protected
 * 
 * Warn for e.f'[..] when
 * (1) e.f' is not unique
 * (3) e.f' is final or volatile in a lock-protected class, or is lock-protected
 */

@Regions({
	@Region("public PROTECTED"),
	@Region("public OTHER")
})
@RegionLocks({
	@RegionLock("L is this protects PROTECTED"),
	@RegionLock("LL is this protects OTHER")
})
public class Test {
	// === final/volatile fields in class with lock annotations
	private final Foo finalNotUnique = null;
	private final @Unique Foo finalUnique = null;
	private volatile Foo volatileNotUnique;
	// volatile and @Unique cannot be used together
	
	private final int[] finalNotUniqueArray = null;
	private final @Unique int[] finalUniqueArray = null;
	private volatile int[] volatileNotUniqueArray;
	// volatile and @Unique cannot be used together
	
	
	// === field protected by a lock
	@InRegion("PROTECTED")
	private Foo protectedNotUnique;
	@UniqueInRegion("PROTECTED")
	private Foo protectedUnique;
	
	@InRegion("PROTECTED")
	private int[] protectedNotUniqueArray;
	@UniqueInRegion("PROTECTED")
	private int[] protectedUniqueArray;
	
	
	// === field not protected by a lock
	private Foo notProtectedNotUnique;
	private @Unique Foo notProtectedUnique;
	
	private int[] notProtectedNotUniqueArray;
	private @Unique int[] notProtectedUniqueArray;
	
	
		
	public void doStuff() {
		@SuppressWarnings("unused")
		int x;
		
		x = this.finalNotUnique.unprotectedF; // WARNING on PROTECTED and OTHER
		x = this.finalNotUnique.protectedF;   // no warning
		x = this.finalNotUnique.finalF;       // no warning
		x = this.finalNotUnique.volatileF;    // no warning
				
		x = this.finalUnique.unprotectedF;  // no warning
		x = this.finalUnique.protectedF;    // no warning 
		x = this.finalUnique.finalF;        // no warning
		x = this.finalUnique.volatileF;     // no warning

		x = this.volatileNotUnique.unprotectedF;  // WARNING on PROTECTED and OTHER
		x = this.volatileNotUnique.protectedF;    // no warning
		x = this.volatileNotUnique.finalF;        // no warning
		x = this.volatileNotUnique.volatileF;     // no warning

		x = this.finalNotUniqueArray[0];     // WARNING on PROTECTED and OTHER
		x = this.finalUniqueArray[0];        // no warning
		x = this.volatileNotUniqueArray[0];  // WARNING on PROTECTED and OTHER
		
		x = this.protectedNotUnique.unprotectedF; // WARNING on PROTECTED only
		x = this.protectedNotUnique.protectedF;   // no warning
		x = this.protectedNotUnique.finalF;       // no warning
		x = this.protectedNotUnique.volatileF;    // no warning
				
		x = this.protectedUnique.unprotectedF; // no warning
		x = this.protectedUnique.protectedF;   // no warning
		x = this.protectedUnique.finalF;       // no warning
		x = this.protectedUnique.volatileF;    // no warning
		
		x = this.protectedNotUniqueArray[0];   // WARNING on PROTECTED only
		x = this.protectedUniqueArray[0];      // no warning
		
		x = this.notProtectedNotUnique.unprotectedF; // no warning
		x = this.notProtectedNotUnique.protectedF;   // no warning
		x = this.notProtectedNotUnique.finalF;       // no warning
		x = this.notProtectedNotUnique.volatileF;    // no warning
				
		x = this.notProtectedUnique.unprotectedF; // no warning
		x = this.notProtectedUnique.protectedF;   // no warning
		x = this.notProtectedUnique.finalF;       // no warning
		x = this.notProtectedUnique.volatileF;    // no warning
		
		x = this.notProtectedNotUniqueArray[0];  // no warning
		x = this.notProtectedUniqueArray[0];     // no warning
	}
}

class Test2 {
	// final/volatile fields in class with out lock annotations
	private final Foo finalNotUnique = null;
	private final @Unique Foo finalUnique = null;
	private volatile Foo volatileNotUnique;
	// volatile and @Unique cannot be used together
	
	private final int[] finalNotUniqueArray = null;
	private final @Unique int[] finalUniqueArray = null;
	private volatile int[] volatileNotUniqueArray;
	// volatile and @Unique cannot be used together

	
	
	public void doStuff() {
		// None of these should have warnings because Test2 doesn't have any lock annotations
		@SuppressWarnings("unused")
    int x; 
		
		x = this.finalNotUnique.unprotectedF;
		x = this.finalNotUnique.protectedF;
		x = this.finalNotUnique.finalF;
		x = this.finalNotUnique.volatileF;
				
		x = this.finalUnique.unprotectedF;
		x = this.finalUnique.protectedF;
		x = this.finalUnique.finalF;
		x = this.finalUnique.volatileF;

		x = this.volatileNotUnique.unprotectedF;
		x = this.volatileNotUnique.protectedF;
		x = this.volatileNotUnique.finalF;
		x = this.volatileNotUnique.volatileF;

		
		
		x = this.finalNotUniqueArray[0];
		x = this.finalUniqueArray[0];   
		x = this.volatileNotUniqueArray[0];
	}
}


@RegionLock("FooLock is this protects protectedF")
class Foo {
	public int unprotectedF;
	public int protectedF;
	public final int finalF = 1;
	public volatile int volatileF;
}

