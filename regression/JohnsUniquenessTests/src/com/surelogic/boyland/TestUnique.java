package com.surelogic.boyland;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

// @Vouch("testing")
public class TestUnique {

	@Unique("return")
	@RegionEffects("none") public TestUnique(){}

	@Unique
	private TestUnique next;
	
	@Unique
	private TestUnique next2;
	
	private Object shared;
	
	@RegionEffects("writes this:Instance")
	@Borrowed("this")
	@Unique("return")
	public TestUnique swapOut(@Unique TestUnique tail) {
		TestUnique x = this.next;
		if (something() < 0) {
			next = tail;
		} else {
			next = null;
		}
		return x;
	}
	
	/*@RegionEffects("writes this:Instance")
	@Borrowed("this")
	@Unique("return")
	public TestUnique swapOutBad(@Unique TestUnique tail) {
		TestUnique x = this.next;
		if (something() < 0) {
			next = tail;
		}
		// x may alias this.next
		return x;
		// because of the way uniqueness is tested,
		// after an error, the lattice is poisoned:
		// ALL uniqueness-related annotations (Borrowed/Unique) go bad.
	}*/
	
	@RegionEffects("none")
	@Borrowed("this")
	private int something() {
		return 3;
	}
	
	public String weirdCatch() {
		String s = toString();
		try {
			something();
		} catch (ClassCastException e) {
			s += e.toString();
		}
		try {
			something();
		} catch (NullPointerException ex) {
			Object o = ex;
			next = null; // (TestUnique)o;
			s += o.hashCode();
		}
		return s;
	}
	
	@RegionEffects("writes this:Instance")
	@Borrowed("this")
	public void testChain() {
		TestUnique n1 = next;
		TestUnique n2 = n1.next;
		TestUnique n3 = n2.next;
		TestUnique n2a = n1.next2;
		n2 = null; // lose connection to n3
		// Now n1 -*-> n3 and n1.next2 -> n2a
		TestUnique n2aa = n2a.next2;
		n2a.next2 = null;
		n2a.next = n2aa;
		n3.next = new TestUnique();
	}
	
	@RegionEffects("writes this:Instance")
	@Borrowed("this")
	public void testNewStore(@Unique TestUnique x) {
		next = x;
		// next2 = x;  // illegal to alias two fields together
		x.next = null;
	}
	
	@RegionEffects("writes this:Instance")
	@Borrowed("this")
	public void testNewStore2(@Unique TestUnique x) {
		String s;
		if (shared == null) {
			next = x;
		} else { 
			next2 = x; 
		}
		// NB: In store, it looks like next and next2 are aliases, but this is OK.
		s = "Unique 42";
		x.next = null;
		shared = s;
	}
}
