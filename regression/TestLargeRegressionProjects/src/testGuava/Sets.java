package testGuava;

import java.util.*;

public class Sets {
	public static <B> Set<List<B>> cartesianProduct(
			Set<? extends B>... sets) {
		return cartesianProduct(Arrays.asList(sets));
	}
	
	public static <B> Set<List<B>> cartesianProduct(
			List<? extends Set<? extends B>> sets) {
		return null;
	}
}
