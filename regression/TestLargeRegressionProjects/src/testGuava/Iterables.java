package testGuava;

import java.util.Collection;
import java.util.Iterator;

public class Iterables {
	public static <T> boolean addAll(
			Collection<T> addTo, Iterable<? extends T> elementsToAdd) {
		return false;
	}

	public static <T> Iterable<T> concat(
			final Iterable<? extends Iterable<? extends T>> inputs) {
		//checkNotNull(inputs);
		return new IterableWithToString<T>() {
			@Override
			public Iterator<T> iterator() {
				// Iterator<? extends Iterator<? extends T>>
				return Iterators.concat(iterators(inputs));
			}
		};
	}	

	/**
	 * Returns an iterator over the iterators of the given iterables.
	 */
	private static <T> UnmodifiableIterator<Iterator<? extends T>> iterators(
	      Iterable<? extends Iterable<? extends T>> iterables) {
		return null;
	}
		
	abstract static class IterableWithToString<E> implements Iterable<E> {
		@Override public String toString() {
			return null;//Iterables.toString(this);
		}
	}	
}
