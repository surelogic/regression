package testGuava;

import static testGuava.Preconditions.checkNotNull;

import java.util.*;

public class SortedLists {
	public enum KeyPresentBehavior {
	}
	public enum KeyAbsentBehavior { 
	}
	
	public static <E> int binarySearch(List<? extends E> list, /*@Nullable*/ E key,
			Comparator<? super E> comparator, KeyPresentBehavior presentBehavior,
			KeyAbsentBehavior absentBehavior) {
		return 0;
	}

	public static <E, K extends Comparable> int binarySearch(List<E> list,
			Function<? super E, K> keyFunction, K key, KeyPresentBehavior presentBehavior,
			KeyAbsentBehavior absentBehavior) {
		return 0;
	}
	
	public static <E extends Comparable> int binarySearch(List<? extends E> list, E e,
			KeyPresentBehavior presentBehavior, KeyAbsentBehavior absentBehavior) {
		checkNotNull(e);
		return binarySearch(
				list, checkNotNull(e), Ordering.natural(), presentBehavior, absentBehavior);
	}
}
