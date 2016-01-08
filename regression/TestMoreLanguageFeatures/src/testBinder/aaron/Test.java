package testBinder.aaron;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;


/*
 * Warn for e.f'.f when
 * (1) e.f' is not unique
 * (2) f is not final or volatile or lock-protected
 * (3) e.f' is final or volatile in a lock-protected class, or is lock-protected
 */

@Region("public PROTECTED")
@RegionLock("L is this protects PROTECTED")
public class Test {
	// === final/volatile fields in class with lock annotations
	private final Foo finalNotUnique = null;
	private final @Unique Foo finalUnique = null;
	private volatile Foo volatileNotUnique;
	private volatile @Unique Foo volatileUnique;
	
	// === field protected by a lock
	@InRegion("PROTECTED")
	private Foo protectedNotUnique;
	@UniqueInRegion("PROTECTED")
	private Foo protectedUnique;
	
	// === field not protected by a lock
	private Foo notProtectedNotUnique;
	private @Unique Foo notProtectedUnique;
	
	// **** arrays (later)
		
	public int doStuff() {
		return
				this.finalNotUnique.unprotectedF + // WARNING
				this.finalNotUnique.protectedF +   // no warning
				this.finalNotUnique.finalF +       // no warning
				this.finalNotUnique.volatileF +    // no warning
				
				// no warnings here (uniqueness)
				this.finalUnique.unprotectedF +
				this.finalUnique.protectedF +           
				this.finalUnique.finalF +              
				this.finalUnique.volatileF +           

				this.volatileNotUnique.unprotectedF +  // WARNING  
				this.volatileNotUnique.protectedF +    // no warning
				this.volatileNotUnique.finalF +        // no warning
				this.volatileNotUnique.volatileF +     // no warning

				// no warnings here (uniqueness)
				this.volatileUnique.unprotectedF +
				this.volatileUnique.protectedF +
				this.volatileUnique.finalF +
				this.volatileUnique.volatileF +
				
				this.protectedNotUnique.unprotectedF + // WARNING
				this.protectedNotUnique.protectedF +   // no warning
				this.protectedNotUnique.finalF +       // no warning
				this.protectedNotUnique.volatileF +    // no warning
				
				this.protectedUnique.unprotectedF + // no warning
				this.protectedUnique.protectedF +   // no warning
				this.protectedUnique.finalF +       // no warning
				this.protectedUnique.volatileF +    // no warning
				
				this.notProtectedNotUnique.unprotectedF + // no warning
				this.notProtectedNotUnique.protectedF +   // no warning
				this.notProtectedNotUnique.finalF +       // no warning
				this.notProtectedNotUnique.volatileF +    // no warning
				
				this.notProtectedUnique.unprotectedF + // no warning
				this.notProtectedUnique.protectedF +   // no warning
				this.notProtectedUnique.finalF +       // no warning
				this.notProtectedUnique.volatileF      // no warning
				;
	}
}

class Test2 {
	// final/volatile fields in class with out lock annotations
	private final Foo finalNotUnique = null;
	private final @Unique Foo finalUnique = null;
	private volatile Foo volatileNotUnique;
	private volatile @Unique Foo volatileUnique;
	
	public int doStuff() {
		// None of these should have warnings because Test2 doesn't have any lock annotations
		return
				this.finalNotUnique.unprotectedF +
				this.finalNotUnique.protectedF +
				this.finalNotUnique.finalF +
				this.finalNotUnique.volatileF +
				
				this.finalUnique.unprotectedF +
				this.finalUnique.protectedF +
				this.finalUnique.finalF +
				this.finalUnique.volatileF +

				this.volatileNotUnique.unprotectedF +
				this.volatileNotUnique.protectedF +
				this.volatileNotUnique.finalF +
				this.volatileNotUnique.volatileF +

				this.volatileUnique.unprotectedF +
				this.volatileUnique.protectedF +
				this.volatileUnique.finalF +
				this.volatileUnique.volatileF;
	}
}


@RegionLock("FooLock is this protects protectedF")
class Foo {
	public int unprotectedF;
	public int protectedF;
	public final int finalF = 1;
	public volatile int volatileF;
}


