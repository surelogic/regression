package testGuava;

import java.util.Comparator;

public abstract class Ordering<T> implements Comparator<T> {
	public static <C extends Comparable> Ordering<C> natural() {
		return null;
	}
	
	public static <T> Ordering<T> from(Comparator<T> comparator) {
		/*
		return (comparator instanceof Ordering)
				? (Ordering<T>) comparator
						: new ComparatorOrdering<T>(comparator);
						*/
		return null;
	}

	/**
	 * Simply returns its argument.
	 *
	 * @deprecated no need to use this
	 */
	//@GwtCompatible(serializable = true)
	@Deprecated public static <T> Ordering<T> from(Ordering<T> ordering) {
		return null;
	}
	
	public <S extends T> Ordering<S> reverse() {
		return null;
	}
}
