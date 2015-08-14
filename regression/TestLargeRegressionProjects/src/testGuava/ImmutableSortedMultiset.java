package testGuava;

import java.util.*;
import static testGuava.Preconditions.checkNotNull;

abstract class ImmutableSortedMultiset<E> /*extends ImmutableSortedMultisetFauxverideShim<E>*/
implements SortedMultiset<E> {
	private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
	
	public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E element) {
		return RegularImmutableSortedMultiset.createFromSorted(
				NATURAL_ORDER, ImmutableList.of(Multisets.immutableEntry(checkNotNull(element), 1)));
	}
}
