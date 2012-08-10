package com.surelogic;

import com.surelogic.RegionEffects;

public class ClientCode {
	
	@RegionEffects("writes CounterUtility:CounterState")
	public static void main(String[] args) {
		long counter = CounterUtility.incrementAndGet();
	}

}
