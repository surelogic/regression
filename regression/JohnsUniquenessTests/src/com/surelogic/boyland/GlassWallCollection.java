package com.surelogic.boyland;

import com.surelogic.Borrowed;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class GlassWallCollection {
	@Unique(allowRead=true) String[] contents;

	@Borrowed("this")
	@RegionEffects("none")
	public GlassWallCollection() {
		contents = new String[]{"hickory","dickery","dock"};
	}
	
	@Borrowed("this")
	@RegionEffects("reads this:Instance")
	public String get(int i) {
		return contents[i];
	}
	
	@Borrowed("this")
	@RegionEffects("writes this:Instance; reads java.lang.Object:All")
	public void set(int i, String s) {
		contents[i] = s;
	}
	
	@ReadOnly("return")
	@Borrowed("this")
	@RegionEffects("reads this:Instance")
	public String[] toArray() {
		return contents;
	}
	
	// NB: We can't write a "remove" method for an iterator,
	// because the effects would include "reads Object:All".
}
