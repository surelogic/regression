package testGuava;

import java.util.*;

public class SortedMultisets {
	static abstract class DescendingMultiset<E> /*extends ForwardingMultiset<E>*/
	implements SortedMultiset<E> {
		abstract SortedMultiset<E> forwardMultiset();

		private transient Comparator<? super E> comparator;

		@Override public Comparator<? super E> comparator() {
			Comparator<? super E> result = comparator;
			if (result == null) {
				return comparator =
						Ordering.from(forwardMultiset().comparator()).<E>reverse();
			}
			return result;
		}
	}
}