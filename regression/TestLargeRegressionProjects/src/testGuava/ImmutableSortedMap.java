package testGuava;

import java.util.*;

public class ImmutableSortedMap<K, V> extends TreeMap<K, V>
/*extends ImmutableSortedMapFauxverideShim<K, V>*/ implements SortedMap<K, V> {
	public static <K extends Comparable<? super K>, V>
	ImmutableSortedMap<K, V> of(K k1, V v1) {
		return new ImmutableSortedMap<K, V>(
				ImmutableList.of(entryOf(k1, v1)), Ordering.natural());
	}
	
	ImmutableSortedMap(
			ImmutableList<Entry<K, V>> entries, Comparator<? super K> comparator) {
	}
	
	static <K, V> Entry<K, V> entryOf(K key, V value) {
		return null;
	}
}
