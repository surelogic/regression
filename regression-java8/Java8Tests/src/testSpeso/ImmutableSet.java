package testSpeso;

import java.io.Serializable;
import java.util.*;

public abstract class ImmutableSet<T> extends AbstractCollection<T> implements Set<T>, Serializable {
	static <E> ImmutableSet<E> of() {
		return null;
	}
	static <E> ImmutableSet<E> of(E e1) {
		return null;
	}
	static <E> ImmutableSet<E> of(E e1, E e2) {
		return null;
	}
	static <E> ImmutableSet<E> of(E e1, E e2, E e3) {
		return null;
	}
	static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4) {
		return null;
	}
	
	static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5) {
		return null;
	}
	
	static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E... e) {
		return null;
	}
}
