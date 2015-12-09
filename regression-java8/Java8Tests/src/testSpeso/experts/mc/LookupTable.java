package testSpeso.experts.mc;

import java.util.*;
import java.util.function.Function;

public class LookupTable<V, A, B, C> {
	public LookupTable(Collection<V> items,
			Function<V, Iterable<A>> firstLookup,
			Function<V, Iterable<B>> secondLookup,
			Function<V, Iterable<C>> thirdLookup) {
		
	}
}
