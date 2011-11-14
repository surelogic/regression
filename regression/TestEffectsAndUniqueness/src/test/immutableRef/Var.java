package test.immutableRef;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class Var {
	public int val;
	
	@Unique("return")
	@RegionEffects("none")
	public Var() {
		super();
	}
	
	@RegionEffects("reads Instance")
	@Borrowed("this")
	public int get() {
		return val;
	}
	
	@RegionEffects("writes Instance")
	@Borrowed("this")
	public void set(final int v) {
		val = v;
	}
	
	
	
	// ======================================================================
	// == Test @Immutable receiver	
	// ======================================================================
	
	/* Driver for the U+F analysis needs to be updated.  Need @Borrowed parameter
	 * here to force the analysis to check this method.
	 */
	@RegionEffects("none")
	@Immutable("this")
	public void testReceiverRead(final @Borrowed Object o) {
		// Read effect on immutable should be discarded
		this.get();
	}
	
	/* Driver for the U+F analysis needs to be updated.  Need @Borrowed parameter
	 * here to force the analysis to check this method.
	 */
	@RegionEffects("none")
	@Immutable("this")
	public void testReceiverRead2(final @Borrowed Object o) {
		// Read effect on immutable should be discarded
		final int z = this.val;
	}
	
	/* Driver for the U+F analysis needs to be updated.  Need @Borrowed parameter
	 * here to force the analysis to check this method.
	 */
	@RegionEffects("none")
	@Immutable("this")
	public void testReceiverWrite(final int v, final @Borrowed Object o) {
		// CHECKED BY FLOW ANALYSIS: Write effect on immutable is illegal
		this.set(v);
	}
	
	/* Driver for the U+F analysis needs to be updated.  Need @Borrowed parameter
	 * here to force the analysis to check this method.
	 */
	@RegionEffects("none")
	@Immutable("this")
	public void testReceiverWrite2(final int v, final @Borrowed Object o) {
		// CHECKED BY FLOW ANALYSIS: Write effect on immutable is illegal
		this.val = v;
	}
}
