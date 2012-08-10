package com.surelogic;

import java.util.List;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionEffects;
import com.surelogic.Utility;

@Utility
@Region("static public CounterState")
public class CounterUtility {

	@InRegion("CounterState")
	private static long count = 0;

	@RegionEffects("writes CounterState")
	public static long incrementAndGet() {
		return ++count;
	}

	@RegionEffects("reads CounterState")
	public static long get() {
		return count;
	}

	@RegionEffects("writes list:Instance")
	public static void eraseList(List<?> list) {
		list.clear();
	}
	
	@RegionEffects("writes arg0:Instance")
	public static void eraseList2(List<?> list) {
		list.clear();
	}

	private CounterUtility() {
		// no instances
	}
}
